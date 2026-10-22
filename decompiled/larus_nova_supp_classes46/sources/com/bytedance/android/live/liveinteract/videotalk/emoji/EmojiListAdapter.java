package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/EmojiListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/InteractEmojiViewHolder;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmojiListAdapter extends RecyclerView.Adapter<InteractEmojiViewHolder> {
    public final int a;
    public List<TalkRoomBaseDynamicEmoji> b;
    public s c;
    public final int d;
    public final int e;
    public final int f;

    public final int getItemCount() {
        return this.b.size();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        InteractEmojiViewHolder r3 = (InteractEmojiViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        TalkRoomBaseDynamicEmoji r4 = r3.f;
        if (r4 == null) goto L8;
        s r0 = this.c;
        if (r0 == null) goto L9;
        r0.c0(r4);
        return;
    L9:
        return;
    }

    public final void y2(List<? extends TalkRoomBaseDynamicEmoji> r11) {
        Intrinsics.checkNotNullParameter(r11, "emojiList");
        int r1 = 0;
        if (Lists.isEmpty(r11) == false) goto L5;
        int r0 = 0;
    L10:
        int r2 = r0 * this.a;
        TalkRoomBaseDynamicEmoji[] r3 = new TalkRoomBaseDynamicEmoji[r2];
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L13;
        r3[r4] = new com.bytedance.android.live.liveinteract.videotalk.emoji.model.q();
        r4 = r4 + 1;
        goto L11
    L13:
        Iterator<T> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L21;
        TalkRoomBaseDynamicEmoji r5 = (TalkRoomBaseDynamicEmoji) r12.next();
        int r6 = this.d;
        int r7 = this.e;
        int r8 = this.a;
        int r9 = r1 % r8;
        int r10 = r9 / r7;
        int r13 = ((r6 * (r9 - (r7 * r10))) + r10) + ((r1 / r8) * r8);
        if (r13 >= r2) goto L20;
        r3[r13] = r5;
    L20:
        r1 = r1 + 1;
        goto L15
    L21:
        List<TalkRoomBaseDynamicEmoji> r14 = ArraysKt.toMutableList(r3);
        DiffUtil.DiffResult r15 = DiffUtil.calculateDiff(new DynamicEmojiDiffCallback(this.b, r14));
        this.b = r14;
        r15.dispatchUpdatesTo(this);
        return;
    L5:
        int r16 = r11.size() / this.a;
        if ((r11.size() % this.a) <= 0) goto L8;
        int r17 = 1;
    L9:
        r0 = r16 + r17;
        goto L10
    L8:
        r17 = 0;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        final InteractEmojiViewHolder r9 = (InteractEmojiViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final TalkRoomBaseDynamicEmoji r10 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.b, r8);
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L8;
        ((RecyclerView.ViewHolder) r9).itemView.setVisibility(4);
        return;
    L8:
        if (r10.type != TalkRoomBaseDynamicEmoji.Type.NormalEmoji) goto L45;
        ((RecyclerView.ViewHolder) r9).itemView.setVisibility(0);
        Intrinsics.checkNotNullParameter(r10, "emoji");
        r9.f = r10;
        ImageUtil.loadImage(r9.a, r10.emojiImage(), 2131251712);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r0 = r10.emojiPermission();
        if (r0 != null) goto L12;
    L14:
        r9.b.setVisibility(8);
        r9.a.setAlpha(1.0f);
    L15:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.e r1 = r10.emojiTag();
        if (r1 != null) goto L18;
    L20:
        r9.c.setVisibility(8);
    L21:
        r9.d.setVisibility(8);
        String r4 = null;
        if (r10.isNewRandomEmoji() == false) goto L34;
        r9.a.setAlpha(1.0f);
        String r2 = r10.getEmojiLabelOrNull();
        if (r2 == null) goto L32;
        if ((!TextUtils.isEmpty(r2)) == true) goto L29;
        r2 = null;
    L29:
        if (r2 == null) goto L32;
        r9.d.setText(r2);
        r9.d.setAlpha(1.0f);
        r9.d.setVisibility(0);
    L32:
        if (r10.disable == false) goto L34;
        r9.a.setAlpha(0.3f);
        r9.d.setAlpha(0.3f);
    L34:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r3 = r10.emojiPermission();
        if (r3 == null) goto L38;
        r4 = r3.bottomText;
    L38:
        if (TextUtils.isEmpty(r4) == false) goto L40;
        r9.e.setVisibility(8);
    L41:
        r3.a(((RecyclerView.ViewHolder) r9).itemView, r10.emojiName);
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(x0.a(new EmojiListAdapter$onBindViewHolder$$inlined$let$lambda$1(r10, this, r9)));
        return;
    L40:
        r9.e.setVisibility(0);
        r9.e.setText(r4);
        goto L41
    L18:
        if (TextUtils.isEmpty(r1.content) == true) goto L20;
        r9.c.setVisibility(0);
        r9.c.setText(r1.content);
        goto L21
    L12:
        if (r0.hasPermission == true) goto L14;
        r9.b.setVisibility(0);
        r9.a.setAlpha(0.6f);
        goto L15
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566252, r3, false);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.width = this.f / this.e;
        return new InteractEmojiViewHolder(r5);
    }

    public EmojiListAdapter(int r1, int r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.a = r1 * r2;
        this.b = new ArrayList();
    }
}
