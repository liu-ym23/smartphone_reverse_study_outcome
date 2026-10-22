package com.bytedance.android.anniex.container;

import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends v3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f3151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3152b;

    public j() {
        this.f3151a = new CopyOnWriteArrayList();
        this.f3152b = new CopyOnWriteArrayList();
    }

    @Override // v3.a
    public final void a(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).a(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).a(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Iterator r10 = this.f3152b.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((j) r10.next()).b(r5);
        goto L4
    L6:
        Iterator r11 = this.f3151a.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ((v3.a) r11.next()).b(r5);
        goto L8
    }

    @Override // v3.a
    public final void c(String r5, AnnieXLiteContainer r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).c(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).c(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void d(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).d(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).d(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void e(String r5, s3.b r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        Iterator r12 = this.f3152b.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((j) r12.next()).e(r5, r10, r11);
        goto L4
    L6:
        Iterator r13 = this.f3151a.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((v3.a) r13.next()).e(r5, r10, r11);
        goto L8
    }

    @Override // v3.a
    public final void f(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).f(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).f(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void g(String r5, s3.b r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        Iterator r12 = this.f3152b.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((j) r12.next()).g(r5, r10, r11);
        goto L4
    L6:
        Iterator r13 = this.f3151a.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((v3.a) r13.next()).g(r5, r10, r11);
        goto L8
    }

    @Override // v3.a
    public final void h(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).h(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).h(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void i(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).i(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).i(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void j(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).j(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).j(r5, r10);
        goto L8
    }

    @Override // v3.a
    public final void k(String r5, s3.b r10) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "container");
        Iterator r11 = this.f3152b.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((j) r11.next()).k(r5, r10);
        goto L4
    L6:
        Iterator r12 = this.f3151a.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((v3.a) r12.next()).k(r5, r10);
        goto L8
    }
}
