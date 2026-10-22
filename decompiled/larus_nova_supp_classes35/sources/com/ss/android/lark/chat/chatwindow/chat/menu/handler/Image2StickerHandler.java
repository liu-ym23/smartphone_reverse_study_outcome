package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class Image2StickerHandler {
    public final Context a;

    public Image2StickerHandler(Context r1) {
        this.a = r1;
    }

    public final void a(String r3, String r4) {
        ChatCoreModule.a().getStickerDependency().saveImage2Stickers(r3, r4, new AnonymousClass1(this));
    }
}
