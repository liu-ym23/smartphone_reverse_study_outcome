package com.ss.android.lark.log;

import android.content.Context;
import android.util.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final Context a;
    public final int b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final int g;
    public final boolean h;
    public final b i;
    public final c j;
    public final boolean k;

    public static final class a {
        public Context a;
        public int b;
        public String c;
        public boolean d;
        public String e;
        public String f;
        public pqb.f g;
        public boolean h;
        public b i;
        public c j;
        public int k;
        public boolean l;

        public a() {
            this.h = true;
        }
    }

    public interface b {
        Pair<String, String> a();
    }

    public interface c {
        boolean isEnable();
    }

    public f(a r2) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        pqb.f r0 = r2.g;
        this.g = r2.k;
        this.j = r2.j;
        this.i = r2.i;
        this.h = r2.l;
        this.k = r2.h;
    }
}
