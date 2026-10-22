package hda;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.a;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.f5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.i5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewFeedbackState;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.cocreationreview.s5;
import com.obric.assistant.cocreationreview.t5;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0<R extends com.obric.assistant.cocreationreview.a> implements e5 {
    public final l5 a;
    public final MemoryDataReviewModuleKey b;
    public final hda.b c;
    public final r0<R> d;
    public final Executor e;
    public final Function0<Unit> f;
    public final ModuleKey g;
    public final LinkedHashSet<f5> h;
    public final AtomicLong i;
    public volatile List<? extends R> j;
    public volatile Map<String, a5> k;
    public volatile g5 l;
    public boolean m;
    public int n;

    public static final class a {
    }

    public static final class b<R extends com.obric.assistant.cocreationreview.a> {
        public final List<R> a;
        public final Map<String, a5> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "LoadedMemoryReviewRecords(records=" + this.a + ", feedbackByRecordId=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends R> r2, Map<String, a5> r3) {
            Intrinsics.checkNotNullParameter(r2, "records");
            Intrinsics.checkNotNullParameter(r3, "feedbackByRecordId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
        g5 r0 = this.l;
        if (r0 != null) goto L6;
        int r1 = s3.a;
        s3.c("memory.provider.refresh", "skip_resume module=" + this.g.getRaw() + ", reason=no_active_request");
        return;
    L6:
        long r2 = r0.a;
        int r3 = g5.c;
        Intrinsics.checkNotNullParameter("host_resume_from_background", "reason");
        g5 r4 = new g5(r2, "host_resume_from_background");
        this.l = r4;
        int r5 = s3.a;
        s3.b("memory.provider.refresh", "resume module=" + this.g.getRaw() + ", earliest=" + g5.a(r4).a);
        i(r4);
    }

    public final i5 g() {
        this.n++;
        Map<String, a5> r0 = this.k;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, a5>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, a5> r3 = r1.next();
        if (r3.getValue().e == false) goto L4;
        r2.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        Set r4 = r2.keySet();
        l5 r5 = this.a;
        List<? extends R> r6 = this.j;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        if (r4.contains(((com.obric.assistant.cocreationreview.a) r9).a()) == true) goto L10;
        r7.add(r9);
        goto L10
    L14:
        List<? extends R> r10 = this.j;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        Object r13 = r12.next();
        if (r4.contains(((com.obric.assistant.cocreationreview.a) r13).a()) == false) goto L16;
        r11.add(r13);
        goto L16
    L20:
        Map<String, a5> r14 = this.k;
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<Map.Entry<String, a5>> r16 = r14.entrySet().iterator();
    L22:
        if (r16.hasNext() == false) goto L37;
        Map.Entry<String, a5> r17 = r16.next();
        String r18 = r17.getKey();
        List<? extends R> r19 = this.j;
        if ((r19 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r20 = r19.iterator();
    L30:
        if (r20.hasNext() == false) goto L34;
        if (Intrinsics.areEqual(((com.obric.assistant.cocreationreview.a) r20.next()).a(), r18) == false) goto L30;
        boolean r21 = true;
    L35:
        if (r21 == false) goto L22;
        r15.put(r17.getKey(), r17.getValue());
    L34:
        r21 = false;
        goto L35
    L26:
        if (r19.isEmpty() == false) goto L28;
    L37:
        i5 r22 = new i5(r5, r7, r11, r15);
        int r23 = s3.a;
        s3.a("memory.provider.snapshot", "build module=" + this.g.getRaw() + ", version=" + this.n + ", pending=" + r22.b.size() + ", completed=" + r22.c.size() + ", feedback=" + r22.d.size());
        return r22;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return this.a;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return this.g;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(com.obric.assistant.cocreationreview.v0 r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        boolean r0 = this.h.add(r4);
        int r1 = s3.a;
        s3.b("memory.provider.observe", "module=" + this.g.getRaw() + ", added=" + r0 + ", listeners=" + this.h.size());
        if (r0 == true) goto L5;
        return;
    L5:
        if (this.n <= 0) goto L9;
        r4.a(g());
        return;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(g5 r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.l = r2;
        i(r2);
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r15) {
        Intrinsics.checkNotNullParameter(r15, "request");
        int r0 = s3.a;
        s3.b("memory.submit", "receive module=" + this.g.getRaw() + ", requestId=" + r15.a + ", recordId=" + r15.b + ", vote=" + r15.d.getRaw() + ", reasonCount=" + r15.e.size() + ", commentLength=" + r15.f.length() + ", payloadHash=" + r15.g.hashCode());
        if (r15.c != this.g) goto L5;
        Iterator<T> r1 = this.j.iterator();
    L7:
        String r5 = null;
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((com.obric.assistant.cocreationreview.a) r3).a(), r15.b) == false) goto L7;
    L13:
        com.obric.assistant.cocreationreview.a r4 = (com.obric.assistant.cocreationreview.a) r3;
        if (r4 == null) goto L16;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        hda.b r6 = this.c;     // Catch: Throwable -> L24
        String r7 = r15.b;     // Catch: Throwable -> L24
        MemoryDataReviewModuleKey r8 = this.b;     // Catch: Throwable -> L24
        Vote r9 = r15.d;     // Catch: Throwable -> L24
        Set<String> r10 = r15.e;     // Catch: Throwable -> L24
        String r11 = r15.f;     // Catch: Throwable -> L24
        String r12 = r15.g;     // Catch: Throwable -> L24
        if ((!StringsKt.isBlank(r12)) == false) goto L20;
        r5 = r12;
    L20:
        if (r5 != null) goto L22;
        r5 = this.d.a(r4);     // Catch: Throwable -> L24
    L22:
        Object r13 = Result.constructor-impl(r6.a(new w0(r7, r8, r9, r10, r11, r5, this.d.b(r4))));     // Catch: Throwable -> L24
    L26:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        String r16 = "记忆反馈提交失败";
        if (r14 != null) goto L41;
        x0 r17 = (x0) r13;
        if (r17.a == false) goto L33;
        g5 r18 = this.l;
        if (r18 == null) goto L33;
        i(r18);
    L33:
        boolean r19 = r17.a;
        String r20 = r17.b;
        if (StringsKt.isBlank(r20) == false) goto L40;
        if (r17.a == false) goto L38;
        r16 = "反馈已回流到" + this.a.b;
    L38:
        r20 = r16;
    L40:
        return new t5(r19, r20);
    L41:
        int r21 = s3.a;
        s3.c("memory.submit", "failed module=" + this.g.getRaw() + ", recordId=" + r15.b + ", error=" + r14.getMessage());
        String r22 = r14.getMessage();
        if (r22 == null) goto L46;
        r16 = r22;
    L46:
        return new t5(false, r16);
    L24:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L16:
        return new t5(false, "反馈数据不存在");
    L12:
        r3 = null;
        goto L13
    L5:
        return new t5(false, "业务方不匹配");
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(com.obric.assistant.cocreationreview.v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.h.remove(r3);
        int r4 = s3.a;
        s3.b("memory.provider.observe", "remove module=" + this.g.getRaw() + ", listeners=" + this.h.size());
        if (this.h.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.m == true) goto L13;
        this.m = true;
        this.l = null;
        this.i.incrementAndGet();
        Function0<Unit> r5 = this.f;
        if (r5 == null) goto L10;
        r5.invoke();
    L10:
        s3.b("memory.provider.observe", "closed module=" + this.g.getRaw());
        return;
    }

    public final b<R> h(g5 r32) {
        h5 r1 = g5.a(r32);
        long r2 = r1.a;
        long r4 = r1.b;
        Calendar r6 = Calendar.getInstance();
        r6.setTimeInMillis(r2);
        r6.add(6, 1);
        r6.set(11, 0);
        r6.set(12, 0);
        r6.set(13, 0);
        r6.set(14, 0);
        long r5 = RangesKt.coerceAtLeast(r6.getTimeInMillis(), r4);
        ArrayList r3 = new ArrayList();
        LinkedHashMap r7 = new LinkedHashMap();
        String r9 = null;
        int r17 = 0;
        int r18 = 0;
    L3:
        com.obric.assistant.cocreationreview.modules.memory.c r8 = this.c.b(new n0(this.b, r9, r1.a, r5));
        String r10 = r8.i;
        if (r10 != null) goto L5;
        r3.addAll(CollectionsKt.plus(r8.d, r8.e));
        Iterator<Map.Entry<String, y>> r11 = r8.f.entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        Map.Entry<String, y> r12 = r11.next();
        String r13 = r12.getKey();
        y r14 = r12.getValue();
        Vote r15 = r14.b;
        Set<String> r16 = r14.c;
        String r19 = r14.d;
        h5 r110 = r1;
        long r29 = r5;
        if (r14.a != MemoryReviewFeedbackState.SUBMITTED) goto L16;
        boolean r24 = true;
    L17:
        r7.put(r13, new a5(r13, r15, r16, r19, r24, r14.g, null, 192));
        r1 = r110;
        r5 = r29;
        goto L12
    L16:
        r24 = false;
        goto L17
    L18:
        h5 r111 = r1;
        long r210 = r5;
        Iterator<T> r20 = r8.e.iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        String r21 = ((q0) r20.next()).a;
        r7.putIfAbsent(r21, new a5(r21, null, null, null, true, 0, null, 238));
        goto L20
    L22:
        int r22 = r18 + CollectionsKt.plus(r8.d, r8.e).size();
        int r23 = r17 + 1;
        boolean r25 = r8.h;
        if (r25 == false) goto L25;
        r9 = r8.g;
    L27:
        if (r25 == false) goto L36;
        if (r9 != null) goto L30;
    L33:
        boolean r26 = true;
    L34:
        if (r26 == false) goto L36;
        int r27 = s3.a;
        s3.c("memory.provider.refresh", "stop module=" + this.g.getRaw() + ", reason=missing_cursor, pages=" + r23 + ", records=" + r22);
    L43:
        int r28 = s3.a;
        s3.b("memory.provider.refresh", "loaded module=" + this.g.getRaw() + ", pages=" + r23 + ", records=" + r3.size() + ", feedback=" + r7.size());
        r0<R> r30 = this.d;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r33 = r3.iterator();
    L45:
        if (r33.hasNext() == false) goto L48;
        r31.add(r30.c((q0) r33.next()));
        goto L45
    L48:
        return new b(r31, r7);
    L30:
        if (StringsKt.isBlank(r9) == true) goto L33;
        r26 = false;
    L36:
        if (r9 != null) goto L38;
    L41:
        boolean r34 = true;
    L42:
        if (r34 == true) goto L43;
        r18 = r22;
        r17 = r23;
        r1 = r111;
        r5 = r210;
        goto L3
    L38:
        if (StringsKt.isBlank(r9) == true) goto L41;
        r34 = false;
        goto L42
    L25:
        r9 = null;
        goto L27
    L5:
        int r35 = s3.a;
        StringBuilder r36 = new StringBuilder("pageError module=");
        r36.append(this.g.getRaw());
        r36.append(", cursor=");
        if (r9 != null) goto L8;
        r9 = "first";
    L8:
        r36.append(r9);
        r36.append(", error=");
        r36.append(r10);
        s3.c("memory.provider.refresh", r36.toString());
        return new b(CollectionsKt.emptyList(), MapsKt.emptyMap());
    }

    public final void i(final g5 r5) {
        if (this.m == false) goto L6;
        int r0 = s3.a;
        s3.c("memory.provider.refresh", "skip_closed module=" + this.g.getRaw() + ", reason=" + r5.b);
        return;
    L6:
        final long r1 = this.i.incrementAndGet();
        this.e.execute(new l0(this, r5, r1));
    }

    public m0(l5 r4, MemoryDataReviewModuleKey r5, com.obric.assistant.cocreationreview.modules.memory.a r6, r0 r7) {
        ExecutorService r0 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MemoryReviewLabelingProvider"));
        Function0<Unit> r2 = null;
        if ((r0 instanceof ExecutorService) == false) goto L5;
        final ExecutorService r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r2 = new k0(r1);
    L8:
        Intrinsics.checkNotNullParameter(r4, "moduleMeta");
        Intrinsics.checkNotNullParameter(r5, "memoryDataModule");
        Intrinsics.checkNotNullParameter(r6, "bridge");
        Intrinsics.checkNotNullParameter(r7, "mapper");
        Intrinsics.checkNotNullParameter(r0, "loadExecutor");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r0;
        this.f = r2;
        this.g = r4.a;
        this.h = new LinkedHashSet();
        this.i = new AtomicLong(0);
        this.j = CollectionsKt.emptyList();
        this.k = MapsKt.emptyMap();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
