package com.bytedance.android.ec.common.impl.sku.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements n.b {
    public final /* synthetic */ SpecItemGroupLayout a;
    public final /* synthetic */ SkuInfoVO b;

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void a() {
        String[] r0 = this.a.c;
        if (r0 != null) goto L5;
        return;
    L5:
        List<SpecInfo> r1 = this.b.getSpecInfoList();
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r11 = r1.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add(((SpecInfo) r11.next()).getDefaultSelect());
        goto L7
    L9:
        int r12 = r0.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L18;
        if (ArraysKt.getOrNull(r0, r13) != null) goto L17;
        if (Intrinsics.areEqual((Boolean) CollectionsKt.getOrNull(r10, r13), Boolean.TRUE) == false) goto L17;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L57;
        List<n> r15 = this.a.d;
        ArrayList r16 = new ArrayList();
        Iterator r17 = ((ArrayList) r15).iterator();
        int r18 = 0;
    L22:
        if (r17.hasNext() == false) goto L30;
        Object r19 = r17.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        n r21 = (n) r19;
        if (Intrinsics.areEqual((Boolean) CollectionsKt.getOrNull(r10, r18), Boolean.TRUE) == false) goto L29;
        r16.add(r19);
    L29:
        r18 = r20;
        goto L22
    L30:
        Iterator r22 = r16.iterator();
    L32:
        if (r22.hasNext() == false) goto L82;
        n r23 = (n) r22.next();
        if (r23.h == true) goto L32;
        int r24 = r23.f.size();
        int r25 = 0;
    L38:
        if (r25 >= r24) goto L45;
        n.c r26 = (n.c) ListProtector.get(r23.f, r25);
        r25 = r25 + 1;
        View r27 = r23.getChildAt(r25);
        if ((r27 instanceof TextView) == true) goto L42;
        r27 = null;
    L42:
        TextView r28 = (TextView) r27;
        if (r26.a == false) goto L38;
    L46:
        if (r26 == null) goto L32;
        if (r28 == null) goto L32;
        String r29 = r26.b;
        n.c r30 = r23.g;
        if (r30 == null) goto L51;
        String r31 = r30.b;
    L53:
        if ((!Intrinsics.areEqual(r29, r31)) == false) goto L32;
        r23.e(null);
        r23.g = r26;
        r23.h = false;
        r23.b(r28, r26, r26.b);
        n.b r32 = r23.k;
        if (r32 == null) goto L32;
        r32.d(r23.j, r23.g, false);
        goto L32
    L51:
        r31 = null;
        goto L53
    L45:
        r26 = null;
        r28 = null;
        goto L46
    L82:
        return;
    L57:
        return;
    L17:
        r13 = r13 + 1;
        goto L11
    L18:
        r14 = false;
        goto L19
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void c() {
        Iterator r0 = ((ArrayList) this.a.d).iterator();
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L26;
        Object r11 = r0.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        n r13 = (n) r11;
        SpecInfo r14 = (SpecInfo) CollectionsKt.getOrNull(this.b.getSpecInfoList(), r10);
        if (r14 == null) goto L11;
        Boolean r15 = r14.getDefaultSelect();
    L12:
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r15, r16) == false) goto L25;
        if (r14 == null) goto L16;
        Boolean r17 = r14.getHideSpec();
    L18:
        if (Intrinsics.areEqual(r17, r16) == false) goto L25;
        if (r13.g == null) goto L25;
        r13.g = null;
        r13.h = false;
        r13.e(null);
        n.b r18 = r13.k;
        if (r18 == null) goto L25;
        r18.d(r13.j, r13.g, false);
        goto L25
    L16:
        r17 = null;
    L25:
        r10 = r12;
        goto L4
    L11:
        r15 = null;
        goto L12
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void b(int r10) {
        SpecItemGroupLayout.d r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.a(r10);
        return;
    }

    public l(SpecItemGroupLayout r1, SkuInfoVO r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.n.b
    public final void d(int r12, n.c r13, boolean r14) {
        SpecItemGroupLayout r15 = this.a;
        String[] r0 = r15.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r13 == null) goto L7;
        String r16 = r13.b;
    L8:
        r0[r12] = r16;
        n r17 = (n) CollectionsKt.getOrNull(r15.d, r12);
        if (r17 != null) goto L11;
    L45:
        SpecItemGroupLayout.b r18 = this.a.f;
        if (r18 == null) goto L57;
        r18.a(r0);
        return;
    L57:
        return;
    L11:
        if (r17.getVisibility() != 0) goto L13;
        boolean r19 = true;
    L14:
        if (r19 != true) goto L45;
        Iterator<T> r110 = this.a.d.iterator();
        int r10 = 0;
    L17:
        if (r110.hasNext() == false) goto L45;
        Object r11 = r110.next();
        int r20 = r10 + 1;
        if (r10 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        n r21 = (n) r11;
        if (r10 == r12) goto L44;
        cg.g r22 = this.a.b;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r0, "checkIdArray");
        String[] r23 = (String[]) Arrays.copyOf(r0, r0.length);
        int r24 = r21.getChildCount();
        int r25 = r21.i;
    L24:
        if (r25 >= r24) goto L44;
        int r26 = r25 - r21.i;
        if (r22 == null) goto L43;
        if (r26 >= r21.f.size()) goto L43;
        n.c r27 = (n.c) ListProtector.get(r21.f, r26);
        r23[r21.j] = r27.b;
        r27.a = r22.a(r23);
        if (TextUtils.equals(r0[r21.j], r27.b) == true) goto L32;
    L34:
        View r28 = r21.getChildAt(r25);
        if (r28 == null) goto L42;
        TextView r29 = (TextView) r28;
        n.c r111 = r21.g;
        if (r111 == null) goto L39;
        String r112 = r111.b;
    L40:
        r21.b(r29, r27, r112);
        goto L43
    L39:
        r112 = null;
        goto L40
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L32:
        if (r27.a == true) goto L34;
        r21.g = null;
        r21.h = false;
    L43:
        r25 = r25 + 1;
    L44:
        r10 = r20;
        goto L17
    L13:
        r19 = false;
        goto L14
    L7:
        r16 = null;
        goto L8
    }
}
