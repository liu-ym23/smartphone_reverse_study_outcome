package com.ss.android.lark.forwardv3.utils;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements TextView.OnEditorActionListener {
    public final /* synthetic */ Function0<Boolean> a;

    public m(Function0<Boolean> r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.a.invoke()).booleanValue();
    }
}
