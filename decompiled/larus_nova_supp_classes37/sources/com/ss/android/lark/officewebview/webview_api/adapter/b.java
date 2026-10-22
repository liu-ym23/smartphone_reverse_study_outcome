package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.webview_api.bridge.Status;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Status.values().length];
        r0[Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r0[Status.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r0[Status.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r0[Status.TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r0[Status.PROGRESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        a = r0;
    }
}
