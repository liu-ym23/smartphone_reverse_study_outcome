package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements c<ssb.b.a, BaseEmojiViewHolder> {
    public a() {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, android.view.ViewGroup, com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView] */
    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r6, ssb.a r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "params");
        ?? r1 = new RecentUsedEmojiView(r6, null, 6, 0);
        r1.setItemParams(r7);
        r1.setLayoutParams(new FlexboxLayoutManager.LayoutParams(r7.e, -2));
        return new BaseEmojiViewHolder(r1);
    }
}
