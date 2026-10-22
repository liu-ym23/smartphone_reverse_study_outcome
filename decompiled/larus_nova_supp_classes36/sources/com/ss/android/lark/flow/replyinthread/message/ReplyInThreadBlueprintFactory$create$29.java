package com.ss.android.lark.flow.replyinthread.message;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.SysChatGuideContentBlock;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class ReplyInThreadBlueprintFactory$create$29 extends FunctionReferenceImpl implements Function1<g, SysChatGuideContentBlock> {
    public static final ReplyInThreadBlueprintFactory$create$29 INSTANCE = null;

    static {
        INSTANCE = new ReplyInThreadBlueprintFactory$create$29();
    }

    public ReplyInThreadBlueprintFactory$create$29() {
        super(1, SysChatGuideContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
    }

    public final SysChatGuideContentBlock invoke(g r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return new SysChatGuideContentBlock(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
