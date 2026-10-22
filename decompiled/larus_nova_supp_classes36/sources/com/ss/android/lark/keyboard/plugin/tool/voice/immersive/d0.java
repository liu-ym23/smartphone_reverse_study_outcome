package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ b0 a;

    public d0(b0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        b0.a(this.a, 2131892833);
        return;
    }
}
