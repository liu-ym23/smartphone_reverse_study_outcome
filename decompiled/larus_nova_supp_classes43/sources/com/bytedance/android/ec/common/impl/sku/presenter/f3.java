package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuTrustTagContentView;
import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.bytedance.android.ec.model.sku.BackgroundInfo;
import com.bytedance.android.ec.model.sku.BlankObject;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.ImageObject;
import com.bytedance.android.ec.model.sku.SkuTrustTagItem;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TextObject;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f3 extends QFragmentPresenter {
    public SkuViewModel f;
    public CommonMarqueeView g;
    public final a h;

    public static final class a implements ul.c {
        public final /* synthetic */ f3 a;

        public a(f3 r1) {
            this.a = r1;
        }

        public final void a(boolean r10) {
            if (r10 == false) goto L4;
            this.a.Y().d().q(dg.v.class, 0);
            return;
        L4:
            this.a.Y().d().q(dg.v.class, 8);
        }
    }

    public final void c0() {
        List r0 = ul.b.a;
        ul.b.a(this.h);
        CommonMarqueeView r1 = this.g;
        if (r1 == null) goto L5;
        r1.setOnViewExposedListener(null);
    L5:
        CommonMarqueeView r10 = this.g;
        if (r10 == null) goto L9;
        r10.d();
        return;
    }

    public f3(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10);
        this.h = new a(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b0(QModel r17) {
        SkuViewModel r1 = (SkuViewModel) Y().g(SkuViewModel.class);
        this.f = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r10 = (SkuInfoVO) r1.getSkuInfo().a();
        if (r10 == null) goto L136;
        SkuTrustTags r11 = r10.getTrustTags();
        if (r11 == null) goto L137;
        List r12 = r11.getSkuDocument();
        int r13 = 0;
        if (r12 != null) goto L13;
    L107:
        List r14 = ul.b.a;
        ul.b.b(this.h);
        SkuViewModel r15 = this.f;
        if (r15 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L110:
        Map r16 = r11.getShowEventTrack();
        if (r16 == null) goto L121;
        ArrayList r18 = new ArrayList(r16.size());
        Iterator r19 = r16.entrySet().iterator();
    L114:
        if (r19.hasNext() == false) goto L116;
        Map.Entry r20 = (Map.Entry) r19.next();
        r18.add(TuplesKt.to((String) r20.getKey(), (String) r20.getValue()));
        goto L114
    L116:
        Object[] r21 = r18.toArray(new Pair[0]);
        if (r21 == null) goto L120;
        Pair[] r22 = (Pair[]) r21;
    L122:
        SkuViewModel.doSkuEventAction$default(r15, "sku_panel_module_show", (Pair[]) Arrays.copyOf(r22, r22.length), null, null, null, 28, null);
        return;
    L120:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L121:
        r22 = new Pair[0];
        goto L122
    L13:
        if (this.g != null) goto L23;
        CommonMarqueeView r23 = (CommonMarqueeView) Z().b(2131389408).f();
        this.g = r23;
        r23.setInterval(3000);
        CommonMarqueeView r24 = this.g;
        if (r24 == null) goto L17;
        r24.setItemSpacing(com.bytedance.android.shopping.extensions.b.b(4));
    L17:
        CommonMarqueeView r25 = this.g;
        if (r25 == null) goto L20;
        r25.setOrientation(true);
    L20:
        CommonMarqueeView r26 = this.g;
        if (r26 == null) goto L23;
        r26.setOnViewExposedListener(new TrustTagsPresenter$bind$$inlined$let$lambda$1(this));
    L23:
        CommonMarqueeView r27 = this.g;
        if (r27 == null) goto L26;
        r27.removeAllViews();
    L26:
        Iterator r28 = r12.iterator();
    L28:
        if (r28.hasNext() == false) goto L101;
        SkuTrustTagItem r29 = (SkuTrustTagItem) r28.next();
        SkuTrustTagsView r30 = new SkuTrustTagsView(Y().c(), null, 6, r13);
        Intrinsics.checkNotNullParameter(r29, "item");
        BackgroundInfo r31 = r29.getBackground();
        if (r31 == null) goto L42;
        GradientDrawable r110 = new GradientDrawable();
        Integer r111 = r31.getCornerRadius();
        if (r111 == null) goto L34;
        r110.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r111.intValue())));
    L34:
        String r112 = r31.getBackgroundColor();
        if (r112 != null) goto L124;
    L39:
        r30.setBackground(r110);
        Integer r32 = r31.getHeight();
        if (r32 == null) goto L42;
        wg.a.d(r30, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r32.intValue())));
        goto L42
    L124:
        r110.setColor(Color.parseColor(r112));     // Catch: Exception -> L38
    L42:
        List r33 = r29.getContent();
        if (r33 == null) goto L97;
        int r34 = (com.bytedance.android.ec.core.utils.k1.m(r30.getContext()) - com.bytedance.android.shopping.extensions.b.b(24)) - com.bytedance.android.shopping.extensions.b.b(24);
        r30.removeAllViews();
        SkuTrustTagContentView r113 = new SkuTrustTagContentView(r30.getContext(), null, 6, r13);
        Intrinsics.checkNotNullParameter(r33, "contents");
        Iterator r35 = r33.iterator();
        int r36 = 0;
    L46:
        if (r35.hasNext() == false) goto L96;
        ContentInfo r114 = (ContentInfo) r35.next();
        ImageObject r115 = r114.getImageObject();
        if (r115 == null) goto L63;
        List r116 = r115.getUrlList();
        if (r116 == null) goto L63;
        String r117 = (String) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L63;
        SimpleDraweeView r37 = new SimpleDraweeView(r113.getContext());
        r37.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r37.setImageURI(r117);
        Integer r38 = r115.getWidth();
        if (r38 == null) goto L57;
        int r39 = vf4.a.b(r38);
    L58:
        Integer r118 = r115.getHeight();
        if (r118 == null) goto L61;
        int r119 = vf4.a.b(r118);
    L62:
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(r39, r119);
        r120.gravity = 16;
        r37.setLayoutParams(r120);
    L64:
        TextObject r40 = r114.getTextObject();
        if (r40 == null) goto L85;
        r37 = new TextView(r113.getContext());
        String r121 = r40.getText();
        if (r121 == null) goto L84;
        r37.setText(r121);
        String r122 = r40.getFontColor();
        if (r122 != null) goto L126;
    L73:
        Integer r123 = r40.getFontSize();
        if (r123 == null) goto L76;
        r37.setTextSize(r123.intValue());
    L76:
        Boolean r41 = r40.getBold();
        if (r41 != null) goto L79;
    L83:
        r37.setGravity(16);
        r37.setSingleLine();
        LinearLayout.LayoutParams r42 = new LinearLayout.LayoutParams(-2, -2);
        r42.gravity = 16;
        r37.setLayoutParams(r42);
        goto L85
    L79:
        if (r41.booleanValue() == false) goto L81;
        Typeface r43 = Typeface.DEFAULT_BOLD;
    L82:
        r37.setTypeface(r43);
        goto L83
    L81:
        r43 = Typeface.DEFAULT;
        goto L82
    L126:
        r37.setTextColor(Color.parseColor(r122));     // Catch: Exception -> L72
        goto L73
    L84:
        r37 = null;
    L85:
        BlankObject r44 = r114.getBlankObject();
        if (r44 == null) goto L91;
        r37 = new View(r113.getContext());
        vf4.a.b(0);
        Integer r45 = r44.getWidth();
        if (r45 == null) goto L90;
        r37.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(Integer.valueOf(r45.intValue())), vf4.a.b(2)));
        goto L91
    L90:
        r37 = null;
    L91:
        if (r37 == null) goto L46;
        r37.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if ((r37.getMeasuredWidth() + r36) >= r34) goto L46;
        r113.addView(r37);
        r36 = r36 + r37.getMeasuredWidth();
        r113.b.add(r114);
        goto L46
    L61:
        r119 = -1;
        goto L62
    L57:
        r39 = -2;
    L63:
        r37 = null;
        goto L64
    L96:
        Unit r46 = Unit.INSTANCE;
        r30.a = r113;
        r30.addView(r113);
    L97:
        r30.requestLayout();
        CommonMarqueeView r47 = this.g;
        if (r47 == null) goto L100;
        r47.addView(r30);
    L100:
        r13 = 0;
        goto L28
    L101:
        CommonMarqueeView r48 = this.g;
        if (r48 == null) goto L104;
        r48.post(new e3(this));
    L104:
        CommonMarqueeView r49 = this.g;
        if (r49 == null) goto L107;
        r49.c();
        goto L107
    L137:
        return;
    }
}
