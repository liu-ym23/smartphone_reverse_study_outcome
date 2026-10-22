package com.obric.oui.material;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001f\u0010\b\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u000e\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0007\u001a!\u0010\u0010\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u001a\u001f\u0010\u0013\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\u0013\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0016H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"applyBackdropMaterial", "", "Landroid/view/View;", "apply", "", "isBackdropView", "srcType", "", "dispatchApplyContentMaterial", "", "Landroid/view/ViewGroup;", "([Landroid/view/ViewGroup;Z)V", "", "Lcom/obric/oui/material/MaterialOwner;", "dispatchBackdropSrcType", "([Landroid/view/ViewGroup;I)V", "dispatchBackdropTarget", "view", "([Landroid/view/ViewGroup;Landroid/view/View;)V", "dispatchBackdropTargetType", "forEachMaterialOwner", "action", "Lkotlin/Function1;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {
    public static final void a(View r1, boolean r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        OMaterialHelper.a(r1, r3, 1);
        return;
    L5:
        OMaterialHelper.a(r1, 0, 1);
    }

    public static final void a(View r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r3 == false) goto L5;
        l.a(r1, r2);
        return;
    L5:
        l.b(r1, r2);
    }

    public static final void a(Iterable<? extends h> r3, int r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).b(r4);
        goto L4
    }

    public static final void a(Iterable<? extends h> r3, View r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin")).setBackdropTarget(r4);
        goto L4
    }

    public static final void a(ViewGroup[] r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L9;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.b(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void a(ViewGroup[] r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L9;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.setBackdropTarget(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
