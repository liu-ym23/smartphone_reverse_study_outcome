package com.ss.android.lark.chat.core.dependency;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface BrowserDependency {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceType {
        public static final int GROUP_CHAT = 1;
        public static final int P2P_CHAT = 0;
        public static final int THREAD_TOPIC = 2;
        public static final int UNKNOWN = -1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UrlClickType {
        public static final String CARD = "card";
        public static final String INLINE = "inline";
    }

    void a(Context r1, String r2, int r3);

    void b(Context r1, String r2, int r3, Bundle r4);

    void c(Context r1, String r2, int r3);

    void d(Context r1, String r2, int r3, String r4, Bundle r5, Fragment r6, String r7);

    void openUrl(Context r1, String r2);
}
