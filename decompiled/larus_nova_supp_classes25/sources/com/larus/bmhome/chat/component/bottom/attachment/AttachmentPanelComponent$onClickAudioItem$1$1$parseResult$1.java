package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.utils.logger.FLogger;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/AudioParseResultData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1", f = "AttachmentPanelComponent.kt", i = {}, l = {3532}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.g>, Object> {
    final /* synthetic */ UplinkFileInfo $fileInfo;
    int label;

    public AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1(UplinkFileInfo r1, Continuation<? super AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1> r2) {
        this.$fileInfo = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1(this.$fileInfo, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L40:
        return (ic8.g) r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger r8 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[onClickAudioItem][AudioParseDebug] fileInfoNull=");
        boolean r4 = false;
        if (this.$fileInfo != null) goto L11;
        boolean r3 = true;
    L12:
        r2.append(r3);
        r2.append(", tosKeyEmpty=");
        UplinkFileInfo r5 = this.$fileInfo;
        if (r5 == null) goto L15;
        String r6 = r5.getTosKey();
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        r2.append(r9);
        r2.append(", tosKeyBlank=");
        UplinkFileInfo r10 = this.$fileInfo;
        if (r10 == null) goto L25;
        String r11 = r10.getTosKey();
    L26:
        if (r11 != null) goto L28;
    L29:
        r4 = true;
    L30:
        r2.append(r4);
        r8.i("AttachmentPanelComponent", r2.toString());
        UplinkFileInfo r12 = this.$fileInfo;
        if (r12 == null) goto L41;
        String r13 = r12.getTosKey();
        if (r13 == null) goto L42;
        String r14 = com.larus.utils.p0.a(r13);
        if (r14 == null) goto L43;
        AttachmentUtil r15 = AttachmentUtil.a;
        List<String> r16 = CollectionsKt.listOf(r14);
        this.label = 1;
        r7 = r15.a(r16, this);
        if (r7 != r0) goto L40;
        return r0;
    L43:
        return null;
    L42:
        return null;
    L41:
        return null;
    L28:
        if (StringsKt.isBlank(r11) == false) goto L30;
    L25:
        r11 = null;
        goto L26
    L18:
        if (r6.length() == 0) goto L21;
        r9 = false;
        goto L22
    L15:
        r6 = null;
        goto L16
    L11:
        r3 = false;
        goto L12
    }
}
