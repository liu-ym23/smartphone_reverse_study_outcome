package com.obric.miniapp.intent;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/miniapp/intent/QueryPrivilegedImageOperation$QueryResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.intent.QueryPrivilegedImageOperation$execute$2", f = "QueryPrivilegedImageOperation.kt", i = {}, l = {46, 48}, m = "invokeSuspend", n = {}, s = {})
public final class QueryPrivilegedImageOperation$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QueryPrivilegedImageOperation.a>, Object> {
    final /* synthetic */ boolean $isVideo;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $uri;
    private /* synthetic */ Object L$0;
    int label;

    public QueryPrivilegedImageOperation$execute$2(boolean r1, String r2, String r3, int r4, Continuation<? super QueryPrivilegedImageOperation$execute$2> r5) {
        this.$isVideo = r1;
        this.$packageName = r2;
        this.$uri = r3;
        this.$maxSize = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        QueryPrivilegedImageOperation$execute$2 r6 = new QueryPrivilegedImageOperation$execute$2(this.$isVideo, this.$packageName, this.$uri, this.$maxSize, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super QueryPrivilegedImageOperation.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25
    L22:
        String r9 = (String) r8;     // Catch: Throwable -> L25
    L23:
        Object r10 = Result.constructor-impl(new QueryPrivilegedImageOperation.a(true, new JSONObject().put(WindowEvent.Params.RESULT, r9), null, null, 12));     // Catch: Throwable -> L25
    L27:
        String r2 = this.$packageName;
        Throwable r3 = Result.exceptionOrNull-impl(r10);
        if (r3 == null) goto L45;
        FLogger.a.w("QueryPrivilegedImage", "query privileged image failed packageName=" + r2, r3);
        QueryPrivilegedImageOperation r11 = QueryPrivilegedImageOperation.a;
        if ((r3 instanceof QueryPrivilegedImageOperation.PrivilegedImageException) == false) goto L33;
        QueryPrivilegedImageOperation.PrivilegedImageException r12 = (QueryPrivilegedImageOperation.PrivilegedImageException) r3;
    L34:
        if (r12 == null) goto L37;
        String r13 = r12.getCode();
        if (r13 == null) goto L37;
    L38:
        String r4 = r3.getMessage();
        if (r4 != null) goto L42;
        r4 = "query privileged image failed";
    L42:
        return QueryPrivilegedImageOperation.e(r13, r4);
    L37:
        r13 = "QUERY_IMAGE_FAILED";
        goto L38
    L33:
        r12 = null;
        goto L34
    L45:
        return r10;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25
    L18:
        r9 = (String) r8;     // Catch: Throwable -> L25
        goto L23
    L12:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        boolean r15 = this.$isVideo;
        String r5 = this.$packageName;
        String r6 = this.$uri;
        int r7 = this.$maxSize;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L25
        if (r15 == false) goto L19;
        QueryPrivilegedImageOperation r17 = QueryPrivilegedImageOperation.a;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        r8 = QueryPrivilegedImageOperation.b(r17, r5, r6, r7, this);     // Catch: Throwable -> L25
        if (r8 != r0) goto L18;
        return r0;
    L19:
        QueryPrivilegedImageOperation r18 = QueryPrivilegedImageOperation.a;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        r8 = QueryPrivilegedImageOperation.a(r18, r5, r6, r7, this);     // Catch: Throwable -> L25
        if (r8 != r0) goto L22;
        return r0;
    L25:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
