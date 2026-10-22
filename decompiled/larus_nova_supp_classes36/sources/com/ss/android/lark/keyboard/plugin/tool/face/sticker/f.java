package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.view.View;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends OnSingleClickListener {
    public final /* synthetic */ Sticker a;
    public final /* synthetic */ FaceNewAdapter b;

    public final void onSingleClick(View r2) {
        final Sticker r3 = this.a;
        RxScheduledExecutor.execInIO(new d(this, r3), new e(this));
    }

    public f(FaceNewAdapter r1, Sticker r2) {
        this.b = r1;
        this.a = r2;
    }
}
