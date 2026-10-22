package com.ss.android.lark.chat.entity.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface MeReadType {
    public static final int DOWNLOAD = 3;
    public static final int PLAYED = 2;
    public static final int READ = 1;
    public static final int UN_READ = 0;
}
