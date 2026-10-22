package com.obric.memorydata.markdown.stream;

import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0002!\"B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\u000f*\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J<\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u00182\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u001c\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J\u001c\u0010 \u001a\u00020\u00152\n\u0010\u001b\u001a\u00060\u0017j\u0002`\u00182\u0006\u0010\u001f\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownStreamEngine;", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/markdown/stream/StreamSource;", "idleTimeoutMs", "", "callback", "Lcom/obric/memorydata/markdown/stream/StreamingCallback;", "renderDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "dataMode", "Lcom/obric/memorydata/markdown/stream/StreamDataMode;", "<init>", "(Lcom/obric/memorydata/markdown/stream/StreamSource;JLcom/obric/memorydata/markdown/stream/StreamingCallback;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/obric/memorydata/markdown/stream/StreamDataMode;)V", CommonConsts.APM_INNER_EVENT_COST_START, "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "launchProducer", "channel", "Lkotlinx/coroutines/channels/Channel;", "", "fullContent", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "consumeLoop", "", "accumulated", "startTs", "(Lkotlinx/coroutines/channels/Channel;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAccumulated", "chunk", "getRenderContent", "Companion", "IdleTimeoutException", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MarkdownStreamEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f10001b;
    private final long c;
    private final n d;
    private final ah e;
    private final StreamDataMode f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownStreamEngine$IdleTimeoutException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class IdleTimeoutException extends Exception {
        public IdleTimeoutException() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/markdown/stream/MarkdownStreamEngine$Companion;", "", "<init>", "()V", "TAG", "", "CHANNEL_BUFFER", "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10002a = null;

        static {
            int[] r0 = new int[StreamDataMode.values().length];
            r0[StreamDataMode.Incremental.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StreamDataMode.Cumulative.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10002a = r0;
        }
    }

    static {
        f10000a = new a(null);
    }

    public MarkdownStreamEngine(l r3, long r4, n r6, ah r7, StreamDataMode r8) {
        l r5 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r6, n.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r7, "renderDispatcher");
        Intrinsics.checkNotNullParameter(r8, "dataMode");
        this.f10001b = r5;
        this.c = r4;
        this.d = r9;
        this.e = r7;
        this.f = r8;
    }

    public /* synthetic */ MarkdownStreamEngine(l r10, long r11, n r13, ah r14, StreamDataMode r15, int r16, DefaultConstructorMarker r17) {
        l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r10, l.class, "com.obric.memorydata.plugin");
        n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r13, n.class, "com.obric.memorydata.plugin");
        if ((r16 & 8) == 0) goto L5;
        ah r7 = (ah) ZeusTransformUtils.preCheckCast(ba.b(), ah.class, "com.obric.memorydata.plugin");
    L7:
        if ((r16 & 16) == 0) goto L9;
        StreamDataMode r8 = StreamDataMode.Cumulative;
    L10:
        this(r3, r11, r6, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }

    public static final /* synthetic */ StreamDataMode a(MarkdownStreamEngine r0) {
        return r0.f;
    }

    public static final /* synthetic */ Object a(MarkdownStreamEngine r9, kotlinx.coroutines.channels.i r10, StringBuilder r11, StringBuilder r12, long r13, Continuation r15) {
        return r9.a((kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin"), r11, r12, r13, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0184 -> B:17:0x008e). Please report as a decompilation issue!!! */
    private final Object a(kotlinx.coroutines.channels.i<String> r26, StringBuilder r27, StringBuilder r28, long r29, Continuation<? super Unit> r31) {
        kotlinx.coroutines.channels.i r1 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r26, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r31, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, MarkdownStreamEngine$consumeLoop$1.class) == false) goto L7;
        MarkdownStreamEngine$consumeLoop$1 r4 = (MarkdownStreamEngine$consumeLoop$1) ZeusTransformUtils.preCheckCast(r3, MarkdownStreamEngine$consumeLoop$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        MarkdownStreamEngine r5 = this;
    L8:
        Object r6 = r4.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r4.label;
        Continuation r11 = null;
        if (r8 == 0) goto L19;
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        ResultKt.throwOnFailure(r6);
    L37:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r2 = r4.I$0;
        long r12 = r4.J$0;
        StringBuilder r9 = (StringBuilder) ZeusTransformUtils.preCheckCast(r4.L$3, StringBuilder.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = (StringBuilder) ZeusTransformUtils.preCheckCast(r4.L$2, StringBuilder.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r14 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(r4.L$1, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        MarkdownStreamEngine r0 = (MarkdownStreamEngine) ZeusTransformUtils.preCheckCast(r4.L$0, MarkdownStreamEngine.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        boolean r13 = true;
        char r15 = 2;
    L17:
        StringBuilder r22 = r9;
        r5 = r0;
        StringBuilder r16 = r10;
        int r17 = r2;
        StringBuilder r18 = r22;
        long r23 = r12;
        MarkdownStreamEngine$consumeLoop$1 r19 = r4;
        Object r110 = r7;
        long r20 = r23;
        kotlinx.coroutines.channels.i r21 = r14;
        r11 = null;
    L21:
        if (r21.q() == true) goto L33;
        kotlinx.coroutines.selects.l r111 = new kotlinx.coroutines.selects.l(r19.getContext());
        kotlinx.coroutines.selects.c r112 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r111, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        r112.a(r21.k(), (Function2) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$consumeLoop$chunk$1$1(r11), Function2.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.selects.b.a(r112, b(r5), (Function1) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$consumeLoop$chunk$1$2(r11), Function1.class, "com.obric.memorydata.plugin"));
        r19.L$0 = r5;
        r19.L$1 = r21;
        r19.L$2 = r16;
        r19.L$3 = r18;
        r19.J$0 = r20;
        r19.I$0 = r17;
        r13 = true;
        r19.label = 1;
        Object r24 = r111.a(r19);
        if (r24 != r110) goto L25;
        return r110;
    L25:
        r14 = r21;
        r7 = r110;
        int r25 = r17;
        r10 = r16;
        r0 = r5;
        r9 = r18;
        int r30 = r25;
        long r210 = r20;
        r6 = r24;
        r4 = r19;
        r12 = r210;
    L26:
        String r32 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r32 != null) goto L29;
        r5 = r0;
        r16 = r10;
        r17 = r30;
        long r211 = r12;
        r19 = r4;
        r110 = r7;
        r20 = r211;
        goto L33
    L29:
        r2 = r30 + 1;
        r0.a(r9, r32);
        CoroutineContext r33 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r0.e, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r34 = (Function2) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$consumeLoop$2(r0, r9, r32, null), Function2.class, "com.obric.memorydata.plugin");
        r4.L$0 = r0;
        r4.L$1 = r14;
        r4.L$2 = r10;
        r4.L$3 = r9;
        r4.J$0 = r12;
        r4.I$0 = r2;
        r15 = 2;
        r4.label = 2;
        if (kotlinx.coroutines.i.a(r33, r34, r4) != r7) goto L17;
        return r7;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "done, chunks=" + r17 + ", len=" + r16.length() + ", cost=" + (SystemClock.elapsedRealtime() - r20) + "ms", false, 4, null);
        CoroutineContext r35 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r5.e, CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r36 = (Function2) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$consumeLoop$3(r5, r16, null), Function2.class, "com.obric.memorydata.plugin");
        r19.L$0 = null;
        r19.L$1 = null;
        r19.L$2 = null;
        r19.L$3 = null;
        r19.label = 3;
        if (kotlinx.coroutines.i.a(r35, r36, r19) != r110) goto L37;
        return r110;
    L18:
        r30 = r4.I$0;
        r12 = r4.J$0;
        r9 = (StringBuilder) ZeusTransformUtils.preCheckCast(r4.L$3, StringBuilder.class, "com.obric.memorydata.plugin");
        r10 = (StringBuilder) ZeusTransformUtils.preCheckCast(r4.L$2, StringBuilder.class, "com.obric.memorydata.plugin");
        r14 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.preCheckCast(r4.L$1, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        r0 = (MarkdownStreamEngine) ZeusTransformUtils.preCheckCast(r4.L$0, MarkdownStreamEngine.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r13 = true;
        goto L26
    L19:
        ResultKt.throwOnFailure(r6);
        r17 = 0;
        r19 = r4;
        r110 = r7;
        r16 = r27;
        r20 = r29;
        r21 = r1;
        r18 = r28;
    L7:
        r5 = this;
        r4 = new MarkdownStreamEngine$consumeLoop$1(r5, r3);
        goto L8
    }

    public static final /* synthetic */ String a(MarkdownStreamEngine r0, StringBuilder r1, String r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ bx a(MarkdownStreamEngine r2, al r3, kotlinx.coroutines.channels.i r4, StringBuilder r5) {
        return r2.a((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin"), r5);
    }

    private final bx a(al r9, kotlinx.coroutines.channels.i<String> r10, StringBuilder r11) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.i r12 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a(r2, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$launchProducer$1(this, r12, r11, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void a(StringBuilder r2, String r3) {
        StreamDataMode r1 = this.f;
        int r4 = b.f10002a[r1.ordinal()];
        if (r4 != 1) goto L5;
        r2.append(r3);
        return;
    L5:
        if (r4 != 2) goto L8;
        StringsKt.clear(r2).append(r3);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ long b(MarkdownStreamEngine r2) {
        return r2.c;
    }

    private final String b(StringBuilder r2, String r3) {
        StreamDataMode r1 = this.f;
        int r4 = b.f10002a[r1.ordinal()];
        if (r4 != 1) goto L5;
        String r5 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    L5:
        if (r4 != 2) goto L8;
        return r3;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ ah c(MarkdownStreamEngine r0) {
        return r0.e;
    }

    public static final /* synthetic */ n d(MarkdownStreamEngine r0) {
        return r0.d;
    }

    public static final /* synthetic */ l e(MarkdownStreamEngine r0) {
        return r0.f10001b;
    }

    public final bx a(al r9) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "scope");
        return kotlinx.coroutines.i.a(r2, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$start$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
