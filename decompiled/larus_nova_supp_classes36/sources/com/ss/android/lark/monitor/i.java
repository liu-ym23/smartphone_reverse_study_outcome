package com.ss.android.lark.monitor;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public final Context a;
    public final c b;
    public final List<String> c;
    public final boolean d;
    public final String e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public static class a {
        public final Context a;
        public c b;
        public boolean c;
        public boolean d;
        public String e;
        public f f;
        public final List<String> g;
        public int h;
        public boolean i;

        /* JADX INFO: renamed from: com.ss.android.lark.monitor.i$a$a, reason: collision with other inner class name */
        public class C0186a implements f {
            public C0186a() {
            }
        }

        public a(Context r2) {
            this.f = new C0186a();
            this.g = new ArrayList();
            this.h = 5;
            this.i = false;
            this.a = r2;
        }
    }

    public i(a r4) {
        this.a = r4.a;
        c r0 = r4.b;
        this.b = r0;
        this.g = r4.c;
        f r1 = r4.f;
        this.d = r4.d;
        this.e = r4.e;
        this.c = r4.g;
        this.f = r4.h;
        this.h = r4.i;
        if (r0 == null) goto L9;
        if (r1 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("time formater impl needed!");
    L9:
        throw new IllegalArgumentException("dependence impl not init!");
    }
}
