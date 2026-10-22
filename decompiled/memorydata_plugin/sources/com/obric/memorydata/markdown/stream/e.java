package com.obric.memorydata.markdown.stream;

import android.widget.TextView;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\u00020+H\u0082@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u001eH\u0016J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u001eH\u0016J\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020+H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\u001e0\u001e0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/memorydata/markdown/stream/GenericStreamCallback;", "Lcom/obric/memorydata/markdown/stream/StreamingCallback;", "textView", "Landroid/widget/TextView;", "strategy", "Lcom/obric/memorydata/markdown/stream/RenderStrategy;", "chunkSize", "", "typewriterDelayMs", "", "hook", "Lcom/obric/memorydata/markdown/stream/StreamingCallbackHook;", "externalStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "cursorConfig", "Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;", "isFirstRenderFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "typewriterJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "parentScope", "Lkotlinx/coroutines/CoroutineScope;", "isReleasedFlag", "firstRenderAll", "", "<init>", "(Landroid/widget/TextView;Lcom/obric/memorydata/markdown/stream/RenderStrategy;IJLcom/obric/memorydata/markdown/stream/StreamingCallbackHook;Lcom/larus/business/markdown/api/model/IMarkwonStruct;Lcom/obric/memorydata/markdown/stream/StreamingCursorConfig;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/atomic/AtomicBoolean;Z)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "fullContentRef", "kotlin.jvm.PlatformType", "displayIndexRef", "Ljava/util/concurrent/atomic/AtomicInteger;", "isCompleted", "lineCache", "Lcom/obric/memorydata/markdown/stream/IncrementalLineCache;", "blockTracker", "Lcom/obric/memorydata/markdown/stream/BlockStateTracker;", "lastRenderedText", "showCursor", "onStart", "", "runTypewriter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onChunk", "chunk", "onComplete", Params.CONTENT, "onError", "t", "", "onTimeout", "Companion", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f10017b;
    private final j c;
    private final int d;
    private final long e;
    private final o f;
    private final com.larus.business.markdown.api.model.e g;
    private final p h;
    private final AtomicBoolean i;
    private final AtomicReference<bx> j;
    private final al k;
    private final AtomicBoolean l;
    private final boolean m;
    private final kotlinx.coroutines.channels.i<String> n;
    private final AtomicReference<String> o;
    private final AtomicInteger p;
    private final AtomicBoolean q;
    private final f r;
    private final c s;
    private volatile String t;
    private volatile boolean u;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/stream/GenericStreamCallback$Companion;", "", "<init>", "()V", "TAG", "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10016a = new a(null);
    }

    public e(TextView r3, j r4, int r5, long r6, o r8, com.larus.business.markdown.api.model.e r9, p r10, AtomicBoolean r11, AtomicReference<bx> r12, al r13, AtomicBoolean r14, boolean r15) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        o r16 = (o) ZeusTransformUtils.wrapperContextForParams(r8, o.class, "com.obric.memorydata.plugin");
        com.larus.business.markdown.api.model.e r17 = (com.larus.business.markdown.api.model.e) ZeusTransformUtils.wrapperContextForParams(r9, com.larus.business.markdown.api.model.e.class, "com.obric.memorydata.plugin");
        al r18 = (al) ZeusTransformUtils.wrapperContextForParams(r13, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r7, "strategy");
        Intrinsics.checkNotNullParameter(r10, "cursorConfig");
        Intrinsics.checkNotNullParameter(r11, "isFirstRenderFlag");
        Intrinsics.checkNotNullParameter(r12, "typewriterJobRef");
        Intrinsics.checkNotNullParameter(r18, "parentScope");
        Intrinsics.checkNotNullParameter(r14, "isReleasedFlag");
        this.f10017b = r3;
        this.c = r7;
        this.d = r5;
        this.e = r6;
        this.f = r16;
        this.g = r17;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r18;
        this.l = r14;
        this.m = r15;
        this.n = kotlinx.coroutines.channels.l.a(-1, null, null, 6, null);
        this.o = new AtomicReference("");
        this.p = new AtomicInteger(0);
        this.q = new AtomicBoolean(false);
        this.r = new f();
        this.s = new c();
        this.t = "";
        this.u = true;
    }

    public static final /* synthetic */ Object a(e r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r21) {
        e r1 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, GenericStreamCallback$runTypewriter$1.class) == false) goto L7;
        GenericStreamCallback$runTypewriter$1 r4 = (GenericStreamCallback$runTypewriter$1) ZeusTransformUtils.preCheckCast(r2, GenericStreamCallback$runTypewriter$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        long r10 = r4.J$0;
        r1 = (e) ZeusTransformUtils.preCheckCast(r4.L$0, e.class, "com.obric.memorydata.plugin");
    L13:
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L22:
        if (r1.q.get() == true) goto L102;
        if (r1.l.get() == true) goto L102;
        String r0 = (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.channels.m.d(r1.n.i()), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r0 == null) goto L29;
        r1.o.set(r0);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L29:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.o.get(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        int r8 = r1.p.get();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        boolean r12 = false;
        if (r1.h.a() == false) goto L41;
        if (r1.h.c() == false) goto L41;
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if ((r13 - r10) < r1.h.d()) goto L41;
        if (r1.u == true) goto L38;
        boolean r9 = true;
    L39:
        r1.u = r9;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r10 = r13;
        goto L41
    L38:
        r9 = false;
    L41:
        if (r8 >= r7.length()) goto L67;
        f r11 = r1.r;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r11.update(r7);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r1.m == false) goto L48;
        if (r1.i.compareAndSet(true, false) == false) goto L48;
        int r14 = r7.length();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L51:
        int r15 = r1.s.update(r1.r, r14);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r15 > r8) goto L54;
    L94:
        long r16 = r1.e;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r16 > 0) goto L96;
        r4.L$0 = r1;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r4.J$0 = r10;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r4.label = 2;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (dg.a(r4) != r5) goto L22;
        return r5;
    L96:
        r4.L$0 = r1;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r4.J$0 = r10;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r4.label = 1;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (au.a(r16, r4) != r5) goto L22;
        return r5;
    L54:
        if (r1.p.compareAndSet(r8, r15) == false) goto L94;
        String r17 = r7.substring(0, r15);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        Intrinsics.checkNotNullExpressionValue(r17, "substring(...)");     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (Intrinsics.areEqual(r17, r1.t) == true) goto L58;
    L59:
        r1.t = r17;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r1.h.a() == true) goto L62;
    L64:
        String r18 = r17;
        j r19 = r1.c;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        TextView r110 = r1.f10017b;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        boolean r111 = false;
        com.larus.business.markdown.api.model.e r20 = r1.g;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L65:
        j.a.a(r19, r110, r18, r111, r20, null, 16, null);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        goto L94
    L62:
        if (r1.u == false) goto L64;
        r17 = r17 + r1.h.b();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        goto L64
    L58:
        if (r1.h.c() == false) goto L94;
    L48:
        if (r1.m == true) goto L50;
        r1.i.compareAndSet(true, false);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L50:
        r14 = Math.min(r1.d + r8, r7.length());     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        goto L51
    L67:
        if (r1.h.a() == false) goto L94;
        if (r1.h.c() == false) goto L94;
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L73;
        boolean r22 = true;
    L74:
        if (r22 == false) goto L94;
        CharSequence r23 = r1.f10017b.getText();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r23 == null) goto L79;
        String r24 = r23.toString();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r24 == null) goto L79;
    L80:
        String r25 = r7 + r1.h.b();     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        if (r1.u == false) goto L86;
        if (Intrinsics.areEqual(r24, r25) == false) goto L87;
    L88:
        if (r12 == false) goto L94;
        if (r1.u == false) goto L92;
        r18 = r25;
    L93:
        r19 = r1.c;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r110 = r1.f10017b;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        r111 = false;
        r20 = r1.g;     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
        goto L65
    L92:
        r18 = r7;
    L87:
        r12 = true;
        goto L88
    L86:
        if (Intrinsics.areEqual(r24, r7) == true) goto L88;
    L79:
        r24 = "";
        goto L80
    L73:
        r22 = false;
    L102:
        z.a.a((z) ZeusTransformUtils.preCheckCast(r1.n, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = r4.J$0;
        r1 = (e) ZeusTransformUtils.preCheckCast(r4.L$0, e.class, "com.obric.memorydata.plugin");
        goto L13
    L18:
        ResultKt.throwOnFailure(r3);
        r10 = System.currentTimeMillis();
        if (r1.h.a() == false) goto L22;
        j.a.a(r1.c, r1.f10017b, r1.h.b(), false, r1.g, null, 16, null);     // Catch: Throwable -> L103 Exception -> L105 CancellationException -> L110
    L103:
        th = move-exception;
        z.a.a((z) ZeusTransformUtils.preCheckCast(r1.n, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        throw th;
    L110:
        e = move-exception;
        throw e;     // Catch: Throwable -> L103
    L105:
        e = move-exception;
        RunLog.INSTANCE.error("GenericStreamCallbackV4", "Typewriter error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L103
    L7:
        r4 = new GenericStreamCallback$runTypewriter$1(r1, r2);
        goto L8
    }

    @Override // com.obric.memorydata.markdown.stream.n
    public void a() {
        o r0 = this.f;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.r.b();
        this.s.a();
        this.t = "";
        this.p.set(0);
        this.o.set("");
        this.q.set(false);
        this.u = true;
        bx r1 = kotlinx.coroutines.i.a(this.k, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new GenericStreamCallback$onStart$job$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        bx r9 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(r1), bx.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L9;
        bx.a.a(r9, null, 1, null);
        return;
    }

    @Override // com.obric.memorydata.markdown.stream.n
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chunk");
        if (this.l.get() == false) goto L5;
        return;
    L5:
        if (this.q.get() == true) goto L13;
        this.n.mo54trySendJP2dKIU(r2);
        o r1 = this.f;
        if (r1 == null) goto L12;
        r1.a(r2);
        return;
    L12:
        return;
    }

    @Override // com.obric.memorydata.markdown.stream.n
    public void a(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "t");
        if (this.q.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        bx.a.a(r0, null, 1, null);
    L8:
        this.r.b();
        this.s.a();
        o r5 = this.f;
        if (r5 == null) goto L12;
        r5.a(r6);
        return;
    }

    @Override // com.obric.memorydata.markdown.stream.n
    public void b() {
        if (this.q.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        bx.a.a(r0, null, 1, null);
    L8:
        this.r.b();
        this.s.a();
        o r5 = this.f;
        if (r5 == null) goto L12;
        r5.b();
        return;
    }

    @Override // com.obric.memorydata.markdown.stream.n
    public void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        if (this.l.get() == false) goto L6;
        return;
    L6:
        if (this.q.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        bx r0 = (bx) ZeusTransformUtils.preCheckCast(this.j.getAndSet(null), bx.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        bx.a.a(r0, null, 1, null);
    L11:
        this.r.b();
        this.s.a();
        j.a.a(this.c, this.f10017b, r10, true, this.g, null, 16, null);
        o r9 = this.f;
        if (r9 == null) goto L15;
        r9.b(r10);
        return;
    }
}
