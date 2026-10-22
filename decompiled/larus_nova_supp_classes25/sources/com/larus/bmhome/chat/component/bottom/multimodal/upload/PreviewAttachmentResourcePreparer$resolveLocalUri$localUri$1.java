package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1", f = "PreviewAttachmentResourcePreparer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $path;
    int label;

    public PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1(String r1, UplinkFileEntity r2, Continuation<? super PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1> r3) {
        this.$path = r1;
        this.$entity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreviewAttachmentResourcePreparer$resolveLocalUri$localUri$1(this.$path, this.$entity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Uri> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r7);
        String r8 = this.$path;
        if (r8 == null) goto L20;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r8);
        if (r1.isFile() == true) goto L9;
    L11:
        boolean r9 = false;
    L12:
        if (r9 == true) goto L15;
        r1 = null;
    L15:
        if (r1 != null) goto L17;
        return null;
    L17:
        return PreviewAttachmentResourcePreparer.a(r1, this.$entity);
    L9:
        if (r1.length() <= 0) goto L11;
        r9 = true;
        goto L12
    L20:
        return null;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
