package com.google.android.material.timepicker;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8612b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f8611a = r10;
        this.f8612b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f8611a;
        Object r10 = this.f8612b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        MaterialTimePicker.b((MaterialTimePicker) r10);
        return;
    L6:
        ((RadialViewGroup) r10).updateLayoutParams();
    }
}
