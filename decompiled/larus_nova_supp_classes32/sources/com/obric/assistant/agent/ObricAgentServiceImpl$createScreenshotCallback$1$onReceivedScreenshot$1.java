package com.obric.assistant.agent;

import android.graphics.Bitmap;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.agent.ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshot$1", f = "ObricAgentServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Ref.ObjectRef<Function1<Bitmap, Unit>> $tmpBitmapCallback;
    int label;

    public ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshot$1(Ref.ObjectRef<Function1<Bitmap, Unit>> r1, Bitmap r2, Continuation<? super ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshot$1> r3) {
        this.$tmpBitmapCallback = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshot$1(this.$tmpBitmapCallback, this.$bitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        Function1 r3 = (Function1) this.$tmpBitmapCallback.element;
        if (r3 == null) goto L7;
        r3.invoke(this.$bitmap);
    L7:
        this.$tmpBitmapCallback.element = null;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
