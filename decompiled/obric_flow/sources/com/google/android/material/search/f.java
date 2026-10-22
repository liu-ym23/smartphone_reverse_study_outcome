package com.google.android.material.search;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f8572b;

    public /* synthetic */ f(SearchView r5, int r10) {
        this.f8571a = r10;
        this.f8572b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r10 = this.f8571a;
        SearchView r11 = this.f8572b;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        SearchView.a(r11, r5);
        return;
    L6:
        SearchView.f(r11, r5);
        return;
    L8:
        SearchView.j(r11, r5);
    }
}
