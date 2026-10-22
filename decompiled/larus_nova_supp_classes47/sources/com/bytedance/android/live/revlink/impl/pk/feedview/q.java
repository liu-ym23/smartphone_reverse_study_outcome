package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public static final JSONObject a(Integer r5, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r6, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r7) {
        JSONObject r0 = new JSONObject();
        r0.put("state", r5);
        IBaseBattleSetting r8 = r7.b();
        String r1 = null;
        if (r8 == null) goto L5;
        JSONObject r9 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r8);
    L6:
        r0.put("battle_settings", r9);
        IBattleUserInfo r10 = r7.f;
        if (r10 == null) goto L9;
        JSONObject r12 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r10);
    L10:
        r0.put("play_anchor_list", r12);
        r0.put("skin_type", r7.c);
        x2 r13 = r7.c();
        if (r13 == null) goto L13;
        JSONObject r14 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r13);
    L14:
        r0.put("skin_config", r14);
        r0.put("remain_time", r6.d.getValue());
        MutableLiveData<q11.a> r15 = r6.h;
        if (r15 == null) goto L21;
        q11.a r16 = (q11.a) r15.getValue();
        if (r16 == null) goto L21;
        RevPkResult r17 = r16.a();
        if (r17 == null) goto L21;
        Integer r18 = Integer.valueOf(r17.ordinal());
    L22:
        r0.put("result", r18);
        Intrinsics.checkNotNullParameter(r6, "$this$getPlayScoresJSONObject");
        JSONObject r19 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r20 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r6.f.getValue();
        if (r20 == null) goto L26;
        List<af2.b> r22 = r20.b();
        if (r22 == null) goto L26;
    L27:
        List<af2.b> r23 = r22;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r24 = r23.iterator();
    L29:
        if (r24.hasNext() == false) goto L31;
        r2.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r24.next())));
        goto L29
    L31:
        int r25 = com.bytedance.revenue.platform.api.core.b.a;
        r19.put("battle_scores", JSONObject.wrap(r2));
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r26 = r6.f;
        if (r26 == null) goto L38;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r27 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r26.getValue();
        if (r27 == null) goto L38;
        n3 r28 = r27.a();
        if (r28 == null) goto L38;
        JSONObject r29 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r28);
    L39:
        r19.put("pve_data", r29);
        r0.put("play_scores", r19);
        r0.put("team_task", r6.g.getValue());
        r0.put("contribution_list", null);
        MutableLiveData<String> r30 = r6.j;
        if (r30 == null) goto L42;
        r1 = (String) r30.getValue();
    L42:
        r0.put("channel_id", r1);
        return r0;
    L38:
        r29 = null;
    L26:
        r22 = CollectionsKt.emptyList();
    L21:
        r18 = null;
        goto L22
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final MediatorLiveData b(MutableLiveData r2, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$convertFeedPkStateToJSON");
        Intrinsics.checkNotNullParameter(r3, "viewState");
        Intrinsics.checkNotNullParameter(r4, "getChannelID");
        MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r2, new k(r0, r3, r4));
        return r0;
    }
}
