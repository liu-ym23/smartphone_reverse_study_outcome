package com.larus.trace.tracespan.span;

import com.larus.platform.model.upload.ResourceUploadError;
import com.tencent.open.log.TraceLevel;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.context.g;
import itc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jtc.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;
import yx9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class SpanWrapImpl implements b {
    public final i a;
    public final long b;
    public final CoroutineScope c;
    public final Job d;
    public volatile b e;
    public final List<b> f;
    public volatile String g;
    public volatile String h;

    /* JADX INFO: renamed from: com.larus.trace.tracespan.span.SpanWrapImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.trace.tracespan.span.SpanWrapImpl$1", f = "SpanWrapImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpanWrapImpl this$0;

        public AnonymousClass1(SpanWrapImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            if (this.this$0.hasEnd() == true) goto L14;
            c.c.w("span id:" + this.this$0.a() + " timeout canceled");
            this.this$0.cancel(false);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.this$0.b;
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.trace.tracespan.span.SpanWrapImpl$cancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.trace.tracespan.span.SpanWrapImpl$cancel$1", f = "SpanWrapImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $needReport;
        int label;
        final /* synthetic */ SpanWrapImpl this$0;

        public C01531(SpanWrapImpl r1, boolean r2, Continuation<? super C01531> r3) {
            this.this$0 = r1;
            this.$needReport = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01531(this.this$0, this.$needReport, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r7);
            SpanWrapImpl r8 = this.this$0;
            List<b> r0 = r8.f;
            boolean r1 = this.$needReport;
            monitor-enter(r0);
            List<b> r2 = r8.k();     // Catch: Throwable -> L23
            ((ArrayList) r8.f).clear();     // Catch: Throwable -> L23
            Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L23
        L7:
            boolean r4 = false;
            if (r3.hasNext() == false) goto L14;
            b r5 = (b) r3.next();     // Catch: Throwable -> L23
            if (r1 == false) goto L12;
            r4 = true;
        L12:
            r5.cancel(r4);     // Catch: Throwable -> L23
            goto L7
        L14:
            if (r8.hasEnd() == true) goto L20;
            r8.d("trace_status", Boxing.boxInt(1));     // Catch: Throwable -> L23
            r8.d("error_code", Boxing.boxInt(-10000));     // Catch: Throwable -> L23
            r8.d("error_msg", "span cancel");     // Catch: Throwable -> L23
            if (r1 == false) goto L19;
            r4 = true;
        L19:
            r8.j(ResourceUploadError.CANCELED, r4);     // Catch: Throwable -> L23
        L20:
            monitor-exit(r0);
            return Unit.INSTANCE;
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String a() {
        return this.a.b().c;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String f() {
        return "4-" + getTraceId() + '-' + a() + "-1";
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTraceId() {
        return this.a.b().b;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final boolean hasEnd() {
        if (Intrinsics.areEqual(this.g, "end") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.g, ResourceUploadError.CANCELED) == true) goto L8;
        return false;
    }

    public final List<b> k() {
        List<b> r0 = this.f;
        monitor-enter(r0);
        List<b> r1 = CollectionsKt.toMutableList(this.f);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b getParent() {
        return this.e;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final String getTag() {
        return this.h;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        xx9.a.a(this).b(r2);
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void c(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        Intrinsics.checkNotNull(r1);
        d(r1, r4.get(r1));
        goto L4
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void cancel(boolean r7) {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new C01531(this, r7, null), 2, null);
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void e(b r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        List<b> r0 = this.f;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f).remove(r3) == true) goto L8;
    L12:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L8:
        if (((ArrayList) this.f).isEmpty() == false) goto L12;
        if (Intrinsics.areEqual(this.g, "waiting") == false) goto L12;
        g(null, null);     // Catch: Throwable -> L15
        goto L12
    }

    public final void h(SpanWrapImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "child");
        List<b> r2 = this.f;
        monitor-enter(r2);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasEnd() == false) goto L10;
        c.c.w("add child error, parent id:" + a() + " has end");     // Catch: Throwable -> L20
        monitor-exit(r2);
        return;
    L10:
        if (r5.hasEnd() == false) goto L15;
        c.c.w("add child error, child id:" + r5.a() + " has end");     // Catch: Throwable -> L20
        monitor-exit(r2);
        return;
    L15:
        if (((ArrayList) this.f).contains(r5) == true) goto L17;
        r5.i(this);     // Catch: Throwable -> L20
        ((ArrayList) this.f).add(r5);     // Catch: Throwable -> L20
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r2);
    }

    public final void i(b r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (this.e == null) goto L6;
        c.c.e("span id:" + a() + " has bind parent");
        return;
    L6:
        this.e = r3;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void setTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.h = r2;
    }

    public SpanWrapImpl(i r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "realSpan");
        this.a = r9;
        this.b = r10;
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt.Job$default(null, 1, null)));
        this.c = r2;
        this.f = new ArrayList();
        this.g = "starting";
        this.h = "";
        if (r10 <= 0) goto L6;
        this.d = BuildersKt.launch$default(r2, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    @Override // com.larus.trace.tracespan.span.b
    public final b d(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        if ((r5 instanceof Integer) == false) goto L6;
        this.a.a(e.a(r4), Long.valueOf(((Number) r5).intValue()));
    L21:
        return this;
    L6:
        if ((r5 instanceof Boolean) == false) goto L9;
        this.a.a(io.opentelemetry.api.internal.i.a(r4, AttributeType.BOOLEAN), r5);
        goto L21
    L9:
        if ((r5 instanceof Long) == false) goto L12;
        this.a.a(e.a(r4), r5);
        goto L21
    L12:
        if ((r5 instanceof Float) == false) goto L15;
        this.a.a(io.opentelemetry.api.internal.i.a(r4, AttributeType.DOUBLE), Double.valueOf(((Number) r5).floatValue()));
        goto L21
    L15:
        if ((r5 instanceof Double) == false) goto L18;
        this.a.a(io.opentelemetry.api.internal.i.a(r4, AttributeType.DOUBLE), r5);
        goto L21
    L18:
        if ((r5 instanceof String) == false) goto L20;
        this.a.a(e.c(r4), r5);
        goto L21
    L20:
        c.c.e("span attribute type not support");
        Unit r6 = Unit.INSTANCE;
        goto L21
    }

    @Override // com.larus.trace.tracespan.span.b
    public final void g(Integer r4, String r5) {
        List<b> r0 = this.f;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (hasEnd() == true) goto L17;
        if (r4 != null) goto L9;
        d("trace_status", 0);     // Catch: Throwable -> L20
    L14:
        if ((!k().isEmpty()) == false) goto L16;
        this.g = "waiting";     // Catch: Throwable -> L20
        goto L17
    L16:
        j("end", true);     // Catch: Throwable -> L20
        goto L17
    L9:
        d("trace_status", 2);     // Catch: Throwable -> L20
        d("error_code", r4);     // Catch: Throwable -> L20
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        d("error_msg", r5);     // Catch: Throwable -> L20
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
    }

    public final void j(String r4, boolean r5) {
        Job r0 = this.d;
        zx9.a r1 = null;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L6:
        if (hasEnd() == false) goto L8;
        return;
    L8:
        this.g = r4;
        if (r5 == false) goto L11;
        this.a.end();
    L11:
        io.opentelemetry.context.c r6 = g.b;
        if ((r6 instanceof zx9.a) == false) goto L14;
        r1 = (zx9.a) r6;
    L14:
        if (r1 == null) goto L16;
        r1.b(this.a.b().b, this.a.b().c);
    L16:
        b r7 = this.e;
        if (r7 == null) goto L20;
        r7.e(this);
        return;
    }
}
