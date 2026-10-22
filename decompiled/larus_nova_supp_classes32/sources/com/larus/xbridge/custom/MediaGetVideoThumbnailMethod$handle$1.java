package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$handle$1", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {MessageContentType.FORM_MSG, 54, LynxTouchEvent.kPseudoStateFocus}, m = "invokeSuspend", n = {}, s = {})
final class MediaGetVideoThumbnailMethod$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ String $filePath;
    int label;
    final /* synthetic */ s1 this$0;

    /* JADX INFO: renamed from: com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$handle$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$handle$1$2", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IvyBridgeMethod.a $callback;
        int label;
        final /* synthetic */ s1 this$0;

        public AnonymousClass2(s1 r1, IvyBridgeMethod.a r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$callback, r4);
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
            bx7.c.c(this.this$0, this.$callback, 0, null, 12);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MediaGetVideoThumbnailMethod$handle$1(s1 r1, String r2, IvyBridgeMethod.a r3, Continuation<? super MediaGetVideoThumbnailMethod$handle$1> r4) {
        this.this$0 = r1;
        this.$filePath = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaGetVideoThumbnailMethod$handle$1(this.this$0, this.$filePath, this.$callback, r5);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L24:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        Pair r9 = (Pair) r8;
        if (r9 == null) goto L20;
        s1 r2 = this.this$0;
        IvyBridgeMethod.a r4 = this.$callback;
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        MediaGetVideoThumbnailMethod$handle$1$1$1 r6 = new MediaGetVideoThumbnailMethod$handle$1$1$1(r2, r4, r9, null);
        this.label = 2;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L24;
        return r0;
    L20:
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass2 r3 = new AnonymousClass2(this.this$0, this.$callback, null);
        this.label = 3;
        if (BuildersKt.withContext(r10, r3, this) != r0) goto L24;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        s1 r11 = this.this$0;
        String r7 = this.$filePath;
        this.label = 1;
        r8 = s1.f(r11, r7, this);
        if (r8 != r0) goto L15;
        return r0;
    }
}
