package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.Postprocessor;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s0 {
    public static final /* synthetic */ int f = 0;
    public Postprocessor a;
    public Function1<? super File, Unit> b;
    public RequestListener c;
    public final Object d;
    public final r e;

    public static final class a {
    }

    static {
    }

    public static void b(s0 r12) {
        Object r0 = r12.d;
        if (r0 == null) goto L46;
        boolean r1 = r0 instanceof String;
        String r10 = null;
        if (r1 == false) goto L8;
    L21:
        if (r1 == false) goto L25;
        r10 = (String) r0;
    L23:
        String r11 = r10;
        if (r11 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r13 == true) goto L47;
        ImageExtensionsKt.B(r11, r12.e, null, null, null, r12.c, r12.a, false, 64);
        return;
    L47:
        return;
    L32:
        if (r11.length() == 0) goto L35;
        r13 = false;
        goto L36
    L25:
        if ((r0 instanceof ECUrlModel) == true) goto L27;
        r0 = null;
    L27:
        ECUrlModel r14 = (ECUrlModel) r0;
        if (r14 == null) goto L23;
        r10 = r14.getFirstUrl();
        goto L23
    L8:
        if ((r0 instanceof ECUrlModel) == true) goto L21;
        if ((r0 instanceof List) == false) goto L45;
        Iterator r15 = ((List) r0).iterator();
    L14:
        if (r15.hasNext() == false) goto L48;
        Object r16 = r15.next();
        if ((r16 instanceof String) == true) goto L18;
        r16 = null;
    L18:
        String r17 = a2.d((String) r16);
        if (r17 == null) goto L14;
        ImageExtensionsKt.A(r17, r12.e, null, null, null, r12.c, r12.a, true, null);
        goto L14
    L48:
        return;
    L45:
        return;
    }

    public final b a(Function1 r13) {
        Object r0 = this.d;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r13;
        if ((r0 instanceof String) == false) goto L11;
        String r14 = a2.d((String) r0);
        if (r14 == null) goto L38;
        r r1 = this.e;
        final Function1<? super File, Unit> r10 = this.b;
        final Priority r11 = null;
        final String r12 = null;
        KProperty[] r15 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r14, "$this$fetchImageToDisk");
        final ResizeOptions r16 = ImageExtensionsKt.i(null, null);
        final u r17 = ImageExtensionsKt.k(null, r1);
        r17.B();
        r17.C(r16);
        final b r18 = new b(0);
        n0.c(ImageExtensionsKt.l(), r14, r16, r17, new ImageExtensionsKt$fetchImageToDisk$3(r17, r16, r11, r12, r10, r18));
        return r18;
    L38:
        return null;
    L11:
        boolean r19 = r0 instanceof ECUrlModel;
        if (r19 == false) goto L14;
    L17:
        boolean r20 = true;
        if (r19 == false) goto L21;
        List r110 = ((ECUrlModel) r0).getUrlList();
    L28:
        List r21 = r110;
        if (r21 != null) goto L31;
    L34:
        if (r20 == false) goto L36;
        return null;
    L36:
        r r22 = this.e;
        final Function1<? super File, Unit> r23 = this.b;
        final Priority r24 = null;
        final String r25 = null;
        KProperty[] r26 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r110, "$this$fetchImageToDisk");
        final ResizeOptions r27 = ImageExtensionsKt.i(null, null);
        final u r28 = ImageExtensionsKt.k(null, r22);
        r28.B();
        r28.C(r27);
        final b r29 = new b(0);
        n0.d(ImageExtensionsKt.l(), r110, r27, r28, new ImageExtensionsKt$fetchImageToDisk$1(r28, r27, r24, r25, r23, r29));
        return r29;
    L31:
        if (r21.isEmpty() == true) goto L34;
        r20 = false;
        goto L34
    L21:
        if ((r0 instanceof List) == false) goto L27;
        r110 = (List) r0;
        if ((!r110.isEmpty()) == false) goto L27;
        if ((CollectionsKt.first(r110) instanceof String) == true) goto L28;
    L27:
        r110 = null;
        goto L28
    L14:
        if ((r0 instanceof List) == true) goto L17;
        return null;
    }

    public s0(Object r1, r r10) {
        this.d = r1;
        this.e = r10;
    }
}
