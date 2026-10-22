package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/chat/entity/message/SendStatus;", "invoke", "(Lcom/ss/android/lark/chat/entity/message/SendStatus;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1 extends Lambda implements Function1<SendStatus, Boolean> {
    public static final FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1 INSTANCE = null;

    static {
        INSTANCE = new FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1();
    }

    public FlowThreadWindowMediaRootStateHandler$patchLoadedMediaRoot$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((SendStatus) r1);
    }

    public final Boolean invoke(SendStatus r1) {
        return Boolean.TRUE;
    }
}
