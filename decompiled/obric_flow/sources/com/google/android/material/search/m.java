package com.google.android.material.search;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8584b;

    public /* synthetic */ m(Object r5, int r10) {
        this.f8583a = r10;
        this.f8584b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f8583a;
        Object r10 = this.f8584b;
        switch(r5) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        SearchBar.b((SearchBar) r10);
        return;
    L6:
        SearchViewAnimationHelper.a((SearchViewAnimationHelper) r10);
        return;
    L8:
        SearchViewAnimationHelper.d((SearchViewAnimationHelper) r10);
    }
}
