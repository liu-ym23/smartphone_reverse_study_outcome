package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public final FragmentActivity a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            a = r0;
            r0[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public g(FragmentActivity r1) {
        this.a = r1;
    }
}
