package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    public interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4895c;

        public b(int r8, int r10, int r11, int r12) {
            this.f4893a = r8;
            this.f4894b = r11;
            this.f4895c = r12;
        }

        public b(b r8) {
            this.f4893a = r8.f4893a;
            this.f4894b = r8.f4894b;
            this.f4895c = r8.f4895c;
        }
    }

    public static boolean a(View r8) {
        WeakHashMap<View, h0> r10 = w.f8437a;
        if (w.e.d(r8) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static PorterDuff.Mode b(int r8, PorterDuff.Mode r10) {
        if (r8 == 3) goto L21;
        if (r8 == 5) goto L19;
        if (r8 == 9) goto L17;
        switch(r8) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r10;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
