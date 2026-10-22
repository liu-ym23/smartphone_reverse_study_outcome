package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$removeAttachmentEntityInternal$2", f = "AttachmentPanelComponent.kt", i = {}, l = {2615}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentPanelComponent$removeAttachmentEntityInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $draftEditedAt;
    final /* synthetic */ UplinkFileEntity $entityToRemove;
    final /* synthetic */ String $fileIdentifier;
    final /* synthetic */ String $localMsgId;
    final /* synthetic */ boolean $removeFromDraft;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$removeAttachmentEntityInternal$2(boolean r1, AttachmentPanelComponent r2, String r3, String r4, Long r5, UplinkFileEntity r6, Continuation<? super AttachmentPanelComponent$removeAttachmentEntityInternal$2> r7) {
        this.$removeFromDraft = r1;
        this.this$0 = r2;
        this.$localMsgId = r3;
        this.$fileIdentifier = r4;
        this.$draftEditedAt = r5;
        this.$entityToRemove = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AttachmentPanelComponent$removeAttachmentEntityInternal$2(this.$removeFromDraft, this.this$0, this.$localMsgId, this.$fileIdentifier, this.$draftEditedAt, this.$entityToRemove, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L57:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (this.$removeFromDraft == false) goto L13;
        AttachmentPanelComponent r9 = this.this$0;
        int r2 = AttachmentPanelComponent.g2;
        j1 r10 = r9.Y3();
        if (r10 == null) goto L13;
        r10.c(this.$localMsgId, this.$fileIdentifier, this.$draftEditedAt);
    L13:
        AttachmentPanelComponent r11 = this.this$0;
        UplinkFileEntity r3 = this.$entityToRemove;
        this.label = 1;
        int r4 = AttachmentPanelComponent.g2;
        r11.getClass();
        if (r3.isHistoryReuse() == false) goto L16;
        Object r12 = Unit.INSTANCE;
    L54:
        if (r12 != r0) goto L57;
        return r0;
    L16:
        Integer r5 = r3.getUpLinkStatus();
        int r6 = UpLinkState.SUCCESS.getValue();
        if (r5 != null) goto L20;
    L21:
        r12 = Unit.INSTANCE;
        goto L54
    L20:
        if (r5.intValue() != r6) goto L21;
        Map r7 = r3.getExtra();
        String r13 = null;
        if (r7 == null) goto L25;
        String r14 = (String) r7.get("disable_remote_delete");
    L27:
        if (Intrinsics.areEqual(r14, "1") == false) goto L29;
        r12 = Unit.INSTANCE;
        goto L54
    L29:
        String r15 = l1.g(r3);
        ResourceCenter r16 = ResourceCenter.a;
        String r17 = r3.getFileIdentifier();
        String r18 = "";
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        r16.getClass();
        if (ResourceCenter.d(r17) == false) goto L41;
        if (r15 != null) goto L36;
        r15 = "";
    L36:
        r12 = r11.Z3(CollectionsKt.listOf(r15), this);
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        r12 = Unit.INSTANCE;
        goto L54
    L41:
        if (n1.d(r3) == false) goto L43;
        String r19 = "image";
    L44:
        Uri r20 = r3.getUri();
        if (r20 == null) goto L47;
        r13 = r20.toString();
    L47:
        if (r13 == null) goto L50;
        r18 = r13;
    L50:
        r12 = r11.a4(CollectionsKt.listOf(new Pair(r18, r19)), this);
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        r12 = Unit.INSTANCE;
        goto L54
    L43:
        r19 = "file";
        goto L44
    L25:
        r14 = null;
        goto L27
    }
}
