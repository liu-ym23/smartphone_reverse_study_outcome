package com.bytedance.android.anniex.container.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.p0;
import com.bytedance.ies.bullet.service.base.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Function0<Unit> {
        public final /* synthetic */ ia.c a;

        public final Object invoke() {
            this.a.close();
            return Unit.INSTANCE;
        }

        public a(ia.c r1) {
            this.a = r1;
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ ia.c a;

        public final Object invoke() {
            this.a.reload(null);
            return Unit.INSTANCE;
        }

        public b(ia.c r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static View a(ia.c r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        t36.d r0 = r10.getCurrentSchema();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(((y36.i) new p(r0, "error_page_style", null)).b, "host") == false) goto L7;
        HybridLogger.f("CustomViewUtil", "use host theme to create error view", null, 12);
        String r1 = "default_bid";
    L8:
        String r11 = r10.getViewType();
        s26.d r12 = s26.d.c;
        p0 r13 = s26.d.c.d(r1, p0.class);
        if (r13 == null) goto L19;
        Context r14 = r10.getSystemContext();
        if (r14 == null) goto L20;
        com.bytedance.ies.bullet.service.base.i r15 = r13.n(r14, r11);
        if (r15 == null) goto L21;
        View r16 = r15.a(new a(r10), new b(r10));
        if (r16 == null) goto L22;
        r16.setLayoutParams(r13.c0(r11));
        return r16;
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    L7:
        HybridLogger.f("CustomViewUtil", "use custom theme to create error view", null, 12);
        r1 = r10.getBid();
        goto L8
    }

    public static View b(ia.c r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        t36.d r0 = r10.getCurrentSchema();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(((y36.i) new p(r0, "loading_style", null)).b, "host") == false) goto L7;
        HybridLogger.f("CustomViewUtil", "use host theme to create loading view", null, 12);
        String r1 = "default_bid";
    L8:
        String r11 = r10.getViewType();
        s26.d r12 = s26.d.c;
        p0 r13 = s26.d.c.d(r1, p0.class);
        if (r13 == null) goto L22;
        Context r14 = r10.getSystemContext();
        if (r14 == null) goto L23;
        q r15 = r13.b(r14, r11);
        if (r15 == null) goto L24;
        View r16 = r15.getView();
        if (r16 == null) goto L25;
        FrameLayout.LayoutParams r17 = r13.B0(r11);
        if (r17 == null) goto L20;
        r16.setLayoutParams(r17);
    L20:
        return r16;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L7:
        HybridLogger.f("CustomViewUtil", "use custom theme to create loading view", null, 12);
        r1 = r10.getBid();
        goto L8
    }
}
