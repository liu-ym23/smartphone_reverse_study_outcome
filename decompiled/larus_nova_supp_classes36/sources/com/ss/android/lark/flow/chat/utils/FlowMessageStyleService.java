package com.ss.android.lark.flow.chat.utils;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.coremd.utils.c;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(c.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/flow/chat/utils/FlowMessageStyleService;", "Lcom/ss/android/lark/coremd/utils/IMessageStyleService;", "<init>", "()V", "applyStyleFromMe", "", "vo", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMessageStyleService implements c {
    public static final int $stable = 0;

    public FlowMessageStyleService() {
    }

    public boolean applyStyleFromMe(a<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        if ((r2 instanceof y6b.c) == false) goto L14;
        y6b.c r3 = (y6b.c) r2;
        if (r3.i == true) goto L7;
    L11:
        return false;
    L7:
        if (r3.N2 == true) goto L11;
        if (r3.getType() == Message.Type.MERGE_FORWARD) goto L11;
        return true;
    L14:
        return r2.h();
    }

    public boolean applyStyleFromMe(Message r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        if (r2.isFromMe() == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.isThreadForwardRootMessage() == true) goto L9;
        if (r2.getType() == Message.Type.MERGE_FORWARD) goto L9;
        return true;
    }
}
