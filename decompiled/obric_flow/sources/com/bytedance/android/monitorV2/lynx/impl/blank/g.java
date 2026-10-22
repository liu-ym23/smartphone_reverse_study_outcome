package com.bytedance.android.monitorV2.lynx.impl.blank;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3679c;
    public final ArrayList d;
    public final HashMap e;
    public final HashMap f;
    public boolean g;

    public g(int r5, int r10) {
        int r11 = Math.max(1, (int) (Math.max(r5, r10) / 100.0f));
        this.f3677a = r5;
        this.f3678b = r10;
        this.f3679c = r11;
        this.d = new ArrayList();
        this.e = new HashMap();
        this.f = new HashMap();
    }

    public final void a(int r5, int r10, int r11, int r12, int r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "element");
        if (r13 == 0) goto L6;
        this.d.add(new Integer[]{Integer.valueOf(r5), Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});
    L6:
        if (r15 == false) goto L10;
        if (r13 != 1) goto L10;
        this.g = true;
    L10:
        if (r13 != 1) goto L15;
        HashMap r16 = this.f;
        Object r17 = r16.get(r14);
        if (r17 != null) goto L14;
        r17 = 0;
    L14:
        r16.put(r14, Integer.valueOf(((Number) r17).intValue() + 1));
    L15:
        HashMap r18 = this.e;
        Object r19 = r18.get(r14);
        if (r19 != null) goto L18;
        r19 = 0;
    L18:
        r18.put(r14, Integer.valueOf(((Number) r19).intValue() + 1));
    }
}
