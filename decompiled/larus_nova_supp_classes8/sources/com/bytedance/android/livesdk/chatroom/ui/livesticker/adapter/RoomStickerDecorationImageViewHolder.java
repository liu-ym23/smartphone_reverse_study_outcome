package com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;
import zg1.t2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/RoomStickerDecorationImageViewHolder;", "Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/adapter/AbsRoomStickerDecorationViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStickerDecorationImageViewHolder extends AbsRoomStickerDecorationViewHolder<RoomDecoration> {
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

    public RoomStickerDecorationImageViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (ImageView) r2.findViewById(2131387346);
        r2.setOnClickListener(a.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.livesticker.adapter.AbsRoomStickerDecorationViewHolder
    public final void T3(RoomDecoration r6) {
        RoomDecoration r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "roomDecoration");
        ((RecyclerView.ViewHolder) this).itemView.setTag(r7);
        if (r7.getImage() != null) goto L5;
    L9:
        ImageView r0 = this.a;
        if (r0 == null) goto L17;
        long r1 = r7.getId();
        AnchorStickerWrapperWidget.F.getClass();
        if (r1 != AnchorStickerWrapperWidget.E) goto L14;
        float r8 = 0.3f;
    L15:
        r0.setAlpha(r8);
        return;
    L14:
        r8 = 1.0f;
        goto L15
    L17:
        return;
    L5:
        if (r7.getImage().getUrls() == null) goto L9;
        if (r7.getImage().getUrls().size() <= 0) goto L9;
        TTLiveSDKContext.getHostService().a.frescoHelper().loadFirstAvailableImageBitmap(r7.getImage(), new mo1.a(this));
        goto L9
    }
}
