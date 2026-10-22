package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.bmhome.bigimg.m1;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.b0;
import com.larus.gallery.api.k;
import com.larus.gallery.api.m;
import com.larus.gallery.api.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import z79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveGalleryDataSource extends com.larus.drive.sdk.api.gallery.datasource.a<c> {
    public final z79.b c;
    public final Lazy d;
    public final Lazy e;
    public final List<DriveFileItem> f;
    public final List<DriveFileItem> g;

    public DriveGalleryDataSource(z79.b r8) {
        Intrinsics.checkNotNullParameter(r8, "galleryContext");
        super(r8.b);
        this.c = r8;
        this.d = LazyKt.lazy(new a(this));
        this.e = LazyKt.lazy(new b(this));
        this.f = new ArrayList();
        this.g = new ArrayList();
        List<DriveFileItem> r9 = r8.d;
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L6:
        boolean r2 = true;
        if (r10.hasNext() == false) goto L16;
        Object r1 = r10.next();
        DriveFileType r4 = ((DriveFileItem) r1).j;
        if (r4 != DriveFileType.IMAGE) goto L11;
    L14:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L11:
        if (r4 == DriveFileType.VIDEO) goto L14;
        r2 = false;
        goto L14
    L16:
        DriveFileItem r11 = this.c.b;
        Iterator r3 = r0.iterator();
        int r5 = 0;
    L18:
        if (r3.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((DriveFileItem) r3.next()).b, r11.b) == true) goto L24;
        r5 = r5 + 1;
    L24:
        if (r5 < 0) goto L26;
        List<DriveFileItem> r12 = this.f;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r0.subList(0, r5));
        List<DriveFileItem> r14 = this.g;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r0.subList(r5 + 1, r0.size()));
        return;
    L26:
        ((ArrayList) this.g).addAll(r0);
        return;
    L23:
        r5 = -1;
        goto L24
    }

    public final Object c(Continuation<? super b0<? extends List<c>>> r3) {
        return CoroutineScopeKt.coroutineScope(new DriveGalleryDataSource$loadInitial$2(this, null), r3);
    }

    public final Object d(Object r2, Continuation r3) {
        c r4 = (c) r2;
        return CoroutineScopeKt.coroutineScope(new DriveGalleryDataSource$loadMore$2(this, null), r3);
    }

    public final Object g(Object r2, Continuation r3) {
        c r4 = (c) r2;
        return CoroutineScopeKt.coroutineScope(new DriveGalleryDataSource$loadPrevious$2(this, null), r3);
    }

    public final Object i(Object r26, Continuation r27) {
        c r0 = (c) r26;
        GalleryType r2 = r0.d;
        m1 r1 = r0.b;
        if (r1 == null) goto L5;
        String r10 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r11 = r1.b;
    L10:
        return new k(r2, new m(r10, r11, null, null, null, null, null, 508), new q(UUID.randomUUID().toString(), r0.c, 0, null, null, 60), null, null, 24);
    L8:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }
}
