package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f4254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f4255b = null;

    static {
        f4254a = new AnonymousClass1();
        f4255b = new AnonymousClass2();
    }

    static f a(int r0, boolean r1, RectF r2, RectF r3) {
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L10;
        return f4255b;
    L10:
        throw new IllegalArgumentException("Invalid fit mode: " + r0);
    L12:
        return f4254a;
    L14:
        if (a(r1, r2, r3) == false) goto L17;
        return f4254a;
    L17:
        return f4255b;
    }

    private static boolean a(boolean r4, RectF r5, RectF r6) {
        float r0 = r5.width();
        float r7 = r5.height();
        float r1 = r6.width();
        float r8 = r6.height();
        float r2 = (r8 * r0) / r1;
        float r3 = (r1 * r7) / r0;
        if (r4 == false) goto L8;
        if (r2 < r7) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (r3 < r8) goto L11;
        return true;
    }
}
