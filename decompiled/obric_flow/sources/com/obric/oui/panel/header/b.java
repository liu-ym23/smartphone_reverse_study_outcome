package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.oui.divider.ODivider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContextThemeWrapper f14007c;
    public final AppCompatImageView d;
    public final ImageView e;
    public final View f;
    public final View g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f14008h;

    public b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f14005a = false;
        this.f14006b = 0;
        View r5 = View.inflate(a(this, r10), R$layout.o_basic_panel_normal_header, null);
        this.f14008h = r5;
        ContextThemeWrapper r11 = this.f14007c;
        if (r11 != null) goto L5;
        r11 = a(this, r10);
    L5:
        int r12 = R$attr.oui_PanelDefaultHeaderHeight;
        int r13 = R$dimen.oui_panel_default_header_height;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r11, "context");
        TypedValue r14 = new TypedValue();
        if (r11.getTheme().resolveAttribute(r12, r14, true) == true) goto L9;
        r14 = null;
    L9:
        if (r14 != null) goto L11;
    L15:
        float r15 = r11.getResources().getDimension(r13);
    L14:
        int r16 = (int) r15;
        r5.setBackgroundColor(0);
        AppCompatImageView r17 = (AppCompatImageView) r5.findViewById(R$id.iv_close);
        this.d = r17;
        TextView r18 = (TextView) r5.findViewById(R$id.tv_title);
        ImageView r19 = (ImageView) r5.findViewById(R$id.iv_back);
        this.e = r19;
        ODivider r20 = (ODivider) r5.findViewById(R$id.divider);
        this.f = r5.findViewById(R$id.grabber);
        View r21 = r5.findViewById(R$id.main_view);
        this.g = r21;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L29;
        r22.height = r16;
        r21.setLayoutParams(r22);
        if (TextUtils.isEmpty(null) == true) goto L24;
        Intrinsics.checkNotNull(null);
        Boolean r110 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(null, "charSequence");
        r18.setText(null);
        r18.setCompoundDrawables(null, null, null, null);
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L24;
        r18.setTypeface(Typeface.defaultFromStyle(1));
    L24:
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L26;
        int r23 = com.lynx.tasm.utils.a.B(44, r5);
        d.p(r5, r23, r23, new View[]{r19, r17});
        return;
    L26:
        r5.addOnAttachStateChangeListener(new a(r5, this));
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        if (r14.type != 5) goto L15;
        r15 = r14.getDimension(r11.getResources().getDisplayMetrics());
        goto L14
    }

    public static ContextThemeWrapper a(b r5, Context r10) {
        boolean r11 = r5.f14005a;
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        int r12 = r5.f14006b;
        if (r12 != 0) goto L10;
        if (r11 == false) goto L7;
        ContextThemeWrapper r13 = new ContextThemeWrapper(r10, R$style.OBasicPanelDayNightSwitch);
    L8:
        r5.f14007c = r13;
        return r13;
    L7:
        r13 = new ContextThemeWrapper(r10, R$style.OBasicPanelConstLight);
        goto L8
    L10:
        return new ContextThemeWrapper(r10, r12);
    }
}
