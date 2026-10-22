package com.lynx.tasm.fluency;

import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final WeakReference<LynxContext> a;
    public volatile boolean b;
    public a c;
    public o7a.b d;
    public LinkedList<Long> e;
    public long f;
    public long g;
    public int h;
    public long i;
    public long j;
    public int k;

    public interface a {
    }

    /* JADX INFO: renamed from: com.lynx.tasm.fluency.b$b, reason: collision with other inner class name */
    public static class C0061b {
        public int a;
        public int b;
        public int c;
        public long d;
        public int e;
        public long f;
        public int g;
        public long h;
        public int i;
        public long j;
        public int k;
        public long l;

        public C0061b() {
        }
    }

    public b(LynxContext r4) {
        this.b = false;
        this.f = -1;
        this.g = -1;
        this.h = 0;
        this.k = -1;
        this.a = new WeakReference(r4);
        this.e = new LinkedList();
    }
}
