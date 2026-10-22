package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final JSONObject c(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toJSONObject");
        return new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r2));
    }

    public static final JSONObject d(Map<String, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toJsonObject");
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, ?> r1 = r5.next();
        r0.put(r1.getKey(), new f(r1.getValue()));
        goto L4
    L6:
        return r0;
    }

    public static final String e(vh7.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toJsonString");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(l97.a.a.toJson(r2));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r3) == true) goto L10;
        return "";
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        String r4 = (String) r3;
        if (r4 != null) goto L16;
        return "";
    L16:
        return r4;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int f(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        return 0;
    L15:
        if (r2.intValue() != 0) goto L17;
        return 3;
    L10:
        if (r2.intValue() != 2) goto L12;
    L19:
        return r2.intValue();
    L5:
        if (r2.intValue() != 1) goto L7;
        goto L7
    }

    public static final HybridType getType(zy0.b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$type");
        xy0.a<?> r2 = r1.g();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.o();
    }

    public static final JSONObject a(int r10, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b r12) {
        JSONObject r0 = new JSONObject();
        r0.put("state", r10);
        if (r12 == null) goto L5;
        IBaseBattleSetting r2 = r12.getBattleSettings();
    L6:
        r0.put("battle_settings", r2);
        if (r12 == null) goto L9;
        Map<String, IBattleUserInfo> r3 = r12.getBattleUserInfoMap();
    L10:
        r0.put("play_anchor_list", r3);
        if (r12 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r4 = r12.getSkinConfig();
        if (r4 == null) goto L15;
        Long r5 = Long.valueOf(r4.a);
    L16:
        r0.put("skin_type", r5);
        if (r12 == null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r6 = r12.getSkinConfig();
        if (r6 == null) goto L21;
        x2 r7 = r6.b;
    L22:
        r0.put("skin_config", r7);
        if (r12 == null) goto L27;
        LiveData<Long> r8 = r12.I();
        if (r8 == null) goto L27;
        Long r9 = (Long) r8.getValue();
    L28:
        r0.put("remain_time", r9);
        r0.put("result", r12.getPkResult().getValue());
        if (r12.getPkResult().getValue() == null) goto L31;
    L73:
        Map<String, Long> r13 = r12.getUserIdToTeamId();
        if (r13 == null) goto L79;
        LinkedHashMap r14 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator<T> r15 = r13.entrySet().iterator();
    L77:
        if (r15.hasNext() == false) goto L80;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put(r16.getKey(), Integer.valueOf(((int) ((Number) r16.getValue()).longValue()) - 1));
    L80:
        r0.put("team_info", r14);
        Intrinsics.checkNotNullParameter(r12, "$this$getPlayScoresJSONObject");
        JSONObject r17 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r18 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r12.getScoreState().getValue();
        if (r18 == null) goto L89;
        List<af2.b> r19 = r18.b();
        if (r19 == null) goto L89;
        List<af2.b> r20 = r19;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r23 = r20.iterator();
    L86:
        if (r23.hasNext() == false) goto L88;
        r22.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.a, (af2.b) r23.next())));
        goto L86
    L88:
        int r24 = com.bytedance.revenue.platform.api.core.b.a;
        r17.put("battle_scores", JSONObject.wrap(r22));
    L89:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r25 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r12.getScoreState().getValue();
        if (r25 == null) goto L94;
        n3 r26 = r25.a();
        if (r26 == null) goto L94;
        JSONObject r27 = c(r26);
    L95:
        r17.put("pve_data", r27);
        r0.put("play_scores", r17);
        r0.put("team_task", r12.getTeamTaskLynxData().getValue());
        r0.put("contribution_list", null);
        r0.put("channel_id", r12.G());
        return r0;
    L94:
        r27 = null;
        goto L95
    L79:
        r14 = null;
        goto L80
    L31:
        if (r10 == RevPkState.PK.ordinal()) goto L73;
        if (r3 == null) goto L36;
        IBattleUserInfo r110 = r3.get(r12.getAnchorId());
        if (r110 == null) goto L36;
        Integer r111 = Integer.valueOf(r110.getPkResult());
    L38:
        if (r3 == null) goto L40;
        int r28 = r3.size();
    L42:
        if (r28 <= 2) goto L67;
        if (r3 == null) goto L57;
        Iterator<Map.Entry<String, IBattleUserInfo>> r29 = r3.entrySet().iterator();
        boolean r30 = true;
    L46:
        if (r29.hasNext() == false) goto L58;
        Map.Entry<String, IBattleUserInfo> r32 = r29.next();
        String r33 = r32.getKey();
        IBattleUserInfo r34 = r32.getValue();
        if (r34 == null) goto L50;
        Integer r35 = Integer.valueOf(r34.getPkResult());
    L51:
        int r36 = r35.intValue();
        if (r111 == null) goto L56;
        if (r36 == r111.intValue()) goto L46;
    L56:
        r30 = false;
        goto L46
    L50:
        r35 = null;
    L58:
        if (r30 == false) goto L60;
        int r112 = RevPkResult.EVEN.ordinal();
    L64:
        Integer r113 = Integer.valueOf(r112);
    L66:
        r0.put("result", r113);
        goto L73
    L60:
        if (r3 == null) goto L65;
        IBattleUserInfo r114 = r3.get(r12.getAnchorId());
        if (r114 == null) goto L65;
        r112 = r114.getPkResult();
    L65:
        r113 = null;
        goto L66
    L57:
        r30 = true;
        goto L58
    L67:
        if (r3 == null) goto L71;
        IBattleUserInfo r115 = r3.get(r12.getAnchorId());
        if (r115 == null) goto L71;
        Integer r116 = Integer.valueOf(r115.getPkResult());
    L72:
        r0.put("result", r116);
    L71:
        r116 = null;
        goto L72
    L40:
        r28 = 0;
    L36:
        r111 = null;
    L27:
        r9 = null;
    L21:
        r7 = null;
    L15:
        r5 = null;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static final MediatorLiveData b(LiveData r2, String r3, FormatType r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$sendDataToLynxMulti");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "formatMap");
        MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new d(r0, r3, r4));
        return r0;
    }
}
