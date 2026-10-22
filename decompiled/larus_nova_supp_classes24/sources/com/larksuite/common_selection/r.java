package com.larksuite.common_selection;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public final View a;
    public final Function0<Unit> b;
    public final ViewGroup c;
    public final Context d;
    public final int e;

    public r(SelectionContainer r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "proxyView");
        Intrinsics.checkNotNullParameter(r3, "invokeDismiss");
        this.a = r2;
        this.b = r3;
        this.c = (ViewGroup) r2.getRootView().findViewById(R.id.content);
        this.d = r2.getContext();
        this.e = View.generateViewId();
    }
}
