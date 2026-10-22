package com.lynx.tasm;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.lynx.base.log.LynxLog;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxExposureModule;
import com.lynx.jsbridge.LynxFetchModule;
import com.lynx.jsbridge.LynxIntersectionObserverModule;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.LynxSetModule;
import com.lynx.jsbridge.LynxTextInfoModule;
import com.lynx.jsbridge.LynxUIMethodModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.krypton.CanvasRuntimeMediator;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.ILynxTrailServiceExtension;
import com.lynx.tasm.service.security.ILynxSecurityService;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTemplateRender implements f, g, c {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final boolean f10015m0 = false;
    public final CopyOnWriteArrayList A;
    public Context B;
    public final long C;
    public final long D;
    public volatile boolean E;
    public boolean F;
    public String G;
    public boolean H;
    public final boolean I;
    public boolean J;
    public final float K;
    public LynxBooleanOption L;
    public boolean M;
    public final boolean N;
    public com.lynx.tasm.behavior.i O;
    public final v P;
    public final PerformanceController Q;
    public volatile String R;
    public final fo.c S;
    public final boolean T;
    public final boolean U;
    public final boolean V;
    public final boolean W;
    public JSProxy X;
    public u Y;
    public LynxEngineProxy Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f10016a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public LynxLayoutProxy f10017a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ym.p f10018b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final HashMap f10019b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10020c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final AtomicBoolean f10021c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f10022d0;
    public b0 e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public NativeFacade f10023e0;
    public final HashMap f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f10024f0;
    public String g;
    public final AtomicInteger g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f10025h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final SparseArray f10026h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f10027i;
    public WeakReference i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10028j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final TemplateData f10029j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10030k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public LynxEngine f10031k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ThreadStrategyForRendering f10032l;
    public LynxModuleFactory l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p0 f10033m;

    @Keep
    private LynxDevtool mDevTool;

    @Nullable
    private LynxResourceLoader mLoader;
    private LynxResourceLoader mResourceLoader;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q0 f10034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final l0 f10035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final l0 f10036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final k f10037q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LynxModuleFactory f10038r;
    public com.lynx.tasm.behavior.w s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10039t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10040u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public UIBody.UIBodyView f10041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10042w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public mo.a f10043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TemplateData f10044y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10045z;

    static {
        f10015m0 = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.g, false);
    }

    @Keep
    public LynxTemplateRender(Context r17, UIBody.UIBodyView r18, l0 r19) {
        this.f10025h = false;
        this.f10028j = false;
        p0 r5 = new p0();
        this.f10033m = r5;
        q0 r10 = new q0();
        this.f10034n = r10;
        this.f10045z = -1;
        this.A = new CopyOnWriteArrayList();
        this.E = false;
        this.F = false;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = 1.0f;
        LynxBooleanOption r11 = LynxBooleanOption.f9962a;
        this.L = r11;
        this.M = true;
        this.N = true;
        this.P = new v();
        PerformanceController r12 = new PerformanceController();
        r12.f10930a = 0;
        r12.e = new JavaOnlyArray();
        r12.f = -1;
        this.Q = r12;
        this.R = "setup";
        boolean r13 = LynxEnv.inst().shouldForceLayoutOnBackgroundThread();
        this.U = r13;
        this.f10019b0 = new HashMap();
        this.f10021c0 = new AtomicBoolean(true);
        this.f10024f0 = 0;
        this.g0 = new AtomicInteger(0);
        this.f10026h0 = new SparseArray();
        new AtomicInteger(0);
        this.f10029j0 = TemplateData.c(new HashMap());
        TraceEvent.c("TemplateRender.init");
        ILynxTrailService r14 = (ILynxTrailService) ko.r.g().e(ILynxTrailService.class);
        if ((r14 instanceof ILynxTrailServiceExtension) == false) goto L5;
        ((ILynxTrailServiceExtension) r14).parseLynxViewBuilder(r19);
    L5:
        long r15 = System.currentTimeMillis();
        this.C = r15;
        this.B = r17;
        this.f10041v = r18;
        this.f10036p = r19;
        r19.getClass();
        this.f10035o = r19;
        r12.f10931b = new WeakReference(r10);
        this.f10032l = r19.f10910q;
        this.O = v0();
        this.S = r19.f10914v;
        this.T = r19.g;
        if (r19.f10905l == false) goto L8;
        boolean r16 = false;
    L9:
        this.V = r16;
        LynxBooleanOption r20 = r19.f10900c.f10896i;
        if (r20 != r11) goto L13;
        boolean r21 = LynxEnv.inst().enableGenericResourceFetcher();
    L16:
        this.I = r21;
        this.W = r19.f10905l;
        UIBody.UIBodyView r22 = this.f10041v;
        if (r22 == null) goto L19;
        r22.setTimingCollector(r12);
    L19:
        k r23 = r19.f10900c;
        this.f10037q = r23;
        ThreadStrategyForRendering r24 = this.f10032l;
        ThreadStrategyForRendering r110 = ThreadStrategyForRendering.e;
        if (r24 != r110) goto L22;
    L25:
        boolean r25 = true;
    L26:
        this.f10042w = r25;
        if (r13 == false) goto L32;
        if (r25 == true) goto L31;
        r110 = ThreadStrategyForRendering.d;
    L31:
        this.f10032l = r110;
    L32:
        this.f10039t = LynxEnv.inst().isNativeLibraryLoaded();
        if (f10015m0 == true) goto L35;
    L41:
        boolean r26 = false;
    L42:
        this.N = r26;
        this.K = r19.f10908o;
        this.f = r19.f10917y;
        this.F = r23.f10892a;
        this.G = r23.f10893b;
        if (r19.f10903j == false) goto L45;
        boolean r27 = r19.f10902i;
    L46:
        this.H = r27;
        DisplayMetricsHolder.c(r17, r19.f10898a);
        DisplayMetrics r28 = DisplayMetricsHolder.a();
        int r29 = r19.f10911r;
        if (r29 == (-1)) goto L52;
        int r111 = r19.s;
        if (r111 == (-1)) goto L52;
        r28.widthPixels = r29;
        r28.heightPixels = r111;
    L52:
        if (r17 == null) goto L54;
        Context r112 = r17;
    L55:
        b0 r30 = new b0(this, r112, r28);
        this.e = r30;
        new WeakReference(r30);
        b0 r31 = this.e;
        r31.getClass();
        r31.f10143k = new WeakReference(r12);
        this.e.d(this.f10041v);
        this.e.getClass();
        this.e.getClass();
        ko.b r32 = (ko.b) ko.r.g().e(ko.b.class);
        if (r32 == null) goto L58;
        r32.onLynxViewSetup(this.e, r23.f10894c, r19.f10899b);
    L58:
        LynxEnv.inst().initNativeUIThread();
        TraceEvent.c("TemplateRender.initWithContext");
        this.f10025h = false;
        this.f10030k = false;
        this.f10028j = false;
        b0 r33 = this.e;
        r33.f10139c = r5;
        r33.f10150r = r5;
        com.lynx.tasm.behavior.i r34 = v0();
        b0 r35 = this.e;
        com.lynx.tasm.behavior.c r36 = r19.f10899b;
        UIBody.UIBodyView r113 = this.f10041v;
        LynxBooleanOption r114 = this.L;
        LynxUIRenderer r37 = (LynxUIRenderer) r34;
        if (r37.f10168m == true) goto L61;
        r37.f10161b = new com.lynx.tasm.behavior.n0(r35, r36, r113);
    L67:
        if (r113 != null) goto L69;
        r37.f10161b.f10295m = true;
    L69:
        com.lynx.tasm.behavior.n0 r38 = r37.f10161b;
        r35.getClass();
        r35.f10147o = new WeakReference(r38);
        r35.f10145m = r37.f10161b.f10288b;
        r35.d(r113);
        r37.f10160a = new WeakReference(r35);
        r37.g = r114;
        monitor-enter(LynxUIRenderer.class);
    L78:
        th = move-exception;
        throw th;
    L72:
        if (LynxUIRenderer.f10159o == null) goto L74;
    L80:
        monitor-exit(LynxUIRenderer.class);
    L81:
        r37.f10168m = true;
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L84;
        LynxView r39 = t0();
        LynxDevtool r40 = new LynxDevtool();
        this.e.a();
        r40.a(r39, this);
        this.mDevTool = r40;
        new WeakReference(this);
    L84:
        e(-1);
        if (r17 != null) goto L90;
        com.lynx.tasm.behavior.n0 r41 = r37.f10161b;
        if (r41 == null) goto L89;
        r41.f10295m = true;
    L89:
        n0(false);
    L90:
        TraceEvent.a(0, "TemplateRender.initWithContext");
        int r42 = r19.f10906m;
        int r43 = r19.f10907n;
        if (r13 == false) goto L95;
        if (r42 != 0) goto L95;
        if (r43 != 0) goto L95;
        r42 = View.MeasureSpec.makeMeasureSpec(this.e.getResources().getDisplayMetrics().widthPixels, BasicMeasure.EXACTLY);
    L95:
        h(r42, r43, true);
        p0 r44 = LynxEnv.inst().getLynxViewClient();
        if (r5.f10927a.contains(r44) == true) goto L98;
        r5.f10927a.add(r44);
    L98:
        e0 r45 = new e0();
        r45.f10838a = 0;
        if (r5.f10927a.contains(r45) == true) goto L101;
        r5.f10927a.add(r45);
    L101:
        long r46 = System.currentTimeMillis();
        this.D = r46;
        r12.h(r15, "createLynxStart");
        r12.h(r46, "createLynxEnd");
        LynxLog.b(2, "LynxTemplateRender", R("create"));
        TraceEvent.a(0, "TemplateRender.init");
        return;
    L74:
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L80;
        HandlerThread r47 = new HandlerThread("PixelCopier");     // Catch: Throwable -> L78
        LynxUIRenderer.f10159o = r47;     // Catch: Throwable -> L78
        r47.start();     // Catch: Throwable -> L78
        monitor-exit(LynxUIRenderer.class);     // Catch: Throwable -> L78
        goto L81
    L61:
        com.lynx.tasm.behavior.n0 r48 = r37.f10161b;
        if (r35 == null) goto L64;
        r48.f10289c = r35;
    L65:
        r37.f10161b.s(r113);
        goto L67
    L64:
        r48.getClass();
        goto L65
    L54:
        r112 = LynxEnv.inst().getAppContext();
        goto L55
    L45:
        r27 = false;
        goto L46
    L35:
        if (LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch() == false) goto L41;
        ThreadStrategyForRendering r49 = this.f10032l;
        if (r49 != ThreadStrategyForRendering.f10065b) goto L39;
    L40:
        r26 = true;
        goto L42
    L39:
        if (r49 != ThreadStrategyForRendering.d) goto L41;
    L22:
        if (r24 == ThreadStrategyForRendering.f10066c) goto L25;
        r25 = false;
        goto L26
    L13:
        if (r20 != LynxBooleanOption.f9963b) goto L15;
        r21 = true;
        goto L16
    L15:
        r21 = false;
        goto L16
    L8:
        r16 = r19.f10904k;
        goto L9
    }

    public static /* synthetic */ boolean M(long r5) {
        return nativeLifecycleTryTerminate(r5);
    }

    public static /* synthetic */ void U(long r5) {
        nativeDestroy(r5);
    }

    public static /* synthetic */ LynxDevtool a(LynxTemplateRender r5) {
        return r5.mDevTool;
    }

    public static /* synthetic */ void d0(long r5) {
        nativeLifecycleDestroy(r5);
    }

    @CalledByNative
    private static Object decodeByteBuffer(ByteBuffer r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return kn.b.a(r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @CalledByNative
    private void getDataBack(ByteBuffer r5, int r10) {
        s r11 = (s) this.f10026h0.get(r10);
        Serializable r12 = kn.b.a(r5);
        if ((r12 instanceof Map) == false) goto L6;
        JavaOnlyMap r13 = new JavaOnlyMap((Map) r12);
        com.bytedance.android.monitorV2.lynx.c r14 = (com.bytedance.android.monitorV2.lynx.c) r11;
        r14.getClass();
        JSONObject r15 = r13.a();
        com.bytedance.android.monitorV2.event.a r16 = r14.f3635a;
        r16.c("state_info", r15);
        com.lynx.tasm.behavior.d r17 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        LynxView r18 = r14.f3636b;
        r17.h(r18, r16);
        x4.f r19 = r14.f3637c;
        r17.g(r18, r16, r19.f22969b, r19.f22970c);
        return;
    L6:
        com.bytedance.android.monitorV2.lynx.c r20 = (com.bytedance.android.monitorV2.lynx.c) r11;
        r20.getClass();
        com.lynx.tasm.behavior.d r21 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        LynxView r22 = r20.f3636b;
        com.bytedance.android.monitorV2.event.a r23 = r20.f3635a;
        r21.h(r22, r23);
        x4.f r24 = r20.f3637c;
        r21.g(r22, r23, r24.f22969b, r24.f22970c);
    }

    public static /* synthetic */ void j(long r5, long r10, String r11, String r12, int r13) {
        nativeUpdateI18nResource(r5, r10, r11, r12, r13);
    }

    public static void j0(String r5) {
        if (TraceController.g == true) goto L5;
        return;
    L5:
        TraceEvent.a(1, r5);
    }

    public static void k(LynxModuleFactory r5) {
        r5.c(LynxIntersectionObserverModule.class, null, LynxIntersectionObserverModule.NAME);
        r5.c(LynxUIMethodModule.class, null, LynxUIMethodModule.NAME);
        r5.c(LynxTextInfoModule.class, null, LynxTextInfoModule.NAME);
        r5.c(LynxAccessibilityModule.class, null, LynxAccessibilityModule.NAME);
        r5.c(LynxSetModule.class, null, LynxSetModule.NAME);
        r5.c(LynxResourceModule.class, null, LynxResourceModule.NAME);
        r5.c(LynxExposureModule.class, null, LynxExposureModule.NAME);
    }

    private native void nativeAttachEngineToUIThread(long r5, long r10);

    private static native void nativeAttachRuntime(long r5, long r10, long r11);

    private native void nativeClearPipelineTimingInfo(long r5, long r10);

    private static native long nativeCreate(long r5, Object r10, Object r11, Object r12, int r13, boolean r14, boolean r15, int r16, int r17, float r18, String r19, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, String r116, Object r117, long r20, long r22, boolean r24, boolean r25, boolean r26, boolean r27, int r28, boolean r29, boolean r30, long r31, Object r33);

    private static native void nativeDestroy(long r5);

    private native void nativeDetachEngineFromUIThread(long r5, long r10);

    private static native void nativeDispatchMessageEvent(long r5, long r10, ReadableMap r11);

    private static native void nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(long r5, long r10, int r11, int r12, int r13, int r14);

    private static native void nativeFlush(long r5, long r10);

    private static native JavaOnlyMap nativeGetAllJsSource(long r5, long r10);

    private native JavaOnlyMap nativeGetAllTimingInfo(long r5, long r10);

    private native void nativeGetDataAsync(long r5, long r10, int r11);

    private static native int nativeGetInstanceId(long r5, long r10);

    private static native JavaOnlyMap nativeGetListPlatformInfo(long r5, long r10, int r11);

    private static native Object nativeGetPageDataByKey(long r5, long r10, String[] r11);

    private native void nativeGetSessionStorageItem(long r5, long r10, String r11, PlatformCallBack r12);

    private static native void nativeInitRuntime(long r5, LynxResourceLoader r10, LynxModuleFactory r11, String r12, String[] r13, String r14, int r15, long r16);

    private static native long nativeLifecycleCreate();

    private static native void nativeLifecycleDestroy(long r5);

    private static native boolean nativeLifecycleTryTerminate(long r5);

    private static native void nativeLoadSSRDataByPreParsedData(long r5, long r10, byte[] r11, long r12, boolean r13, String r14, TemplateData r15);

    private static native void nativeLoadTemplateBufferByPreParsedData(long r5, long r10, String r11, ByteBuffer r12, int r13, boolean r14, long r15, boolean r16, String r17, TemplateData r18, int r19, ReadableMap r110);

    private static native void nativeLoadTemplateBundleByPreParsedData(long r5, long r10, String r11, long r12, int r13, long r14, boolean r15, String r16, TemplateData r17, int r18, ReadableMap r19);

    private static native void nativeLoadTemplateByPreParsedData(long r5, long r10, String r11, byte[] r12, int r13, boolean r14, long r15, boolean r16, String r17, TemplateData r18, int r19, ReadableMap r110);

    private static native void nativeMarkDirty(long r5, long r10);

    private static native int nativeObtainChild(long r5, long r10, int r11, int r12, long r13, boolean r14);

    private static native void nativeObtainChildAsync(long r5, long r10, int r11, int r12, long r13);

    private static native void nativeOnEnterBackground(long r5, long r10);

    private static native void nativeOnEnterForeground(long r5, long r10);

    private static native void nativeOnLynxEngineCreated(long r5, long r10);

    private static native void nativePreloadLazyBundles(long r5, long r10, String[] r11);

    private static native void nativeProcessRender(long r5, long r10);

    private static native void nativeRecycleChild(long r5, long r10, int r11, int r12);

    private static native void nativeRecycleChildAsync(long r5, long r10, int r11, int r12);

    private static native boolean nativeRegisterLazyBundle(long r5, long r10, String r11, long r12);

    private static native void nativeReloadTemplate(long r5, long r10, long r11, long r12, String r13, boolean r14, Object r15, TemplateData r16, ReadableMap r17);

    private static native void nativeRemoveChild(long r5, long r10, int r11, int r12);

    private static native void nativeRenderChild(long r5, long r10, int r11, int r12, long r13);

    private static native void nativeResetDataByPreParsedData(long r5, long r10, long r11, String r12, boolean r13, TemplateData r14);

    private native void nativeScrollByListContainer(long r5, long r10, int r11, float r12, float r13, float r14, float r15);

    private native void nativeScrollStopped(long r5, long r10, int r11);

    private native void nativeScrollToPosition(long r5, long r10, int r11, int r12, float r13, int r14, boolean r15);

    private static native void nativeSendGlobalEventToLepus(long r5, long r10, String r11, ByteBuffer r12, int r13);

    private static native void nativeSendSsrGlobalEvent(long r5, long r10, String r11, ByteBuffer r12, int r13);

    private native void nativeSetContextHasAttached(long r5, long r10);

    private static native void nativeSetEnableBytecode(long r5, long r10, boolean r11, String r12);

    private static native void nativeSetEnableUIFlush(long r5, long r10, boolean r11);

    private native void nativeSetExtensionDelegate(long r5, long r10, long r11);

    private static native void nativeSetFontScale(long r5, long r10, float r11);

    private native void nativeSetLongTaskMonitorDisabled(long r5, long r10, boolean r11);

    private static native void nativeSetPlatformConfig(long r5, long r10, String r11);

    private native void nativeSetSSRTimingData(long r5, long r10, String r11, long r12);

    private native void nativeSetSessionStorageItem(long r5, long r10, String r11, long r12, boolean r13);

    private static native void nativeStartRuntime(long r5, long r10);

    private native double nativeSubscribeSessionStorage(long r5, long r10, String r11, PlatformCallBack r12);

    private static native void nativeSyncFetchLayoutResult(long r5, long r10);

    private static native void nativeSyncPackageExternalPath(long r5, String r10);

    private static native void nativeTriggerEventBus(long r5, long r10, String r11, ByteBuffer r12, int r13);

    private native void nativeUnsubscribeSessionStorage(long r5, long r10, String r11, double r12);

    private static native void nativeUpdateChild(long r5, long r10, int r11, int r12, int r13, long r14);

    private static native void nativeUpdateConfig(long r5, long r10, ByteBuffer r11, int r12);

    private static native void nativeUpdateDataByPreParsedData(long r5, long r10, long r11, String r12, boolean r13, TemplateData r14, boolean r15);

    private static native void nativeUpdateFontScale(long r5, long r10, float r11);

    private static native void nativeUpdateGlobalProps(long r5, long r10, long r11);

    private static native void nativeUpdateI18nResource(long r5, long r10, String r11, String r12, int r13);

    private static native void nativeUpdateMetaData(long r5, long r10, long r11, String r12, boolean r13, TemplateData r14, long r15);

    private static native void nativeUpdateScreenMetrics(long r5, long r10, int r11, int r12, float r13, long r14);

    private static native void nativeUpdateViewport(long r5, long r10, int r11, int r12, int r13, int r14, float r15, long r16, boolean r17);

    public static String[] o0(String r10) {
        ArrayList r5 = new ArrayList();
        String[] r11 = r10.split("=|&");
        String r12 = "";
        int r13 = 0;
    L3:
        int r14 = r13 + 1;
        if (r14 >= r11.length) goto L17;
        if (r11[r13].equalsIgnoreCase("compile_path") == false) goto L8;
    L15:
        r10 = r11[r14];
    L16:
        r13 = r13 + 2;
        goto L3
    L8:
        if (r11[r13].equalsIgnoreCase("compilePath") == true) goto L15;
        if (r11[r13].equalsIgnoreCase("post_url") == false) goto L13;
    L14:
        r12 = r11[r14];
        goto L16
    L13:
        if (r11[r13].equalsIgnoreCase("postUrl") == false) goto L16;
    L17:
        r5.add(r10);
        r5.add(r12);
        return (String[]) r5.toArray(new String[r5.size()]);
    }

    public final void A(String r10, PlatformCallBack r11) {
        LynxLog.b(1, "LynxTemplateRender", "getSessionStorageItem with key: " + r10);
        if (TextUtils.isEmpty(r10) == true) goto L8;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L9;
        nativeGetSessionStorageItem(r5, this.f10022d0, r10, r11);
        return;
    L9:
        return;
    }

    public final void A0() {
        f0("TemplateRender.processRender");
        if (this.f10024f0 != 0) goto L5;
    L7:
        j0("TemplateRender.processRender");
        return;
    L5:
        if (this.M == true) goto L7;
        n0(true);
        nativeProcessRender(this.f10024f0, this.f10022d0);
        goto L7
    }

    public final void B(String r13, TemplateData r14) {
        LynxLog.b(1, "LynxTemplateRender", "setSessionStorageItem with key: " + r13);
        if (this.f10024f0 != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r14.k();
        if (r14.f10054a != 0) goto L10;
        LynxLog.b(4, "LynxTemplateRender", "setSessionStorageItem with zero data! key: " + r13);
        return;
    L10:
        nativeSetSessionStorageItem(this.f10024f0, this.f10022d0, r13, r14.f10054a, r14.e);
        return;
    }

    public final synchronized void B0() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f10028j == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f10025h == false) goto L57;
        f0("TemplateRender.reloadAndInit");     // Catch: Throwable -> L14
        this.f10030k = false;     // Catch: Throwable -> L14
        NativeFacade r5 = null;
        this.f10027i = null;     // Catch: Throwable -> L14
        this.R = "setup";     // Catch: Throwable -> L14
        b0 r10 = this.e;     // Catch: Throwable -> L14
        if (r10 == null) goto L16;
        com.lynx.tasm.behavior.ui.y r11 = r10.f10155x;     // Catch: Throwable -> L14
        if (r11 == null) goto L16;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.ui.l(r11, 1));     // Catch: Throwable -> L14
    L16:
        com.lynx.tasm.utils.j.f(new androidx.fragment.app.d(this, 19));     // Catch: Throwable -> L14
        TemplateData r12 = this.f10044y;     // Catch: Throwable -> L14
        if (r12 == null) goto L20;
        this.f10044y = r12.a();     // Catch: Throwable -> L14
    L20:
        if (this.f10024f0 == 0) goto L26;
        b0 r13 = this.e;     // Catch: Throwable -> L14
        if (r13 == null) goto L24;
        int r14 = r13.A;     // Catch: Throwable -> L14
        LynxEventReporter.removeGenericInfo(r14);     // Catch: Throwable -> L14
    L25:
        a0();     // Catch: Throwable -> L14
    L27:
        int r15 = this.f10020c;     // Catch: Throwable -> L14
        int r16 = this.d;     // Catch: Throwable -> L14
        this.f10020c = 0;     // Catch: Throwable -> L14
        this.d = 0;     // Catch: Throwable -> L14
        com.lynx.tasm.behavior.i r17 = v0();     // Catch: Throwable -> L14
        if (r17 == null) goto L51;
        com.lynx.tasm.behavior.n0 r18 = ((LynxUIRenderer) r17).f10161b;     // Catch: Throwable -> L14
        if (r18 == null) goto L51;
        r18.f10293k = true;     // Catch: Throwable -> L14
        r18.f10287a = -1;     // Catch: Throwable -> L14
        HashMap r19 = r18.g;     // Catch: Throwable -> L14
        if (r19 == null) goto L38;
        Iterator r20 = r19.values().iterator();     // Catch: Throwable -> L14
    L35:
        if (r20.hasNext() == false) goto L37;
        ((LynxBaseUI) r20.next()).destroy();     // Catch: Throwable -> L14
        goto L35
    L37:
        r18.g.clear();     // Catch: Throwable -> L14
        r18.e.clear();     // Catch: Throwable -> L14
    L38:
        UIBody r21 = r18.f10288b;     // Catch: Throwable -> L14
        if (r21 == null) goto L41;
        r21.removeAll();     // Catch: Throwable -> L14
    L41:
        HashMap r22 = r18.f10291i;     // Catch: Throwable -> L14
        if (r22 == null) goto L44;
        r22.clear();     // Catch: Throwable -> L14
    L44:
        WeakReference r23 = r18.f10296n;     // Catch: Throwable -> L14
        if (r23 == null) goto L47;
        r5 = (NativeFacade) r23.get();     // Catch: Throwable -> L14
    L47:
        if (r5 == null) goto L51;
        f0 r24 = r5.f10047a;     // Catch: Throwable -> L14
        if (r24 == null) goto L51;
        LynxTemplateRender r25 = r24.f10842a;     // Catch: Throwable -> L14
        r25.nativeClearPipelineTimingInfo(r25.f10024f0, r25.f10022d0);     // Catch: Throwable -> L14
    L51:
        b0 r26 = this.e;     // Catch: Throwable -> L14
        if (r26 == null) goto L54;
        r26.n();     // Catch: Throwable -> L14
    L54:
        e(r14);     // Catch: Throwable -> L14
        h(r15, r16, true);     // Catch: Throwable -> L14
        this.Q.h(this.C, "createLynxStart");     // Catch: Throwable -> L14
        this.Q.h(this.D, "createLynxEnd");     // Catch: Throwable -> L14
        j0("TemplateRender.reloadAndInit");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L24:
        r14 = -1;
        goto L25
    L26:
        r14 = -1;
        goto L27
    L57:
        this.f10025h = true;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public final void C(String r10, List r11) {
        if (this.f10039t == true) goto L5;
    L13:
        LynxLog.b(4, "LynxTemplateRender", "sendGlobalEventToLepus error, Env not prepared in " + toString());
        return;
    L5:
        if (this.f10024f0 == 0) goto L13;
        ByteBuffer r12 = kn.b.b(r11);
        long r5 = this.f10024f0;
        long r13 = this.f10022d0;
        if (r12 != null) goto L10;
        int r14 = 0;
    L11:
        nativeSendGlobalEventToLepus(r5, r13, r10, r12, r14);
        return;
    L10:
        r14 = r12.position();
        goto L11
    }

    public final void C0() {
        long r5 = this.f10024f0;
        if (r5 == 0) goto L6;
        this.H = false;
        nativeStartRuntime(r5, this.f10022d0);
        return;
    }

    public final void D(String r10, boolean r11) {
        if (this.F == r11) goto L5;
    L7:
        this.F = r11;
        this.G = r10;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L11;
        nativeSetEnableBytecode(r5, this.f10022d0, r11, r10);
        return;
    L11:
        return;
    L5:
        if (Objects.equals(this.G, r10) == false) goto L7;
    }

    public final void D0() {
        f0("LynxTemplateRender.syncFlush");
        if (com.lynx.tasm.utils.j.j() == false) goto L14;
        if (this.f10042w == true) goto L7;
    L11:
        j0("LynxTemplateRender.syncFlush");
        return;
    L7:
        if (this.f10021c0.get() == true) goto L11;
        LynxLog.b(2, "LynxTemplateRender", "syncFlush wait layout finish");
        long r5 = this.f10024f0;
        if (r5 == 0) goto L11;
        nativeFlush(r5, this.f10022d0);
        goto L11
    L14:
        throw new AssertionError("Expected to run on UI thread!");
    }

    public final void E(String r16, byte[] r17, int r18, boolean r19, boolean r20, String r21, TemplateData r22, ym.p r23) {
        ILynxSecurityService r5 = (ILynxSecurityService) ko.r.g().e(ILynxSecurityService.class);
        if (r5 == null) goto L8;
        long r10 = PerformanceController.a();
        ((HashMap) r23.f23313c).put("verifyTasmStart", Long.valueOf(r10));
        lo.a r11 = r5.verifyTASM(t0(), r17, null, r16, ILynxSecurityService.LynxTasmType.f10958a);
        long r12 = PerformanceController.a();
        ((HashMap) r23.f23313c).put("verifyTasmEnd", Long.valueOf(r12));
        if (r11.f19688a == true) goto L8;
        this.f10023e0.reportError(new LynxError(10701, r11.f19689b, "", "error"));
        return;
    L8:
        long r13 = PerformanceController.a();
        ((HashMap) r23.f23313c).put("ffiStart", Long.valueOf(r13));
        if (r22 != null) goto L12;
        long r14 = 0;
    L11:
        long r15 = r14;
        if (r17 == null) goto L16;
        nativeLoadTemplateByPreParsedData(this.f10024f0, this.f10022d0, r16, r17, r18, r19, r15, r20, r21, r22, 0, r23.e());
        return;
    L16:
        LynxLog.b(4, "LynxTemplateRender", "loadTemplate with empty template or buffer.");
        return;
    L12:
        r14 = r22.f10054a;
        goto L11
    }

    public final void F(ByteBuffer r10) {
        if (this.f10039t == false) goto L9;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L10;
        nativeUpdateConfig(r5, this.f10022d0, r10, r10.position());
        return;
    L10:
        return;
    }

    public final void G(mo.a r10) {
        if (r10 == null) goto L9;
        HashMap r5 = new HashMap();
        r5.put("theme", r10.f20155a);
        ByteBuffer r11 = kn.b.b(r5);
        if (r11 == null) goto L8;
        nativeUpdateConfig(this.f10024f0, this.f10022d0, r11, r11.position());
        return;
    L8:
        return;
    }

    public final void H(boolean r11, int r12, int r13, int r14, float r15) {
        nativeScrollToPosition(this.f10024f0, this.f10022d0, r12, r13, r15, r14, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(byte[] r11, TemplateData r12) {
        if (this.f10028j == false) goto L6;
        return;
    L6:
        if (this.f10042w == false) goto L10;
        if (this.f10025h == true) goto L10;
    L13:
        ym.p r10 = ym.p.i("loadBundle", "loadBundleStart");
        this.Q.getClass();
        z0();
        if (this.f10024f0 == 0) goto L19;
        String r5 = this.g;
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        K(r11, r12, r5, false, false, new f0(this), r10);
    L19:
        t(r12);
        return;
    L10:
        if (com.lynx.tasm.utils.j.j() == true) goto L13;
        q r13 = new q(this, r11, r12, 2);
        com.lynx.tasm.utils.j.a().post(r13);
    }

    public final void J(byte[] r20, TemplateData r21, String r22) {
        if (this.f10028j == false) goto L6;
        return;
    L6:
        if (this.f10042w == false) goto L10;
        if (this.f10025h == true) goto L10;
    L13:
        q0(r22);
        s0(r22);
        LynxLog.b(2, "LynxTemplateRender", R("renderTemplate"));
        if (this.f10039t == true) goto L16;
        onErrorOccurred(new LynxError(140201, "LynxEnv has not been prepared successfully!", null, "error"));
    L25:
        long r5 = this.f10024f0;
        if (r5 == 0) goto L39;
        f0 r10 = new f0(this);
        if (this.f10023e0 == null) goto L38;
        if (r5 == 0) goto L38;
        if (r20 != null) goto L34;
        LynxLog.b(4, "LynxTemplateRender", "Load ssr data  with null template");
        goto L39
    L34:
        if (r21 == null) goto L36;
        r21.k();
        long r11 = r21.f10054a;
        String r17 = r21.f10056c;
        boolean r16 = r21.e;
    L37:
        this.f10023e0.f10047a = r10;
        nativeLoadSSRDataByPreParsedData(this.f10024f0, this.f10022d0, r20, r11, r16, r17, r21);
        goto L39
    L36:
        r16 = false;
        r17 = null;
        r11 = 0;
    L38:
        LynxLog.b(4, "LynxTemplateRender", "Load ssr data before inited");
    L39:
        t(r21);
        return;
    L16:
        this.f10040u = true;
        long r12 = this.f10024f0;
        if (r12 == 0) goto L19;
        nativeMarkDirty(r12, this.f10022d0);
    L19:
        B0();
        i r13 = new i();
        r13.f10879a = LynxSSRHelper$SSRHydrateStatus.f10006a;
        this.f10027i = r13;
        r13.f10879a = LynxSSRHelper$SSRHydrateStatus.f10007b;
        b0 r14 = this.e;
        if (r14 == null) goto L22;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_ENABLE_SSR, Boolean.TRUE, r14.A);
    L22:
        long r15 = this.f10024f0;
        if (r15 == 0) goto L25;
        nativeSetSSRTimingData(r15, this.f10022d0, r22, r20.length);
    L10:
        if (com.lynx.tasm.utils.j.j() == true) goto L13;
        com.lynx.tasm.utils.j.a().post(new com.bytedance.apm.e(this, r20, r22, r21));
    }

    public final void K(byte[] r13, TemplateData r14, String r15, boolean r16, boolean r17, f0 r18, ym.p r19) {
        if (r13 != null) goto L7;
        LynxLog.b(4, "LynxTemplateRender", "Load Template with null template");
        return;
    L7:
        if (this.f10023e0 != null) goto L9;
    L19:
        LynxLog.b(4, "LynxTemplateRender", "Load Template before inited");
        return;
    L9:
        if (this.f10024f0 == 0) goto L19;
        if (r14 == null) goto L13;
        r14.k();
        long r5 = r14.f10054a;
        String r10 = r14.f10056c;
        boolean r11 = r14.e;
        r14.g.set(true);
    L15:
        if (r5 != 0) goto L17;
        LynxLog.b(4, "LynxTemplateRender", "Load Template with zero template data");
    L17:
        this.f10023e0.getClass();
        this.f10023e0.f10047a = r18;
        E(r15, r13, r16 ? 1 : 0, r17, r11, r10, r14, r19);
        return;
    L13:
        r10 = null;
        r11 = false;
        r5 = 0;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L(byte[] r12, Map r13) {
        if (this.f10028j == false) goto L6;
        return;
    L6:
        if (this.f10042w == false) goto L10;
        if (this.f10025h == true) goto L10;
    L13:
        ym.p r10 = ym.p.i("loadBundle", "loadBundleStart");
        this.Q.getClass();
        z0();
        long r5 = this.f10024f0;
        if (r5 == 0) goto L29;
        String r11 = this.g;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        String r14 = r11;
        f0 r15 = new f0(this);
        NativeFacade r16 = this.f10023e0;
        if (r16 == null) goto L27;
        if (r5 == 0) goto L27;
        if (r12 != 0) goto L25;
        LynxLog.b(4, "LynxTemplateRender", "Load Template with null template");
        return;
    L25:
        r16.f10047a = r15;
        TemplateData r17 = TemplateData.c(r13);
        r17.k();
        r17.g.set(true);
        E(r14, r12, 0, false, true, "", r17, r10);
        return;
    L27:
        LynxLog.b(4, "LynxTemplateRender", "Load Template before inited");
        return;
    L29:
        return;
    L10:
        if (com.lynx.tasm.utils.j.j() == true) goto L13;
        q r18 = new q(this, r12, r13, 1);
        com.lynx.tasm.utils.j.a().post(r18);
    }

    public final boolean N(MotionEvent r10) {
        com.lynx.tasm.behavior.i r11 = this.O;
        if (r11 == null) goto L50;
        a1 r12 = ((LynxUIRenderer) r11).f10162c;
        if (r12 == null) goto L19;
        int r5 = r10.getAction();
        if (r5 != 0) goto L9;
        r12.f10182j = EventTarget$EnableStatus.f10246c;
        r12.f10183k = false;
        wm.a r13 = r12.f10179c;
        if (r13 == null) goto L45;
    L38:
        if (r13 == null) goto L45;
        if (r13.parent() == r13) goto L45;
        if (r13.hasConsumeSlideEventAngles() == false) goto L44;
        r12.f10183k = true;
    L44:
        r13 = r13.parent();
    L45:
        boolean r14 = r12.f10183k;
        if (r14 == false) goto L19;
        r12.k(r14);
        goto L19
    L9:
        if (r5 != 2) goto L32;
        if (r12.f10183k == false) goto L19;
        float r15 = r10.getX() - r12.f10184l.x;
        float r16 = r10.getY() - r12.f10184l.y;
        if (Math.abs(r15) > com.lynx.tasm.utils.g.a(10.0f, 0.0f)) goto L21;
        if (Math.abs(r16) > com.lynx.tasm.utils.g.a(10.0f, 0.0f)) goto L21;
        r12.k(true);
    L21:
        if (r12.f10182j != EventTarget$EnableStatus.f10246c) goto L32;
        r12.f10182j = EventTarget$EnableStatus.f10245b;
        double r17 = (Math.atan2(r16, r15) * ((double) 180.0f)) / 3.141592653589793d;
        wm.a r18 = r12.f10179c;
    L24:
        if (r18 == null) goto L32;
        if (r18.parent() == r18) goto L32;
        if (r18.consumeSlideEvent((float) r17) == true) goto L29;
        r18 = r18.parent();
        goto L24
    L29:
        r12.f10182j = EventTarget$EnableStatus.f10244a;
    L32:
        if (r12.f10182j != EventTarget$EnableStatus.f10244a) goto L34;
        boolean r19 = true;
    L35:
        boolean r20 = r12.k(r19);
    L48:
        if (r20 == false) goto L50;
        return true;
    L34:
        r19 = false;
    L19:
        r20 = false;
    L50:
        return false;
    }

    public final boolean O(String r11, TemplateBundle r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        String r13 = "url is empty";
    L5:
        String r5 = null;
    L15:
        if (r13 == null) goto L21;
        LynxError r10 = new LynxError(160104, r13, "", "error");
        r10.g = null;
        r10.f10000o = r5;
        r10.b("component_url", r11);
        NativeFacade r14 = this.f10023e0;
        if (r14 == null) goto L23;
        r14.reportError(r10);
        return false;
    L23:
        return false;
    L21:
        return true;
    L6:
        if (r12 != null) goto L9;
        r13 = "bundle is null";
        goto L5
    L9:
        if (r12.d() == true) goto L12;
        r5 = r12.f10052b;
        r13 = "bundle is invalid";
        goto L15
    L12:
        if (nativeRegisterLazyBundle(this.f10024f0, this.f10022d0, r11, r12.f10051a) == true) goto L14;
        r13 = "input bundle is not from a dynamic component template";
        goto L5
    L14:
        r13 = null;
        r5 = null;
        goto L15
    }

    public final double P(String r10, PlatformCallBack r11) {
        LynxLog.b(1, "LynxTemplateRender", "subscribeSessionStorage with key: " + r10);
        if (TextUtils.isEmpty(r10) == true) goto L8;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L10;
        double r12 = nativeSubscribeSessionStorage(r5, this.f10022d0, r10, r11);
        this.f10019b0.put(Double.valueOf(r12), r11);
        return r12;
    L10:
        return -1.0d;
    L8:
        return -1.0d;
    }

    public final JavaOnlyMap Q(int r5) {
        return nativeGetListPlatformInfo(this.f10024f0, this.f10022d0, r5);
    }

    public final String R(String r5) {
        long r10 = System.currentTimeMillis();
        StringBuilder r11 = new StringBuilder();
        r11.append(String.valueOf(r10));
        r11.append(" ");
        r11.append(r5);
        r11.append(" LynxView ");
        b0 r12 = this.e;
        if (r12 == null) goto L14;
        String r13 = r12.B;
        String r14 = "";
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        if (TextUtils.isEmpty(r13) == true) goto L14;
        String r15 = this.e.B;
        if (r15 == null) goto L13;
        r14 = r15;
    L13:
        r11.append(r14);
        r11.append(" ");
    L14:
        String r16 = this.g;
        if (r16 == null) goto L18;
        r11.append(r16);
    L18:
        return r11.toString();
    }

    public final void S() {
        f0("LynxTemplateRender.destroy");
        b0 r5 = this.e;
        if (r5 == null) goto L7;
        com.lynx.tasm.behavior.ui.y r10 = r5.f10155x;
        if (r10 == null) goto L7;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.ui.l(r10, 1));
    L7:
        Iterator r11 = this.A.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((TemplateData) r11.next()).o();
        goto L9
    L11:
        this.A.clear();
        h0();
        f0("Client.onReportComponentInfo");
        this.f10033m.onReportComponentInfo(new HashSet());
        j0("Client.onReportComponentInfo");
        monitor-enter(this);
        TemplateData r12 = this.f10044y;     // Catch: Throwable -> L18
        if (r12 == null) goto L20;
        r12.o();     // Catch: Throwable -> L18
        this.f10044y = null;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
    L21:
        ko.b r13 = (ko.b) ko.r.g().e(ko.b.class);
        if (r13 == null) goto L24;
        r13.onLynxViewDestroy(this.e);
    L24:
        b0 r14 = this.e;
        if (r14 == null) goto L29;
        x0 r15 = r14.f10153v;
        if (r15 == null) goto L29;
        ((HashMap) r15.f10812a).clear();
    L29:
        this.e = null;
        com.lynx.tasm.behavior.i r16 = this.O;
        if (r16 == null) goto L84;
        com.lynx.tasm.behavior.n0 r17 = ((LynxUIRenderer) r16).f10161b;
        if (r17 == null) goto L84;
        TraceEvent.c("UIOwner.destroy");
        Iterator r18 = r17.g.entrySet().iterator();
    L35:
        if (r18.hasNext() == false) goto L42;
        Map.Entry r19 = (Map.Entry) r18.next();
        if ((r19.getValue() instanceof LynxBaseUI) == false) goto L35;
        LynxBaseUI r20 = (LynxBaseUI) r19.getValue();
        if (r20 == null) goto L35;
        r20.destroy();
        goto L35
    L42:
        b0 r21 = r17.f10289c;
        if (r21 == null) goto L57;
        com.lynx.tasm.behavior.ui.y r22 = r21.f10155x;
        if (r22 == null) goto L47;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.ui.l(r22, 1));
    L47:
        u0 r23 = r21.K;
        if (r23 == null) goto L50;
        boolean r24 = r23.E;
    L51:
        if (r24 == false) goto L57;
        WeakReference r25 = r21.f10148p;
        if (r25 == null) goto L57;
        com.lynx.tasm.behavior.w r26 = (com.lynx.tasm.behavior.w) r25.get();
        if (r26 == null) goto L57;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.v(r26, 1));
        goto L57
    L50:
        r24 = false;
    L57:
        sn.a r27 = r17.f10297o;
        if (r27 == null) goto L83;
        HashMap r28 = r27.f21956a;
        if (r28 == null) goto L62;
        r28.clear();
    L62:
        LinkedList r29 = r27.f21957b;
        if (r29 == null) goto L65;
        r29.clear();
    L65:
        LinkedList r30 = r27.f21958c;
        if (r30 == null) goto L68;
        r30.clear();
    L68:
        s6.c r31 = r27.e;
        if (r31 == null) goto L71;
        ((HashMap) r31.f21828b).clear();
    L71:
        vn.d r32 = r27.f21959h;
        if (r32 == null) goto L83;
        VelocityTracker r33 = r32.f;
        if (r33 != null) goto L90;
    L80:
        r32.f22619b = null;
        HashSet r34 = r32.g;
        if (r34 == null) goto L83;
        r34.clear();
        goto L83
    L90:
        r33.recycle();     // Catch: IllegalStateException -> L77
    L79:
        r32.f = null;
    L77:
        e = move-exception;
        LynxLog.b(4, "GestureHandlerTrigger", e.toString());
    L83:
        r17.f10299q.clear();
        TraceEvent.a(0, "UIOwner.destroy");
    L84:
        LynxLog.b(2, "LynxTemplateRender", R("destroy"));
        j0("LynxTemplateRender.destroy");
        return;
    L20:
        monitor-exit(this);
    L18:
        th = move-exception;
        throw th;
    }

    public final void T(int r10, int r11) {
        nativeRecycleChild(this.f10024f0, this.f10022d0, r10, r11);
    }

    public final void V(x r10) {
        if (this.f10028j == false) goto L5;
        return;
    L5:
        f0("LynxTemplateRender.loadTemplateWithMeta");
        if (this.f10042w == false) goto L10;
        if (this.f10025h == true) goto L10;
    L14:
        if (r10.f != LynxLoadMode.f10004b) goto L21;
        UIBody.UIBodyView r5 = this.f10041v;
        if (r5 == null) goto L18;
        r5.setShouldInterceptRequestLayout(true);
    L18:
        b0 r11 = this.e;
        r11.f10157z = true;
        r r12 = r11.g;
        if (r12 == null) goto L21;
        r12.f10940b = true;
    L21:
        LynxLoadMode r13 = r10.f;
        if (r13 != LynxLoadMode.d) goto L34;
        byte[] r14 = r10.f11192b;
        if (r14 == null) goto L29;
        if (r14.length <= 0) goto L29;
        String r15 = r10.f11191a;
        J(r14, r10.d, r15);
    L32:
        j0("LynxTemplateRender.loadTemplateWithMeta");
        return;
    L29:
        if (r10.f11191a.isEmpty() == true) goto L31;
        String r16 = r10.f11191a;
        z(r16, new a0(this, r16, r10.d));
        goto L32
    L31:
        LynxLog.b(4, "LynxTemplateRender", "SSR rendering failed: Binary data is invalid or URL is empty.");
        goto L32
    L34:
        i r17 = this.f10027i;
        if (r17 != null) goto L37;
    L41:
        ym.p r18 = ym.p.i("loadBundle", "loadBundleStart");
        this.Q.getClass();
        q0(r10.f11191a);
        o(r10, r18);
        LynxLog.b(2, "LynxTemplateRender", R("renderTemplate"));
        TemplateData r19 = r10.d;
        if (r19 == null) goto L44;
        t(r19);
    L44:
        j0("LynxTemplateRender.loadTemplateWithMeta");
        return;
    L37:
        if (((LynxSSRHelper$SSRHydrateStatus) r17.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L41;
        if (r13 != LynxLoadMode.e) goto L41;
        r17.f10879a = LynxSSRHelper$SSRHydrateStatus.f10008c;
    L10:
        if (com.lynx.tasm.utils.j.j() == true) goto L14;
        ab.b r20 = new ab.b(24, this, false, r10);
        com.lynx.tasm.utils.j.a().post(r20);
        j0("LynxTemplateRender.loadTemplateWithMeta");
    }

    public final void W(String r10, List r11) {
        if (this.f10039t == true) goto L5;
    L13:
        LynxLog.b(4, "LynxTemplateRender", "triggerEventBus error, Env not prepared in " + toString());
        return;
    L5:
        if (this.f10024f0 == 0) goto L13;
        ByteBuffer r12 = kn.b.b(r11);
        long r5 = this.f10024f0;
        long r13 = this.f10022d0;
        if (r12 != null) goto L10;
        int r14 = 0;
    L11:
        nativeTriggerEventBus(r5, r13, r10, r12, r14);
        return;
    L10:
        r14 = r12.position();
        goto L11
    }

    public final void X(String r10, ug.d r11) {
        if (this.f10039t == true) goto L6;
        onErrorOccurred(new LynxError(10202, "LynxEnv has not been prepared successfully!", null, "error"));
        return;
    L6:
        f0("LynxTemplateRender.renderTemplate");
        if (r10 == null) goto L11;
        String[] r5 = o0(r10);
        q0(r5[0]);
        if (this.mDevTool == null) goto L11;
        String r12 = r5[0];
        String r13 = r5[1];
    L11:
        b0 r14 = this.e;
        if (r14 != null) goto L15;
        LynxLog.b(4, "LynxTemplateRender", "renderTemplate error, can't get LynxContext in " + toString());
        return;
    L15:
        dn.a r15 = r14.F;
        if (r15 == null) goto L19;
        r15.O(new ko.r(8, r10, LynxResourceRequest$LynxResourceType.f), new androidx.core.view.inputmethod.a(r11, 8));
    L21:
        LynxLog.b(2, "LynxTemplateRender", R("renderTemplate"));
        j0("LynxTemplateRender.renderTemplate");
        return;
    L19:
        if (TextUtils.isEmpty(r10) == true) goto L24;
        w(this.g);
        this.Q.j("prepareTemplateStart");
        this.S.a(this.g, r11);
        goto L21
    L24:
        throw new IllegalArgumentException("LynxTemplateRender template url is null or TemplateProvider is not init");
    }

    public final void Y(String[] r5) {
        nativePreloadLazyBundles(this.f10024f0, this.f10022d0, r5);
    }

    public final boolean Z(TemplateData r10) {
        if (this.f10039t == true) goto L5;
    L19:
        return false;
    L5:
        if (this.f10024f0 == 0) goto L19;
        if (r10 != null) goto L11;
        LynxLog.b(4, "LynxTemplateRender", "updateData with null TemplateData");
        return false;
    L11:
        r10.k();
        if (r10.f10054a != 0) goto L15;
        LynxLog.b(4, "LynxTemplateRender", "updateData with TemplateData after flush is nullptr");
        return false;
    L15:
        this.f10040u = true;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L18;
        nativeMarkDirty(r5, this.f10022d0);
    L18:
        return true;
    }

    public final void a0() {
        if (this.f10021c0.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.i r5 = this.O;
        if (r5 == null) goto L8;
        ((LynxUIRenderer) r5).d();
    L8:
        NativeFacade r10 = this.f10023e0;
        if (r10 == null) goto L17;
        LynxModuleFactory r11 = r10.f;
        if (r11 == null) goto L17;
        if (r10.e == false) goto L15;
        r11.b();
    L16:
        r10.f = null;
        goto L17
    L15:
        r11.destroy();
    L17:
        com.lynx.tasm.utils.j.f(new com.bytedance.apm.internal.a(this.f10024f0, this.f10022d0, this, this.f10023e0));
        HashMap r12 = this.f10019b0;
        if (r12 == null) goto L20;
        r12.clear();
    L20:
        JSProxy r13 = this.X;
        if (r13 == null) goto L23;
        r13.a();
        this.X = null;
    L23:
        LynxEngineProxy r14 = this.Z;
        if (r14 == null) goto L26;
        com.lynx.tasm.utils.j.f(new jm.a(r14, 3));
    L26:
        LynxLayoutProxy r15 = this.f10017a0;
        if (r15 == null) goto L29;
        r15.a();
    L29:
        this.i0 = null;
        this.f10023e0 = null;
        this.f10022d0 = 0;
        this.f10024f0 = 0;
    }

    public final HashMap b(String[] r5) {
        if (this.f10039t == false) goto L11;
        long r10 = this.f10024f0;
        if (r10 == 0) goto L13;
        Object r11 = nativeGetPageDataByKey(r10, this.f10022d0, r5);
        HashMap r12 = new HashMap();
        if ((r11 instanceof Map) == false) goto L10;
        r12.putAll((Map) r11);
    L10:
        return r12;
    L13:
        return null;
    L11:
        return null;
    }

    public final void b0(int r10) {
        nativeScrollStopped(this.f10024f0, this.f10022d0, r10);
    }

    public final void c() {
        if (this.f10024f0 != 0) goto L5;
        return;
    L5:
        if (com.lynx.tasm.utils.j.j() == true) goto L8;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("attachEngineToUIThread should be called on ui thread, url: "), this.g, 4, "LynxTemplateRender");
        return;
    L8:
        int r5 = this.f10032l.ordinal();
        if (r5 != 1) goto L11;
        this.f10032l = ThreadStrategyForRendering.f10065b;
    L15:
        nativeAttachEngineToUIThread(this.f10024f0, this.f10022d0);
        y0();
        return;
    L11:
        if (r5 != 3) goto L18;
        this.f10032l = ThreadStrategyForRendering.d;
        goto L15
    }

    public final void c0(int r10, int r11) {
        nativeRecycleChildAsync(this.f10024f0, this.f10022d0, r10, r11);
    }

    public final void d(float r5) {
        if (this.f10039t == false) goto L9;
        long r10 = this.f10024f0;
        if (r10 == 0) goto L10;
        nativeUpdateFontScale(r10, this.f10022d0, r5);
        return;
    L10:
        return;
    }

    public final void e(int r49) {
        if (this.f10039t == true) goto L6;
        return;
    L6:
        if (this.f10021c0.compareAndSet(true, false) == true) goto L8;
        return;
    L8:
        TraceEvent.c("TemplateRender.createLynxEngine");
        if (this.f10032l != ThreadStrategyForRendering.f10065b) goto L11;
        UIBody.UIBodyView r5 = this.f10041v;
        ym.p r10 = new ym.p(0, false);
        r10.f23312b = r5;
        this.f10018b = r10;
        ym.f r11 = r10;
    L12:
        LynxLog.b(2, "LynxTemplateRender", "mEnableGenericResourceFetcher: " + this.I + " render: " + this);
        if (this.I == false) goto L15;
        b0 r12 = this.e;
        k r13 = this.f10036p.f10900c;
        r12.D = r13.f;
        r12.E = r13.g;
        r12.F = r13.f10895h;
    L15:
        this.f10016a = new d0(this);
        l0 r14 = this.f10035o;
        u r15 = r14.f10900c.f10894c;
        if (r15 != null) goto L19;
        r15 = null;
    L19:
        this.Y = r15;
        ln.b r16 = r14.f10915w;
        b0 r17 = this.e;
        this.mLoader = new LynxResourceLoader(null, r16, this, r17.F, r17.D);
        b0 r18 = this.e;
        r18.J = this.f10036p.d;
        l0 r19 = this.f10035o;
        if (r19.f10905l == false) goto L22;
        boolean r20 = false;
    L23:
        NativeFacade r21 = new NativeFacade(r20);
        this.f10023e0 = r21;
        r21.f10047a = new f0(this);
        DisplayMetrics r22 = r18.f10152u;
        u r23 = this.Y;
        if (r23 == null) goto L29;
        LynxWhiteBoard r24 = r23.f;
        if (r24 == null) goto L29;
        long r34 = r24.f10046a;
    L30:
        com.lynx.tasm.behavior.i r25 = v0();
        b0 r26 = this.e;
        ThreadStrategyForRendering r27 = this.f10032l;
        com.lynx.tasm.behavior.c r28 = this.f10036p.f10899b;
        LynxUIRenderer r29 = (LynxUIRenderer) r25;
        com.lynx.tasm.behavior.n0 r30 = r29.f10161b;
        if (r30 != null) goto L34;
    L40:
        WeakReference r31 = this.i0;
        if (r31 != null) goto L43;
    L46:
        NativeFacade r32 = this.f10023e0;
        TasmPlatformInvoker r33 = new TasmPlatformInvoker();
        r33.f10050a = new WeakReference(r32);
        this.i0 = new WeakReference(r33);
    L45:
        TasmPlatformInvoker r35 = r33;
        if (this.f10036p.f10901h == false) goto L50;
    L53:
        boolean r36 = true;
    L55:
        if (this.f10035o.f10913u == false) goto L58;
        LynxModuleFactory r37 = new LynxModuleFactory(this.e);
        this.l0 = r37;
        k(r37);
        LynxModuleFactory r38 = this.l0;
        this.f10035o.getClass();
        r38.getClass();
        r38.d(this.f10037q.d);
    L58:
        NativeFacade r39 = this.f10023e0;
        PerformanceController r40 = this.Q;
        r40.getClass();
        LynxResourceLoader r41 = this.mLoader;
        int r42 = this.f10032l.f10067a;
        boolean r110 = this.f10036p.e;
        boolean r111 = this.f10035o.f10916x;
        int r112 = r22.widthPixels;
        int r113 = r22.heightPixels;
        float r43 = r22.density;
        String r210 = LynxEnv.inst().getLocale();
        l0 r114 = this.f10035o;
        if (r114.f10905l == false) goto L61;
        boolean r211 = false;
    L62:
        this.f10036p.getClass();
        boolean r44 = this.f10036p.f10909p;
        u r115 = this.Y;
        if (r115 != null) goto L65;
    L67:
        boolean r310 = false;
    L68:
        if (r115 != null) goto L70;
    L73:
        String r45 = "";
    L72:
        String r311 = r45;
        long r312 = r29.c();
        if (this.L != LynxBooleanOption.f9964c) goto L77;
        boolean r313 = true;
    L78:
        boolean r46 = this.U;
        boolean r116 = this.f10036p.f;
        this.f10035o.getClass();
        LynxModuleFactory r117 = this.l0;
        if (r117 == null) goto L81;
        LynxModuleFactory r47 = r117;
    L82:
        this.f10024f0 = nativeCreate(0, r39, r40, r41, r42, r110, r111, r112, r113, r43, r210, r211, true, r44, r36, false, r310, r311, r35, r34, r312, false, r313, r46, r116, 0, false, false, 0, r47);
        NativeFacade r48 = this.f10023e0;
        com.lynx.tasm.behavior.n0 r50 = r29.f10161b;
        if (r50 == null) goto L85;
        r50.f10296n = new WeakReference(r48);
    L85:
        this.f10022d0 = nativeLifecycleCreate();
        long r51 = this.f10022d0;
        bm.a r52 = new bm.a(2);
        r52.f960b = r51;
        new com.lynx.tasm.base.c(this, r52);
        b0 r53 = this.e;
        r53.f10141i = new i(this);
        r53.I = r36;
        x0 r54 = new x0(6);
        Iterator<Map.Entry<String, fo.h>> r55 = LynxEnv.inst().getResourceProvider().entrySet().iterator();
    L87:
        if (r55.hasNext() == false) goto L91;
        Map.Entry<String, fo.h> r56 = r55.next();
        String r57 = r56.getKey();
        fo.h r58 = r56.getValue();
        if (TextUtils.isEmpty(r57) == true) goto L87;
        ((HashMap) r54.f10812a).put(r57, r58);
        goto L87
    L91:
        Iterator r59 = this.f10037q.e.entrySet().iterator();
    L93:
        if (r59.hasNext() == false) goto L97;
        Map.Entry r60 = (Map.Entry) r59.next();
        String r61 = (String) r60.getKey();
        fo.h r62 = (fo.h) r60.getValue();
        if (TextUtils.isEmpty(r61) == true) goto L93;
        ((HashMap) r54.f10812a).put(r61, r62);
        goto L93
    L97:
        this.e.f10153v = r54;
        this.f10035o.getClass();
        b0 r63 = this.e;
        this.f10035o.getClass();
        r63.getClass();
        NativeFacade r64 = this.f10023e0;
        b0 r65 = this.e;
        r64.getClass();
        r64.d = new WeakReference(r65);
        int r66 = nativeGetInstanceId(this.f10024f0, this.f10022d0);
        if (r66 < 0) goto L100;
        this.e.A = r66;
        this.Q.f = r66;
    L100:
        UIBody.UIBodyView r67 = this.f10041v;
        if (r67 == null) goto L104;
        r67.setInstanceId(this.e.A);
        p0 r68 = this.f10033m;
        int r69 = this.e.A;
        r68.getClass();
        q0 r70 = this.f10034n;
        int r71 = this.e.A;
        r70.getClass();
    L104:
        if (this.e == null) goto L106;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(this.f10032l.f10067a), this.e.A);
        LynxEventReporter.moveExtraParams(r49, this.e.A);
    L106:
        b0 r72 = this.e;
        if (r72 == null) goto L179;
        this.f10038r = new LynxModuleFactory(r72);
        this.f10037q.getClass();
        LynxModuleFactory r73 = this.f10038r;
        this.f10035o.getClass();
        r73.getClass();
        r73.d(this.f10037q.d);
        k(this.f10038r);
        nm.b r74 = new nm.b();
        new WeakReference(this.e);
        this.f10038r.c(LynxFetchModule.class, r74, LynxFetchModule.NAME);
        k r75 = this.f10037q;
        ln.b r76 = this.f10035o.f10915w;
        b0 r77 = this.e;
        LynxResourceLoader r118 = new LynxResourceLoader(r75, r76, this, r77.F, r77.D);
        this.mResourceLoader = r118;
        LynxModuleFactory r119 = this.f10038r;
        u r78 = this.f10037q.f10894c;
        if (r78 != null) goto L111;
    L114:
        boolean r79 = true;
    L115:
        boolean r80 = this.F;
        String r81 = this.G;
        boolean r82 = this.H;
        TraceEvent.c("TemplateRender.initPiper");
        this.f10023e0.f = r119;
        if (r79 == false) goto L119;
        LynxLog.b(2, "LynxTemplateRender", "force use quick js engine");
    L120:
        int r120 = k.a(k.a(k.a(k.a(0, 4, false), 8, r79), 32, r82), 1, r80);
        long r121 = this.f10024f0;
        u r83 = this.Y;
        if (r83 == null) goto L124;
        String r84 = r83.f10966c;
    L123:
        String r122 = r84;
        if (r83 == null) goto L127;
        String[] r123 = r83.d;
    L128:
        nativeInitRuntime(r121, r118, r119, r122, r123, r81, r120, r29.c());
        u r85 = this.Y;
        if (r85 != null) goto L131;
    L133:
        String r86 = "";
    L134:
        NativeFacade r87 = this.f10023e0;
        WeakReference r88 = r87.d;
        if (r87.e == false) goto L137;
        this.X = new JSProxy(this.f10024f0, r88, r86);
    L137:
        NativeFacade r89 = this.f10023e0;
        JSProxy r90 = this.X;
        r89.getClass();
        new WeakReference(r90);
        if (r88.get() == null) goto L140;
        LynxLog.b(2, "LynxTemplateRender", "set JSGroupThreadName to lynx context: " + r86);
        ((LynxContext) r88.get()).getClass();
    L140:
        LynxEngineProxy r91 = new LynxEngineProxy(this.f10024f0);
        this.Z = r91;
        NativeFacade r92 = this.f10023e0;
        r92.getClass();
        r92.f10049c = new WeakReference(r91);
        LynxLayoutProxy r93 = new LynxLayoutProxy(this.f10024f0);
        this.f10017a0 = r93;
        b0 r94 = this.e;
        r94.getClass();
        r94.f10144l = new WeakReference(r93);
        TraceEvent.a(0, "TemplateRender.initPiper");
        l0 r95 = this.f10035o;
        if (r95.f10905l == false) goto L143;
        boolean r96 = false;
    L144:
        if (r96 == true) goto L146;
        LynxLog.b(4, "LynxTemplateRender", "setUpExtensionModules failed, isEnableJSRuntime is false");
    L161:
        if (this.mDevTool == null) goto L178;
        LynxModuleFactory r97 = this.f10038r;
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L178;
        ILynxDevToolService r98 = LynxDevtool.f9889a;
        if (r98 != null) goto L168;
        LynxLog.b(4, "LynxDevtool", "sDevToolService is null");
        goto L178
    L168:
        Class<? extends LynxModule> r99 = r98.getDevToolSetModuleClass();
        if (r99 == null) goto L171;
        Object r100 = null;
        r97.c(r99, null, r99.getSimpleName());
        int r101 = 2;
        LynxLog.b(2, "LynxDevtool", "register LynxDevToolSetModule!");
    L172:
        Class<? extends LynxModule> r102 = LynxDevtool.f9889a.getDevToolWebSocketModuleClass();
        if (r102 == null) goto L175;
        r97.c(r102, r100, r102.getSimpleName());
        LynxLog.b(r101, "LynxDevtool", "register LynxWebSocketModule!");
    L175:
        Class<? extends LynxModule> r103 = LynxDevtool.f9889a.getLynxTrailModule();
        if (r103 == null) goto L178;
        r97.c(r103, r100, r103.getSimpleName());
        LynxLog.b(r101, "LynxDevtool", "register LynxTrailModule!");
        goto L178
    L171:
        r100 = null;
        r101 = 2;
    L178:
        b0 r104 = this.e;
        JSProxy r105 = this.X;
        r104.getClass();
        r104.f10142j = new WeakReference(r105);
    L183:
        this.e.g = new r(this.Z);
        com.lynx.tasm.behavior.w r106 = new com.lynx.tasm.behavior.w(this.e, this.X);
        this.s = r106;
        b0 r107 = this.e;
        r107.getClass();
        r107.f10148p = new WeakReference(r106);
        r r108 = this.e.g;
        if (r108 == null) goto L190;
        com.lynx.tasm.behavior.w r109 = this.s;
        if (r108.f.contains(r109) == true) goto L189;
        r108.f.add(r109);
    L189:
        r108.f10941c = new WeakReference(this.f10023e0);
        r108.d = new WeakReference(this);
    L190:
        G(this.f10043x);
        TemplateData r124 = this.f10044y;
        monitor-enter(this);
        if (r124 != null) goto L212;
        monitor-exit(this);
    L204:
        float r125 = this.K;
        if (r125 == 1.0f) goto L207;
        nativeSetFontScale(this.f10024f0, this.f10022d0, r125);
    L207:
        nativeOnLynxEngineCreated(this.f10024f0, ((LynxUIRenderer) v0()).c());
        TraceEvent.a(0, "TemplateRender.createLynxEngine");
        return;
    L212:
        r124.k();     // Catch: Throwable -> L200
        long r126 = r124.f10054a;     // Catch: Throwable -> L200
        if (r126 != 0) goto L202;
        LynxLog.b(4, "LynxTemplateRender", "updateGlobalProps with zero templateData");     // Catch: Throwable -> L200
        monitor-exit(this);     // Catch: Throwable -> L200
    L211:
        goto L204
    L202:
        nativeUpdateGlobalProps(this.f10024f0, this.f10022d0, r126);     // Catch: Throwable -> L200
        monitor-exit(this);     // Catch: Throwable -> L200
    L200:
        th = move-exception;
        throw th;
    L146:
        HashMap r127 = this.e.G;
        Iterator r128 = r127.keySet().iterator();
    L148:
        if (r128.hasNext() == false) goto L161;
        LynxKryptonModule r129 = (LynxKryptonModule) r127.get((String) r128.next());
        long r130 = r129.b();
        if (r130 == 0) goto L151;
        nativeSetExtensionDelegate(this.f10024f0, this.f10022d0, r130);
        LynxLog.b(2, "LynxKryptonModule", "LynxKryptonModule setup");
        u r131 = r129.f10498b;
        if (r131 == null) goto L148;
        if (r131.f10965b == false) goto L148;
        LynxKryptonHelper r132 = r129.f10499c;
        r132.getClass();
        LynxLog.b(2, "LynxKryptonHelper", "[Krypton] Setup canvas environment when specify enable_canvas in schema.");
        CanvasRuntimeMediator r133 = r132.f10495a;
        if (r133 == null) goto L148;
        LynxLog.b(2, "KryptonCanvasRuntimeMediator", "[Krypton] setupCanvasFromUI");
        r133.c();
        r132.f10495a.getClass();
        goto L148
    L151:
        LynxLog.b(4, "LynxTemplateRender", "Fail to get extension delegate");
        goto L148
    L143:
        r96 = r95.f10904k;
        goto L144
    L131:
        if (r85.e == false) goto L133;
        r86 = r85.f10966c;
        goto L134
    L127:
        r123 = null;
        goto L128
    L124:
        r84 = "-1";
        goto L123
    L119:
        LynxLog.b(2, "LynxTemplateRender", "useQuickJSEngine is false");
        goto L120
    L111:
        if (r78.f10964a == false) goto L114;
        r79 = false;
        goto L115
    L179:
        this.Z = new LynxEngineProxy(this.f10024f0);
        if (this.e != null) goto L182;
        LynxLog.b(4, "LynxTemplateRender", "mLynxContext is null, can not set LayoutProxy");
        goto L183
    L182:
        LynxLayoutProxy r134 = new LynxLayoutProxy(this.f10024f0);
        this.f10017a0 = r134;
        b0 r135 = this.e;
        r135.getClass();
        r135.f10144l = new WeakReference(r134);
        goto L183
    L81:
        r47 = null;
        goto L82
    L77:
        r313 = false;
        goto L78
    L70:
        if (r115.e == false) goto L73;
        r45 = r115.f10966c;
        goto L72
    L65:
        if (r115.e == false) goto L67;
        r310 = true;
        goto L68
    L61:
        r211 = r114.f10904k;
        goto L62
    L50:
        if (LynxEnv.inst().enableVSyncAlignedMessageLoopGlobal() == true) goto L53;
        r36 = false;
        goto L55
    L43:
        if (r31.get() == null) goto L46;
        r33 = (TasmPlatformInvoker) this.i0.get();
        NativeFacade r136 = this.f10023e0;
        r33.getClass();
        r33.f10050a = new WeakReference(r136);
        goto L45
    L34:
        if (r29.e != null) goto L37;
        r26.getClass();
        r29.e = new PaintingContext(r30, r27.f10067a);
    L37:
        if (r29.d != null) goto L39;
        r29.d = new com.lynx.tasm.behavior.w0(r26, r28, r11);
    L39:
        com.lynx.tasm.behavior.w0 r137 = r29.d;
        r26.getClass();
        r26.f10151t = new WeakReference(r137);
    L29:
        r34 = 0;
        goto L30
    L22:
        r20 = r19.f10904k;
        goto L23
    L11:
        r11 = new ym.d(this.e);
        goto L12
    }

    public final void e0(TemplateData r12) {
        f0("LynxTemplateRender.resetData");
        if (Z(r12) == false) goto L5;
        nativeResetDataByPreParsedData(this.f10024f0, this.f10022d0, r12.f10054a, r12.f10056c, r12.e, r12);
    L5:
        t(r12);
        LynxLog.b(2, "LynxTemplateRender", R("reset"));
        j0("LynxTemplateRender.resetData");
    }

    public final void f(int r11, float r12, float r13, float r14, float r15) {
        nativeScrollByListContainer(this.f10024f0, this.f10022d0, r11, r12, r13, r14, r15);
    }

    public final void f0(String r5) {
        if (TraceController.g == true) goto L5;
        return;
    L5:
        HashMap r10 = new HashMap();
        b0 r11 = this.e;
        if (r11 == null) goto L12;
        r10.put("instance_id", String.valueOf(r11.A));
        if (this.e.k() == null) goto L10;
        String r12 = this.e.k().toString();
    L11:
        r10.put("lynx_view", r12);
        goto L12
    L10:
        r12 = "null";
    L12:
        TraceEvent.b(1, r5, r10);
    }

    public final void finalize() {
        super.finalize();
        h0();
    }

    public final void g(int r24, int r25) {
        LynxEngine r5 = this.f10031k0;
        boolean r10 = true;
        if (r5 == null) goto L13;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r5.f9965a != LynxEngine.LynxEngineState.f9967b) goto L8;
        r5.a(LynxEngine.LynxEngineState.f9968c);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r5);
    L13:
        b0 r11 = this.e;
        if (r11 == null) goto L16;
        boolean r12 = LynxLongTaskMonitor.b("LynxTemplateRender.Measure", r11.A, this.L);
    L18:
        if (this.f10045z != (-1)) goto L20;
        long r13 = System.currentTimeMillis();
    L21:
        boolean r14 = this.U;
        boolean r15 = this.N;
        UIBody.UIBodyView r16 = null;
        if (r14 == false) goto L52;
        if (this.f10042w == true) goto L52;
        if (this.f10040u == true) goto L44;
        h(r24, r25, true);
        if (r15 == false) goto L40;
        b0 r17 = this.e;
        if (r17 == null) goto L37;
        u0 r18 = r17.K;
        if (r18 == null) goto L34;
        boolean r19 = r18.f10974l;
    L35:
        if (r19 == false) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L40;
    L41:
        if (r10 == false) goto L83;
        nativeFlush(this.f10024f0, this.f10022d0);
    L83:
        if (this.f10045z != (-1)) goto L85;
        this.f10045z = System.currentTimeMillis() - r13;
    L85:
        if (r12 == false) goto L87;
        LynxLongTaskMonitor.a();
    L87:
        com.lynx.tasm.behavior.i r20 = this.O;
        if (r20 == null) goto L116;
        LynxUIRenderer r21 = (LynxUIRenderer) r20;
        WeakReference r22 = r21.f10160a;
        if (r22 == null) goto L92;
        LynxContext r23 = (LynxContext) r22.get();
    L93:
        if (r23 == null) goto L95;
        r16 = r23.l();
    L95:
        com.lynx.tasm.behavior.n0 r26 = r21.f10161b;
        if (r26 == null) goto L112;
        if (r16 == null) goto L112;
        r26.f10288b.measureChildren();
        int r27 = View.MeasureSpec.getMode(r24);
        if (r27 == Integer.MIN_VALUE) goto L104;
        if (r27 == 0) goto L104;
        int r28 = View.MeasureSpec.getSize(r24);
    L105:
        int r29 = View.MeasureSpec.getMode(r25);
        if (r29 == Integer.MIN_VALUE) goto L110;
        if (r29 == 0) goto L110;
        int r30 = View.MeasureSpec.getSize(r25);
    L111:
        r16.innerSetMeasuredDimension(r28, r30);
        return;
    L110:
        r30 = r21.f10161b.f10288b.getHeight();
    L104:
        r28 = r21.f10161b.f10288b.getWidth();
    L112:
        LynxLog.b(4, "LynxUIRenderer", "performInnerMeasure failed, mLynxUIOwner:" + r21.f10161b + ", bodyView:" + r16);
        return;
    L92:
        r23 = null;
        goto L93
    L116:
        return;
    L34:
        r19 = false;
    L37:
        r110 = false;
    L40:
        r10 = false;
        goto L41
    L44:
        if (this.f10020c == r24) goto L46;
    L50:
        this.J = false;
        int r210 = MeasureMode.b(r24);
        int r111 = View.MeasureSpec.getSize(r24);
        int r211 = MeasureMode.b(r25);
        nativeEnforceRelayoutOnCurrentThreadWithUpdatedViewport(this.f10024f0, this.f10022d0, r111, r210, View.MeasureSpec.getSize(r25), r211);
        this.f10020c = r24;
        this.d = r25;
        this.f10040u = false;
        goto L83
    L46:
        if (this.d != r25) goto L50;
        if (this.J == true) goto L50;
        nativeSyncFetchLayoutResult(this.f10024f0, this.f10022d0);
        this.f10040u = false;
    L52:
        if (this.T == false) goto L54;
        D0();
    L54:
        h(r24, r25, true);
        if (this.f10032l != ThreadStrategyForRendering.d) goto L61;
        long r31 = this.f10024f0;
        if (r31 == 0) goto L61;
        if (this.f10040u == false) goto L61;
        nativeSyncFetchLayoutResult(r31, this.f10022d0);
        this.f10040u = false;
    L61:
        ym.p r32 = this.f10018b;
        if (r32 == null) goto L67;
        a6.a r33 = (a6.a) r32.f23313c;
        if (r33 == null) goto L66;
        r33.run();
    L66:
        r32.f23313c = null;
    L67:
        if (r15 == false) goto L79;
        b0 r34 = this.e;
        if (r34 == null) goto L76;
        u0 r35 = r34.K;
        if (r35 == null) goto L73;
        boolean r36 = r35.f10974l;
    L74:
        if (r36 == false) goto L76;
        boolean r37 = true;
    L77:
        if (r37 == false) goto L79;
    L80:
        if (r10 == false) goto L83;
        nativeFlush(this.f10024f0, this.f10022d0);
        this.f10040u = false;
        goto L83
    L73:
        r36 = false;
    L76:
        r37 = false;
    L79:
        r10 = false;
        goto L80
    L20:
        r13 = 0;
        goto L21
    L16:
        r12 = false;
        goto L18
    }

    public final void g0(boolean r5) {
        LynxLog.b(2, "LynxTemplateRender", "onEnterBackground. force: " + r5);
        if (this.f10024f0 == 0) goto L18;
        if (r5 == true) goto L17;
        b0 r10 = this.e;
        boolean r11 = false;
        if (r10 != null) goto L8;
    L16:
        if (r11 == false) goto L18;
    L8:
        if (r10.J == false) goto L13;
        u0 r12 = r10.K;
        if (r12 != null) goto L12;
        LynxLog.b(4, "LynxContext", "PageConfig is null.GetAutoExpose get default true!");
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        r11 = true;
        goto L16
    L12:
        r13 = r12.f10967a;
        goto L14
    L13:
        r13 = false;
    L17:
        nativeOnEnterBackground(this.f10024f0, this.f10022d0);
    L18:
        com.lynx.tasm.behavior.i r14 = this.O;
        if (r14 == null) goto L29;
        com.lynx.tasm.behavior.n0 r15 = ((LynxUIRenderer) r14).f10161b;
        if (r15 == null) goto L31;
        ArrayList r16 = r15.f;
        if (r16 == null) goto L32;
        Iterator r17 = r16.iterator();
    L27:
        if (r17.hasNext() == false) goto L33;
        ((com.lynx.tasm.behavior.g) r17.next()).a();
        goto L27
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void h(int r17, int r18, boolean r19) {
        if (this.f10039t == true) goto L5;
        return;
    L5:
        if (this.f10024f0 != 0) goto L8;
        return;
    L8:
        if (this.f10020c != r17) goto L16;
        if (this.d != r18) goto L16;
        if (this.J == true) goto L16;
        LynxLog.b(2, "LynxTemplateRender", "updateViewport is unnecessary, because the size of the cache are the same as the size to be set.");
        return;
    L16:
        if (this.J == false) goto L18;
        this.J = false;
    L18:
        int r10 = MeasureMode.b(r17);
        int r11 = View.MeasureSpec.getSize(r17);
        int r12 = MeasureMode.b(r18);
        int r13 = View.MeasureSpec.getSize(r18);
        nativeUpdateViewport(this.f10024f0, this.f10022d0, r11, r10, r13, r12, this.e.f10152u.density, ((LynxUIRenderer) this.O).c(), r19);
        this.f10020c = r17;
        this.d = r18;
    }

    public final void h0() {
        LynxModuleFactory r5 = this.f10038r;
        if (r5 == null) goto L5;
        r5.f = true;
    L5:
        StringBuilder r10 = new StringBuilder("destroyNative url ");
        String r11 = this.g;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        r10.append(r11);
        r10.append(" in ");
        r10.append(toString());
        LynxLog.b(2, "LynxTemplateRender", r10.toString());
        if (this.mDevTool == null) goto L12;
        this.mDevTool = null;
    L12:
        if (this.f10024f0 == 0) goto L17;
        b0 r12 = this.e;
        if (r12 == null) goto L16;
        LynxEventReporter.clearCache(r12.A);
    L16:
        a0();
    L17:
        this.f10028j = true;
    }

    public final void i(int r10, long r11, int r12) {
        nativeObtainChildAsync(this.f10024f0, this.f10022d0, r10, r12, r11);
    }

    public final void i0(int r14, int r15) {
        b0 r5 = this.e;
        if (this.f10024f0 == 0) goto L15;
        if (r5 == null) goto L17;
        DisplayMetrics r10 = r5.f10152u;
        if (r14 == r10.widthPixels) goto L9;
    L10:
        this.J = true;
        r10.widthPixels = r14;
        r10.heightPixels = r15;
        com.lynx.tasm.behavior.ui.y r11 = r5.f10155x;
        if (r11 == null) goto L13;
        DisplayMetrics r12 = DisplayMetricsHolder.b(r5);
        int r13 = r12.widthPixels;
        int[] r16 = r11.f10212t;
        r16[0] = r13;
        r16[1] = r12.heightPixels;
    L13:
        nativeUpdateScreenMetrics(this.f10024f0, this.f10022d0, r14, r15, r10.density, ((LynxUIRenderer) this.O).c());
        return;
    L9:
        if (r15 != r10.heightPixels) goto L10;
        return;
    L17:
        return;
    }

    public final void k0(boolean r5) {
        LynxLog.b(2, "LynxTemplateRender", "onEnterForeground. force: " + r5);
        if (this.f10024f0 == 0) goto L18;
        if (r5 == true) goto L17;
        b0 r10 = this.e;
        boolean r11 = false;
        if (r10 != null) goto L8;
    L16:
        if (r11 == false) goto L18;
    L8:
        if (r10.J == false) goto L13;
        u0 r12 = r10.K;
        if (r12 != null) goto L12;
        LynxLog.b(4, "LynxContext", "PageConfig is null.GetAutoExpose get default true!");
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        r11 = true;
        goto L16
    L12:
        r13 = r12.f10967a;
        goto L14
    L13:
        r13 = false;
    L17:
        nativeOnEnterForeground(this.f10024f0, this.f10022d0);
    L18:
        com.lynx.tasm.behavior.i r14 = this.O;
        if (r14 == null) goto L29;
        com.lynx.tasm.behavior.n0 r15 = ((LynxUIRenderer) r14).f10161b;
        if (r15 == null) goto L31;
        ArrayList r16 = r15.f;
        if (r16 == null) goto L32;
        Iterator r17 = r16.iterator();
    L27:
        if (r17.hasNext() == false) goto L33;
        ((com.lynx.tasm.behavior.g) r17.next()).c();
        goto L27
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void l(LynxBooleanOption r10) {
        if (com.lynx.tasm.utils.j.j() == false) goto L14;
        this.L = r10;
        long r5 = this.f10024f0;
        if (r5 == 0) goto L15;
        long r11 = this.f10022d0;
        if (r10 != LynxBooleanOption.f9964c) goto L10;
        boolean r12 = true;
    L11:
        nativeSetLongTaskMonitorDisabled(r5, r11, r12);
        return;
    L10:
        r12 = false;
        goto L11
    L15:
        return;
    L14:
        throw new AssertionError("Expected to run on UI thread!");
    }

    public final void l0() {
        if (this.f10024f0 != 0) goto L5;
        return;
    L5:
        if (com.lynx.tasm.utils.j.j() == true) goto L8;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("detachEngineFromUIThread should be called on ui thread, url: "), this.g, 4, "LynxTemplateRender");
        return;
    L8:
        int r5 = this.f10032l.ordinal();
        if (r5 != 0) goto L11;
        this.f10032l = ThreadStrategyForRendering.f10066c;
        LynxEngine r10 = this.f10031k0;
        if (r10 == null) goto L17;
        r10.getClass();
        r10.a(LynxEngine.LynxEngineState.d);
        m.f10918a.getClass();
        this.f10031k0 = null;
    L17:
        nativeDetachEngineFromUIThread(this.f10024f0, this.f10022d0);
        y0();
        return;
    L11:
        if (r5 != 2) goto L20;
        this.f10032l = ThreadStrategyForRendering.e;
        goto L17
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(s r10) {
        if (this.f10039t == true) goto L5;
    L9:
        com.bytedance.android.monitorV2.lynx.c r11 = (com.bytedance.android.monitorV2.lynx.c) r10;
        r11.getClass();
        com.lynx.tasm.behavior.d r12 = com.bytedance.android.monitorV2.lynx.impl.d.f3683k;
        LynxView r5 = r11.f3636b;
        com.bytedance.android.monitorV2.event.a r13 = r11.f3635a;
        r12.h(r5, r13);
        x4.f r14 = r11.f3637c;
        r12.g(r5, r13, r14.f22969b, r14.f22970c);
        return;
    L5:
        if (this.f10024f0 == 0) goto L9;
        int r15 = this.g0.incrementAndGet();
        this.f10026h0.put(r15, r10);
        nativeGetDataAsync(this.f10024f0, this.f10022d0, r15);
    }

    public final void m0(TemplateData r11) {
        String r5 = this.g;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        LynxLog.b(1, "LynxTemplateRender", "updateGlobalProps with url: ".concat(r5));
        f0("TemplateRender.setGlobalProps");
        if (this.f10039t == true) goto L8;
    L37:
        j0("TemplateRender.setGlobalProps");
        return;
    L8:
        if (this.f10024f0 == 0) goto L37;
        if (r11 == null) goto L37;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L12:
        if (this.f10044y != null) goto L16;
        this.f10044y = TemplateData.c(new HashMap());     // Catch: Throwable -> L14
    L16:
        this.f10044y.h(r11);     // Catch: Throwable -> L14
        monitor-exit(this);
        TemplateData r12 = this.f10044y;
        monitor-enter(this);
        if (r12 != null) goto L42;
        monitor-exit(this);
        goto L37
    L42:
        r12.k();     // Catch: Throwable -> L28
        long r10 = r12.f10054a;     // Catch: Throwable -> L28
        if (r10 != 0) goto L30;
        LynxLog.b(4, "LynxTemplateRender", "updateGlobalProps with zero templateData");     // Catch: Throwable -> L28
        monitor-exit(this);
    L41:
        goto L37
    L30:
        nativeUpdateGlobalProps(this.f10024f0, this.f10022d0, r10);     // Catch: Throwable -> L28
        monitor-exit(this);
    L28:
        th = move-exception;
        throw th;
    }

    public final void n(x r10) {
        if (this.f10024f0 != 0) goto L5;
        return;
    L5:
        if ((r10.g & 8) == 0) goto L7;
        n0(false);
    L7:
        HashMap r5 = this.f;
        if (r5 == null) goto L12;
        String r11 = (String) r5.get("platform_config");
        if (r11 == null) goto L12;
        nativeSetPlatformConfig(this.f10024f0, this.f10022d0, r11);
    L12:
        TemplateData r12 = r10.e;
        if (r12 == null) goto L17;
        m0(r12);
        return;
    }

    public final void n0(boolean r5) {
        long r10 = this.f10024f0;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (this.M == r5) goto L9;
        this.M = r5;
        nativeSetEnableUIFlush(r10, this.f10022d0, r5);
        return;
    }

    public native void nativeDetachLynxEngineWrapper(long r5, long r10);

    public native void nativeReattachLynxEngineWrapper(long r5, long r10, long r11, long r12);

    public final void o(x r13, ym.p r14) {
        LynxLoadMode r5 = r13.f;
        boolean r10 = true;
        if (LynxLoadMode.f10004b != r5) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (this.e != null) goto L13;
        LynxLog.b(4, "LynxTemplateRender", "renderWithLoadMeta with null LynxContext");
        return;
    L13:
        TemplateBundle r12 = r13.f11193c;
        int r15 = r13.g;
        if (r12 != null) goto L16;
    L33:
        byte[] r16 = r13.f11192b;
        if (r16 != null) goto L36;
    L47:
        StringBuilder r17 = new StringBuilder("LoadMeta with url, pre-painting: ");
        r17.append(r11);
        r17.append(" ,pre-painting with draw:");
        if (LynxLoadMode.f10005c == r5) goto L51;
        r10 = false;
    L51:
        r17.append(r10);
        r17.append(" url: ");
        String r18 = r13.f11191a;
        com.lynx.tasm.behavior.ui.utils.e.i(r17, r18, 2, "LynxTemplateRender");
        X(r18, new ug.d(this, r18, r13));
        return;
    L36:
        if (r16.length <= 0) goto L47;
        z0();
        n(r13);
        if ((r15 & 4) == 0) goto L40;
        boolean r19 = true;
    L41:
        StringBuilder r20 = new StringBuilder("LoadMeta with binary, pre-painting: ");
        r20.append(r11);
        r20.append(" ,pre-painting with draw:");
        if (LynxLoadMode.f10005c == r5) goto L45;
        r10 = false;
    L45:
        r20.append(r10);
        r20.append(" enableRecycleTemplateBundle: ");
        r20.append(r19);
        LynxLog.b(2, "LynxTemplateRender", r20.toString());
        K(r13.f11192b, r13.d, r13.f11191a, r11, r19, new f0(this), r14);
        return;
    L40:
        r19 = false;
        goto L41
    L16:
        if (r12.d() == false) goto L33;
        TemplateBundle r21 = r13.f11193c;
        if (r21 != null) goto L20;
    L22:
        TemplateBundle r22 = null;
    L23:
        z0();
        n(r13);
        if ((r15 & 2) == 0) goto L26;
        boolean r23 = true;
    L27:
        StringBuilder r24 = new StringBuilder("LoadMeta with bundle, pre-painting: ");
        r24.append(r11);
        r24.append(" ,pre-painting with draw:");
        if (LynxLoadMode.f10005c == r5) goto L31;
        r10 = false;
    L31:
        r24.append(r10);
        r24.append(" enableDumpElementTree: ");
        r24.append(r23);
        LynxLog.b(2, "LynxTemplateRender", r24.toString());
        f0 r110 = new f0(this);
        TemplateBundle r25 = r22;
        s(r25, r13.f11191a, r13.d, r11, r13.g, r110, r14);
        return;
    L26:
        r23 = false;
        goto L27
    L20:
        if (r21.d() == false) goto L22;
        r22 = r13.f11193c;
        goto L23
    L5:
        if (LynxLoadMode.f10005c == r5) goto L8;
        r11 = false;
        goto L10
    }

    @Override // com.lynx.tasm.g
    public final void onErrorOccurred(LynxError r10) {
        if (r10 != null) goto L5;
    L39:
        LynxLog.b(4, "LynxTemplateRender", "receive invalid error");
        return;
    L5:
        if (TextUtils.isEmpty(r10.d) == true) goto L7;
    L8:
        String r5 = this.g;
        r10.g = null;
        r10.f9994i = r5;
        b0 r11 = this.e;
        if (r11 == null) goto L15;
        u0 r12 = r11.K;
        if (r12 != null) goto L13;
        LynxLog.b(4, "LynxContext", "PageConfig is null.GetPageVersion get default error;");
        String r13 = "error";
    L14:
        r10.g = null;
        r10.f9996k = r13;
        goto L15
    L13:
        r13 = r12.d;
    L15:
        i r14 = this.f10027i;
        if (r14 != null) goto L18;
    L20:
        boolean r15 = r10.f9990a;
        int r16 = r10.f;
        if (r15 == true) goto L37;
        b0 r17 = this.e;
        if (r17 == null) goto L25;
        LynxEventReporter.onEvent(LynxEventReporter.LYNX_SDK_ERROR_EVENT, r17.A, new s6.c(5, this, false, r10));
    L25:
        f0("TemplateRender.dispatchError");
        int r18 = r10.a();
        p0 r19 = this.f10033m;
        if (r18 != 102) goto L28;
        r19.onLoadFailed(r10.e());
    L29:
        r19.onReceivedError(r10);
        if (r18 != 201) goto L33;
        r19.onReceivedJSError(r10);
    L36:
        j0("TemplateRender.dispatchError");
        goto L37
    L33:
        if (r16 != (-1)) goto L35;
        r19.onReceivedNativeError(r10);
        goto L36
    L35:
        r19.onReceivedJavaError(r10);
        goto L36
    L28:
        r19.onReceivedError(r10.e());
    L37:
        LynxLog.b(4, "LynxTemplateRender", "LynxTemplateRender " + toString() + ": onErrorOccurred type " + r16 + ",errCode:" + r10.a() + ",detail:" + r10.e());
        return;
    L18:
        if (r10.a() != 102) goto L20;
        r14.f10879a = LynxSSRHelper$SSRHydrateStatus.e;
        goto L20
    L7:
        if (TextUtils.isEmpty(r10.f9993h) == true) goto L39;
        goto L8
    }

    public final void p(g0 r14) {
        b0 r5 = this.e;
        if (r5 != null) goto L5;
        return;
    L5:
        f0("LynxTemplateRender.updateMetaData");
        TemplateData r10 = r14.f10875a;
        if (r5.f10157z == false) goto L14;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("updateData after pre load, url:"), this.g, 2, "LynxTemplateRender");
        UIBody.UIBodyView r15 = this.f10041v;
        if (r15 == null) goto L10;
        r15.setShouldInterceptRequestLayout(false);
    L10:
        r5.f10157z = false;
        r r16 = r5.g;
        if (r16 == null) goto L14;
        r16.f10940b = false;
    L14:
        if (this.f10024f0 == 0) goto L16;
        r10.k();
        long r11 = r10.f10054a;
        String r12 = r10.f10056c;
        boolean r13 = r10.e;
        nativeUpdateMetaData(this.f10024f0, this.f10022d0, r11, r12, r13, r10, 0);
    L16:
        j0("LynxTemplateRender.updateMetaData");
    }

    public final JavaOnlyMap p0() {
        long r5 = this.f10024f0;
        if (r5 != 0) goto L5;
        return null;
    L5:
        return nativeGetAllTimingInfo(r5, this.f10022d0);
    }

    public final void q(LynxView r10) {
        if (this.f10041v == null) goto L6;
        LynxLog.b(4, "LynxTemplateRender", "already attached " + r10);
        return;
    L6:
        Context r5 = r10.getContext();
        this.B = r5;
        Activity r11 = kk.a.c(r5);
        if (TraceController.g == false) goto L13;
        HashMap r12 = new HashMap();
        if (r11 == null) goto L11;
        String r13 = r11.toString();
    L12:
        r12.put("curActivity", r13);
        TraceEvent.b(0, "TemplateRender.attachLynxView", r12);
        goto L13
    L11:
        r13 = "";
    L13:
        LynxLog.b(2, "LynxTemplateRender", "LynxTemplateRender(" + this + ") is attached on lynxView:" + r10);
        com.lynx.tasm.behavior.i r14 = v0();
        this.f10041v = r10;
        r10.setLynxUIRendererInternal(r14);
        ym.p r15 = this.f10018b;
        if (r15 == null) goto L16;
        r15.f23312b = this.f10041v;
    L16:
        this.f10041v.setTimingCollector(this.Q);
        b0 r16 = this.e;
        Context r17 = this.B;
        LynxUIRenderer r18 = (LynxUIRenderer) r14;
        if (r16 == null) goto L27;
        r18.getClass();
        r18.f10160a = new WeakReference(r16);
        r16.f10147o = new WeakReference(r18.f10161b);
        r16.f10145m = r18.f10161b.f10288b;
        r16.setBaseContext(r17);
        r16.d(r10);
        a1 r19 = r18.f10162c;
        if (r19 == null) goto L27;
        com.lynx.tasm.behavior.h r20 = r19.f10178b;
        if (r20 == null) goto L26;
        if (r17 != null) goto L24;
        int r21 = ViewConfiguration.getTouchSlop();
    L25:
        r20.f10256a = r21 * r21;
        goto L26
    L24:
        r21 = ViewConfiguration.get(r17).getScaledTouchSlop();
    L26:
        r16.f10140h = r18.f10162c;
    L27:
        com.lynx.tasm.behavior.n0 r22 = r18.f10161b;
        if (r22 == null) goto L32;
        if (r16 == null) goto L31;
        r22.f10289c = r16;
    L31:
        r22.s(r10);
    L32:
        if (r11 == null) goto L38;
        com.lynx.tasm.behavior.n0 r23 = r18.f10161b;
        if (r23 == null) goto L36;
        r23.f10295m = false;
    L36:
        nativeSetContextHasAttached(this.f10024f0, this.f10022d0);
    L38:
        if (this.mDevTool == null) goto L41;
        new WeakReference(r10);
    L41:
        if (TraceController.g == false) goto L44;
        TraceEvent.a(0, "TemplateRender.attachLynxView");
        return;
    }

    public final void q0(String r5) {
        this.g = r5;
        LynxEnv.inst().setLastUrl(this.g);
        b0 r10 = this.e;
        if (r10 == null) goto L6;
        r10.f10149q = this.g;
        return;
    }

    public final void r(TemplateBundle r12, TemplateData r13, String r14) {
        if (this.f10028j == false) goto L6;
        return;
    L6:
        if (this.f10042w == false) goto L10;
        if (this.f10025h == true) goto L10;
    L13:
        f0("TemplateRender.renderTemplateBundle");
        ym.p r10 = ym.p.i("loadBundle", "loadBundleStart");
        this.Q.getClass();
        q0(r14);
        z0();
        LynxLog.b(2, "LynxTemplateRender", R("renderTemplate"));
        if (this.f10024f0 == 0) goto L16;
        s(r12, r14, r13, false, 0, new f0(this), r10);
    L16:
        t(r13);
        j0("TemplateRender.renderTemplateBundle");
        return;
    L10:
        if (com.lynx.tasm.utils.j.j() == true) goto L13;
        com.bytedance.apm.e r5 = new com.bytedance.apm.e(this, r12, r13, r14, 7);
        com.lynx.tasm.utils.j.a().post(r5);
    }

    public final LynxDevtool r0() {
        return this.mDevTool;
    }

    public final void s(TemplateBundle r16, String r17, TemplateData r18, boolean r19, int r20, f0 r21, ym.p r22) {
        if (this.f10023e0 != null) goto L5;
    L26:
        LynxLog.b(4, "LynxTemplateRender", "LoadTemplateBundle before inited");
        return;
    L5:
        if (this.f10024f0 == 0) goto L26;
        if (r16 != null) goto L10;
    L20:
        LynxLog.b(4, "LynxTemplateRender", "LoadTemplateBundle with null bundle or invalid bundle");
        LynxError r5 = new LynxError(10205, "LoadTemplateBundle with null bundle or invalid bundle", "", "error");
        if (r16 != null) goto L23;
        String r10 = "bundle is null";
    L24:
        r5.g = null;
        r5.f10000o = r10;
        this.f10023e0.reportError(r5);
        return;
    L23:
        r10 = r16.f10052b;
        goto L24
    L10:
        if (r16.d() == false) goto L20;
        if (r18 == null) goto L14;
        r18.k();
        long r11 = r18.f10054a;
        String r12 = r18.f10056c;
        boolean r13 = r18.e;
        r18.g.set(true);
        String r14 = r12;
        boolean r15 = r13;
        long r23 = r11;
    L16:
        if (r23 != 0) goto L18;
        LynxLog.b(4, "LynxTemplateRender", "LoadTemplateBundle with zero templateData");
    L18:
        this.f10023e0.getClass();
        this.f10023e0.f10047a = r21;
        u0.a(r16.d, this.e, this.O);
        ((HashMap) r22.f23313c).put("ffiStart", Long.valueOf(PerformanceController.a()));
        long r24 = this.f10024f0;
        long r25 = this.f10022d0;
        long r26 = r16.f10051a;
        JavaOnlyMap r110 = r22.e();
        nativeLoadTemplateBundleByPreParsedData(r24, r25, r17, r26, r19 ? 1 : 0, r23, r15, r14, r18, r20, r110);
        return;
    L14:
        r14 = null;
        r15 = false;
        r23 = 0;
        goto L16
    }

    public final void s0(String r5) {
        b0 r10 = this.e;
        if (r10 == null) goto L9;
        if (r5 == null) goto L10;
        int r11 = r10.A;
        HashMap r12 = new HashMap();
        r12.put("url", r5);
        r12.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r5);
        LynxEventReporter.updateGenericInfo(r12, r11);
        v r13 = this.P;
        if (r13 == null) goto L11;
        r13.a("last_lynx_url", r5);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void t(TemplateData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (LynxEnv.inst().enableDataListFix() == false) goto L7;
        r5.f10057h = new WeakReference(this.e);
        return;
    L7:
        this.A.add(r5);
    }

    public final LynxView t0() {
        UIBody.UIBodyView r5 = this.f10041v;
        if ((r5 instanceof LynxView) == true) goto L5;
        return null;
    L5:
        return (LynxView) r5;
    }

    public final void u(TemplateData r20, TemplateData r21) {
        String r5 = this.g;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        LynxLog.b(1, "LynxTemplateRender", "reloadTemplate with url: ".concat(r5));
        f0("LynxTemplateRender.reloadTemplate");
        ym.p r10 = ym.p.i("reloadBundleFromNative", "reloadBundleStart");
        if (Z(r20) == false) goto L28;
        if (r21 == null) goto L9;
        this.f10044y = r21;
    L9:
        this.f10034n.a(t0(), new uj.a());
        if (r21 == null) goto L13;
        r21.k();
        long r11 = r21.f10054a;
    L12:
        long r12 = r11;
        b0 r13 = this.e;
        if (r13 == null) goto L27;
        u0 r14 = r13.K;
        if (r14 == null) goto L19;
        boolean r15 = r14.B;
    L20:
        if (r15 == false) goto L27;
        com.lynx.tasm.behavior.ui.y r16 = r13.f10155x;
        if (r16 == null) goto L24;
        r16.k(null);
    L24:
        com.lynx.tasm.behavior.ui.y r17 = this.e.f10155x;
        if (r17 == null) goto L27;
        LynxLog.b(2, "Lynx.UIExposure", "resumeExposure");
        r17.f10783z = false;
        r17.c();
        goto L27
    L19:
        r15 = false;
    L27:
        ((HashMap) r10.f23313c).put("ffiStart", Long.valueOf(PerformanceController.a()));
        int r18 = 2;
        nativeReloadTemplate(this.f10024f0, this.f10022d0, r20.f10054a, r12, r20.f10056c, r20.e, r21, r20, r10.e());
    L29:
        t(r20);
        LynxLog.b(r18, "LynxTemplateRender", R("reload"));
        j0("LynxTemplateRender.reloadTemplate");
        return;
    L13:
        r11 = 0;
        goto L12
    L28:
        r18 = 2;
        goto L29
    }

    public final l0 u0() {
        l0 r5 = new l0();
        l0 r10 = this.f10035o;
        r10.getClass();
        r5.f10912t = r10.f10912t;
        r5.f10908o = r10.f10908o;
        r5.f10909p = true;
        r5.f10915w = r10.f10915w;
        k r11 = r10.f10900c;
        LynxBooleanOption r12 = r11.f10896i;
        k r13 = r5.f10900c;
        r13.f10896i = r12;
        r13.f10894c = r11.f10894c;
        r13.f10892a = r11.f10892a;
        r13.f10893b = r11.f10893b;
        if (r12 != LynxBooleanOption.f9962a) goto L5;
        r13.f10896i = r11.f10896i;
    L5:
        wn.h r14 = r13.f;
        if (r14 != null) goto L9;
        r14 = r11.f;
    L9:
        r13.f = r14;
        com.bytedance.ies.bullet.base.utils.b r15 = r13.g;
        if (r15 != null) goto L13;
        r15 = r11.g;
    L13:
        r13.g = r15;
        dn.a r16 = r13.f10895h;
        if (r16 != null) goto L17;
        r16 = r11.f10895h;
    L17:
        r13.f10895h = r16;
        Iterator r17 = r11.e.entrySet().iterator();
    L19:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r17.next();
        HashMap r19 = r13.e;
        if (r19.containsKey(r18.getKey()) == true) goto L19;
        r19.put(r18.getKey(), r18.getValue());
        goto L19
    L23:
        int r20 = r10.f10911r;
        int r21 = r10.s;
        r5.f10911r = r20;
        r5.s = r21;
        ThreadStrategyForRendering r22 = r10.f10910q;
        if (r22 == null) goto L26;
        r5.f10910q = r22;
    L26:
        r5.f10899b = r10.f10899b;
        return r5;
    }

    @Keep
    public void updateData(Map<String, Object> r5, String r10) {
        TemplateData r11 = TemplateData.c(r5);
        r11.f10056c = r10;
        r11.e = true;
        v(r11, false);
        LynxLog.b(2, "LynxTemplateRender", R("update"));
    }

    public final void v(TemplateData r14, boolean r15) {
        f0("LynxTemplateRender.updateData");
        b0 r5 = this.e;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.f10157z == false) goto L14;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("updateData after pre load, url:"), this.g, 2, "LynxTemplateRender");
        UIBody.UIBodyView r10 = this.f10041v;
        if (r10 == null) goto L10;
        r10.setShouldInterceptRequestLayout(false);
    L10:
        r5.f10157z = false;
        r r11 = r5.g;
        if (r11 == null) goto L14;
        r11.f10940b = false;
    L14:
        if (Z(r14) == false) goto L16;
        r14.g.set(true);
        nativeUpdateDataByPreParsedData(this.f10024f0, this.f10022d0, r14.f10054a, r14.f10056c, r14.e, r14, r15);
    L16:
        t(r14);
        j0("LynxTemplateRender.updateData");
    }

    public final com.lynx.tasm.behavior.i v0() {
        if (this.O != null) goto L9;
        UIBody.UIBodyView r5 = this.f10041v;
        if (r5 == null) goto L7;
        this.O = r5.getLynxUIRendererInternal();
        goto L9
    L7:
        this.f10036p.f10912t.getClass();
        this.O = new LynxUIRenderer();
    L9:
        return this.O;
    }

    public final void w(String r5) {
        StringBuilder r10 = com.lynx.tasm.utils.e.b("dispatchOnPageStart url ", r5, " in ");
        r10.append(toString());
        LynxLog.b(2, "LynxTemplateRender", r10.toString());
        if (this.f10030k == true) goto L12;
        p0 r11 = this.f10033m;
        if (r11 == null) goto L13;
        this.f10030k = true;
        b0 r12 = this.e;
        if (r12 == null) goto L10;
        LynxEventReporter.onEvent("lynxsdk_open_page", null, r12.A);
    L10:
        TraceEvent.g(1, "StartLoad");
        f0("Client.onPageStart");
        r11.onPageStart(r5);
        uj.a r13 = new uj.a();
        this.f10034n.a(t0(), r13);
        j0("Client.onPageStart");
        return;
    L13:
        return;
    }

    public final void w0() {
        String r5 = "lynxview onDetachedFromWindow " + toString();
        LynxLog.b(2, "LynxTemplateRender", r5);
        f0(r5);
        if (this.O == null) goto L10;
        TraceEvent.c("Client.onReportComponentInfo");
        this.f10033m.onReportComponentInfo(new HashSet());
        TraceEvent.a(0, "Client.onReportComponentInfo");
        com.lynx.tasm.behavior.n0 r10 = ((LynxUIRenderer) this.O).f10161b;
        if (r10 == null) goto L10;
        UIBody r11 = r10.f10288b;
        if (r11 == null) goto L10;
        r11.onDetach();
    L10:
        g0(false);
        j0(r5);
    }

    public final void x(String r10, double r11) {
        LynxLog.b(1, "LynxTemplateRender", "unsubscribeSessionStorage with key: " + r10);
        if (TextUtils.isEmpty(r10) == true) goto L10;
        long r5 = this.f10024f0;
        if (r5 != 0) goto L7;
        return;
    L7:
        if ((-1.0d) == r11) goto L12;
        nativeUnsubscribeSessionStorage(r5, this.f10022d0, r10, r11);
        this.f10019b0.remove(Double.valueOf(r11));
        return;
    L12:
        return;
    }

    public final void x0() {
        com.lynx.tasm.behavior.i r5 = this.O;
        if (r5 == null) goto L19;
        LynxUIRenderer r10 = (LynxUIRenderer) r5;
        if (r10.f10161b != null) goto L8;
        LynxLog.b(4, "LynxUIRenderer", "onLayout failed, mLynxUIOwner is null");
        return;
    L8:
        WeakReference r11 = r10.f10160a;
        if (r11 == null) goto L11;
        LynxContext r12 = (LynxContext) r11.get();
    L12:
        if (r12 == null) goto L17;
        boolean r13 = LynxLongTaskMonitor.b("LynxTemplateRender.Layout", r12.A, r10.g);
        r10.f10161b.y();
        if (r13 == false) goto L20;
        LynxLongTaskMonitor.a();
        return;
    L20:
        return;
    L17:
        r10.f10161b.y();
        return;
    L11:
        r12 = null;
        goto L12
    }

    public final void y(String r10, JavaOnlyArray r11) {
        i r5 = this.f10027i;
        boolean r12 = this.f10039t;
        if (r5 == null) goto L26;
        LynxSSRHelper$SSRHydrateStatus r13 = (LynxSSRHelper$SSRHydrateStatus) r5.f10879a;
        if (r13 != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L7;
    L12:
        if (r12 == true) goto L14;
    L21:
        this.f10027i.getClass();
        if (r11 != null) goto L25;
        r11 = new JavaOnlyArray();
    L25:
        r11.pushString("from_ssr_cache");
        goto L26
    L14:
        if (this.f10024f0 == 0) goto L21;
        ByteBuffer r14 = kn.b.b(r11);
        long r15 = this.f10024f0;
        long r16 = this.f10022d0;
        if (r14 != null) goto L19;
        int r17 = 0;
    L20:
        nativeSendSsrGlobalEvent(r15, r16, r10, r14, r17);
        goto L21
    L19:
        r17 = r14.position();
        goto L20
    L7:
        if (r13 == LynxSSRHelper$SSRHydrateStatus.f10008c) goto L12;
        if (r13 == LynxSSRHelper$SSRHydrateStatus.d) goto L12;
        if (r13 == LynxSSRHelper$SSRHydrateStatus.e) goto L12;
    L26:
        if (r12 == false) goto L30;
        b0 r18 = this.e;
        if (r18 == null) goto L30;
        r18.e(r10, r11);
        return;
    L30:
        LynxLog.b(4, "LynxTemplateRender", "sendGlobalEvent error, can't get GlobalEventEmitter in " + toString());
    }

    public final void y0() {
        ThreadStrategyForRendering r5 = this.f10032l;
        if (r5 != ThreadStrategyForRendering.e) goto L5;
    L8:
        boolean r10 = true;
    L9:
        this.f10042w = r10;
        if (this.e == null) goto L17;
        LynxEventReporter.updateGenericInfo(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(r5.f10067a), this.e.A);
        ThreadStrategyForRendering r11 = this.f10032l;
        if (r11 != ThreadStrategyForRendering.f10066c) goto L14;
    L15:
        this.e.M = true;
        return;
    L14:
        if (r11 == ThreadStrategyForRendering.f10065b) goto L15;
        return;
    L17:
        return;
    L5:
        if (r5 == ThreadStrategyForRendering.f10066c) goto L8;
        r10 = false;
        goto L9
    }

    public final void z(String r10, a0 r11) {
        if (this.f10039t == true) goto L6;
        onErrorOccurred(new LynxError(10202, "LynxEnv has not been prepared successfully!", null, "error"));
        return;
    L6:
        f0("LynxTemplateRender.renderSSRUrlInternal");
        String[] r5 = o0(r10);
        q0(r5[0]);
        s0(r5[0]);
        LynxLog.b(2, "LynxTemplateRender", R("renderTemplate"));
        dn.a r12 = this.e.F;
        if (r12 == null) goto L10;
        int r13 = 8;
        r12.N(new ko.r(r13, r10, LynxResourceRequest$LynxResourceType.f), new q7.a(4, this, r11));
    L12:
        j0("LynxTemplateRender.renderSSRUrlInternal");
        return;
    L10:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        w(this.g);
        this.Q.j("prepareTemplateStart");
        this.S.a(this.g, r11);
        goto L12
    L15:
        throw new IllegalArgumentException("LynxTemplateRender template url is null or TemplateProvider is not init");
    }

    public final void z0() {
        if (this.f10039t == true) goto L6;
        onErrorOccurred(new LynxError(10202, "LynxEnv has not been prepared successfully!", null, "error"));
        return;
    L6:
        i r5 = this.f10027i;
        if (r5 != null) goto L9;
    L11:
        this.f10040u = true;
        long r10 = this.f10024f0;
        if (r10 == 0) goto L14;
        nativeMarkDirty(r10, this.f10022d0);
    L14:
        B0();
        s0(this.g);
        NativeFacade r11 = this.f10023e0;
        if (r11 == null) goto L18;
        r11.f10048b = this.f10033m;
        w(this.g);
        return;
    L18:
        return;
    L9:
        if (((LynxSSRHelper$SSRHydrateStatus) r5.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10008c) goto L11;
        this.f10025h = false;
        i r12 = this.f10027i;
        r12.f10879a = LynxSSRHelper$SSRHydrateStatus.d;
        goto L11
    }
}
