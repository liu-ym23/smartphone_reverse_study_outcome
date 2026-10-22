package com.bytedance.android.live.revlink.impl.multianchor.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.livesdk.link.model.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements m {
    public f31.f a;
    public final Map<String, k> b;
    public final Map<String, Boolean> c;
    public final Map<String, Boolean> d;
    public final FrameLayout e;
    public final Context f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        k r1 = (k) ((Map.Entry) r0.next()).getValue();
        r1.c.removeView(r1.a);
        r1.c.removeView(r1.b);
        goto L4
    L6:
        ((LinkedHashMap) this.b).clear();
    }

    public final void d(f31.f r8) {
        Intrinsics.checkNotNullParameter(r8, "layoutStatus");
        this.a = r8;
        LinkedHashMap r0 = new LinkedHashMap();
        jy0.b.c("WindowServiceImpl", "updateLayoutStatus " + r8.a, null, 4);
        List<f31.k> r9 = r8.a;
        if (r9 == null) goto L39;
        Iterator<T> r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L39;
        f31.k r1 = (f31.k) r10.next();
        k r2 = (k) ((LinkedHashMap) this.b).get(r1.a);
        if (r2 != null) goto L34;
        r2 = new k(this.f, this.e);
        Map<String, Boolean> r3 = this.c;
        String r4 = r1.a;
        if (r3 == null) goto L32;
        if (r3.containsKey(r4) == false) goto L18;
        ViewUtilsKt.g(r2.a, !Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.c).get(r1.a), Boolean.TRUE));
        Map<String, Boolean> r5 = this.c;
        String r6 = r1.a;
        if (r5 == null) goto L17;
        TypeIntrinsics.asMutableMap(r5).remove(r6);
    L19:
        Map<String, Boolean> r7 = this.d;
        String r12 = r1.a;
        if (r7 == null) goto L30;
        if (r7.containsKey(r12) == false) goto L28;
        ViewUtilsKt.g(r2.b, Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.d).get(r1.a), Boolean.TRUE));
        Map<String, Boolean> r13 = this.d;
        String r14 = r1.a;
        if (r13 == null) goto L27;
        TypeIntrinsics.asMutableMap(r13).remove(r14);
        goto L34
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L28:
        ViewUtilsKt.g(r2.b, !r1.h);
        goto L34
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L18:
        ViewUtilsKt.g(r2.a, false);
        goto L19
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L34:
        if (b(r1.a, r2) == true) goto L36;
        ViewUtilsKt.g(r2.b, !r1.h);
    L36:
        r2.a(r1);
        String r15 = r1.a;
        if (r15 == null) goto L6;
        r0.put(r15, r2);
    L39:
        Iterator r16 = ((LinkedHashMap) this.b).entrySet().iterator();
    L41:
        if (r16.hasNext() == false) goto L46;
        Map.Entry r17 = (Map.Entry) r16.next();
        String r18 = (String) r17.getKey();
        k r19 = (k) r17.getValue();
        if (r0.containsKey(r18) == true) goto L41;
        r19.c.removeView(r19.a);
        r19.c.removeView(r19.b);
        goto L41
    L46:
        ((LinkedHashMap) this.b).clear();
        this.b.putAll(r0);
    }

    public l(FrameLayout r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.e = r2;
        this.f = r3;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.anchorimpl.m
    public final void a(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "linkerID");
        jy0.b.c("WindowServiceImpl", "setStatus linkerID: " + r6 + ", isForeGround:" + r7, null, 4);
        if (this.b.containsKey(r6) == false) goto L16;
        i11.b r0 = y.a();
        if (r0 == null) goto L10;
        p r1 = r0.getGuestInfo(u.c(), null);
        if (r1 == null) goto L10;
        r1.getInteractId();
    L10:
        if (b(r6, (k) ((LinkedHashMap) this.b).get(r6)) == false) goto L12;
        return;
    L12:
        k r2 = (k) ((LinkedHashMap) this.b).get(r6);
        if (r2 == null) goto L15;
        ViewUtilsKt.g(r2.a, !r7);
    L15:
        jy0.b.c("WindowServiceImpl", "setStatus found rtcContent: " + ((k) ((LinkedHashMap) this.b).get(r6)), null, 4);
        return;
    L16:
        this.c.put(r6, Boolean.valueOf(r7));
        jy0.b.c("WindowServiceImpl", "setStatus cache", null, 4);
    }

    public final boolean b(String r6, k r7) {
        i11.b r0 = y.a();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L8;
        p r2 = r0.getGuestInfo(u.c(), null);
        if (r2 == null) goto L8;
        r2.getInteractId();
    L8:
        if (r6 != null) goto L10;
        return false;
    L10:
        RevLinkWindowRegionContext r3 = com.bytedance.android.live.revlink.impl.global.b.f0();
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r4 = r3.getPartnerService();
        if (r4 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r5 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r4.getValue();
    L16:
        if (r5 == null) goto L18;
        boolean r8 = r5.n();
    L19:
        if (r8 == false) goto L51;
        i11.b r9 = y.a();
        if (r9 == null) goto L25;
        p r10 = r9.getGuestInfo(u.c(), null);
        if (r10 == null) goto L25;
        String r12 = r10.getLinkMicIdStr();
    L27:
        if ((!Intrinsics.areEqual(r6, r12)) == false) goto L33;
        if (r7 == null) goto L30;
        ViewUtilsKt.g(r7.a, false);
    L30:
        if (r7 == null) goto L32;
        ViewUtilsKt.g(r7.b, false);
    L32:
        return true;
    L33:
        if (r7 == null) goto L50;
        i11.b r13 = y.a();
        if (r13 == null) goto L40;
        p r14 = r13.getGuestInfo(u.c(), null);
        if (r14 == null) goto L40;
        r14.getInteractId();
    L40:
        if (r7.a.getParent() != null) goto L42;
        r7.c.addView(r7.a, new FrameLayout.LayoutParams(-1, -1));
    L42:
        ViewGroup.LayoutParams r15 = r7.a.getLayoutParams();
        if ((r15 instanceof FrameLayout.LayoutParams) == false) goto L46;
        r1 = r15;
    L46:
        FrameLayout.LayoutParams r16 = (FrameLayout.LayoutParams) r1;
        if (r16 != null) goto L49;
        r16 = new FrameLayout.LayoutParams(-1, -1);
    L49:
        r16.width = -1;
        r16.height = -1;
        r16.leftMargin = 0;
        r16.topMargin = 0;
        r7.a.setLayoutParams(r16);
    L50:
        return false;
    L25:
        r12 = null;
        goto L27
    L51:
        f31.f r17 = this.a;
        if (r17 == null) goto L61;
        List<f31.k> r18 = r17.a;
        if (r18 == null) goto L61;
        Iterator<T> r19 = r18.iterator();
    L57:
        if (r19.hasNext() == false) goto L61;
        f31.k r20 = (f31.k) r19.next();
        k r22 = (k) ((LinkedHashMap) this.b).get(r20.a);
        if (r22 == null) goto L57;
        r22.a(r20);
    L61:
        return false;
    L18:
        r8 = false;
    L15:
        r5 = null;
        goto L16
    }
}
