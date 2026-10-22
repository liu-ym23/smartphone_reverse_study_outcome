package com.larus.dora.impl.alive;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraKeepAliveItemLayoutBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/alive/DoraKeepAliveAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/alive/DoraKeepAliveHolder;", "data", "", "Lcom/larus/dora/impl/alive/DoraKeepAliveHintItem;", "imgWidth", "", "<init>", "(Ljava/util/List;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraKeepAliveAdapter extends RecyclerView.Adapter<DoraKeepAliveHolder> {
    public static final /* synthetic */ int c = 0;
    public final List<j> a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public DoraKeepAliveAdapter(List<j> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        DoraKeepAliveHolder r9 = (DoraKeepAliveHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final j r10 = (j) CollectionsKt.getOrNull(this.a, r8);
        if (r10 == null) goto L15;
        final LarusDoraKeepAliveItemLayoutBinding r11 = r9.a;
        boolean r1 = false;
        r11.b.setBackgroundColor(0);
        e1.o(r11.c);
        final float r0 = i5.Q();
        RoundingParams r2 = RoundingParams.fromCornersRadius(r0);
        int r3 = j0.a;
        r11.b.setHierarchy(new GenericDraweeHierarchyBuilder(AppHost.a.getApplication().getResources()).setRoundingParams(r2.setBorderColor(j0.a(2131103685)).setBorderWidth(i5.b())).build());
        ImageLoaderKt.y(r11.b, r10.a, "dora_keep_alive_image", new b(r10, r11, r0), 4);
        String r4 = r10.b;
        if (r4 != null) goto L8;
    L9:
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        e1.o(r11.d);
        return;
    L12:
        e1.x(r11.d);
        r11.d.setText(r10.b);
        return;
    L8:
        if (r4.length() != 0) goto L10;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConstraintLayout r6 = e1.m(r4).inflate(2131562224, r4, false);
        int r7 = 2131369657;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(r6, 2131369657);
        if (r0 == null) goto L11;
        r7 = 2131369658;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r6, 2131369658);
        if (r1 == null) goto L11;
        r7 = 2131369659;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r6, 2131369659);
        if (r2 == null) goto L11;
        LarusDoraKeepAliveItemLayoutBinding r8 = new LarusDoraKeepAliveItemLayoutBinding(r6, r0, r1, r2);
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        int r3 = this.b;
        r9.width = r3;
        r9.height = r3 * 2;
        r0.setLayoutParams(r9);
        return new DoraKeepAliveHolder(r8);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
