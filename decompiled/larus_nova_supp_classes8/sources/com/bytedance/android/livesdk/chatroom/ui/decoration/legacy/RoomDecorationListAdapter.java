package com.bytedance.android.livesdk.chatroom.ui.decoration.legacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RoomDecorationListAdapter extends RecyclerView.Adapter<a<RoomDecoration>> {

    public static abstract class a<T> extends RecyclerView.ViewHolder {
        public abstract void T3(T r1);

        public a(View r1) {
            super(r1);
        }
    }

    public static class b extends a<RoomDecoration> {
        public b(View r1) {
            super(r1);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final /* bridge */ /* synthetic */ void T3(RoomDecoration r1) {
        }
    }

    public static class c extends a<RoomDecoration> {
        public c(View r1) {
            super(r1);
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final /* bridge */ /* synthetic */ void T3(RoomDecoration r1) {
        }
    }

    public static class d extends a<RoomDecoration> {
        public final ImageView a;
        public final View.OnClickListener b;

        public d(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131368636);
            this.b = null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final void T3(RoomDecoration r5) {
            RoomDecoration r6 = r5;
            if (r6 == null) goto L22;
            ((RecyclerView.ViewHolder) this).itemView.setTag(r6);
            if (r6.getImage() != null) goto L8;
        L12:
            long r0 = r6.getId();
            AnchorStickerWrapperWidget.F.getClass();
            if (r0 != AnchorStickerWrapperWidget.D) goto L15;
            boolean r7 = true;
        L16:
            ImageView r1 = this.a;
            if (r7 == false) goto L19;
            float r8 = 0.3f;
        L20:
            r1.setAlpha(r8);
            return;
        L19:
            r8 = 1.0f;
            goto L20
        L15:
            r7 = false;
            goto L16
        L8:
            if (r6.getImage().getUrls() == null) goto L12;
            if (r6.getImage().getUrls().size() <= 0) goto L12;
            TTLiveSDKContext.getHostService().a.frescoHelper().loadFirstAvailableImageBitmap(r6.getImage(), new com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.a(this));
            goto L12
        }
    }

    public static class e extends a<RoomDecoration> {
        public final ImageView a;
        public final View.OnClickListener b;

        public e(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131368634);
            this.b = null;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.RoomDecorationListAdapter.a
        public final void T3(RoomDecoration r5) {
            RoomDecoration r6 = r5;
            if (r6 == null) goto L22;
            ((RecyclerView.ViewHolder) this).itemView.setTag(r6);
            if (r6.getImage() != null) goto L8;
        L12:
            long r0 = r6.getId();
            AnchorStickerWrapperWidget.F.getClass();
            if (r0 != AnchorStickerWrapperWidget.E) goto L15;
            boolean r7 = true;
        L16:
            ImageView r1 = this.a;
            if (r7 == false) goto L19;
            float r8 = 0.3f;
        L20:
            r1.setAlpha(r8);
            return;
        L19:
            r8 = 1.0f;
            goto L20
        L15:
            r7 = false;
            goto L16
        L8:
            if (r6.getImage().getUrls() == null) goto L12;
            if (r6.getImage().getUrls().size() <= 0) goto L12;
            TTLiveSDKContext.getHostService().a.frescoHelper().loadFirstAvailableImageBitmap(r6.getImage(), new com.bytedance.android.livesdk.chatroom.ui.decoration.legacy.b(this));
            goto L12
        }
    }

    public final int getItemViewType(int r1) {
        if (r1 != 0) goto L5;
        return 1;
    L5:
        if (r1 <= 0) goto L9;
        if (r1 >= 0) goto L9;
        return 3;
    L9:
        if (r1 != 0) goto L12;
        return 2;
    L12:
        return 4;
    }

    public final int getItemCount() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        ((a) r2).T3((RoomDecoration) ListProtector.get(null, r3));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 1) goto L5;
        RecyclerView.ViewHolder r5 = new c(LayoutInflater.from(r3.getContext()).inflate(2131566154, r3, false));
    L16:
        return r5;
    L5:
        if (r4 != 2) goto L7;
        r5 = new b(LayoutInflater.from(r3.getContext()).inflate(2131566155, r3, false));
        goto L16
    L7:
        if (r4 != 3) goto L9;
        r5 = new d(LayoutInflater.from(r3.getContext()).inflate(2131565358, r3, false));
        goto L16
    L9:
        if (r4 == 4) goto L11;
        return null;
    L11:
        r5 = new e(LayoutInflater.from(r3.getContext()).inflate(2131565359, r3, false));
        goto L16
    }
}
