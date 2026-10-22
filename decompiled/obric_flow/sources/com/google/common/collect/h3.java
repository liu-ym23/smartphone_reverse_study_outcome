package com.google.common.collect;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h3 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9008b;

    public /* synthetic */ h3(Object r5, int r10) {
        this.f9007a = r10;
        this.f9008b = r5;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(final Object r5, Object r10) {
        Object r11 = this.f9008b;
        switch(this.f9007a) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        int r12 = AbstractMapBasedMultiset.e;
        ObjIntConsumer r13 = (ObjIntConsumer) r11;
        r13.accept(r5, ((Count) r10).get());
        return;
    L6:
        ((BiConsumer) r11).accept(r10, r5);
        return;
    L8:
        final BiConsumer r14 = (BiConsumer) r11;
        final int r15 = 1;
        ((Collection) r10).forEach(new i(r14, r5, r15));
        return;
    L10:
        final BiConsumer r16 = (BiConsumer) r11;
        final int r17 = 0;
        ((Collection) r10).forEach(new i(r16, r5, r17));
        return;
    L12:
        int r18 = HashBiMap.Inverse.f8814a;
        ((BiConsumer) r11).accept(r10, r5);
    }
}
