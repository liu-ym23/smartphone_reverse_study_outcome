package com.lynx.tasm;

import com.lynx.config.LynxLiteConfigs;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t1 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final int L;
    public final boolean M;
    public final int N;
    public final int O;
    public final double P;
    public final boolean Q;
    public final boolean R;
    public final boolean S;
    public final boolean T;
    public final boolean U;
    public final boolean V;
    public final boolean W;
    public final boolean X;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    public final String toString() {
        return "PageConfig{autoExpose=" + this.a + ", pageVersion='" + this.d + '}';
    }

    public t1(ReadableMap r6) {
        this.a = true;
        this.f = true;
        this.g = true;
        this.k = true;
        this.m = "50px";
        this.n = true;
        this.q = true;
        this.r = true;
        this.y = true;
        this.A = false;
        this.B = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = 20;
        this.M = false;
        this.N = -1;
        this.O = 0;
        this.P = -1.0d;
        this.Q = LynxEnv.inst().enableFSP();
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.a = true;
        this.b = false;
        this.d = "error";
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.hasKey("autoExpose") == false) goto L8;
        this.a = r6.getBoolean("autoExpose");
    L8:
        if (r6.hasKey("pageVersion") == false) goto L11;
        this.d = r6.getString("pageVersion");
    L11:
        if (r6.hasKey("enableEventThrough") == false) goto L14;
        this.b = r6.getBoolean("enableEventThrough");
    L14:
        if (r6.hasKey("defaultOverflowVisible") == false) goto L17;
        this.c = r6.getBoolean("defaultOverflowVisible");
    L17:
        if (r6.hasKey("syncImageAttach") == false) goto L20;
        this.f = r6.getBoolean("syncImageAttach");
    L20:
        if (r6.hasKey("enableCheckLocalImage") == false) goto L23;
        this.g = r6.getBoolean("enableCheckLocalImage");
    L23:
        if (r6.hasKey("enableAsyncRequestImage") == false) goto L26;
        this.h = r6.getBoolean("enableAsyncRequestImage");
    L26:
        if (r6.hasKey("useImagePostProcessor") == false) goto L29;
        this.i = r6.getBoolean("useImagePostProcessor");
    L29:
        if (r6.hasKey("enableNewImage") == false) goto L32;
        this.j = r6.getBoolean("enableNewImage");
    L32:
        if (r6.hasKey("asyncRedirect") == false) goto L35;
        this.e = r6.getBoolean("asyncRedirect");
    L35:
        if (r6.hasKey("pageType") == false) goto L38;
        r6.getString("pageType");
    L38:
        if (r6.hasKey("cliVersion") == false) goto L41;
        r6.getString("cliVersion");
    L41:
        if (r6.hasKey("customData") == false) goto L44;
        r6.getString("customData");
    L44:
        if (r6.hasKey("useNewSwiper") == false) goto L47;
        this.k = r6.getBoolean("useNewSwiper");
    L47:
        if (r6.hasKey("enableAsyncInitVideoEngine") == false) goto L50;
        this.l = r6.getBoolean("enableAsyncInitVideoEngine");
    L50:
        if (r6.hasKey("targetSdkVersion") == false) goto L53;
        r6.getString("targetSdkVersion");
    L53:
        if (r6.hasKey("enableFlattenTranslateZ") == false) goto L56;
        this.F = r6.getBoolean("enableFlattenTranslateZ");
    L56:
        if (r6.hasKey("enableNewGesture") == false) goto L59;
        this.G = r6.getBoolean("enableNewGesture");
    L59:
        if (r6.hasKey("enablePlatformGesture") == false) goto L62;
        this.H = r6.getBoolean("enablePlatformGesture");
    L62:
        if (r6.hasKey("includeFontPadding") == false) goto L65;
        this.A = r6.getBoolean("includeFontPadding");
    L65:
        if (r6.hasKey("lepusVersion") == false) goto L68;
        r6.getString("lepusVersion");
    L68:
        if (r6.hasKey("enableLepusNG") == false) goto L71;
        r6.getBoolean("enableLepusNG");
    L71:
        if (r6.hasKey("tapSlop") == false) goto L74;
        this.m = r6.getString("tapSlop");
    L74:
        if (r6.hasKey("enableCreateViewAsync") == false) goto L77;
        this.n = r6.getBoolean("enableCreateViewAsync");
    L77:
        if (r6.hasKey("enableVsyncAlignedFlush") == false) goto L80;
        this.o = r6.getBoolean("enableVsyncAlignedFlush");
    L80:
        if (r6.hasKey("cssAlignWithLegacyW3c") == false) goto L83;
        this.p = r6.getBoolean("cssAlignWithLegacyW3c");
    L83:
        if (r6.hasKey("enableAccessibilityElement") == false) goto L86;
        this.q = r6.getBoolean("enableAccessibilityElement");
    L86:
        if (r6.hasKey("enableOverlapForAccessibilityElement") == false) goto L89;
        this.r = r6.getBoolean("enableOverlapForAccessibilityElement", true);
    L89:
        if (r6.hasKey("enableNewAccessibility") == false) goto L92;
        this.s = r6.getBoolean("enableNewAccessibility", false);
    L92:
        if (r6.hasKey("enableA11yIDMutationObserver") == false) goto L95;
        this.t = r6.getBoolean("enableA11yIDMutationObserver", false);
    L95:
        if (r6.hasKey("enableA11y") == false) goto L98;
        this.u = r6.getBoolean("enableA11y", false);
    L98:
        if (r6.hasKey("reactVersion") == false) goto L101;
        r6.getString("reactVersion");
    L101:
        if (r6.hasKey("enableTextRefactor") == false) goto L104;
        this.v = r6.getBoolean("enableTextRefactor");
    L104:
        if (r6.hasKey("enableTextOverflow") == false) goto L107;
        this.w = r6.getBoolean("enableTextOverflow");
    L107:
        if (r6.hasKey("enableTextBoringLayout") == false) goto L109;
        this.x = r6.getBoolean("enableTextBoringLayout");
    L111:
        if (r6.hasKey("enableNewClipMode") == false) goto L114;
        this.y = r6.getBoolean("enableNewClipMode");
    L114:
        if (r6.hasKey("keyboardCallbackPassRelativeHeight") == false) goto L117;
        this.z = r6.getBoolean("keyboardCallbackPassRelativeHeight");
    L117:
        if (r6.hasKey("enableCSSParser") == false) goto L120;
        r6.getBoolean("enableCSSParser");
    L120:
        if (r6.hasKey("enableEventRefactor") == false) goto L123;
        this.B = r6.getBoolean("enableEventRefactor");
    L123:
        if (r6.hasKey("enableDisexposureWhenLynxHidden") == false) goto L126;
        this.C = r6.getBoolean("enableDisexposureWhenLynxHidden");
    L126:
        if (r6.hasKey("enableExposureWhenLayout") == false) goto L129;
        this.D = r6.getBoolean("enableExposureWhenLayout", false);
    L129:
        if (r6.hasKey("enableExposureWhenReload") == false) goto L132;
        this.E = r6.getBoolean("enableExposureWhenReload", false);
    L132:
        if (r6.hasKey("enableNewIntersectionObserver") == false) goto L135;
        this.I = r6.getBoolean("enableNewIntersectionObserver");
    L135:
        if (r6.hasKey("observerFrameRate") == false) goto L138;
        this.L = r6.getInt("observerFrameRate");
    L138:
        if (r6.hasKey("enableExposureUIMargin") == false) goto L141;
        this.M = r6.getBoolean("enableExposureUIMargin");
    L141:
        if (r6.hasKey("longPressDuration") == false) goto L144;
        this.N = r6.getInt("longPressDuration");
    L144:
        if (r6.hasKey("mapContainerType") == false) goto L147;
        this.O = r6.getInt("mapContainerType");
    L147:
        if (r6.hasKey("pageFlatten") == false) goto L150;
        r6.getBoolean("pageFlatten");
    L150:
        if (r6.hasKey("enableNewGesture") == false) goto L153;
        this.G = r6.getBoolean("enableNewGesture");
    L153:
        if (r6.hasKey("user") == false) goto L156;
        r6.getString("user");
    L156:
        if (r6.hasKey("git") == false) goto L159;
        r6.getString("git");
    L159:
        if (r6.hasKey("filePath") == false) goto L162;
        r6.getString("filePath");
    L162:
        if (r6.hasKey("enableFiber") == false) goto L165;
        this.J = r6.getBoolean("enableFiber");
    L165:
        if (r6.hasKey("enableMultiTouch") == false) goto L168;
        this.K = r6.getBoolean("enableMultiTouch");
    L168:
        if (r6.hasKey("enableLynxScrollFluency") == false) goto L171;
        this.P = r6.getDouble("enableLynxScrollFluency");
    L171:
        if (r6.hasKey("enableFSP") == false) goto L174;
        this.Q = r6.getBoolean("enableFSP");
    L174:
        if (r6.hasKey("enableTextLayoutCache") == false) goto L176;
        this.R = r6.getBoolean("enableTextLayoutCache");
    L178:
        if (r6.hasKey("enableTransformedTouchPosition") == false) goto L181;
        this.S = r6.getBoolean("enableTransformedTouchPosition");
    L181:
        if (r6.hasKey("enableNewSticky") == false) goto L184;
        this.T = r6.getBoolean("enableNewSticky");
    L184:
        if (r6.hasKey("enableDispatchCustomEventForUI") == false) goto L187;
        this.U = r6.getBoolean("enableDispatchCustomEventForUI");
    L187:
        if (r6.hasKey("enableNativeInteraction") == false) goto L190;
        this.V = r6.getBoolean("enableNativeInteraction");
    L190:
        if (r6.hasKey("syncXElementRegistry") == false) goto L193;
        this.W = r6.getBoolean("syncXElementRegistry");
    L193:
        if (r6.hasKey("enableAutoNonFlatten") == false) goto L197;
        this.X = r6.getBoolean("enableAutoNonFlatten");
        return;
    L197:
        return;
    L176:
        this.R = LynxEnv.inst().enableTextLayoutCache();
        goto L178
    L109:
        this.x = LynxEnv.inst().enableTextBoringLayout();
        goto L111
    }

    public static void a(t1 r1, LynxContext r2, ILynxUIRenderer r3) {
        if (r1 != null) goto L6;
        LLog.e("PageConfig", "PageConfig is null when exec onPageConfigDecoded from TemplateBundle.");
        return;
    L6:
        if (r2 == null) goto L8;
        r2.onPageConfigDecoded(r1);
    L9:
        if (r3 == null) goto L38;
        LynxUIRenderer r4 = (LynxUIRenderer) r3;
        r4.i = true;
        LynxContext r0 = null;
        if ("50px".equals(r1.m) == true) goto L13;
        r4.j = r1.m;
    L19:
        r4.k = r1.K;
        r4.l = r1.J;
        r4.n = r1.H;
        boolean r5 = r1.G;
        r4.m = r5;
        if (r5 == true) goto L22;
    L27:
        LynxUIOwner r6 = r4.b;
        if (r6 == null) goto L33;
        if (r6.getRootUI() == null) goto L33;
        r4.b.getRootUI().onPageConfigDecoded(r1);
    L33:
        if (r1.W == false) goto L39;
        LynxUIOwner r7 = r4.b;
        if (r7 == null) goto L40;
        r7.setEnableSyncXElementRegistry();
        return;
    L40:
        return;
    L39:
        return;
    L22:
        if (LynxLiteConfigs.enableNewGesture() == false) goto L27;
        WeakReference<LynxContext> r8 = r4.a;
        if (r8 == null) goto L26;
        r0 = r8.get();
    L26:
        r4.b.initGestureArenaManager(r0);
        goto L27
    L13:
        WeakReference<LynxContext> r9 = r4.a;
        if (r9 == null) goto L16;
        LynxContext r10 = r9.get();
    L17:
        if (r10 == null) goto L19;
        r4.j = r10.getTapSlop();
        goto L19
    L16:
        r10 = null;
        goto L17
    L38:
        return;
    L8:
        LLog.e("PageConfig", "lynx context free in used: LynxUI configs may be not valid from TemplateBundle.");
        goto L9
    }
}
