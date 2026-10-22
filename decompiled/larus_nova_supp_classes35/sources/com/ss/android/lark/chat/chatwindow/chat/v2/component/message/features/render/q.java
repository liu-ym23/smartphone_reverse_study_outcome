package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.BannerSettingItemDecoration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements BannerSettingItemDecoration.b {
    public final /* synthetic */ MessageListRendererFeature a;

    public q(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.BannerSettingItemDecoration.b
    public final boolean a() {
        if (MessageListRendererFeature.F(this.a) == true) goto L5;
    L7:
        return false;
    L5:
        if (MessageListRendererFeature.m(this.a) == false) goto L7;
        return true;
    }
}
