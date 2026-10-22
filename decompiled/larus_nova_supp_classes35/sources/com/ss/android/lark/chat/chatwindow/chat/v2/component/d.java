package com.ss.android.lark.chat.chatwindow.chat.v2.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "modelClass");
        String r2 = r1.getCanonicalName();
        if (r2 == null) goto L7;
        return "androidx.lifecycle.ViewModelProvider.DefaultKey0".concat(r2);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
