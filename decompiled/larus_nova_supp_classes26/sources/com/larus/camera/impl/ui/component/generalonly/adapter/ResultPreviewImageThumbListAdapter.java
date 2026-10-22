package com.larus.camera.impl.ui.component.generalonly.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ux8.c;
import ux8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/adapter/ResultPreviewImageThumbListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/camera/api/params/OutputParam;", "Lcom/larus/camera/impl/ui/component/generalonly/adapter/ResultPreviewThumbHolder;", "onItemClick", "Lkotlin/Function2;", "", "", "onDeleteClick", "Lkotlin/Function3;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "useLargeUnifiedStyle", "", "setUseLargeUnifiedStyle", "enabled", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getSelectedPosition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultPreviewImageThumbListAdapter extends ListAdapter<OutputParam, ResultPreviewThumbHolder> {
    public final Function2<OutputParam, Integer, Unit> a;
    public final Function3<OutputParam, Integer, Integer, Unit> b;
    public boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultPreviewImageThumbListAdapter(Function2<? super OutputParam, ? super Integer, Unit> r2, Function3<? super OutputParam, ? super Integer, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        Intrinsics.checkNotNullParameter(r3, "onDeleteClick");
        super(new OutputParamDiffCallback());
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        final ResultPreviewThumbHolder r8 = (ResultPreviewThumbHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        boolean r9 = this.c;
        if (Intrinsics.areEqual(r8.e, Boolean.valueOf(r9)) == true) goto L42;
        r8.e = Boolean.valueOf(r9);
        if (r9 == false) goto L8;
        int r0 = 64;
    L9:
        int r1 = r8.T3(r0);
        r8.a.setLayoutParams(new FrameLayout.LayoutParams(r1, r1));
        r8.b.setLayoutParams(new FrameLayout.LayoutParams(r1, r1));
        r8.c.setLayoutParams(new FrameLayout.LayoutParams(r1, r1));
        ImageButton r2 = r8.d;
        int r3 = 14;
        if (r9 == false) goto L12;
        int r4 = 18;
    L13:
        int r5 = r8.T3(r4);
        if (r9 == false) goto L16;
        r3 = 18;
    L16:
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(r5, r8.T3(r3), 8388661);
        if (r9 == false) goto L19;
        r10.topMargin = r8.T3(5);
        r10.setMarginEnd(r8.T3(5));
    L19:
        r2.setLayoutParams(r10);
        ViewGroup.MarginLayoutParams r11 = null;
        if (r9 == false) goto L22;
        r8.d.setImageResource(2131241875);
        r8.d.setBackgroundResource(2131239535);
        Resources r12 = ((RecyclerView.ViewHolder) r8).itemView.getResources();
        int r13 = (int) (WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density * 3.5f);
        r8.d.setPadding(r13, r13, r13, r13);
    L23:
        ViewParent r14 = r8.a.getParent();
        if ((r14 instanceof FrameLayout) == false) goto L26;
        FrameLayout r15 = (FrameLayout) r14;
    L27:
        if (r15 == null) goto L42;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        r11 = (ViewGroup.MarginLayoutParams) r16;
    L31:
        if (r11 == null) goto L40;
        r11.setMarginStart(r8.T3(4));
        r11.setMarginEnd(r8.T3(4));
        int r17 = 8;
        if (r9 == false) goto L35;
        int r18 = 9;
    L36:
        r11.topMargin = r8.T3(r18);
        if (r9 == false) goto L39;
        r17 = 9;
    L39:
        r11.bottomMargin = r8.T3(r17);
        ViewGroup.LayoutParams r19 = r11;
    L41:
        r15.setLayoutParams(r19);
        goto L42
    L35:
        r18 = 8;
        goto L36
    L40:
        r19 = r15.getLayoutParams();
        goto L41
    L26:
        r15 = null;
        goto L27
    L22:
        r8.d.setImageDrawable(null);
        r8.d.setBackgroundResource(2131242183);
        r8.d.setPadding(0, 0, 0, 0);
        goto L23
    L12:
        r4 = 14;
        goto L13
    L8:
        r0 = 48;
    L42:
        final OutputParam r20 = (OutputParam) getItem(r8.getAdapterPosition());
        if (r20.isVideo() == false) goto L45;
        e1.o(r8.b);
    L46:
        t r21 = t.a;
        r8.a.setImageBitmap(t.c(r20));
        if (r20.isSelected() == false) goto L49;
        e1.x(r8.c);
    L50:
        e1.d(r8.d, new c(r8, this, r20));
        e1.d(((RecyclerView.ViewHolder) r8).itemView, new d(r20, r8, this));
        return;
    L49:
        e1.o(r8.c);
        goto L50
    L45:
        e1.x(r8.b);
        r8.b.setImageBitmap(r20.getImageParam().getMarkedMaskBitmap());
        goto L46
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562634, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ResultPreviewThumbHolder(r5);
    }
}
