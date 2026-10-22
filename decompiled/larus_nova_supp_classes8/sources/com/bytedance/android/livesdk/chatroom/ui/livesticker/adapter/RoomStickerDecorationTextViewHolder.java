package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;
import zg1.t2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/RoomStickerDecorationTextViewHolder;", "Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/AbsRoomStickerDecorationViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStickerDecorationTextViewHolder extends AbsRoomStickerDecorationViewHolder<RoomDecoration> {
    public final ImageView a;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (c.a(r3) == true) goto L5;
            return;
        L5:
            Object r4 = r3.getTag();
            if (r4 == null) goto L10;
            RoomDecoration r5 = (RoomDecoration) r4;
            com.bytedance.android.live.liveinteract.api.utils.a.a.getClass();
            com.bytedance.android.live.liveinteract.api.utils.a.a.c(r5);
            b.a().post(new t2(r5));
            com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.b(0);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration");
        }
    }

    public RoomStickerDecorationTextViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (ImageView) r2.findViewById(2131387351);
        r2.setOnClickListener(a.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.AbsRoomStickerDecorationViewHolder
    public final void T3(RoomDecoration r12) {
        RoomDecoration r13 = r12;
        Intrinsics.checkNotNullParameter(r13, "roomDecoration");
        ((RecyclerView.ViewHolder) this).itemView.setTag(r13);
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        ImageModel r1 = r13.getImage();
        if (r1 == null) goto L5;
        int r2 = r1.height;
    L6:
        r0.setTag(2131389517, Integer.valueOf(r2));
        ImageUtil.loadImage(this.a, r13.getImage(), -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        ImageView r3 = this.a;
        if (r3 == null) goto L14;
        long r4 = r13.getId();
        AnchorStickerWrapperWidget.F.getClass();
        if (r4 != AnchorStickerWrapperWidget.D) goto L11;
        float r14 = 0.3f;
    L12:
        r3.setAlpha(r14);
        return;
    L11:
        r14 = 1.0f;
        goto L12
    L14:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
