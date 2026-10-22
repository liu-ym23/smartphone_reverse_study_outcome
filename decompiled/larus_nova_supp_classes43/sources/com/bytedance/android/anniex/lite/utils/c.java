package com.bytedance.android.anniex.lite.utils;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.ui.j;
import com.bytedance.android.anniex.container.ui.l;
import com.bytedance.android.anniex.lite.container.AnnieXLiteContainer;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import kotlin.jvm.internal.Intrinsics;
import s26.d;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final KitType a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        UGLogger.a.c("getKitTypeFromSchema", "uri.scheme: " + r10.getScheme() + " uri: " + r10);
        String r11 = r10.getScheme();
        if (r11 == null) goto L24;
        int r0 = r11.hashCode();
        if (r0 == (-1772600516)) goto L20;
        if (r0 == 3213448) goto L16;
        if (r0 != 99617003) goto L24;
        if (r11.equals("https") == false) goto L24;
        return KitType.WEB;
    L16:
        if (r11.equals("http") == false) goto L24;
        return KitType.WEB;
    L20:
        if (r11.equals("lynxview") == false) goto L24;
        return KitType.LYNX;
    L24:
        return KitType.UNKNOWN;
    }

    public static final ia.c e(IBDXBridgeContext r1) {
        Intrinsics.checkNotNullParameter(r1, "bridgeContext");
        m16.b r10 = (m16.b) r1.getService(m16.b.class);
        if (r10 == null) goto L7;
        ia.c r11 = (ia.c) r10.c(ia.c.class);
        if ((r11 instanceof AnnieXLiteContainer) == false) goto L9;
        return r11;
    L9:
        return null;
    L7:
        return null;
    }

    public static final ia.c f(IBDXBridgeContext r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        m16.b r11 = (m16.b) r10.getService(m16.b.class);
        if (r11 == null) goto L16;
        ia.c r12 = (ia.c) r11.c(ia.c.class);
        if (r12 != null) goto L7;
        return null;
    L7:
        if ((r12 instanceof AnnieXLiteContainer) == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return null;
    L15:
        return r12;
    L9:
        if ((r12 instanceof ua.a) == true) goto L12;
        r1 = false;
        goto L13
    L16:
        return null;
    }

    public static final DialogFragment g(IBDXBridgeContext r1) {
        Intrinsics.checkNotNullParameter(r1, "bridgeContext");
        m16.b r10 = (m16.b) r1.getService(m16.b.class);
        if (r10 != null) goto L5;
        return null;
    L5:
        if ((r10.c(ia.c.class) instanceof AnnieXLiteContainer) == true) goto L7;
        return null;
    L7:
        return (DialogFragment) r10.c(DialogFragment.class);
    }

    public static final boolean h(ia.c r10, qa.a r11) {
        Intrinsics.checkNotNullParameter(r10, "pageContainer");
        Intrinsics.checkNotNullParameter(r11, "annieXContext");
        if (h.V() == true) goto L5;
        return false;
    L5:
        d r0 = d.c;
        com.bytedance.android.anniex.base.service.c r1 = d.c.d(r10.getBid(), com.bytedance.android.anniex.base.service.c.class);
        if (r1 != null) goto L8;
    L11:
        return false;
    L8:
        if (r1.G0(r11.h, r10) == false) goto L11;
        r1.H0(r11.h, r10);
        return true;
    }

    public static final void b(String r10, ia.c r11, Context r12) {
        Intrinsics.checkNotNullParameter(r10, "currentBid");
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "context");
        HybridLogger.m("XView", "init footer", null, null, 12);
        d r13 = d.c;
        if (d.c.d(r10, com.bytedance.android.anniex.base.service.d.class) == null) goto L6;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, "container");
        return;
    }

    public static final com.bytedance.android.anniex.base.service.d.b d(String r10, ia.c r11, View r12, Context r13, ab.b r14) {
        Intrinsics.checkNotNullParameter(r10, "currentBid");
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "uiModel");
        i r15 = null;
        HybridLogger.m("XView", "init title bar", null, null, 12);
        d r0 = d.c;
        com.bytedance.android.anniex.base.service.d r1 = d.c.d(r10, com.bytedance.android.anniex.base.service.d.class);
        if (r1 == null) goto L61;
        com.bytedance.android.anniex.base.service.d.b r16 = r1.I0(null, r11);
        if (r16 == null) goto L62;
        e26.b r17 = d.c.d(r10, e26.b.class);
        if (r17 == null) goto L9;
        boolean r18 = r17.l();
    L10:
        t36.d r19 = r11.getSchemaData();
        if (r19 == null) goto L13;
        boolean r20 = h.h0(r19);
    L15:
        if ((r16 instanceof l) == false) goto L17;
        l r21 = (l) r16;
    L18:
        if (r21 == null) goto L20;
        r21.a = r20;
    L20:
        if (r12 == null) goto L26;
        FrameLayout r22 = (FrameLayout) r12.findViewById(2131363017);
        if (r22 == null) goto L26;
        View r23 = r16.a(r13, r11);
        if (r23 == null) goto L26;
        r22.addView(r23);
    L26:
        if (r20 == false) goto L29;
        if (r18 == false) goto L29;
        r16.b(AnnieXRuntime.a().a());
    L60:
        return r16;
    L29:
        i r24 = r14.c;
        if (r24 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("hideNavBar");
        r24 = null;
    L33:
        Object r25 = r24.b;
        Boolean r26 = Boolean.TRUE;
        if (Intrinsics.areEqual(r25, r26) == true) goto L43;
        i r27 = r14.o;
        if (r27 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r27 = null;
    L40:
        if (Intrinsics.areEqual(r27.b, r26) == true) goto L43;
        if (Intrinsics.areEqual(((i) r14.c()).b, r26) == true) goto L43;
    L44:
        i r28 = r14.e;
        if (r28 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("navBarColor");
        r28 = null;
    L48:
        Integer r29 = (Integer) r28.b;
        if (r29 == null) goto L51;
        int r30 = r29.intValue();
    L52:
        r16.b(r30);
        i r31 = r14.l;
        if (r31 == null) goto L55;
        r15 = r31;
    L56:
        String r32 = (String) r15.b;
        if (r32 == null) goto L60;
        r16.c(r32);
        goto L60
    L55:
        Intrinsics.throwUninitializedPropertyAccessException("title");
        goto L56
    L51:
        r30 = AnnieXRuntime.a().a();
    L43:
        r16.e(false);
        goto L44
    L17:
        r21 = null;
        goto L18
    L13:
        r20 = false;
        goto L15
    L9:
        r18 = true;
        goto L10
    L62:
        return null;
    L61:
        return null;
    }

    public static final j c(String r17, ia.c r18, Window r19, View r20, Context r21, ab.b r22) {
        Intrinsics.checkNotNullParameter(r17, "currentBid");
        Intrinsics.checkNotNullParameter(r18, "container");
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "uiModel");
        i r10 = null;
        HybridLogger.m("XView", "init status bar", null, null, 12);
        if (r19 != null) goto L5;
        return null;
    L5:
        j r11 = new j(r19);
        d r1 = d.c;
        e26.b r0 = d.c.d(r17, e26.b.class);
        if (r0 == null) goto L8;
        boolean r12 = r0.l();
    L9:
        t36.d r13 = r18.getSchemaData();
        if (r13 == null) goto L12;
        boolean r14 = h.h0(r13);
    L13:
        int r15 = AnnieXRuntime.a().a();
        if ((1.0d - ((((((double) Color.red(r15)) * 0.299d) + (((double) Color.green(r15)) * 0.587d)) + (((double) Color.blue(r15)) * 0.114d)) / 255.0d)) >= 0.22d) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == false) goto L19;
        StatusFontMode r23 = StatusFontMode.DARK;
    L20:
        if (r20 == null) goto L24;
        FrameLayout r24 = (FrameLayout) r20.findViewById(2131363014);
        if (r24 == null) goto L24;
        Intrinsics.checkNotNullParameter(r21, "context");
        r11.d();
        FrameLayout r25 = new FrameLayout(r21);
        r25.setLayoutParams(new FrameLayout.LayoutParams(-1, j.b(r21)));
        r11.b = r25;
        r24.addView(r25);
    L24:
        if (r14 == false) goto L30;
        if (r12 == false) goto L30;
        int r26 = AnnieXRuntime.a().a();
        FrameLayout r27 = r11.b;
        if (r27 == null) goto L29;
        r27.setBackgroundColor(r26);
    L29:
        r11.c(r23);
    L81:
        return r11;
    L30:
        i r28 = r22.i;
        if (r28 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarBgColor");
        r28 = null;
    L34:
        Integer r29 = (Integer) r28.b;
        if (r29 != null) goto L43;
        i r30 = r22.j;
        if (r30 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("statusBarColor");
        r30 = null;
    L41:
        r29 = (Integer) r30.b;
        if (r29 != null) goto L43;
        int r31 = AnnieXRuntime.a().a();
    L45:
        FrameLayout r32 = r11.b;
        if (r32 == null) goto L48;
        r32.setBackgroundColor(r31);
    L48:
        i r33 = r22.k;
        if (r33 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("statusFontMode");
        r33 = null;
    L52:
        StatusFontMode r34 = (StatusFontMode) r33.b;
        if (r34 != null) goto L55;
    L65:
        r11.c(r23);
        i r35 = r22.o;
        if (r35 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("shouldFullScreen");
        r35 = null;
    L69:
        Object r36 = r35.b;
        Boolean r37 = Boolean.TRUE;
        if (Intrinsics.areEqual(r36, r37) == false) goto L72;
    L73:
        r11.e(true);
    L74:
        i r38 = r22.d;
        if (r38 == null) goto L77;
        r10 = r38;
    L79:
        if (Intrinsics.areEqual(r10.b, r37) == false) goto L81;
        r11.f(false);
        goto L81
    L77:
        Intrinsics.throwUninitializedPropertyAccessException("hideStatusBar");
        goto L79
    L72:
        if (Intrinsics.areEqual(((i) r22.c()).b, r37) == false) goto L74;
    L55:
        if (r34 == StatusFontMode.DEFAULT) goto L57;
        boolean r39 = true;
    L59:
        if (Boolean.valueOf(r39).booleanValue() == true) goto L62;
        r34 = null;
    L62:
        if (r34 == null) goto L65;
        r23 = r34;
        goto L65
    L57:
        r39 = false;
    L43:
        r31 = r29.intValue();
        goto L45
    L19:
        r23 = StatusFontMode.LIGHT;
        goto L20
    L16:
        r16 = false;
        goto L17
    L12:
        r14 = false;
        goto L13
    L8:
        r12 = true;
        goto L9
    }
}
