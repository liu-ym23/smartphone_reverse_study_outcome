package com.obric.aikernel.res.downloader;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.KevaImpl;
import com.google.gson.k;
import com.obric.aikernel.res.PackageResourceManager;
import ib.a0;
import ib.b0;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadTask {
    private volatile r0<Boolean> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PackageResourceManager.PresmConfig f4917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f4919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f4920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a0 f4921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b0 f4922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f4923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1<b, j> f4924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function1<PackageResourceManager.PresmConfig, f> f4925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f4926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f4927k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set<String> f4928l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile int f4929m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f4930n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile boolean f4931o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile int f4932p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f4933q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f4934r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile boolean f4935s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile int f4936t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile boolean f4937u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Set<String> f4938v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Function2<? super Set<String>, ? super Boolean, Unit> f4939w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final l0 f4940x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f4941y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List<Pair<j, b>> f4942z;

    /* JADX INFO: renamed from: com.obric.aikernel.res.downloader.DownloadTask$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PackageResourceManager.PresmConfig, f> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
            super(1, h.class, "resolveDownloadNetworkState", "resolveDownloadNetworkState(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)Lcom/obric/aikernel/res/downloader/DownloadNetworkState;", 1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final f invoke2(PackageResourceManager.PresmConfig r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return h.c(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ f invoke(PackageResourceManager.PresmConfig r10) {
            return invoke2(r10);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f4945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f4946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f4947e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f4948f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f4949g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f4950h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f4951i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f4952j;

        public b(String r10, String r11, String r12, String r13, String r14, int r15, boolean r16, int r17, boolean r18, boolean r19) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, "md5");
            Intrinsics.checkNotNullParameter(r12, "url");
            Intrinsics.checkNotNullParameter(r13, "savePath");
            Intrinsics.checkNotNullParameter(r14, "tmpPath");
            this.f4943a = r10;
            this.f4944b = r11;
            this.f4945c = r12;
            this.f4946d = r13;
            this.f4947e = r14;
            this.f4948f = r15;
            this.f4949g = r16;
            this.f4950h = r17;
            this.f4951i = r18;
            this.f4952j = r19;
        }

        public /* synthetic */ b(String r15, String r16, String r17, String r18, String r19, int r20, boolean r21, int r22, boolean r23, boolean r24, int r25, DefaultConstructorMarker r26) {
            if ((r25 & 64) == 0) goto L5;
            boolean r10 = true;
        L7:
            if ((r25 & 128) == 0) goto L9;
            int r11 = 3;
        L11:
            if ((r25 & 256) == 0) goto L13;
            boolean r12 = true;
        L15:
            if ((r25 & 512) == 0) goto L17;
            boolean r13 = false;
        L18:
            this(r15, r16, r17, r18, r19, r20, r10, r11, r12, r13);
            return;
        L17:
            r13 = r24;
            goto L18
        L13:
            r12 = r23;
            goto L15
        L9:
            r11 = r22;
            goto L11
        L5:
            r10 = r21;
            goto L7
        }

        public final boolean a() {
            return this.f4951i;
        }

        public final String b() {
            return this.f4944b;
        }

        public final String c() {
            return this.f4943a;
        }

        public final boolean d() {
            return this.f4949g;
        }

        public final int e() {
            return this.f4950h;
        }

        public final String f() {
            return this.f4946d;
        }

        public final int g() {
            return this.f4948f;
        }

        public final boolean h() {
            return this.f4952j;
        }

        public final String i() {
            return this.f4947e;
        }

        public final String j() {
            return this.f4945c;
        }

        public final boolean k() {
            File r10 = new File(this.f4946d, this.f4943a);
            if (r10.isFile() == true) goto L18;
            String[] r11 = r10.list();
            if (r11 != null) goto L8;
        L14:
            boolean r12 = true;
        L15:
            if (r12 == false) goto L17;
            return false;
        L17:
            return true;
        L8:
            if (r11.length != 0) goto L10;
            boolean r13 = true;
        L11:
            if (r13 == true) goto L14;
            r12 = false;
            goto L15
        L10:
            r13 = false;
            goto L11
        L18:
            return r10.exists();
        }

        public final void l(boolean r10) {
            this.f4952j = r10;
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadTask(PackageResourceManager.PresmConfig r10, String r11, CoroutineContext r12, List<b> r13, a0 r14, b0 r15, boolean r16, Function1<? super b, ? extends j> r17, Function1<? super PackageResourceManager.PresmConfig, f> r18, long r19, long r110) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "parentScope");
        Intrinsics.checkNotNullParameter(r13, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        Intrinsics.checkNotNullParameter(r14, "downloadListener");
        Intrinsics.checkNotNullParameter(r15, "monitorDepend");
        Intrinsics.checkNotNullParameter(r17, "downloadTaskFactory");
        Intrinsics.checkNotNullParameter(r18, "downloadNetworkStateProvider");
        this.f4917a = r10;
        this.f4918b = r11;
        this.f4919c = r12;
        this.f4920d = r13;
        this.f4921e = r14;
        this.f4922f = r15;
        this.f4923g = r16;
        this.f4924h = r17;
        this.f4925i = r18;
        this.f4926j = r19;
        this.f4927k = r110;
        this.f4928l = new LinkedHashSet();
        this.f4930n = true;
        this.f4938v = new LinkedHashSet();
        this.f4940x = m0.a(r12.plus(new k0(r11)));
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r13.iterator();
    L3:
        Pair r22 = null;
        if (r21.hasNext() == false) goto L11;
        b r23 = (b) r21.next();
        if (r23.k() == true) goto L9;
        this.f4941y += (long) r23.g();
        r22 = new Pair(this.f4924h.invoke(r23), r23);
    L9:
        if (r22 == null) goto L3;
        r20.add(r22);
        goto L3
    L11:
        this.f4942z = r20;
        this.f4935s = h.d(r20.isEmpty());
        this.A = kotlinx.coroutines.h.b(this.f4940x, null, null, new DownloadTask$splitTask$1(this, null), 3, null);
    }

    public /* synthetic */ DownloadTask(final PackageResourceManager.PresmConfig r17, String r18, CoroutineContext r19, List r20, final a0 r21, final b0 r22, boolean r23, Function1 r24, Function1 r25, long r26, long r28, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 64) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r30 & 128) == 0) goto L9;
        Function1 r11 = new AnonymousClass1(r17, r21, r22);
    L11:
        if ((r30 & 256) == 0) goto L13;
        Function1 r12 = AnonymousClass2.INSTANCE;
    L15:
        if ((r30 & 512) == 0) goto L17;
        long r13 = 5000;
    L19:
        if ((r30 & 1024) == 0) goto L21;
        long r14 = 1000;
    L22:
        this(r17, r18, r19, r20, r21, r22, r10, r11, r12, r13, r14);
        return;
    L21:
        r14 = r28;
        goto L22
    L17:
        r13 = r26;
        goto L19
    L13:
        r12 = r25;
        goto L15
    L9:
        r11 = r24;
        goto L11
    L5:
        r10 = r23;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean I(DownloadTask r10, String r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = DownloadTask$removeGroup$1.INSTANCE;
    L6:
        return r10.H(r11, r12);
    }

    private final boolean Q() {
        f r10 = this.f4925i.invoke(this.f4917a);
        boolean r11 = this.f4917a.getAppConfig().getAllowNetworkRequest().invoke().booleanValue();
        boolean r12 = !this.f4928l.isEmpty();
        boolean r13 = this.f4923g;
        boolean r14 = this.f4930n;
        boolean r15 = this.f4917a.getAppConfig().getAllowBackgroundUpdate().getValue().getFirst().booleanValue();
        String r16 = this.f4917a.getAppConfig().getAllowBackgroundUpdate().getValue().getSecond();
        boolean r17 = r10.b();
        List<b> r18 = this.f4920d;
        if ((r18 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r19 = r18.iterator();
    L9:
        if (r19.hasNext() == false) goto L6;
        if (((b) r19.next()).d() == false) goto L9;
        boolean r110 = true;
    L13:
        com.obric.aikernel.res.downloader.a r20 = com.obric.aikernel.res.downloader.b.a(new c(r11, r12, r13, r14, r15, r16, r17, r110, r10.a()));
        if (r20.a() == true) goto L16;
        return false;
    L16:
        this.f4932p = r20.c();
        int r21 = r20.c();
        if (r21 != 1) goto L19;
        com.obric.aikernel.runtime.utils.d.f5417a.l("DownloadTask", "download task " + this.f4918b + " quit by caller is all canceled");
    L34:
        return true;
    L19:
        if (r21 != 2) goto L21;
        com.obric.aikernel.runtime.utils.d r22 = com.obric.aikernel.runtime.utils.d.f5417a;
        String r111 = "background download task " + this.f4918b + " quit by disallow reason: " + r20.b();
    L32:
        r22.l("DownloadTask", r111);
        goto L34
    L21:
        if (r21 != 3) goto L23;
        com.obric.aikernel.runtime.utils.d r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        String r23 = "no STATE_NEED_WIFI";
    L30:
        r112.l("DownloadTask", r23);
        goto L34
    L23:
        if (r21 != 4) goto L25;
        r22 = com.obric.aikernel.runtime.utils.d.f5417a;
        r111 = "download task " + this.f4918b + " blocked by " + r20.b();
        goto L32
    L25:
        if (r21 != 5) goto L34;
        r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        r23 = "no valid internet";
    L6:
        r110 = false;
        goto L13
    L5:
        if (r18.isEmpty() == false) goto L7;
        goto L6
    }

    public static final /* synthetic */ Object a(DownloadTask r10, Continuation r11) {
        return r10.m(r11);
    }

    public static final /* synthetic */ boolean b(DownloadTask r10) {
        return r10.n();
    }

    public static final /* synthetic */ PackageResourceManager.PresmConfig c(DownloadTask r10) {
        return r10.f4917a;
    }

    public static final /* synthetic */ List d(DownloadTask r10) {
        return r10.f4942z;
    }

    public static final /* synthetic */ long e(DownloadTask r10) {
        return r10.f4926j;
    }

    public static final /* synthetic */ void f(DownloadTask r10, boolean r11) {
        r10.f4935s = r11;
    }

    public static final /* synthetic */ boolean g(DownloadTask r10) {
        return r10.Q();
    }

    private final Object m(Continuation<? super Boolean> r10) {
        if ((r10 instanceof DownloadTask$completeAndFinishIfDownloadedFromTasks$1) == false) goto L7;
        DownloadTask$completeAndFinishIfDownloadedFromTasks$1 r11 = (DownloadTask$completeAndFinishIfDownloadedFromTasks$1) r10;
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
        DownloadTask r17 = (DownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
        DownloadTask r18 = r17;
    L20:
        if (r16.hasNext() == false) goto L24;
        j r19 = (j) ((Pair) r16.next()).getFirst();
        r11.L$0 = r18;
        r11.L$1 = r16;
        r11.label = 1;
        if (r19.f(r11) != r14) goto L20;
        return r14;
    L24:
        r18.f4935s = h.d(true);
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (n() == false) goto L17;
        Iterator r20 = this.f4942z.iterator();
        r18 = this;
        r16 = r20;
        goto L20
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r11 = new DownloadTask$completeAndFinishIfDownloadedFromTasks$1(this, r10);
        goto L8
    }

    private final boolean n() {
        if (this.f4942z.isEmpty() == false) goto L6;
        this.f4935s = h.d(true);
        return true;
    L6:
        List<Pair<j, b>> r10 = this.f4942z;
        boolean r11 = false;
        if ((r10 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L10;
        Pair r13 = (Pair) r12.next();
        j r14 = (j) r13.component1();
        b r15 = (b) r13.component2();
        if (r15.h() == false) goto L17;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == false) goto L23;
        r15.l(true);
    L23:
        if (r16 == true) goto L13;
    L24:
        if (r11 == false) goto L26;
        this.f4935s = h.d(true);
    L26:
        return r11;
    L17:
        if (r14.b() == true) goto L20;
        r16 = false;
    L10:
        r11 = true;
        goto L24
    L9:
        if (r10.isEmpty() == false) goto L11;
        goto L10
    }

    private final void p() {
        this.A = kotlinx.coroutines.h.b(this.f4940x, null, null, new DownloadTask$downloadSplit$1(this, null), 3, null);
    }

    public final Object A(Continuation<? super Boolean> r10) {
        return this.A.r(r10);
    }

    public final synchronized boolean B(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "group");     // Catch: Throwable -> L6
        boolean r11 = this.f4928l.contains(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean C() {
        return h.e(this.f4935s, this.A.a(), D(), this.f4932p, this.f4936t);
    }

    public final boolean D() {
        List<Pair<j, b>> r10 = this.f4942z;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        b r13 = (b) ((Pair) r12.next()).getSecond();
        if (r13.h() == false) goto L7;
        r11.add(r13);
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    public final void E() {
        monitor-enter(this);
        this.f4937u = true;     // Catch: Throwable -> L15
        Pair r10 = TuplesKt.to(CollectionsKt.toSet(this.f4938v), this.f4939w);     // Catch: Throwable -> L15
        monitor-exit(this);
        Function2 r11 = (Function2) r10.getSecond();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((true ^ ((Collection) r10.getFirst()).isEmpty()) == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L21;
        r11.invoke(r10.getFirst(), Boolean.TRUE);
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void F() {
        monitor-enter(this);
        this.f4937u = false;     // Catch: Throwable -> L15
        Pair r10 = TuplesKt.to(CollectionsKt.toSet(this.f4938v), this.f4939w);     // Catch: Throwable -> L15
        monitor-exit(this);
        Function2 r11 = (Function2) r10.getSecond();
        if (r11 != null) goto L9;
        return;
    L9:
        if ((!((Collection) r10.getFirst()).isEmpty()) == true) goto L12;
        r11 = null;
    L12:
        if (r11 == null) goto L21;
        r11.invoke(r10.getFirst(), Boolean.FALSE);
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void G() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f4936t <= 0) goto L6;
        this.f4936t--;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public final synchronized boolean H(String r10, Function1<? super Boolean, Unit> r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "group");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r11, "action");     // Catch: Throwable -> L13
        if (r10.length() != 0) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L9;
        this.f4928l.clear();     // Catch: Throwable -> L13
    L10:
        boolean r13 = this.f4928l.isEmpty();     // Catch: Throwable -> L13
        r11.invoke(Boolean.valueOf(r13));     // Catch: Throwable -> L13
        monitor-exit(this);
        return r13;
    L9:
        this.f4928l.remove(r10);     // Catch: Throwable -> L13
        goto L10
    L6:
        r12 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final Object J(Continuation<? super r0<Boolean>> r13) {
        if ((r13 instanceof DownloadTask$run$1) == false) goto L7;
        DownloadTask$run$1 r10 = (DownloadTask$run$1) r13;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        DownloadTask this = (DownloadTask) r10.L$0;
        ResultKt.throwOnFailure(r14);
    L34:
        if (((Boolean) r14).booleanValue() == false) goto L36;
        this.A = kotlinx.coroutines.h.b(this.f4940x, null, null, new DownloadTask$run$3(null), 3, null);
    L38:
        return this.A;
    L36:
        this.p();
        goto L38
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        this = (DownloadTask) r10.L$0;
        ResultKt.throwOnFailure(r14);
    L29:
        if (((Boolean) r14).booleanValue() == true) goto L38;
        r10.L$0 = this;
        r10.label = 3;
        r14 = this.m(r10);
        if (r14 != r12) goto L34;
        return r12;
    L17:
        this = (DownloadTask) r10.L$0;
        ResultKt.throwOnFailure(r14);
    L22:
        if (((Boolean) r14).booleanValue() == false) goto L25;
        this.A = kotlinx.coroutines.h.b(this.f4940x, null, null, new DownloadTask$run$2(null), 3, null);
        return this.A;
    L25:
        r0<Boolean> r16 = this.A;
        r10.L$0 = this;
        r10.label = 2;
        r14 = r16.r(r10);
        if (r14 != r12) goto L29;
        return r12;
    L18:
        ResultKt.throwOnFailure(r14);
        this.f4933q = true;
        r10.L$0 = this;
        r10.label = 1;
        r14 = m(r10);
        if (r14 != r12) goto L22;
        return r12;
    L7:
        r10 = new DownloadTask$run$1(this, r13);
        goto L8
    }

    public final void K(boolean r10) {
        this.f4930n = r10;
    }

    public final void L(boolean r10) {
        this.f4933q = r10;
    }

    public final void M(float r10) {
        this.f4934r = r10;
    }

    public final void N(int r10) {
        this.f4929m = r10;
    }

    public final void O(boolean r10) {
        this.f4931o = r10;
    }

    public final void P(int r10) {
        this.f4932p = r10;
    }

    public final synchronized void h() {
        monitor-enter(this);
        this.f4936t++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i(Collection<String> r10, Function2<? super Set<String>, ? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "keys");
        Intrinsics.checkNotNullParameter(r11, "listener");
        monitor-enter(this);
        this.f4939w = r11;     // Catch: Throwable -> L24
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L24
        Iterator<T> r13 = r10.iterator();     // Catch: Throwable -> L24
    L6:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();     // Catch: Throwable -> L24
        if (this.f4938v.add((String) r14) == false) goto L6;
        r12.add(r14);     // Catch: Throwable -> L24
        goto L6
    L10:
        Set r15 = CollectionsKt.toSet(r12);     // Catch: Throwable -> L24
        boolean r16 = true;
        if (this.f4937u == false) goto L16;
        if ((!r15.isEmpty()) == false) goto L16;
    L17:
        if (r16 == true) goto L20;
        r15 = null;
    L20:
        monitor-exit(this);
        if (r15 == null) goto L34;
        r11.invoke(r15, Boolean.TRUE);
        return;
    L34:
        return;
    L16:
        r16 = false;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void j(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "group");     // Catch: Throwable -> L6
        this.f4928l.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0123 -> B:14:0x003f). Please report as a decompilation issue!!! */
    public final Object k(Continuation<? super Pair<Pair<Boolean, Integer>, ? extends List<b>>> r24) {
        DownloadTask r10 = this;
        if ((r24 instanceof DownloadTask$await$1) == false) goto L7;
        DownloadTask$await$1 r11 = (DownloadTask$await$1) r24;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        boolean r16 = true;
        if (r15 == 0) goto L19;
        if (r15 == 1) goto L18;
        if (r15 == 2) goto L17;
        if (r15 != 3) goto L16;
        int r17 = r11.I$0;
        DownloadTask r18 = (DownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L14:
        int r19 = r17;
        r10 = r18;
    L20:
        r0<Boolean> r20 = r10.A;
        r11.L$0 = r10;
        r11.I$0 = r19;
        r11.label = 1;
        Object r21 = r20.r(r11);
        if (r21 != r14) goto L23;
        return r14;
    L23:
        r18 = r10;
        int r22 = r19;
        r13 = r21;
    L25:
        if (((Boolean) r13).booleanValue() == true) goto L40;
        r11.L$0 = r18;
        r11.I$0 = r22;
        r11.label = 2;
        r13 = r18.m(r11);
        if (r13 != r14) goto L30;
        return r14;
    L30:
        if (((Boolean) r13).booleanValue() == false) goto L32;
        r18.A = kotlinx.coroutines.h.b(r18.f4940x, null, null, new DownloadTask$await$3(null), 3, null);
        goto L40
    L32:
        r17 = r22 + 1;
        if (r17 != 1) goto L35;
    L36:
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadTask", "download await waiting id=" + r18.f4918b + " waitLoop=" + r17 + ' ' + r18.o());
    L37:
        long r110 = r18.f4927k;
        r11.L$0 = r18;
        r11.I$0 = r17;
        r11.label = 3;
        if (DelayKt.b(r110, r11) != r14) goto L14;
        return r14;
    L35:
        if ((r17 % 30) != 0) goto L37;
    L40:
        List<Pair<j, b>> r23 = r18.f4942z;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r26 = r23.iterator();
    L42:
        if (r26.hasNext() == false) goto L47;
        b r27 = (b) ((Pair) r26.next()).getSecond();
        if (r27.h() == true) goto L46;
        r16 = false;
    L46:
        r25.add(r27);
        goto L42
    L47:
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadTask", "download await end id=" + r18.f4918b + " success=" + r16 + ' ' + r18.o() + " files=" + CollectionsKt.joinToString$default(r25, null, null, null, 8, null, DownloadTask$await$4.INSTANCE, 23, null));
        return new Pair(new Pair(Boxing.boxBoolean(r16), Boxing.boxInt(r18.f4932p)), r25);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r22 = r11.I$0;
        r18 = (DownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
        goto L30
    L18:
        r22 = r11.I$0;
        r18 = (DownloadTask) r11.L$0;
        ResultKt.throwOnFailure(r13);
        goto L25
    L19:
        ResultKt.throwOnFailure(r13);
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadTask", "download await start id=" + r10.f4918b + ' ' + o() + " files=" + CollectionsKt.joinToString$default(r10.f4942z, null, null, null, 8, null, DownloadTask$await$2.INSTANCE, 23, null));
        r19 = 0;
    L7:
        r11 = new DownloadTask$await$1(r10, r24);
        goto L8
    }

    public final Object l(Continuation<? super Unit> r12) {
        if ((r12 instanceof DownloadTask$cancel$1) == false) goto L7;
        DownloadTask$cancel$1 r10 = (DownloadTask$cancel$1) r12;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r13 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Iterator r16 = (Iterator) r10.L$1;
        DownloadTask r17 = (DownloadTask) r10.L$0;
        ResultKt.throwOnFailure(r13);
        DownloadTask r18 = r17;
    L16:
        if (r16.hasNext() == false) goto L20;
        j r19 = (j) ((Pair) r16.next()).getFirst();
        r10.L$0 = r18;
        r10.L$1 = r16;
        r10.label = 1;
        if (r19.e(r10) != r14) goto L16;
        return r14;
    L20:
        r18.f4935s = true;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0<Boolean> r110 = this.A;
        this.A = kotlinx.coroutines.h.b(this.f4940x, null, null, new DownloadTask$cancel$2(null), 3, null);
        v1.a.a(r110, null, 1, null);
        Iterator r111 = this.f4942z.iterator();
        r18 = this;
        r16 = r111;
    L7:
        r10 = new DownloadTask$cancel$1(this, r12);
        goto L8
    }

    public final synchronized String o() {
        monitor-enter(this);
        String r10 = "state=" + this.f4932p + " started=" + this.f4931o + " completed=" + this.f4935s + " prior=" + this.f4929m + " background=" + this.f4930n + " canRunSplit=" + this.f4933q + " holderCount=" + this.f4936t + " groupCount=" + this.f4928l.size() + " fileCount=" + this.f4942z.size() + " progress=" + this.f4934r + " size=" + this.f4941y;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean q() {
        return this.f4930n;
    }

    public final boolean r() {
        return this.f4933q;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0074 -> B:21:0x0075). Please report as a decompilation issue!!! */
    public final Object s(Continuation<? super List<k>> r10) {
        if ((r10 instanceof DownloadTask$getDownloadInfos$1) == false) goto L7;
        DownloadTask$getDownloadInfos$1 r11 = (DownloadTask$getDownloadInfos$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Collection r16 = (Collection) r11.L$2;
        Iterator r17 = (Iterator) r11.L$1;
        Collection r18 = (Collection) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        r16.add((k) r13);
        r16 = r18;
    L16:
        if (r17.hasNext() == false) goto L23;
        j r19 = (j) ((Pair) r17.next()).getFirst();
        r11.L$0 = r16;
        r11.L$1 = r17;
        r11.L$2 = r16;
        r11.label = 1;
        r13 = r19.a(r11);
        if (r13 != r14) goto L20;
        return r14;
    L20:
        r18 = r16;
        goto L21
    L23:
        return (List) r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        List<Pair<j, b>> r20 = this.f4942z;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        r17 = r20.iterator();
        r16 = r21;
    L7:
        r11 = new DownloadTask$getDownloadInfos$1(this, r10);
        goto L8
    }

    public final float t() {
        return this.f4934r;
    }

    public final long u() {
        return this.f4941y;
    }

    public final String v() {
        return this.f4918b;
    }

    public final int w() {
        return this.f4929m;
    }

    public final boolean x() {
        return this.f4931o;
    }

    public final int y() {
        return this.f4932p;
    }

    public final boolean z() {
        return this.f4935s;
    }
}
