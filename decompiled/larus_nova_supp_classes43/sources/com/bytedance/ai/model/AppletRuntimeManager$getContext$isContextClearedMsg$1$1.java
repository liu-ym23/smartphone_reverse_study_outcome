package com.bytedance.ai.model;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$getContext$isContextClearedMsg$1$1", f = "AppletRuntimeManager.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class AppletRuntimeManager$getContext$isContextClearedMsg$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $it;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ai.model.AppletRuntimeManager$getContext$isContextClearedMsg$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$getContext$isContextClearedMsg$1$1$1", f = "AppletRuntimeManager.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $it;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r10) {
            this.$it = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$it, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L16:
            return (Boolean) r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppletRuntimeManager.INSTANCE.getClass();
            g2.b r11 = AppletRuntimeManager.d;
            if (r11 == null) goto L14;
            String r12 = this.$it;
            this.label = 1;
            r10 = r11.G(r12, this);
            if (r10 != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    public AppletRuntimeManager$getContext$isContextClearedMsg$1$1(String r1, Continuation<? super AppletRuntimeManager$getContext$isContextClearedMsg$1$1> r10) {
        this.$it = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletRuntimeManager$getContext$isContextClearedMsg$1$1(this.$it, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.bytedance.ai.infra.thread_pool.a r11 = com.bytedance.ai.infra.thread_pool.b.a;
        AnonymousClass1 r12 = new AnonymousClass1(this.$it, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r11, r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
