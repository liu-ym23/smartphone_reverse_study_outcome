package com.obric.assistant.cocreationreview.modules.searchqa;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.CocreationLabelingServerClient;
import com.obric.assistant.cocreationreview.CocreationUserFeedbackAttachment;
import com.obric.assistant.cocreationreview.CocreationUserFeedbackRequest;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.f5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.i0;
import com.obric.assistant.cocreationreview.i5;
import com.obric.assistant.cocreationreview.j;
import com.obric.assistant.cocreationreview.j0;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.cocreationreview.s5;
import com.obric.assistant.cocreationreview.t5;
import com.obric.assistant.cocreationreview.v0;
import dm9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements e5 {
    public final q a;
    public final l5 b;
    public final ModuleKey c;
    public final CocreationLabelingServerClient d;
    public List<c0> e;
    public final LinkedHashSet<f5> f;
    public final LinkedHashMap<String, a5> g;
    public n h;
    public int i;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    public final i5 g() {
        this.i++;
        List<c0> r0 = this.e;
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((c0) r2.next()).a);
        goto L4
    L6:
        LinkedHashMap<String, a5> r3 = this.g;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Map.Entry<String, a5>> r5 = r3.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Map.Entry<String, a5> r6 = r5.next();
        if (r1.contains(r6.getKey()) == false) goto L8;
        r4.put(r6.getKey(), r6.getValue());
        goto L8
    L12:
        Map r7 = MapsKt.toMap(r4);
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r7.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (((a5) r10.getValue()).e == false) goto L14;
        r8.put(r10.getKey(), r10.getValue());
        goto L14
    L18:
        Set r11 = r8.keySet();
        l5 r12 = this.b;
        List<c0> r13 = this.e;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L24;
        Object r16 = r15.next();
        if (r11.contains(((c0) r16).a) == true) goto L20;
        r14.add(r16);
        goto L20
    L24:
        List<c0> r17 = this.e;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L26:
        if (r19.hasNext() == false) goto L30;
        Object r20 = r19.next();
        if (r11.contains(((c0) r20).a) == false) goto L26;
        r18.add(r20);
        goto L26
    L30:
        i5 r21 = new i5(r12, r14, r18, r7);
        int r22 = s3.a;
        s3.a("provider.snapshot", "build module=" + this.c.getRaw() + ", provider=" + m.class.getSimpleName() + ", version=" + this.i + ", pending=" + r21.b.size() + ", completed=" + r21.c.size() + ", feedback=" + r21.d.size());
        return r21;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return this.b;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return this.c;
    }

    public m(q r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.a = r2;
        l5 r3 = h.a;
        this.b = r3;
        this.c = r3.a;
        this.d = new CocreationLabelingServerClient();
        this.e = CollectionsKt.emptyList();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.obric.assistant.cocreationreview.modules.searchqa.l, java.lang.Object] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        boolean r0 = this.f.add(r9);
        int r1 = s3.a;
        s3.b("provider.observe", "module=" + this.c.getRaw() + ", provider=" + m.class.getSimpleName() + ", added=" + r0 + ", listeners=" + this.f.size());
        if (this.h != null) goto L17;
        q r2 = this.a;
        ?? r3 = new l(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        LinkedHashSet<Function1<List<c0>, Unit>> r4 = r2.c;
        monitor-enter(r4);
        r2.c.add((Function1<List<c0>, Unit>) r3);     // Catch: Throwable -> L22
        int r5 = r2.c.size();     // Catch: Throwable -> L22
        monitor-exit(r4);
        r2.a();
        StringBuilder r6 = new StringBuilder("observe listeners=");
        r6.append(r5);
        r6.append(", hasSearchQaDb=");
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
        s3.b("search_qa.repository.observe", r6.toString());
        this.h = new n(r2, r3);
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
        if (this.i <= 0) goto L28;
        i5 r10 = g();
        s3.b("provider.notify", "initial module=" + this.c.getRaw() + ", pending=" + r10.b.size() + ", completed=" + r10.c.size());
        r9.a(r10);
        return;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(g5 r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        q r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "request");
        r1.f = r5;
        i(this.a.c(r5));
        h5 r0 = g5.a(r5);
        int r2 = s3.a;
        s3.b("provider.observe", "updateRequest module=" + this.c.getRaw() + ", provider=" + m.class.getSimpleName() + ", reason=" + r5.b + ", earliest=" + r0.a + ", latest=" + r0.b + ", records=" + this.e.size() + ", listeners=" + this.f.size());
        h(g());
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r25) {
        Intrinsics.checkNotNullParameter(r25, "request");
        int r0 = s3.a;
        s3.b("submit.annotation", "receive module=" + this.c.getRaw() + ", requestId=" + r25.a + ", recordId=" + r25.b + ", vote=" + r25.d.getRaw() + ", reasonCount=" + r25.e.size() + ", commentLength=" + r25.f.length() + ", attachmentCount=" + r25.h.size() + ", payloadHash=" + r25.g.hashCode());
        if (r25.c == this.c) goto L6;
        s3.c("submit.annotation", "reject module=" + this.c.getRaw() + ", requestBusiness=" + r25.c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r1 = this.e.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r8 = r1.next();
        if (Intrinsics.areEqual(((c0) r8).a, r25.b) == false) goto L8;
    L13:
        c0 r9 = (c0) r8;
        if (r9 != null) goto L17;
        int r2 = s3.a;
        s3.c("submit.annotation", "reject module=" + this.c.getRaw() + ", recordId=" + r25.b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        String r13 = UUID.randomUUID().toString();
        List r16 = CollectionsKt.toList(r25.e);
        int r5 = w.a[r25.d.ordinal()];
        if (r5 == 1) goto L24;
        int r10 = 2;
        if (r5 != 2) goto L23;
    L25:
        Integer r17 = Integer.valueOf(r10);
        String r6 = r25.f;
        String r11 = r9.k;
        List<CocreationUserFeedbackAttachment> r12 = r25.h;
        Gson r14 = j0.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if ((!r12.isEmpty()) == true) goto L29;
        r12 = null;
    L29:
        if (r12 == null) goto L31;
        String r20 = GsonProtectorUtils.toJson(j0.a, r12);
    L32:
        CocreationUserFeedbackRequest r3 = new CocreationUserFeedbackRequest(r13, "label_app", 3, r16, r17, r6, r11, r20, null, 256, null);
        int r7 = s3.a;
        StringBuilder r15 = new StringBuilder("start recordId=");
        r15.append(r9.a);
        r15.append(", requestId=");
        r15.append(r25.a);
        r15.append(", module=");
        r15.append(r3.getModule());
        r15.append(", feedbackType=");
        r15.append(r3.getFeedbackType());
        r15.append(", tagCount=");
        List<String> r18 = r3.getTags();
        if (r18 != null) goto L35;
        r18 = CollectionsKt.emptyList();
    L35:
        r15.append(r18.size());
        r15.append(", contentLength=");
        String r19 = r3.getContent();
        if (r19 != null) goto L38;
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L38:
        r15.append(r19.length());
        r15.append(", attachmentCount=");
        r15.append(r25.h.size());
        r15.append(", uniqId=");
        r15.append(r3.getUniqId());
        r15.append(", logId=");
        r15.append(r3.getLogId());
        s3.b("search_qa.feedback.submit", r15.toString());
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L41
        Object r4 = Result.constructor-impl((a) BuildersKt.runBlocking$default(null, new SearchQaLabelingProvider$submitUserFeedback$1$1(this, r3, null), 1, null));     // Catch: Throwable -> L41
    L44:
        if (Result.isSuccess-impl(r4) == false) goto L46;
        int r22 = s3.a;
        s3.b("search_qa.feedback.submit", "result recordId=" + r9.a + ", requestId=" + r25.a + ", response=" + ((a) r4));
    L46:
        Throwable r23 = Result.exceptionOrNull-impl(r4);
        if (r23 == null) goto L49;
        int r24 = s3.a;
        s3.c("search_qa.feedback.submit", "failed recordId=" + r9.a + ", requestId=" + r25.a + ", error=" + r23.getClass().getSimpleName() + ':' + r23.getMessage());
    L49:
        q r26 = this.a;
        r26.getClass();
        Intrinsics.checkNotNullParameter(r25, "request");
        a5 r27 = i0.c(r25);
        j r28 = r26.b;
        if (r28 == null) goto L52;
        r28.b(r27);
    L53:
        this.g.put(r25.b, r27);
        int r29 = s3.a;
        s3.b("search_qa.provider", "submitAnnotation saved recordId=" + r9.a + ", requestId=" + r25.a + ", feedbackRecordId=" + r27.a);
        h(g());
        return i0.a(this.b);
    L52:
        int r30 = s3.a;
        s3.c("search_qa.repository", "saveFeedback skipped, reason=context_unavailable, recordId=" + r27.a);
    L41:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L31:
        r20 = null;
        goto L32
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r10 = 1;
        goto L25
    L12:
        r8 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f.remove(r2);
        int r3 = s3.a;
        s3.b("provider.observe", "remove module=" + this.c.getRaw() + ", listeners=" + this.f.size());
        if (this.f.isEmpty() == false) goto L9;
        n r4 = this.h;
        if (r4 == null) goto L7;
        r4.invoke();
    L7:
        this.h = null;
        return;
    }

    public final void h(i5 r4) {
        List r0 = CollectionsKt.toList(this.f);
        int r1 = s3.a;
        s3.b("provider.notify", "module=" + this.c.getRaw() + ", listeners=" + r0.size() + ", pending=" + r4.b.size() + ", completed=" + r4.c.size());
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((f5) r2.next()).a(r4);
        goto L4
    }

    public final void i(List<c0> r4) {
        this.e = r4;
        this.g.clear();
        List<c0> r5 = this.e;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        a5 r1 = ((c0) r6.next()).l;
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Iterator r7 = r0.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        a5 r2 = (a5) r7.next();
        this.g.put(r2.a, r2);
        goto L10
    }
}
