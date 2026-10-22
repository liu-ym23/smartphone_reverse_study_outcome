package com.obric.flow.cardlistpage.ui;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f11570b;

    public /* synthetic */ b(int r5, Function0 r10) {
        this.f11569a = r5;
        this.f11570b = r10;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        switch(this.f11569a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        Function0 r10 = this.f11570b;
        if (r10 == null) goto L12;
        r10.invoke();
        return;
    L12:
        return;
    L8:
        Function0 r11 = this.f11570b;
        if (r11 == null) goto L13;
        r11.invoke();
        return;
    }
}
