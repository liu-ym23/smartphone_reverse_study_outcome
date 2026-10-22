package com.lynx.tasm.behavior.ui;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f10452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f10454c;

    public e0(ViewGroup r5) {
        this.f10453b = 0;
        this.f10452a = r5;
    }

    public final void a() {
        ViewGroup r5 = this.f10452a;
        int r10 = r5.getChildCount();
        if (this.f10454c != null) goto L10;
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r13 >= r10) goto L7;
        r11.add(r5.getChildAt(r13));
        r13 = r13 + 1;
        goto L5
    L7:
        Collections.sort(r11, new ca.d(14));
        this.f10454c = new int[r10];
    L8:
        if (r12 >= r10) goto L13;
        this.f10454c[r12] = r5.indexOfChild((View) r11.get(r12));
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    }
}
