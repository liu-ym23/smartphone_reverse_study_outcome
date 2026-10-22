package com.larus.bmhome.chat.camera.command;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.camera.command.CameraSuggestedActionDataController$getSuggestedAction$1", f = "CameraSuggestedActionDataController.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class CameraSuggestedActionDataController$getSuggestedAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizScene;
    final /* synthetic */ Function1<List<SuggestedAction>, Unit> $callback;
    final /* synthetic */ SuggestedActionScene $scene;
    final /* synthetic */ String $singleAttachmentFileMimeType;
    final /* synthetic */ boolean $useDraft;
    int label;
    final /* synthetic */ CameraSuggestedActionDataController this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSuggestedActionDataController$getSuggestedAction$1(CameraSuggestedActionDataController r1, SuggestedActionScene r2, String r3, boolean r4, String r5, Function1<? super List<SuggestedAction>, Unit> r6, Continuation<? super CameraSuggestedActionDataController$getSuggestedAction$1> r7) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$bizScene = r3;
        this.$useDraft = r4;
        this.$singleAttachmentFileMimeType = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CameraSuggestedActionDataController$getSuggestedAction$1(this.this$0, this.$scene, this.$bizScene, this.$useDraft, this.$singleAttachmentFileMimeType, this.$callback, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        SuggestedActionData r8 = (SuggestedActionData) r7;
        if (r8 != null) goto L14;
        CameraSuggestedActionDataController r9 = this.this$0;
        SuggestedActionScene r2 = this.$scene;
        int r3 = CameraSuggestedActionDataController.h;
        r8 = r9.e(r2);
    L14:
        SuggestedActionData r4 = r8;
        int r10 = m.a;
        List r11 = m.a(r4, this.$scene, this.this$0.g(this.$bizScene, this.$useDraft), ((Boolean) this.this$0.b.a.invoke()).booleanValue(), this.this$0.e, this.$singleAttachmentFileMimeType);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("getSuggestedAction[");
        r6.append(this.$scene);
        r6.append("], bizScene=");
        r6.append(this.$bizScene);
        r6.append(", bot=");
        r6.append(this.this$0.f());
        r6.append(", resultSize=");
        if (r11 == null) goto L17;
        Integer r12 = Boxing.boxInt(r11.size());
    L18:
        r6.append(r12);
        r5.i("CameraSuggestedActionDataController", r6.toString());
        this.$callback.invoke(r11);
        return Unit.INSTANCE;
    L17:
        r12 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CompletableDeferred<SuggestedActionData> r13 = this.this$0.c;
        this.label = 1;
        r7 = r13.await(this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
