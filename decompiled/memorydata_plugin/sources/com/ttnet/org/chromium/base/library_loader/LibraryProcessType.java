package com.ttnet.org.chromium.base.library_loader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes6.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LibraryProcessType {
    public static final int PROCESS_BROWSER = 1;
    public static final int PROCESS_CHILD = 2;
    public static final int PROCESS_UNINITIALIZED = 0;
    public static final int PROCESS_WEBLAYER = 5;
    public static final int PROCESS_WEBLAYER_CHILD = 6;
    public static final int PROCESS_WEBVIEW = 3;
    public static final int PROCESS_WEBVIEW_CHILD = 4;
    public static final int PROCESS_WEBVIEW_NONEMBEDDED = 7;
}
