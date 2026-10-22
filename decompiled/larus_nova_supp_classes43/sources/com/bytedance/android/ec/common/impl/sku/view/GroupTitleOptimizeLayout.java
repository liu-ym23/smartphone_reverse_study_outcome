package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/GroupTitleOptimizeLayout;", "Landroid/widget/FrameLayout;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "setChartClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupTitleOptimizeLayout extends FrameLayout {
    public final ViewGroup a;
    public final View b;
    public final View c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public cg.d i;
    public SpecItemOptimizeGroupLayout.d j;
    public s.b k;
    public boolean l;
    public boolean m;
    public int n;
    public SkuViewModel o;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GroupTitleOptimizeLayout a;
        public final /* synthetic */ String b;

        public a(GroupTitleOptimizeLayout r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            SpecItemOptimizeGroupLayout.d r11 = this.a.j;
            if (r11 == null) goto L5;
            r11.b();
        L5:
            ECLiveHybridUtil.k(this.a.getContext(), this.b, false, false, false, null, 252);
        }
    }

    public GroupTitleOptimizeLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public GroupTitleOptimizeLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void b() {
        jg.g.d(this.c, this.m);
        if (this.l == false) goto L5;
        this.g.setImageResource(2131248193);
        this.h.setText("小图");
        return;
    L5:
        this.g.setImageResource(2131248191);
        this.h.setText("大图");
    }

    private final void setChartClickListener(String r10) {
        View r0 = this.a.findViewById(2131365498);
        if (r10.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.setOnClickListener(new a(this, r10));
        return;
    L8:
        r0.setOnClickListener(null);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public GroupTitleOptimizeLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        View r13 = LayoutInflater.from(r10).inflate(2131564779, this, true);
        if (r13 == null) goto L7;
        ViewGroup r14 = (ViewGroup) r13;
        this.a = r14;
        this.e = (TextView) r14.findViewById(2131390716);
        this.f = (TextView) r14.findViewById(2131390717);
        this.b = r14.findViewById(2131365498);
        this.c = r14.findViewById(2131364167);
        this.g = (ImageView) r14.findViewById(2131376650);
        this.h = (TextView) r14.findViewById(2131391542);
        this.d = r14.findViewById(2131369197);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public /* synthetic */ GroupTitleOptimizeLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }

    public final void a(cg.d r10, int r11, SpecItemOptimizeGroupLayout.d r12, SkuViewModel r13, t r14) {
        Intrinsics.checkNotNullParameter(r10, "groupTitleVO");
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        if (Intrinsics.areEqual(r10, this.i) == false) goto L5;
        return;
    L5:
        this.i = r10;
        this.n = r11;
        this.o = r13;
        if (r12 == null) goto L8;
        this.j = r12;
    L8:
        this.k = r14;
        cg.i r15 = r10.a;
        TextView r16 = this.e;
        String r17 = null;
        if (r15 == null) goto L11;
        String r18 = r15.a;
    L12:
        r16.setText(r18);
        TextView r19 = this.f;
        if (r15 == null) goto L15;
        r17 = r15.b;
    L15:
        r19.setText(r17);
        cg.b r110 = r10.b;
        boolean r111 = true;
        int r112 = 0;
        if (r110 == null) goto L23;
        TextView r0 = (TextView) this.a.findViewById(2131390299);
        if (a2.b(r110.g) == false) goto L22;
        this.b.setVisibility(0);
        r0.setText(r110.g);
        setChartClickListener(r110.f);
        SkuViewModel r113 = this.o;
        if (r113 == null) goto L24;
        r113.setExistSizeTab(true);
    L24:
        cg.l r20 = r10.c;
        if (this.n != 0) goto L29;
        SkuViewModel r114 = this.o;
        if (r114 == null) goto L29;
        boolean r115 = r114.getCurrentSpecShowBigPicMode();
    L30:
        this.l = r115;
        if (com.bytedance.android.ec.core.abtest.d.F() == 1) goto L40;
        if (r20 == null) goto L40;
        if (r20.a == false) goto L40;
        if (r20.b == false) goto L40;
        boolean r21 = true;
    L41:
        this.m = r21;
        b();
        this.c.setOnClickListener(new com.bytedance.android.ec.common.impl.sku.view.a(this));
        if (this.m == true) goto L44;
    L48:
        View r22 = this.d;
        if (this.b.getVisibility() == 0) goto L52;
        r111 = false;
    L52:
        if (r111 == true) goto L55;
        r112 = 4;
    L55:
        r22.setVisibility(r112);
        return;
    L44:
        if (this.n != 0) goto L48;
        SkuViewModel r1 = this.o;
        if (r1 == null) goto L48;
        SkuViewModel.doSkuEventAction$default(r1, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "size_map_switch")}, null, null, null, 28, null);
    L40:
        r21 = false;
    L29:
        r115 = false;
        goto L30
    L22:
        this.b.setVisibility(8);
        goto L24
    L23:
        this.b.setVisibility(8);
        goto L24
    L11:
        r18 = null;
        goto L12
    }
}
