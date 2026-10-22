package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MergeForwardContentBlock;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$20 extends FunctionReferenceImpl implements Function1<g, MergeForwardContentBlock> {
    public static final ReplyInThreadBlueprintFactory$create$20 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$20();
    }

    public ReplyInThreadBlueprintFactory$create$20() {
        super(1, MergeForwardContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    public final MergeForwardContentBlock invoke(g r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return new MergeForwardContentBlock(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
