package com.larus.bmhome.view;

import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.ChatTitleAlignLeftStyle$setAvatar$1", f = "ChatTitleAlignLeftStyle.kt", i = {}, l = {964}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleAlignLeftStyle$setAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $iconUrl;
    int label;
    final /* synthetic */ ChatTitleAlignLeftStyle this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.ChatTitleAlignLeftStyle$setAvatar$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.ChatTitleAlignLeftStyle$setAvatar$1$1", f = "ChatTitleAlignLeftStyle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PipelineDraweeControllerBuilder $builder;
        final /* synthetic */ String $iconUrl;
        int label;
        final /* synthetic */ ChatTitleAlignLeftStyle this$0;

        public AnonymousClass1(ChatTitleAlignLeftStyle r1, String r2, PipelineDraweeControllerBuilder r3, Continuation<? super AnonymousClass1> r4) {
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

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            ChatTitleAlignLeftStyle r5 = this.this$0;
            String r0 = this.$iconUrl;
            PipelineDraweeControllerBuilder r1 = this.$builder;
            Intrinsics.checkNotNull(r1);
            int r2 = ChatTitleAlignLeftStyle.T;
            r5.u6(r0, r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatTitleAlignLeftStyle$setAvatar$1(ChatTitleAlignLeftStyle r1, String r2, Continuation<? super ChatTitleAlignLeftStyle$setAvatar$1> r3) {
        this.this$0 = r1;
        this.$iconUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleAlignLeftStyle$setAvatar$1(this.this$0, this.$iconUrl, r4);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (Fresco.hasBeenInitialized() == true) goto L12;
        FLogger.a.e("tts_isGray", "fresco not init");
        EnsureManager.ensureNotReachHere("fresco not init");
        return Unit.INSTANCE;
    L12:
        PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder();
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$iconUrl, r9, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L16;
        return r0;
    }
}
