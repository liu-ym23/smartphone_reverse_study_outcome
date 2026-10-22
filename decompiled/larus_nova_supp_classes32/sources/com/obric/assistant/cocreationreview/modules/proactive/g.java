package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.ModuleKey;
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
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements e5 {
    public final ProactiveAgentRepository a;
    public List<q> b;
    public final LinkedHashSet<f5> c;
    public g5 d;
    public int e;
    public final w f;
    public v g;

    @Override // com.obric.assistant.cocreationreview.e5
    public final void a() {
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final l5 b() {
        return d.a.b();
    }

    public final i5 h() {
        this.e++;
        List<q> r0 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        q r3 = (q) r2.next();
        a5 r4 = r3.u;
        if (r4 == null) goto L8;
        Pair r5 = TuplesKt.to(r3.a, r4);
    L9:
        if (r5 == null) goto L4;
        r1.add(r5);
        goto L4
    L8:
        r5 = null;
        goto L9
    L11:
        Map r6 = MapsKt.toMap(r1);
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r6.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r9 = (Map.Entry) r8.next();
        if (((a5) r9.getValue()).e == false) goto L13;
        r7.put(r9.getKey(), r9.getValue());
        goto L13
    L17:
        Set r10 = r7.keySet();
        l5 r11 = b();
        List<q> r12 = this.b;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if (r10.contains(((q) r15).a) == true) goto L19;
        r13.add(r15);
        goto L19
    L23:
        List<q> r16 = this.b;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        if (r10.contains(((q) r19).a) == false) goto L25;
        r17.add(r19);
        goto L25
    L29:
        i5 r20 = new i5(r11, r13, r17, r6);
        int r21 = s3.a;
        s3.a("provider.snapshot", "build module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", version=" + this.e + ", pending=" + r20.b.size() + ", completed=" + r20.c.size() + ", feedback=" + r20.d.size());
        return r20;
    }

    public final int i() {
        LinkedHashSet<f5> r0 = this.c;
        monitor-enter(r0);
        int r1 = this.c.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final ModuleKey getBusinessId() {
        return b().a;
    }

    public g(ProactiveAgentRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
        this.c = new LinkedHashSet();
        int r3 = g5.c;
        this.d = g5.a.a("provider_init");
        this.f = new w();
        int r4 = v.d;
        this.g = v.a.a();
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void c(v0 r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        LinkedHashSet<f5> r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.c.add(r5);     // Catch: Throwable -> L12
        monitor-exit(r0);
        int r2 = s3.a;
        s3.b("provider.observe", "module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", added=" + r1 + ", listeners=" + i());
        if (r1 == true) goto L9;
        return;
    L9:
        if (this.e <= 0) goto L18;
        i5 r3 = h();
        s3.b("provider.notify", "initial module=" + getBusinessId().getRaw() + ", pending=" + r3.b.size() + ", completed=" + r3.c.size());
        r5.a(r3);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.obric.assistant.cocreationreview.modules.proactive.f, java.lang.Object] */
    @Override // com.obric.assistant.cocreationreview.e5
    public final void d(final g5 r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        this.d = r10;
        w r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "request");
        final x r0 = new x(r1.a.incrementAndGet(), r10);
        h5 r2 = g5.a(r10);
        boolean r3 = false;
        if (i() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        j("update_without_listener");
        int r5 = s3.a;
        s3.b("provider.observe", "skipLoadWithoutListener module=" + getBusinessId().getRaw() + ", reason=" + r10.b + ", sequence=" + r0.a);
        return;
    L10:
        int r6 = s3.a;
        s3.b("provider.observe", "updateRequest module=" + getBusinessId().getRaw() + ", provider=" + g.class.getSimpleName() + ", reason=" + r10.b + ", earliest=" + r2.a + ", latest=" + r2.b + ", sequence=" + r0.a + ", listeners=" + i());
        if (this.g.c.get() == false) goto L13;
        int r7 = v.d;
        this.g = v.a.a();
    L13:
        final v r8 = this.g;
        final ?? r9 = new f(this, r0, r10);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "task");
        if (r8.c.get() == false) goto L27;
    L24:
        if (r3 == true) goto L29;
        int r11 = s3.a;
        s3.c("provider.observe", "loadSubmitRejected module=" + getBusinessId().getRaw() + ", reason=" + r10.b + ", sequence=" + r0.a);
        return;
    L29:
        return;
    L27:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L18
        r8.a.invoke(new r(r8, r9));     // Catch: Throwable -> L18
        Object r13 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L18
    L20:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r13) == false) goto L23;
        r13 = r14;
    L23:
        r3 = ((Boolean) r13).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final t5 e(s5 r15) {
        Intrinsics.checkNotNullParameter(r15, "request");
        int r1 = s3.a;
        s3.b("submit.annotation", "receive module=" + getBusinessId().getRaw() + ", requestId=" + r15.a + ", recordId=" + r15.b + ", vote=" + r15.d.getRaw() + ", reasonCount=" + r15.e.size() + ", commentLength=" + r15.f.length() + ", payloadHash=" + r15.g.hashCode());
        if (r15.c == getBusinessId()) goto L6;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", requestBusiness=" + r15.c.getRaw() + ", reason=business_mismatch");
        return new t5(false, "业务方不匹配");
    L6:
        Iterator<T> r2 = this.b.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        if (Intrinsics.areEqual(((q) r5).a, r15.b) == false) goto L8;
    L13:
        q r6 = (q) r5;
        if (r6 != null) goto L17;
        int r0 = s3.a;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", recordId=" + r15.b + ", reason=record_not_found");
        return new t5(false, "反馈数据不存在");
    L17:
        g5 r3 = this.d;
        w r9 = this.f;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "request");
        x r10 = new x(r9.a.incrementAndGet(), r3);
        int r11 = s3.a;
        s3.b("submit.annotation", "invalidateObserveLoad module=" + getBusinessId().getRaw() + ", recordId=" + r15.b + ", sequence=" + r10.a);
        ProactiveAgentRepository r12 = this.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r6, "record");
        Intrinsics.checkNotNullParameter(r15, "request");
        Context r4 = r12.a;
        if (r4 != null) goto L20;
        boolean r7 = false;
    L21:
        if (r7 == true) goto L24;
        s3.c("submit.annotation", "reject module=" + getBusinessId().getRaw() + ", recordId=" + r15.b + ", reason=remote_submit_failed");
        return new t5(false, "反馈写入失败，请稍后重试");
    L24:
        n r8 = this.a.d(r3);
        s3.b("submit.annotation", "accepted module=" + getBusinessId().getRaw() + ", recordId=" + r15.b);
        if (this.f.a(r10, this.d) == false) goto L27;
        g(r3, r8, "submit_refresh");
    L29:
        return i0.a(b());
    L27:
        s3.b("submit.annotation", "skipStaleRefresh module=" + getBusinessId().getRaw() + ", recordId=" + r15.b + ", sequence=" + r10.a + ", submitReason=" + r3.b + ", activeReason=" + this.d.b);
        goto L29
    L20:
        r7 = ((Boolean) BuildersKt.runBlocking$default(null, new ProactiveAgentRepository$submitAnnotation$submitted$1(r4, r6, r15, null), 1, null)).booleanValue();
        s3.b("proactive_agent.repository", "submitAnnotation recordId=" + r6.a + ", recommendId=" + r6.c + ", inspirationId=" + r6.d + ", vote=" + r15.d.getRaw() + ", submitted=" + r7);
        goto L21
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.obric.assistant.cocreationreview.e5
    public final void f(v0 r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        LinkedHashSet<f5> r0 = this.c;
        monitor-enter(r0);
        this.c.remove(r4);     // Catch: Throwable -> L10
        int r5 = this.c.size();     // Catch: Throwable -> L10
        monitor-exit(r0);
        if (r5 != 0) goto L8;
        j("remove_last_observer");
    L8:
        int r1 = s3.a;
        s3.b("provider.observe", "remove module=" + getBusinessId().getRaw() + ", listeners=" + r5);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void j(String r7) {
        long r0 = this.f.a.incrementAndGet();
        v r2 = this.g;
        if (r2.c.compareAndSet(false, true) == false) goto L5;
        r2.b.invoke();
    L5:
        int r3 = s3.a;
        s3.b("provider.observe", "releaseLoader module=" + getBusinessId().getRaw() + ", reason=" + r7 + ", sequence=" + r0);
    }

    public final void g(g5 r5, n r6, String r7) {
        if (i() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        int r8 = s3.a;
        s3.b("provider.observe", "skipApplyWithoutListener module=" + getBusinessId().getRaw() + ", source=" + r7 + ", reason=" + r5.b);
        return;
    L9:
        ProactiveLabelingFeedbackConfigDto r1 = r6.b;
        l5 r2 = e.a;
        i.a.update(r1);
        this.b = r6.a;
        h5 r9 = g5.a(r5);
        int r3 = s3.a;
        s3.b("provider.observe", "applySnapshot module=" + getBusinessId().getRaw() + ", source=" + r7 + ", reason=" + r5.b + ", earliest=" + r9.a + ", latest=" + r9.b + ", records=" + this.b.size() + ", listeners=" + i());
        i5 r10 = h();
        LinkedHashSet<f5> r11 = this.c;
        monitor-enter(r11);
        List r12 = CollectionsKt.toList(this.c);     // Catch: Throwable -> L18
        monitor-exit(r11);
        s3.b("provider.notify", "module=" + getBusinessId().getRaw() + ", listeners=" + r12.size() + ", pending=" + r10.b.size() + ", completed=" + r10.c.size());
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L17;
        ((f5) r13.next()).a(r10);
        goto L15
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }
}
