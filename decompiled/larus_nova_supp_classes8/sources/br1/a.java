package br1;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a {
    public final View.OnTouchListener a;

    public int a() {
        return 0;
    }

    public a(View.OnTouchListener r2) {
        Intrinsics.checkNotNullParameter(r2, "touchListener");
        this.a = r2;
    }
}
