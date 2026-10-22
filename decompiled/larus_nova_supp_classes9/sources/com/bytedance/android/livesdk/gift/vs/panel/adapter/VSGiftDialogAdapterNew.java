package com.bytedance.android.livesdk.gift.vs.panel.adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.gift.model.z3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b;
import com.bytedance.android.livesdk.gift.vs.panel.viewholder.VSGiftDialogViewHolder;
import com.bytedance.android.livesdk.gift.vs.panel.viewmodel.VSGiftDialogViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/adapter/VSGiftDialogAdapterNew;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/BaseLiveGiftViewHolder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/ui/panel/AbsPanel;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftDialogAdapterNew extends RecyclerView.Adapter<BaseLiveGiftViewHolder<AbsPanel<?>>> {
    public final List<AbsPanel<?>> a;
    public final LayoutInflater b;
    public final GiftViewModelManager c;
    public int d;
    public final VSGiftDialogViewModel e;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final int getItemViewType(int r2) {
        if (r2 < 0) goto L12;
        if (r2 >= ((ArrayList) this.a).size()) goto L12;
        AbsPanel r0 = (AbsPanel) ListProtector.get(this.a, r2);
        if (r0 == null) goto L10;
        return r0.a;
    L10:
        return super.getItemViewType(r2);
    L12:
        return super.getItemViewType(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        BaseLiveGiftViewHolder r3 = (BaseLiveGiftViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
    }

    public final void y2(List r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.a).clear();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L18;
        AbsPanel r0 = (AbsPanel) r8.next();
        AbsPanel<?> r1 = b.d();
        if (r1 != null) goto L10;
    L16:
        r0.d = AbsPanel.GiftPanelSelectType.IDLE;
    L17:
        ((ArrayList) this.a).add(r0);
        goto L6
    L10:
        if (r1.c() != r0.c()) goto L16;
        AbsPanel<?> r2 = b.d();
        if (r2 == null) goto L14;
        AbsPanel.GiftPanelSelectType r3 = r2.d;
    L15:
        r0.d = r3;
        goto L17
    L14:
        r3 = null;
        goto L15
    L18:
        notifyDataSetChanged();
    }

    public final AbsPanel<?> z2(long r6) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        AbsPanel<?> r1 = (AbsPanel) r0.next();
        if (r1 == null) goto L4;
        if (r1.c() != r6) goto L4;
        return r1;
    L10:
        return null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        BaseLiveGiftViewHolder r7 = (BaseLiveGiftViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "liveGiftViewHolder");
        AbsPanel r0 = (AbsPanel) ListProtector.get(this.a, r6);
        if (r0 == null) goto L32;
        Integer r1 = Integer.valueOf(r0.a);
        if (r1.intValue() != 0) goto L8;
        boolean r2 = true;
    L9:
        BaseLiveGiftViewHolder r3 = null;
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        r1.intValue();
        ((RecyclerView.ViewHolder) r7).itemView.setVisibility(4);
    L15:
        VSGiftDialogViewModel r4 = this.e;
        if (r4 == null) goto L30;
        MutableLiveData<z3> r8 = r4.getInfo();
        if (r8 == null) goto L30;
        z3 r9 = (z3) r8.getValue();
        if (r9 == null) goto L30;
        String r10 = r9.a();
        if (r10 == null) goto L30;
        if ((r7 instanceof VSGiftDialogViewHolder) == false) goto L27;
        r3 = r7;
    L27:
        VSGiftDialogViewHolder r11 = (VSGiftDialogViewHolder) r3;
        if (r11 == null) goto L30;
        r11.e4().g(r10);
    L30:
        r7.a = r6;
        r7.T3(r0);
        this.d = Math.max(r6, this.d);
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Object r1 = null;
        VSGiftDialogViewHolder r7 = new VSGiftDialogViewHolder(this.b.inflate(2131565255, null), this.c);
        r7.C = false;
        r7.B = false;
        Context r8 = ((RecyclerView.ViewHolder) r7).itemView.getContext();
        if (r8 == null) goto L28;
        Point r0 = new Point();
        Object r2 = r8.getSystemService("window");
        if (r2 == null) goto L17;
        if ((r2 instanceof WindowManager) == false) goto L11;
        r1 = r2;
    L11:
        WindowManager r3 = (WindowManager) r1;
        if (r3 == null) goto L17;
        Display r4 = r3.getDefaultDisplay();
        if (r4 == null) goto L17;
        r4.getSize(r0);
    L17:
        if (PadConfigUtils.c() == false) goto L19;
    L25:
        float r9 = UIUtils.dip2Px(r8, 375.0f);
    L26:
        int r10 = (int) (r9 / 4);
    L27:
        ((RecyclerView.ViewHolder) r7).itemView.setLayoutParams(new ViewGroup.LayoutParams(r10, (int) UIUtils.dip2Px(r8, 110.0f)));
        goto L28
    L19:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L25;
        if (this.c.getIsVertical() == false) goto L24;
        r10 = r0.x / 4;
        goto L27
    L24:
        r9 = UIUtils.dip2Px(r8, 364.0f);
    L28:
        return r7;
    }

    public VSGiftDialogAdapterNew(Context r2, GiftViewModelManager r3, VSGiftDialogViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.e = r4;
        this.a = new ArrayList();
        this.b = LayoutInflater.from(r2);
        this.c = r3;
        this.d = -1;
    }
}
