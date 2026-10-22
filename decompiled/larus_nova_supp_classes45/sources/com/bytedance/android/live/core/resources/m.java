package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final /* synthetic */ KProperty[] a = null;
    public static final vh7.i b = null;

    static {
        KMutableProperty1 r0 = Reflection.mutableProperty1(new MutablePropertyReference1Impl(m.class, "mCdnDomainOpt", "getMCdnDomainOpt(Lcom/bytedance/android/live/core/resources/ResourceModel;)Ljava/lang/Boolean;", 1));
        a = new KProperty[]{r0};
        int r1 = vh7.a.a;
        b = new vh7.i(new vh7.a.b(r0.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<String> a(l r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$getUrlList");
        Intrinsics.checkNotNullParameter(r5, "$this$mCdnDomainOpt");
        vh7.i r0 = b;
        KProperty r1 = a[0];
        l r2 = r5;
        ArrayList r3 = 0;
        if ((r2 instanceof FlexModelBase) == true) goto L5;
        r2 = null;
    L5:
        FlexModelBase r4 = (FlexModelBase) r2;
        if (r4 == null) goto L8;
        Object r6 = r4.get(r0.a);
    L10:
        if (Intrinsics.areEqual((Boolean) r6, Boolean.TRUE) == false) goto L56;
        if (r5.getUrlList().isEmpty() == false) goto L56;
        List r7 = w12.a.a;
        String r8 = r5.getUri();
        List<String> r9 = r5.getUrlList();
        if (TypeIntrinsics.isMutableList(r9) == false) goto L18;
        r3 = r9;
    L18:
        if (w12.a.e == true) goto L35;
        if (w12.a.c == null) goto L33;
        if (r8 == null) goto L33;
        List r11 = w12.a.a;
        if (((ArrayList) r11).isEmpty() == false) goto L26;
        w12.a.a();
    L26:
        ArrayList r12 = new ArrayList();
        if (r11 == null) goto L32;
        Iterator r13 = ((ArrayList) r11).iterator();
    L30:
        if (r13.hasNext() == false) goto L32;
        r12.add(((String) r13.next()) + r8);
    L32:
        r3 = r12;
    L54:
        r5.setUrlList(r3);
    L33:
        r3 = new ArrayList();
        goto L54
    L35:
        if (w12.a.c == null) goto L53;
        if (r8 == null) goto L53;
        List r14 = w12.a.a;
        if (((ArrayList) r14).isEmpty() == false) goto L41;
        w12.a.a();
    L41:
        if (r3 == 0) goto L47;
        if (r14 == null) goto L54;
        Iterator r15 = ((ArrayList) r14).iterator();
    L45:
        if (r15.hasNext() == false) goto L54;
        r3.add(((String) r15.next()) + r8);
        goto L45
    L47:
        r3 = new ArrayList();
        if (r14 == null) goto L54;
        Iterator r16 = ((ArrayList) r14).iterator();
    L51:
        if (r16.hasNext() == false) goto L54;
        r3.add(((String) r16.next()) + r8);
    L53:
        r3 = new ArrayList();
    L56:
        return r5.getUrlList();
    L8:
        r6 = null;
        goto L10
    }

    public static final void b(l r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$mCdnDomainOpt");
        vh7.i r0 = b;
        KProperty r1 = a[0];
        l r5 = r3;
        if ((r5 instanceof FlexModelBase) == true) goto L5;
        r5 = null;
    L5:
        FlexModelBase r6 = (FlexModelBase) r5;
        if (r6 == null) goto L9;
        r6.set(r0.a, r4);
        return;
    }
}
