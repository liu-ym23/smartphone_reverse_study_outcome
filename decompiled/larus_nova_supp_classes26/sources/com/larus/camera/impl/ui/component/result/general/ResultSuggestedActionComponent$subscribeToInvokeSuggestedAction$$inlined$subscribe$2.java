package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/larus/camera/impl/utils/eventbus/Event;", "it", "com/larus/camera/impl/utils/eventbus/CameraEventBus$subscribe$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2 extends SuspendLambda implements Function2<com.larus.camera.impl.utils.eventbus.j, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2(Continuation r1, ResultSuggestedActionComponent r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2 r0 = new ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2(r4, this.this$0);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.camera.impl.utils.eventbus.j r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.camera.impl.utils.eventbus.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r6);
        com.larus.camera.impl.utils.eventbus.j r7 = (com.larus.camera.impl.utils.eventbus.j) ((com.larus.camera.impl.utils.eventbus.g) this.L$0);
        FLogger.a.i("ResultSuggestedActionComponent", "[subscribe] received " + r7);
        ResultSuggestedActionComponent r0 = this.this$0;
        String r8 = r7.a;
        Iterator<T> r1 = r0.n.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(r8, ((SuggestedAction) r2).getSuggestedActionKey()) == false) goto L6;
    L11:
        SuggestedAction r3 = (SuggestedAction) r2;
        if (r3 == null) goto L24;
        final CameraResultViewModel r4 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r0.e.getValue()).a();
        if (r4 == null) goto L24;
        final ex8.b r5 = r0.u();
        if (r5 == null) goto L24;
        if (Intrinsics.areEqual(r8, SuggestedActionKey.AIBeautify.getValue()) == false) goto L22;
        r4.getParamAlbumUrlOrBitmapPath(new x(r4, r5));
        goto L24
    L22:
        r5.a("from_icon", 3, r3);
        CameraResultViewModel.onComplete$default(r4, null, "suggest_invokeSuggestedActionByKey", 1, null);
    L24:
        return Unit.INSTANCE;
    L10:
        r2 = null;
        goto L11
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
