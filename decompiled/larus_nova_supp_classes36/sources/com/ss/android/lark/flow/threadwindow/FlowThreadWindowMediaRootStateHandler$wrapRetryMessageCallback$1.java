package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class FlowThreadWindowMediaRootStateHandler$wrapRetryMessageCallback$1 extends FunctionReferenceImpl implements Function1<Message, Unit> {
    public FlowThreadWindowMediaRootStateHandler$wrapRetryMessageCallback$1(Object r8) {
        super(1, r8, FlowThreadWindowMediaRootStateHandler.class, "patchRetryMediaRoot", "patchRetryMediaRoot(Lcom/ss/android/lark/chat/entity/message/Message;)V", 0);
    }

    public final void invoke(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        FlowThreadWindowMediaRootStateHandler.b((FlowThreadWindowMediaRootStateHandler) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Message) r1);
        return Unit.INSTANCE;
    }
}
