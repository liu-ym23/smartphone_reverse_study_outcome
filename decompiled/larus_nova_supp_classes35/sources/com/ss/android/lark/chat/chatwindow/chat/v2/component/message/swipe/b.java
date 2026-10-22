package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b {

    public interface a {
        f.a a(RecyclerView.ViewHolder r1, y6b.c r2, int r3);
    }

    Drawable getIcon(Context r1);

    void performAction();
}
