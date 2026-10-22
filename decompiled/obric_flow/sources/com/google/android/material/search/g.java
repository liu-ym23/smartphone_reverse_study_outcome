package com.google.android.material.search;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f8574b;

    public /* synthetic */ g(SearchView r5, int r10) {
        this.f8573a = r10;
        this.f8574b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f8573a;
        SearchView r10 = this.f8574b;
        switch(r5) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        r10.requestFocusAndShowKeyboardIfNeeded();
        return;
    L6:
        r10.show();
        return;
    L8:
        SearchView.e(r10);
        return;
    L10:
        SearchView.d(r10);
    }
}
