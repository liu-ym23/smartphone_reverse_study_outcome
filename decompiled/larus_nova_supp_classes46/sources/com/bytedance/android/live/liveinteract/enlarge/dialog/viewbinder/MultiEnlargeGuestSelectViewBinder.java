package com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.x0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiEnlargeGuestSelectViewBinder extends me.drakeet.multitype.b<b, ItemViewHolder> {
    public final int b;
    public final a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/viewbinder/MultiEnlargeGuestSelectViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public b a;
        public final HSImageView b;
        public final TextView c;
        public final View d;
        public final a e;

        public ItemViewHolder(View r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "selectedListener");
            super(r2);
            this.e = r3;
            this.b = r2.findViewById(2131371667);
            this.c = (TextView) r2.findViewById(2131371671);
            this.d = r2.findViewById(2131385838);
            r2.setOnClickListener(x0.a(new AnonymousClass1(this)));
        }
    }

    public interface a {
        void onSelected(String r1, boolean r2);
    }

    public static final class b {
        public boolean a;
        public final ILinkPlayerInfoBridge b;

        public b(boolean r2, ILinkPlayerInfoBridge r3) {
            Intrinsics.checkNotNullParameter(r3, "playerInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public MultiEnlargeGuestSelectViewBinder(a r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedListener");
        this.b = 4;
        this.c = r2;
    }

    public static void h(ItemViewHolder r5, b r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.a = r6;
        HSImageView r0 = r5.b;
        IBaseUser r1 = r6.b.getUser();
        if (r1 == null) goto L5;
        k r2 = r1.getAvatarMedium();
    L6:
        ImageUtil.loadRoundImage(r0, r2);
        TextView r3 = r5.c;
        IBaseUser r4 = r6.b.getUser();
        if (r4 == null) goto L10;
        String r7 = r4.getNickName();
        if (r7 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r7, "content");
        int r8 = 0;
        if (r7.length() <= 4) goto L14;
        r7 = r7.substring(0, 4) + "...";
    L14:
        r3.setText(r7);
        View r9 = r5.d;
        if (r6.a == true) goto L18;
        r8 = 8;
    L18:
        r9.setVisibility(r8);
        return;
    L10:
        r7 = "";
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (b) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        ItemViewHolder r6 = new ItemViewHolder(r4.inflate(2131565651, r5, false), this.c);
        int r7 = (s1.y() - s1.f(32.0f)) / this.b;
        int r8 = s1.f(96.0f);
        ((RecyclerView.ViewHolder) r6).itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, r8));
        return r6;
    }

    public final void c(RecyclerView.ViewHolder r7, Object r8, List r9) {
        ItemViewHolder r10 = (ItemViewHolder) r7;
        b r11 = (b) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        if (r9.size() != 0) goto L5;
        h(r10, r11);
        return;
    L5:
        Iterator r12 = r9.iterator();
    L7:
        if (r12.hasNext() == false) goto L52;
        Object r1 = r12.next();
        if ((r1 instanceof Bundle) == true) goto L11;
        r1 = null;
    L11:
        Bundle r2 = (Bundle) r1;
        if (r2 == null) goto L7;
        if (r2.size() == 0) goto L15;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "item");
        Intrinsics.checkNotNullParameter(r2, "payload");
        r10.a = r11;
        Iterator<String> r3 = r2.keySet().iterator();
    L18:
        if (r3.hasNext() == false) goto L7;
        String r4 = r3.next();
        if (r4 == null) goto L18;
        if (r4.hashCode() != 1486694307) goto L18;
        if (r4.equals("payload_key_guest_selected_state_update") == false) goto L18;
        boolean r5 = r2.getBoolean(r4);
        b r6 = r10.a;
        if (r6 == null) goto L30;
        r6.a = r5;
    L30:
        View r13 = r10.d;
        if (r5 == false) goto L33;
        int r14 = 0;
    L34:
        r13.setVisibility(r14);
        goto L18
    L33:
        r14 = 8;
        goto L34
    L15:
        h(r10, r11);
        goto L7
    }
}
