package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f8600b;

    public /* synthetic */ a(EndIconDelegate r5, int r10) {
        this.f8599a = r10;
        this.f8600b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r10 = this.f8599a;
        EndIconDelegate r11 = this.f8600b;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        PasswordToggleEndIconDelegate.a((PasswordToggleEndIconDelegate) r11, r5);
        return;
    L6:
        DropdownMenuEndIconDelegate.g((DropdownMenuEndIconDelegate) r11, r5);
        return;
    L8:
        ClearTextEndIconDelegate.a((ClearTextEndIconDelegate) r11, r5);
    }
}
