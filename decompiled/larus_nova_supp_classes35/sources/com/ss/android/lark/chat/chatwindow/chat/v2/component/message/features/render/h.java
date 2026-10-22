package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.WallpaperAdaptionTimeLineDecoration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements WallpaperAdaptionTimeLineDecoration.a {
    public final /* synthetic */ MessageListRendererFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.WallpaperAdaptionTimeLineDecoration.a
    public final m2b.a a() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.a.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return r0.a();
    }

    public h(MessageListRendererFeature r1) {
        this.a = r1;
    }
}
