package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.opt.DeviceScore;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final boolean a(List<com.bytedance.android.shopping.api.image.d> r10, com.bytedance.android.ec.core.imagex.r r11, com.bytedance.android.shopping.api.image.q r12) {
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        List<com.bytedance.android.shopping.api.image.d> r1 = r10;
        if (r1 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L23;
        Iterator<T> r14 = r10.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        com.bytedance.android.shopping.api.image.d r16 = (com.bytedance.android.shopping.api.image.d) r15;
        Intrinsics.checkNotNullParameter(r16, "$this$notMatchIn");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if ((!c(r16, r11, r12)) == false) goto L12;
    L17:
        if (r15 != null) goto L24;
        return true;
    L24:
        return false;
    L16:
        r15 = null;
        goto L17
    L23:
        return false;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r13 = false;
        goto L9
    }

    public static final boolean b(com.bytedance.android.shopping.api.image.d.b r10, com.bytedance.android.ec.core.imagex.r r11, com.bytedance.android.shopping.api.image.q r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$matchIn");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if (Intrinsics.areEqual(r10.c(), Boolean.TRUE) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r10.g(), "and") == false) goto L10;
        return a(r10.e(), r11, r12);
    L10:
        if (Intrinsics.areEqual(r10.g(), "or") == false) goto L31;
        List r13 = r10.e();
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        List r0 = r13;
        if (r0 != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L28;
        Iterator r14 = r13.iterator();
    L21:
        if (r14.hasNext() == false) goto L25;
        Object r15 = r14.next();
        if (c((com.bytedance.android.shopping.api.image.d) r15, r11, r12) == false) goto L21;
    L26:
        if (r15 == null) goto L28;
        return true;
    L25:
        r15 = null;
    L28:
        return false;
    L14:
        if (r0.isEmpty() == true) goto L17;
        r1 = false;
        goto L18
    L31:
        return a(r10.e(), r11, r12);
    }

    public static final boolean c(com.bytedance.android.shopping.api.image.d r10, com.bytedance.android.ec.core.imagex.r r11, com.bytedance.android.shopping.api.image.q r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$matchIn");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        List r0 = r10.b();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L39;
        List r13 = r10.a();
        if (r13 == null) goto L27;
        Double r14 = (Double) DeviceScore.b.getValue();
        Intrinsics.checkNotNullParameter(r13, "$this$operationIn");
        if ((!r13.isEmpty()) == false) goto L24;
        Iterator r15 = r13.iterator();
    L16:
        if (r15.hasNext() == false) goto L20;
        Object r16 = r15.next();
        if (((com.bytedance.android.shopping.api.image.c) r16).a(r14) == false) goto L16;
    L22:
        if (((com.bytedance.android.shopping.api.image.c) r16) == null) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == true) goto L27;
        boolean r18 = true;
    L28:
        if (r18 == true) goto L39;
        if (r10.c() != null) goto L33;
    L37:
        boolean r19 = false;
    L38:
        if (r19 == true) goto L39;
        boolean r20 = r10.e(r11, r12);
    L42:
        if (Intrinsics.areEqual(r10.d(), Boolean.TRUE) == false) goto L46;
        if (r20 == true) goto L50;
        return true;
    L50:
        return false;
    L46:
        return r20;
    L33:
        if (r11.b == null) goto L37;
        if ((!Intrinsics.areEqual(r10.c(), r11.b)) == false) goto L37;
        r19 = true;
        goto L38
    L20:
        r16 = null;
    L24:
        r17 = false;
    L27:
        r18 = false;
    L39:
        r20 = false;
        goto L42
    L5:
        if (com.bytedance.android.shopping.api.image.y.a(r0, Integer.valueOf(TTNetInit.getEffectiveConnectionType())) == true) goto L7;
        r1 = true;
        goto L8
    }
}
