package com.larus.avlink.plugins;

import android.animation.ValueAnimator;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraMediaFocusPlugin extends com.larus.call_plugins_doubao_common.h implements s4, o4 {
    public final n4 h;
    public ValueAnimator i;
    public ValueAnimator j;

    public static final class a {
    }

    static {
    }

    public final String T2() {
        return "DoraMediaFocusPlugin";
    }

    @Override // com.larus.avlink.plugins.s4
    public final void M1() {
        com.larus.call_plugins_doubao_common.manager.n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public final void j3() {
        ((com.larus.call_plugins_doubao_common.h) this).g = new com.larus.call_plugins_doubao_common.manager.r(new d2(this), new e2(this), new f2(this), new g2());
    }

    public final void k3() {
        Job r0 = ((com.larus.call_plugins_doubao_common.h) this).f;
        if (r0 != null) goto L5;
    L7:
        CoroutineScope r1 = getContext().r();
        Job r2 = null;
        if (r1 == null) goto L10;
        r2 = BuildersKt.launch$default(r1, null, null, new DoraMediaFocusPlugin$observerUIStateChange$1(this, null), 3, null);
    L10:
        ((com.larus.call_plugins_doubao_common.h) this).f = r2;
        FLogger.a.d("DoraMediaFocusPlugin", "uiStateJob");
        return;
    L5:
        if (r0.isActive() == false) goto L7;
    }

    @Override // com.larus.avlink.plugins.s4
    public final void z1() {
        com.larus.call_plugins_doubao_common.manager.n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    public DoraMediaFocusPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "innerContext");
        super(r2);
        this.h = r2;
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r1) {
        M1();
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        z1();
    }
}
