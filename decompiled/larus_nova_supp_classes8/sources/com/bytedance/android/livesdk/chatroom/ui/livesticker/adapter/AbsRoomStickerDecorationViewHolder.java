package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/AbsRoomStickerDecorationViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsRoomStickerDecorationViewHolder<T> extends RecyclerView.ViewHolder {

    public static final class a {
    }

    static {
    }

    public abstract void T3(T r1);

    public AbsRoomStickerDecorationViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
