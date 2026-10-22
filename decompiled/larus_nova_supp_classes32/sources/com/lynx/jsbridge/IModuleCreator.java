package com.lynx.jsbridge;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IModuleCreator {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int NORMAL = 0;
        public static final int SHARED = 1;
    }
}
