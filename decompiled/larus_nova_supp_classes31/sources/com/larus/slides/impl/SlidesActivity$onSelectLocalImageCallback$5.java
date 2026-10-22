package com.larus.slides.impl;

import com.larus.slides.impl.select.utils.ChameleonImageUtils;
import com.larus.slides.sdk.api.media.ThumbType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$onSelectLocalImageCallback$5", f = "SlidesActivity.kt", i = {}, l = {407, 425}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesActivity$onSelectLocalImageCallback$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ ThumbType $thumbType;
    int label;
    final /* synthetic */ SlidesActivity this$0;

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesActivity$onSelectLocalImageCallback$5$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesActivity$onSelectLocalImageCallback$5$3", f = "SlidesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SlidesActivity this$0;

        public AnonymousClass3(SlidesActivity r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SlidesActivity r3 = this.this$0;
            int r0 = SlidesActivity.q;
            r3.G1();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SlidesActivity$onSelectLocalImageCallback$5(ThumbType r1, SlidesActivity r2, String r3, Continuation<? super SlidesActivity$onSelectLocalImageCallback$5> r4) {
        this.$thumbType = r1;
        this.this$0 = r2;
        this.$clickFrom = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SlidesActivity$onSelectLocalImageCallback$5(this.$thumbType, this.this$0, this.$clickFrom, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass3 r2 = new AnonymousClass3(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        ChameleonImageUtils r12 = ChameleonImageUtils.a;
        ThumbType r3 = this.$thumbType;
        Long r4 = Boxing.boxLong(20971520);
        final SlidesActivity r5 = this.this$0;
        Function0 r6 = new m(r5);
        final String r7 = this.$clickFrom;
        Function1 r8 = new n(r5, r7);
        this.label = 1;
        r12.getClass();
        if (ChameleonImageUtils.b(r3, r4, r6, r8, this) != r0) goto L13;
        return r0;
    }
}
