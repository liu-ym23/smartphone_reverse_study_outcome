package com.ss.android.lark.integrator.im.impl;

import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.integrator.im.impl.ChatPreviewApiImpl$getPreviewByHangPoints$1", f = "ChatPreviewApiImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class ChatPreviewApiImpl$getPreviewByHangPoints$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Map<String, UrlCardPreviewEntity>> $callback;
    final /* synthetic */ w4b.f $dependency;
    final /* synthetic */ List<PreviewHangPoint> $hangPoints;
    int label;

    public ChatPreviewApiImpl$getPreviewByHangPoints$1(w4b.f r1, List<PreviewHangPoint> r2, IGetDataCallback<Map<String, UrlCardPreviewEntity>> r3, Continuation<? super ChatPreviewApiImpl$getPreviewByHangPoints$1> r4) {
        this.$dependency = r1;
        this.$hangPoints = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatPreviewApiImpl$getPreviewByHangPoints$1(this.$dependency, this.$hangPoints, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        IGetDataCallback<Map<String, UrlCardPreviewEntity>> r2 = this.$callback;
        r2.onSuccess((Map) r4);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        w4b.f r5 = this.$dependency;
        List<PreviewHangPoint> r3 = this.$hangPoints;
        this.label = 1;
        r4 = r5.a(r3, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
