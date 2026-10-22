package com.lynx.tasm.behavior;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIOwner {
    private static final int LEGACY_STICKY_INFO_COUNT = 4;
    private static final String LYNXSDK_ASYNC_CREATE_CONFIG = "lynxsdk_async_create_config";
    private static final String LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT = "lynxsdk_async_create_success_event";
    private static final String LYNXSDK_COMPONENT_STATISTIC_EVENT = "lynxsdk_component_statistic";
    private static final String TAG = "LynxUIOwner";
    private static final Comparator<LynxBaseUI> translationZComparator = null;
    private UIBody.UIBodyView.a mAttachLynxPageUICallback;
    private final com.lynx.tasm.behavior.c mBehaviorRegistry;
    private final HashSet<LynxBaseUI> mCachedBoundingClientRectUI;
    private final HashMap<String, Integer> mComponentIdToUiIdHolder;
    private final Set<String> mComponentSet;
    private LynxContext mContext;
    private final ConcurrentLinkedQueue<FutureTask<Runnable>> mCreateNodeAsyncTasks;
    private HashMap<String, Boolean> mCreateNodeConfigHasReportedMark;
    private boolean mEnableReportCreateAsync;
    private final List<j> mForegroundListeners;
    private q7a.b mGestureArenaManager;
    private boolean mHasTouchPseudo;
    private boolean mIsContextFree;
    private boolean mIsFirstLayout;
    private boolean mIsRootLayoutAnimationRunning;
    private WeakReference<NativeFacade> mNativeFacade;
    private l mPaintingContext;
    private int mRootSign;
    private Boolean mSettingsEnableNewImage;
    private final HashMap<Integer, LynxBaseUI> mTextChildUIHolder;
    private com.lynx.tasm.behavior.shadow.text.d mTextMeasurer;
    private final HashSet<LynxBaseUI> mTranslateZParentHolder;
    private UIBody mUIBody;
    private final HashMap<Integer, LynxBaseUI> mUIHolder;

    public class a implements Runnable {
        public final /* synthetic */ FutureTask a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(FutureTask r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ LynxBaseUI[] b;
        public final /* synthetic */ UIShadowProxy c;
        public final /* synthetic */ x0 d;
        public final /* synthetic */ int e;
        public final /* synthetic */ LynxUIOwner f;

        public final void a() {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            String r0 = "UIOwner.AfterCreateAsyncViewRunnable." + this.a;
            TraceEvent.beginSection(r0);
        L6:
            LynxBaseUI[] r1 = this.b;
            r1[0] = LynxUIOwner.access$000(this.f, r1[0], this.c, this.d);
            this.f.reportStatistic(this.a);
            LynxUIOwner.access$100(this.f, this.e, this.a, this.d);
            LynxUIOwner.access$200(this.f).put(Integer.valueOf(this.e), this.b[0]);
            if (TraceEvent.isTracingStarted() == false) goto L10;
            TraceEvent.endSection(r0);
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxUIOwner r1, String r2, LynxBaseUI[] r3, UIShadowProxy r4, x0 r5, int r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Exception a;
        public final /* synthetic */ LynxUIOwner b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxUIOwner.access$300(this.b).handleException(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LynxUIOwner r1, Exception r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ReadableMap c;
        public final /* synthetic */ ReadableMapBuffer d;
        public final /* synthetic */ ReadableArray e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ int g;
        public final /* synthetic */ ReadableArray h;
        public final /* synthetic */ LynxUIOwner i;

        @Override // java.lang.Runnable
        public final void run() {
            this.i.createView(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LynxUIOwner r1, int r2, String r3, ReadableMap r4, ReadableMapBuffer r5, ReadableArray r6, boolean r7, int r8, ReadableArray r9) {
            this.i = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ LynxBaseUI[] b;
        public final /* synthetic */ UIShadowProxy c;
        public final /* synthetic */ x0 d;
        public final /* synthetic */ int e;
        public final /* synthetic */ LynxUIOwner f;

        public final void a() {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            String r0 = "UIOwner.AfterCreateViewAsync." + this.a;
            LynxUIOwner.access$400(this.f, r0);
        L6:
            LynxBaseUI[] r1 = this.b;
            r1[0] = LynxUIOwner.access$000(this.f, r1[0], this.c, this.d);
            this.f.reportStatistic(this.a);
            LynxUIOwner.access$100(this.f, this.e, this.a, this.d);
            LynxUIOwner.access$200(this.f).put(Integer.valueOf(this.e), this.b[0]);
            if (TraceEvent.isTracingStarted() == false) goto L10;
            TraceEvent.endSection(r0);
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(LynxUIOwner r1, String r2, LynxBaseUI[] r3, UIShadowProxy r4, x0 r5, int r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ Exception a;
        public final /* synthetic */ LynxUIOwner b;

        @Override // java.lang.Runnable
        public final void run() {
            LynxUIOwner.access$300(this.b).handleException(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(LynxUIOwner r1, Exception r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class g implements Comparator<LynxBaseUI> {
        public g() {
        }

        @Override // java.util.Comparator
        public final int compare(LynxBaseUI r3, LynxBaseUI r4) {
            LynxBaseUI r5 = r3;
            LynxBaseUI r6 = r4;
            if (r5.getTranslationZ() <= r6.getTranslationZ()) goto L6;
            return 1;
        L6:
            if (r5.getTranslationZ() != r6.getTranslationZ()) goto L8;
            return 0;
        L8:
            return -1;
        }
    }

    public static final class h extends com.lynx.tasm.behavior.a {
        public final com.lynx.tasm.behavior.a a;

        @Override // com.lynx.tasm.behavior.a
        public final com.lynx.tasm.a createClassWarmer() {
            return this.a.createClassWarmer();
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return this.a.createShadowNode();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUI(LynxContext r2) {
            return this.a.createFlattenUI(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIFiber(LynxContext r2) {
            return this.a.createFlattenUIFiber(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final x6a.e createPlatformRendererHost(LynxContext r2) {
            return this.a.createPlatformRendererHost(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUI(LynxContext r2) {
            return this.a.createUI(r2);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIFiber(LynxContext r2) {
            return this.a.createUIFiber(r2);
        }

        public h(String r7, com.lynx.tasm.behavior.a r8) {
            super(r7, r8.supportUIFlatten(), r8.supportCreateAsync(), r8.needProcessDirection(), r8.supportFragmentLayerRenderer());
            this.a = r8;
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxFlattenUI createFlattenUIWithParams(LynxContext r2, Object r3) {
            return this.a.createFlattenUIWithParams(r2, r3);
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI createUIWithParams(LynxContext r2, Object r3) {
            return this.a.createUIWithParams(r2, r3);
        }
    }

    public static /* synthetic */ Map a(String r0) {
        return lambda$componentStatistic$1(r0);
    }

    public static /* synthetic */ Runnable b(LynxUIOwner r0, String r1, int r2, int r3, boolean r4, x0 r5, Map r6, Map r7) {
        return r0.lambda$createViewAsync$0(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Map c(String r0, String r1, boolean r2) {
        return lambda$reportCreateViewConfig$3(r0, r1, r2);
    }

    public static /* synthetic */ Map d(String r0, String r1, boolean r2, int r3) {
        return lambda$reportCreateAsyncSuccessEvent$2(r0, r1, r2, r3);
    }

    private int getSignFromOperationId(long r2) {
        return (int) (r2 >>> 32);
    }

    public void pauseRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = false;
    }

    public void reset() {
        this.mIsFirstLayout = true;
        this.mRootSign = -1;
        HashMap<Integer, LynxBaseUI> r0 = this.mUIHolder;
        if (r0 == null) goto L9;
        Iterator<LynxBaseUI> r1 = r0.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().destroy();
        goto L6
    L8:
        this.mUIHolder.clear();
        this.mTranslateZParentHolder.clear();
    L9:
        UIBody r2 = this.mUIBody;
        if (r2 == null) goto L12;
        r2.removeAll();
    L12:
        HashMap<String, Integer> r3 = this.mComponentIdToUiIdHolder;
        if (r3 == null) goto L15;
        r3.clear();
    L15:
        WeakReference<NativeFacade> r4 = this.mNativeFacade;
        if (r4 == null) goto L18;
        NativeFacade r5 = r4.get();
    L19:
        if (r5 == null) goto L25;
        NativeFacade.c r6 = r5.a;
        if (r6 == null) goto L26;
        r6.q();
        return;
    L26:
        return;
    L25:
        return;
    L18:
        r5 = null;
        goto L19
    }

    public void resumeRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = true;
    }

    public void setFirstLayout() {
        this.mIsFirstLayout = false;
    }

    static {
        translationZComparator = new g();
    }

    private void didPerformLayout() {
        if (this.mCachedBoundingClientRectUI.isEmpty() == false) goto L5;
        return;
    L5:
        HashSet r0 = new HashSet(this.mCachedBoundingClientRectUI);
        this.mCachedBoundingClientRectUI.clear();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((LynxBaseUI) r1.next()).uiOwnerDidPerformLayout();
        goto L7
    L9:
        didPerformLayout();
    }

    private void handleTranslateZUI() {
        if (this.mContext.getEnableFlattenTranslateZ() == true) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r0 = this.mTranslateZParentHolder.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        LynxBaseUI r1 = r0.next();
        if (r1.flattenChildrenCount() <= 0) goto L7;
        if (r1.getNeedSortChildren() == false) goto L7;
        sortTranslateZChildren(r1);
        r1.setNeedSortChildren(false);
        goto L7
    }

    public void destroy() {
        TraceEvent.beginSection("UIOwner.destroy");
        Iterator<Map.Entry<Integer, LynxBaseUI>> r1 = this.mUIHolder.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<Integer, LynxBaseUI> r2 = r1.next();
        if ((r2.getValue() instanceof LynxBaseUI) == false) goto L4;
        LynxBaseUI r3 = r2.getValue();
        if (r3 == null) goto L4;
        r3.destroy();
        goto L4
    L11:
        LynxContext r4 = this.mContext;
        if (r4 == null) goto L14;
        r4.destory();
    L14:
        q7a.b r5 = this.mGestureArenaManager;
        if (r5 == null) goto L40;
        Map<Integer, WeakReference<p7a.a>> r6 = r5.a;
        if (r6 == null) goto L19;
        ((HashMap) r6).clear();
    L19:
        LinkedList<p7a.a> r7 = r5.b;
        if (r7 == null) goto L22;
        r7.clear();
    L22:
        LinkedList<p7a.a> r8 = r5.c;
        if (r8 == null) goto L25;
        r8.clear();
    L25:
        s7a.b r9 = r5.e;
        if (r9 == null) goto L28;
        ((HashMap) r9.a).clear();
    L28:
        t7a.d r10 = r5.h;
        if (r10 == null) goto L40;
        VelocityTracker r11 = r10.f;
        if (r11 != null) goto L42;
    L37:
        r10.b = null;
        HashSet<p7a.a> r12 = r10.g;
        if (r12 == null) goto L40;
        r12.clear();
        goto L40
    L42:
        r11.recycle();     // Catch: IllegalStateException -> L34
    L36:
        r10.f = null;
    L34:
        e = move-exception;
        LLog.e("GestureHandlerTrigger", e.toString());
    L40:
        this.mCreateNodeAsyncTasks.clear();
        TraceEvent.endSection("UIOwner.destroy");
    }

    public Set<String> getComponentSet() {
        return new HashSet();
    }

    public boolean getEnableCreateViewAsync() {
        return this.mContext.getEnableCreateViewAsync();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v0 ??, still in use, count: 1, list:
          (r12v0 ?? I:java.lang.Object) from 0x0047: INVOKE (r0v1 ?? I:java.util.HashMap), (r9v0 ?? I:java.lang.Object), (r12v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:71)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public java.util.HashMap<java.lang.String, a8a.a> getMemoryUsage() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            r13 = this;
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r0 = r13.mUIHolder
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r1 = r13.mUIHolder
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L15:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L74
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            com.lynx.tasm.behavior.ui.LynxBaseUI r2 = (com.lynx.tasm.behavior.ui.LynxBaseUI) r2
            if (r2 == 0) goto L6c
            java.lang.String r9 = r2.getTagName()
            if (r9 != 0) goto L30
            goto L15
        L30:
            long r10 = r2.getMemoryUsageBytes()
            java.lang.Object r3 = r0.get(r9)
            a8a.a r3 = (a8a.a) r3
            if (r3 != 0) goto L4a
            a8a.a r12 = new a8a.a
            r5 = 0
            r7 = 0
            r8 = 0
            r3 = r12
            r4 = r9
            r3.<init>(r4, r5, r7, r8)
            r0.put(r9, r12)
        L4a:
            int r4 = r3.c
            int r4 = r4 + 1
            r3.c = r4
            long r4 = r3.b
            long r4 = r4 + r10
            r3.b = r4
            java.util.Map r2 = r2.getMemoryUsageDetail()
            if (r2 == 0) goto L15
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.d
            if (r4 != 0) goto L66
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r3.d = r4
        L66:
            java.util.Map<java.lang.String, java.lang.String> r3 = r3.d
            r3.putAll(r2)
            goto L15
        L6c:
            java.lang.String r2 = "LynxUIOwner"
            java.lang.String r3 = "getMemoryUsage failed, the ui is null or not LynxBaseUI"
            com.lynx.tasm.base.LLog.e(r2, r3)
            goto L15
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.behavior.LynxUIOwner.getMemoryUsage():java.util.HashMap");
    }

    public int getRootHeight() {
        return this.mUIBody.getHeight();
    }

    public int getRootWidth() {
        return this.mUIBody.getWidth();
    }

    public void onEnterBackground() {
        List<j> r0 = this.mForegroundListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<j> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().B();
        goto L7
    }

    public void onEnterForeground() {
        List<j> r0 = this.mForegroundListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<j> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().p();
        goto L7
    }

    public void performLayout() {
        this.mUIBody.layoutChildren();
        if (this.mUIBody.getLynxContext().getEventEmitter() == null) goto L5;
        this.mUIBody.getLynxContext().getEventEmitter().sendLayoutEvent();
    L5:
        didPerformLayout();
    }

    public void performMeasure() {
        this.mUIBody.measureChildren();
    }

    public void setEnableSyncXElementRegistry() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("x-viewpager-ng", "viewpager");
        r0.put("x-viewpager-item-ng", LynxViewpagerItem.X_ELEMENT_TAG);
        r0.put("x-webview", "webview");
        r0.put("x-overlay-ng", "overlay");
        r0.put("x-refresh-view", "refresh");
        r0.put("x-refresh-header", "refresh-header");
        r0.put("x-blur-view", "blur-view");
        r0.put("x-foldview-ng", "scroll-coordinator");
        r0.put("x-foldview-header-ng", "scroll-coordinator-header");
        r0.put("x-foldview-slot-ng", "scroll-coordinator-slot");
        r0.put("x-foldview-slot-drag-ng", "scroll-coordinator-slot-drag");
        r0.put("x-foldview-toolbar-ng", "scroll-coordinator-toolbar");
        r0.put("x-input-ng", "input");
        r0.put("x-textarea-ng", "textarea");
        Iterator r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        com.lynx.tasm.behavior.a r3 = this.mBehaviorRegistry.c((String) r2.getKey());     // Catch: RuntimeException -> L8
        this.mBehaviorRegistry.a(new h((String) r2.getValue(), r3));     // Catch: RuntimeException -> L8
        goto L4
    }

    public z7a.k getMeaningfulPaintingAreas() {
        UIBody r0 = getRootUI();
        if (r0 != null) goto L5;
        return null;
    L5:
        List<com.lynx.tasm.behavior.ui.e> r2 = r0.getMeaningfulPaintingAreas();
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r2.size() > 0) goto L11;
        return null;
    L11:
        return new z7a.k(r0.getWidth(), r0.getHeight(), r2);
    }

    public void rebuildViewTree() {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r0 = "UIOwner.rebuildViewTree";
        TraceEvent.beginSection("UIOwner.rebuildViewTree");
    L6:
        this.mUIBody.rebuildViewTree();
        if (TraceEvent.isTracingStarted() == false) goto L10;
        TraceEvent.endSection(r0);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public LynxContext getContext() {
        return this.mContext;
    }

    public q7a.b getGestureArenaManager() {
        return this.mGestureArenaManager;
    }

    public boolean getHasTouchPseudo() {
        return this.mHasTouchPseudo;
    }

    public l getPaintingContext() {
        return this.mPaintingContext;
    }

    public int getRootSign() {
        return this.mRootSign;
    }

    public UIBody getRootUI() {
        return this.mUIBody;
    }

    public boolean isContextFree() {
        return this.mIsContextFree;
    }

    public static /* synthetic */ HashMap access$200(LynxUIOwner r0) {
        return r0.mUIHolder;
    }

    public static /* synthetic */ LynxContext access$300(LynxUIOwner r0) {
        return r0.mContext;
    }

    private void addShadowProxy(LynxBaseUI r5) {
        LynxBaseUI r0 = r5.getParentBaseUI();
        if (r0 == null) goto L5;
        int r1 = r0.getIndex(r5);
        remove(r0.getSign(), r5.getSign());
    L6:
        this.mContext.removeUIFromExposedMap(r5);
        UIShadowProxy r2 = new UIShadowProxy(this.mContext, r5);
        this.mUIHolder.put(Integer.valueOf(r5.getSign()), r2);
        if (r0 == null) goto L10;
        insert(r0.getSign(), r2.getSign(), r1);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private void checkTranslateZ(LynxBaseUI r2) {
        if (r2.getParentBaseUI() == null) goto L6;
        checkTranslateZ(r2.getSign(), r2.getParentBaseUI().getSign());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LynxBaseUI createViewInterval(com.lynx.tasm.behavior.ui.j r6) {
        if (this.mRootSign < 0) goto L5;
    L32:
        LynxBaseUI r0 = createUI(r6.d, r6.c, r6);
    L33:
        if (r0 != null) goto L35;
        return r0;
    L35:
        r0.setEvents(r6.e);
        r0.setSign(r6.a, r6.d);
        r0.setNodeIndex(r6.b);
        r0.setGestureDetectors(r6.f);
        return r0;
    L5:
        if (r6.d.equals("page") == false) goto L32;
        r0 = this.mUIBody;
        this.mRootSign = r6.a;
        if (r0 == null) goto L33;
        UIBody.UIBodyView.a r1 = this.mAttachLynxPageUICallback;
        if (r1 == null) goto L33;
        WeakReference r2 = new WeakReference(r0);
        c7a.c r3 = (c7a.c) r1;
        r3.getClass();
        if ((r2.get() instanceof UIBody) == false) goto L33;
        UIBody r4 = (UIBody) r2.get();
        if (r4.getLynxContext() == null) goto L33;
        r4.getLynxContext().EnsureEventDispatcher();
        LynxBaseUI r5 = r3.a.get();
        if (r5 == null) goto L33;
        if (r5.getChildrenLynxPageUI() != null) goto L22;
        r5.setChildrenLynxPageUI(new HashMap());
    L22:
        r5.getChildrenLynxPageUI().put(String.valueOf(System.identityHashCode(r5)), r4);
        if (r5.getLynxContext() == null) goto L30;
        if (r5.getLynxContext().getLynxUIOwner() == null) goto L30;
        if (r5.getLynxContext().getLynxUIOwner().getRootUI() == null) goto L30;
        r4.setParentLynxPageUI(r5.getLynxContext().getLynxUIOwner().getRootUI());
    L30:
        if (r4.getView() == 0) goto L33;
        ((UIBody.UIBodyView) r4.getView()).setIsChildLynxPageUI(true);
        goto L33
    }

    private void destroyChildrenRecursively(LynxBaseUI r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.getChildren().size()) goto L6;
        LynxBaseUI r1 = r5.getChildAt(r0);
        r1.destroy();
        this.mUIHolder.remove(Integer.valueOf(r1.getSign()));
        this.mTranslateZParentHolder.remove(r1);
        this.mContext.removeUIFromExposedMap(r1);
        destroyChildrenRecursively(r1);
        r0 = r0 + 1;
        goto L4
    }

    private boolean hasShadowOrOutline(x0 r2) {
        if (r2.i("box-shadow") == false) goto L5;
    L12:
        return true;
    L5:
        if (r2.i("outline-color") == true) goto L12;
        if (r2.i("outline-style") == true) goto L12;
        if (r2.i("outline-width") == true) goto L12;
        return false;
    }

    private void insertChildIntoDrawListRecursive(LynxBaseUI r5) {
        Iterator<LynxBaseUI> r0 = r5.getChildren().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        LynxBaseUI r2 = r0.next();
        int r3 = r1 + 1;
        insertIntoDrawList(r5, r2, r1);
        if (r2.isFlatten() == false) goto L8;
        insertChildIntoDrawListRecursive(r2);
    L8:
        r1 = r3;
        goto L4
    }

    private static /* synthetic */ Map lambda$componentStatistic$1(String r2) {
        HashMap r0 = new HashMap();
        r0.put("component_name", r2);
        return r0;
    }

    private float[] normalizeStickyInfo(float[] r4) {
        if (r4 != null) goto L4;
    L13:
        return r4;
    L4:
        if (r4.length <= 4) goto L13;
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L9;
    L11:
        float[] r1 = new float[4];
        System.arraycopy(r4, 0, r1, 0, 4);
        return r1;
    L9:
        if (r0.getEnableNewSticky() == false) goto L11;
        return r4;
    }

    private void onNodeRemovedRecursively(LynxBaseUI r3) {
        boolean r0 = r3 instanceof UIShadowProxy;
        if (r0 == false) goto L5;
        LynxBaseUI r1 = ((UIShadowProxy) r3).a;
    L6:
        r1.onNodeRemoved();
        if (r0 == true) goto L12;
        Iterator<LynxBaseUI> r4 = r3.getChildren().iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        onNodeRemovedRecursively(r4.next());
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r1 = r3;
        goto L6
    }

    private void removeFromDrawList(LynxBaseUI r7) {
        UIGroup r0 = (UIGroup) r7.getDrawParent();
        LynxBaseUI r1 = r7.getParentBaseUI();
        if (r0 == null) goto L43;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r7.isFlatten() == true) goto L20;
        LynxBaseUI r2 = r7.getPreviousDrawUI();
        LynxBaseUI r4 = r7.getNextDrawUI();
        if (r2 == null) goto L13;
        r2.setNextDrawUI(r4);
        if (r4 == null) goto L17;
        r4.setPreviousDrawUI(r2);
    L17:
        if (r1.isFlatten() == false) goto L19;
        r0.removeView(r7);
    L19:
        r7.setNextDrawUI(null);
        r7.setPreviousDrawUI(null);
        r7.setDrawParent(null);
        return;
    L13:
        r0.setDrawHead(r4);
        if (r4 == null) goto L17;
        r4.setPreviousDrawUI(null);
        goto L17
    L20:
        LynxBaseUI r3 = r7;
    L22:
        if (r3.isFlatten() == false) goto L26;
        if (r3.getChildren().isEmpty() == true) goto L26;
        r3 = r3.getChildAt(r3.getChildren().size() - 1);
    L26:
        LynxBaseUI r5 = r7.getPreviousDrawUI();
        if (r5 == null) goto L31;
        r5.setNextDrawUI(r3.getNextDrawUI());
        if (r3.getNextDrawUI() == null) goto L34;
        r3.getNextDrawUI().setPreviousDrawUI(r5);
    L34:
        r7.setPreviousDrawUI(null);
        LynxBaseUI r6 = r7.getNextDrawUI();
    L36:
        if (r6 == r3.getNextDrawUI()) goto L38;
        r6.getPreviousDrawUI().setNextDrawUI(null);
        r6.setPreviousDrawUI(null);
        r0.removeView(r6);
        r6.setDrawParent(null);
        r6 = r6.getNextDrawUI();
        goto L36
    L38:
        r3.setNextDrawUI(null);
        r7.setDrawParent(null);
        r1.invalidate();
        return;
    L31:
        r0.setDrawHead(r3.getNextDrawUI());
        if (r3.getNextDrawUI() == null) goto L34;
        r3.getNextDrawUI().setPreviousDrawUI(null);
        goto L34
    }

    private void resetUIDrawingLayoutInfo(LynxBaseUI r2) {
        r2.setBound(null);
        r2.setLeft(r2.getOriginLeft());
        r2.setTop(r2.getOriginTop());
    }

    private void sortTranslateZChildren(LynxBaseUI r4) {
        Iterator<LynxBaseUI> r0 = r4.getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        removeFromDrawList(r0.next());
        goto L4
    L12:
        Collections.sort(r4.getChildren(), translationZComparator);     // Catch: Exception -> L8
    L10:
        insertChildIntoDrawListRecursive(r4);
        return;
    L8:
        e = move-exception;
        LLog.i(TAG, "Something went wrong during sort children by translation Z " + e.getStackTrace());
        goto L10
    }

    private void traceBeginWithInstanceId(String r4) {
        if (this.mContext == null) goto L5;
        HashMap r0 = new HashMap();
        r0.put("instance_id", String.valueOf(this.mContext.getInstanceId()));
        TraceEvent.beginSection(r4, r0);
        return;
    L5:
        TraceEvent.beginSection(r4);
    }

    public float[] align(int r2) {
        return this.mTextMeasurer.a(r2);
    }

    public void attachLynxContext(LynxContext r1) {
        if (r1 == null) goto L5;
        this.mContext = r1;
        return;
    }

    public void attachNativeFacade(NativeFacade r2) {
        this.mNativeFacade = new WeakReference(r2);
    }

    public void attachUIBodyView(UIBody.UIBodyView r3) {
        this.mUIBody.attachUIBodyView(r3, this.mContext);
        if (isContextFree() == true) goto L5;
        return;
    L5:
        if (this.mCreateNodeAsyncTasks.isEmpty() == true) goto L15;
        FutureTask<Runnable> r4 = this.mCreateNodeAsyncTasks.poll();
        if (r4 == null) goto L5;
        LynxThreadPool.g(new a(r4));
        goto L5
    }

    public boolean behaviorNeedProcessDirection(String r2) {
        if (r2.equals("page") == false) goto L7;
        return false;
    L7:
        return this.mBehaviorRegistry.c(r2).needProcessDirection();
    }

    public boolean behaviorSupportCreateAsync(String r2) {
        if (r2.equals("page") == false) goto L7;
        return false;
    L7:
        return this.mBehaviorRegistry.c(r2).supportCreateAsync();
    }

    public void componentStatistic(final String r3) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (this.mComponentSet.contains(r3) == true) goto L16;
        this.mComponentSet.add(r3);
        LynxContext r1 = this.mContext;
        if (r1 != null) goto L12;
        int r2 = -1;
    L13:
        LynxEventReporter.onEvent(LYNXSDK_COMPONENT_STATISTIC_EVENT, r2, new h0(r3));
        return;
    L12:
        r2 = r1.getInstanceId();
        goto L13
    }

    public LynxBaseUI findLynxUIByA11yId(String r5) {
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<Integer> r0 = this.mUIHolder.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        Integer r2 = r0.next();
        LynxBaseUI r3 = this.mUIHolder.get(r2);
        if (r3 == null) goto L7;
        if (r5.equals(r3.getAccessibilityId()) == false) goto L7;
        return r3;
    L13:
        return null;
    }

    public LynxBaseUI findLynxUIByComponentId(String r3) {
        if (r3.isEmpty() == true) goto L19;
        if ("-1".equals(r3) == true) goto L19;
        if (this.mComponentIdToUiIdHolder.containsKey(r3) == false) goto L20;
        int r4 = this.mComponentIdToUiIdHolder.get(r3).intValue();
    L13:
        if (r4 != (-1)) goto L17;
        return getRootUI();
    L17:
        return getNode(r4);
    L20:
        r4 = CastIntegerProtector.parseInt(r3);     // Catch: NumberFormatException -> L12
    L12:
        r4 = -1;
    L19:
        return getRootUI();
    }

    public LynxBaseUI findLynxUIByIdSelector(String r4) {
        Iterator<LynxBaseUI> r0 = this.mUIHolder.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        LynxBaseUI r1 = r0.next();
        if (r1 == null) goto L4;
        if (r4.equals(r1.getIdSelector()) == false) goto L4;
        return r1;
    L10:
        return null;
    }

    public LynxBaseUI findLynxUIByIndex(int r2) {
        return this.mUIHolder.get(Integer.valueOf(r2));
    }

    public LynxBaseUI findLynxUIByName(String r4) {
        Iterator<LynxBaseUI> r0 = this.mUIHolder.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        LynxBaseUI r1 = r0.next();
        if (r1 == null) goto L4;
        if (r4.equals(r1.getName()) == false) goto L4;
        return r1;
    L10:
        return null;
    }

    public LynxBaseUI findLynxUIBySign(int r3) {
        if ((this.mUIHolder.get(Integer.valueOf(r3)) instanceof UIShadowProxy) == false) goto L7;
        return ((UIShadowProxy) this.mUIHolder.get(Integer.valueOf(r3))).a;
    L7:
        return this.mUIHolder.get(Integer.valueOf(r3));
    }

    public LynxBaseUI getNode(int r2) {
        HashMap<Integer, LynxBaseUI> r0 = this.mUIHolder;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get(Integer.valueOf(r2));
    }

    public int getTagInfo(String r2) {
        ShadowNode r3 = this.mBehaviorRegistry.c(r2).createShadowNode();
        if (r3 != null) goto L6;
        return 1;
    L6:
        if (r3.p() == false) goto L8;
        return 6;
    L8:
        return 4;
    L11:
        return 0;
    }

    public void initGestureArenaManager(LynxContext r4) {
        if (this.mGestureArenaManager != null) goto L5;
        this.mGestureArenaManager = new q7a.b();
    L5:
        q7a.b r0 = this.mGestureArenaManager;
        r0.f = true;
        if (r0.d() == false) goto L10;
        r0.e = new s7a.b(r0);
        r0.a = new HashMap();
        r0.b = new LinkedList();
        r0.c = new LinkedList();
        r0.h = new t7a.d(r4, r0.e);
        return;
    }

    public void onNodeReady(int r2) {
        LynxBaseUI r3 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof UIShadowProxy) == false) goto L7;
        r3 = ((UIShadowProxy) r3).a;
    L7:
        r3.onNodeReady();
    }

    public void onNodeReload(int r2) {
        LynxBaseUI r3 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof UIShadowProxy) == false) goto L7;
        r3 = ((UIShadowProxy) r3).a;
    L7:
        r3.onNodeReload();
    }

    public void onNodeRemoved(int r2) {
        LynxBaseUI r3 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r3 == null) goto L6;
        onNodeRemovedRecursively(r3);
        return;
    }

    public void onTasmFinish(long r1) {
        List<r0> r2 = this.mContext.getPatchFinishListeners();
        if (r2 == null) goto L9;
        Iterator<r0> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        r3.next().onPatchFinish();
    L9:
        if (this.mUIBody.getBodyView() != null) goto L11;
        return;
    L11:
        if (this.mUIBody.getBodyView().HasPendingRequestLayout() == false) goto L16;
        LLog.i(TAG, "onTasmFinish do force RequestLayout after UpdateData in PreLoad Mode!");
        this.mUIBody.getBodyView().requestLayout();
        return;
    }

    public void registerBoundingClientRectUI(LynxBaseUI r2) {
        this.mCachedBoundingClientRectUI.add(r2);
    }

    public void registerForegroundListener(j r2) {
        List<j> r0 = this.mForegroundListeners;
        if (r0 == null) goto L6;
        r0.add(r2);
        return;
    }

    public void reportStatistic(String r3) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return;
    L6:
        if (LynxEnv.inst().enableComponentStatisticReport() == false) goto L9;
        componentStatistic(r3);
        return;
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r1) {
        this.mAttachLynxPageUICallback = r1;
    }

    public void setContextFree(boolean r1) {
        this.mIsContextFree = r1;
    }

    public void setHasTouchPseudo(boolean r1) {
        this.mHasTouchPseudo = r1;
    }

    public void setPaintingContext(l r1) {
        this.mPaintingContext = r1;
    }

    public void setRootSign(int r1) {
        this.mRootSign = r1;
    }

    public Object takeTextLayout(int r2) {
        com.lynx.tasm.behavior.shadow.text.d r0 = this.mTextMeasurer;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b.get(r2);
    }

    public void unregisterForegroundListener(j r2) {
        List<j> r0 = this.mForegroundListeners;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    public void validate(int r2) {
        LynxBaseUI r3 = getNode(r2);
        if (r3 != null) goto L6;
        LLog.e(TAG, "try to validate a not-existing node");
        return;
    L6:
        r3.renderIfNeeded();
    }

    public static /* synthetic */ void access$400(LynxUIOwner r0, String r1) {
        r0.traceBeginWithInstanceId(r1);
    }

    private void checkShadowOrOutline(x0 r3, LynxBaseUI r4) {
        if (hasShadowOrOutline(r3) == true) goto L6;
        return;
    L6:
        if (r3.a("box-shadow") != null) goto L11;
        if (r3.f("outline-style", -1) != (-1)) goto L11;
        return;
    L11:
        if ((r4 instanceof UIShadowProxy) == false) goto L13;
        return;
    L13:
        if ((r4.getParent() instanceof UIShadowProxy) == true) goto L18;
        addShadowProxy(r4);
        return;
    }

    private void checkTranslateZ(int r3, int r4) {
        if (this.mContext.getEnableFlattenTranslateZ() == true) goto L5;
        return;
    L5:
        LynxBaseUI r5 = this.mUIHolder.get(Integer.valueOf(r3));
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.getTranslationZ() == r5.getLastTranslateZ()) goto L17;
        LynxBaseUI r0 = this.mUIHolder.get(Integer.valueOf(r4));
        if (r0 != null) goto L13;
    L15:
        LynxBaseUI r6 = this.mUIHolder.get(Integer.valueOf(r4));
        this.mTranslateZParentHolder.add(r6);
        r6.setNeedSortChildren(true);
        r5.setLastTranslateZ(r5.getTranslationZ());
        return;
    L13:
        if (r0.isFlatten() == false) goto L15;
        newUpdateFlatten(r4, false);
        goto L15
    }

    private LynxBaseUI consumeInitialProps(LynxBaseUI r2, x0 r3) {
        return afterConsumeInitialProps(r2, consumeInitialPropsInterval(r2, r3), r3);
    }

    private UIShadowProxy consumeInitialPropsInterval(LynxBaseUI r3, x0 r4) {
        UIShadowProxy r0 = null;
        if (r4 != null) goto L5;
    L8:
        return r0;
    L5:
        if (hasShadowOrOutline(r4) == false) goto L7;
        r0 = new UIShadowProxy(this.mContext, r3);
    L7:
        r3.updatePropertiesInterval(r4);
        goto L8
    }

    private LynxBaseUI findLynxUIByIdWithGroup(String r5, UIGroup r6) {
        int r0 = 0;
    L4:
        if (r0 >= r6.getChildCount()) goto L18;
        LynxBaseUI r1 = r6.getChildAt(r0);
        if (r1.getIdSelector() == null) goto L11;
        if (r1.getIdSelector().equals(r5) == false) goto L11;
        return r1;
    L11:
        if (r1.getTagName().equals("component") == true) goto L17;
        if ((r1 instanceof UIGroup) == false) goto L17;
        LynxBaseUI r2 = findLynxUIByIdWithGroup(r5, (UIGroup) r1);
        if (r2 == null) goto L17;
        return r2;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return null;
    }

    private void insertA11yMutationEvent(int r3, LynxBaseUI r4) {
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mUIBody.getLynxAccessibilityWrapper();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.k != null) goto L7;
        return;
    L7:
        if (r0.m() == false) goto L12;
        r0.k.a(r3, r4, NameKeys.UnloadStrategy_No_Strategy);
        return;
    }

    private void newRemove(int r4, int r5) {
        if (this.mUIHolder.size() <= 0) goto L25;
        LynxBaseUI r0 = this.mUIHolder.get(Integer.valueOf(r5));
        if (r0 == null) goto L24;
        if (r4 != (-1)) goto L9;
        LynxBaseUI r6 = r0.getParentBaseUI();
    L10:
        if (r6 == null) goto L22;
        if (TraceEvent.isTracingStarted() == false) goto L14;
        String r7 = "UIOwner.remove." + r6.getTagName() + "." + r0.getTagName();
        TraceEvent.beginSection(r7);
    L15:
        removeFromDrawList(r0);
        r6.removeChild(r0);
        resetUIDrawingLayoutInfo(r0);
        if (r0.isFlatten() == false) goto L18;
        r6.flattenChildrenCountDecrement();
    L18:
        r0.removeChildrenExposureUI();
        insertA11yMutationEvent(1, r0);
        if (TraceEvent.isTracingStarted() == false) goto L26;
        TraceEvent.endSection(r7);
        return;
    L26:
        return;
    L14:
        r7 = null;
        goto L15
    L22:
        throw new RuntimeException("Trying to remove unknown ui signature: " + r5);
    L9:
        r6 = this.mUIHolder.get(Integer.valueOf(r4));
        goto L10
    L24:
        throw new RuntimeException("Trying to remove unknown ui signature: " + r5);
    }

    private void newUpdateFlatten(int r9, boolean r10) {
        LynxBaseUI r11 = this.mUIHolder.get(Integer.valueOf(r9));
        if (r11 != null) goto L5;
        return;
    L5:
        LynxBaseUI r0 = r11.getParentBaseUI();
        x0 r1 = new x0(r11.getProps());
        ArrayList r2 = new ArrayList(r11.getChildren());
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r3 = "UIOwner.updateFlatten." + r11.getTagName();
        TraceEvent.beginSection(r3);
    L9:
        int r4 = 0;
        if (r0 == null) goto L12;
        int r5 = r0.getIndex(r11);
        removeFromDrawList(r11);
        r0.removeChild(r11);
    L14:
        if (r11.isFlatten() == true) goto L19;
        Iterator r6 = r2.iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        removeFromDrawList((LynxBaseUI) r6.next());
    L19:
        int r7 = r11.getChildren().size() - 1;
    L20:
        if (r7 < 0) goto L22;
        r11.removeChild(r11.getChildAt(r7));
        r7 = r7 - 1;
        goto L20
    L22:
        LynxBaseUI r12 = createUI(r11.getTagName(), r10);
        r11.applyUIPaintStylesToTarget(r12);
        r12.setSign(r11.getSign(), r11.getTagName());
        consumeInitialProps(r12, r1);
        this.mUIHolder.put(Integer.valueOf(r11.getSign()), r12);
        if (this.mTranslateZParentHolder.contains(r11) == false) goto L25;
        this.mTranslateZParentHolder.remove(r11);
        this.mTranslateZParentHolder.add(r12);
    L25:
        if (r0 == null) goto L27;
        r0.insertChild(r12, r5);
        insertIntoDrawList(r0, r12, r5);
    L27:
        Iterator r8 = r2.iterator();
    L29:
        if (r8.hasNext() == false) goto L31;
        LynxBaseUI r13 = (LynxBaseUI) r8.next();
        resetUIDrawingLayoutInfo(r13);
        r12.insertChild(r13, r4);
        r4 = r4 + 1;
        goto L29
    L31:
        insertChildIntoDrawListRecursive(r12);
        r12.updateLayoutInfo(r11);
        r12.copyPropFromOldUiInUpdateFlatten(r11);
        r12.measure();
        ((LynxUI) r12).handleLayout();
        if ((r12 instanceof UIGroup) == false) goto L34;
        ((UIGroup) r12).layoutChildren();
    L34:
        r12.invalidate();
        r11.destroy();
        if (TraceEvent.isTracingStarted() == false) goto L41;
        TraceEvent.endSection(r3);
        return;
    L41:
        return;
    L12:
        r5 = 0;
        goto L14
    L8:
        r3 = null;
        goto L9
    }

    public LynxBaseUI createUI(String r2, boolean r3) {
        return createUI(r2, r3, null);
    }

    public void destroy(int r4, int r5) {
        TraceEvent.beginSection("UIOwner.destroy.item");
        if (this.mUIHolder.size() <= 0) goto L19;
        LynxBaseUI r1 = this.mUIHolder.get(Integer.valueOf(r5));
        if (r1 != null) goto L8;
        TraceEvent.endSection("UIOwner.destroy.item");
        return;
    L8:
        this.mTranslateZParentHolder.remove(r1);
        removeFromDrawList(r1);
        this.mUIHolder.remove(Integer.valueOf(r5));
        this.mContext.removeUIFromExposedMap(r1);
        r1.destroy();
        insertA11yMutationEvent(2, r1);
        if (this.mContext.getEnableFiberArch() == true) goto L12;
        destroyChildrenRecursively(r1);
    L12:
        if (r4 != (-1)) goto L14;
        LynxBaseUI r6 = r1.getParentBaseUI();
    L15:
        if (r6 != null) goto L18;
        TraceEvent.endSection("UIOwner.destroy.item");
        return;
    L18:
        r6.removeChild(r1);
        goto L19
    L14:
        r6 = this.mUIHolder.get(Integer.valueOf(r4));
    L19:
        TraceEvent.endSection("UIOwner.destroy.item");
    }

    public void dispatchLayoutBefore(int r2, ReadableCompactArrayBuffer r3) {
        this.mTextMeasurer.c(r2, r3);
    }

    public LynxBaseUI findLynxUIById(String r6, LynxBaseUI r7) {
        if (r7 == null) goto L9;
        if (r7.getIdSelector() == null) goto L9;
        if (r7.getIdSelector().equals(r6) == false) goto L9;
        return r7;
    L9:
        if ((r7 instanceof UIGroup) == true) goto L11;
        return null;
    L11:
        UIGroup r8 = (UIGroup) r7;
        int r0 = 0;
    L13:
        if (r0 >= r8.getChildCount()) goto L27;
        LynxBaseUI r2 = r8.getChildAt(r0);
        if (r2.getIdSelector() == null) goto L20;
        if (r2.getIdSelector().equals(r6) == false) goto L20;
        return r2;
    L20:
        if (r2.getTagName().equals("component") == true) goto L26;
        if ((r2 instanceof UIGroup) == false) goto L26;
        LynxBaseUI r3 = findLynxUIById(r6, r2);
        if (r3 == null) goto L26;
        return r3;
    L26:
        r0 = r0 + 1;
        goto L13
    L27:
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelector(String r4, LynxBaseUI r5) {
        if (r5 == null) goto L9;
        if (r5.getIdSelector() == null) goto L9;
        if (r5.getIdSelector().equals(r4) == false) goto L9;
        return r5;
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        Iterator<LynxBaseUI> r6 = r5.getChildren().iterator();
    L13:
        if (r6.hasNext() == false) goto L24;
        LynxBaseUI r1 = r6.next();
        if (r1.getIdSelector() == null) goto L20;
        if (r1.getIdSelector().equals(r4) == false) goto L20;
        return r1;
    L20:
        if ((r1 instanceof UIComponent) == true) goto L13;
        LynxBaseUI r2 = findLynxUIByIdSelector(r4, r1);
        if (r2 == null) goto L13;
        return r2;
    L24:
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelectorSearchUp(String r2, LynxBaseUI r3) {
        if (r3 != null) goto L6;
        LLog.e(TAG, "findLynxUIByIdSelectorSearchUp failed, the ui is null for " + r2 + ".");
        return null;
    L6:
        if (r3.getIdSelector() == null) goto L11;
        if (r3.getIdSelector().equals(r2) == false) goto L11;
        return r3;
    L11:
        return findLynxUIByIdSelectorSearchUp(r2, r3.getParentBaseUI());
    }

    public LynxBaseUI findLynxUIByRefId(String r5, LynxBaseUI r6) {
        if (r6 == null) goto L9;
        if (r6.getRefIdSelector() == null) goto L9;
        if (r6.getRefIdSelector().equals(r5) == false) goto L9;
        return r6;
    L9:
        if (r6 != null) goto L11;
        return null;
    L11:
        Iterator<LynxBaseUI> r7 = r6.getChildren().iterator();
    L13:
        if (r7.hasNext() == false) goto L24;
        LynxBaseUI r1 = r7.next();
        if (r1.getRefIdSelector() == null) goto L20;
        if (r1.getRefIdSelector().equals(r5) == false) goto L20;
        return r1;
    L20:
        if (r1.getTagName().equals("component") == true) goto L13;
        LynxBaseUI r2 = findLynxUIByRefId(r5, r1);
        if (r2 == null) goto L13;
        return r2;
    L24:
        return null;
    }

    public void listCellAppear(int r2, String r3) {
        LynxBaseUI r4 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r4.onListCellAppear(r3, r4.getParentBaseUI());
        return;
    }

    public void onLayoutFinish(int r7, long r8) {
        handleTranslateZUI();
        if (this.mUIBody.getLynxAccessibilityWrapper() == null) goto L46;
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mUIBody.getLynxAccessibilityWrapper();
        if (r0.k == null) goto L23;
        if (r0.m() == false) goto L23;
        if (r0.h() == null) goto L23;
        if (r0.h().getLynxContext() == null) goto L23;
        com.lynx.tasm.behavior.ui.accessibility.a r1 = r0.k;
        LynxContext r2 = r0.h().getLynxContext();
        if (r2 != null) goto L15;
        r1.getClass();
        goto L23
    L15:
        if (r1.a.isEmpty() == true) goto L23;
        JavaOnlyArray r3 = new JavaOnlyArray();
        Iterator<JavaOnlyMap> r4 = r1.a.iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        r3.add(r4.next());
        goto L18
    L20:
        JavaOnlyArray r5 = new JavaOnlyArray();
        r5.add(r3);
        r2.sendGlobalEvent("a11y-mutations", r5);
        r1.a.clear();
    L23:
        if (r0.f() == false) goto L46;
        LynxAccessibilityHelper r6 = r0.n;
        if (r6.d.isEmpty() == true) goto L36;
        Iterator<WeakReference<LynxBaseUI>> r9 = r6.d.iterator();
    L28:
        if (r9.hasNext() == false) goto L34;
        WeakReference<LynxBaseUI> r10 = r9.next();
        if (r10 == null) goto L28;
        if (r10.get() == null) goto L28;
        r6.b(r10.get());
        goto L28
    L34:
        r6.d.clear();
    L36:
        if (r6.c.isEmpty() == true) goto L46;
        Iterator<WeakReference<LynxBaseUI>> r11 = r6.c.iterator();
    L39:
        if (r11.hasNext() == false) goto L45;
        WeakReference<LynxBaseUI> r12 = r11.next();
        if (r12 == null) goto L39;
        if (r12.get() == null) goto L39;
        r6.b(r12.get());
        goto L39
    L45:
        r6.c.clear();
    L46:
        UIBody.UIBodyView r13 = this.mUIBody.getBodyView();
        if (r13 == null) goto L54;
        int r14 = this.mUIBody.getWidth();
        int r15 = this.mUIBody.getHeight();
        if (r14 == r13.getIntrinsicWidth()) goto L51;
    L52:
        r13.setIntrinsicContentSize(r14, r15);
        goto L54
    L51:
        if (r15 != r13.getIntrinsicHeight()) goto L52;
    L54:
        if (r8 != 0) goto L56;
        return;
    L56:
        LynxBaseUI r16 = this.mUIHolder.get(Integer.valueOf(getSignFromOperationId(r8)));
        if (r16 != null) goto L59;
        return;
    L59:
        if (TraceEvent.isTracingStarted() == false) goto L61;
        String r17 = "UIOwner.layoutFinish." + r16.getTagName();
        TraceEvent.beginSection(r17);
    L62:
        r16.onLayoutFinish(r8, this.mUIHolder.get(Integer.valueOf(r7)));
        if (TraceEvent.isTracingStarted() == false) goto L82;
        TraceEvent.endSection(r17);
        return;
    L82:
        return;
    L61:
        r17 = null;
        goto L62
    }

    public void remove(int r1, int r2) {
        newRemove(r1, r2);
    }

    public void reuseListNode(int r2, String r3) {
        LynxBaseUI r4 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4.getParentBaseUI() instanceof UIList) == false) goto L7;
    L8:
        r4.onListCellPrepareForReuse(r3, r4.getParentBaseUI());
        return;
    L7:
        if ((r4.getParentBaseUI() instanceof UIListContainer) == true) goto L8;
    }

    public void setFrameAppBundle(int r1, TemplateBundle r2) {
        updateViewExtraData(r1, r2);
    }

    public void setNode(int r2, LynxBaseUI r3) {
        HashMap<Integer, LynxBaseUI> r0 = this.mUIHolder;
        if (r0 == null) goto L6;
        r0.put(Integer.valueOf(r2), r3);
        return;
    }

    public void updateFlatten(int r1, boolean r2) {
        newUpdateFlatten(r1, r2);
    }

    public void updateViewExtraData(int r3, Object r4) {
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI r5 = this.mUIHolder.get(Integer.valueOf(r3));
        if (r5 != null) goto L5;
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r0 = "UIOwner.updateViewExtraData." + r5.getTagName();
        TraceEvent.beginSection(r0);
    L8:
        r5.updateExtraData(r4);
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection(r0);
        return;
    L13:
        return;
    L7:
        r0 = null;
        goto L8
    }

    public LynxUIOwner(LynxContext r4, com.lynx.tasm.behavior.c r5, UIBody.UIBodyView r6) {
        this.mIsContextFree = false;
        this.mSettingsEnableNewImage = null;
        this.mCreateNodeAsyncTasks = new ConcurrentLinkedQueue();
        TraceEvent.beginSection("LynxUIOwner initialized");
        this.mContext = r4;
        this.mBehaviorRegistry = r5;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        this.mComponentSet = ConcurrentHashMap.newKeySet();
    L6:
        this.mTranslateZParentHolder = new HashSet();
        this.mForegroundListeners = new ArrayList();
        this.mUIHolder = new HashMap();
        this.mTextChildUIHolder = new HashMap();
        this.mComponentIdToUiIdHolder = new HashMap();
        this.mRootSign = -1;
        UIBody r7 = new UIBody(this.mContext, r6);
        this.mUIBody = r7;
        this.mContext.setUIBody(r7);
        this.mIsFirstLayout = true;
        this.mIsRootLayoutAnimationRunning = true;
        this.mCachedBoundingClientRectUI = new HashSet();
        this.mEnableReportCreateAsync = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_REPORT_CREATE_ASYNC_TAG, false);
        this.mCreateNodeConfigHasReportedMark = new HashMap();
        if (r4.isLayoutInElementModeOn() == false) goto L9;
        this.mTextMeasurer = new com.lynx.tasm.behavior.shadow.text.d(r4);
    L9:
        attachUIBodyView(r6);
        TraceEvent.endSection("LynxUIOwner initialized");
        return;
    L5:
        this.mComponentSet = new HashSet();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LynxBaseUI afterConsumeInitialProps(LynxBaseUI r6, UIShadowProxy r7, x0 r8) {
        if ((r6 instanceof r0) == false) goto L6;
        this.mContext.registerPatchFinishListener((r0) r6);
    L6:
        if ((r6 instanceof j) == false) goto L8;
        registerForegroundListener((j) r6);
    L8:
        if (r8 == null) goto L32;
        r6.afterPropsUpdated(r8);
        boolean r1 = true;
        if (r8.i("transition") == true) goto L18;
        MapBuffer r0 = r8.b;
        if (r0 == null) goto L14;
        boolean r2 = r0.contains(109);
    L15:
        if (r2 == true) goto L18;
        boolean r3 = false;
    L19:
        if (r3 == false) goto L22;
        r6.initTransitionAnimator(r8.a);
    L22:
        if (r8.i("animation") == true) goto L30;
        MapBuffer r4 = r8.b;
        if (r4 == null) goto L26;
        boolean r5 = r4.contains(64);
    L27:
        if (r5 == true) goto L30;
        r1 = false;
        goto L30
    L26:
        r5 = false;
    L30:
        if (r1 == false) goto L32;
        r6.setAnimation(r8.a("animation"));
        goto L32
    L14:
        r2 = false;
    L18:
        r3 = true;
    L32:
        if (r7 != null) goto L34;
        return r6;
    L34:
        return r7;
    }

    private LynxBaseUI createSwiperIfNeeded(String r2, LynxBaseUI r3, Object r4) {
        if ("swiper".equals(r2) == true) goto L9;
        if ("x-swiper".equals(r2) == true) goto L9;
        return r3;
    L9:
        return new XSwiperUI(this.mContext, r4);
    }

    private LynxBaseUI createUI(String r5, boolean r6, Object r7) {
        LynxBaseUI r1 = null;
        if (this.mContext.isUseNewSwiper() == false) goto L5;
        r1 = createSwiperIfNeeded(r5, null, r7);
    L5:
        if (r1 != null) goto L23;
        com.lynx.tasm.behavior.a r8 = this.mBehaviorRegistry.c(r5);
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mContext.getLynxAccessibilityWrapper();
        if (r0 != null) goto L9;
    L16:
        if (r6 == true) goto L18;
    L20:
        if (r1 == null) goto L22;
        return r1;
    L22:
        return r8.createUIWithParams(this.mContext, r7);
    L18:
        if (r8.supportUIFlatten() == false) goto L20;
        r1 = r8.createFlattenUIWithParams(this.mContext, r7);
        goto L20
    L9:
        if (r0.f() == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r6 = false;
        goto L16
    L11:
        if (r0.k() == false) goto L13;
        r2 = true;
        goto L14
    L23:
        return r1;
    }

    private void insertIntoDrawList(LynxBaseUI r4, LynxBaseUI r5, int r6) {
        r5.setNextDrawUI(null);
        if (r4.isFlatten() == false) goto L5;
        LynxBaseUI r1 = r4.getDrawParent();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r6 != 0) goto L14;
        LynxUI r7 = (LynxUI) r1;
        if (r4.isFlatten() == true) goto L13;
        r4 = null;
    L13:
        r7.insertDrawList(r4, r5);
    L22:
        if (r5.isFlatten() == true) goto L29;
        UIGroup r2 = (UIGroup) r1;
        if (r2.isInsertViewCalled() == false) goto L30;
        r2.insertView((LynxUI) r5);
        return;
    L30:
        return;
    L29:
        return;
    L14:
        LynxBaseUI r8 = r4.getChildAt(r6 - 1);
    L16:
        if (r8.isFlatten() == false) goto L20;
        if (r8.getChildren().isEmpty() == true) goto L20;
        r8 = r8.getChildAt(r8.getChildren().size() - 1);
    L20:
        ((LynxUI) r1).insertDrawList(r8, r5);
        goto L22
    L5:
        r1 = r4;
        goto L6
    }

    private static /* synthetic */ Map lambda$reportCreateViewConfig$3(String r2, String r3, boolean r4) {
        HashMap r0 = new HashMap();
        r0.put("tag_name", r2);
        r0.put("class_name", r3);
        r0.put("enable_async", Boolean.valueOf(r4));
        return r0;
    }

    private void newInsert(int r4, int r5, int r6) {
        if (this.mUIHolder.size() > 0) goto L5;
        return;
    L5:
        if (this.mUIHolder.get(Integer.valueOf(r4)) == null) goto L26;
        LynxBaseUI r0 = this.mUIHolder.get(Integer.valueOf(r5));
        if (r0 == null) goto L24;
        checkTranslateZ(r5, r4);
        LynxBaseUI r7 = this.mUIHolder.get(Integer.valueOf(r4));
        if (r7.canHaveFlattenChild() == true) goto L14;
        if (r0.isFlatten() == false) goto L14;
        newUpdateFlatten(r5, false);
        r0 = this.mUIHolder.get(Integer.valueOf(r5));
    L14:
        if (r6 != (-1)) goto L16;
        r6 = r7.getChildren().size();
    L16:
        r7.insertChild(r0, r6);
        insertIntoDrawList(r7, r0, r6);
        if (r0.isFlatten() == false) goto L20;
        r7.flattenChildrenCountIncrement();
    L20:
        if (r0.isFlatten() == false) goto L22;
        insertChildIntoDrawListRecursive(r0);
        r0.requestLayout();
        r0.invalidate();
    L22:
        insertA11yMutationEvent(0, r0);
        return;
    L24:
        throw new RuntimeException("Insertion (new) failed due to unknown child signature: " + r5);
    L26:
        throw new RuntimeException("Insertion (new) failed due to unknown parent signature: " + r4);
    }

    private void updateComponentIdToUiIdMapIfNeeded(int r2, String r3, x0 r4) {
        if (r3.equals("component") == true) goto L5;
        return;
    L5:
        if (r4.i("ComponentID") == false) goto L12;
        String r5 = r4.h("ComponentID");
        if (r5 != null) goto L9;
        r5 = "-1";
    L9:
        this.mComponentIdToUiIdHolder.put(r5, Integer.valueOf(r2));
        return;
    }

    public void cleanupCreatedView(int r1, String r2, ReadableMap r3) {
        if (getNode(r1) != null) goto L5;
        return;
    L5:
        destroy(-1, r1);
    }

    public void consumeGesture(int r1, int r2, ReadableMap r3) {
        LynxBaseUI r4 = getNode(r1);
        if (r4 != null) goto L6;
        LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r4.consumeGesture(r2, r3);
    }

    public void dump(StringBuilder r3, LynxBaseUI r4, int r5) {
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r3.append(" ");
        r0 = r0 + 1;
        goto L3
    L5:
        r3.append("id: ");
        r3.append(r4.getSign());
        r3.append(", tag: ");
        r3.append(r4.getTagName());
        r3.append(", rect: [");
        r3.append(r4.getLeft());
        r3.append(", ");
        r3.append(r4.getTop());
        r3.append(", ");
        r3.append(r4.getWidth());
        r3.append(", ");
        r3.append(r4.getHeight());
        r3.append("]");
        if (r4.getLynxBackground() == null) goto L8;
        r3.append(", bg: 0x");
        r3.append(Integer.toHexString(r4.getLynxBackground().e));
    L8:
        r3.append("\n");
    }

    public void dumpDrawList(StringBuilder r1, UIGroup r2, int r3) {
        dump(r1, r2, r3);
        LynxBaseUI r4 = r2.getDrawHead();
    L3:
        if (r4 == null) goto L5;
        dump(r1, r4, r3);
        r4 = r4.getNextDrawUI();
        goto L3
    }

    public void dumpTree(StringBuilder r4, LynxBaseUI r5, int r6) {
        dump(r4, r5, r6);
        int r0 = 0;
    L4:
        if (r0 >= r5.getChildren().size()) goto L6;
        dumpTree(r4, (LynxBaseUI) ListProtector.get(r5.getChildren(), r0), r6 + 1);
        r0 = r0 + 1;
        goto L4
    }

    public void insert(int r1, int r2, int r3) {
        newInsert(r1, r2, r3);
    }

    public void listCellDisappear(int r2, Boolean r3, String r4) {
        LynxBaseUI r5 = this.mUIHolder.get(Integer.valueOf(r2));
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r5.onListCellDisAppear(r4, r5.getParentBaseUI(), r3.booleanValue());
        return;
    }

    public void reportCreateViewConfig(int r3, final String r4, final boolean r5) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (TextUtils.equals(r4, "page") == false) goto L11;
        return;
    L11:
        if (this.mEnableReportCreateAsync == true) goto L13;
        return;
    L13:
        if (this.mCreateNodeConfigHasReportedMark.containsKey(r4) == true) goto L22;
        this.mCreateNodeConfigHasReportedMark.put(r4, Boolean.valueOf(r5));
        LynxBaseUI r6 = getNode(r3);
        if (r6 == null) goto L17;
        final String r7 = r6.getClass().getSimpleName();
    L18:
        LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_CONFIG, getContext().getInstanceId(), new j0(r4, r7, r5));
        return;
    L17:
        r7 = null;
        goto L18
    }

    public void setGestureDetectorState(int r1, int r2, int r3) {
        LynxBaseUI r4 = getNode(r1);
        if (r4 != null) goto L6;
        LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r4.setGestureDetectorState(r2, r3);
    }

    public static /* synthetic */ LynxBaseUI access$000(LynxUIOwner r0, LynxBaseUI r1, UIShadowProxy r2, x0 r3) {
        return r0.afterConsumeInitialProps(r1, r2, r3);
    }

    public static /* synthetic */ void access$100(LynxUIOwner r0, int r1, String r2, x0 r3) {
        r0.updateComponentIdToUiIdMapIfNeeded(r1, r2, r3);
    }

    private static /* synthetic */ Map lambda$reportCreateAsyncSuccessEvent$2(String r2, String r3, boolean r4, int r5) {
        HashMap r0 = new HashMap();
        r0.put("tag_name", r2);
        r0.put("class_name", r3);
        r0.put("success", Boolean.valueOf(r4));
        r0.put("status", Integer.valueOf(r5));
        return r0;
    }

    public void invokeUIMethodForSelectorQuery(int r3, String r4, ReadableMap r5, Callback r6) {
        LynxBaseUI r7 = getNode(r3);
        if (r7 != null) goto L5;
        if (r6 == null) goto L16;
        r6.invoke(new Object[]{6, "node does not have a LynxUI"});
        return;
    L16:
        return;
    L5:
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r0 = "UIOwner.invokeUIMethodForSelectorQuery." + r7.getTagName() + "." + r4;
        TraceEvent.beginSection(r0);
    L8:
        LynxUIMethodsExecutor.b(r7, r4, r5, r6);
        if (TraceEvent.isTracingStarted() == false) goto L14;
        TraceEvent.endSection(r0);
        return;
    L14:
        return;
    L7:
        r0 = null;
        goto L8
    }

    public void reportCreateAsyncSuccessEvent(int r3, final String r4, final boolean r5, final int r6) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (this.mEnableReportCreateAsync == false) goto L16;
        LynxBaseUI r7 = getNode(r3);
        if (r7 == null) goto L12;
        final String r8 = r7.getClass().getSimpleName();
    L13:
        LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT, getContext().getInstanceId(), new i0(r4, r8, r5, r6));
        return;
    L12:
        r8 = null;
        goto L13
    }

    public void invokeUIMethod(String r9, ReadableArray r10, String r11, ReadableMap r12, Callback r13) {
        LynxBaseUI r14 = findLynxUIByComponentId(r9);
        String r0 = "component not found, nodes: " + r10.toString() + ", method: " + r11;
        if (r14 == null) goto L33;
        int r4 = 0;
    L6:
        if (r4 >= r10.size()) goto L33;
        String r5 = r10.getString(r4);
        if (r12 != null) goto L10;
    L16:
        boolean r6 = false;
    L18:
        if (r5.startsWith("#") == true) goto L23;
        if (r6 == true) goto L23;
        if (r13 == null) goto L43;
        r13.invoke(new Object[]{5, r5.concat(" not support, only support id selector currently")});
        return;
    L43:
        return;
    L23:
        String r7 = r5.substring(1);
        if (r6 == false) goto L26;
        r14 = findLynxUIByRefId(r5, r14);
    L27:
        if (r14 == null) goto L28;
        if (r14.getIdSelector() == null) goto L32;
        r14.getIdSelector().equals(r7);
    L32:
        r4 = r4 + 1;
        goto L6
    L28:
        r0 = "not found ".concat(r5);
        goto L33
    L26:
        r14 = findLynxUIByIdSelector(r7, r14);
        goto L27
    L10:
        if (r12.size() <= 0) goto L16;
        if (r12.hasKey("_isCallByRefId") == false) goto L16;
        if (r12.getBoolean("_isCallByRefId") == false) goto L16;
        r6 = true;
    L33:
        if (r14 == null) goto L35;
        LynxUIMethodsExecutor.b(r14, r11, r12, r13);
        return;
    L35:
        if (r13 == null) goto L45;
        r13.invoke(new Object[]{2, r0});
        return;
    }

    public void updateProperties(int r4, boolean r5, x0 r6, Map<String, EventsListener> r7, Map<Integer, s7a.a> r8) {
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI r0 = this.mUIHolder.get(Integer.valueOf(r4));
        if (r0 != null) goto L5;
        return;
    L5:
        updateComponentIdToUiIdMapIfNeeded(r4, r0.getTagName(), r6);
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r1 = "UIOwner.updateProps." + r0.getTagName();
        TraceEvent.beginSection(r1);
    L9:
        if (r7 == null) goto L11;
        r0.setEvents(r7);
    L11:
        if (r8 == null) goto L13;
        r0.setGestureDetectors(r8);
    L13:
        boolean r9 = true;
        if (r5 == false) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L21;
        updateFlatten(r4, false);
        r0 = this.mUIHolder.get(Integer.valueOf(r4));
    L21:
        if (r6 != null) goto L23;
    L54:
        r0.updateProperties(r6);
        checkTranslateZ(r0);
        if (TraceEvent.isTracingStarted() == false) goto L58;
        TraceEvent.endSection(r1);
        return;
    L58:
        return;
    L23:
        if (r6.j() == true) goto L54;
        if (r6.i("transition") == true) goto L33;
        MapBuffer r11 = r6.b;
        if (r11 == null) goto L29;
        boolean r12 = r11.contains(109);
    L30:
        if (r12 == true) goto L33;
        boolean r13 = false;
    L34:
        if (r13 == false) goto L40;
        if ((r0 instanceof UIShadowProxy) == false) goto L38;
        ((UIShadowProxy) r0).a.initTransitionAnimator(r6.a);
        goto L40
    L38:
        r0.initTransitionAnimator(r6.a);
    L40:
        if (r6.i("animation") == true) goto L48;
        MapBuffer r14 = r6.b;
        if (r14 == null) goto L44;
        boolean r15 = r14.contains(64);
    L45:
        if (r15 == true) goto L48;
        r9 = false;
        goto L48
    L44:
        r15 = false;
    L48:
        if (r9 == true) goto L50;
    L53:
        checkShadowOrOutline(r6, r0);
        goto L54
    L50:
        if ((r0 instanceof UIShadowProxy) == false) goto L52;
        ((UIShadowProxy) r0).a.setAnimation(r6.a("animation"));
        goto L53
    L52:
        r0.setAnimation(r6.a("animation"));
        goto L53
    L29:
        r12 = false;
    L33:
        r13 = true;
        goto L34
    L16:
        if (r0.isFlatten() == false) goto L18;
        r10 = true;
        goto L19
    L8:
        r1 = null;
        goto L9
    }

    public float[] measureText(int r8, float r9, int r10, float r11, int r12, float[] r13) {
        return this.mTextMeasurer.e(r8, r9, r10, r11, r12, r13);
    }

    private /* synthetic */ Runnable lambda$createViewAsync$0(String r13, int r14, int r15, boolean r16, x0 r17, Map r18, Map r19) throws Exception {
    L12:
        th = move-exception;
        String r1 = "createViewAsync failed, tagName:" + r13 + ", error:" + th;
        LLog.e(TAG, r1);
        Exception r2 = new Exception(r1);
        r2.setStackTrace(th.getStackTrace());
        UIThreadUtils.runOnUiThread(new f(this, r2));
        return null;
    L4:
        if (TraceEvent.isTracingStarted() == false) goto L6;
        String r0 = "UIOwner.createViewAsync." + r13;     // Catch: Throwable -> L12
        traceBeginWithInstanceId(r0);     // Catch: Throwable -> L12
    L7:
        LynxBaseUI r3 = createViewInterval(new com.lynx.tasm.behavior.ui.j(r14, r15, r16, r13, r18, r19));     // Catch: Throwable -> L12
        LynxBaseUI[] r4 = {r3};     // Catch: Throwable -> L12
        UIShadowProxy r5 = consumeInitialPropsInterval(r3, r17);     // Catch: Throwable -> L12
        if (TraceEvent.isTracingStarted() == false) goto L10;
        TraceEvent.endSection(r0);     // Catch: Throwable -> L12
    L10:
        return new e(this, r13, r4, r5, r17, r14);
    L6:
        r0 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.lynx.tasm.behavior.g0, java.util.concurrent.Callable] */
    public Future<Runnable> createViewAsync(final int r11, final String r12, final x0 r13, final Map<String, EventsListener> r14, final boolean r15, final int r16, final Map<Integer, s7a.a> r17) {
        ?? r9 = new g0(this, r12, r11, r16, r15, r13, r14, r17);
        if (isContextFree() == false) goto L7;
        FutureTask<Runnable> r0 = new FutureTask(r9);
        this.mCreateNodeAsyncTasks.add(r0);
        return r0;
    L7:
        return LynxThreadPool.f(r9);
    }

    public synchronized void createViewInternal(int r17, String r18, x0 r19, Map<String, EventsListener> r20, boolean r21, int r22, Map<Integer, s7a.a> r23) {
        monitor-enter(this);
        LynxBaseUI r13 = null;
        if (TraceEvent.isTracingStarted() == false) goto L7;
        String r2 = "UIOwner.createView." + r18;     // Catch: Throwable -> L34
        TraceEvent.beginSection(r2);     // Catch: Throwable -> L34
        String r14 = r2;
    L8:
        UIThreadUtils.assertOnUiThread();     // Catch: Throwable -> L34
        r13 = createViewInterval(new com.lynx.tasm.behavior.ui.j(r17, r22, r21, r18, r20, r23));     // Catch: Throwable -> L18
        LynxBaseUI r3 = consumeInitialProps(r13, r19);     // Catch: Throwable -> L16
        if (r3 == null) goto L14;
        reportStatistic(r18);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r17, r18, r19);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r17), r3);     // Catch: Throwable -> L34
    L25:
        if (TraceEvent.isTracingStarted() == false) goto L27;
        TraceEvent.endSection(r14);     // Catch: Throwable -> L34
    L27:
        monitor-exit(this);
        return;
    L14:
        LLog.e(TAG, "createUI got null ui for tag:" + r18);     // Catch: Throwable -> L34
    L16:
        th = th;
    L38:
        RuntimeException r4 = new RuntimeException("createUI catch error while createUI for tag: " + r18 + ", " + th.getMessage(), th);     // Catch: Throwable -> L29
        r4.setStackTrace(th.getStackTrace());     // Catch: Throwable -> L29
        this.mUIBody.getLynxContext().handleException(r4);     // Catch: Throwable -> L29
        if (r13 == null) goto L23;
        reportStatistic(r18);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r17, r18, r19);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r17), r13);     // Catch: Throwable -> L34
        goto L25
    L23:
        LLog.e(TAG, "createUI got null ui for tag:" + r18);     // Catch: Throwable -> L34
        goto L25
    L29:
        th = move-exception;
        if (r13 == null) goto L32;
        reportStatistic(r18);     // Catch: Throwable -> L34
        updateComponentIdToUiIdMapIfNeeded(r17, r18, r19);     // Catch: Throwable -> L34
        this.mUIHolder.put(Integer.valueOf(r17), r13);     // Catch: Throwable -> L34
    L33:
        throw th;     // Catch: Throwable -> L34
    L32:
        LLog.e(TAG, "createUI got null ui for tag:" + r18);     // Catch: Throwable -> L34
    L18:
        th = th;
        goto L38
    L7:
        r14 = null;
    L34:
        th = move-exception;
        throw th;
    }

    public void createView(int r11, String r12, ReadableMap r13, ReadableMapBuffer r14, ReadableArray r15, boolean r16, int r17, ReadableArray r18) {
        if (r13 == null) goto L5;
        x0 r1 = new x0(r13, r14);
    L6:
        createViewInternal(r11, r12, r1, EventsListener.convertEventListeners(r15), r16, r17, s7a.a.a(r18));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public Runnable createViewAsyncRunnable(int r18, String r19, ReadableMap r20, ReadableMapBuffer r21, ReadableArray r22, boolean r23, int r24, ReadableArray r25) {
        reportCreateViewConfig(r18, r19, true);
        if (r20 == null) goto L5;
        x0 r15 = new x0(r20, r21);
    L6:
        com.lynx.tasm.behavior.ui.j r5 = new com.lynx.tasm.behavior.ui.j(r18, r24, r23, r19, EventsListener.convertEventListeners(r22), s7a.a.a(r25));
    L20:
        th = th;
        boolean r16 = false;
    L22:
        String r1 = "createViewAsync failed, tagName:" + r19 + ", error:" + th;
        LLog.e(TAG, r1);
        Exception r2 = new Exception(r1);
        r2.setStackTrace(th.getStackTrace());
        UIThreadUtils.runOnUiThread(new c(this, r2));
        d r0 = new d(this, r18, r19, r20, r21, r22, r23, r24, r25);
        reportCreateAsyncSuccessEvent(r18, r19, r16, 3);
        return r0;
    L8:
        if (TraceEvent.isTracingStarted() == false) goto L10;
        String r3 = "UIOwner.createAsyncViewRunnable." + r19;     // Catch: Throwable -> L20
        TraceEvent.beginSection(r3);     // Catch: Throwable -> L20
        String r17 = r3;
    L11:
        LynxBaseUI r4 = createViewInterval(r5);     // Catch: Throwable -> L20
        LynxBaseUI[] r6 = {r4};     // Catch: Throwable -> L20
        UIShadowProxy r7 = consumeInitialPropsInterval(r4, r15);     // Catch: Throwable -> L20
        if (TraceEvent.isTracingStarted() == false) goto L14;
        TraceEvent.endSection(r17);     // Catch: Throwable -> L20
    L14:
        reportCreateAsyncSuccessEvent(r18, r19, true, 2);     // Catch: Throwable -> L20
        x0 r8 = r15;
        r16 = false;
        return new b(this, r19, r6, r7, r8, r18);
    L18:
        th = th;
        goto L22
    L10:
        r17 = null;
        goto L11
    L5:
        r15 = null;
        goto L6
    }

    public void updateLayout(int r45, int r46, int r47, int r48, int r49, int r50, int r51, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r60, int r61, Rect r62, float[] r63, float r64, int r65) {
        LynxUIOwner r0 = this;
        LynxBaseUI r11 = r0.mUIHolder.get(Integer.valueOf(r45));
        if (r11 != null) goto L6;
        LynxError r1 = new LynxError(60301, "Can't find ui tag");
        r1.addCustomInfo("node_index", Integer.toString(r65));
        r0.mContext.handleLynxError(r1);
        return;
    L6:
        boolean r10 = r11 instanceof UIShadowProxy;
        if (r10 == false) goto L9;
        LynxBaseUI r2 = ((UIShadowProxy) r11).a;
    L10:
        r2.updateLayoutSize(r48, r49);
        if (r11.getLayoutAnimator() == null) goto L14;
        r11.getLayoutAnimator().i(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
    L14:
        u6a.a r12 = r11.getTransitionAnimator();
        Animation r19 = null;
        if (TraceEvent.isTracingStarted() == false) goto L17;
        String r3 = "UIOwner.updateLayout." + r11.getTagName();
        TraceEvent.beginSection(r3);
        String r21 = r3;
    L18:
        if (r12 == null) goto L155;
        if (r12.j.size() != 0) goto L22;
    L34:
        boolean r4 = false;
    L35:
        if (r4 == false) goto L155;
        if (r0.mIsFirstLayout == true) goto L155;
        if (r11.isFirstAnimatedReady() == true) goto L155;
        if (r10 == false) goto L42;
        LynxBaseUI r6 = r11;
        LynxUI r5 = (LynxUI) ((UIShadowProxy) r6).a;
    L44:
        if ((r5 instanceof LynxUI) == false) goto L153;
        LynxBaseUI r7 = r12.g;
        if (r7 == null) goto L49;
        LynxBaseUI r16 = r7;
    L51:
        if (r16.getOriginLeft() == r15) goto L53;
        boolean r17 = true;
    L55:
        if (r16.getOriginTop() == r47) goto L57;
        boolean r18 = true;
    L59:
        if (r16.getWidth() == r48) goto L61;
        boolean r110 = true;
    L63:
        if (r16.getHeight() == r49) goto L65;
        boolean r20 = true;
    L67:
        if ((r16.getOriginLeft() + r16.getWidth()) != (r46 + r48)) goto L69;
        boolean r40 = true;
    L71:
        if ((r16.getOriginTop() + r16.getHeight()) != (r47 + r49)) goto L73;
        boolean r41 = true;
    L74:
        r16.onBeforeAnimation(r46, r47, r48, r49, r50, r51, r52, r53);
        if (r12.c(256) == false) goto L77;
    L80:
        boolean r8 = true;
    L82:
        if (r12.c(512) == false) goto L84;
    L87:
        boolean r9 = true;
    L88:
        boolean r13 = r12.c(16);
        boolean r14 = r12.c(32);
        if (r8 == false) goto L91;
        if (r17 == false) goto L91;
    L93:
        int r23 = r16.getOriginLeft();
    L95:
        if (r9 == false) goto L97;
        if (r18 == false) goto L97;
    L99:
        int r24 = r16.getOriginTop();
    L101:
        if (r110 == false) goto L104;
        if (r13 == false) goto L104;
        int r25 = r16.getWidth();
    L105:
        if (r20 == false) goto L108;
        if (r14 == false) goto L108;
        int r26 = r16.getHeight();
    L109:
        r12.f(256);
        r12.f(1024);
        r12.f(512);
        r12.f(2048);
        r12.f(32);
        r12.f(16);
        r16.updateLayout(r23, r24, r25, r26, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        HashMap r15 = new HashMap();
        int r22 = 0;
    L111:
        if (r22 >= r12.j.size()) goto L150;
        s6a.a r27 = r12.j.valueAt(r22);
        int r28 = r27.d;
        if ((r28 & 3888) == 0) goto L148;
        if (r28 == 16) goto L138;
        if (r28 == 32) goto L127;
        if (r28 == 256) goto L125;
        if (r28 == 512) goto L123;
        if (r28 == 1024) goto L125;
        if (r28 != 2048) goto L148;
    L123:
        if (r18 == false) goto L148;
        r15.put(Integer.valueOf(r27.d), r12.d(r27.d, r16, r16.getOriginTop(), r47, r27, true));
    L125:
        if (r17 == false) goto L148;
        r15.put(Integer.valueOf(r27.d), r12.d(r27.d, r16, r16.getOriginLeft(), r46, r27, true));
        goto L148
    L127:
        if (r20 == false) goto L148;
        AnimatorSet r29 = new AnimatorSet();
        ArrayList r30 = new ArrayList();
        r30.add(r12.d(32, r16, r16.getHeight(), r49, r27, true));
        if (r18 == false) goto L133;
        if (r41 == false) goto L133;
        if (r9 == true) goto L133;
        boolean r31 = true;
    L134:
        if (r31 == false) goto L136;
        r30.add(r12.d(512, r16, r16.getOriginTop(), r47, r27, false));
    L136:
        r29.playTogether(r30);
        r15.put(32, r29);
    L133:
        r31 = false;
        goto L134
    L138:
        if (r110 == false) goto L148;
        AnimatorSet r32 = new AnimatorSet();
        ArrayList r33 = new ArrayList();
        r33.add(r12.d(16, r16, r16.getWidth(), r48, r27, true));
        if (r17 == false) goto L144;
        if (r40 == false) goto L144;
        if (r8 == true) goto L144;
        boolean r34 = true;
    L145:
        if (r34 == false) goto L147;
        r33.add(r12.d(256, r16, r16.getOriginLeft(), r46, r27, false));
    L147:
        r32.playTogether(r33);
        r15.put(16, r32);
    L144:
        r34 = false;
    L148:
        r22 = r22 + 1;
        goto L111
    L150:
        if (r15.isEmpty() == true) goto L152;
        r12.i.putAll(r15);
    L152:
        r12.a = r46;
        r12.b = r47;
        r12.c = r48;
        r12.d = r49;
    L108:
        r26 = r49;
    L104:
        r25 = r48;
    L97:
        if (r14 == false) goto L100;
        if (r41 == true) goto L99;
    L100:
        r24 = r47;
    L91:
        if (r13 == false) goto L94;
        if (r40 == true) goto L93;
    L94:
        r23 = r46;
        goto L95
    L84:
        if (r12.c(2048) == true) goto L87;
        r9 = false;
        goto L88
    L77:
        if (r12.c(1024) == true) goto L80;
        r8 = false;
        goto L82
    L73:
        r41 = false;
        goto L74
    L69:
        r40 = false;
        goto L71
    L65:
        r20 = false;
        goto L67
    L61:
        r110 = false;
        goto L63
    L57:
        r18 = false;
        goto L59
    L53:
        r17 = false;
        goto L55
    L49:
        r16 = r5;
    L153:
        r0.mUIBody.invalidate();
        LynxBaseUI r66 = r6;
    L237:
        LynxBaseUI r35 = r66;
        r35.updateSticky(r0.normalizeStickyInfo(r63));
        r35.updateMaxHeight(r64);
        r0.insertA11yMutationEvent(3, r35);
        if (TraceEvent.isTracingStarted() == false) goto L246;
        TraceEvent.endSection(r21);
        return;
    L246:
        return;
    L42:
        r6 = r11;
        r5 = (LynxUI) r6;
        goto L44
    L22:
        if (r12.c(256) == false) goto L24;
    L33:
        r4 = true;
        goto L35
    L24:
        if (r12.c(1024) == true) goto L33;
        if (r12.c(512) == true) goto L33;
        if (r12.c(2048) == true) goto L33;
        if (r12.c(16) == true) goto L33;
        if (r12.c(32) == false) goto L34;
    L155:
        if (r11.enableLayoutAnimation() == true) goto L157;
    L235:
        r66 = r11;
        r66.updateLayout(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        goto L237
    L157:
        if (r0.mIsFirstLayout == true) goto L235;
        int r36 = r0.mRootSign;
        if (r45 != r36) goto L163;
        if (r45 != r36) goto L235;
        if (r0.mIsRootLayoutAnimationRunning == false) goto L235;
    L163:
        t6a.c r111 = r11.getLayoutAnimator();
        if (r10 == 0) goto L166;
        LynxBaseUI r112 = r11;
        LynxUI r37 = (LynxUI) ((UIShadowProxy) r112).a;
    L167:
        LynxUI r38 = r37;
        r111.getClass();
        View r210 = r38.getView();
        r111.a = new WeakReference(r38);
        r66 = r112;
        r111.i(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        if (r111.x != (-1.0f)) goto L171;
        if (r210 == null) goto L171;
        r111.x = r210.getAlpha();
    L171:
        int r39 = r38.getSign();
        t6a.f r42 = r111.w.get(r39);
        if (r42 == null) goto L181;
        if (r210 != null) goto L175;
    L178:
        r111.w.remove(r39);
        goto L181
    L175:
        if (r210.getAnimation() == null) goto L178;
        r42.a(r46, r47, r48, r49);
    L177:
        r0 = this;
        r0.mUIBody.invalidate();
    L181:
        if (r38.getWidth() == 0) goto L183;
    L185:
        t6a.a r43 = r111.u;
    L186:
        t6a.e r44 = r111.v;
        if (r44 != null) goto L189;
    L199:
        t6a.e r67 = r111.v;
        if (r67 != null) goto L202;
    L203:
        if (r48 != 0) goto L206;
        if (r49 != 0) goto L206;
        r38.updateLayout(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
    L206:
        if (r43 == null) goto L209;
        r19 = r43.a(r38, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r111.x);
    L209:
        Animation r113 = r19;
        if ((r113 instanceof TranslateAnimation) == true) goto L212;
    L214:
        View r114 = r210;
        if (r113 != null) goto L224;
        float r68 = r111.x;
        if (r68 == (-1.0f)) goto L219;
        r114.setAlpha(r68);
    L219:
        WeakReference<LynxUI> r69 = r111.a;
        if (r69 == null) goto L222;
        r69.clear();
    L222:
        r11.updateLayout(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        goto L177
    L224:
        if (r11.getWidth() == 0) goto L226;
    L228:
        r113.setAnimationListener(new t6a.c.a(r111, "layout-animation-update"));
        r111.b(r114, "layout-animation-update");
    L230:
        if ((r113 instanceof t6a.f) == false) goto L232;
        r11.requestLayout();
    L233:
        r11.onBeforeAnimation(r46, r47, r48, r49, r50, r51, r52, r53);
        r114.startAnimation(r113);
        goto L177
    L232:
        r11.updateLayout(r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        goto L233
    L226:
        if (r11.getHeight() != 0) goto L228;
        r113.setAnimationListener(new t6a.c.a(r111, "layout-animation-create"));
        r111.b(r114, "layout-animation-create");
        goto L230
    L212:
        if ((r11.getParent() instanceof UIShadowProxy) == false) goto L214;
        r210 = ((LynxUI) r38.getParent()).getView();
        goto L214
    L202:
        if (r67.c() == true) goto L206;
    L189:
        if (r44.c() == false) goto L199;
        if (r48 != 0) goto L199;
        if (r49 != 0) goto L199;
        View r70 = r38.getView();
        if (r70 == null) goto L177;
        r111.a = new WeakReference(r38);
        Animation r71 = r111.v.a(r38, r70.getLeft(), r70.getTop(), r70.getWidth(), r70.getHeight(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect(), r111.x);
        if (r71 != null) goto L198;
        r38.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
        goto L177
    L198:
        r71.setAnimationListener(new t6a.c.a(r111, "layout-animation-delete"));
        r111.b(r70, "layout-animation-delete");
        r70.startAnimation(r71);
        goto L177
    L183:
        if (r38.getHeight() != 0) goto L185;
        r43 = r111.t;
        goto L186
    L166:
        r112 = r11;
        r37 = (LynxUI) r112;
        goto L167
    L17:
        r21 = null;
        goto L18
    L9:
        r2 = r11;
        goto L10
    }

    public void updateLayout(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, Rect r21, float[] r22, float r23, int r24, boolean r25) {
        LynxBaseUI r1 = this.mUIHolder.get(Integer.valueOf(r4));
        if (r1 == null) goto L5;
        r1.setDisplayNone(r25);
    L5:
        updateLayout(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }
}
