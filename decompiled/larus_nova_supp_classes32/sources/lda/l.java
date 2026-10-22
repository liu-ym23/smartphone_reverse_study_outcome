package lda;

import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.f5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.i0;
import com.obric.assistant.cocreationreview.i5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.cocreationreview.s5;
import com.obric.assistant.cocreationreview.t5;
import com.obric.assistant.cocreationreview.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements e5 {
    public final q a;
    public final l5 b;
    public final ModuleKey c;
    public final LinkedHashSet<f5> d;
    public List<b0> e;
    public g5 f;
    public n g;
    public int h;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    public final i5 g() {
        this.h++;
        List<b0> r0 = this.e;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        a5 r3 = ((b0) r2.next()).l;
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        r4.put(((a5) r6).a, r6);
        goto L10
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r4.entrySet().iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r9 = (Map.Entry) r8.next();
        if (((a5) r9.getValue()).e == false) goto L14;
        r7.put(r9.getKey(), r9.getValue());
        goto L14
    L18:
        Set r10 = r7.keySet();
        l5 r11 = this.b;
        List<b0> r12 = this.e;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        Object r15 = r14.next();
        if (r10.contains(((b0) r15).a) == true) goto L20;
        r13.add(r15);
        goto L20
    L24:
        List<b0> r16 = this.e;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L26:
        if (r18.hasNext() == false) goto L30;
        Object r19 = r18.next();
        if (r10.contains(((b0) r19).a) == false) goto L26;
        r17.add(r19);
        goto L26
    L30:
        i5 r20 = new i5(r11, r13, r17, r4);
        int r21 = s3.a;
        s3.a("provider.snapshot", "build module=" + this.c.getRaw() + ", provider=" + l.class.getSimpleName() + ", version=" + this.h + ", pending=" + r20.b.size() + ", completed=" + r20.c.size() + ", feedback=" + r20.d.size());
        return r20;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return this.b;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return this.c;
    }

    public l(q r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.a = r2;
        l5 r3 = e.a;
        this.b = r3;
        this.c = r3.a;
        this.d = new LinkedHashSet();
        this.e = CollectionsKt.emptyList();
        int r4 = g5.c;
        this.f = g5.a.a("provider_init");
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, lda.k] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        boolean r0 = this.d.add(r9);
        int r1 = s3.a;
        s3.b("provider.observe", "module=" + this.c.getRaw() + ", provider=" + l.class.getSimpleName() + ", added=" + r0 + ", listeners=" + this.d.size());
        if (this.g != null) goto L17;
        q r2 = this.a;
        ?? r3 = new k(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        LinkedHashSet<Function1<u, Unit>> r4 = r2.c;
        monitor-enter(r4);
        r2.c.add((Function1<u, Unit>) r3);     // Catch: Throwable -> L22
        int r5 = r2.c.size();     // Catch: Throwable -> L22
        monitor-exit(r4);
        r2.a();
        StringBuilder r6 = new StringBuilder("observe listeners=");
        r6.append(r5);
        r6.append(", hasOmniDb=");
        boolean r7 = false;
        if (r2.a == null) goto L12;
        boolean r8 = true;
    L13:
        r6.append(r8);
        r6.append(", hasFeedbackDb=");
        if (r2.b == null) goto L16;
        r7 = true;
    L16:
        r6.append(r7);
        s3.b("omni.repository.observe", r6.toString());
        this.g = new n(r2, r3);
        goto L17
    L12:
        r8 = false;
    L22:
        th = move-exception;
        throw th;
    L17:
        if (r0 == true) goto L19;
        return;
    L19:
        if (this.h <= 0) goto L28;
        i5 r10 = g();
        s3.b("provider.notify", "initial module=" + this.c.getRaw() + ", pending=" + r10.b.size() + ", completed=" + r10.c.size());
        r9.a(r10);
        return;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(g5 r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.f = r5;
        q r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "request");
        r1.f = r5;
        h5 r0 = g5.a(r5);
        int r2 = s3.a;
        s3.b("provider.observe", "updateRequest module=" + this.c.getRaw() + ", provider=" + l.class.getSimpleName() + ", reason=" + r5.b + ", earliest=" + r0.a + ", latest=" + r0.b + ", listeners=" + this.d.size());
        StringBuilder r3 = new StringBuilder("observe_request_update:");
        r3.append(r5.b);
        i(new u(r3.toString(), this.a.c(r5)));
        h(g());
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r33) {
        Intrinsics.checkNotNullParameter(r33, "request");
        int r0 = s3.a;
        s3.b("submit.annotation", "receive module=" + this.c.getRaw() + ", requestId=" + r33.a + ", recordId=" + r33.b + ", vote=" + r33.d.getRaw() + ", reasonCount=" + r33.e.size() + ", commentLength=" + r33.f.length() + ", payloadHash=" + r33.g.hashCode());
        if (r33.c == this.c) goto L6;
        s3.c("submit.annotation", "reject module=" + this.c.getRaw() + ", requestBusiness=" + r33.c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r1 = this.e.iterator();
    L7:
        String r11 = null;
        if (r1.hasNext() == false) goto L12;
        Object r8 = r1.next();
        if (Intrinsics.areEqual(((b0) r8).a, r33.b) == false) goto L7;
    L13:
        b0 r9 = (b0) r8;
        if (r9 != null) goto L17;
        int r2 = s3.a;
        s3.c("submit.annotation", "reject module=" + this.c.getRaw() + ", recordId=" + r33.b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        String r3 = r9.c;
        if ((!StringsKt.isBlank(r3)) == false) goto L20;
        String r13 = r3;
    L22:
        if (r13 != null) goto L24;
        int r6 = s3.a;
        s3.c("omni.feedback.report", "skip recordId=" + r9.a + ", taskId=" + r9.c + ", requestId=" + r33.a + ", reason=task_id_blank");
        String r21 = ", recordId=";
        String r19 = "submit.annotation";
    L71:
        q r4 = this.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r33, "request");
        String r5 = r33.b;
        Vote r7 = r33.d;
        Set<String> r10 = r33.e;
        String r12 = r33.f;
        long r28 = System.currentTimeMillis();
        int r14 = m9a.b.a;
        a5 r15 = new a5(r5, r7, r10, r12, true, r28, m9a.b.a(r33.j), 64);
        com.obric.assistant.cocreationreview.j r16 = r4.b;
        if (r16 == null) goto L74;
        r16.b(r15);
    L75:
        int r17 = s3.a;
        s3.b("omni.provider", "submitAnnotation saved recordId=" + r9.a + ", taskId=" + r9.c + ", requestId=" + r33.a + ", feedbackRecordId=" + r15.a + ", refresh=database_observer");
        StringBuilder r18 = new StringBuilder("accepted module=");
        r18.append(this.c.getRaw());
        r18.append(r21);
        r18.append(r33.b);
        s3.b(r19, r18.toString());
        return i0.a(this.b);
    L74:
        int r20 = s3.a;
        s3.c("omni.repository", "saveFeedback skipped, reason=context_unavailable, recordId=" + r15.a);
        goto L75
    L24:
        List r110 = CollectionsKt.toList(r33.e);
        String r111 = r33.f;
        if ((!StringsKt.isBlank(r111)) == false) goto L27;
        r11 = r111;
    L27:
        if (r11 != null) goto L29;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L29:
        String r112 = r11;
        List r113 = CollectionsKt.toMutableList(r33.e);
        Vote r114 = r33.d;
        int[] r115 = s.a.a;
        int r116 = r115[r114.ordinal()];
        r19 = "submit.annotation";
        r21 = ", recordId=";
        if (r116 == 1) goto L35;
        if (r116 != 2) goto L34;
        String r22 = "dislike";
    L36:
        r113.add("__omni_feedback_type=".concat(r22));
        r113.add("__omni_feedback_source=label_app");
        int r23 = m9a.b.a;
        Integer r24 = r33.j;
        List r117 = m9a.b.b(r113);
        Integer r25 = m9a.b.a(r24);
        if (r25 == null) goto L40;
        List r26 = CollectionsKt.plus(r117, "__omni_feedback_amount=" + r25.intValue());
        if (r26 == null) goto L40;
    L41:
        int r27 = s3.a;
        StringBuilder r29 = new StringBuilder("start recordId=");
        r29.append(r9.a);
        r29.append(", taskId=");
        r29.append(r9.c);
        r29.append(", requestId=");
        r29.append(r33.a);
        r29.append(", vote=");
        r29.append(r33.d.getRaw());
        r29.append(", uploadType=");
        int r30 = r115[r33.d.ordinal()];
        if (r30 != 1) goto L44;
        String r31 = "like";
    L49:
        r29.append(r31);
        r29.append(", tagCount=");
        r29.append(r110.size());
        r29.append(", uploadTagCount=");
        r29.append(r26.size());
        r29.append(", contentLength=");
        r29.append(r112.length());
        r29.append(", amount=");
        Integer r32 = m9a.b.a(r33.j);
        if (r32 == null) goto L52;
        int r34 = r32.intValue();
    L53:
        r29.append(r34);
        s3.b("omni.feedback.report", r29.toString());
        IAgentAppIntentIDL r118 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r118 != null) goto L77;
        s3.c("omni.feedback.report", "skip recordId=" + r9.a + ", taskId=" + r9.c + ", requestId=" + r33.a + ", reason=ipc_null");
        goto L71
    L77:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L62
        String r36 = "omni.feedback.report";
        r118.drainOmniUploadImagesForFeedbackWithInfo(r13, r112, r26, null, true);     // Catch: Throwable -> L60
        Object r37 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L66:
        if (Result.isSuccess-impl(r37) == false) goto L68;
        Unit r38 = (Unit) r37;
        int r39 = s3.a;
        s3.b(r36, "dispatched recordId=" + r9.a + ", taskId=" + r9.c + ", requestId=" + r33.a);
    L68:
        Throwable r40 = Result.exceptionOrNull-impl(r37);
        if (r40 == null) goto L71;
        int r41 = s3.a;
        s3.c(r36, "failed recordId=" + r9.a + ", taskId=" + r9.c + ", requestId=" + r33.a + ", error=" + r40.getClass().getSimpleName() + ':' + r40.getMessage());
    L60:
        th = th;
    L64:
        Result.Companion r42 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L62:
        th = th;
        r36 = "omni.feedback.report";
        goto L64
    L52:
        r34 = -1;
        goto L53
    L44:
        if (r30 != 2) goto L47;
        r31 = "dislike";
        goto L49
    L47:
        throw new NoWhenBranchMatchedException();
    L40:
        r26 = r117;
        goto L41
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        r22 = "like";
        goto L36
    L20:
        r13 = null;
        goto L22
    L12:
        r8 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.remove(r2);
        int r3 = s3.a;
        s3.b("provider.observe", "remove module=" + this.c.getRaw() + ", listeners=" + this.d.size());
        if (this.d.isEmpty() == false) goto L9;
        n r4 = this.g;
        if (r4 == null) goto L7;
        r4.invoke();
    L7:
        this.g = null;
        return;
    }

    public final void h(i5 r4) {
        List r0 = CollectionsKt.toList(this.d);
        int r1 = s3.a;
        s3.b("provider.notify", "module=" + this.c.getRaw() + ", listeners=" + r0.size() + ", pending=" + r4.b.size() + ", completed=" + r4.c.size());
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((f5) r2.next()).a(r4);
        goto L4
    }

    public final void i(u r5) {
        int r0 = this.e.size();
        this.e = r5.b;
        int r1 = s3.a;
        StringBuilder r2 = new StringBuilder("refreshRecords reason=");
        r2.append(r5.a);
        r2.append(", previousCount=");
        r2.append(r0);
        r2.append(", currentCount=");
        r2.append(this.e.size());
        r2.append(", feedback=");
        List<b0> r6 = this.e;
        int r3 = 0;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r7 = r6.iterator();
        int r4 = 0;
    L9:
        if (r7.hasNext() == false) goto L18;
        if (((b0) r7.next()).l == null) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L9;
        r4 = r4 + 1;
        if (r4 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r8 = false;
        goto L14
    L18:
        r3 = r4;
    L19:
        r2.append(r3);
        r2.append(", earliest=");
        r2.append(g5.a(this.f).a);
        s3.b("omni.provider", r2.toString());
        return;
    L5:
        if (r6.isEmpty() == false) goto L7;
        goto L7
    }
}
