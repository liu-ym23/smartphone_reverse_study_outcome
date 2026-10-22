package com.obric.assistant.component;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$setAvatar$1", f = "OrionInstructionComponent.kt", i = {}, l = {552}, m = "invokeSuspend", n = {}, s = {})
final class OrionInstructionComponent$setAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iconUrl;
    int label;
    final /* synthetic */ OrionInstructionComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.component.OrionInstructionComponent$setAvatar$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$setAvatar$1$1", f = "OrionInstructionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PipelineDraweeControllerBuilder $builder;
        final /* synthetic */ String $iconUrl;
        int label;
        final /* synthetic */ OrionInstructionComponent this$0;

        public AnonymousClass1(OrionInstructionComponent r1, String r2, PipelineDraweeControllerBuilder r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$iconUrl = r2;
            this.$builder = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$iconUrl, this.$builder, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            OrionInstructionComponent r6 = this.this$0;
            int r0 = OrionInstructionComponent.p1;
            TitleAvatarImageView r7 = r6.p3();
            com.larus.image.loader.g r1 = com.larus.image.loader.b0.e("im_fresco_cache");
            String r2 = this.$iconUrl;
            final PipelineDraweeControllerBuilder r3 = this.$builder;
            ImageLoaderKt.w(r7, r2, "chat.bot_avatar", new j7(r3), r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OrionInstructionComponent$setAvatar$1(OrionInstructionComponent r1, String r2, Continuation<? super OrionInstructionComponent$setAvatar$1> r3) {
        this.this$0 = r1;
        this.$iconUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OrionInstructionComponent$setAvatar$1(this.this$0, this.$iconUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder();
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$iconUrl, r9, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
