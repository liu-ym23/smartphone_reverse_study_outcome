package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends RelativeLayout implements IIndicatorView {
    public final String a;
    public final TextView b;
    public Function0<Unit> c;
    public final View d;
    public final View e;
    public int f;
    public int g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "adapter");
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    public final void a() {
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0.setText(String.format(Locale.getDefault(), this.a, Arrays.copyOf(new Object[]{Integer.valueOf(this.g + 1), Integer.valueOf(this.f)}, 2)));
        return;
    }

    public final int getCount() {
        return this.f;
    }

    public final int getCurrentPos() {
        return this.g;
    }

    public final void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    public final void onTransitionBegin(int r10) {
        if (r10 != 0) goto L4;
    L5:
        setVisibility(8);
        return;
    L4:
        if (r10 == 3) goto L5;
    }

    public final void onTransitionEnd(int r10) {
        if (r10 != 0) goto L4;
    L5:
        setVisibility(0);
        return;
    L4:
        if (r10 == 1) goto L5;
    }

    public final void setCount(int r1) {
        this.f = r1;
        a();
    }

    public final void setCurrentPos(int r1) {
        this.g = r1;
        a();
    }

    public final void setOnBackPressListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.c = r10;
    }

    public final void setOnClickDetailButton(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(r10));
    L5:
        View r1 = this.e;
        if (r1 == null) goto L9;
        r1.setOnClickListener(new b(r10));
        return;
    }

    public final void onAttach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r10, r11);
    }

    public final void onDetach(int r10, TransitionPagerAdapter<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r10, r11);
    }

    public d(Context r10, boolean r11, String r12, com.bytedance.android.ec.core.gallery2.opt.b r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, null, 0);
        this.a = "%s/%s";
        LayoutInflater.from(r10).inflate(2131560931, this, true);
        this.b = (TextView) findViewById(2131389165);
        ((ImageView) findViewById(2131389162)).setOnClickListener(new c(this));
        View r14 = findViewById(2131368892);
        this.d = r14;
        View r0 = findViewById(2131368891);
        this.e = r0;
        if (r11 == false) goto L14;
        if (r13 == null) goto L7;
        r13.Q70(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "product_detail_entrance")}));
    L7:
        if (k.c(r12) == false) goto L11;
        h0.e(findViewById(2131379458), r12, new r("ec_buy_now", "buy_now_sku_gallery"), null, null, 120);
        ViewExtensionsKt.g(findViewById(2131379458), 6.0f, 6.0f, 6.0f, 6.0f);
        if (r0 == null) goto L15;
        r0.setVisibility(0);
        return;
    L15:
        return;
    L11:
        if (r14 == null) goto L17;
        r14.setVisibility(0);
        return;
    L17:
        return;
    }
}
