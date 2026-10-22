package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import java.util.Iterator;
import java.util.List;
import jg0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkDummyViewBinder extends me.drakeet.multitype.b<tf0.e, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkDummyViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final g<tf0.e> a;

        public ItemViewHolder(g<tf0.e> r2) {
            Intrinsics.checkNotNullParameter(r2, "layer");
            super(r2.l());
            this.a = r2;
            r2.j(r2.c.getContext());
        }
    }

    public MultiLinkDummyViewBinder() {
    }

    public static void h(ItemViewHolder r1, tf0.e r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r2, "item");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "itemData");
        r1.a.v(r2, r2.a);
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (tf0.e) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r0 = hg0.c.a;
        MicSeatScene r1 = MicSeatScene.VIDEO_LINK_EQUAL;
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r1, "scene");
        kg0.a r4 = new kg0.a(r1);
        g r5 = new g(r3);
        r5.b(r4);
        r5.a(r3.getContext());
        return new ItemViewHolder(r5);
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        tf0.e r8 = (tf0.e) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.size() != 0) goto L5;
        h(r7, r8);
        return;
    L5:
        Iterator r9 = r6.iterator();
    L7:
        if (r9.hasNext() == false) goto L30;
        Object r0 = r9.next();
        if ((r0 instanceof Bundle) == true) goto L11;
        r0 = null;
    L11:
        Bundle r1 = (Bundle) r0;
        if (r1 == null) goto L7;
        if (r1.size() == 0) goto L19;
        if (r1.containsKey("payload_key_is_not_same_class") == true) goto L19;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "itemData");
        Intrinsics.checkNotNullParameter(r1, "payload");
        r7.a.w(r8, r8.a, r1);
    L19:
        h(r7, r8);
        goto L7
    }
}
