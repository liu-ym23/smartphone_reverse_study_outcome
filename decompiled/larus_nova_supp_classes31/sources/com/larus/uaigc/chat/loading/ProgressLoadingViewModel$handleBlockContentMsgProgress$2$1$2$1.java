package com.larus.uaigc.chat.loading;

import com.facebook.datasource.DataSource;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {355, 358}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationItem $it;
    final /* synthetic */ Job $this_apply;
    int label;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/facebook/datasource/DataSource;", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DataSource<Void>>, Object> {
        final /* synthetic */ CreationItem $it;
        int label;

        public AnonymousClass1(CreationItem r1, Continuation<? super AnonymousClass1> r2) {
            this.$it = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$it, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super DataSource<Void>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L17:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            ImageData r12 = this.$it.image;
            if (r12 == null) goto L13;
            ImageObj r13 = r12.imageThumb;
            if (r13 == null) goto L13;
            String r14 = bz9.a.a(r13);
        L14:
            this.label = 1;
            r11 = ImageLoaderKt.A(r14, "ProgressLoadingViewModel", null, null, null, this, 60);
            if (r11 != r0) goto L17;
            return r0;
        L13:
            r14 = null;
            goto L14
        }
    }

    public ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1(Job r1, CreationItem r2, Continuation<? super ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1> r3) {
        this.$this_apply = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProgressLoadingViewModel$handleBlockContentMsgProgress$2$1$2$1(this.$this_apply, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L16:
        Job.DefaultImpls.cancel$default(this.$this_apply, null, 1, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        this.label = 2;
        if (DelayKt.delay(500, this) != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$it, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L13;
        return r0;
    }
}
