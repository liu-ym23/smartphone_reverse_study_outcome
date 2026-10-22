package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f8602b;

    public /* synthetic */ b(EndIconDelegate r5, int r10) {
        this.f8601a = r10;
        this.f8602b = r5;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r5, boolean r10) {
        int r11 = this.f8601a;
        EndIconDelegate r12 = this.f8602b;
        switch(r11) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        DropdownMenuEndIconDelegate.d((DropdownMenuEndIconDelegate) r12, r5, r10);
        return;
    L6:
        ClearTextEndIconDelegate.b((ClearTextEndIconDelegate) r12, r5, r10);
    }
}
