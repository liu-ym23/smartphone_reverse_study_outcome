package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.bdlocation.BuildConfig;
import cy0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(StickerMessageInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "msgInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        w r1 = r9.c;
        if (r1 == null) goto L14;
        r0.put("gift_id", String.valueOf(r1.c));
        i97.a r2 = i97.a.a;
        long r3 = System.currentTimeMillis();
        long r4 = r9.g;
        if (r4 == 0) goto L7;
        r0.put("show_time", String.valueOf(r3 - r4));
        n r5 = new n();
        Map r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        m r7 = new m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r5.b).addAll(r7.a);
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_gift_effect_show_finish", r5.a, r5.b);
    L7:
        JSONObject r11 = new JSONObject();
        r11.put("effect_info", r1.E);     // Catch: Exception -> L11
    L9:
        v12.f.u(r1, "effect_play_end", 0, null, r11);
        return;
    }

    public static JSONObject d(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    public static void a(StickerMessageInfo r4, com.bytedance.android.livesdk.revenue.room.a r5) {
        Intrinsics.checkNotNullParameter(r4, "msgInfo");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        w r0 = r4.c;
        if (r0 == null) goto L22;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("gift_id", String.valueOf(r0.c));
        r1.put("effect_id", String.valueOf(r0.h));
        r1.put("message_id", String.valueOf(r0.b));
        Map<String, Integer> r2 = r4.e;
        if ((!r2.entrySet().isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r1.put("interaction_type", d(r2).toString());
    L10:
        r4.e.clear();
        String r3 = BuildConfig.FLAVOR;
        r1.put("sticker_scene", BuildConfig.FLAVOR);
        r1.put("recognize_anchor", String.valueOf(r4.f));
        IRoomBase r6 = r5.getCommonRoom();
        r1.put("room_id", r6.getIdStr());
        IBaseUser r7 = r6.getOwnerKt();
        if (r7 == null) goto L16;
        String r8 = r7.getIdString();
        if (r8 == null) goto L16;
        r3 = r8;
    L16:
        r1.put("anchor_id", r3);
        if (r5.getCommonIsAnchor() == false) goto L19;
        String r9 = "1";
    L20:
        r1.put("is_anchor", r9);
        n r10 = new n();
        Map r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r11.putAll(r1);
        cy0.e.a.getClass();
        j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_gift_interaction", r10.a, r10.b);
        return;
    L19:
        r9 = "0";
        goto L20
    }

    public static void c(StickerMessageInfo r8, com.bytedance.android.livesdk.revenue.room.a r9) {
        Intrinsics.checkNotNullParameter(r8, "msgInfo");
        Intrinsics.checkNotNullParameter(r9, "roomContext");
        LinkedHashMap r0 = new LinkedHashMap();
        IRoomBase r1 = r9.getCommonRoom();
        r0.put("room_id", r1.getIdStr());
        IBaseUser r2 = r1.getOwnerKt();
        if (r2 == null) goto L5;
        String r3 = com.bytedance.android.live.base.model.user.m.a(r2);
    L6:
        r0.put("anchor_id", r3);
        if (r9.getCommonIsAnchor() == false) goto L9;
        String r4 = "1";
    L10:
        r0.put("is_anchor", r4);
        StringBuilder r5 = new StringBuilder(BuildConfig.FLAVOR);
        r5.append(r1.getIdStr());
        r5.append(r9.getCommonUser().getIdString());
        w r10 = r8.c;
        if (r10 == null) goto L13;
        Long r11 = Long.valueOf(r10.z);
    L14:
        r5.append(r11);
        r0.put("together_effect_id", r5.toString());
        r8.getClass();
        r0.put("gift_cnt", String.valueOf(0));
        r0.put("score", String.valueOf(0));
        r0.put("is_sum_score", "1");
        w r13 = r8.c;
        if (r13 == null) goto L21;
        long r6 = r13.z;
        long r7 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r14 = r6 / r7;
        r0.put("start_time", String.valueOf(r14));
        long r15 = com.bytedance.live.kmp.util.e.b() / r7;
        r0.put("end_time", String.valueOf(r15));
        r0.put("play_duration", String.valueOf(r15 - r14));
        r0.put("gift_id", String.valueOf(r13.c));
        o7 r16 = r8.d;
        if (r16 == null) goto L19;
        Intrinsics.checkNotNullParameter(r16, "$this$getTotalMoney");
        long r17 = r16.getTotalMoney();
    L20:
        r8.getClass();
        r0.put("money", String.valueOf(r17 * ((long) 0)));
        goto L21
    L19:
        r17 = 0;
    L21:
        n r18 = new n();
        Map r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r19.putAll(r0);
        m r20 = new m();
        r20.b(LogCommon.PAGE_SOURCE_LOG);
        r20.b(LogCommon.ROOM);
        ((ArrayList) r18.b).addAll(r20.a);
        cy0.e.a.getClass();
        j r21 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r21).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r23);
        ((f80.a) r23).w3("livesdk_send_gift_together_effect_show", r18.a, r18.b);
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r4 = "0";
        goto L10
    L5:
        r3 = BuildConfig.FLAVOR;
        goto L6
    }
}
