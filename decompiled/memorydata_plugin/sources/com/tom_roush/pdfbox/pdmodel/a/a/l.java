package com.tom_roush.pdfbox.pdmodel.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f16155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Integer> f16156b;

    public l() {
    }

    private List<T> b() {
        if (this.f16155a != null) goto L6;
        this.f16155a = new ArrayList();
    L6:
        return this.f16155a;
    }

    private List<Integer> c() {
        if (this.f16156b != null) goto L6;
        this.f16156b = new ArrayList();
    L6:
        return this.f16156b;
    }

    public int a() {
        return b().size();
    }

    public T a(int r1) {
        return b().get(r1);
    }

    public void a(T r2, int r3) {
        b().add(r2);
        c().add(Integer.valueOf(r3));
    }

    public int b(int r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(c().get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public void b(T r2, int r3) {
        int r4 = b().indexOf(r2);
        if (r4 <= (-1)) goto L6;
        c().set(r4, Integer.valueOf(r3));
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= b().size()) goto L9;
        if (r1 <= 0) goto L7;
        r0.append("; ");
    L7:
        r0.append("object=").append(b().get(r1)).append(", revisionNumber=").append(b(r1));
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.toString();
    }
}
