package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/platform/model/upload/ResourceCenterUploadParam;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mr9.h>, Object> {
    final /* synthetic */ ic8.m0 $fileInfo;
    final /* synthetic */ Pair<Integer, Integer> $imageSize;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $uploadConversationId;
    final /* synthetic */ String $uploaderIdentifier;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1(MultiAttachmentSelectorComponent r1, String r2, String r3, String r4, String r5, ic8.m0 r6, Pair<Integer, Integer> r7, Continuation<? super MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1> r8) {
        this.this$0 = r1;
        this.$uploaderIdentifier = r2;
        this.$localMessageId = r3;
        this.$uploadConversationId = r4;
        this.$localResPath = r5;
        this.$fileInfo = r6;
        this.$imageSize = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1(this.this$0, this.$uploaderIdentifier, this.$localMessageId, this.$uploadConversationId, this.$localResPath, this.$fileInfo, this.$imageSize, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super mr9.h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        MultiAttachmentSelectorComponent r1 = this.this$0;
        String r2 = this.$uploaderIdentifier;
        String r3 = this.$localMessageId;
        String r4 = this.$uploadConversationId;
        String r5 = this.$localResPath;
        ic8.m0 r6 = this.$fileInfo;
        Pair<Integer, Integer> r7 = this.$imageSize;
        int r10 = MultiAttachmentSelectorComponent.Z;
        return r1.D3(r2, r3, r4, r5, r6, r7);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
