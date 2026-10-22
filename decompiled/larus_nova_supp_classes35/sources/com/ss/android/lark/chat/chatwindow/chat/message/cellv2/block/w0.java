package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chatwindow.view.preview.UrlPreviewCollapsingHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class w0 implements UrlPreviewCollapsingHelper.c {
    public final /* synthetic */ UrlPreviewBlock a;

    public w0(UrlPreviewBlock r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chatwindow.view.preview.UrlPreviewCollapsingHelper.c
    public final void a(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        ((b3b.f) this.a.d.getValue()).x(r2, r3);
    }
}
