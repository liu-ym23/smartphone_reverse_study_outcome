package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/GiftGridLayoutManager;", "Lcom/bytedance/android/livesdk/chatroom/ui/SSGridLayoutManager;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftGridLayoutManager extends SSGridLayoutManager {
    public final Function4<Integer, RecyclerView.Recycler, RecyclerView.State, Boolean, Unit> a;

    public GiftGridLayoutManager(Context r3, Function4 r4) {
        Intrinsics.checkNotNullParameter(r4, "scrollVerticalCallback");
        super(r3, 4, 1);
        this.a = r4;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r6, RecyclerView.State r7) {
        long r0 = System.currentTimeMillis();
        super.onLayoutChildren(r6, r7);
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - r0) <= 10) goto L9;
        jy0.b.a("ttlive_gift_panel_metrics", "grid onLayoutChildren cost " + (System.currentTimeMillis() - r0) + "ms");
        return;
    }

    public final int scrollVerticallyBy(int r7, RecyclerView.Recycler r8, RecyclerView.State r9) {
        long r0 = System.currentTimeMillis();
        int r2 = super.scrollVerticallyBy(r7, r8, r9);
        jy0.b.a("yz-debug-SSGridLayoutManager", "dy " + r7 + ", scroll " + r2);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        long r3 = System.currentTimeMillis() - r0;
        if (r3 <= 6) goto L7;
        jy0.b.a("ttlive_gift_panel_metrics", "grid scrollVerticallyBy cost " + r3 + "ms");
    L7:
        Function4<Integer, RecyclerView.Recycler, RecyclerView.State, Boolean, Unit> r1 = this.a;
        Integer r4 = Integer.valueOf(r7);
        if (r7 != r2) goto L10;
        boolean r10 = true;
    L11:
        r1.invoke(r4, r8, r9, Boolean.valueOf(r10));
        return r2;
    L10:
        r10 = false;
        goto L11
    }
}
