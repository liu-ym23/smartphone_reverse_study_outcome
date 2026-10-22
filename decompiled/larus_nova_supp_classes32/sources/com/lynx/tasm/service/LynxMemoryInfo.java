package com.lynx.tasm.service;

import com.obric.aivoice.core.data.NameKeys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxMemoryInfo {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final float i;
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final String n;
    public final String o;
    public final int p;
    public final int q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LynxMemoryType {
    }

    public static class a {
        public long a;
        public long b;
        public long c;
        public long d;
        public String e;
        public String f;
        public String g;
        public float h;
        public long i;
        public long j;
        public long k;
        public long l;
        public String m;
        public String n;
        public int o;
        public int p;

        public a() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = NameKeys.UnloadStrategy_No_Strategy;
            this.f = NameKeys.UnloadStrategy_No_Strategy;
            this.g = NameKeys.UnloadStrategy_No_Strategy;
            this.h = 0.0f;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = NameKeys.UnloadStrategy_No_Strategy;
            this.n = NameKeys.UnloadStrategy_No_Strategy;
            this.o = 1;
            this.p = 0;
        }
    }

    public String getType() {
        return this.h;
    }

    public LynxMemoryInfo(a r5) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = NameKeys.UnloadStrategy_No_Strategy;
        this.f = NameKeys.UnloadStrategy_No_Strategy;
        this.g = NameKeys.UnloadStrategy_No_Strategy;
        this.h = NameKeys.UnloadStrategy_No_Strategy;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = NameKeys.UnloadStrategy_No_Strategy;
        this.o = NameKeys.UnloadStrategy_No_Strategy;
        this.p = 0;
        this.q = 0;
        this.a = r5.a;
        this.b = r5.b;
        this.c = r5.c;
        this.d = r5.d;
        this.e = NameKeys.UnloadStrategy_No_Strategy;
        String r0 = r5.e;
        if (r0 == null) goto L5;
        this.f = r0;
    L5:
        String r1 = r5.f;
        if (r1 == null) goto L8;
        this.g = r1;
    L8:
        String r2 = r5.g;
        if (r2 == null) goto L11;
        this.h = r2;
    L11:
        this.i = r5.h;
        this.k = r5.j;
        this.j = r5.i;
        this.l = r5.k;
        this.m = r5.l;
        String r3 = r5.m;
        if (r3 == null) goto L14;
        this.n = r3;
    L14:
        String r4 = r5.n;
        if (r4 == null) goto L17;
        this.o = r4;
    L17:
        this.p = r5.o;
        this.q = r5.p;
    }
}
