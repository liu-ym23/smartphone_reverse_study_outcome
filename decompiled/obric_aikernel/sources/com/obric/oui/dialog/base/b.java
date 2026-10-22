package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<D extends AbstractDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DialogInterface.OnDismissListener f6507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f6508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DialogInterface.OnShowListener f6509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnClickListener f6510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AbstractDialog.CloseIconStyle f6513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Pair<Integer, Integer> f6514h;

    public b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f6511e = true;
        this.f6513g = AbstractDialog.CloseIconStyle.DARK;
        this.f6514h = TuplesKt.to(null, null);
    }

    public static /* synthetic */ b i(b r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.h(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public final D a() {
        D r10 = (D) c();
        r10.w(this.f6512f, this.f6510d);
        r10.setCancelable(this.f6511e);
        r10.g(this.f6513g, this.f6514h.getFirst(), this.f6514h.getSecond());
        return r10;
    }

    public b<D> b(boolean r10) {
        this.f6511e = r10;
        return this;
    }

    public abstract D c();

    public final DialogInterface.OnCancelListener d() {
        return this.f6508b;
    }

    public final DialogInterface.OnDismissListener e() {
        return this.f6507a;
    }

    public final boolean f() {
        return this.f6512f;
    }

    public final DialogInterface.OnShowListener g() {
        return this.f6509c;
    }

    public b<D> h(boolean r10, View.OnClickListener r11) {
        this.f6512f = r10;
        this.f6510d = r11;
        return this;
    }
}
