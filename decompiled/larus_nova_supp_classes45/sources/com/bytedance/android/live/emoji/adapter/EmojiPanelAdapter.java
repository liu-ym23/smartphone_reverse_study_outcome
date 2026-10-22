package com.bytedance.android.live.emoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.viewholder.BaseEmojiViewHolder;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import t90.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EmojiPanelAdapter extends RecyclerView.Adapter<BaseEmojiViewHolder> {
    public final Context a;
    public final LayoutInflater b;
    public final List<BaseEmoji> c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public a i;

    public final long getItemId(int r3) {
        return r3;
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final int getItemViewType(int r2) {
        return ((BaseEmoji) ListProtector.get(this.c, r2)).getType().ordinal();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseEmojiViewHolder r5 = (BaseEmojiViewHolder) r3;
        BaseEmoji r6 = (BaseEmoji) ListProtector.get(this.c, r4);
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getType() != BaseEmoji.Type.DummyEmoji) goto L8;
        ((RecyclerView.ViewHolder) r5).itemView.setVisibility(4);
        return;
    L8:
        r5.T3(r6);
        a r7 = this.i;
        if (r7 == null) goto L13;
        r5.b = r7;
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        BaseEmojiViewHolder r5 = new BaseEmojiViewHolder(this.b.inflate(2131566341, null));
        ViewGroup.LayoutParams r1 = new ViewGroup.LayoutParams(this.g / this.e, (int) t6.a(this.a, 62.0f));
        ((RecyclerView.ViewHolder) r5).itemView.setLayoutParams(r1);
        return r5;
    }

    public EmojiPanelAdapter(Context r2, int r3, int r4, int r5) {
        this.c = new ArrayList();
        this.a = r2;
        this.b = LayoutInflater.from(r2);
        this.d = r3;
        this.e = r4;
        this.f = r3 * r4;
        this.g = r5;
        this.h = false;
    }
}
