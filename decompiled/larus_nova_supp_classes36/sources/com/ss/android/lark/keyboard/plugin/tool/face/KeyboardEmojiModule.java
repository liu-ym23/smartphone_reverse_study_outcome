package com.ss.android.lark.keyboard.plugin.tool.face;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardEmojiModule {
    public static final Lazy a = null;

    public interface a {
        int getFileUploadAuthorizatedDenyCode();

        int getFileUploadAuthorizatedDenyCodeByFilePolicy();

        String getUploadAuthorizationTip();

        void onAuthorizatedDeny(Context r1, String r2);
    }

    static {
        a = LazyKt.lazy(KeyboardEmojiModule$dependency$2.INSTANCE);
    }
}
