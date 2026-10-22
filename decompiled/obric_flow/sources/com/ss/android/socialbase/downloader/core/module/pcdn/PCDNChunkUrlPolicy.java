package com.ss.android.socialbase.downloader.core.module.pcdn;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNChunkUrlPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f15367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15369c;
    public int d;
    public int e;

    public PCDNChunkUrlPolicy(ArrayList r5, ArrayList r10) {
        ArrayList r11 = new ArrayList();
        this.f15367a = r11;
        ArrayList r12 = new ArrayList();
        this.f15368b = r12;
        this.f15369c = -1;
        this.d = -1;
        if (r5 != null) goto L5;
    L7:
        if (r10 == null) goto L12;
        if (r10.isEmpty() == true) goto L12;
        r11.addAll(r10);
    L12:
        if (r12.isEmpty() == true) goto L15;
        this.e = 1;
        return;
    L15:
        this.e = 2;
        return;
    L5:
        if (r5.isEmpty() == true) goto L7;
        r12.addAll(r5);
        goto L7
    }

    public final boolean a() {
        if (this.e != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final String b() {
        int r5 = this.e;
        if (r5 == 1) goto L14;
        if (r5 == 2) goto L9;
        return null;
    L9:
        if (this.f15369c >= 0) goto L11;
        this.f15369c = 0;
    L11:
        ArrayList r10 = this.f15367a;
        return (String) r10.get(this.f15369c % r10.size());
    L14:
        if (this.d >= 0) goto L16;
        this.d = 0;
    L16:
        ArrayList r11 = this.f15368b;
        return (String) r11.get(this.d % r11.size());
    }

    public final void c() {
        if (a() == false) goto L13;
        if (this.f15368b.isEmpty() == true) goto L13;
        if (this.d >= (this.f15368b.size() - 1)) goto L9;
    L10:
        this.d++;
        return;
    L9:
        if (this.f15367a.isEmpty() == true) goto L10;
    L13:
        if (this.f15367a.isEmpty() == true) goto L16;
        this.f15369c++;
        this.e = 2;
        return;
    }
}
