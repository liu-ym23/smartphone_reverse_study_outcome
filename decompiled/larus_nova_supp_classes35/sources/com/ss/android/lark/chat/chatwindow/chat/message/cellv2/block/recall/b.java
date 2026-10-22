package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.view.View;
import b3b.d;
import b3b.f;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends OnSingleClickListener {
    public final /* synthetic */ v5b.a<?> a;
    public final /* synthetic */ d b;
    public final /* synthetic */ y6b.a<v5b.a<?>> c;

    public final void onSingleClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if ((this.a instanceof BaseTextContentVO) == false) goto L6;
        this.b.K6(this.c);
        return;
    }

    public b(v5b.a r1, f r2, y6b.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
