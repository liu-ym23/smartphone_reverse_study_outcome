package com.obric.assistant.omnidetailpage.localmedia;

import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements IGalleryDataSource<ifa.c> {
    public final List<ifa.c> a;
    public final String b;
    public final int c;

    public final boolean b() {
        return false;
    }

    public final boolean h() {
        return true;
    }

    public final int k() {
        return 0;
    }

    public /* synthetic */ c(List r3) {
        this(r3, null, 0);
    }

    public final Object c(Continuation<? super b0<? extends List<? extends ifa.c>>> r3) {
        return new b0.b(this.a, false, false);
    }

    public final Object d(Object r1, Continuation r2) {
        ifa.c r3 = (ifa.c) r1;
        return IGalleryDataSource.DefaultImpls.a();
    }

    public final Object e(List<? extends ifa.c> r1, Continuation<? super List<? extends Pair<? extends ifa.c, com.larus.gallery.api.k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final Object f(Object r1, Continuation r2) {
        return (ifa.c) r1;
    }

    public final Object g(Object r1, Continuation r2) {
        ifa.c r3 = (ifa.c) r1;
        return IGalleryDataSource.DefaultImpls.b();
    }

    public final Object i(Object r25, Continuation r26) {
        ifa.c r1 = (ifa.c) r25;
        if ((r1 instanceof ifa.c.a) == false) goto L6;
        GalleryType r4 = GalleryType.Image;
        ifa.c.a r2 = (ifa.c.a) r1;
        String r7 = r2.d;
        return new com.larus.gallery.api.k(r4, new com.larus.gallery.api.m(r7, r7, r2.e, r2.f, null, null, null, 496), null, null, null, 28);
    L6:
        if ((r1 instanceof ifa.c.b) == false) goto L21;
        GalleryType r5 = GalleryType.Video;
        ifa.c.b r3 = (ifa.c.b) r1;
        String r8 = r3.a;
        if (Intrinsics.areEqual(r8, this.b) == false) goto L10;
        int r9 = this.c;
    L11:
        String r11 = r3.a;
        String r6 = r3.c;
        Double r15 = r3.k;
        String r10 = r3.f;
        String r12 = r3.e;
        Integer r13 = r3.h;
        if (r13 != null) goto L14;
        r13 = r3.j;
    L14:
        Integer r20 = r13;
        Integer r14 = r3.g;
        if (r14 != null) goto L17;
        Integer r21 = r3.i;
    L19:
        return new com.larus.gallery.api.k(r5, null, new com.larus.gallery.api.q(r8, new nr9.g(r11, null, null, null, r15, null, new nr9.f(r10, r10, r12, r20, r21, null, 32), r6, null, null, 814), r9, null, null, 56), null, null, 26);
    L17:
        r21 = r14;
        goto L19
    L10:
        r9 = 0;
        goto L11
    L21:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean j(Object r1, Object r2) {
        return Intrinsics.areEqual((ifa.c) r1, (ifa.c) r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends ifa.c> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "mediaItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
