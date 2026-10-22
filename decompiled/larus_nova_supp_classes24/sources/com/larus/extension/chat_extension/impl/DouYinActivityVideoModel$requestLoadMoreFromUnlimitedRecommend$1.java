package com.larus.extension.chat_extension.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.extension.chat_extension.impl.DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1", f = "DouYinActivityVideoModel.kt", i = {}, l = {32, 28}, m = "invokeSuspend", n = {}, s = {})
final class DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $douYinVideoDataManager;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ Function3<Boolean, List<String>, Map<String, String>, Unit> $onSuccess;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1(a r1, Function3<? super Boolean, ? super List<String>, ? super Map<String, String>, Unit> r2, Function0<Unit> r3, Continuation<? super DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1> r4) {
        this.$onSuccess = r2;
        this.$onFail = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DouYinActivityVideoModel$requestLoadMoreFromUnlimitedRecommend$1(null, this.$onSuccess, this.$onFail, r5);
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
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r16);
        this.L$0 = "Basic";
        this.L$1 = RecommendVideos.class;
        this.L$2 = "/alice/media/video/recommend";
        this.label = 1;
        throw null;
    L5:
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L9;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L13:
        y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof y) == false) goto L16;
        RecommendVideos r3 = (RecommendVideos) ((com.larus.network.http.a) r2).b;
        throw null;
    L16:
        if ((r2 instanceof f) == false) goto L21;
        Function0<Unit> r4 = this.$onFail;
        if (r4 == null) goto L21;
        r4.invoke();
    L21:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r5 = (String) this.L$2;
        Class r6 = (Class) this.L$1;
        String r7 = (String) this.L$0;
        ResultKt.throwOnFailure(r16);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        r1 = HttpExtKt.k(r7, r6, r5, (JSONObject) r16, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L13;
        return r13;
    }
}
