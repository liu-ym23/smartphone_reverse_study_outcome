package com.ss.android.lark.passport.signinsdk_api.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IAccountInterceptor {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Step {
        public static final int DIRECT = 2;
        public static final int NEXT = 1;
        public static final int STOP = 0;
    }
}
