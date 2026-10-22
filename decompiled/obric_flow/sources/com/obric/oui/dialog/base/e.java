package com.obric.oui.dialog.base;

import android.content.DialogInterface;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnDismissListener f13116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f13117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13118c;
    public AbstractDialog$CloseIconStyle d;
    public Pair e;

    public final com.obric.oui.dialog.v2.alert.b a() {
        com.obric.oui.dialog.v2.alert.b r5 = b();
        r5.d(this.f13117b);
        r5.setCancelable(this.f13118c);
        Pair r10 = this.e;
        Integer r11 = (Integer) r10.getFirst();
        Integer r12 = (Integer) r10.getSecond();
        AbstractDialog$CloseIconStyle r13 = this.d;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r13, "style");
        return r5;
    }

    public abstract com.obric.oui.dialog.v2.alert.b b();
}
