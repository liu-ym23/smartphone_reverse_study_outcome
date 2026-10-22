package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ AudioPanelInnerView a;
    public final /* synthetic */ MotionEvent b;

    public g(AudioPanelInnerView r1, MotionEvent r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a;     // Catch: Throwable -> L4
        r0.g = false;     // Catch: Throwable -> L4
        r0.getParent().requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L4
        this.b.setAction(0);     // Catch: Throwable -> L4
        AudioPanelInnerView r1 = this.a;     // Catch: Throwable -> L4
        h.o(r1.a, AudioPluginEnums$DisplayMode.COMPLETE, this.b, AudioPanelInnerView.S5(r1), AudioPanelInnerView.R5(this.a), 16);     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
