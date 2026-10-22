package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UsernameBlock;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$9 extends FunctionReferenceImpl implements Function1<g, UsernameBlock> {
    public static final ReplyInThreadBlueprintFactory$create$9 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$9();
    }

    public ReplyInThreadBlueprintFactory$create$9() {
        super(1, UsernameBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    public final UsernameBlock invoke(g r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return new UsernameBlock(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
