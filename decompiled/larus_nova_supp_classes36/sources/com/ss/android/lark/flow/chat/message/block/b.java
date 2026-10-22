package com.ss.android.lark.flow.chat.message.block;

import android.view.View;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FileView.c a;
    public final /* synthetic */ FileView.b b;

    public b(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.a.b r1, FileView.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.c(this.b);
    }
}
