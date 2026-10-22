package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h extends OnSingleClickListener {
    public final /* synthetic */ HashTagSwipeAdapter a;
    public final /* synthetic */ oy7.e b;

    public final void onSingleClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.c.b(this.b);
    }

    public h(HashTagSwipeAdapter r1, int r2, oy7.e r3) {
        this.a = r1;
        this.b = r3;
    }
}
