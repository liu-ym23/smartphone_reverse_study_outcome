package com.obric.oui.tab;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007JH\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/tab/OTabLayoutHelper;", "", "()V", "MAX_SHOW_TAB_COUNT", "", "MAX_TAB_COUNT_MIX_MODE", "", "configScrollableTabWidth", "", "tabLayout", "Lcom/obric/oui/tab/OTabLayout;", "resolveEdgeFadeOverlayColor", "view", "Landroid/view/View;", "updateEdgeFadeBounds", "tabContainer", "Landroid/view/ViewGroup;", "scrollX", "width", "height", "showLeftFade", "", "showRightFade", "outLayerBounds", "Landroid/graphics/RectF;", "outOverlayBounds", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14551a = null;

    static {
        f14551a = new b();
    }

    private b() {
    }

    @JvmStatic
    public static final void a(ViewGroup r13, float r14, int r15, int r16, boolean r17, boolean r18, RectF r19, RectF r20) {
        Intrinsics.checkNotNullParameter(r13, "tabContainer");
        Intrinsics.checkNotNullParameter(r19, "outLayerBounds");
        Intrinsics.checkNotNullParameter(r20, "outOverlayBounds");
        int r3 = r13.getChildCount();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r5 >= r3) goto L19;
        int r8 = r5 + 1;
        View r9 = r13.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r9, com.obric.oui.common.style.b.class) == false) goto L9;
        List<k> r10 = ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.common.style.b.class, "com.obric.memorydata.plugin")).getCurrentShadows();
        if (r10 == null) goto L9;
        Iterator<k> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L9;
        k r12 = (k) ZeusTransformUtils.preCheckCast(r11.next(), k.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L12;
        if (r12.h() == false) goto L12;
        r6 = Math.max(r6, (int) Math.ceil((Math.abs(r12.c()) + r12.b()) + r12.e()));
        r7 = Math.max(r7, (int) Math.ceil((Math.abs(r12.d()) + r12.b()) + r12.e()));
    L9:
        r5 = r8;
        goto L3
    L19:
        if (r17 == false) goto L21;
        int r0 = 0;
    L22:
        float r1 = r14 - r0;
        float r21 = r15 + r14;
        if (r18 == true) goto L26;
        r4 = r6;
    L26:
        float r22 = r7;
        r19.set(r1, -r22, r4 + r21, r16 + r22);
        if (r17 == false) goto L29;
        float r2 = r19.left;
    L30:
        if (r18 == false) goto L32;
        r21 = r19.right;
    L32:
        r20.set(r2, r19.top, r21, r19.bottom);
        return;
    L29:
        r2 = r14;
        goto L30
    L21:
        r0 = r6;
        goto L22
    }
}
