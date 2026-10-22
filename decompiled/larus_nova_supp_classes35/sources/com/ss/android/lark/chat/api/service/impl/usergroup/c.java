package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.i(r2, "[UserGroup] " + r3);
    }

    public static void a(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Log.e(r2, "[UserGroup] " + r3, r4);
    }
}
