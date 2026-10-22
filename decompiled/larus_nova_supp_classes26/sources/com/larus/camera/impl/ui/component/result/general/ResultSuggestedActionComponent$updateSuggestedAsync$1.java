package com.larus.camera.impl.ui.component.result.general;

import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$updateSuggestedAsync$1", f = "ResultSuggestedActionComponent.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
final class ResultSuggestedActionComponent$updateSuggestedAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizScene;
    final /* synthetic */ String $cameraScene;
    final /* synthetic */ boolean $deleteWhenContainsVideo;
    final /* synthetic */ Object $result;
    final /* synthetic */ int $updateVersion;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$updateSuggestedAsync$1(int r1, ResultSuggestedActionComponent r2, Object r3, boolean r4, String r5, String r6, Continuation<? super ResultSuggestedActionComponent$updateSuggestedAsync$1> r7) {
        this.$updateVersion = r1;
        this.this$0 = r2;
        this.$result = r3;
        this.$deleteWhenContainsVideo = r4;
        this.$bizScene = r5;
        this.$cameraScene = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ResultSuggestedActionComponent$updateSuggestedAsync$1(this.$updateVersion, this.this$0, this.$result, this.$deleteWhenContainsVideo, this.$bizScene, this.$cameraScene, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L20:
        List<SuggestedAction> r6 = (List) r5;
        if (r6 != null) goto L29;
    L22:
        r6 = CollectionsKt.emptyList();
    L29:
        int r2 = this.$updateVersion;
        ResultSuggestedActionComponent r3 = this.this$0;
        if (r2 != r3.s) goto L32;
        r3.n = r3.s(r6);
        ResultSuggestedActionComponent r7 = this.this$0;
        List<SuggestedActionBar.c> r8 = r7.r(r7.n);
        if (((ArrayList) r8).isEmpty() == false) goto L36;
        FLogger.a.i("ResultSuggestedActionComponent", "updateSuggestedActionInfo, barItems is empty");
        com.larus.utils.e1.o(this.this$0.t());
    L41:
        return Unit.INSTANCE;
    L36:
        FLogger.a.i("ResultSuggestedActionComponent", "updateSuggestedActionInfo, barItems is not empty deleteWhenContainsVideo" + this.$deleteWhenContainsVideo);
        if (this.$deleteWhenContainsVideo == false) goto L39;
        this.this$0.w(false);
    L39:
        this.this$0.q(r8, this.$bizScene, this.$cameraScene);
        goto L41
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$updateVersion != this.this$0.s) goto L11;
        Object r9 = this.$result;
        boolean r4 = r9 instanceof Deferred;
        List<SuggestedAction> r10 = null;
        if (r4 == false) goto L24;
        if (r4 == false) goto L16;
        r10 = (Deferred) r9;
    L16:
        if (r10 == null) goto L22;
        this.label = 1;
        r5 = r10.await(this);
        if (r5 != r0) goto L20;
        return r0;
    L24:
        if ((r9 instanceof List) == false) goto L26;
        r10 = (List) r9;
    L26:
        if (r10 != null) goto L28;
        r6 = CollectionsKt.emptyList();
        goto L29
    L28:
        r6 = r10;
        goto L29
    L11:
        return Unit.INSTANCE;
    }
}
