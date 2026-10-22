package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chat.utils.IMRichTextCopyUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements IMRichTextCopyUtils.a {
    public final /* synthetic */ v a;

    @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
    public final void onSuccess() {
        UDToast.show(this.a.a, 2131891640);
    }

    public u(v r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.utils.IMRichTextCopyUtils.a
    public final void onError(Exception r4) {
        if ((r4 instanceof SensitiveAPIException) == false) goto L5;
        UDToast.show(this.a.a, 2131891032);
        boolean r0 = false;
    L6:
        Log.e("TextMessageCopyHandler", "Copy failed", r4, r0);
        return;
    L5:
        r0 = true;
        goto L6
    }
}
