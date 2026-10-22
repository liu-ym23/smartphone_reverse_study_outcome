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
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.platform.component.cta.databinding.ItemVersionInfoBinding;
import com.suite.lark.platform.component.cta.newstyle.f;
import goc.b;
import java.util.List;
import joc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import loc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J \u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00030\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter$VersionViewHolder;", "Lcom/suite/lark/platform/component/cta/newstyle/entity/CardVO;", "context", "Landroid/content/Context;", "onVersionClickListener", "Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;", "<init>", "(Landroid/content/Context;Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;)V", "getContext", "()Landroid/content/Context;", "getOnVersionClickListener", "()Lcom/suite/lark/platform/component/cta/newstyle/entity/OnVersionClickListener;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getItems", "", "getItem", "position", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "bindVersionInfoItem", "item", "bindTitle", "bindPrice", "updateItemMargin", "bindListeners", "updateSelection", "submitList", "items", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "VersionViewHolder", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VersionInfoAdapter extends LarkRecyclerViewBaseAdapter<VersionViewHolder, joc.a> {
    public final Context a;
    public final d b;
    public final AsyncListDiffer<joc.a> c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/VersionInfoAdapter$VersionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/suite/lark/platform/component/cta/databinding/ItemVersionInfoBinding;", "<init>", "(Lcom/suite/lark/platform/component/cta/databinding/ItemVersionInfoBinding;)V", "versionCheckbox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getVersionCheckbox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "versionWrapper", "Landroid/widget/LinearLayout;", "getVersionWrapper", "()Landroid/widget/LinearLayout;", "versionText", "Landroid/widget/TextView;", "getVersionText", "()Landroid/widget/TextView;", "priceSymbol", "getPriceSymbol", "priceCount", "getPriceCount", "priceUnit", "getPriceUnit", "root", "getRoot", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class VersionViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int h = 0;
        public final UDCheckBox a;
        public final LinearLayout b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final TextView f;
        public final LinearLayout g;

        public static final class a {
        }

        static {
        }

        public VersionViewHolder(ItemVersionInfoBinding r2) {
            super(r2.a);
            this.a = r2.e;
            this.b = r2.g;
            this.c = r2.f;
            this.d = r2.c;
            this.e = r2.b;
            this.f = r2.d;
            this.g = r2.a;
        }
    }

    public static final class a {
    }

    static {
    }

    public final List<joc.a> getItems() {
        return this.c.getCurrentList();
    }

    public final int getItemCount() {
        return getItems().size();
    }

    public final Context getContext() {
        return this.a;
    }

    public final Object getItem(int r2) {
        return (joc.a) ListProtector.get(this.c.getCurrentList(), r2);
    }

    public VersionInfoAdapter(Context r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onVersionClickListener");
        this.a = r2;
        this.b = r3;
        this.c = new AsyncListDiffer(this, new VersionInfoAdapter$differ$1());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        VersionViewHolder r10 = (VersionViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        joc.a r0 = (joc.a) ListProtector.get(this.c.getCurrentList(), r9);
        r10.a.setEnabled(r0.a.f());
        r10.a.setChecked(r0.b);
        if (r0.a.f() == true) goto L5;
    L13:
        TextView r1 = r10.c;
        String r2 = r0.a.h();
        String r3 = "";
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        r1.setText(r2);
        String r4 = null;
        if (r0.a.i() == false) goto L25;
        UDTagsDrawable.d.a r5 = new UDTagsDrawable.d.a(this.a);
        String r6 = r0.a.c();
        if (r6 == null) goto L22;
        r3 = r6;
    L22:
        r5.c = r3;
        r5.d = UIUtils.getColor(this.a, 2131109115);
        r5.a(UIUtils.getColor(this.a, 2131109109));
        UDTagsDrawable.d r7 = r5.b();
        UDTagsDrawable.a r11 = new UDTagsDrawable.a(this.a);
        r11.a(r7);
        UDTagsDrawable r12 = r11.b();
        if (r12 == null) goto L39;
        r12.c(r10.c);
    L39:
        TextView r13 = r10.d;
        b.k r14 = r0.a.e();
        if (r14 == null) goto L42;
        String r15 = r14.b();
    L43:
        r13.setText(r15);
        TextView r16 = r10.e;
        b.k r17 = r0.a.e();
        if (r17 == null) goto L46;
        String r18 = r17.a();
    L47:
        r16.setText(r18);
        TextView r19 = r10.f;
        b.k r20 = r0.a.e();
        if (r20 == null) goto L50;
        r4 = r20.c();
    L50:
        r19.setText(r4);
        r10.e.post(new com.suite.lark.platform.component.cta.newstyle.adapter.a(r10, this, r9));
        r10.g.setOnClickListener(new ioc.a(r0, this, r10));
        return;
    L46:
        r18 = null;
        goto L47
    L42:
        r15 = null;
        goto L43
    L25:
        String r21 = r0.a.b();
        if (r21 != null) goto L28;
    L31:
        boolean r22 = true;
    L32:
        if (r22 == true) goto L39;
        if (r10.b.findViewWithTag("iconView") != null) goto L39;
        int r23 = UIUtils.dp2px(this.a, 24.0f);
        ImageView r24 = new ImageView(this.a);
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(r23, r23);
        r25.setMarginStart(UIUtils.dp2px(r24.getContext(), 4.0f));
        r24.setLayoutParams(r25);
        r24.setTag("iconView");
        String r26 = r0.a.b();
        if (r26 == null) goto L38;
        e.a(r24, this.a, r26, null);
    L38:
        r10.b.addView(r24);
        goto L39
    L28:
        if (r21.length() == 0) goto L31;
        r22 = false;
        goto L32
    L5:
        if (r0.b == false) goto L7;
        int r27 = UIUtils.getColor(this.a, 2131105548);
    L9:
        if (r0.b == false) goto L11;
        int r28 = UIUtils.getColor(this.a, 2131105548);
    L12:
        r10.c.setTextColor(r27);
        r10.d.setTextColor(r28);
        r10.e.setTextColor(r28);
        goto L13
    L11:
        r28 = UIUtils.getColor(this.a, 2131106607);
        goto L12
    L7:
        r27 = UIUtils.getColor(this.a, 2131106622);
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r0 = VersionViewHolder.h;
        Intrinsics.checkNotNullParameter(r10, "parent");
        View r12 = LayoutInflater.from(r10.getContext()).inflate(2131561711, r10, false);
        int r13 = 2131383005;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r12, 2131383005);
        if (r3 == null) goto L19;
        r13 = 2131383011;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131383011);
        if (r4 == null) goto L19;
        r13 = 2131383013;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, 2131383013);
        if (r5 == null) goto L19;
        r13 = 2131383016;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131383016)) == null) goto L19;
        r13 = 2131392210;
        UDCheckBox r6 = ViewBindings.findChildViewById(r12, 2131392210);
        if (r6 == null) goto L19;
        r13 = 2131392211;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131392211);
        if (r7 == null) goto L19;
        r13 = 2131392212;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131392212);
        if (r8 == null) goto L19;
        return new VersionViewHolder(new ItemVersionInfoBinding((LinearLayout) r12, r3, r4, r5, r6, r7, r8));
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
