package com.google.android.material.textfield;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8606b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f8605a = r10;
        this.f8606b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f8605a;
        Object r10 = this.f8606b;
        switch(r5) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        TextInputLayout.a((TextInputLayout) r10);
        return;
    L6:
        DropdownMenuEndIconDelegate.a((DropdownMenuEndIconDelegate) r10);
        return;
    L8:
        ClearTextEndIconDelegate.e((ClearTextEndIconDelegate) r10);
    }
}
