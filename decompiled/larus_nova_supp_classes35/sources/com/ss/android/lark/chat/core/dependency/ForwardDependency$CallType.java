package com.ss.android.lark.chat.core.dependency;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ForwardDependency$CallType {
    public static final String CLICK = "click";
    public static final String QUICK_CLICK = "quick_click";
    public static final String SHORTCUT = "shortcutkey";
    public static final String TOPIC_CLICK = "topic_click";
}
