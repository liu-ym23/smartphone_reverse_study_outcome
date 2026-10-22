package com.bytedance.android.live.ktv.common.ordersong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.banner.LabelBannerUrl;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.MusicListSecondLevelTabFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvLabelBannerViewBinder extends me.drakeet.multitype.b<LabelBannerUrl, VH> {
    public VH b;
    public final b c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/adapter/KtvLabelBannerViewBinder$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class VH extends RecyclerView.ViewHolder {
        public final ViewGroup a;
        public com.bytedance.android.live.ktv.common.ordersong.adapter.a b;
        public LabelBannerUrl c;
        public boolean d;
        public boolean e;

        public final void release() {
            ALogger.d("KtvLabelBannerViewBinder", "release");
            com.bytedance.android.live.ktv.common.ordersong.adapter.a r0 = this.b;
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.b = null;
            this.e = false;
            this.d = false;
            ViewGroup r1 = this.a;
            if (r1 == null) goto L9;
            r1.removeAllViews();
            return;
        }

        public VH(View r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "listener");
            super(r2);
            this.a = (ViewGroup) r2.findViewById(2131379287);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        boolean getForceUpdateBannerState();
    }

    static {
    }

    public KtvLabelBannerViewBinder(MusicListSecondLevelTabFragment.getCustomItemViewBinderAction.1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r6, Object r7) {
        VH r8 = (VH) r6;
        LabelBannerUrl r9 = (LabelBannerUrl) r7;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        this.b = r8;
        StringBuilder r0 = new StringBuilder("onBindViewHolder, isLoading=");
        r0.append(r8.e);
        r0.append(", isLoadSuccess=");
        r0.append(r8.e);
        r0.append(", holderUrl=");
        LabelBannerUrl r1 = r8.c;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getUrl();
    L6:
        r0.append(r3);
        r0.append(", itemUrl=");
        r0.append(r9.getUrl());
        ALogger.d("KtvLabelBannerViewBinder", r0.toString());
        if (r8.e == true) goto L11;
        if (r8.d == true) goto L11;
    L19:
        Intrinsics.checkNotNullParameter(r9, "labelBanner");
        r8.release();
        r8.c = r9;
        r8.e = true;
        Context r4 = ((RecyclerView.ViewHolder) r8).itemView.getContext();
        String r5 = r9.getUrl();
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        com.bytedance.android.live.ktv.common.ordersong.adapter.a r11 = new com.bytedance.android.live.ktv.common.ordersong.adapter.a(r8, r4, x6.a.d(r5), s1.y());
        r8.b = r11;
        r11.loadUrl(r9.getUrl());
        this.c.a();
        return;
    L11:
        if (((Boolean) h.J0.getValue(null, h.a[86])).booleanValue() == true) goto L13;
        return;
    L13:
        if (this.c.getForceUpdateBannerState() == false) goto L25;
        LabelBannerUrl r12 = r8.c;
        if (r12 == null) goto L18;
        r2 = r12.getUrl();
    L18:
        if ((!Intrinsics.areEqual(r2, r9.getUrl())) == true) goto L19;
        return;
    L25:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new VH(r4.inflate(2131566508, r5, false), this.c);
    }
}
