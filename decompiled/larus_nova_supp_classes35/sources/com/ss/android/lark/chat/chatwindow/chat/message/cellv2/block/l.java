package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.image.api.DiskCacheStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public final /* synthetic */ ImageContentBlock a;

    public final com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.c a() {
        ImageContentBlock r0 = this.a;
        r0.getClass();
        if (r0.c.r() == false) goto L5;
    L8:
        Scene r1 = Scene.Thread;
    L10:
        return new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.c(r1, DiskCacheStrategy.ALL);
    L5:
        if (r0.c.q() == true) goto L8;
        r1 = Scene.Chat;
        goto L10
    }

    public l(ImageContentVO r1, ImageContentBlock r2) {
        this.a = r2;
    }
}
