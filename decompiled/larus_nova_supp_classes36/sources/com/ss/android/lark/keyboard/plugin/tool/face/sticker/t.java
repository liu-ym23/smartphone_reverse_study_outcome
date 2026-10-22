package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class t implements StickerPageAdapter.c {
    public final /* synthetic */ StickerPageFragment a;

    public /* synthetic */ t(StickerPageFragment r1) {
        this.a = r1;
    }

    public final void a(Context r1, int r2, int r3, String r4, ImageView r5, int r6, String r7) {
        StickerPageFragment r8 = this.a;
        int r9 = StickerPageFragment.s;
        WeakReference<k> r10 = r8.h;
        if (r10 != null) goto L5;
        k r11 = null;
    L6:
        if (r11 == null) goto L10;
        r11.c();
        return;
    L10:
        return;
    L5:
        r11 = r10.get();
        goto L6
    }
}
