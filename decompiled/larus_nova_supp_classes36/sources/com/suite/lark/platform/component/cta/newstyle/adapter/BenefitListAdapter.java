package com.suite.lark.platform.component.cta.newstyle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.platform.component.cta.databinding.ItemBenefitListBinding;
import goc.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import loc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter$BenefitViewHolder;", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Benefit;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getItems", "", "getItem", "position", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "submitList", "items", "", "BenefitViewHolder", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BenefitListAdapter extends LarkRecyclerViewBaseAdapter<BenefitViewHolder, b.C0270b> {
    public final Context a;
    public final AsyncListDiffer<b.C0270b> b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter$BenefitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/suite/lark/platform/component/cta/databinding/ItemBenefitListBinding;", "<init>", "(Lcom/suite/lark/platform/component/cta/databinding/ItemBenefitListBinding;)V", "benefitIcon", "Landroid/widget/ImageView;", "getBenefitIcon", "()Landroid/widget/ImageView;", "benefitText", "Landroid/widget/TextView;", "getBenefitText", "()Landroid/widget/TextView;", "root", "Landroid/widget/LinearLayout;", "getRoot", "()Landroid/widget/LinearLayout;", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class BenefitViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int d = 0;
        public final ImageView a;
        public final TextView b;
        public final LinearLayout c;

        public static final class a {
        }

        static {
        }

        public BenefitViewHolder(ItemBenefitListBinding r2) {
            super(r2.a);
            this.a = r2.b;
            this.b = r2.c;
            this.c = r2.a;
        }
    }

    public final List<b.C0270b> getItems() {
        return this.b.getCurrentList();
    }

    public final int getItemCount() {
        return getItems().size();
    }

    public final Context getContext() {
        return this.a;
    }

    public BenefitListAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new AsyncListDiffer(this, new BenefitListAdapter$differ$1());
    }

    public final Object getItem(int r2) {
        return (b.C0270b) ListProtector.get(this.b.getCurrentList(), r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        BenefitViewHolder r9 = (BenefitViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        b.C0270b r0 = (b.C0270b) ListProtector.get(this.b.getCurrentList(), r8);
        ImageView r1 = r9.a;
        Context r2 = this.a;
        String r3 = r0.b();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        e.a(r1, r2, r3, 2131102420);
        TextView r5 = r9.b;
        String r6 = r0.a();
        if (r6 == null) goto L9;
        r4 = r6;
    L9:
        r5.setText(r4);
        int r10 = UIUtils.dp2px(this.a, 12.0f);
        ViewGroup.LayoutParams r11 = r9.c.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r8 != (getItemCount() - 1)) goto L12;
        r12.setMargins(0, 0, 0, 0);
    L13:
        r9.c.setLayoutParams(r12);
        return;
    L12:
        r12.setMargins(0, 0, 0, r10);
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r0 = BenefitViewHolder.d;
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561570, r3, false);
        int r6 = 2131364095;
        if (((ImageView) ViewBindings.findChildViewById(r5, 2131364095)) == null) goto L11;
        r6 = 2131364097;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r5, 2131364097);
        if (r1 == null) goto L11;
        r6 = 2131364106;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r5, 2131364106);
        if (r2 == null) goto L11;
        return new BenefitViewHolder(new ItemBenefitListBinding((LinearLayout) r5, r1, r2));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
