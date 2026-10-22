package com.obric.aiagent.messenger.stub;

import android.os.Binder;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FrontierIDLStub$sendData$1", f = "FrontierIDLStub.kt", i = {0}, l = {74}, m = "invokeSuspend", n = {"headerMap"}, s = {"L$0"})
public final class FrontierIDLStub$sendData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $callingId;
    final /* synthetic */ Ref.BooleanRef $hasScreenshot;
    final /* synthetic */ Map<Object, Object> $headers;
    final /* synthetic */ Ref.ObjectRef<String> $messageId;
    final /* synthetic */ Ref.ObjectRef<byte[]> $payload;
    final /* synthetic */ int $serviceId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FrontierIDLStub this$0;

    public FrontierIDLStub$sendData$1(int r1, Map<Object, Object> r2, Ref.ObjectRef<String> r3, Ref.BooleanRef r4, Ref.ObjectRef<byte[]> r5, FrontierIDLStub r6, long r7, Continuation<? super FrontierIDLStub$sendData$1> r9) {
        this.$serviceId = r1;
        this.$headers = r2;
        this.$messageId = r3;
        this.$hasScreenshot = r4;
        this.$payload = r5;
        this.this$0 = r6;
        this.$callingId = r7;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        FrontierIDLStub$sendData$1 r10 = new FrontierIDLStub$sendData$1(this.$serviceId, this.$headers, this.$messageId, this.$hasScreenshot, this.$payload, this.this$0, this.$callingId, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        Ref.ObjectRef<byte[]> r0 = (Ref.ObjectRef) this.L$1;
        Map r3 = (Map) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L61
    L55:
        r0.element = r10;     // Catch: Throwable -> L61
        Map r11 = r3;
    L56:
        com.larus.im.f r4 = FrontierIDLStub.access$getFrontier(this.this$0, this.$serviceId);     // Catch: Throwable -> L61
        if (r4 == null) goto L59;
        r4.f((byte[]) this.$payload.element, r11, null);     // Catch: Throwable -> L61
    L59:
        Binder.restoreCallingIdentity(this.$callingId);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        FLogger.a.i("FrontierIDLStub", "sendData, serviceId=" + this.$serviceId);     // Catch: Throwable -> L61
        Map<Object, Object> r13 = this.$headers;     // Catch: Throwable -> L61
        if (r13 == null) goto L16;
        Map r14 = com.obric.aiagent.ipc.utils.d.b(r13);     // Catch: Throwable -> L61
        if (r14 == null) goto L16;
        r11 = MapsKt.toMutableMap(r14);     // Catch: Throwable -> L61
    L17:
        Ref.ObjectRef<String> r5 = this.$messageId;     // Catch: Throwable -> L61
        if (r11 == null) goto L20;
        String r6 = (String) r11.get("message_id");     // Catch: Throwable -> L61
    L21:
        r5.element = r6;     // Catch: Throwable -> L61
        Ref.BooleanRef r7 = this.$hasScreenshot;     // Catch: Throwable -> L61
        if (r11 == null) goto L25;
        String r8 = (String) r11.get("has_screenshot");     // Catch: Throwable -> L61
    L26:
        r7.element = Intrinsics.areEqual(r8, "1");     // Catch: Throwable -> L61
        if (r11 == null) goto L30;
        String r9 = (String) r11.remove("has_screenshot");     // Catch: Throwable -> L61
    L30:
        if (this.$hasScreenshot.element == false) goto L56;
        Ref.ObjectRef<byte[]> r15 = this.$payload;     // Catch: Throwable -> L61
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L46
        JSONObject r17 = new JSONObject(new String((byte[]) r15.element, Charsets.UTF_8)).optJSONObject("app_action");     // Catch: Throwable -> L46
        if (r17 == null) goto L43;
        Long r18 = Boxing.boxLong(r17.optLong("question_id", -1));     // Catch: Throwable -> L46
        if (r18.longValue() <= 0) goto L37;
        boolean r19 = true;
    L38:
        if (r19 == true) goto L41;
        r18 = null;
    L41:
        if (r18 == null) goto L43;
        String r20 = r18.toString();     // Catch: Throwable -> L46
    L44:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r21) == false) goto L51;
        r21 = null;
    L51:
        Ref.ObjectRef<byte[]> r22 = this.$payload;     // Catch: Throwable -> L61
        FrontierIDLStub r23 = this.this$0;     // Catch: Throwable -> L61
        byte[] r24 = (byte[]) r22.element;     // Catch: Throwable -> L61
        String r25 = (String) this.$messageId.element;     // Catch: Throwable -> L61
        this.L$0 = r11;     // Catch: Throwable -> L61
        this.L$1 = r22;     // Catch: Throwable -> L61
        this.label = 1;     // Catch: Throwable -> L61
        Object r26 = FrontierIDLStub.access$handleCacheBitmap(r23, r24, r25, (String) r21, this);     // Catch: Throwable -> L61
        if (r26 != r1) goto L54;
        return r1;
    L54:
        r3 = r11;
        r10 = r26;
        r0 = r22;
        goto L55
    L37:
        r19 = false;
    L43:
        r20 = null;
    L46:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L61
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L49
    L25:
        r8 = null;
        goto L26
    L20:
        r6 = null;
    L16:
        r11 = null;
    L61:
        th = move-exception;
        Binder.restoreCallingIdentity(this.$callingId);
        throw th;
    }
}
