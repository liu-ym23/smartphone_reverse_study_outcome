package com.larus.camera.impl.ui.viewmodel;

import com.larus.camera.api.params.OutputParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/camera/api/params/OutputParam;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2", f = "CameraResultViewModel.kt", i = {}, l = {1555}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2 extends SuspendLambda implements Function1<Continuation<? super List<OutputParam>>, Object> {
    final /* synthetic */ CoroutineScope $$this$launch;
    final /* synthetic */ List<OutputParam> $previewOutputParamList;
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    public CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2(List<OutputParam> r1, CoroutineScope r2, CameraResultViewModel r3, Continuation<? super CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2> r4) {
        this.$previewOutputParamList = r1;
        this.$$this$launch = r2;
        this.this$0 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2(this.$previewOutputParamList, this.$$this$launch, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super List<OutputParam>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L16:
        return CollectionsKt.toMutableList((Collection) r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        List<OutputParam> r13 = this.$previewOutputParamList;
        CoroutineScope r2 = this.$$this$launch;
        CameraResultViewModel r9 = this.this$0;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r10.add(BuildersKt.async$default(r2, null, null, new CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2$deferredSavedOutputParams$1$1(r9, (OutputParam) r14.next(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r12 = AwaitKt.a(r10, this);
        if (r12 != r0) goto L16;
        return r0;
    }
}
