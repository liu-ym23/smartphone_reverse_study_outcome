package com.ss.android.lark.chat.export.entity.translate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface TranslateDisplayRule {
    public static final int NOT_TRANSLATE = 1;
    public static final int ONLY_TRANSLATION = 2;
    public static final int UNKNOWN_RULE = 0;
    public static final int WITH_ORIGINAL = 3;
}
