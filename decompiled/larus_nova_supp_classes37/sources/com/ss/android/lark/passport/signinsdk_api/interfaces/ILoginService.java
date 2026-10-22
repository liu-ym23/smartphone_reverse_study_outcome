package com.ss.android.lark.passport.signinsdk_api.interfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface ILoginService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoginSource {
        public static final int EXTERNAL = 1;
        public static final int USER = 0;
    }
}
