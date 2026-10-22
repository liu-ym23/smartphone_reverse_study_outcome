package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ b0 a;

    public f0(b0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
    L12:
        b0.b(this.a, 2131890453);
        return;
    L10:
        if (r4.intValue() != 10006) goto L12;
    L13:
        b0.b(this.a, 2131891301);
        return;
    L6:
        if (r4.intValue() == 10005) goto L13;
        goto L7
    }
}
