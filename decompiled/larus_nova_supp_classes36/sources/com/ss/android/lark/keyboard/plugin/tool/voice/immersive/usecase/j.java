package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Runnable {
    public final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a a;
    public final /* synthetic */ VoiceActionAreaUseCase b;

    public j(com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation.a r1, VoiceActionAreaUseCase r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ((ConstraintLayout) this.a.z.getValue()).setVisibility(4);
        if (this.a.a().hasFocus() == false) goto L5;
        this.a.e().setVisibility(0);
        this.a.g().setVisibility(4);
    L10:
        this.a.c().setVisibility(0);
        this.a.j().setVisibility(0);
        this.a.p().setVisibility(4);
        this.a.n().setVisibility(4);
        return;
    L5:
        this.a.e().setVisibility(4);
        ConstraintLayout r0 = this.a.g();
        if (this.b.g() == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        goto L10
    L8:
        r3 = 8;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
