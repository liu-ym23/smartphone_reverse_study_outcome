package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import kotlin.jvm.internal.Intrinsics;
import qsb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements c<ssb.b.C0327b, BaseEmojiViewHolder> {
    public b() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r3, ssb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        View r5 = new View(r3);
        r5.setLayoutParams(new FlexboxLayoutManager.LayoutParams(-1, i.a(8, r3)));
        return new BaseEmojiViewHolder(r5);
    }
}
