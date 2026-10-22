package com.bytedance.android.anniex.scene.next;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final ConcurrentMap<String, a> a;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        }

        public final String toString() {
            return "RepeatStrategyStats(totalRepeatSceneShow=" + this.a + ", totalRepeatCount=" + this.b + ", totalPredictions=" + this.c + ", totalRepeatPredictions=" + this.d + ", predictHits=" + this.e + ", predictRepeatHits=" + this.f + ", predictUnRepeatHits=" + this.g + ')';
        }

        public a(int r1) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
        }
    }

    public e() {
        this.a = new ConcurrentHashMap();
    }
}
