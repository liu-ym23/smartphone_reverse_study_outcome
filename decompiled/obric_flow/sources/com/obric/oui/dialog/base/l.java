package com.obric.oui.dialog.base;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends j {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13144x;

    public l(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
    }

    @Override // com.obric.oui.dialog.base.j
    public final void a() {
        this.f13144x = false;
        super.a();
    }

    @Override // com.obric.oui.dialog.base.j, android.content.DialogInterface
    public final void dismiss() {
        if (this.f13144x == false) goto L5;
        return;
    L5:
        this.f13144x = true;
        super.dismiss();
    }

    public final void setDismissing(boolean r5) {
        this.f13144x = r5;
    }
}
