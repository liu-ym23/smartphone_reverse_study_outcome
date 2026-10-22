package com.larus.dora.impl.device.ailab;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.dora.impl.databinding.LarusDoraAilabKeywordListItemBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\f\u001a\u00020\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/device/ailab/AiLabKeywordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/device/ailab/DoraKeywordViewHolder;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "<init>", "(Lcom/larus/dora/impl/device/ailab/AiLabViewModel;)V", "getModel", "()Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "data", "", "Lcom/larus/dora/impl/device/ailab/AiLabKeyword;", "setData", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiLabKeywordAdapter extends RecyclerView.Adapter<DoraKeywordViewHolder> {
    public final int getItemCount() {
        throw null;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        DoraKeywordViewHolder r6 = (DoraKeywordViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        t r7 = (t) CollectionsKt.getOrNull(null, r5);
        if (r7 == null) goto L15;
        LarusDoraAilabKeywordListItemBinding r8 = r6.a;
        r8.e.setText(r7.b);
        r8.c.setText(r7.c);
        r8.b.setActualImageResource(r7.a);
        if (r7.e == false) goto L13;
        e1.x(r8.d);
        ImageView r1 = r8.d;
        if (r7.f == false) goto L10;
        int r9 = 2131240390;
    L11:
        r1.setImageResource(r9);
        r8.d.setClickable(false);
        throw null;
    L10:
        r9 = 2131240391;
        goto L11
    L13:
        r8.a.setClickable(false);
        e1.o(r8.d);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        ConstraintLayout r10 = e1.m(r8).inflate(2131562141, r8, false);
        int r11 = 2131369664;
        RoundAvatarImageView r3 = ViewBindings.findChildViewById(r10, 2131369664);
        if (r3 == null) goto L13;
        r11 = 2131369665;
        DoraTextView r4 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369665);
        if (r4 == null) goto L13;
        r11 = 2131369672;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, 2131369672);
        if (r5 == null) goto L13;
        r11 = 2131369673;
        DoraTextView r6 = (DoraTextView) ViewBindings.findChildViewById(r10, 2131369673);
        if (r6 == null) goto L13;
        return new DoraKeywordViewHolder(new LarusDoraAilabKeywordListItemBinding(r10, r3, r4, r5, r6));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
