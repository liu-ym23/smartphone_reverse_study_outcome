package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e3 {
    public static final Map<String, String> b(t r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        if (r3 == null) goto L9;
        List<Integer> r1 = r3.g;
        if (r1 == null) goto L9;
        if (r1.contains(50) != true) goto L9;
        String r5 = "install";
    L16:
        Pair[] r2 = new Pair[2];
        boolean r6 = false;
        r2[0] = TuplesKt.to("participate_way", r5);
        IRoom r7 = r4.getRoom();
        Intrinsics.checkNotNullParameter(r7, "$this$isLifeRoom");
        IMainRoom r8 = (IMainRoom) r7.castToOrNull(IMainRoom.class);
        if (r8 == null) goto L21;
        IRoomSpecificSceneTypeInfo r9 = r8.getSceneTypeInfo();
        if (r9 == null) goto L21;
        Boolean r10 = Boolean.valueOf(r9.isLife());
    L22:
        if (r10 == null) goto L24;
        r6 = r10.booleanValue();
    L24:
        if (r6 == false) goto L26;
        String r12 = DataType.TRUE;
    L27:
        r2[1] = TuplesKt.to("is_life", r12);
        return MapsKt.mapOf(r2);
    L26:
        r12 = DataType.FALSE;
    L21:
        r10 = null;
    L9:
        if (r3 == null) goto L15;
        List<Integer> r13 = r3.g;
        if (r13 == null) goto L15;
        if (r13.contains(3) != true) goto L15;
        r5 = "comment";
    L15:
        r5 = "";
        goto L16
    }

    public static final void e(mz0.o r3, String r4) {
        if (r4 == null) goto L26;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r5 = new JSONObject(r4).optJSONObject("tracker_params");     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        Iterator<String> r1 = r5.keys();     // Catch: Throwable -> L15
    L7:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();     // Catch: Throwable -> L15
        Object r6 = r5.opt(r2);     // Catch: Throwable -> L15
        if (r6 == null) goto L7;
        r3.a(r2, r6.toString());     // Catch: Throwable -> L15
        goto L7
    L11:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L15
    L17:
        Result.box-impl(r8);
        return;
    L12:
        r7 = null;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static final long c(long r7, long r9, long r12, boolean r13) {
        if (r13 == false) goto L6;
        StringBuilder r14 = new StringBuilder("当前时间： ");
        r14.append(System.currentTimeMillis());
        r14.append("     serverDrawTime = ");
        r14.append(r9);
        r14.append("    serverCurrentTime = ");
        r14.append(r7);
        r14.append("  差值:  ");
        long r10 = r9 - r7;
        r14.append(r10);
        r14.append("  maxRandomDelayDurationByMs = ");
        r14.append(r12);
        ALogger.i("HOT_LOTTERY", r14.toString());
        return (System.currentTimeMillis() + r10) - r12;
    L6:
        StringBuilder r15 = new StringBuilder("当前时间： ");
        r15.append(System.currentTimeMillis());
        r15.append("     serverDrawTime = ");
        r15.append(r9);
        r15.append("    serverCurrentTime = ");
        r15.append(r7);
        r15.append("  差值:  ");
        long r16 = r9 - r7;
        r15.append(r16);
        r15.append("  enable = false");
        ALogger.i("HOT_LOTTERY", r15.toString());
        return System.currentTimeMillis() + r16;
    }

    public static final Map<String, String> a(boolean r18, t r19, ParticipateStatus r20, LotteryState r22, yz0.k r23, int r24) {
        Intrinsics.checkNotNullParameter(r19, "curStateInfo");
        Intrinsics.checkNotNullParameter(r20, "participateStatus");
        Intrinsics.checkNotNullParameter(r23, "roomDataService");
        List<Integer> r0 = r19.g;
        if (r0.contains(5) == false) goto L5;
    L11:
        String r1 = "fans";
    L12:
        String r7 = r1;
        String r12 = "";
        if (r19.i != null) goto L101;
        String r13 = "";
    L24:
        if (r20 != ParticipateStatus.PARTICIPATEINSUCCESS) goto L26;
        int r2 = 2;
    L27:
        String r3 = String.valueOf(r2);
        if (r22 != null) goto L30;
    L38:
        c r4 = r19.k;
        if (r4 == null) goto L43;
        b r5 = r4.a();
        if (r5 == null) goto L43;
        Boolean r6 = r5.a();
    L44:
        boolean r8 = Intrinsics.areEqual(r6, Boolean.FALSE);
        if (c1.a(r19) == false) goto L47;
        String r9 = "life_coupon_single";
    L58:
        String r10 = (String) vh6.c.b(dr2.e.class).getTrackService().a().get("biz_type");
        if (r10 != null) goto L61;
        r10 = "";
    L61:
        Map<String, String> r14 = b(r19, r23);
        String r16 = r14.get("is_life");
        if (r16 != null) goto L64;
        String r15 = "";
    L65:
        String r17 = r14.get("participate_way");
        if (r17 != null) goto L68;
        r17 = "";
    L68:
        i.B0.getClass();
        if (r24 != 0) goto L71;
        String r25 = "live";
    L74:
        Pair[] r110 = new Pair[13];
        String r26 = r25;
        r110[0] = TuplesKt.to("lottery_id", String.valueOf(r19.a));
        r110[1] = TuplesKt.to("lottery_type", r9);
        r110[2] = TuplesKt.to("is_life", r15);
        r110[3] = TuplesKt.to("activity_name", r13);
        if (r18 == false) goto L77;
        String r27 = "anchor";
    L78:
        r110[4] = TuplesKt.to("activity_role", r27);
        r110[5] = TuplesKt.to("lottery_range", r7);
        r110[6] = TuplesKt.to("biz_type", r10);
        r110[7] = TuplesKt.to("participate_way", r17);
        c r28 = r19.k;
        if (r28 == null) goto L82;
        String r29 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r28);
        if (r29 == null) goto L82;
    L83:
        r110[8] = TuplesKt.to("life_coupon_extra", r29);
        r110[9] = TuplesKt.to("show_type", r3);
        String r30 = r23.getLiveMode().getSceneName();
        if (r30 == null) goto L97;
        int r32 = r30.hashCode();
        if (r32 == 93166550) goto L95;
        if (r32 != 112202875) goto L97;
        if (r30.equals(FileUtils.VIDEO) == false) goto L97;
        r12 = "video_live";
        goto L97
    L95:
        if (r30.equals("audio") == false) goto L97;
        r12 = "voice_live";
    L97:
        r110[10] = TuplesKt.to("live_type", r12);
        r110[11] = TuplesKt.to("event_page", r26);
        r110[12] = TuplesKt.to("function_type2", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getFunctionTypeForLog());
        return MapsKt.mapOf(r110);
    L82:
        r29 = "";
        goto L83
    L77:
        r27 = "user";
        goto L78
    L71:
        if (r24 != 1) goto L73;
        r25 = "preview";
        goto L74
    L73:
        r25 = "";
        goto L74
    L64:
        r15 = r16;
        goto L65
    L47:
        if (r8 == false) goto L49;
        r9 = "life_coupon";
        goto L58
    L49:
        int r33 = r19.d;
        if (r33 == 1) goto L57;
        if (r33 == 2) goto L56;
        if (r33 == 3) goto L55;
        if (r33 == 4) goto L56;
        r9 = "unknown";
        goto L58
    L55:
        r9 = "game";
    L56:
        r9 = "gift";
        goto L58
    L57:
        r9 = "money";
    L43:
        r6 = null;
        goto L44
    L30:
        if ((r22 instanceof LotteryState.d) == false) goto L38;
        h1 r34 = ((LotteryState.d) r22).b;
        if (r34 == null) goto L36;
        ParticipateStatus r35 = r34.h;
        if (r35 == null) goto L36;
    L37:
        r3 = String.valueOf(r35.getStatus());
    L36:
        r35 = ParticipateStatus.CHOOSEING;
        goto L37
    L26:
        r2 = 1;
        goto L27
    L101:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L19
        r13 = new JSONObject(r19.i).optString("activity_name");     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L17:
        th = th;
    L21:
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        th = th;
        r13 = "";
        goto L21
    L5:
        if (r0.contains(8) == true) goto L11;
        if (r0.contains(11) == false) goto L10;
        r1 = "livevip";
        goto L12
    L10:
        r1 = "all";
        goto L12
    }

    public static final void d(boolean r3, t r4, ParticipateStatus r5, LotteryState r6, yz0.k r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "curStateInfo");
        Intrinsics.checkNotNullParameter(r5, "participateStatus");
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        mz0.n r0 = new mz0.n();
        Map<String, String> r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Map<String, String> r9 = a(r3, r4, r5, r6, r7, r8);
        Intrinsics.checkNotNullParameter(r9, "map");
        r1.putAll(r9);
        e(new mz0.o(r0.a), r4.i);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r12 = r0.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("click_lottery", r0.a, r0.b);
    }
}
