package com.ss.android.lark.compose.groupinfo;

import com.lark.kmp.logger.LarkLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        LarkLogger r0 = LarkLogger.a;
        LarkLogger.b("FlowGroupInfo", r1);
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        LarkLogger r0 = LarkLogger.a;
        LarkLogger.c("FlowGroupInfo", r1);
    }
}
