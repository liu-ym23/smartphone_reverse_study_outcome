package com.bytedance.android.live.revlink.impl.pk.breakthrough;

import af2.b;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.d;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/breakthrough/BreakThroughBarImpl$playStateObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/pk/d;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BreakThroughBarImpl$playStateObserver$1 implements Observer<d> {
    public final /* synthetic */ BreakThroughBarImpl a;

    public BreakThroughBarImpl$playStateObserver$1(BreakThroughBarImpl r1) {
        this.a = r1;
    }

    public final void a(d r9) {
        List<b> r4 = null;
        if (Intrinsics.areEqual(r9, d.C0190d.b) == false) goto L12;
        this.a.d.clear();
        this.a.getClass();
        BreakThroughBarImpl r10 = this.a;
        r10.h = true;
        BreakThroughBarImpl.c(r10);
        BreakThroughBarImpl r12 = this.a;
        m3 r0 = r12.m.getBreakThoughConfig();
        n3 r5 = this.a.m.getBreakThroughInfo();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r6 = this.a.l.getBattleScoreData();
        if (r6 == null) goto L7;
        r4 = r6.b();
    L7:
        String r1 = BreakThroughBarImpl.b(r12, r0, r5, r4, this.a.m.getPkTitleConfig());
        if (r12.e == false) goto L10;
        JSONObject r7 = new JSONObject();
        r7.put("type", "refresh");
        r7.put(Constants.Keys.DATA, r1);
        r12.e(r7);
        return;
    L10:
        r12.c.addLast(r1);
        return;
    L12:
        if (Intrinsics.areEqual(r9, d.b.b) == false) goto L30;
        BreakThroughBarImpl r13 = this.a;
        if (r13.h == true) goto L23;
        BreakThroughBarImpl.c(r13);
        BreakThroughBarImpl r14 = this.a;
        m3 r2 = r14.m.getBreakThoughConfig();
        n3 r8 = this.a.m.getBreakThroughInfo();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r15 = this.a.l.getBattleScoreData();
        if (r15 == null) goto L18;
        List<b> r16 = r15.b();
    L19:
        String r3 = BreakThroughBarImpl.b(r14, r2, r8, r16, this.a.m.getPkTitleConfig());
        if (r14.e == false) goto L22;
        JSONObject r17 = new JSONObject();
        r17.put("type", "refresh");
        r17.put(Constants.Keys.DATA, r3);
        r14.e(r17);
        goto L23
    L22:
        r14.c.addLast(r3);
        goto L23
    L18:
        r16 = null;
    L23:
        BreakThroughBarImpl r18 = this.a;
        n3 r19 = r18.m.getBreakThroughInfo();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r20 = this.a.l.getBattleScoreData();
        if (r20 == null) goto L26;
        r4 = r20.b();
    L26:
        h3 r22 = this.a.m.getPunishTitleConfig();
        JSONObject r23 = new JSONObject();
        r23.put("info", GsonProtectorUtils.toJson(l97.a.a, r19));
        r23.put("score", GsonProtectorUtils.toJson(l97.a.a, r4));
        r23.put("title", GsonProtectorUtils.toJson(l97.a.a, r22));
        String r24 = r23.toString();
        if (r18.e == false) goto L29;
        JSONObject r25 = new JSONObject();
        r25.put("type", "finish");
        r25.put(Constants.Keys.DATA, r24);
        r18.e(r25);
        return;
    L29:
        r18.d.addLast(r24);
        return;
    L30:
        Intrinsics.areEqual(r9, d.a.b);
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        a((d) r1);
    }
}
