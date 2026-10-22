package com.bytedance.android.live.emoji.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.emoji.SelfEmoji;
import com.bytedance.android.live.emoji.viewholder.SelfEmojiViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SelfEmojiPanelAdapter extends RecyclerView.Adapter<SelfEmojiViewHolder> {
    public final int getItemViewType(int r3) {
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return 0;
    L8:
        return 1;
    L5:
        r4 = false;
        goto L6
    }

    public final int getItemCount() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        SelfEmojiViewHolder r5 = (SelfEmojiViewHolder) r3;
        r5.getClass();
        if (r4 != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        r5.T3(null, r4, getItemViewType(r4));
        return;
    L9:
        r5.T3((SelfEmoji) ListProtector.get(null, r4 - 1), r4, getItemViewType(r4));
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new SelfEmojiViewHolder(LayoutInflater.from(null).inflate(2131566344, r4, false));
    }
}
