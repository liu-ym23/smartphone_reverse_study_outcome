package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(y6b.a r1, m2b.a r2, g3b.v r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ChatCoreModule.a().canShowSingleUrlCard(r1, r2, r3);
    }
}
