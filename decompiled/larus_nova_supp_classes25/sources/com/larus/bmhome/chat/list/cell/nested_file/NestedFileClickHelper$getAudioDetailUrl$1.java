package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper", f = "NestedFileClickHelper.kt", i = {0, 1, 1}, l = {768, 774, 775, 777}, m = "getAudioDetailUrl", n = {"fileInfo", "fileInfo", "realBotId"}, s = {"L$0", "L$0", "L$1"})
final class NestedFileClickHelper$getAudioDetailUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileClickHelper this$0;

    public NestedFileClickHelper$getAudioDetailUrl$1(NestedFileClickHelper r1, Continuation<? super NestedFileClickHelper$getAudioDetailUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        NestedFileClickHelper r14 = this.this$0;
        r14.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        NestedFileClickHelper$getAudioDetailUrl$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L15;
        if (r4 != 4) goto L14;
        ResultKt.throwOnFailure(r2);
    L53:
        String r5 = (String) r2;
    L46:
        String r6 = r5;
        if (r6 == null) goto L56;
        return r6;
    L56:
        return "";
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r2);
    L45:
        r5 = (String) r2;
        goto L46
    L16:
        String r7 = (String) r0.L$1;
        UplinkFileInfo r8 = (UplinkFileInfo) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L37:
        r5 = (String) r2;
        if (r5 != null) goto L46;
        if (r8 == null) goto L41;
        String r9 = r8.getTosKey();
    L42:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        r2 = r14.c(r7, r9, r0);
        if (r2 != r3) goto L45;
        return r3;
    L41:
        r9 = null;
        goto L42
    L17:
        UplinkFileInfo r10 = (UplinkFileInfo) r0.L$0;
        ResultKt.throwOnFailure(r2);
    L22:
        BotModel r11 = (BotModel) r2;
        if (r11 == null) goto L25;
        String r12 = r11.getBotId();
    L26:
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L47;
        if (r10 == null) goto L32;
        String r15 = r10.getResourceId();
    L33:
        r0.L$0 = r10;
        r0.L$1 = r12;
        r0.label = 2;
        Object r16 = r14.b(r12, r15, r0);
        if (r16 == r3) goto L59;
        UplinkFileInfo r17 = r10;
        r7 = r12;
        r2 = r16;
        r8 = r17;
        goto L37
    L59:
        return r3;
    L32:
        r15 = null;
        goto L33
    L47:
        if (r10 == null) goto L49;
        String r18 = r10.getTosKey();
    L50:
        r0.L$0 = null;
        r0.label = 4;
        r2 = r14.c(r12, r18, r0);
        if (r2 != r3) goto L53;
        return r3;
    L49:
        r18 = null;
        goto L50
    L25:
        r12 = null;
        goto L26
    L18:
        ResultKt.throwOnFailure(r2);
        CompletableDeferred r19 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().getBotByConversationId(null, new g(r19));
        r0.L$0 = null;
        r0.label = 1;
        r2 = r19.await(r0);
        if (r2 == r3) goto L58;
        r10 = null;
        goto L22
    L58:
        return r3;
    L5:
        r0 = new NestedFileClickHelper$getAudioDetailUrl$1(r14, this);
        goto L6
    }
}
