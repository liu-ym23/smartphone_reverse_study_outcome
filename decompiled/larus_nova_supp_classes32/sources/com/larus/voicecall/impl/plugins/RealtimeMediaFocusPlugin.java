package com.larus.voicecall.impl.plugins;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeMediaFocusPlugin extends com.larus.call_plugins_doubao_common.h implements q {
    public final boolean h;

    public final String T2() {
        return "RealtimeMediaFocusPlugin";
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.voicecall.impl.plugins.y1] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.voicecall.impl.plugins.z1] */
    public final void j3() {
        Function0 r0 = new r1(this);
        if (this.h == false) goto L5;
        r0 = new s1(this);
    L5:
        Function0 r6 = r0;
        boolean r10 = com.larus.im.service.audio.y0.c(getContext().params().s);
        boolean r11 = this.h;
        ((com.larus.call_plugins_doubao_common.h) this).g = new com.larus.call_plugins_doubao_common.manager.n0(new t1(this), new u1(this), new v1(this), new w1(this), r6, new x1(this), new y1(), new z1(), r10, r11, 256);
    }

    public final void k3() {
        Job r0 = ((com.larus.call_plugins_doubao_common.h) this).f;
        if (r0 != null) goto L5;
    L7:
        CoroutineScope r1 = getContext().r();
        Job r2 = null;
        if (r1 == null) goto L10;
        r2 = BuildersKt.launch$default(r1, null, null, new RealtimeMediaFocusPlugin$observerUIStateChange$1(this, null), 3, null);
    L10:
        ((com.larus.call_plugins_doubao_common.h) this).f = r2;
        FLogger.a.d("RealtimeMediaFocusPlugin", "uiStateJob");
        return;
    L5:
        if (r0.isActive() == false) goto L7;
    }

    @Override // com.larus.voicecall.impl.plugins.q
    public final void p() {
        FLogger.a.i("RealtimeMediaFocusPlugin", "releaseMediaFocusSync");
        com.larus.call_plugins_doubao_common.manager.n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.l();
        return;
    }

    public RealtimeMediaFocusPlugin(com.larus.audio.call.arch.c r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = r3;
    }
}
