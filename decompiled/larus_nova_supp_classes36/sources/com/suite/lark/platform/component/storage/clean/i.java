package com.suite.lark.platform.component.storage.clean;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i {
    public static final i a = null;
    public static final i b = null;
    public static final i c = null;

    public static final class a {
    }

    static {
        a = new i("unknown error");
        b = new i("file delete invoke failed!");
        c = new i("io exception occurred");
        new i("rust erase failed");
        new i("clean engine internal error");
        new i("this is a mock error, plz ignore");
    }

    public i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }
}
