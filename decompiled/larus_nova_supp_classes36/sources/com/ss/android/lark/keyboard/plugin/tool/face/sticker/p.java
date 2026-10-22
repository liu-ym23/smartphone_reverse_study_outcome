package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p extends OnSingleClickListener {
    public final /* synthetic */ Sticker a;
    public final /* synthetic */ StickerPageAdapter b;

    public final void onSingleClick(View r2) {
        final Sticker r3 = this.a;
        RxScheduledExecutor.execInIO(new n(this, r3), new o(this));
    }

    public p(StickerPageAdapter r1, Sticker r2) {
        this.b = r1;
        this.a = r2;
    }
}
