package com.ss.android.lark.keyboard.biz.plus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$ViewHolder;", "Lcom/ss/android/lark/chat/entity/keyboard/IPlusItem;", "context", "Landroid/content/Context;", "dependency", "Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$AdapterDependency;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$AdapterDependency;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "renderNormalRoundImage", "entity", "imageView", "Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "refreshWhenInterceptorUpdated", "Companion", "ViewHolder", "AdapterDependency", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MoreItemsAdapterNew extends LarkRecyclerViewBaseAdapter<ViewHolder, d5b.a> {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "iconImageView", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "nameTextView", "Landroid/widget/TextView;", "getNameTextView", "()Landroid/widget/TextView;", "redDotImageView", "getRedDotImageView", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final ImageView c;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131375773);
            this.b = (TextView) r2.findViewById(2131375808);
            this.c = (ImageView) r2.findViewById(2131375774);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        d5b.a r9 = (d5b.a) getItem(r7);
        if (r9.isVisible() == false) goto L9;
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(0);
        r8.b.setText(r9.getName());
        SquircleImageView r0 = r8.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larksuite.component.ignition.widget.squircle.SquircleImageView");
        SquircleImageView r1 = r0;
        Intrinsics.checkNotNull(r9);
        r1.setBackgroundColor(UDColorUtils.getColor(null, 2131102437));
        r1.setBackgroundTintList(UDColorUtils.getColorStateList(null, 2131102495));
        UIHelper.dp2px(52.0f);
        if (r9.getIconId() == (-1)) goto L7;
        r1.setImageResource(r9.getIconId());
        r1.setImageTintList(null);
        r1.setRadius(UIHelper.dp2px(12.0f));
        r1.setBorderWidth(UIHelper.dp2px(0.0f));
        r1.setBorderColor(j08.b.b(ContextCompat.getColor(r1.getContext(), 2131103463), 0.1f));
    L8:
        ImageView r2 = r8.c;
        r9.showRedDot();
        r2.setVisibility(8);
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new c(this, r9, r8));
        return;
    L7:
        r9.b();
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(8);
        goto L8
    L9:
        ((RecyclerView.ViewHolder) r8).itemView.setVisibility(8);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(null).inflate(2131561734, r3, false);
        Intrinsics.checkNotNull(r5);
        return new ViewHolder(r5);
    }
}
