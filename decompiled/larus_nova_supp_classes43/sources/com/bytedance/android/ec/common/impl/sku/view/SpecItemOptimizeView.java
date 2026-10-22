package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.commerce.base.richtext.SpanUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getAtmosphereColor", "getCurrentPosition", "Lcom/bytedance/android/ec/common/impl/sku/view/r;", "clickListener", "", "setItemClickListener", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemOptimizeView extends ConstraintLayout {
    public boolean a;
    public s.c b;
    public boolean c;
    public boolean d;
    public final ConstraintLayout e;
    public final ConstraintLayout f;
    public final SimpleDraweeView g;
    public final TextView h;
    public final ImageView i;
    public final ConstraintLayout j;
    public final SimpleDraweeView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public SkuViewModel o;
    public int p;
    public Function1<? super Integer, Unit> q;
    public final SpecItemOptimizeGroupLayout.e r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SpecItemOptimizeView a;
        public final /* synthetic */ r b;

        public a(SpecItemOptimizeView r1, r r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (r10.getId() != 2131376046) goto L5;
            return;
        L5:
            s.c r0 = this.a.b;
            if ((r10 instanceof ConstraintLayout) == true) goto L8;
            r10 = null;
        L8:
            ConstraintLayout r11 = (ConstraintLayout) r10;
            if (r0 == null) goto L13;
            if (r11 == null) goto L14;
            this.b.a(r0);
            return;
        L14:
            return;
        }
    }

    private final int getAtmosphereColor() {
        SkuViewModel r0 = this.o;
        if (r0 == null) goto L13;
        QLiveData<Integer> r1 = r0.getCurrentAtmosphereStyle();
        if (r1 == null) goto L13;
        Integer r10 = (Integer) r1.a();
        if (r10 == null) goto L13;
        if (r10.intValue() == 2) goto L15;
        return ColorProtector.parseColor("#FF3B52");
    L15:
        return ColorProtector.parseColor("#9E2DF5");
    L13:
        return ColorProtector.parseColor("#FF3B52");
    }

    private final int getCurrentPosition() {
        s.c r0 = this.b;
        if (r0 == null) goto L18;
        String r1 = r0.c;
        if (r1 == null) goto L18;
        SkuViewModel r10 = this.o;
        if (r10 == null) goto L18;
        List<String> r11 = r10.getFirstIdList();
        if (r11 == null) goto L18;
        int r12 = r11.size();
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L18;
        if (TextUtils.equals(r1, (CharSequence) ListProtector.get(r11, r13)) == true) goto L16;
        r13 = r13 + 1;
        goto L12
    L16:
        return r13 + 1;
    L18:
        return 0;
    }

    public final void V5() {
        this.f.setAlpha(1.0f);
        this.j.setAlpha(1.0f);
        int r0 = getAtmosphereColor();
        if (this.d == false) goto L5;
        this.h.setTextColor(r0);
        GradientDrawable r1 = new GradientDrawable();
        r1.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r1.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.05f));
        r1.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.5f));
        this.f.setBackgroundDrawable(r1);
        this.h.setTypeface(Typeface.defaultFromStyle(1));
        this.i.setVisibility(0);
    L9:
        this.n.setVisibility(4);
        return;
    L5:
        this.l.setTextColor(r0);
        this.m.setTextColor(r0);
        GradientDrawable r10 = new GradientDrawable();
        r10.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r10.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.05f));
        r10.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r0, 0.5f));
        this.j.setBackgroundDrawable(r10);
        this.l.setTypeface(Typeface.defaultFromStyle(1));
        this.m.setTypeface(Typeface.defaultFromStyle(1));
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L8;
        this.i.setVisibility(0);
        goto L9
    L8:
        this.i.setVisibility(8);
        goto L9
    }

    public final void Y5() {
        this.f.setAlpha(1.0f);
        this.j.setAlpha(1.0f);
        if (this.d == false) goto L5;
        this.h.setTextColor(ColorProtector.parseColor("#161823"));
        this.h.setTypeface(Typeface.defaultFromStyle(0));
        this.f.setBackgroundResource(2131248194);
        this.i.setVisibility(0);
    L9:
        this.n.setVisibility(4);
        return;
    L5:
        this.l.setTextColor(ColorProtector.parseColor("#161823"));
        this.m.setTextColor(ColorProtector.parseColor("#161823"));
        this.l.setTypeface(Typeface.defaultFromStyle(0));
        this.m.setTypeface(Typeface.defaultFromStyle(0));
        this.j.setBackgroundResource(2131248194);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L8;
        this.i.setVisibility(0);
        goto L9
    L8:
        this.i.setVisibility(8);
        goto L9
    }

    public final void Z5() {
        if (this.a == false) goto L19;
        s.c r0 = this.b;
        if (r0 != null) goto L7;
    L9:
        SkuStatusDetail r1 = null;
        if (this.c == false) goto L15;
        V5();
        s.c r10 = this.b;
        if (r10 == null) goto L14;
        r1 = r10.b;
    L14:
        c6(r1, true);
        return;
    L15:
        Y5();
        s.c r11 = this.b;
        if (r11 == null) goto L18;
        r1 = r11.b;
    L18:
        c6(r1, false);
        return;
    L7:
        if (r0.a == true) goto L9;
    L19:
        U5();
    }

    public final void U5() {
        Y5();
        this.f.setAlpha(0.34f);
        this.j.setAlpha(0.34f);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L5;
        this.i.setVisibility(0);
    L6:
        s.c r0 = this.b;
        if (r0 == null) goto L9;
        SkuStatusDetail r1 = r0.b;
    L10:
        c6(r1, false);
        this.i.setVisibility(8);
        return;
    L9:
        r1 = null;
        goto L10
    L5:
        this.i.setVisibility(8);
        goto L6
    }

    public static final /* synthetic */ int R5(SpecItemOptimizeView r0) {
        return r0.getCurrentPosition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b6(s.c r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r1 = false;
        if (this.d == false) goto L19;
        this.f.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        SimpleDraweeView r0 = this.g;
        Map<String, String> r11 = r10.i;
        if (r11 == null) goto L9;
        String r12 = r11.get(r10.c);
    L10:
        com.bytedance.android.ec.core.utils.y.d(r0, r12);
        this.h.setText(r10.d);
        this.i.setOnClickListener(new b0(this));
        int r13 = UIUtils.getScreenWidth(getContext());     // Catch: Exception -> L13
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Exception -> L13
        int r14 = ((((((((r13 - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(12)) - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(8)) - vf4.a.b(4)) - vf4.a.b(3)) / 3;     // Catch: Exception -> L13
        float r15 = r14;
        float r16 = r15 / vf4.a.b(Integer.valueOf(CastInfo.TYPE_DISCONNECT));     // Catch: Exception -> L13
        float r17 = r15 * (vf4.a.b(149) / vf4.a.b(Integer.valueOf(CastInfo.TYPE_DISCONNECT)));     // Catch: Exception -> L13
        ConstraintLayout r18 = this.e;     // Catch: Exception -> L13
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();     // Catch: Exception -> L13
        r19.width = r14;     // Catch: Exception -> L13
        r19.height = (int) r17;     // Catch: Exception -> L13
        Unit r20 = Unit.INSTANCE;     // Catch: Exception -> L13
        r18.setLayoutParams(r19);     // Catch: Exception -> L13
        int r21 = (int) (r16 * vf4.a.b(104));     // Catch: Exception -> L13
        SimpleDraweeView r22 = this.g;     // Catch: Exception -> L13
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();     // Catch: Exception -> L13
        r23.width = r21;     // Catch: Exception -> L13
        r23.height = r21;     // Catch: Exception -> L13
        r22.setLayoutParams(r23);     // Catch: Exception -> L13
    L14:
        ECUrlModel r24 = r10.g;
        if (r24 == null) goto L17;
        com.bytedance.android.ec.core.utils.y.l(r24, 0, 0, new w(this, r10));
    L18:
        this.h.getViewTreeObserver().addOnGlobalLayoutListener(new x(this));
        return;
    L17:
        SpanUtils r25 = new SpanUtils(this.h);
        r25.a(r10.d);
        r25.c();
        goto L18
    L9:
        r12 = null;
        goto L10
    L19:
        this.f.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        this.l.setText(r10.d);
        String r26 = r10.e;
        if (r26 != null) goto L22;
    L25:
        boolean r27 = true;
    L26:
        if (r27 == false) goto L28;
        this.m.setVisibility(8);
    L29:
        Map<String, String> r28 = r10.h;
        if (r28 == null) goto L34;
        String r29 = r28.get(r10.c);
        if (r29 == null) goto L34;
        this.k.setVisibility(0);
        com.bytedance.android.ec.core.utils.y.d(this.k, r29);
    L35:
        ECUrlModel r30 = r10.g;
        if (r30 == null) goto L38;
        com.bytedance.android.ec.core.utils.y.l(r30, 0, 0, new z(this, r10));
    L39:
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(new a0(this));
        if (this.k.getVisibility() != 0) goto L42;
        boolean r31 = true;
    L44:
        if (r31 == false) goto L47;
        this.l.setPadding(vf4.a.b(8), 0, vf4.a.b(12), 0);
    L53:
        int r32 = UIUtils.getScreenWidth(getContext());
        ConstraintLayout r33 = this.e;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        r34.width = -2;
        r34.height = -2;
        Unit r35 = Unit.INSTANCE;
        r33.setLayoutParams(r34);
        if (this.m.getVisibility() != 0) goto L56;
        boolean r36 = true;
    L58:
        if (r36 == false) goto L63;
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r37 = this.e.getMeasuredWidth();
        int r38 = (((r32 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(12)) / 2;
        TextView r39 = this.l;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        r40.width = vf4.a.b(0);
        r39.setLayoutParams(r40);
        if (r37 <= r38) goto L62;
        ConstraintLayout r41 = this.j;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        r42.width = ((r32 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        r41.setLayoutParams(r42);
        return;
    L62:
        ConstraintLayout r43 = this.j;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        r44.width = r38;
        r43.setLayoutParams(r44);
        return;
    L63:
        TextView r45 = this.l;
        ViewGroup.LayoutParams r46 = r45.getLayoutParams();
        r46.width = -2;
        r45.setLayoutParams(r46);
        TextView r47 = this.l;
        if (this.k.getVisibility() != 0) goto L66;
        r1 = true;
    L66:
        if (r1 == false) goto L68;
        int r48 = ((r32 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        int r49 = vf4.a.b(48);
    L69:
        r47.setMaxWidth(r48 - r49);
        return;
    L68:
        r48 = ((r32 - vf4.a.b(16)) - vf4.a.b(24)) - vf4.a.b(6);
        r49 = vf4.a.b(20);
        goto L69
    L56:
        r36 = false;
        goto L58
    L47:
        if (this.m.getVisibility() != 0) goto L49;
        boolean r50 = true;
    L50:
        if (r50 == false) goto L52;
        this.l.setPadding(vf4.a.b(16), 0, vf4.a.b(8), 0);
        goto L53
    L52:
        this.l.setPadding(vf4.a.b(16), 0, vf4.a.b(16), 0);
        goto L53
    L49:
        r50 = false;
        goto L50
    L42:
        r31 = false;
        goto L44
    L38:
        SpanUtils r51 = new SpanUtils(this.l);
        r51.a(r10.d);
        r51.c();
    L34:
        this.k.setVisibility(8);
        goto L35
    L28:
        this.m.setVisibility(0);
        this.m.setText(r10.e);
        goto L29
    L22:
        if (r26.length() == 0) goto L25;
        r27 = false;
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setItemClickListener(r r10) {
        Intrinsics.checkNotNullParameter(r10, "clickListener");
        setOnClickListener(new a(this, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpecItemOptimizeView(Context r10, s r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null, 0);
        this.r = r11;
        ViewGroup.inflate(r10, 2131564793, this);
        this.e = findViewById(2131366903);
        this.f = findViewById(2131366822);
        this.g = findViewById(2131385269);
        this.h = (TextView) findViewById(2131390220);
        this.i = (ImageView) findViewById(2131376046);
        this.j = findViewById(2131366900);
        this.k = findViewById(2131385285);
        this.l = (TextView) findViewById(2131391479);
        this.m = (TextView) findViewById(2131391478);
        this.n = (TextView) findViewById(2131391465);
        AccessibilityDelegateCompat r12 = new AnonymousClass1(this);
        int r13 = jg.a.a;
        ViewCompat.setAccessibilityDelegate(this, r12);
    }

    public final void S5(s.c r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "viewInfo");
        this.b = r10.a();
        if (this.a == true) goto L5;
    L16:
        U5();
        this.c = false;
        return;
    L5:
        if (r10.a == false) goto L16;
        SpecItemOptimizeGroupLayout.e r0 = this.r;
        if (r0 == null) goto L10;
        s.c r1 = r0.getCheckedItemViewInfo();
    L11:
        if (r1 != null) goto L13;
    L15:
        Y5();
        c6(r10.b, false);
        this.c = false;
        return;
    L13:
        if (TextUtils.equals(r11, r10.c) == false) goto L15;
        V5();
        c6(r10.b, true);
        this.c = true;
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void T5(int r10, s.c r11) {
        if (r10 != 0) goto L20;
        boolean r12 = this.d;
        if (r12 == true) goto L21;
        boolean r0 = false;
        if (r12 == false) goto L10;
        SkuViewModel r13 = this.o;
        if (r13 == null) goto L22;
        r13.setCurrentSpecHasPic(false);
        return;
    L22:
        return;
    L10:
        SkuViewModel r14 = this.o;
        if (r14 == null) goto L24;
        if (r11 == null) goto L18;
        Map<String, String> r15 = r11.h;
        if (r15 == null) goto L18;
        if (r15.isEmpty() == true) goto L18;
        r0 = true;
    L18:
        r14.setCurrentSpecHasPic(r0);
        return;
    L24:
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6(SkuStatusDetail r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        boolean r1 = true;
        if (r11.canAppointNoStock() == true) goto L7;
    L22:
        TextView r13 = this.n;
        s.c r14 = this.b;
        if (r14 == null) goto L29;
        SkuStatusDetail r15 = r14.b;
        if (r15 == null) goto L29;
        String r16 = r15.getDesc();
        if (r16 == null) goto L29;
    L30:
        r13.setText(r16);
        int r17 = com.bytedance.android.ec.core.utils.s.a;
        s.c r18 = this.b;
        String r19 = null;
        if (r18 == null) goto L35;
        SkuStatusDetail r110 = r18.b;
        if (r110 == null) goto L35;
        String r111 = r110.getDescBgColor();
    L36:
        Integer r112 = com.bytedance.android.ec.core.utils.s.b(r111);
        if (r112 == null) goto L45;
        int r113 = r112.intValue();
        int r10 = g1.a;
        Drawable r20 = g1.a.b(getContext(), 2131248192);
        if (r20 == null) goto L41;
        Drawable r21 = r20.mutate();
    L42:
        if (r21 == null) goto L44;
        r21.setColorFilter(r113, PorterDuff.Mode.SRC_IN);
    L44:
        this.n.setBackground(r21);
        goto L45
    L41:
        r21 = null;
    L45:
        s.c r114 = this.b;
        if (r114 == null) goto L50;
        SkuStatusDetail r115 = r114.b;
        if (r115 == null) goto L50;
        String r116 = r115.getFontColor();
    L51:
        Integer r117 = com.bytedance.android.ec.core.utils.s.b(r116);
        if (r117 == null) goto L54;
        this.n.setTextColor(r117.intValue());
    L54:
        TextView r118 = this.n;
        s.c r22 = this.b;
        if (r22 == null) goto L59;
        SkuStatusDetail r23 = r22.b;
        if (r23 == null) goto L59;
        r19 = r23.getDesc();
    L59:
        if (r19 != null) goto L61;
    L64:
        if (r1 == false) goto L66;
        r0 = 8;
    L66:
        r118.setVisibility(r0);
        return;
    L61:
        if (r19.length() == 0) goto L64;
        r1 = false;
    L50:
        r116 = null;
    L35:
        r111 = null;
    L29:
        r16 = "";
        goto L30
    L7:
        if (r12 == false) goto L15;
        this.f.setAlpha(1.0f);
        this.j.setAlpha(1.0f);
        int r119 = getAtmosphereColor();
        int r24 = ColorProtector.parseColor("#161823");
        if (this.d == false) goto L11;
        this.h.setTextColor(ColorProtector.parseColor("#57161823"));
        GradientDrawable r120 = new GradientDrawable();
        r120.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r120.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r24, 0.05f));
        r120.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r119, 0.5f));
        this.f.setBackgroundDrawable(r120);
        this.h.setTypeface(Typeface.defaultFromStyle(0));
        this.i.setVisibility(0);
        goto L22
    L11:
        this.l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.m.setTextColor(ColorProtector.parseColor("#57161823"));
        GradientDrawable r121 = new GradientDrawable();
        r121.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(6));
        r121.setColor(com.bytedance.android.ec.common.impl.sku.utils.m.a(r24, 0.05f));
        r121.setStroke(vf4.a.b(1), com.bytedance.android.ec.common.impl.sku.utils.m.a(r119, 0.5f));
        this.j.setBackgroundDrawable(r121);
        this.l.setTypeface(Typeface.defaultFromStyle(0));
        this.m.setTypeface(Typeface.defaultFromStyle(0));
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L14;
        this.i.setVisibility(0);
        goto L22
    L14:
        this.i.setVisibility(8);
        goto L22
    L15:
        this.f.setAlpha(1.0f);
        this.j.setAlpha(1.0f);
        if (this.d == false) goto L18;
        this.h.setTextColor(ColorProtector.parseColor("#57161823"));
        this.h.setTypeface(Typeface.defaultFromStyle(0));
        this.f.setBackgroundResource(2131248194);
        this.i.setVisibility(0);
        goto L22
    L18:
        this.l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.m.setTextColor(ColorProtector.parseColor("#57161823"));
        this.l.setTypeface(Typeface.defaultFromStyle(0));
        this.m.setTypeface(Typeface.defaultFromStyle(0));
        this.j.setBackgroundResource(2131248194);
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L21;
        this.i.setVisibility(0);
        goto L22
    L21:
        this.i.setVisibility(8);
        goto L22
    }
}
