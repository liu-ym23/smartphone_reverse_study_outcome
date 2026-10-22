package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.InteractivityPlatfromContextUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class AbsPSHighlightComp implements g {
    public final Lazy a;
    public final PropertyOwner<IPSHighlightCompLifecycle$State> b;
    public final String c;
    public final n d;
    public final DataCenter e;

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m(FailReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    public void n(InterruptReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    public void o() {
    }

    public void b() {
        InteractivityPlatfromContextUtils.a(this.e, new AbsPSHighlightComp$dismiss$1(this));
    }

    public final k d() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2), this.e);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<k> r1 = r0.getHighlightContext();
        if (r1 == null) goto L7;
        return (k) r1.getValue();
    L7:
        return null;
    }

    public final boolean g() {
        if (((IPSHighlightCompLifecycle$State) this.b.a) != IPSHighlightCompLifecycle$State.Destroyed) goto L5;
        return true;
    L5:
        return false;
    }

    public final void q() {
        InteractivityPlatfromContextUtils.a(this.e, new AbsPSHighlightComp$show$1(this));
    }

    public final z51.e<p42.a> f() {
        k r0 = d();
        if (r0 == null) goto L7;
        l r1 = r0.stateCenter();
        if (r1 == null) goto L7;
        z51.e<p42.a> r2 = r1.lifecycle();
    L9:
        if ((r2 instanceof z51.e) == true) goto L12;
        return null;
    L12:
        return r2;
    L7:
        r2 = null;
        goto L9
    }

    public String e() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public n getType() {
        return this.d;
    }

    public final <T> T c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        T r3 = (T) ((Map) this.a.getValue()).get(r2);
        if ((r3 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    public final void h(IPSHighlightCompLifecycle$State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.b.a(r2);
        int r3 = a.a[r2.ordinal()];
        if (r3 != 2) goto L5;
        z51.e<p42.a> r4 = f();
        if (r4 == null) goto L29;
        int r0 = p42.a.c;
        r4.b(p42.a.C0260a.a(this));
    L29:
        j();
        return;
    L5:
        if (r3 != 3) goto L7;
        i();
        z51.e<p42.a> r5 = f();
        if (r5 == null) goto L36;
        int r1 = p42.a.c;
        r5.b(p42.a.C0260a.a(this));
        return;
    L36:
        return;
    L7:
        if (r3 != 4) goto L9;
        o();
        z51.e<p42.a> r6 = f();
        if (r6 == null) goto L34;
        int r7 = p42.a.c;
        r6.b(p42.a.C0260a.a(this));
        return;
    L34:
        return;
    L9:
        if (r3 != 5) goto L11;
        l();
        z51.e<p42.a> r8 = f();
        if (r8 == null) goto L32;
        int r9 = p42.a.c;
        r8.b(p42.a.C0260a.a(this));
        return;
    L32:
        return;
    L11:
        if (r3 != 6) goto L38;
        z51.e<p42.a> r10 = f();
        if (r10 == null) goto L16;
        int r11 = p42.a.c;
        r10.b(p42.a.C0260a.a(this));
    L16:
        k();
        return;
    }

    public final void p(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        ((Map) this.a.getValue()).put(r2, r3);
    }

    public AbsPSHighlightComp(String r2, n r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(AbsPSHighlightComp$extras$2.INSTANCE);
        this.b = new PropertyOwner(IPSHighlightCompLifecycle$State.Initialized, AbsPSHighlightComp$_lifecycleObserver$1.INSTANCE);
    }
}
