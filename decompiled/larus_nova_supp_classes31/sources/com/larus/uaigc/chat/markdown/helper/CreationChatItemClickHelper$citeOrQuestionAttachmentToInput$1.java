package com.larus.uaigc.chat.markdown.helper;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class CreationChatItemClickHelper$citeOrQuestionAttachmentToInput$1 extends FunctionReferenceImpl implements Function1<UplinkFileEntity, UplinkFileEntity> {
    public CreationChatItemClickHelper$citeOrQuestionAttachmentToInput$1(Object r8) {
        super(1, r8, CreationNoWatermarkManager.class, "selectUplinkFileEntity", "selectUplinkFileEntity(Lcom/larus/im/bean/message/UplinkFileEntity;)Lcom/larus/im/bean/message/UplinkFileEntity;", 0);
    }

    public final UplinkFileEntity invoke(UplinkFileEntity r2) {
        return ((CreationNoWatermarkManager) ((CallableReference) this).receiver).e0(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((UplinkFileEntity) r1);
    }
}
