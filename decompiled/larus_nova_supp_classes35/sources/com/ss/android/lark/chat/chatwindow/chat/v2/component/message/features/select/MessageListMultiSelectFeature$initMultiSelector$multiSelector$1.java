package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.a;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e4b.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w4b.u;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/ss/android/lark/chat/chatwindow/chat/v2/component/message/features/select/MessageListMultiSelectFeature$initMultiSelector$multiSelector$1", "Lcom/ss/android/lark/widget/recyclerview/MultiSelector;", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "Lcom/ss/android/lark/chat/chatwindow/chat/IChatAdapter;", "isItemSelectable", BuildConfig.FLAVOR, "item", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 extends MultiSelector<c<?>, a> {
    public final /* synthetic */ b f;

    public final boolean b(Object r5) {
        c r6 = (c) r5;
        Intrinsics.checkNotNullParameter(r6, "item");
        ValidateIMFileResult r0 = r6.F;
        if (r0 == null) goto L5;
        IMFileResult r1 = r0.getResultType();
    L7:
        if (r1 != null) goto L9;
        u r2 = MessagePermissionUtil.a;
        boolean r3 = false;
    L11:
        if (((MultiSelector) this).d == false) goto L14;
        if (r3 == true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L18;
        return false;
    L18:
        if (this.f.b != ListMode.SELECT_MESSAGES_FOR_CALLER) goto L40;
        if (r6.isPreMessage() == false) goto L22;
    L36:
        boolean r7 = false;
    L37:
        if (r7 == false) goto L40;
    L43:
        return true;
    L22:
        if (r6.j() == true) goto L36;
        if (r6.G != null) goto L36;
        if (r6.y == true) goto L36;
        if (r6.z == true) goto L36;
        if (r6.getType() == Message.Type.SYSTEM) goto L36;
        if (r6.getType() == Message.Type.RED_PACKET) goto L36;
        if (r6.getType() == Message.Type.UNKNOWN) goto L36;
        r7 = true;
    L40:
        if (this.f.b == ListMode.MULTI_SELECT) goto L42;
        return false;
    L42:
        if (r6.X() == true) goto L43;
        return false;
    L14:
        r4 = false;
        goto L15
    L9:
        r3 = MessagePermissionUtil.g(MessagePermissionUtil.h(r1));
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public MessageListMultiSelectFeature$initMultiSelector$multiSelector$1(a r1, b r2) {
        this.f = r2;
        super(r1);
    }
}
