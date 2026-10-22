package com.ss.android.lark.flow.chat.file;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mya.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements n {
    public final Function1<String, Message> a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super String, ? extends Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageProvider");
        this.a = r2;
    }

    public final void n(String r4, FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Message r0 = (Message) this.a.invoke(r4);
        if (r0 != null) goto L11;
        MessageInfo r1 = ImSdkService.f().p(r4);
        if (r1 == null) goto L7;
        r0 = r1.getMessage();
    L8:
        if (r0 != null) goto L11;
        Log.e("FlowFolderActionHandler", "onFolderClick, message not found: " + r4);
        return;
    L7:
        r0 = null;
    L11:
        int r6 = FlowChatModule.d;
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r5, "https://applink.feishu.cn/client/chat/open?chatId=" + r0.getChatId() + "&position=" + r0.getPosition());
    }
}
