package com.ss.android.lark.flow.chat.message.layout;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;

    static {
        a = UIHelper.dp2px(7.0f);
        b = UIHelper.dp2px(2.0f);
        c = UIHelper.dp2px(12.0f);
    }

    public static int a(m2b.a r1) {
        if (r1.e0() == true) goto L9;
        if (r1.getChat() == null) goto L9;
        return c;
    L9:
        return a;
    }
}
