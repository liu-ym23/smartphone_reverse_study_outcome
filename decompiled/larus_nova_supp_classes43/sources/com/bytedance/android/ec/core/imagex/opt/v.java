package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.imagex.common.ImageUrlParser;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v extends com.bytedance.android.ec.core.imagex.h {
    public static final a a = null;
    public static final boolean b = false;
    public static final b c = null;

    public static final class a implements ReadOnlyProperty<Object, cj.b> {
        public cj.b a;

        public a() {
        }

        public final cj.b getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "property");
            cj.b r12 = this.a;
            if (r12 == null) goto L5;
            return r12;
        L5:
            int r13 = ECSdk.a;
            cj.b r14 = (cj.b) ECSdk.a(cj.b.class);
            if (r14 == null) goto L11;
            if (StringsKt.contains$default(r14.getClass().getSimpleName(), "DefaultImpl_", false, 2, null) == true) goto L12;
            this.a = r14;
            return r14;
        L12:
            return r14;
        L11:
            return null;
        }
    }

    public static final class b {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(b.class, "shoppingPerfOptService", "getShoppingPerfOptService()Lcom/bytedance/android/ec/host/api/opt/IShoppingPerfOptService;", 0))};
        }

        public b() {
        }
    }

    @Override // com.bytedance.android.ec.core.imagex.h
    public final String b() {
        return "host_dynamic_opt_middleware";
    }

    static {
        c = new b();
        a = new a();
        int r0 = ECSdk.a;
        cj.b r1 = (cj.b) ECSdk.a(cj.b.class);
        if (r1 == null) goto L6;
        r1.b();
    L6:
        if (Intrinsics.areEqual(null, Boolean.TRUE) == true) goto L9;
        w.c.getClass();
        b = w.a();
        return;
    L9:
        throw null;
    }

    public v() {
    }

    @Override // com.bytedance.android.ec.core.imagex.h
    public final void a(com.bytedance.android.ec.core.imagex.r r11, ImageUrlParser r12) {
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        Intrinsics.checkNotNullParameter(r12, "imageUrlParser");
        if (b == true) goto L5;
        return;
    L5:
        if (r12.v == false) goto L82;
        w r1 = w.c;
        r1.getClass();
        if (w.a() == false) goto L65;
        com.bytedance.android.shopping.api.image.k r10 = (com.bytedance.android.shopping.api.image.k) w.b.getValue(r1, w.a[0]);
        if (r10 == null) goto L65;
        Intrinsics.checkNotNullParameter(r10, "$this$match");
        Intrinsics.checkNotNullParameter(r12, "imageUrlParser");
        List r0 = r10.a();
        String r13 = null;
        if (r0 == null) goto L61;
        Iterator r14 = r0.iterator();
    L15:
        if (r14.hasNext() == false) goto L61;
        com.bytedance.android.shopping.api.image.i r15 = (com.bytedance.android.shopping.api.image.i) r14.next();
        List r16 = r15.a();
        if (r16 == null) goto L58;
        Iterator r17 = r16.iterator();
    L20:
        if (r17.hasNext() == false) goto L56;
        Object r18 = r17.next();
        com.bytedance.android.shopping.api.image.j r19 = (com.bytedance.android.shopping.api.image.j) r18;
        if (r12.f(r19.b(), r19.c()) == false) goto L53;
        String r20 = r19.a();
        boolean r21 = true;
        if (r20 != null) goto L27;
    L30:
        boolean r22 = true;
    L31:
        if (r22 == true) goto L39;
        String r23 = r19.a();
        if (r11 == null) goto L35;
        String r24 = r11.f;
    L37:
        if ((!Intrinsics.areEqual(r23, r24)) == false) goto L39;
    L35:
        r24 = null;
    L39:
        String r25 = r19.d();
        if (r25 != null) goto L42;
    L45:
        boolean r26 = true;
    L46:
        if (r26 == true) goto L54;
        String r27 = r19.d();
        if (r11 == null) goto L50;
        String r28 = r11.g;
    L52:
        if ((!Intrinsics.areEqual(r27, r28)) == false) goto L54;
    L50:
        r28 = null;
    L54:
        if (r21 == false) goto L20;
    L57:
        com.bytedance.android.shopping.api.image.j r29 = (com.bytedance.android.shopping.api.image.j) r18;
    L59:
        if (r29 == null) goto L15;
        r13 = r15.b();
        goto L61
    L42:
        if (StringsKt.isBlank(r25) == true) goto L45;
        r26 = false;
        goto L46
    L27:
        if (StringsKt.isBlank(r20) == true) goto L30;
        r22 = false;
    L53:
        r21 = false;
        goto L54
    L56:
        r18 = null;
        goto L57
    L58:
        r29 = null;
    L61:
        if (r13 == null) goto L65;
        if (r12.i(r13, r12.f) == false) goto L65;
        r12.f = r13;
    L65:
        b r110 = c;
        r110.getClass();
        cj.b r111 = (cj.b) a.getValue(r110, b.a[0]);
        if (r111 == null) goto L81;
        r111.b();
        return;
    L81:
        return;
    }
}
