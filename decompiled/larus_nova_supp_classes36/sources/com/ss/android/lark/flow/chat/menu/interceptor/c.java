package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements yya.c {
    public static final Set<MessageActionType> b = null;
    public static final Set<PageType> c = null;
    public final Function0<Boolean> a;

    public static final class a {
    }

    public final String getTAG() {
        return "DoubaoChatSettingActionInterceptor";
    }

    static {
        b = SetsKt.setOf(new MessageActionType[]{MessageActionType.FLOW_ASK_DOUBAO, MessageActionType.FOLLOW_UP_QUESTION, MessageActionType.WORDS_ASK_DOUBAO});
        c = SetsKt.setOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD});
    }

    public c() {
        DoubaoChatSettingActionInterceptor$1 r0 = DoubaoChatSettingActionInterceptor$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "enterpriseAccountProvider");
        this.a = r0;
    }

    public final boolean a(MessageActionType r5, yya.a r6) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        boolean r0 = false;
        if (b.contains(r5) == true) goto L6;
        return false;
    L6:
        if (c.contains(r6.r()) == true) goto L9;
        return false;
    L9:
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L12;
        Log.d("DoubaoChatSettingAction", "intercept Ask Doubao action for enterprise account");
        return true;
    L12:
        Chat r7 = r6.getChat();
        if (r7 != null) goto L15;
        return false;
    L15:
        boolean r8 = r7.getDoubaoSetting().isDoubaoUsingEnabled();
        int r3 = com.ss.android.lark.biz.im.api.h.a;
        if (r8 == false) goto L18;
        r0 = true;
    L18:
        boolean r9 = !r0;
        if (r9 == false) goto L21;
        Log.d("DoubaoChatSettingAction", "intercept Ask Doubao action, pageType=" + r6.r());
    L21:
        return r9;
    }
}
