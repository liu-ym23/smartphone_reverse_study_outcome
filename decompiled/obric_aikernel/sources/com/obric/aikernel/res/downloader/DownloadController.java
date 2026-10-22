package com.obric.aikernel.res.downloader;

import androidx.annotation.GuardedBy;
import com.bytedance.keva.KevaImpl;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f4896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f4897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<String, DownloadTask> f4898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final List<DownloadTask> f4899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<Integer, Integer> f4900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f4901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f4902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DownloadController$slotCallback$1 f4903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<DownloadSlot> f4904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f4905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f4906k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class b extends AbstractCoroutineContextElement implements h0 {
        public b(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            com.obric.aikernel.runtime.utils.d.f5417a.f("DownloadController", r10 + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        new a(null);
    }

    public DownloadController(final PrmContext r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        this.f4896a = r15;
        this.f4897b = m0.a(z0.b().plus(new k0("DownloadController")).plus(q2.b(null, 1, null)).plus(new b(h0.f10523d)));
        this.f4898c = new LinkedHashMap();
        this.f4899d = new ArrayList();
        this.f4900e = new LinkedHashMap();
        int r10 = r15.getConfig().getParallelDownloadNum();
        this.f4902g = r10;
        this.f4903h = new DownloadController$slotCallback$1(this);
        int[] r11 = new int[r10];
        ArrayList r12 = new ArrayList(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r10) goto L5;
        int r16 = r11[r13];
        r12.add(new DownloadSlot(r14, this.f4897b, this.f4903h, 0, 8, null));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        this.f4904i = r12;
        this.f4905j = LazyKt.lazy(new DownloadController$downloadListener$2(r15, this));
        this.f4906k = LazyKt.lazy(new DownloadController$monitorDepend$2(r15));
        u();
    }

    @GuardedBy("this")
    private final int A(DownloadTask r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return d.a(this.f4899d, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean C(DownloadController r10, String r11, String r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = DownloadController$removeTask$1.INSTANCE;
    L6:
        return r10.B(r11, r12, r13);
    }

    private final synchronized void D() {
        monitor-enter(this);
        Iterator<T> r10 = this.f4904i.iterator();     // Catch: Throwable -> L10
    L5:
        if (r10.hasNext() == false) goto L8;
        ((DownloadSlot) r10.next()).f();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @GuardedBy("this")
    private final void F(PrmContext r10) {
        Collection<DownloadTask> r11 = this.f4898c.values();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(Boolean.valueOf(((DownloadTask) r13.next()).z()));
        goto L4
    L6:
        boolean r14 = d.f(r10.getConfig().getAppConfig().getEnableDownloadForegroundService(), d.b(r12));
        if (r14 != this.f4901f) goto L9;
        return;
    L9:
        this.f4901f = r14;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        if (r14 == false) goto L14;
        Function0<Unit> r16 = r10.getConfig().getAppConfig().getStartDownloadForegroundService();     // Catch: Throwable -> L17
    L13:
        r16.invoke();     // Catch: Throwable -> L17
        Object r17 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L26;
        com.obric.aikernel.runtime.utils.d.f5417a.l("DownloadController", "sync download foreground service failed shouldRun=" + r14 + ' ' + r18);
        return;
    L26:
        return;
    L14:
        r16 = r10.getConfig().getAppConfig().getStopDownloadForegroundService();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public static final /* synthetic */ void a(DownloadController r10, DownloadInfo r11) {
        r10.l(r11);
    }

    public static final /* synthetic */ String b(DownloadController r10, BaseException r11) {
        return r10.m(r11);
    }

    public static final /* synthetic */ String c(DownloadController r10, DownloadInfo r11) {
        return r10.n(r11);
    }

    public static final /* synthetic */ List d(DownloadController r10) {
        return r10.f4899d;
    }

    public static final /* synthetic */ PrmContext e(DownloadController r10) {
        return r10.f4896a;
    }

    public static final /* synthetic */ void f(DownloadController r10, DownloadInfo r11) {
        r10.v(r11);
    }

    public static final /* synthetic */ void g(DownloadController r10, DownloadTask r11) {
        r10.w(r11);
    }

    public static final /* synthetic */ Object h(DownloadController r10, int r11, Continuation r12) {
        return r10.y(r11, r12);
    }

    public static final /* synthetic */ int i(DownloadController r10, DownloadTask r11) {
        return r10.A(r11);
    }

    public static final /* synthetic */ void j(DownloadController r10) {
        r10.D();
    }

    public static final /* synthetic */ void k(DownloadController r10, PrmContext r11) {
        r10.F(r11);
    }

    private final void l(DownloadInfo r10) {
        if (r10 == null) goto L11;
        int r11 = r10.getId();
        monitor-enter(this);
        Integer r12 = this.f4900e.remove(Integer.valueOf(r11));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final String m(BaseException r10) {
        if (r10 == null) goto L15;
        String r11 = r10.getMessage();
        if (r11 == null) goto L15;
        if (r11.length() <= 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L15;
        String r13 = " error=" + r11;
        if (r13 == null) goto L15;
        return r13;
    L8:
        r12 = false;
    L15:
        return "";
    }

    private final String n(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return "downloadId=null name=null progress=null bytes=null/null savePath=null";
    L5:
        return "downloadId=" + r10.getId() + " name=" + r10.getName() + " progress=" + r10.getDownloadProcess() + "% bytes=" + r10.getCurBytes() + '/' + r10.getTotalBytes() + " savePath=" + r10.getSavePath();
    }

    private final DownloadController$downloadListener$2.a p() {
        return (DownloadController$downloadListener$2.a) this.f4905j.getValue();
    }

    private final DownloadController$monitorDepend$2.a r() {
        return (DownloadController$monitorDepend$2.a) this.f4906k.getValue();
    }

    private final void v(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        Integer r11 = d.d(this.f4900e.get(Integer.valueOf(r10.getId())), r10.getDownloadProcess());     // Catch: Throwable -> L14
        if (r11 == null) goto L9;
        this.f4900e.put(Integer.valueOf(r10.getId()), Integer.valueOf(r11.intValue()));     // Catch: Throwable -> L14
    L10:
        monitor-exit(this);
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "model download progress checkpoint=" + r12 + "% " + n(r10));
        return;
    L19:
        return;
    L9:
        r11 = null;
    L14:
        th = move-exception;
        throw th;
    }

    private final synchronized void w(DownloadTask r10) {
        monitor-enter(this);
        int r11 = d.c(this.f4899d, r10, DownloadController$orderTask$removed$1.INSTANCE);     // Catch: Throwable -> L8
        if (r11 <= 1) goto L6;
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "dedupe queued download task " + r10.v() + " removed=" + r11 + " queueSize=" + this.f4899d.size() + " prior=" + r10.w() + " size=" + r10.u());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final DownloadTask x(int r10) {
        monitor-enter(this);
        DownloadTask r11 = null;
        if ((!this.f4899d.isEmpty()) == true) goto L6;
    L9:
        monitor-exit(this);
        return r11;
    L6:
        if (this.f4899d.get(0).w() < r10) goto L9;
        r11 = this.f4899d.remove(0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:20:0x0058). Please report as a decompilation issue!!! */
    private final Object y(int r10, Continuation<? super DownloadTask> r11) {
        if ((r11 instanceof DownloadController$pickTask$1) == false) goto L7;
        DownloadController$pickTask$1 r12 = (DownloadController$pickTask$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        int r17 = r12.I$0;
        DownloadTask r18 = (DownloadTask) r12.L$1;
        DownloadController r19 = (DownloadController) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r10 = r17;
        DownloadController this = r19;
        Object r20 = r14;
        DownloadTask r21 = r18;
    L21:
        if (((Boolean) r20).booleanValue() == false) goto L22;
    L15:
        r21 = this.x(r10);
        if (r21 == null) goto L22;
        r12.L$0 = this;
        r12.L$1 = r21;
        r12.I$0 = r10;
        r12.label = 1;
        r20 = r21.A(r12);
        if (r20 != r15) goto L21;
        return r15;
    L22:
        return r21;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
    L7:
        r12 = new DownloadController$pickTask$1(this, r11);
        goto L8
    }

    public final boolean B(String r10, String r11, Function1<? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "group");
        Intrinsics.checkNotNullParameter(r11, "taskId");
        Intrinsics.checkNotNullParameter(r12, "action");
        DownloadTask r13 = t(r11);
        if (r13 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L20;
        monitor-enter(this);
        DownloadTask r15 = this.f4898c.remove(r11);     // Catch: Throwable -> L16
        A(r15);     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(this.f4903h.e(), r15) == false) goto L13;
        this.f4903h.g(null);     // Catch: Throwable -> L16
    L13:
        F(this.f4896a);     // Catch: Throwable -> L16
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;
    L20:
        return false;
    L5:
        if (r13.H(r10, r12) != true) goto L7;
        r14 = true;
        goto L8
    }

    public final synchronized void E(DownloadTask r10, int r11, boolean r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "task");     // Catch: Throwable -> L34
        int r13 = r10.w();     // Catch: Throwable -> L34
        boolean r14 = r10.q();     // Catch: Throwable -> L34
        boolean r15 = false;
        if (r12 == true) goto L9;
        if (r10.q() == false) goto L9;
        r10.K(false);     // Catch: Throwable -> L34
    L9:
        if (r11 <= r10.w()) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L14;
        int r17 = A(r10);     // Catch: Throwable -> L34
    L15:
        if (r16 == false) goto L17;
        r10.N(r11);     // Catch: Throwable -> L34
    L17:
        if (r16 == false) goto L19;
    L20:
        r15 = true;
    L21:
        if (r15 == false) goto L23;
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "updateTask " + r10.v() + " prior " + r13 + "->" + r10.w() + ", background:" + r14 + "->" + r10.q());     // Catch: Throwable -> L34
    L25:
        if (r10.x() == false) goto L31;
        if (r16 == false) goto L29;
        if (r17 <= 0) goto L29;
        w(r10);     // Catch: Throwable -> L34
        D();     // Catch: Throwable -> L34
    L29:
        monitor-exit(this);
        return;
    L31:
        w(r10);     // Catch: Throwable -> L34
        F(this.f4896a);     // Catch: Throwable -> L34
        D();     // Catch: Throwable -> L34
        r10.O(true);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L23:
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadController", r10.v() + " prior " + r11 + ", background:" + r10.q());     // Catch: Throwable -> L34
        goto L25
    L19:
        if (r14 == r10.q()) goto L21;
    L14:
        r17 = 0;
        goto L15
    L11:
        r16 = false;
    L34:
        th = move-exception;
        throw th;
    }

    public final void G(String r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "group");
        monitor-enter(this);
        Iterator<T> r13 = this.f4898c.values().iterator();     // Catch: Throwable -> L31
    L6:
        if (r13.hasNext() == false) goto L28;
        DownloadTask r14 = (DownloadTask) r13.next();     // Catch: Throwable -> L31
        if (r14.B(r10) == false) goto L6;
        int r15 = r14.w();     // Catch: Throwable -> L31
        boolean r16 = r14.q();     // Catch: Throwable -> L31
        int r17 = 0;
        if (r12 == true) goto L15;
        if (r14.q() == false) goto L15;
        r14.K(false);     // Catch: Throwable -> L31
    L15:
        if (r11 <= r14.w()) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == false) goto L20;
        r17 = A(r14);     // Catch: Throwable -> L31
    L20:
        if (r18 == false) goto L24;
        r14.N(r11);     // Catch: Throwable -> L31
        if (r17 <= 0) goto L24;
        w(r14);     // Catch: Throwable -> L31
    L24:
        if (r18 == true) goto L27;
        if (r16 == r14.q()) goto L6;
    L27:
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "updatePrior " + r10 + ':' + r14.v() + " prior " + r15 + "->" + r14.w() + ", background:" + r16 + "->" + r14.q());     // Catch: Throwable -> L31
        goto L6
    L17:
        r18 = false;
        goto L18
    L28:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0069 -> B:24:0x006c). Please report as a decompilation issue!!! */
    public final Object o(Continuation<? super List<k>> r10) {
        if ((r10 instanceof DownloadController$getDownloadInfos$1) == false) goto L7;
        DownloadController$getDownloadInfos$1 r11 = (DownloadController$getDownloadInfos$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Iterator r16 = (Iterator) r11.L$1;
        Collection r17 = (Collection) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L24:
        CollectionsKt.addAll(r17, (List) r13);
    L20:
        if (r16.hasNext() == false) goto L26;
        DownloadTask r18 = (DownloadTask) r16.next();
        r11.L$0 = r17;
        r11.L$1 = r16;
        r11.label = 1;
        r13 = r18.s(r11);
        if (r13 != r14) goto L24;
        return r14;
    L26:
        return (List) r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        monitor-enter(this);
        List r19 = CollectionsKt.toList(this.f4898c.values());     // Catch: Throwable -> L27
        monitor-exit(this);
        ArrayList r20 = new ArrayList();
        r17 = r20;
        r16 = r19.iterator();
    L27:
        th = move-exception;
        throw th;
    L7:
        r11 = new DownloadController$getDownloadInfos$1(this, r10);
        goto L8
    }

    public final float q(String r10) {
        Intrinsics.checkNotNullParameter(r10, "group");
        monitor-enter(this);
        Iterator<T> r11 = this.f4898c.values().iterator();     // Catch: Throwable -> L16
        int r12 = 0;
        float r13 = 0.0f;
    L6:
        if (r11.hasNext() == false) goto L10;
        DownloadTask r14 = (DownloadTask) r11.next();     // Catch: Throwable -> L16
        if (r14.B(r10) == false) goto L6;
        r13 = r13 + r14.t();     // Catch: Throwable -> L16
        r12 = r12 + 1;     // Catch: Throwable -> L16
        goto L6
    L10:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r12 != 0) goto L15;
        return 1.0f;
    L15:
        return r13 / r12;
    L16:
        th = move-exception;
        throw th;
    }

    public final DownloadTask s(PackageResourceManager.PresmConfig r23, String r24, String r25, List<DownloadTask.b> r26) {
        Intrinsics.checkNotNullParameter(r23, "config");
        Intrinsics.checkNotNullParameter(r24, "group");
        Intrinsics.checkNotNullParameter(r25, "taskId");
        Intrinsics.checkNotNullParameter(r26, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        monitor-enter(this);
        DownloadTask r10 = this.f4898c.get(r25);     // Catch: Throwable -> L34
        boolean r11 = true;
        if (r10 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        Object r13 = null;
        if (r12 == false) goto L16;
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "replace finished failed download task " + r25 + " for retry");     // Catch: Throwable -> L34
        this.f4898c.remove(r25);     // Catch: Throwable -> L34
        A(r10);     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(this.f4903h.e(), r10) == false) goto L15;
        this.f4903h.g(null);     // Catch: Throwable -> L34
    L15:
        r10 = null;
    L16:
        if (r10 != null) goto L27;
        Iterator<T> r14 = r26.iterator();     // Catch: Throwable -> L34
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();     // Catch: Throwable -> L34
        if (((DownloadTask.b) r15).a() == false) goto L19;
        r13 = r15;
    L23:
        if (r13 == null) goto L25;
        boolean r16 = true;
    L26:
        DownloadTask r17 = new DownloadTask(r23, r25, this.f4897b.getCoroutineContext(), r26, p(), r(), r16, null, null, 0, 0, 1920, null);     // Catch: Throwable -> L34
        String r18 = r25;
        this.f4898c.put(r18, r17);     // Catch: Throwable -> L34
        F(this.f4896a);     // Catch: Throwable -> L34
        r10 = r17;
        r11 = false;
    L28:
        r10.h();     // Catch: Throwable -> L34
        monitor-exit(this);
        r10.j(r24);
        if (r11 == false) goto L33;
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadController", "reuse download task " + r18 + " group=" + r24 + ' ' + r10.o());
    L33:
        return r10;
    L25:
        r16 = false;
        goto L26
    L27:
        r18 = r25;
        goto L28
    L7:
        if (r10.C() != true) goto L9;
        r12 = true;
    L34:
        th = move-exception;
        throw th;
    }

    public final DownloadTask t(String r10) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        monitor-enter(this);
        DownloadTask r11 = this.f4898c.get(r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void u() {
    }

    public final void z(String r10) {
        Intrinsics.checkNotNullParameter(r10, "group");
        monitor-enter(this);
        Iterator<T> r11 = this.f4898c.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L8;
        DownloadTask.I((DownloadTask) r11.next(), r10, null, 2, null);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
