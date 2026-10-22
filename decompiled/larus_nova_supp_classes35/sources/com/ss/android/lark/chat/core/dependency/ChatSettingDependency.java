package com.ss.android.lark.chat.core.dependency;

import aqb.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface ChatSettingDependency {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceToChatSetting {
        public static final int GROUP_NAME_MOBILE = 0;
        public static final int MORE_MOBILE = 1;
    }

    void a(c r1);

    void b();

    void c(q.b r1);
}
