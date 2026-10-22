package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$tryOpenAttachmentPreview$1", f = "AttachmentPanelComponent.kt", i = {0}, l = {3657}, m = "invokeSuspend", n = {"token"}, s = {"L$1"})
public final class AttachmentPanelComponent$tryOpenAttachmentPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ownerId;
    final /* synthetic */ String $selectedKey;
    final /* synthetic */ String $selectedToken;
    final /* synthetic */ List<UplinkFileEntity> $unresolvedImages;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    public AttachmentPanelComponent$tryOpenAttachmentPreview$1(List<UplinkFileEntity> r1, AttachmentPanelComponent r2, String r3, String r4, String r5, Continuation<? super AttachmentPanelComponent$tryOpenAttachmentPreview$1> r6) {
        this.$unresolvedImages = r1;
        this.this$0 = r2;
        this.$ownerId = r3;
        this.$selectedKey = r4;
        this.$selectedToken = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AttachmentPanelComponent$tryOpenAttachmentPreview$1(this.$unresolvedImages, this.this$0, this.$ownerId, this.$selectedKey, this.$selectedToken, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0062 -> B:68:0x0068). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r6 = null;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        String r2 = (String) this.L$1;
        Iterator<UplinkFileEntity> r7 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L60 CancellationException -> L64
        Iterator<UplinkFileEntity> r8 = r7;
        String r9 = r2;
        Object r3 = r0;
        AttachmentPanelComponent$tryOpenAttachmentPreview$1 r4 = this;
    L68:
        String r13 = (String) r12;     // Catch: Exception -> L35 CancellationException -> L64
        if (r13 != null) goto L27;
    L29:
        r13 = null;
    L30:
        if (r13 != null) goto L33;
        FLogger.a.w("AttachmentPanelComponent", "Attachment preview image URL resolution returned empty");     // Catch: Exception -> L35 CancellationException -> L64
        t19.s.a.g(r4.this$0.getContext(), 2131907052, false);     // Catch: Exception -> L35 CancellationException -> L64
        return Unit.INSTANCE;
    L33:
        r4.this$0.Z.put(r9, r13);     // Catch: Exception -> L35 CancellationException -> L64
        AttachmentPanelComponent$tryOpenAttachmentPreview$1 r14 = r4;
        r0 = r3;
        Iterator<UplinkFileEntity> r10 = r8;
    L66:
    L58:
        e = move-exception;
        r4 = r14;
        e = e;
    L62:
        FLogger.a.e("AttachmentPanelComponent", "Attachment preview image URL resolution failed", e);
        t19.s.a.g(r4.this$0.getContext(), 2131907052, false);
        return Unit.INSTANCE;
    L14:
        if (r10.hasNext() == false) goto L37;
        Image r5 = l1.c(r10.next());     // Catch: Exception -> L58 CancellationException -> L64
        if (r5 == null) goto L66;
        String r11 = r5.key;     // Catch: Exception -> L58 CancellationException -> L64
        if (r11 == null) goto L66;
        CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Exception -> L58 CancellationException -> L64
        AttachmentPanelComponent$tryOpenAttachmentPreview$1$url$1 r16 = new AttachmentPanelComponent$tryOpenAttachmentPreview$1$url$1(r11, null);     // Catch: Exception -> L58 CancellationException -> L64
        r14.L$0 = r10;     // Catch: Exception -> L58 CancellationException -> L64
        r14.L$1 = r11;     // Catch: Exception -> L58 CancellationException -> L64
        r14.label = 1;     // Catch: Exception -> L58 CancellationException -> L64
        Object r17 = BuildersKt.withContext(r15, r16, r14);     // Catch: Exception -> L58 CancellationException -> L64
        if (r17 != r0) goto L23;
        return r0;
    L23:
        Object r18 = r0;
        r4 = r14;
        r12 = r17;
        r8 = r10;
        r9 = r11;
        r3 = r18;
        goto L68
    L37:
        AttachmentPanelComponent r19 = r14.this$0;
        r19.k0 = null;
        List<UplinkFileEntity> r20 = r19.J;
        String r21 = r14.$selectedKey;
        String r22 = r14.$selectedToken;
        Iterator<T> r23 = r20.iterator();
    L39:
        if (r23.hasNext() == false) goto L52;
        Object r24 = r23.next();
        UplinkFileEntity r25 = (UplinkFileEntity) r24;
        if (Intrinsics.areEqual(r25.getFileIdentifier(), r21) == false) goto L49;
        Image r26 = l1.c(r25);
        if (r26 == null) goto L45;
        String r27 = r26.key;
    L47:
        if (Intrinsics.areEqual(r27, r22) == false) goto L49;
        boolean r28 = true;
    L50:
        if (r28 == false) goto L39;
        r6 = r24;
        goto L52
    L45:
        r27 = null;
    L49:
        r28 = false;
    L52:
        UplinkFileEntity r29 = (UplinkFileEntity) r6;
        if (Intrinsics.areEqual(r14.this$0.P, r14.$ownerId) == false) goto L57;
        if (r29 == null) goto L57;
        r14.this$0.u6(r29);
    L57:
        return Unit.INSTANCE;
    L27:
        if ((!StringsKt.isBlank(r13)) == false) goto L29;
    L35:
        e = e;
        goto L62
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
        r10 = this.$unresolvedImages.iterator();     // Catch: Exception -> L60 CancellationException -> L64
        r14 = this;
    L64:
        e = move-exception;
        throw e;
    L60:
        e = e;
        r4 = this;
        goto L62
    }
}
