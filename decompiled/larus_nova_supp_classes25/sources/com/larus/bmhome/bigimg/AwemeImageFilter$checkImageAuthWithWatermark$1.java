package com.larus.bmhome.bigimg;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.AwemeImageFilter$checkImageAuthWithWatermark$1", f = "AwemeImageFilter.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeImageFilter$checkImageAuthWithWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $itemId;
    final /* synthetic */ Function1<Throwable, Unit> $onDeny;
    final /* synthetic */ Function1<String, Unit> $onGranted;
    final /* synthetic */ String $shortId;
    final /* synthetic */ String $uri;
    int label;
    final /* synthetic */ AwemeImageFilter this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AwemeImageFilter$checkImageAuthWithWatermark$1(AwemeImageFilter r1, Function1<? super Throwable, Unit> r2, String r3, Function1<? super String, Unit> r4, String r5, String r6, Continuation<? super AwemeImageFilter$checkImageAuthWithWatermark$1> r7) {
        this.this$0 = r1;
        this.$onDeny = r2;
        this.$itemId = r3;
        this.$onGranted = r4;
        this.$uri = r5;
        this.$shortId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AwemeImageFilter$checkImageAuthWithWatermark$1(this.this$0, this.$onDeny, this.$itemId, this.$onGranted, this.$uri, this.$shortId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r14 = true;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L11:
        com.larus.network.http.f r2 = (com.larus.network.http.a) r1;
        GetAuthImageWithWatermarkResponse r3 = (GetAuthImageWithWatermarkResponse) ((com.larus.network.http.a) r2).b;
        boolean r4 = r2 instanceof com.larus.network.http.f;
        if (r4 == true) goto L30;
        if (r3 == null) goto L30;
        Map<String, String> r5 = r3.getItemIdToUrl();
        if (r5 != null) goto L19;
        Function1<Throwable, Unit> r6 = this.$onDeny;
        ImageAuthException.Companion.getClass();
        r6.invoke(new ImageAuthException(-1));
        return Unit.INSTANCE;
    L19:
        String r7 = r5.get(this.$itemId.toString());
        if (r7 != null) goto L22;
    L25:
        if (r14 == false) goto L27;
        Function1<Throwable, Unit> r8 = this.$onDeny;
        ImageAuthException.Companion.getClass();
        r8.invoke(new ImageAuthException(-1));
    L29:
        return Unit.INSTANCE;
    L27:
        this.$onGranted.invoke(r7);
        goto L29
    L22:
        if (r7.length() == 0) goto L25;
        r14 = false;
    L30:
        String r9 = null;
        if (r4 == false) goto L33;
        AsyncThrowable r10 = r2.d;
    L34:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("checkImageAuthWithWatermark called, net error, ");
        if (r10 == null) goto L39;
        Throwable r15 = r10.getCause();
        if (r15 == null) goto L39;
        r9 = r15.getMessage();
    L39:
        r12.append(r9);
        r11.e("AwemeImageFilter", r12.toString());
        Function1<Throwable, Unit> r17 = this.$onDeny;
        ImageAuthException.Companion.getClass();
        r17.invoke(new ImageAuthException(-3));
        return Unit.INSTANCE;
    L33:
        r10 = null;
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        JSONObject r18 = new JSONObject();
        String r19 = this.$uri;
        String r20 = this.$shortId;
        r18.put("uri", r19);
        r18.put("short_id", r20);
        AwemeImageFilter r21 = this.this$0;
        JSONArray r22 = new JSONArray();
        String r23 = this.$itemId;
        JSONObject r24 = new JSONObject();
        r24.put("item_id", r23);
        r24.put("image_info", r18);
        r22.put(r24);
        this.label = 1;
        int r25 = AwemeImageFilter.a;
        r21.getClass();
        JSONObject r26 = new JSONObject();
        r26.put("itemIDToImageInfos", r22);
        Unit r27 = Unit.INSTANCE;
        r1 = HttpExtKt.k("Message", GetAuthImageWithWatermarkResponse.class, "/alice/download/image_with_watermark", r26, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L11;
        return r13;
    }
}
