package com.ss.android.lark.image.uploader.entity;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Biz e;
    public final Scene f;
    public final int g;
    public final String h;
    public boolean i;
    public final String j;
    public ImageInfo k;
    public c l;
    public com.ss.android.lark.image.uploader.entity.a m;
    public glb.a n;

    public static final class a {
        public String a;
        public Biz b;
        public Scene c;
        public int d;
        public String e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;

        public final b b() {
            return new b(this.a, this.g, this.f, this.h, this.b, this.c, this.d, this.e, this.i);
        }

        public a() {
            this.a = "";
        }

        public final void a(Biz r2) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            this.b = r2;
        }

        public final void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.a = r2;
        }

        public final void d(Scene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.c = r2;
        }
    }

    public final String toString() {
        return "UploadImage_" + this.a;
    }

    public b(String r1, boolean r2, boolean r3, boolean r4, Biz r5, Scene r6, int r7, String r8, boolean r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r1;
    }
}
