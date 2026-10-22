package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends b8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f8902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f8903b;

    public b0(a0 r5, Map.Entry r10) {
        this.f8903b = r5;
        this.f8902a = r10;
    }

    @Override // com.google.common.collect.y7
    public final int getCount() {
        Map.Entry r5 = this.f8902a;
        Count r10 = (Count) r5.getValue();
        if (r10 != null) goto L5;
    L6:
        Count r11 = (Count) AbstractMapBasedMultiset.access$100(this.f8903b.d).get(r5.getKey());
        if (r11 != null) goto L9;
    L10:
        if (r10 != null) goto L13;
        return 0;
    L13:
        return r10.get();
    L9:
        return r11.get();
    L5:
        if (r10.get() != 0) goto L10;
        goto L6
    }

    @Override // com.google.common.collect.y7
    public final Object getElement() {
        return this.f8902a.getKey();
    }
}
