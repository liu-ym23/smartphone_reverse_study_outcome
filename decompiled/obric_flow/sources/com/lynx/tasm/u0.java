package com.lynx.tasm;

import android.view.accessibility.AccessibilityManager;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.UIBody;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final int H;
    public final boolean I;
    public final int J;
    public final int K;
    public final double L;
    public final boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10969c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f10972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f10974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f10975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f10976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f10977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f10978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f10979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f10980r;
    public final boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10981t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f10982u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f10983v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f10984w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f10985x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f10986y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f10987z;

    public u0(ReadableMap r10) {
        this.f = true;
        this.g = true;
        this.f10971i = true;
        this.f10972j = "50px";
        this.f10973k = true;
        this.f10976n = true;
        this.f10977o = true;
        this.f10983v = true;
        this.f10985x = false;
        this.f10986y = true;
        this.f10987z = true;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 20;
        this.I = false;
        this.J = -1;
        this.K = 0;
        this.L = -1.0d;
        this.M = true;
        this.f10967a = true;
        this.f10968b = false;
        this.d = "error";
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.hasKey("autoExpose") == false) goto L8;
        this.f10967a = r10.getBoolean("autoExpose");
    L8:
        if (r10.hasKey("pageVersion") == false) goto L11;
        this.d = r10.getString("pageVersion");
    L11:
        if (r10.hasKey("enableEventThrough") == false) goto L14;
        this.f10968b = r10.getBoolean("enableEventThrough");
    L14:
        if (r10.hasKey("defaultOverflowVisible") == false) goto L17;
        this.f10969c = r10.getBoolean("defaultOverflowVisible");
    L17:
        if (r10.hasKey("syncImageAttach") == false) goto L20;
        this.f = r10.getBoolean("syncImageAttach");
    L20:
        if (r10.hasKey("enableCheckLocalImage") == false) goto L23;
        this.g = r10.getBoolean("enableCheckLocalImage");
    L23:
        if (r10.hasKey("enableAsyncRequestImage") == false) goto L26;
        this.f10970h = r10.getBoolean("enableAsyncRequestImage");
    L26:
        if (r10.hasKey("useImagePostProcessor") == false) goto L29;
        r10.getBoolean("useImagePostProcessor");
    L29:
        if (r10.hasKey("enableNewImage") == false) goto L32;
        r10.getBoolean("enableNewImage");
    L32:
        if (r10.hasKey("asyncRedirect") == false) goto L35;
        this.e = r10.getBoolean("asyncRedirect");
    L35:
        if (r10.hasKey("pageType") == false) goto L38;
        r10.getString("pageType");
    L38:
        if (r10.hasKey("cliVersion") == false) goto L41;
        r10.getString("cliVersion");
    L41:
        if (r10.hasKey("customData") == false) goto L44;
        r10.getString("customData");
    L44:
        if (r10.hasKey("useNewSwiper") == false) goto L47;
        this.f10971i = r10.getBoolean("useNewSwiper");
    L47:
        if (r10.hasKey("enableAsyncInitVideoEngine") == false) goto L50;
        r10.getBoolean("enableAsyncInitVideoEngine");
    L50:
        if (r10.hasKey("targetSdkVersion") == false) goto L53;
        r10.getString("targetSdkVersion");
    L53:
        if (r10.hasKey("enableFlattenTranslateZ") == false) goto L56;
        this.C = r10.getBoolean("enableFlattenTranslateZ");
    L56:
        if (r10.hasKey("enableNewGesture") == false) goto L59;
        this.D = r10.getBoolean("enableNewGesture");
    L59:
        if (r10.hasKey("includeFontPadding") == false) goto L62;
        this.f10985x = r10.getBoolean("includeFontPadding");
    L62:
        if (r10.hasKey("lepusVersion") == false) goto L65;
        r10.getString("lepusVersion");
    L65:
        if (r10.hasKey("enableLepusNG") == false) goto L68;
        r10.getBoolean("enableLepusNG");
    L68:
        if (r10.hasKey("tapSlop") == false) goto L71;
        this.f10972j = r10.getString("tapSlop");
    L71:
        if (r10.hasKey("enableCreateViewAsync") == false) goto L74;
        this.f10973k = r10.getBoolean("enableCreateViewAsync");
    L74:
        if (r10.hasKey("enableVsyncAlignedFlush") == false) goto L77;
        this.f10974l = r10.getBoolean("enableVsyncAlignedFlush");
    L77:
        if (r10.hasKey("cssAlignWithLegacyW3c") == false) goto L80;
        this.f10975m = r10.getBoolean("cssAlignWithLegacyW3c");
    L80:
        if (r10.hasKey("enableAccessibilityElement") == false) goto L83;
        this.f10976n = r10.getBoolean("enableAccessibilityElement");
    L83:
        if (r10.hasKey("enableOverlapForAccessibilityElement") == false) goto L86;
        this.f10977o = r10.getBoolean("enableOverlapForAccessibilityElement", true);
    L86:
        if (r10.hasKey("enableNewAccessibility") == false) goto L89;
        this.f10978p = r10.getBoolean("enableNewAccessibility", false);
    L89:
        if (r10.hasKey("enableA11yIDMutationObserver") == false) goto L92;
        this.f10979q = r10.getBoolean("enableA11yIDMutationObserver", false);
    L92:
        if (r10.hasKey("enableA11y") == false) goto L95;
        this.f10980r = r10.getBoolean("enableA11y", false);
    L95:
        if (r10.hasKey("reactVersion") == false) goto L98;
        r10.getString("reactVersion");
    L98:
        if (r10.hasKey("enableTextRefactor") == false) goto L101;
        this.s = r10.getBoolean("enableTextRefactor");
    L101:
        if (r10.hasKey("enableTextOverflow") == false) goto L104;
        this.f10981t = r10.getBoolean("enableTextOverflow");
    L104:
        if (r10.hasKey("enableTextBoringLayout") == false) goto L106;
        this.f10982u = r10.getBoolean("enableTextBoringLayout");
    L108:
        if (r10.hasKey("enableNewClipMode") == false) goto L111;
        this.f10983v = r10.getBoolean("enableNewClipMode");
    L111:
        if (r10.hasKey("keyboardCallbackPassRelativeHeight") == false) goto L114;
        this.f10984w = r10.getBoolean("keyboardCallbackPassRelativeHeight");
    L114:
        if (r10.hasKey("enableCSSParser") == false) goto L117;
        r10.getBoolean("enableCSSParser");
    L117:
        if (r10.hasKey("enableEventRefactor") == false) goto L120;
        this.f10986y = r10.getBoolean("enableEventRefactor");
    L120:
        if (r10.hasKey("enableDisexposureWhenLynxHidden") == false) goto L123;
        this.f10987z = r10.getBoolean("enableDisexposureWhenLynxHidden");
    L123:
        if (r10.hasKey("enableExposureWhenLayout") == false) goto L126;
        this.A = r10.getBoolean("enableExposureWhenLayout", false);
    L126:
        if (r10.hasKey("enableExposureWhenReload") == false) goto L129;
        this.B = r10.getBoolean("enableExposureWhenReload", false);
    L129:
        if (r10.hasKey("enableNewIntersectionObserver") == false) goto L132;
        this.E = r10.getBoolean("enableNewIntersectionObserver");
    L132:
        if (r10.hasKey("observerFrameRate") == false) goto L135;
        this.H = r10.getInt("observerFrameRate");
    L135:
        if (r10.hasKey("enableExposureUIMargin") == false) goto L138;
        this.I = r10.getBoolean("enableExposureUIMargin");
    L138:
        if (r10.hasKey("longPressDuration") == false) goto L141;
        this.J = r10.getInt("longPressDuration");
    L141:
        if (r10.hasKey("mapContainerType") == false) goto L144;
        this.K = r10.getInt("mapContainerType");
    L144:
        if (r10.hasKey("pageFlatten") == false) goto L147;
        r10.getBoolean("pageFlatten");
    L147:
        if (r10.hasKey("enableNewGesture") == false) goto L150;
        this.D = r10.getBoolean("enableNewGesture");
    L150:
        if (r10.hasKey("user") == false) goto L153;
        r10.getString("user");
    L153:
        if (r10.hasKey("git") == false) goto L156;
        r10.getString("git");
    L156:
        if (r10.hasKey("filePath") == false) goto L159;
        r10.getString("filePath");
    L159:
        if (r10.hasKey("enableFiber") == false) goto L162;
        this.F = r10.getBoolean("enableFiber");
    L162:
        if (r10.hasKey("enableMultiTouch") == false) goto L165;
        this.G = r10.getBoolean("enableMultiTouch");
    L165:
        if (r10.hasKey("enableLynxScrollFluency") == false) goto L168;
        this.L = r10.getDouble("enableLynxScrollFluency");
    L168:
        if (r10.hasKey("enableTextLayoutCache") == false) goto L171;
        this.M = r10.getBoolean("enableTextLayoutCache");
        return;
    L171:
        this.M = LynxEnv.inst().enableTextLayoutCache();
        return;
    L106:
        this.f10982u = LynxEnv.inst().enableTextBoringLayout();
        goto L108
    }

    public static void a(u0 r5, b0 r10, com.lynx.tasm.behavior.i r11) {
        if (r5 != null) goto L6;
        LynxLog.b(4, "PageConfig", "PageConfig is null when exec onPageConfigDecoded from TemplateBundle.");
        return;
    L6:
        if (r10 == null) goto L8;
        r10.K = r5;
    L9:
        if (r11 == null) goto L72;
        LynxUIRenderer r12 = (LynxUIRenderer) r11;
        r12.f10163h = true;
        String r13 = r5.f10972j;
        UIBody r14 = null;
        if ("50px".equals(r13) == true) goto L13;
        r12.f10164i = r13;
    L23:
        r12.f10165j = r5.G;
        r12.f10166k = r5.F;
        boolean r15 = r5.D;
        r12.f10167l = r15;
        if (r15 == false) goto L33;
        WeakReference r16 = r12.f10160a;
        if (r16 == null) goto L28;
        LynxContext r17 = (LynxContext) r16.get();
    L29:
        com.lynx.tasm.behavior.n0 r18 = r12.f10161b;
        if (r18.f10297o != null) goto L32;
        r18.f10297o = new sn.a();
    L32:
        sn.a r19 = r18.f10297o;
        r19.f = true;
        r19.e = new s6.c(r19);
        r19.f21956a = new HashMap();
        r19.f21957b = new LinkedList();
        r19.f21958c = new LinkedList();
        r19.f21959h = new vn.d(r17, r19.e);
        goto L33
    L28:
        r17 = null;
    L33:
        com.lynx.tasm.behavior.n0 r20 = r12.f10161b;
        if (r20 == null) goto L73;
        UIBody r21 = r20.f10288b;
        if (r21 == null) goto L74;
        com.lynx.tasm.behavior.ui.accessibility.d r22 = r21.d;
        if (r22 == null) goto L75;
        boolean r23 = r5.f10978p;
        r22.f10406b = r23;
        boolean r24 = r5.f10980r;
        r22.f10407c = r24;
        boolean r25 = r5.f10976n;
        r22.d = r25;
        boolean r26 = r5.f10977o;
        r22.e = r26;
        r22.f = r5.f10979q;
        if (r22.f10415o == false) goto L43;
        r22.a();
        return;
    L43:
        if (r23 == true) goto L49;
        if (r24 == true) goto L49;
        com.lynx.tasm.behavior.ui.f r27 = r22.f10412l;
        if (r27 == null) goto L49;
        r27.f10458h = r25;
        r27.f10459i = r26;
        return;
    L49:
        WeakReference r28 = r22.f10405a;
        if (r28 == null) goto L52;
        r14 = (UIBody) r28.get();
    L52:
        if (r14 != null) goto L54;
        return;
    L54:
        if (r14.f10385a == null) goto L77;
        AccessibilityManager r29 = r22.f10409i;
        if (r29 != null) goto L59;
        return;
    L59:
        if (r22.f10410j != null) goto L62;
        r22.f10410j = new com.google.common.reflect.w(r29, r22);
    L62:
        if (r22.f10411k != null) goto L65;
        r22.f10411k = new ym.p(5);
    L65:
        if (r22.f10407c == false) goto L69;
        r22.e(r14, r14.f10385a);
        return;
    L69:
        if (r22.f10406b == false) goto L78;
        r22.d(r14);
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L13:
        WeakReference r30 = r12.f10160a;
        if (r30 == null) goto L16;
        LynxContext r31 = (LynxContext) r30.get();
    L17:
        if (r31 == null) goto L23;
        LynxView r32 = r31.k();
        if (r32 == null) goto L23;
        if (r32.getLynxViewBuilder() == null) goto L23;
        r12.f10164i = "50px";
        goto L23
    L16:
        r31 = null;
        goto L17
    L72:
        return;
    L8:
        LynxLog.b(4, "PageConfig", "lynx context free in used: LynxUI configs may be not valid from TemplateBundle.");
        goto L9
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PageConfig{autoExpose=");
        r5.append(this.f10967a);
        r5.append(", pageVersion='");
        return ai.j0.p(r5, this.d, '}');
    }
}
