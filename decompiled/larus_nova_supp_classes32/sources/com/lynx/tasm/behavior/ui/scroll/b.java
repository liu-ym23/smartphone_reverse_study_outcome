package com.lynx.tasm.behavior.ui.scroll;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final double a;
    public final int b;
    public final int c;
    public final a d;

    public interface a {
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.scroll.b$b, reason: collision with other inner class name */
    public static final class C0055b {
        public final c a;
        public final int b;
        public final int c;
        public final int d;

        public C0055b(c r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;

        public c(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d {
        public final int a;
        public final int b;

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b(ReadableMap r10, com.lynx.tasm.behavior.ui.scroll.d r11) {
        double r0 = r10.getDouble("factor");
        int r2 = r10.getInt("offset", 0);
        int r4 = 1;
        int r12 = r10.getInt("maxSnapCount", 1);
        if (r0 >= 0.0d) goto L5;
    L6:
        r0 = 0.0d;
    L7:
        if (r12 < 1) goto L10;
        r4 = r12;
    L10:
        this.a = r0;
        this.b = (int) i.b(r2, 0.0f);
        this.c = r4;
        this.d = r11;
        return;
    L5:
        if (r0 <= 1.0d) goto L7;
        goto L6
    }
}
