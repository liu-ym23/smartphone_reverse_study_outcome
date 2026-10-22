package com.obric.oui.orecyclerview.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f14125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f14126b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14128b;
        int c;
        int d;
        int e;

        a() {
            this.f14127a = 0;
        }

        int a(int r1, int r2) {
            if (r1 <= r2) goto L5;
            return 1;
        L5:
            if (r1 != r2) goto L8;
            return 2;
        L8:
            return 4;
        }

        void a() {
            this.f14127a = 0;
        }

        void a(int r2) {
            this.f14127a = r2 | this.f14127a;
        }

        void a(int r1, int r2, int r3, int r4) {
            this.f14128b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }

        boolean b() {
            int r0 = this.f14127a;
            if ((r0 & 7) != 0) goto L5;
        L7:
            int r1 = this.f14127a;
            if ((r1 & 112) != 0) goto L10;
        L12:
            int r2 = this.f14127a;
            if ((r2 & 1792) != 0) goto L15;
        L17:
            int r3 = this.f14127a;
            if ((r3 & 28672) != 0) goto L20;
            return true;
        L20:
            if (((a(this.e, this.c) << 12) & r3) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r2 & (a(this.e, this.f14128b) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r1 & (a(this.d, this.c) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r0 & (a(this.d, this.f14128b) << 0)) != 0) goto L7;
            return false;
        }
    }

    interface b {
        int a();

        int a(View r1);

        View a(int r1);

        int b();

        int b(View r1);
    }

    ac(b r3) {
        this.f14125a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f14126b = new a();
    }

    View a(int r9, int r10, int r11, int r12) {
        int r0 = this.f14125a.a();
        int r1 = this.f14125a.b();
        if (r10 <= r9) goto L5;
        int r2 = 1;
    L6:
        View r3 = null;
    L7:
        if (r9 == r10) goto L18;
        View r4 = this.f14125a.a(r9);
        int r5 = this.f14125a.a(r4);
        int r6 = this.f14125a.b(r4);
        this.f14126b.a(r0, r1, r5, r6);
        if (r11 == 0) goto L13;
        this.f14126b.a();
        this.f14126b.a(r11);
        if (this.f14126b.b() == false) goto L13;
        return r4;
    L13:
        if (r12 == 0) goto L17;
        this.f14126b.a();
        this.f14126b.a(r12);
        if (this.f14126b.b() == false) goto L17;
        r3 = r4;
    L17:
        r9 = r9 + r2;
        goto L7
    L18:
        return r3;
    L5:
        r2 = -1;
        goto L6
    }

    boolean a(View r6, int r7) {
        this.f14126b.a(this.f14125a.a(), this.f14125a.b(), this.f14125a.a(r6), this.f14125a.b(r6));
        if (r7 == 0) goto L6;
        this.f14126b.a();
        this.f14126b.a(r7);
        return this.f14126b.b();
    L6:
        return false;
    }
}
