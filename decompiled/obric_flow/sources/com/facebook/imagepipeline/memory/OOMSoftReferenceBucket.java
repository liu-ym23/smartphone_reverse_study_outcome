package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.lang.ref.SoftReference;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
class OOMSoftReferenceBucket<V> extends Bucket<V> {
    public final LinkedList e;

    public OOMSoftReferenceBucket(int r5, int r10) {
        super(r5, r10, 0);
        this.e = new LinkedList();
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public final Object a() {
        OOMSoftReference r5 = (OOMSoftReference) this.f8208c.poll();
        SoftReference r10 = r5.f7673a;
        if (r10 != null) goto L5;
        Object r11 = null;
    L6:
        SoftReference r12 = r5.f7673a;
        if (r12 == null) goto L9;
        r12.clear();
        r5.f7673a = null;
    L9:
        SoftReference r13 = r5.f7674b;
        if (r13 == null) goto L12;
        r13.clear();
        r5.f7674b = null;
    L12:
        SoftReference r14 = r5.f7675c;
        if (r14 == null) goto L15;
        r14.clear();
        r5.f7675c = null;
    L15:
        this.e.add(r5);
        return r11;
    L5:
        r11 = r10.get();
        goto L6
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public final void a(Object r5) {
        OOMSoftReference r10 = (OOMSoftReference) this.e.poll();
        if (r10 != null) goto L5;
        r10 = new OOMSoftReference();
    L5:
        r10.f7673a = new SoftReference(r5);
        r10.f7674b = new SoftReference(r5);
        r10.f7675c = new SoftReference(r5);
        this.f8208c.add(r10);
    }
}
