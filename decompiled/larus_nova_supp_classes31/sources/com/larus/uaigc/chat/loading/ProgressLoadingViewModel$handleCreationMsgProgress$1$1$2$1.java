package com.larus.uaigc.chat.loading;

import com.facebook.datasource.DataSource;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.uaigc.chat.markdown.helper.k0;
import com.tencent.open.log.TraceLevel;
import dp8.e;
import java.util.Map;
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
@DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {401, 404}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map.Entry<String, CreationTask> $it;
    final /* synthetic */ Job $this_apply;
    int label;

    /* JADX INFO: renamed from: com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.chat.loading.ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1$1", f = "ProgressLoadingViewModel.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map.Entry<String, CreationTask> $it;
        int label;

        public AnonymousClass1(Map.Entry<String, CreationTask> r1, Continuation<? super AnonymousClass1> r2) {
            this.$it = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$it, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L30:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            int r12 = k0.a;
            CreationTask r13 = this.$it.getValue();
            if (r13 == null) goto L11;
            CreationAsset r14 = r13.asset;
        L12:
            this.label = 1;
            if (r14 == null) goto L26;
            UserCreationImage r15 = r14.imageContent;
            if (r15 == null) goto L26;
            ImageInfo r16 = r15.a;
            if (r16 == null) goto L26;
            Image r17 = r16.b;
            if (r17 == null) goto L26;
            String r3 = e.b(r17);
            if (r3 == null) goto L26;
            Object r18 = ImageLoaderKt.A(r3, "ProgressLoadingViewModel", null, null, null, this, 60);
            if (r18 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            DataSource r19 = (DataSource) r18;
        L27:
            if (r18 != r0) goto L30;
            return r0;
        L26:
            r18 = Unit.INSTANCE;
            goto L27
        L11:
            r14 = null;
            goto L12
        }
    }

    public ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1(Job r1, Map.Entry<String, CreationTask> r2, Continuation<? super ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1> r3) {
        this.$this_apply = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProgressLoadingViewModel$handleCreationMsgProgress$1$1$2$1(this.$this_apply, this.$it, r4);
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
