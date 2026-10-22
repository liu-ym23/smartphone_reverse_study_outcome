package com.larus.bmhome.miniartifact.listpage.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.miniartifact.listpage.l;
import com.larus.bmhome.miniartifact.listpage.request.ApplicationTemplate;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusItemMiniArtifactTemplateBinding;
import com.larus.utils.logger.FLogger;
import cr8.a;
import cr8.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0007J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R/\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactDoubleColumnAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/miniartifact/listpage/adapter/MiniArtifactItemViewHolder;", "onClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "adapterList", "", "size", "Landroid/util/Size;", "setupItemSize", "setupList", "items", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactDoubleColumnAdapter extends RecyclerView.Adapter<MiniArtifactItemViewHolder> {
    public final Function2<Integer, ApplicationTemplate, Unit> a;
    public List<ApplicationTemplate> b;
    public Size c;

    public final int getItemCount() {
        return this.b.size();
    }

    public MiniArtifactDoubleColumnAdapter(l r2) {
        Intrinsics.checkNotNullParameter(r2, "onClick");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
        this.c = new Size(0, 0);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, final int r9) {
        final MiniArtifactItemViewHolder r10 = (MiniArtifactItemViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        final ApplicationTemplate r6 = (ApplicationTemplate) CollectionsKt.getOrNull(this.b, r9);
        if (r6 == null) goto L20;
        Size r0 = this.c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "size");
        Intrinsics.checkNotNullParameter(r6, "miniAppItemData");
        int r1 = r0.getHeight();
        ConstraintLayout r2 = r10.b.b;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L19;
        RecyclerView.LayoutParams r4 = (RecyclerView.LayoutParams) r3;
        ((ViewGroup.MarginLayoutParams) r4).width = -1;
        ((ViewGroup.MarginLayoutParams) r4).height = r1;
        r2.setLayoutParams(r4);
        r10.b.e.setText(r6.getTemplateTitle());
        ImageLoaderKt.u(r10.b.c, r6.getTemplateCoverUrl(), "mini_artifact_template_cover");
        r10.b.c.setOnClickListener(new a(r10, r9, r6));
        String r5 = r6.getCoverMainColor();
        View r7 = r10.b.d;
    L15:
        e = move-exception;
        FLogger.a.e("MiniAppItemViewHolder", "error parsing tint color ", e);
    L17:
        ExposeXTrackerExtKt.b(r10.b.b, new b(r6, r10, r9));
        return;
    L8:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        if (r5 != null) goto L11;
        int r11 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L15
    L13:
        int r12 = r11;
        int r13 = Color.argb(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L15
        int r14 = CircleProgressBarView.k;     // Catch: IllegalArgumentException -> L15
        float r15 = CircleProgressBarView.a.a(r7.getContext(), 4.0f);     // Catch: IllegalArgumentException -> L15
        MiniArtifactItemViewHolder.T3(r10, r7, r15, r15, r12, r13);     // Catch: IllegalArgumentException -> L15
        goto L17
    L11:
        r11 = Color.parseColor("#B6BACD");     // Catch: IllegalArgumentException -> L15
        goto L13
    L12:
        r11 = Color.parseColor(r5);     // Catch: IllegalArgumentException -> L15
        goto L13
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        ConstraintLayout r9 = LayoutInflater.from(r7.getContext()).inflate(2131562589, r7, false);
        ConstraintLayout r2 = r9;
        int r10 = 2131380135;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r9, 2131380135);
        if (r3 == null) goto L11;
        r10 = 2131386037;
        View r4 = ViewBindings.findChildViewById(r9, 2131386037);
        if (r4 == null) goto L11;
        r10 = 2131388772;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r9, 2131388772);
        if (r5 == null) goto L11;
        LarusItemMiniArtifactTemplateBinding r11 = new LarusItemMiniArtifactTemplateBinding(r2, r2, r3, r4, r5);
        return new MiniArtifactItemViewHolder(this.a, r11);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r10)));
    }
}
