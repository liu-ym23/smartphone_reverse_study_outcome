package com.ss.android.lark.chat.chatwindow.biz.plugin.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a extends BaseChatPlugin {
    public a() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final boolean y(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
        return !r2.f.isSecret();
    }
}
