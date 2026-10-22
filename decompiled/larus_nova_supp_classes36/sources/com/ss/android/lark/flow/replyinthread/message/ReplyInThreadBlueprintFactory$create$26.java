package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessagePinInfoBlock;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$26 extends FunctionReferenceImpl implements Function1<g, MessagePinInfoBlock> {
    public static final ReplyInThreadBlueprintFactory$create$26 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$26();
    }

    public ReplyInThreadBlueprintFactory$create$26() {
        super(1, MessagePinInfoBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    public final MessagePinInfoBlock invoke(g r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return new MessagePinInfoBlock(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
