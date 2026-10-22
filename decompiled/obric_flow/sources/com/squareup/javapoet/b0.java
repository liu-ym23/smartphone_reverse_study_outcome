package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends x {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List f14955w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f14956x;

    public b0(List r5, List r10) {
        super(null, new ArrayList());
        List r11 = com.bytedance.android.anniex.base.service.f.x(r5);
        this.f14955w = r11;
        this.f14956x = com.bytedance.android.anniex.base.service.f.x(r10);
        if (r11.size() != 1) goto L5;
        boolean r12 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.r(r12, "unexpected extends bounds: %s", new Object[]{r5});
        Iterator r13 = r11.iterator();
    L7:
        boolean r14 = r13.hasNext();
        x r15 = x.d;
        if (r14 == false) goto L15;
        x r16 = (x) r13.next();
        if (r16.k() == true) goto L13;
        if (r16 == r15) goto L13;
        boolean r17 = true;
    L14:
        com.bytedance.android.anniex.base.service.f.r(r17, "invalid upper bound: %s", new Object[]{r16});
    L13:
        r17 = false;
        goto L14
    L15:
        Iterator r18 = this.f14956x.iterator();
    L17:
        if (r18.hasNext() == false) goto L24;
        x r19 = (x) r18.next();
        if (r19.k() == true) goto L22;
        if (r19 == r15) goto L22;
        boolean r20 = true;
    L23:
        com.bytedance.android.anniex.base.service.f.r(r20, "invalid lower bound: %s", new Object[]{r19});
    L22:
        r20 = false;
        goto L23
    L24:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static b0 n() {
        return o(x.e(Object.class));
    }

    public static b0 o(x r5) {
        return new b0(Collections.singletonList(r5), Collections.emptyList());
    }

    public static b0 p(x r5) {
        return new b0(Collections.singletonList(x.f15028m), Collections.singletonList(r5));
    }

    @Override // com.squareup.javapoet.x
    public final k c(k r5) {
        List r10 = this.f14956x;
        if (r10.size() != 1) goto L6;
        r5.b("? super $T", new Object[]{r10.get(0)});
        return r5;
    L6:
        List r11 = this.f14955w;
        if (((x) r11.get(0)).equals(x.f15028m) == false) goto L9;
        r5.e("?");
    L10:
        return r5;
    L9:
        r5.b("? extends $T", new Object[]{r11.get(0)});
        goto L10
    }
}
