package com.obric.memorydata.personalcontext.search.global;

import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jr\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/global/ReactAgentConcurrentExecutor;", "", "<init>", "()V", "TAG", "", "DEFAULT_TIMEOUT_MS", "", "requestQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/obric/memorydata/personalcontext/search/global/ReactAgentConcurrentExecutor$SearchRequest;", "processingCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "schedulerMutex", "Lkotlinx/coroutines/sync/Mutex;", "executeReActPackageSearchWithConcurrency", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", "queryId", "queryList", "", "referenceQuery", "searchType", "needContent", "", ChatMessage.TYPE_RESPONSE, "businessName", "timeoutMs", "meta", "searchContentDomain", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProcessingCount", "", "getQueueLength", "getPoolStatus", "SearchRequest", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<Object> f12334b = null;
    private static final AtomicInteger c = null;
    private static final AtomicLong d = null;
    private static final kotlinx.coroutines.sync.a e = null;

    static {
        f12333a = new h();
        f12334b = new ConcurrentLinkedQueue();
        c = new AtomicInteger(0);
        d = new AtomicLong(0);
        e = kotlinx.coroutines.sync.c.a(false, 1, null);
    }

    private h() {
    }

    public static /* synthetic */ Object a(h r16, String r17, List r18, String r19, String r20, boolean r21, GlobalAssistantSearchResponse r22, String r23, long r24, String r26, String r27, Continuation r28, int r29, Object r30) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Continuation<? super GlobalAssistantSearchResponse> r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r28, Continuation.class, "com.obric.memorydata.plugin");
        if ((r29 & 4) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r29 & 128) == 0) goto L9;
        long r11 = 180000;
    L11:
        if ((r29 & 256) == 0) goto L13;
        String r13 = "";
    L15:
        if ((r29 & 512) == 0) goto L17;
        String r14 = null;
    L19:
        return r16.a(r17, r5, r6, r20, r21, r22, r23, r11, r13, r14, r15);
    L17:
        r14 = r27;
        goto L19
    L13:
        r13 = r26;
        goto L15
    L9:
        r11 = r24;
        goto L11
    L5:
        r6 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v10, types: [T] */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final Object a(String r32, List<String> r33, String r34, String r35, boolean r36, GlobalAssistantSearchResponse r37, String r38, long r39, String r41, String r42, Continuation<? super GlobalAssistantSearchResponse> r43) {
        ?? r1 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r43, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1.class) == false) goto L7;
        ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1 r4 = (ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1) ZeusTransformUtils.preCheckCast(r3, ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r8 = "Search execution failed: ";
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L23;
        if (r7 != 2) goto L22;
        long r9 = r4.J$0;
        Ref.ObjectRef r10 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        GlobalAssistantSearchResponse r11 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r4.L$0, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15 IllegalStateException -> L17 TimeoutCancellationException -> L19
        r8 = "Search execution failed: ";
        Object r12 = r5;
    L98:
        GlobalAssistantSearchResponse r0 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r12, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IllegalStateException -> L53 TimeoutCancellationException -> L55
        RunLog.INSTANCE.debug("ReactAgentConcurrentExecutor", "Completed request: " + r9);     // Catch: Throwable -> L15 IllegalStateException -> L53 TimeoutCancellationException -> L55
        String r2 = (String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L52;
        i.f12335a.a(r2);
    L52:
        c.decrementAndGet();
        return r0;
    L55:
        e = e;
        GlobalAssistantSearchResponse r14 = r11;
        r8 = r8;
    L80:
        RunLog.INSTANCE.error("ReactAgentConcurrentExecutor", "Failed to execute search request: " + r9, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        r14.setCode(1004);     // Catch: Throwable -> L15
        r14.setMessage(r8 + e.getMessage());     // Catch: Throwable -> L15
        String r13 = (String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L84;
    L83:
        i.f12335a.a(r13);
    L84:
        c.decrementAndGet();
        return r14;
    L53:
        e = e;
        r14 = r11;
    L73:
        RunLog.INSTANCE.error("ReactAgentConcurrentExecutor", "Failed to execute search request: " + r9, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        r14.setCode(1004);     // Catch: Throwable -> L15
        r14.setMessage(r8 + e.getMessage());     // Catch: Throwable -> L15
        r13 = (String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L84;
    L19:
        e = e;
        r14 = r11;
        r8 = "Search execution failed: ";
    L17:
        e = e;
        r14 = r11;
        r8 = "Search execution failed: ";
        goto L73
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        long r15 = r4.J$1;
        long r16 = r4.J$0;
        boolean r17 = r4.Z$0;
        Ref.ObjectRef r18 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$9, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r19 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$8, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r4.L$7, String.class, "com.obric.memorydata.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r4.L$6, String.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r4.L$5, String.class, "com.obric.memorydata.plugin");
        GlobalAssistantSearchResponse r111 = (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r4.L$4, GlobalAssistantSearchResponse.class, "com.obric.memorydata.plugin");
        String r22 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        List r24 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.memorydata.plugin");
        String r25 = (String) ZeusTransformUtils.preCheckCast(r4.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L26 IllegalStateException -> L28 TimeoutCancellationException -> L30
        String r26 = r20;
        String r27 = r21;
        String r28 = r22;
        String r29 = r23;
        ?? r112 = r24;
        String r113 = r25;
        r10 = r19;
        String r210 = r110;
        long r114 = r16;
        Ref.ObjectRef r115 = r18;
        long r30 = r15;
        r14 = r111;
        ?? r31 = r5;
    L102:
        r115.element = r31;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        c.incrementAndGet();     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        RunLog.INSTANCE.debug("ReactAgentConcurrentExecutor", "Processing request: " + r30 + ", using package: " + ((String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        if (r17 == false) goto L43;
        boolean r211 = true;
    L44:
        Function2 r40 = (Function2) ZeusTransformUtils.preCheckCast(new ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$result$1(r113, r112, r29, r28, r211, r14, r27, r10, r26, r210, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$0 = r14;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$1 = r10;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$2 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$3 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$4 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$5 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$6 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$7 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$8 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.L$9 = null;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.J$0 = r30;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        r4.label = 2;     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        Object r44 = da.a(r114, r40, r4);     // Catch: Throwable -> L15 IllegalStateException -> L57 TimeoutCancellationException -> L59
        if (r44 != r6) goto L47;
        return r6;
    L47:
        r9 = r30;
        r11 = r14;
        r12 = r44;
        goto L98
    L43:
        r211 = false;
    L59:
        e = e;
        r8 = r8;
        r9 = r30;
    L57:
        e = e;
        r9 = r30;
        goto L73
    L30:
        e = e;
        r8 = "Search execution failed: ";
        r10 = r19;
        r9 = r15;
        r14 = r111;
    L28:
        e = e;
        r8 = "Search execution failed: ";
        r10 = r19;
        r9 = r15;
        r14 = r111;
    L26:
        th = th;
        r1 = r19;
    L86:
        String r45 = (String) ZeusTransformUtils.preCheckCast(r1.element, String.class, "com.obric.memorydata.plugin");
        if (r45 == null) goto L89;
        i.f12335a.a(r45);
    L89:
        c.decrementAndGet();
        throw th;
    L32:
        ResultKt.throwOnFailure(r5);
        long r116 = d.incrementAndGet();
        RunLog.INSTANCE.debug("ReactAgentConcurrentExecutor", "Queueing search request: " + r116 + ", queryId: " + r32);
        r10 = new Ref.ObjectRef();
        i r46 = i.f12335a;     // Catch: Throwable -> L68 IllegalStateException -> L70 TimeoutCancellationException -> L77
        r4.L$0 = r32;     // Catch: TimeoutCancellationException -> L65 Throwable -> L68 IllegalStateException -> L70
        r4.L$1 = r1;     // Catch: TimeoutCancellationException -> L65 Throwable -> L68 IllegalStateException -> L70
        r4.L$2 = r34;     // Catch: TimeoutCancellationException -> L65 Throwable -> L68 IllegalStateException -> L70
        r4.L$3 = r35;     // Catch: TimeoutCancellationException -> L65 Throwable -> L68 IllegalStateException -> L70
        r14 = r37;
        r4.L$4 = r14;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.L$5 = r38;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.L$6 = r41;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.L$7 = r42;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.L$8 = r10;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.L$9 = r10;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.Z$0 = r36;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.J$0 = r39;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.J$1 = r116;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        r4.label = 1;     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        Object r47 = r46.a(r4);     // Catch: IllegalStateException -> L61 TimeoutCancellationException -> L63 Throwable -> L68
        if (r47 != r6) goto L39;
        return r6;
    L39:
        r113 = r32;
        r17 = r36;
        r26 = r41;
        r210 = r42;
        r29 = r34;
        r30 = r116;
        r28 = r35;
        r27 = r38;
        r112 = r1;
        r114 = r39;
        r115 = r10;
        r31 = r47;
        r10 = r115;
        goto L102
    L63:
        e = e;
    L79:
        r9 = r116;
    L61:
        e = e;
    L72:
        r8 = "Search execution failed: ";
        r10 = r10;
        r9 = r116;
        goto L73
    L65:
        e = e;
        r14 = r37;
    L70:
        e = e;
        r14 = r37;
    L77:
        e = e;
        r14 = r37;
    L68:
        th = th;
        r1 = r10;
    L15:
        th = th;
    L7:
        r4 = new ReactAgentConcurrentExecutor$executeReActPackageSearchWithConcurrency$1(this, r3);
        goto L8
    }
}
