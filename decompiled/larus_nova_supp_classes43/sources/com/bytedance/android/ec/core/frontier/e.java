package com.bytedance.android.ec.core.frontier;

import com.bytedance.common.wschannel.MsgSendListener;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements MsgSendListener {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void onSendResult(WsChannelMsg r10, boolean r11) {
        if (r10 == null) goto L8;
        byte[] r12 = r10.getPayload();
        if (r12 == null) goto L9;
        new String(r12, Charsets.UTF_8);
        return;
    L9:
        return;
    }
}
