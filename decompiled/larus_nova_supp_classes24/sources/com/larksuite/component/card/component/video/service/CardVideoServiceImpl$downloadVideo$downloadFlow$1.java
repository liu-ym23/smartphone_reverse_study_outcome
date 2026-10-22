package com.larksuite.component.card.component.video.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;
import qpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$downloadFlow$1", f = "CardVideoServiceImpl.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
final class CardVideoServiceImpl$downloadVideo$downloadFlow$1 extends SuspendLambda implements Function2<k<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $videoKey;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements qpc.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ k<Integer> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r1, k<? super Integer> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onPushDownloadProgress(String r1, int r2, long r3, long r5) {
            if (Intrinsics.areEqual(r1, this.a) == false) goto L6;
            this.b.trySend-JP2dKIU(Integer.valueOf(r2));
            return;
        }
    }

    public CardVideoServiceImpl$downloadVideo$downloadFlow$1(String r1, Continuation<? super CardVideoServiceImpl$downloadVideo$downloadFlow$1> r2) {
        this.$videoKey = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CardVideoServiceImpl$downloadVideo$downloadFlow$1 r0 = new CardVideoServiceImpl$downloadVideo$downloadFlow$1(this.$videoKey, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super Integer> r1, Continuation<? super Unit> r2) {
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
        k r6 = (k) this.L$0;
        final a r2 = new a(this.$videoKey, r6);
        ((e) ApiUtils.getApi(e.class)).addPushResourceDownloadProgressListener(r2);
        Function0<Unit> r3 = new AnonymousClass1(r2);
        this.label = 1;
        if (ProduceKt.a(r6, r3, this) != r0) goto L12;
        return r0;
    }
}
