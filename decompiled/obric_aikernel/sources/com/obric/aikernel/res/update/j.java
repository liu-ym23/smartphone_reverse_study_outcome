package com.obric.aikernel.res.update;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<h, Unit> f5194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f5195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f5196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.d f5197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, b> f5198e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f5199n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f5203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f5204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f5205f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f5206g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f5207h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f5208i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f5209j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f5210k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f5211l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f5212m;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public final b a(g r21, boolean r22, long r23) {
                Intrinsics.checkNotNullParameter(r21, "identity");
                String r10 = r21.h();
                String r11 = r21.g();
                String r12 = r21.i();
                String r13 = r21.f();
                String r14 = r21.a();
                String r15 = r21.c();
                return new b(r10, r11, r12, r13, r21.d(), r21.e(), r14, r15, r22, r23, 0, 0, 0, 7168, null);
            }
        }

        static {
            f5199n = new a(null);
        }

        public b(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, boolean r18, long r19, long r20, int r22, long r23) {
            Intrinsics.checkNotNullParameter(r10, "ownerType");
            Intrinsics.checkNotNullParameter(r11, "ownerName");
            Intrinsics.checkNotNullParameter(r12, "ownerVersion");
            Intrinsics.checkNotNullParameter(r13, "ownerDepVersion");
            Intrinsics.checkNotNullParameter(r14, "modelName");
            Intrinsics.checkNotNullParameter(r15, "modelVersion");
            this.f5200a = r10;
            this.f5201b = r11;
            this.f5202c = r12;
            this.f5203d = r13;
            this.f5204e = r14;
            this.f5205f = r15;
            this.f5206g = r16;
            this.f5207h = r17;
            this.f5208i = r18;
            this.f5209j = r19;
            this.f5210k = r20;
            this.f5211l = r22;
            this.f5212m = r23;
        }

        public /* synthetic */ b(String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, boolean r29, long r30, long r32, int r34, long r35, int r37, DefaultConstructorMarker r38) {
            if ((r37 & 64) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r37 & 128) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r37 & 1024) == 0) goto L13;
            long r15 = 0;
        L15:
            if ((r37 & 2048) == 0) goto L17;
            int r17 = 0;
        L19:
            if ((r37 & 4096) == 0) goto L21;
            long r18 = 0;
        L22:
            this(r21, r22, r23, r24, r25, r26, r10, r11, r29, r30, r15, r17, r18);
            return;
        L21:
            r18 = r35;
            goto L22
        L17:
            r17 = r34;
            goto L19
        L13:
            r15 = r32;
            goto L15
        L9:
            r11 = r28;
            goto L11
        L5:
            r10 = r27;
            goto L7
        }

        public final String a() {
            String r10 = this.f5206g;
            if (r10 != null) goto L6;
            r10 = "";
        L6:
            if (r10.length() != 0) goto L8;
            boolean r11 = true;
        L9:
            if (r11 == true) goto L11;
            return r10;
        L11:
            return this.f5201b;
        L8:
            r11 = false;
            goto L9
        }

        public final String b() {
            String r10 = this.f5207h;
            String r11 = "";
            if (r10 != null) goto L6;
            r10 = "";
        L6:
            if (r10.length() != 0) goto L8;
            boolean r12 = true;
        L9:
            if (r12 == true) goto L11;
            return r10;
        L11:
            if (Intrinsics.areEqual(this.f5200a, "lora") == false) goto L14;
            r11 = this.f5201b;
        L14:
            return r11;
        L8:
            r12 = false;
            goto L9
        }

        public final int c() {
            return this.f5211l;
        }

        public final long d() {
            return this.f5212m;
        }

        public final long e() {
            return this.f5210k;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f5200a, r11.f5200a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5201b, r11.f5201b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f5202c, r11.f5202c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f5203d, r11.f5203d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f5204e, r11.f5204e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f5205f, r11.f5205f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f5206g, r11.f5206g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f5207h, r11.f5207h) == true) goto L33;
            return false;
        L33:
            if (this.f5208i == r11.f5208i) goto L36;
            return false;
        L36:
            if (this.f5209j == r11.f5209j) goto L39;
            return false;
        L39:
            if (this.f5210k == r11.f5210k) goto L42;
            return false;
        L42:
            if (this.f5211l == r11.f5211l) goto L45;
            return false;
        L45:
            if (this.f5212m == r11.f5212m) goto L47;
            return false;
        L47:
            return true;
        }

        public final boolean f() {
            return this.f5208i;
        }

        public final String g() {
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{this.f5200a, this.f5201b, this.f5202c, this.f5203d, this.f5204e, this.f5205f}), "\u001f", null, null, 0, null, null, 62, null);
        }

        public final String h() {
            return this.f5204e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v25 */
        public int hashCode() {
            int r10 = ((((((((((this.f5200a.hashCode() * 31) + this.f5201b.hashCode()) * 31) + this.f5202c.hashCode()) * 31) + this.f5203d.hashCode()) * 31) + this.f5204e.hashCode()) * 31) + this.f5205f.hashCode()) * 31;
            String r11 = this.f5206g;
            int r12 = 0;
            if (r11 != null) goto L5;
            int r13 = 0;
        L6:
            int r14 = (r10 + r13) * 31;
            String r15 = this.f5207h;
            if (r15 == null) goto L10;
            r12 = r15.hashCode();
        L10:
            int r16 = (r14 + r12) * 31;
            boolean r17 = this.f5208i;
            ?? r18 = r17;
            if (r17 == false) goto L14;
            r18 = 1;
        L14:
            return ((((((((r16 + r18) * 31) + Long.hashCode(this.f5209j)) * 31) + Long.hashCode(this.f5210k)) * 31) + Integer.hashCode(this.f5211l)) * 31) + Long.hashCode(this.f5212m);
        L5:
            r13 = r11.hashCode();
            goto L6
        }

        public final String i() {
            return this.f5205f;
        }

        public final String j() {
            return this.f5201b;
        }

        public final String k() {
            return this.f5200a;
        }

        public final long l() {
            return this.f5209j;
        }

        public final void m(int r10) {
            this.f5211l = r10;
        }

        public final void n(long r10) {
            this.f5212m = r10;
        }

        public final void o(long r10) {
            this.f5210k = r10;
        }

        public final void p(boolean r10) {
            this.f5208i = r10;
        }

        public String toString() {
            return "ModelDownloadState(ownerType=" + this.f5200a + ", ownerName=" + this.f5201b + ", ownerVersion=" + this.f5202c + ", ownerDepVersion=" + this.f5203d + ", modelName=" + this.f5204e + ", modelVersion=" + this.f5205f + ", bizName=" + this.f5206g + ", loraType=" + this.f5207h + ", foreground=" + this.f5208i + ", startTimestamp=" + this.f5209j + ", downloadDuration=" + this.f5210k + ", activeCount=" + this.f5211l + ", activeStartTimestamp=" + this.f5212m + ')';
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(File r10, Function1<? super h, Unit> r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "rootDir");
        Intrinsics.checkNotNullParameter(r11, "listener");
        Intrinsics.checkNotNullParameter(r12, "clock");
        this.f5194a = r11;
        this.f5195b = r12;
        this.f5196c = new File(r10, "model_download_telemetry.json");
        this.f5197d = new com.google.gson.d();
        this.f5198e = new LinkedHashMap();
        h();
    }

    public /* synthetic */ j(File r10, Function1 r11, f r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = l.f5214a;
    L5:
        this(r10, r11, r12);
    }

    private final h c(b r21, int r22, int r23, long r24) {
        d(r21, r24);
        long r10 = Math.max(0, r24 - r21.l());
        long r12 = RangesKt.coerceIn(r21.e(), 0, r10);
        String r11 = r21.h();
        String r17 = r21.i();
        String r18 = r21.a();
        String r19 = r21.b();
        return new h(r11, r22, r23, r10, r12, r10 - r12, r21.f() ? 1 : 0, r17, r18, r19);
    }

    private final void d(b r10, long r11) {
        if (r10.c() > 0) goto L6;
    L4:
        r10.m(0);
        r10.n(0);
        return;
    L6:
        r10.o(r10.e() + Math.max(0, r11 - r10.d()));
        goto L4
    }

    private final void h() {
        if (this.f5196c.exists() == true) goto L32;
        return;
    L32:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        Object r11 = (Object[]) this.f5197d.k(FilesKt.readText$default(this.f5196c, null, 1, null), b[].class);     // Catch: Throwable -> L19
        if (r11 != null) goto L8;
        r11 = new b[0];     // Catch: Throwable -> L19
    L8:
        b[] r12 = (b[]) r11;     // Catch: Throwable -> L19
        monitor-enter(this);     // Catch: Throwable -> L19
        this.f5198e.clear();     // Catch: Throwable -> L16
        int r13 = r12.length;     // Catch: Throwable -> L16
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L13;
        b r15 = r12[r14];     // Catch: Throwable -> L16
        r15.m(0);     // Catch: Throwable -> L16
        r15.n(0);     // Catch: Throwable -> L16
        this.f5198e.put(r15.g(), r15);     // Catch: Throwable -> L16
        r14 = r14 + 1;     // Catch: Throwable -> L16
        goto L11
    L13:
        j();     // Catch: Throwable -> L16
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L19
        Object r17 = Result.m32constructorimpl(r16);     // Catch: Throwable -> L19
    L21:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L38;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L25
        Object r20 = Result.m32constructorimpl(Boolean.valueOf(this.f5196c.delete()));     // Catch: Throwable -> L25
    L27:
        Boolean r21 = Boolean.FALSE;
        if (Result.m38isFailureimpl(r20) == false) goto L30;
        r20 = r21;
    L30:
        boolean r22 = ((Boolean) r20).booleanValue();
        com.obric.aikernel.runtime.utils.d.f5417a.l("ModelDownloadTelemetry", "load model download telemetry failed " + this.f5196c.getPath() + ", deleted=" + r22 + ": " + r18);
        return;
    L25:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L27
    L38:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final void j() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        if (this.f5198e.isEmpty() == false) goto L5;
        Object r11 = Boolean.valueOf(this.f5196c.delete());     // Catch: Throwable -> L8
    L6:
        Object r12 = Result.m32constructorimpl(r11);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L16;
        com.obric.aikernel.runtime.utils.d.f5417a.l("ModelDownloadTelemetry", "save model download telemetry failed " + this.f5196c.getPath() + ": " + r13);
        return;
    L16:
        return;
    L5:
        com.obric.aikernel.res.utils.a r14 = com.obric.aikernel.res.utils.a.f5222a;     // Catch: Throwable -> L8
        File r15 = this.f5196c;     // Catch: Throwable -> L8
        String r16 = this.f5197d.t(this.f5198e.values());     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r16, "gson.toJson(states.values)");     // Catch: Throwable -> L8
        r14.k(r15, r16);     // Catch: Throwable -> L8
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void l(b r10, long r11) {
        if (r10.c() > 0) goto L6;
        r10.m(0);
        r10.n(0);
        return;
    L6:
        r10.m(r10.c() - 1);
        if (r10.c() != 0) goto L10;
        r10.o(r10.e() + Math.max(0, r11 - r10.d()));
        r10.n(0);
        return;
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        b r11 = this.f5198e.get(r10);     // Catch: Throwable -> L14
        if (r11 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r12 = this.f5195b.a();     // Catch: Throwable -> L14
        if (r11.c() != 0) goto L11;
        r11.n(r12);     // Catch: Throwable -> L14
    L11:
        r11.m(r11.c() + 1);     // Catch: Throwable -> L14
        j();     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        b r11 = this.f5198e.get(r10);     // Catch: Throwable -> L11
        if (r11 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        l(r11, this.f5195b.a());     // Catch: Throwable -> L11
        j();     // Catch: Throwable -> L11
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        b r12 = this.f5198e.remove(r10);     // Catch: Throwable -> L13
        if (r12 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        h r13 = c(r12, 0, r11, this.f5195b.a());     // Catch: Throwable -> L13
        j();     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f5194a.invoke(r13);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void f(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "ownerName");
        monitor-enter(this);
        long r10 = this.f5195b.a();     // Catch: Throwable -> L29
        Map<String, b> r14 = this.f5198e;     // Catch: Throwable -> L29
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, b>> r16 = r14.entrySet().iterator();     // Catch: Throwable -> L29
    L5:
        boolean r17 = true;
        if (r16.hasNext() == false) goto L16;
        Map.Entry<String, b> r18 = r16.next();     // Catch: Throwable -> L29
        b r19 = r18.getValue();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r19.j(), r12) == false) goto L13;
        if (r11 != null) goto L11;
    L14:
        if (r17 == false) goto L5;
        r15.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L29
        goto L5
    L11:
        if (Intrinsics.areEqual(r19.k(), r11) == true) goto L14;
    L13:
        r17 = false;
        goto L14
    L16:
        ArrayList r110 = new ArrayList(r15.size());     // Catch: Throwable -> L29
        Iterator r111 = r15.entrySet().iterator();     // Catch: Throwable -> L29
    L18:
        if (r111.hasNext() == false) goto L21;
        Map.Entry r20 = (Map.Entry) r111.next();     // Catch: Throwable -> L29
        String r21 = (String) r20.getKey();     // Catch: Throwable -> L29
        b r22 = (b) r20.getValue();     // Catch: Throwable -> L29
        this.f5198e.remove(r21);     // Catch: Throwable -> L29
        r110.add(c(r22, 0, r13, r10));     // Catch: Throwable -> L29
        goto L18
    L21:
        if ((!r110.isEmpty()) == false) goto L23;
        j();     // Catch: Throwable -> L29
    L23:
        monitor-exit(this);
        Function1<h, Unit> r112 = this.f5194a;
        Iterator r113 = r110.iterator();
    L26:
        if (r113.hasNext() == false) goto L28;
        r112.invoke((h) r113.next());
        goto L26
    L28:
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final void g(int r11) {
        monitor-enter(this);
        long r10 = this.f5195b.a();     // Catch: Throwable -> L16
        Collection<b> r12 = this.f5198e.values();     // Catch: Throwable -> L16
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L16
        Iterator<T> r14 = r12.iterator();     // Catch: Throwable -> L16
    L5:
        if (r14.hasNext() == false) goto L7;
        r13.add(c((b) r14.next(), 0, r11, r10));     // Catch: Throwable -> L16
        goto L5
    L7:
        this.f5198e.clear();     // Catch: Throwable -> L16
        if ((!r13.isEmpty()) == false) goto L10;
        j();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        Function1<h, Unit> r15 = this.f5194a;
        Iterator r16 = r13.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        r15.invoke((h) r16.next());
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f5198e.containsKey(r10) == false) goto L7;
        j();     // Catch: Throwable -> L10
    L7:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final void k(g r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "identity");
        monitor-enter(this);
        b r12 = this.f5198e.get(r10.b());     // Catch: Throwable -> L17
        if (r12 != null) goto L8;
        this.f5198e.put(r10.b(), b.f5199n.a(r10, r11, this.f5195b.a()));     // Catch: Throwable -> L17
    L14:
        j();     // Catch: Throwable -> L17
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L8:
        if (r12.f() == true) goto L12;
        if (r11 == true) goto L12;
        boolean r14 = false;
    L13:
        r12.p(r14);     // Catch: Throwable -> L17
    L12:
        r14 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public final void m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        monitor-enter(this);
        b r11 = this.f5198e.remove(r10);     // Catch: Throwable -> L13
        if (r11 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        h r12 = c(r11, 1, 0, this.f5195b.a());     // Catch: Throwable -> L13
        j();     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f5194a.invoke(r12);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
