package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(y6b.a r1) {
        if ((r1 instanceof y6b.c) == false) goto L9;
        y6b.c r2 = (y6b.c) r1;
        if (r2.Y() == false) goto L7;
    L8:
        return true;
    L7:
        if (r2.Z() == true) goto L8;
    L9:
        return false;
    }
}
