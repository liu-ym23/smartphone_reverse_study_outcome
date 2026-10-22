package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectViewHolder;", "DiffCallback", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectAdapter extends RecyclerView.Adapter<TuningEffectViewHolder> {
    public final List<h> a;
    public final List<h> b;
    public final cc0.a c;
    public final boolean d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<Object> a;
        public final List<Object> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<? extends Object> r2, List<? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "origin");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            if (r4 == r5) goto L5;
            return false;
        L5:
            Object r6 = ListProtector.get(this.a, r4);
            Object r7 = ListProtector.get(this.b, r5);
            if ((!Intrinsics.areEqual(r6.getClass(), r7.getClass())) == false) goto L9;
            return false;
        L9:
            if ((r6 instanceof h) == true) goto L11;
        L14:
            return false;
        L11:
            if ((r7 instanceof h) == false) goto L14;
            return ((h) r6).h((h) r7);
        }

        public final boolean areItemsTheSame(int r1, int r2) {
            return areContentsTheSame(r1, r2);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final int y2(h r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((h) r0.next()).d(), r5.d()) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    public TuningEffectAdapter(TuningEffectListView$tuningEffectCallback$2.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tuningEffectCallback");
        this.c = r2;
        this.d = r3;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        TuningEffectViewHolder r7 = (TuningEffectViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "viewHolder");
        h r8 = (h) ListProtector.get(this.a, r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.e = r8;
        TextView r0 = (TextView) r7.d.getValue();
        if (r0 == null) goto L6;
        r0.setText(r8.e());
    L6:
        if (r8.a == false) goto L13;
        View r1 = (View) r7.b.getValue();
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        SimpleDraweeView r2 = r7.T3();
        if (r2 == null) goto L25;
        r2.setAlpha(1.0f);
    L25:
        SimpleDraweeView r3 = r7.T3();
        if (r3 == null) goto L29;
        r3.setAlpha(1.0f);
    L29:
        if (r8.g() == false) goto L31;
        ImageLoader.bindDrawableResource(r7.T3(), KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.u));
    L32:
        SimpleDraweeView r4 = r7.T3();
        if (r4 == null) goto L35;
        r4.setContentDescription(r8.e());
    L35:
        View r9 = (View) r7.b.getValue();
        if (r9 == null) goto L38;
        r9.setContentDescription(r8.e());
    L38:
        FrameLayout r11 = (FrameLayout) r7.a.getValue();
        if (r11 == null) goto L42;
        r11.setContentDescription(r8.e());
        return;
    L42:
        return;
    L31:
        ImageLoader.bindImage(r7.T3(), r8.c());
        goto L32
    L13:
        View r12 = (View) r7.b.getValue();
        if (r12 == null) goto L16;
        r12.setVisibility(8);
    L16:
        SimpleDraweeView r13 = r7.T3();
        if (r13 == null) goto L25;
        h r14 = r7.e;
        if (r14 != null) goto L21;
    L23:
        float r15 = 0.5f;
    L24:
        r13.setAlpha(r15);
        goto L25
    L21:
        if (r14.g() != true) goto L23;
        r15 = 1.0f;
        goto L24
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566307, r3, false);
        if (this.d == false) goto L7;
        TextView r6 = (TextView) r5.findViewById(2131389968);
        if (r6 == null) goto L7;
        r6.setTextSize(14.0f);
    L7:
        Unit r7 = Unit.INSTANCE;
        return new TuningEffectViewHolder(r5, this.c);
    }
}
