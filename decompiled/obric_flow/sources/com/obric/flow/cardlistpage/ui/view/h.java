package com.obric.flow.cardlistpage.ui.view;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f11852b;

    public /* synthetic */ h(int r5, Function1 r10) {
        this.f11851a = r5;
        this.f11852b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        switch(this.f11851a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f11852b.invoke(r5);
        return;
    L6:
        this.f11852b.invoke(r5);
        return;
    L8:
        this.f11852b.invoke(r5);
    }
}
