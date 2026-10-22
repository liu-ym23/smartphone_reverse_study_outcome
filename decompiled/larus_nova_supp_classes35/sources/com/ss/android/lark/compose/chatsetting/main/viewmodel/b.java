package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import com.lark.kmp.pb.basic.v1.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final boolean a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.o == true) goto L13;
        Chat.Type r0 = r2.a;
        if (r0 != Chat.Type.P2P) goto L7;
    L12:
        return true;
    L7:
        if (r0 != Chat.Type.GROUP) goto L13;
        if (r2.f == true) goto L12;
        if (r2.g == true) goto L12;
    L13:
        return false;
    }
}
