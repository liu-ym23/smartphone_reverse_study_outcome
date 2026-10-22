package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 extends RecyclerView.Adapter<f0> {
    public final int a;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.s b;
    public List<TalkRoomBaseDynamicEmoji> c;
    public final int d;
    public final int e;
    public final boolean f;
    public final String g;

    public final int getItemCount() {
        return this.c.size();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r4) {
        f0 r5 = (f0) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6 = r5.c;
        if (r6 == null) goto L6;
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.k(this.f, this.g, r6, true);
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        f0 r6 = (f0) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        TalkRoomBaseDynamicEmoji r7 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.c, r5);
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L7;
        ((RecyclerView.ViewHolder) r6).itemView.setVisibility(4);
        return;
    L7:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "emoji");
        r6.c = r7;
        ImageUtil.loadImage(r6.a, r7.getEmojiImage(), 2131251712);
        r6.b.setText(r7.getEmojiName());
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new d0(r7, this));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566251, r3, false);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.width = s1.y() / this.e;
        return new f0(r5);
    }

    public e0(int r2, int r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = r2 * r3;
        this.c = new ArrayList();
    }
}
