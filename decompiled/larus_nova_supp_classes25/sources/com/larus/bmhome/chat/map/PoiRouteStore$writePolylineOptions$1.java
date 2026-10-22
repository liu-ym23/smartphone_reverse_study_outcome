package com.larus.bmhome.chat.map;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.cache.DiskCache;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import wq9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.map.PoiRouteStore$writePolylineOptions$1", f = "PoiRouteStore.kt", i = {}, l = {MessageCellStateTransformerType.RECORD_CARD}, m = "invokeSuspend", n = {}, s = {})
final class PoiRouteStore$writePolylineOptions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ List<a> $polylinePoints;
    int label;

    public PoiRouteStore$writePolylineOptions$1(String r1, List<a> r2, Continuation<? super PoiRouteStore$writePolylineOptions$1> r3) {
        this.$messageId = r1;
        this.$polylinePoints = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PoiRouteStore$writePolylineOptions$1(this.$messageId, this.$polylinePoints, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FLogger.a.d("PoiRouteStore", "[writePolylineOptions] to disk and memory with messageId:" + this.$messageId);
        s.d.put(this.$messageId, this.$polylinePoints);
        String r6 = GsonProtectorUtils.toJson(s.a, this.$polylinePoints);
        DiskCache r2 = s.c;
        String r3 = this.$messageId;
        Intrinsics.checkNotNull(r6);
        this.label = 1;
        if (r2.d(r3, r6, this) != r0) goto L12;
        return r0;
    }
}
