package com.larus.bmhome.chat.doclink;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.doclink.UrlPreviewGatewayRepository$getOrCreatePreviewIds$2", f = "UrlPreviewGatewayRepository.kt", i = {}, l = {MessageCellStateTransformerType.CIPHER}, m = "invokeSuspend", n = {}, s = {})
final class UrlPreviewGatewayRepository$getOrCreatePreviewIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ List<String> $urls;
    int label;

    public UrlPreviewGatewayRepository$getOrCreatePreviewIds$2(List<String> r1, String r2, Continuation<? super UrlPreviewGatewayRepository$getOrCreatePreviewIds$2> r3) {
        this.$urls = r1;
        this.$messageId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UrlPreviewGatewayRepository$getOrCreatePreviewIds$2(this.$urls, this.$messageId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Map r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L21:
        dm9.a.b r16 = (dm9.a) r15;
        boolean r3 = r16 instanceof dm9.a.b;
        if (r3 == false) goto L52;
        dm9.a.b r4 = r16;
        if (r4.a.isSuccess() == false) goto L52;
        o r17 = (o) r4.a.getData();
        if (r17 == null) goto L48;
        Map<String, p> r18 = r17.a();
        if (r18 == null) goto L48;
        ArrayList r5 = new ArrayList();
        Iterator<Map.Entry<String, p>> r19 = r18.entrySet().iterator();
    L31:
        if (r19.hasNext() == false) goto L47;
        Map.Entry<String, p> r6 = r19.next();
        String r7 = r6.getKey();
        p r8 = r6.getValue();
        if (r8 == null) goto L35;
        String r9 = r8.a();
    L36:
        if (r9 != null) goto L38;
    L41:
        boolean r10 = true;
    L42:
        if (r10 == false) goto L44;
        Pair r11 = null;
    L45:
        if (r11 == null) goto L31;
        r5.add(r11);
        goto L31
    L44:
        r11 = TuplesKt.to(r7, r9);
        goto L45
    L38:
        if (StringsKt.isBlank(r9) == true) goto L41;
        r10 = false;
        goto L42
    L35:
        r9 = null;
        goto L36
    L47:
        r2 = MapsKt.toMap(r5);
    L48:
        if (r2 != null) goto L50;
        r2 = MapsKt.emptyMap();
    L50:
        FLogger.a.i("UrlPreviewGatewayRepository", "getOrCreatePreviewIds success previewIdCount=" + r2.size());
        return r2;
    L52:
        if (r3 == false) goto L55;
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("getOrCreatePreviewIds biz error code=");
        dm9.a.b r14 = r16;
        r13.append(r14.a.getCode());
        r13.append(", msg=");
        r13.append(r14.a.getMsg());
        r12.i("UrlPreviewGatewayRepository", r13.toString());
    L55:
        if ((r16 instanceof dm9.a.a) == false) goto L57;
        FLogger.a.i("UrlPreviewGatewayRepository", "getOrCreatePreviewIds error=" + ((dm9.a.a) r16).c);
    L59:
        return MapsKt.emptyMap();
    L57:
        FLogger.a.i("UrlPreviewGatewayRepository", "getOrCreatePreviewIds empty result");
        goto L59
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        List<String> r110 = this.$urls;
        ArrayList r20 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L10:
        if (r111.hasNext() == false) goto L14;
        Object r21 = r111.next();
        if ((!StringsKt.isBlank((String) r21)) == false) goto L10;
        r20.add(r21);
        goto L10
    L14:
        List r112 = CollectionsKt.take(CollectionsKt.distinct(r20), 25);
        if (r112.isEmpty() == true) goto L17;
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("getOrCreatePreviewIds request urlCount=");
        r23.append(r112.size());
        r23.append(", hasMessageId=");
        r23.append(!StringsKt.isBlank(this.$messageId));
        r22.i("UrlPreviewGatewayRepository", r23.toString());
        UrlPreviewGatewayApi.a r24 = UrlPreviewGatewayApi.a;
        UrlPreviewGatewayRepository$getOrCreatePreviewIds$2$result$1 r25 = new UrlPreviewGatewayRepository$getOrCreatePreviewIds$2$result$1(r112, this.$messageId, null);
        this.label = 1;
        r24.getClass();
        FlowHttpConnection r113 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("Basic", UrlPreviewGatewayApi.class, r25, false, null, null, null, this, 248);
        if (r15 != r0) goto L21;
        return r0;
    L17:
        return MapsKt.emptyMap();
    }
}
