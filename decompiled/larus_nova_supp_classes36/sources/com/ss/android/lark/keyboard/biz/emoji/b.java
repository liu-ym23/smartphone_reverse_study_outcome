package com.ss.android.lark.keyboard.biz.emoji;

import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void b(AppCompatImageView r13, com.ss.android.lark.keyboard.plugin.tool.face.d r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r14, "stickerFileInfo");
        c r15 = this.a;
        com.ss.android.lark.keyboard.b r0 = r15.c.b;
        if (r0 == null) goto L8;
        String r1 = com.ss.android.lark.keyboard.a.d(r0);
        String r2 = com.ss.android.lark.keyboard.a.b(r0);
        PartialReplyInfo r3 = com.ss.android.lark.keyboard.a.c(r0);
        StickerFileInfo r11 = new StickerFileInfo(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.g);
        KeyboardViewModel r16 = j2b.d.a(r15.c);
        if (r16 == null) goto L9;
        r16.sendStickerMsg(r11, r1, r2, r3);
        return;
    L9:
        return;
    }
}
