package com.bytedance.android.live.revlink.impl.pk.breakthrough;

import af2.b;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/breakthrough/BreakThroughBarImpl$battleScoreDataObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/a;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BreakThroughBarImpl$battleScoreDataObserver$1 implements Observer<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> {
    public final /* synthetic */ BreakThroughBarImpl a;

    public BreakThroughBarImpl$battleScoreDataObserver$1(BreakThroughBarImpl r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        BreakThroughBarImpl r0 = this.a;
        if (r0.e == false) goto L10;
        PkBaseStateMachine.c r1 = r0.m.getCurPKBaseState();
        r1.getClass();
        if ((r1 instanceof PkBaseStateMachine.c.d) == true) goto L11;
        BreakThroughBarImpl r2 = this.a;
        n3 r3 = r5.a();
        List<b> r6 = r5.b();
        r2.getClass();
        JSONObject r4 = new JSONObject();
        r4.put("info", GsonProtectorUtils.toJson(l97.a.a, r3));
        r4.put("score", GsonProtectorUtils.toJson(l97.a.a, r6));
        String r7 = r4.toString();
        r2.getClass();
        JSONObject r8 = new JSONObject();
        r8.put("type", "update_score");
        r8.put(Constants.Keys.DATA, r7);
        r2.e(r8);
        return;
    L11:
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        a((com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r1);
    }
}
