package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0}, l = {1717, 1718}, m = "invokeSuspend", n = {"uploaderIdentifier", "localMessageId", "uploadLocalPath"}, s = {"L$0", "L$1", "L$2"})
public final class MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ic8.m0 $fileInfo;
    final /* synthetic */ File $localFile;
    final /* synthetic */ String $pipelineIdentifier;
    final /* synthetic */ String $resourceKey;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1(String r1, MultiAttachmentSelectorComponent r2, String r3, File r4, ic8.m0 r5, Continuation<? super MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1> r6) {
        this.$pipelineIdentifier = r1;
        this.this$0 = r2;
        this.$resourceKey = r3;
        this.$localFile = r4;
        this.$fileInfo = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1(this.$pipelineIdentifier, this.this$0, this.$resourceKey, this.$localFile, this.$fileInfo, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r23);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r1 = (String) this.L$2;
        String r2 = (String) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r23);
        String r10 = r1;
        String r12 = r2;
        final String r11 = r3;
        Object r4 = r23;
    L20:
        com.larus.bmhome.resource.access.b0 r13 = (com.larus.bmhome.resource.access.b0) r4;
        MultiAttachmentSelectorComponent r5 = this.this$0;
        Intrinsics.checkNotNull(r10);
        final String r6 = this.$resourceKey;
        final ic8.m0 r9 = this.$fileInfo;
        final MultiAttachmentSelectorComponent r8 = this.this$0;
        Function1 r7 = new k3(r11, r6, r9, r8);
        final String r14 = r11;
        final String r16 = r10;
        final String r17 = r12;
        Function1 r18 = new l3(r14, r6, r9, r8, r16, r17);
        Function1 r19 = new m3(r8, r6);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (MultiAttachmentSelectorComponent.Q5(r5, r10, r6, r11, r12, r9, null, null, r13, r7, r18, r19, this, 96) != r15) goto L24;
        return r15;
    L10:
        ResultKt.throwOnFailure(r23);
        String r20 = this.$pipelineIdentifier;
        if (r20 != null) goto L14;
        StringBuilder r21 = new StringBuilder();
        r21.append(UUID.randomUUID());
        r21.append('_');
        r21.append(System.currentTimeMillis());
        r20 = r21.toString();
    L14:
        if (this.$pipelineIdentifier != null) goto L16;
        this.this$0.w.put(this.$resourceKey, r20);
    L16:
        MultiAttachmentSelectorComponent r22 = this.this$0;
        int r24 = MultiAttachmentSelectorComponent.Z;
        String r25 = r22.h4();
        String r26 = this.$localFile.getAbsolutePath();
        final MultiAttachmentSelectorComponent r27 = this.this$0;
        final String r28 = this.$resourceKey;
        com.larus.utils.t0.e(new j3(r27, r28));
        tx9.l0.d(this.$resourceKey);
        FLogger.a.i("MultiAttachmentSelector", "[submitImageResourceAccess] submitted");
        ResourceCenter r29 = ResourceCenter.a;
        FlowResourceScene r30 = FlowResourceScene.ImageVLM;
        r29.getClass();
        ResourceCenter.k(r20, r30);
        CreationAlbumPipelinePrewarmer r31 = this.this$0.V3();
        this.L$0 = r20;
        this.L$1 = r25;
        this.L$2 = r26;
        this.label = 1;
        r4 = r31.e(r20, this);
        if (r4 != r15) goto L19;
        return r15;
    L19:
        r11 = r20;
        r12 = r25;
        r10 = r26;
        goto L20
    }
}
