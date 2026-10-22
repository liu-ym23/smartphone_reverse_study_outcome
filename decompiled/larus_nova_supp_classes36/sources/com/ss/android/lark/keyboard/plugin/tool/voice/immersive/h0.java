package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ Function0 a;

    public h0(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.invoke();
    }
}
