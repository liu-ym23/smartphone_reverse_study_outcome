package com.bytedance.android.live.emoji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.emoji.viewholder.BaseEmojiViewHolder;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class EmojiPanelWaterfallAdapter extends RecyclerView.Adapter<BaseEmojiViewHolder> {
    public final Context a;
    public final LayoutInflater b;
    public final List<BaseEmoji> c;
    public View d;
    public final int e;
    public final int f;
    public t90.a g;

    public class a extends GridLayoutManager.SpanSizeLookup {
        public final /* synthetic */ GridLayoutManager a;
        public final /* synthetic */ EmojiPanelWaterfallAdapter b;

        public final int getSpanSize(int r3) {
            if (r3 != ((ArrayList) this.b.c).size()) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == true) goto L8;
            return 1;
        L8:
            return this.a.getSpanCount();
        L5:
            r4 = false;
            goto L6
        }

        public a(EmojiPanelWaterfallAdapter r1, GridLayoutManager r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final int getItemCount() {
        if (this.d == null) goto L5;
        int r0 = 1;
    L7:
        return ((ArrayList) this.c).size() + r0;
    L5:
        r0 = 0;
        goto L7
    }

    public final int getItemViewType(int r2) {
        if (r2 != ((ArrayList) this.c).size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return -99;
    L10:
        return ((BaseEmoji) ListProtector.get(this.c, r2)).getType().ordinal();
    L5:
        r0 = false;
        goto L6
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        super.onAttachedToRecyclerView(r2);
        GridLayoutManager r3 = r2.getLayoutManager();
        if ((r3 instanceof GridLayoutManager) == false) goto L6;
        GridLayoutManager r4 = r3;
        r4.setSpanSizeLookup(new a(this, r4));
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseEmojiViewHolder r5 = (BaseEmojiViewHolder) r3;
        if (r4 != ((ArrayList) this.c).size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L20;
        BaseEmoji r6 = (BaseEmoji) ListProtector.get(this.c, r4);
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.getType() != BaseEmoji.Type.DummyEmoji) goto L14;
        ((RecyclerView.ViewHolder) r5).itemView.setVisibility(4);
        return;
    L14:
        r5.T3(r6);
        t90.a r7 = this.g;
        if (r7 == null) goto L19;
        r5.b = r7;
        return;
    L19:
        return;
    L20:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        BaseEmojiViewHolder r5 = new BaseEmojiViewHolder(this.b.inflate(2131566341, null));
        ViewGroup.LayoutParams r1 = new ViewGroup.LayoutParams(this.f / this.e, (int) t6.a(this.a, 62.0f));
        ((RecyclerView.ViewHolder) r5).itemView.setLayoutParams(r1);
        return r5;
    }

    public EmojiPanelWaterfallAdapter(Context r2, int r3, int r4) {
        this.c = new ArrayList();
        this.a = r2;
        this.b = LayoutInflater.from(r2);
        this.e = r3;
        this.f = r4;
    }
}
