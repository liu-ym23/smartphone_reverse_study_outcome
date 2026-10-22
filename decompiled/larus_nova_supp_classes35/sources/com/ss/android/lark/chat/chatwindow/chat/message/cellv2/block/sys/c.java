package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements g<Object, Object> {
    public final /* synthetic */ AppCompatImageView a;

    public c(AppCompatImageView r1) {
        this.a = r1;
    }

    public final boolean onLoadFailed(Exception r1, Object r2, Target<Object> r3, boolean r4) {
        this.a.setVisibility(8);
        return true;
    }

    public final boolean onResourceReady(Object r1, Object r2, Target<Object> r3, DataSource r4, boolean r5) {
        this.a.setVisibility(0);
        return false;
    }
}
