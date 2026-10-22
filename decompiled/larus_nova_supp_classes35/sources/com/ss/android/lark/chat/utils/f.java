package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final CopyOnWriteArraySet<String> a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Message.Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new CopyOnWriteArraySet();
    }
}
