package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final Context a;
    public final ReactionListAdapter.a b;
    public final int c;
    public final IRequestCreator d;

    public c(Context r1, ReactionListAdapter.a r2) {
        this.a = r1;
        this.b = r2;
        this.c = v2c.a.a(r1, 48.0f);
        this.d = ImageLoader.with(r1);
    }
}
