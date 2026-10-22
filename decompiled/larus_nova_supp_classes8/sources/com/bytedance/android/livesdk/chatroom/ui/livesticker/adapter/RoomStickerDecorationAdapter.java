package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.StickerDecorationType;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/RoomStickerDecorationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/AbsRoomStickerDecorationViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStickerDecorationAdapter extends RecyclerView.Adapter<AbsRoomStickerDecorationViewHolder<RoomDecoration>> {
    public final List<RoomDecoration> a;
    public final StickerDecorationType b;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public RoomStickerDecorationAdapter(StickerDecorationType r2) {
        Intrinsics.checkNotNullParameter(r2, "itemType");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final int getItemViewType(int r1) {
        return this.b.getType();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        AbsRoomStickerDecorationViewHolder r5 = (AbsRoomStickerDecorationViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        r5.T3(ListProtector.get(this.a, r4));
        ((RecyclerView.ViewHolder) r5).itemView.setContentDescription("贴纸" + (r4 + 1));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        if (r5 != StickerDecorationType.TEXT_STICKER.getType()) goto L6;
        return new RoomStickerDecorationTextViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567477, r4, false));
    L6:
        return new RoomStickerDecorationImageViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567475, r4, false));
    }
}
