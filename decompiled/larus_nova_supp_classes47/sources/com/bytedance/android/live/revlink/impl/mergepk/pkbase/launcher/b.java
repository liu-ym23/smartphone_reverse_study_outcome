package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.n1;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ JSONObject e;
    public final /* synthetic */ a.b f;

    public b(PkAnchorLauncher r1, int r2, int r3, long r4, JSONObject r6, com.bytedance.android.live.revlink.impl.jsb.a r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }

    public final void accept(Object r19) {
        ExtraResponse r1 = (ExtraResponse) r19;
        Disposable r2 = this.a.f;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        this.a.c = false;
        if (Intrinsics.areEqual(((n1) r1.data).getNotInviteReason(), "in_team_inviting") == true) goto L26;
        PkAnchorLauncher r3 = this.a;
        r3.a = true;
        r3.h.setValue(new c21.c.d(0));
        PkAnchorLauncher.t(this.a);
        d31.f r4 = PkAnchorLauncher.r(this.a);
        if (r4 == null) goto L11;
        r4.e("linkmic/battle/invite/", new d31.a(0, this.b, 0, 0, null, 0, this.c, null, null, null, null, 4029), t.a(this.d));
    L11:
        b21.e r5 = this.a.z();
        if (r5 == null) goto L21;
        JSONObject r6 = this.e;
        long r9 = t.a(this.d);
        int r12 = ((Number) this.a.u.invoke()).intValue();
        HashMap<String, String> r13 = new HashMap();
        r5.b(r13);
        if (r6 == null) goto L17;
        String r7 = r6.toString();
        if (r7 == null) goto L17;
    L18:
        r13.put("extra", r7);
        LiveFullLinkPKMonitor r8 = r5.c();
        if (r8 == null) goto L21;
        LiveFullLinkPKMonitor.s(r8, "linkmic/battle/invite", r9, 0, r12, r13, 4);
    L17:
        r7 = "";
    L21:
        q7 r10 = new q7();
        r10.a = 1;
        JSONObject r14 = new JSONObject();
        r14.put("toast", ((n1) r1.data).getToast());
        Unit r15 = Unit.INSTANCE;
        r10.b = r14;
        a.b r16 = this.f;
        if (r16 == null) goto L25;
        r16.a(r10);
        return;
    L25:
        return;
    }
}
