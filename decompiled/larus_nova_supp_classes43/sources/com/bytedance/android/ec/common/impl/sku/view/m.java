package com.bytedance.android.ec.common.impl.sku.view;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements n.b {
    public final /* synthetic */ SpecItemGroupLayout a;
    public final /* synthetic */ SkuInfoVO b;

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void a() {
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void c() {
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void b(int r10) {
        SpecItemGroupLayout.d r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.a(r10);
        return;
    }

    public m(SpecItemGroupLayout r1, SkuInfoVO r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void d(int r11, n.c r12, boolean r13) {
        String[] r0 = this.a.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r12 == null) goto L7;
        String r10 = r12.b;
    L8:
        r0[r11] = r10;
        int r14 = 0;
        if (r13 == true) goto L43;
        Iterator<T> r15 = this.b.getSpecInfoList().iterator();
        int r16 = 0;
        boolean r17 = false;
    L12:
        if (r15.hasNext() == false) goto L44;
        Object r18 = r15.next();
        int r19 = r16 + 1;
        if (r16 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        SpecInfo r20 = (SpecInfo) r18;
        Boolean r21 = r20.getDefaultSelect();
        Boolean r22 = Boolean.TRUE;
        if (Intrinsics.areEqual(r21, r22) == false) goto L42;
        if (r16 == r11) goto L42;
        n r23 = (n) CollectionsKt.getOrNull(this.a.d, r16);
        if (Intrinsics.areEqual(r20.getHideSpec(), r22) == false) goto L35;
        if (r12 == null) goto L27;
        if (r23 == null) goto L24;
        n.c r24 = r23.d(r0, this.a.b);
    L25:
        if (r24 == null) goto L33;
        r0[r16] = r24.b;
    L33:
        r17 = true;
        goto L42
    L24:
        r24 = null;
        goto L25
    L27:
        if (r23 != null) goto L29;
    L32:
        r0[r16] = null;
        goto L33
    L29:
        if (r23.g == null) goto L32;
        r23.f(null);
        r23.g = null;
        goto L32
    L35:
        if (ArraysKt.getOrNull(r0, r16) != null) goto L42;
        if (r12 == null) goto L42;
        if (r23 == null) goto L39;
        n.c r25 = r23.d(r0, this.a.b);
    L40:
        if (r25 == null) goto L33;
        r0[r16] = r25.b;
        goto L33
    L39:
        r25 = null;
    L42:
        r16 = r19;
    L44:
        n r110 = (n) CollectionsKt.getOrNull(this.a.d, r11);
        if (r110 != null) goto L47;
    L63:
        SpecItemGroupLayout.b r111 = this.a.f;
        if (r111 == null) goto L78;
        r111.a(r0);
        return;
    L78:
        return;
    L47:
        if (r110.getVisibility() != 0) goto L49;
        boolean r112 = true;
    L50:
        if (r112 != true) goto L63;
        Iterator<T> r113 = this.a.d.iterator();
    L53:
        if (r113.hasNext() == false) goto L63;
        Object r114 = r113.next();
        int r1 = r14 + 1;
        if (r14 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        n r115 = (n) r114;
        if (r14 == r11) goto L60;
        r115.g(r0, this.a.b);
    L62:
        r14 = r1;
        goto L53
    L60:
        if (r17 == false) goto L62;
        r115.g(r0, this.a.b);
        goto L62
    L49:
        r112 = false;
        goto L50
    L43:
        r17 = false;
        goto L44
    L7:
        r10 = null;
        goto L8
    }
}
