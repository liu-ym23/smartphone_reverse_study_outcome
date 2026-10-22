package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements qub.a {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.ObjectRef<qub.a> c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ Ref.ObjectRef<View.OnAttachStateChangeListener> e;
    public final /* synthetic */ View f;

    @Override // qub.a
    public final void hide() {
        c.a(this.a, this.b, this.c, this.d, this.e, this.f, "hide");
    }

    @Override // qub.a
    public final boolean isShowing() {
        qub.a r0 = (qub.a) this.c.element;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public b(Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.ObjectRef<qub.a> r3, Ref.BooleanRef r4, Ref.ObjectRef<View.OnAttachStateChangeListener> r5, View r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
