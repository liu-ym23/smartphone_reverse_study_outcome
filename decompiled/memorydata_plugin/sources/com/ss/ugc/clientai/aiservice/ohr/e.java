package com.ss.ugc.clientai.aiservice.ohr;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0;H\u0004J\u0016\u0010<\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0;H\u0002J\u000e\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0016\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010F\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020)J\u0006\u0010I\u001a\u000209J\u0006\u0010J\u001a\u000209J\u000e\u0010K\u001a\u0002092\u0006\u0010H\u001a\u00020)R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0016R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRService;", "", "()V", "_inputBuffer", "", "config", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRConfig;", "evBuffer", "", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRServiceInput;", "getEvBuffer", "()Ljava/util/List;", "setEvBuffer", "(Ljava/util/List;)V", "inputBuffer", "getInputBuffer", "()[F", "isInitialized", "", "lastFeedTime", "", "getLastFeedTime", "()J", "setLastFeedTime", "(J)V", "<set-?>", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictResult;", "lastPredictResult", "getLastPredictResult", "()Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictResult;", "lastPredictTime", "lastPredictTouchArea", "Lcom/ss/ugc/clientai/aiservice/OHRPredictTouchArea;", "getLastPredictTouchArea", "()Lcom/ss/ugc/clientai/aiservice/OHRPredictTouchArea;", "mainHandler", "Landroid/os/Handler;", "minInterval", "getMinInterval", "observable", "Lcom/ss/ugc/clientai/aiservice/ohr/AIPredictObservable;", "Lcom/ss/ugc/clientai/aiservice/ohr/OHRPredictObserver;", "getObservable", "()Lcom/ss/ugc/clientai/aiservice/ohr/AIPredictObservable;", "ohrEngine", "Lcom/ss/ugc/clientai/aiservice/AIEngine;", "sampleCount", "", "getSampleCount", "()I", "screenDensity", "", "screenHeight", "screenWidth", "touchAreaCalculator", "Lcom/ss/ugc/clientai/aiservice/ohr/TouchAreaCalculator;", "feedData", "", "dataList", "", "feedDataAsync", "feedMotionEvent", "ev", "Landroid/view/MotionEvent;", "figureOutTouchArea", "result", "Lcom/ss/ugc/clientai/aiservice/AIPredictResult;", "initialize", "application", "Landroid/content/Context;", "notifyPredictResult", "registerOHRServiceObserver", "observer", "shutdown", "startup", "unregisterOHRServiceObserver", "Companion", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.ugc.clientai.aiservice.a f15794b;
    private volatile boolean c;
    private final Handler d;
    private final com.ss.ugc.clientai.aiservice.ohr.a<com.ss.ugc.clientai.aiservice.ohr.c> e;
    private final g f;
    private com.ss.ugc.clientai.aiservice.ohr.b g;
    private com.ss.ugc.clientai.aiservice.ohr.d h;
    private List<com.ss.ugc.clientai.aiservice.ohr.f> i;
    private long j;
    private float[] k;
    private long l;
    private float m;
    private float n;
    private float o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/ugc/clientai/aiservice/ohr/OHRService$Companion;", "", "()V", "LOG_TAG", "", "SCENE", "TENSOR_SIZE", "", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f15796b;

        b(e r3, List r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f15795a = r3;
            this.f15796b = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.a(this.f15795a, this.f15796b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/ss/ugc/clientai/aiservice/ohr/OHRService$initialize$1", "Lcom/ss/ugc/clientai/aiservice/OnAIEngineListener;", "onAIPredictResult", "", "result", "Lcom/ss/ugc/clientai/aiservice/AIPredictResult;", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
    public static final class c implements com.ss.ugc.clientai.aiservice.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15797a;

        c(e r1) {
            this.f15797a = r1;
        }

        @Override // com.ss.ugc.clientai.aiservice.f
        public void a(com.ss.ugc.clientai.aiservice.d r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            e.a(this.f15797a, r2);
            e.b(this.f15797a, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.ss.ugc.clientai.aiservice.ohr.d f15799b;

        d(e r1, com.ss.ugc.clientai.aiservice.ohr.d r2) {
            this.f15798a = r1;
            this.f15799b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15798a.a().a((Function1) ZeusTransformUtils.preCheckCast(new OHRService$notifyPredictResult$1$1(this), Function1.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.ss.ugc.clientai.aiservice.ohr.e$e, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
    static final class RunnableC0841e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15800a;

        RunnableC0841e(e r1) {
            this.f15800a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15800a.a().a((Function1) ZeusTransformUtils.preCheckCast(OHRService$shutdown$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 1})
    static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15801a;

        f(e r1) {
            this.f15801a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15801a.a().a((Function1) ZeusTransformUtils.preCheckCast(OHRService$startup$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f15793a = new a(null);
    }

    public e() {
        this.d = new Handler(Looper.getMainLooper());
        this.e = new com.ss.ugc.clientai.aiservice.ohr.a();
        this.f = new g();
    }

    private final void a(com.ss.ugc.clientai.aiservice.d r3) {
        if (r3.a() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.b(), com.ss.ugc.clientai.aiservice.g.f15783a.a()) == true) goto L13;
        float[] r0 = this.k;
        if (r0 == null) goto L12;
        this.f.a(r3.b().b(), r0);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ void a(e r0, com.ss.ugc.clientai.aiservice.d r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(e r2, List r3) {
        r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final void b(com.ss.ugc.clientai.aiservice.d r11) {
        int r0 = r11.b().b();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        Object r6 = null;
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((com.ss.ugc.clientai.aiservice.g) ZeusTransformUtils.preCheckCast(r2, com.ss.ugc.clientai.aiservice.g.class, "com.obric.memorydata.plugin")).b() != 1) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L3;
    L12:
        com.ss.ugc.clientai.aiservice.g r3 = (com.ss.ugc.clientai.aiservice.g) ZeusTransformUtils.preCheckCast(r2, com.ss.ugc.clientai.aiservice.g.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L42;
        float r4 = r3.c();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r5.hasNext() == false) goto L23;
        Object r8 = r5.next();
        if (((com.ss.ugc.clientai.aiservice.g) ZeusTransformUtils.preCheckCast(r8, com.ss.ugc.clientai.aiservice.g.class, "com.obric.memorydata.plugin")).b() != 2) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
    L24:
        com.ss.ugc.clientai.aiservice.g r10 = (com.ss.ugc.clientai.aiservice.g) ZeusTransformUtils.preCheckCast(r8, com.ss.ugc.clientai.aiservice.g.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L43;
        float r12 = r10.c();
        Object r13 = r11.b().a();
        if (ZeusTransformUtils.instanceOf(r13, RectF.class) == false) goto L30;
        r6 = r13;
    L30:
        com.ss.ugc.clientai.aiservice.ohr.d r14 = new com.ss.ugc.clientai.aiservice.ohr.d(r0, r4, r12, (RectF) ZeusTransformUtils.preCheckCast(r6, RectF.class, "com.obric.memorydata.plugin"));
        this.h = r14;
        this.d.post((Runnable) ZeusTransformUtils.preCheckCast(new d(this, r14), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L43:
        return;
    L20:
        r9 = false;
        goto L21
    L23:
        r8 = null;
        goto L24
    L42:
        return;
    L8:
        r7 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    public static final /* synthetic */ void b(e r0, com.ss.ugc.clientai.aiservice.d r1) {
        r0.b(r1);
    }

    private final void b(List<com.ss.ugc.clientai.aiservice.ohr.f> r20) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        if (this.c == false) goto L5;
        com.ss.ugc.clientai.aiservice.a r3 = this.f15794b;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
    L12:
        if (r3.e() == true) goto L18;
        if (com.ss.ugc.clientai.common.b.f15808a == false) goto L45;
        com.ss.ugc.clientai.common.b.a("ohr", "engine hasn't started");
        return;
    L45:
        return;
    L18:
        if (com.ss.ugc.clientai.common.b.f15808a == false) goto L21;
        com.ss.ugc.clientai.common.b.a("ohr", "feedData, dataList.size=" + r1.size());
    L21:
        if (r1.isEmpty() == true) goto L40;
        if (r1.size() < d()) goto L40;
        long r4 = SystemClock.uptimeMillis();
        long r6 = ((com.ss.ugc.clientai.aiservice.ohr.f) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r1), com.ss.ugc.clientai.aiservice.ohr.f.class, "com.obric.memorydata.plugin")).c();
        float r8 = r1.size() / d();
        float[] r14 = f();
        int r9 = 0;
        int r10 = d();
    L26:
        if (r9 >= r10) goto L28;
        com.ss.ugc.clientai.aiservice.ohr.f r11 = (com.ss.ugc.clientai.aiservice.ohr.f) ZeusTransformUtils.preCheckCast(r1.get((int) (r9 * r8)), com.ss.ugc.clientai.aiservice.ohr.f.class, "com.obric.memorydata.plugin");
        int r12 = r9 * 6;
        r14[r12] = r11.a();
        r14[r12 + 1] = r11.b();
        r14[r12 + 2] = r11.c() - r6;
        r14[r12 + 3] = this.m;
        r14[r12 + 4] = this.n;
        r14[r12 + 5] = this.o;
        r9 = r9 + 1;
        r10 = r10;
        goto L26
    L28:
        com.ss.ugc.clientai.aiservice.ohr.b r2 = this.g;
        if (r2 == null) goto L34;
        h r5 = r2.a();
        if (r5 == null) goto L34;
        r5.a(r1.size(), d(), this.l - r4, r4, r4 - r6, SystemClock.uptimeMillis() - r4);
    L34:
        this.l = r4;
        com.ss.ugc.clientai.aiservice.a r0 = this.f15794b;
        if (r0 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
    L37:
        r0.b(new com.ss.ugc.clientai.aiservice.c(r14));
        return;
    L40:
        if (com.ss.ugc.clientai.common.b.f15808a == false) goto L46;
        com.ss.ugc.clientai.common.b.a("ohr", "sample not enough, dataList.size=" + r1.size());
        return;
    L46:
        return;
    L5:
        if (com.ss.ugc.clientai.common.b.f15808a == false) goto L44;
        com.ss.ugc.clientai.common.b.b("ohr", "service hasn't initialized");
        return;
    }

    private final int d() {
        com.ss.ugc.clientai.aiservice.ohr.b r0 = this.g;
        if (r0 != null) goto L7;
        return 9;
    L7:
        return r0.c();
    }

    private final long e() {
        com.ss.ugc.clientai.aiservice.ohr.b r2 = this.g;
        if (r2 != null) goto L7;
        return 5000;
    L7:
        return r2.b();
    }

    private final float[] f() {
        float[] r0 = this.k;
        int r1 = d() * 6;
        if (r0 != null) goto L5;
    L7:
        float[] r2 = new float[r1];
        this.k = r2;
        return r2;
    L5:
        if (r0.length != r1) goto L7;
        return r0;
    }

    public final com.ss.ugc.clientai.aiservice.ohr.a<com.ss.ugc.clientai.aiservice.ohr.c> a() {
        return this.e;
    }

    public final void a(Context r4, com.ss.ugc.clientai.aiservice.ohr.b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "application");
        Intrinsics.checkNotNullParameter(r5, "config");
        if (this.c == false) goto L5;
        return;
    L5:
        this.g = r5;
        com.ss.ugc.clientai.aiservice.a r7 = r5.d().a();
        this.f15794b = r7;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
    L8:
        r7.a((com.ss.ugc.clientai.aiservice.f) ZeusTransformUtils.preCheckCast(new c(this), com.ss.ugc.clientai.aiservice.f.class, "com.obric.memorydata.plugin"));
        DisplayMetrics r8 = new DisplayMetrics();     // Catch: Exception -> L16
        Object r9 = r6.getSystemService("window");     // Catch: Exception -> L16
        if (r9 == null) goto L15;
        ((WindowManager) ZeusTransformUtils.preCheckCast(r9, WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay().getMetrics(r8);     // Catch: Exception -> L16
        this.m = r8.widthPixels;     // Catch: Exception -> L16
        this.n = r8.heightPixels;     // Catch: Exception -> L16
        this.o = r8.density;     // Catch: Exception -> L16
        this.c = true;
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L16
    L16:
        com.ss.ugc.clientai.common.b.c("ohr", "failed to retrieve the DisplayMetrics");
    }

    public final void a(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "ev");
        if (this.c == true) goto L6;
        return;
    L6:
        if (r12.getPointerCount() <= 1) goto L9;
        this.i = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
        return;
    L9:
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - this.j) >= e()) goto L13;
        return;
    L13:
        if (r12.getAction() != 0) goto L15;
        this.i = (List) ZeusTransformUtils.preCheckCast(new LinkedList(), List.class, "com.obric.memorydata.plugin");
    L15:
        List<com.ss.ugc.clientai.aiservice.ohr.f> r0 = this.i;
        if (r0 == null) goto L27;
        int r1 = 0;
        int r5 = r12.getHistorySize();
    L18:
        if (r1 >= r5) goto L20;
        r0.add(new com.ss.ugc.clientai.aiservice.ohr.f(r12.getHistoricalX(r1), r12.getHistoricalY(r1), r12.getHistoricalEventTime(r1)));
        r1 = r1 + 1;
        goto L18
    L20:
        r0.add(new com.ss.ugc.clientai.aiservice.ohr.f(r12.getX(), r12.getY(), r12.getEventTime()));
        if (r12.getAction() == 1) goto L23;
        return;
    L23:
        if (r0.size() < d()) goto L29;
        this.j = r3;
        a(r0);
        return;
    L29:
        return;
    }

    public final void a(com.ss.ugc.clientai.aiservice.ohr.c r3) {
        com.ss.ugc.clientai.aiservice.ohr.c r4 = (com.ss.ugc.clientai.aiservice.ohr.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.ugc.clientai.aiservice.ohr.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.e.a(r4);
    }

    public final void a(List<com.ss.ugc.clientai.aiservice.ohr.f> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dataList");
        com.ss.ugc.clientai.common.c.a((Runnable) ZeusTransformUtils.preCheckCast(new b(this, r4), Runnable.class, "com.obric.memorydata.plugin"), 100);
    }

    public final void b() {
        if (this.c == true) goto L5;
        return;
    L5:
        com.ss.ugc.clientai.aiservice.a r0 = this.f15794b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
    L8:
        r0.c();
        this.d.post((Runnable) ZeusTransformUtils.preCheckCast(new f(this), Runnable.class, "com.obric.memorydata.plugin"));
    }

    public final void b(com.ss.ugc.clientai.aiservice.ohr.c r3) {
        com.ss.ugc.clientai.aiservice.ohr.c r4 = (com.ss.ugc.clientai.aiservice.ohr.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.ugc.clientai.aiservice.ohr.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        this.e.b(r4);
    }

    public final void c() {
        if (this.c == true) goto L5;
        return;
    L5:
        this.d.post((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0841e(this), Runnable.class, "com.obric.memorydata.plugin"));
        com.ss.ugc.clientai.aiservice.a r4 = this.f15794b;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
    L8:
        r4.d();
    }
}
