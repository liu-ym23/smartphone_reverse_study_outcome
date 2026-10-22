package com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter$VH;", "VH", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AssetsInfoAdapter extends RecyclerView.Adapter<VH> {
    public final List<Pair<e, Boolean>> a;
    public final LayoutInflater b;
    public String c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/debug/AssetsInfoAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VH extends RecyclerView.ViewHolder {
        public final TextView a;

        public VH(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131363262);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public AssetsInfoAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new ArrayList();
        this.b = LayoutInflater.from(r2);
        this.c = BuildConfig.FLAVOR;
    }

    public final void y2(List<? extends Pair<? extends e, Boolean>> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L35;
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r6);
        Iterator r7 = ((ArrayList) this.a).iterator();
        int r0 = 0;
        int r1 = 0;
    L8:
        if (r7.hasNext() == false) goto L21;
        Pair r2 = (Pair) r7.next();
        int r3 = ((e) r2.getFirst()).getResourceType();
        if (r3 == 4) goto L17;
        if (r3 == 5) goto L17;
        if (r3 != 8) goto L8;
    L17:
        if (((e) r2.getFirst()).getDownloadType() == 2) goto L8;
        r1 = r1 + 1;
        if (((Boolean) r2.getSecond()).booleanValue() == false) goto L8;
        r0 = r0 + 1;
        goto L8
    L21:
        this.c = "M,L,S:(" + r0 + '/' + r1 + ") All: " + ((ArrayList) this.a).size();
        notifyDataSetChanged();
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        VH r8 = (VH) r6;
        Intrinsics.checkNotNullParameter(r8, "vh");
        Pair r0 = (Pair) ListProtector.get(this.a, r7);
        switch(((e) r0.getFirst()).getResourceType()) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L4;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        Object r1 = Integer.valueOf(((e) r0.getFirst()).getResourceType());
    L10:
        r8.a.setText(r7 + "-[" + ((e) r0.getFirst()).getId() + "]-{" + r1 + "} " + ((e) r0.getFirst()).getMD5());
        return;
    L5:
        r1 = "LOKI";
        goto L10
    L6:
        r1 = "STICKER";
        goto L10
    L7:
        r1 = "MP4";
        goto L10
    L8:
        r1 = "LOTTIE";
        goto L10
    L9:
        r1 = "WEBP";
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        return new VH(this.b.inflate(2131565354, r4, false));
    }
}
