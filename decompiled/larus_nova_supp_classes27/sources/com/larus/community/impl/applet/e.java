package com.larus.community.impl.applet;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Runnable e;

    public /* synthetic */ e(Ref.BooleanRef r1, View r2, Ref.ObjectRef r3, long r4, Runnable r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        AICreationAppletNavigator.n(this.a, this.b, this.c, this.d, this.e);
        return true;
    }
}
