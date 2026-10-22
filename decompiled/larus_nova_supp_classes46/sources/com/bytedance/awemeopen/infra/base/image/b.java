package com.bytedance.awemeopen.infra.base.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final String a;
    public final int b;
    public final List<String> c;
    public View d;
    public com.bytedance.awemeopen.infra.base.image.a e;
    public l64.c f;
    public Drawable g;
    public int h;
    public Drawable i;
    public int j;
    public c k;
    public Uri l;
    public ImageView.ScaleType m;
    public int n;
    public int o;
    public Bitmap.Config p;
    public int q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public boolean v;

    public class a {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.image.b$b, reason: collision with other inner class name */
    public class C0190b implements l64.a {
        public final /* synthetic */ b a;

        @Override // l64.a
        public final void onSuccess() {
            com.bytedance.awemeopen.infra.base.image.a r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.onSuccess();
            return;
        }

        public C0190b(b r1) {
            this.a = r1;
        }

        @Override // l64.a
        public final void onFail(Exception r1) {
            com.bytedance.awemeopen.infra.base.image.a r2 = this.a.e;
            if (r2 == null) goto L6;
            r2.onFail();
            return;
        }
    }

    public final l64.b a() {
        l64.b r0 = new l64.b();
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.f = this.l;
        r0.u = new a(this);
        r0.v = this.f;
        r0.d = this.d;
        r0.e = new C0190b(this);
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.m;
        r0.l = this.n;
        r0.m = this.o;
        r0.n = this.p;
        r0.o = this.q;
        r0.p = this.r;
        r0.q = this.s;
        r0.r = this.t;
        r0.s = this.u;
        r0.t = this.v;
        return r0;
    }

    public b(int r2) {
        this.n = -1;
        this.o = -1;
        this.p = Bitmap.Config.RGB_565;
        this.v = true;
        this.b = r2;
    }

    public final void b(int r2) {
        this.g = null;
        this.h = r2;
    }

    public b(String r2) {
        this.n = -1;
        this.o = -1;
        this.p = Bitmap.Config.RGB_565;
        this.v = true;
        this.a = r2;
    }

    public b(List<String> r2) {
        this.n = -1;
        this.o = -1;
        this.p = Bitmap.Config.RGB_565;
        this.v = true;
        this.c = r2;
    }
}
