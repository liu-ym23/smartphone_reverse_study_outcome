package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.SingleEmojiView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements c<ssb.b.c, BaseEmojiViewHolder> {
    public RecyclerView a;
    public d b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r2, ssb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        SingleEmojiView r0 = new SingleEmojiView(r2);
        r0.b(r3);
        return new BaseEmojiViewHolder(r0);
    }
}
