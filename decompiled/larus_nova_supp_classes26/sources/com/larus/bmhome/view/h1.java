package com.larus.bmhome.view;

import com.larus.chat.ChatTitleBarIcon;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h1 implements Function1 {
    public /* synthetic */ h1() {
    }

    public final Object invoke(Object r2) {
        ChatTitleBarIcon r3 = (ChatTitleBarIcon) r2;
        int r0 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.name();
    }
}
