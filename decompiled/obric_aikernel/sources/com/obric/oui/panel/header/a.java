package com.obric.oui.panel.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.obric.oui.common.util.k;
import com.obric.oui.divider.ODivider;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.d;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatImageView f7000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f7001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f7002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f7003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View f7004j;

    /* JADX INFO: renamed from: com.obric.oui.panel.header.a$a, reason: collision with other inner class name */
    public static final class ViewOnAttachStateChangeListenerC0131a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f7005c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f7006g;

        public ViewOnAttachStateChangeListenerC0131a(View r10, a r11) {
            this.f7005c = r10;
            this.f7006g = r11;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            Intrinsics.checkParameterIsNotNull(r10, "view");
            this.f7005c.removeOnAttachStateChangeListener(this);
            Resources r11 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
            int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, r11.getDisplayMetrics()));
            k.d(a.h(this.f7006g), r12, r12, new View[]{a.f(this.f7006g), a.g(this.f7006g)});
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            Intrinsics.checkParameterIsNotNull(r10, "view");
        }
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, false);
    }

    public /* synthetic */ a(Context r10, View.OnClickListener r11, CharSequence r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public a(Context r10, View.OnClickListener r11, CharSequence r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r13, 0, 4, null);
        View r14 = View.inflate(b.b(this, r10, false, 2, null), h.o_basic_panel_normal_header, null);
        Intrinsics.checkNotNullExpressionValue(r14, "View.inflate(generateThe…anel_normal_header, null)");
        this.f7004j = r14;
        int r15 = com.obric.oui.common.util.a.f6396a.b(d(), u8.b.oui_PanelDefaultHeaderHeight, d.oui_panel_default_header_height);
        r14.setBackgroundColor(0);
        View r16 = r14.findViewById(f.iv_close);
        Intrinsics.checkNotNullExpressionValue(r16, "rootView.findViewById(R.id.iv_close)");
        this.f7000f = (AppCompatImageView) r16;
        View r17 = r14.findViewById(f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r17, "rootView.findViewById(R.id.tv_title)");
        this.f7001g = (TextView) r17;
        View r18 = r14.findViewById(f.iv_back);
        Intrinsics.checkNotNullExpressionValue(r18, "rootView.findViewById(R.id.iv_back)");
        this.f7002h = (ImageView) r18;
        View r19 = r14.findViewById(f.divider);
        Intrinsics.checkNotNullExpressionValue(r19, "rootView.findViewById(R.id.divider)");
        ODivider r20 = (ODivider) r19;
        Intrinsics.checkNotNullExpressionValue(r14.findViewById(f.grabber), "rootView.findViewById(R.id.grabber)");
        View r21 = r14.findViewById(f.main_view);
        Intrinsics.checkNotNullExpressionValue(r21, "rootView.findViewById(R.id.main_view)");
        this.f7003i = r21;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L16;
        r22.height = r15;
        r21.setLayoutParams(r22);
        if (r11 == null) goto L8;
        i(r11);
    L8:
        if (TextUtils.isEmpty(r12) == true) goto L11;
        Intrinsics.checkNotNull(r12);
        k(this, r12, null, null, 6, null);
    L11:
        if (ViewCompat.isAttachedToWindow(r14) == false) goto L13;
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        int r24 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, r23.getDisplayMetrics()));
        k.d(h(this), r24, r24, new View[]{f(this), g(this)});
        return;
    L13:
        r14.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0131a(r14, this));
        return;
    L16:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ ImageView f(a r10) {
        return r10.f7002h;
    }

    public static final /* synthetic */ AppCompatImageView g(a r10) {
        return r10.f7000f;
    }

    public static final /* synthetic */ View h(a r10) {
        return r10.f7004j;
    }

    public static /* synthetic */ void k(a r10, CharSequence r11, Drawable r12, Boolean r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = Boolean.FALSE;
    L9:
        r10.j(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
    }

    @Override // com.obric.oui.panel.header.b
    public View e() {
        return this.f7004j;
    }

    public final void i(View.OnClickListener r10) {
        AppCompatImageView r11 = this.f7000f;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        k.a(r11, MathKt.roundToInt(TypedValue.applyDimension(1, 44, r12.getDisplayMetrics())));
        this.f7000f.setOnClickListener(r10);
    }

    public final void j(CharSequence r10, Drawable r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "charSequence");
        this.f7001g.setText(r10);
        if (r11 == null) goto L5;
        r11.setBounds(0, 0, 70, 70);
    L5:
        this.f7001g.setCompoundDrawables(r11, null, null, null);
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L9;
        this.f7001g.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }
}
