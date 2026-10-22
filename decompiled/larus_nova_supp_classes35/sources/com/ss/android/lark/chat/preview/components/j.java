package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chat.preview.entity.component.property.OverSizeTextProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends q6c.e<OverSizeTextProperty, TextView, r6c.a> {
    public final Style f;
    public final com.ss.android.lark.chat.preview.actions.b g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OverSizeTextProperty.FontWeight.values().length];
            r0[OverSizeTextProperty.FontWeight.REGULAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OverSizeTextProperty.FontWeight.SEMI_BOLD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ j a;

        public c(j r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.g;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    static {
    }

    public final String i() {
        return "android.widget.TextView";
    }

    public final boolean j() {
        return true;
    }

    public final View a(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "size");
        r6c.a r3 = ((q6c.a) this).a;
        if (r3 != null) goto L5;
        return null;
    L5:
        return new TextView(r3.getContext());
    }

    public final s6c.b.a d(s6c.b.a r11) {
        Intrinsics.checkNotNullParameter(r11, "size");
        int r1 = UIHelper.dp2px(r11.a);
        r6c.a r2 = ((q6c.a) this).a;
        if (r2 == null) goto L55;
        Context r3 = r2.getContext();
        if (r3 == null) goto L55;
        float r4 = ((OverSizeTextProperty) ((q6c.e) this).e).getFontSize();
        Resources r5 = r3.getResources();
        int r6 = 1;
        float r7 = a08.b.a(TypedValue.applyDimension(1, r4, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())), r3);
        Style r8 = this.f;
        FontLevel r9 = null;
        if (r8 == null) goto L12;
        ThemeColor r10 = r8.getTextColorV2();
        if (r10 == null) goto L12;
        int r12 = com.ss.android.lark.export.entity.preview.a.a(r10, r3, null);
    L13:
        int r13 = h6b.a.a;
        Style r14 = this.f;
        if (r14 == null) goto L17;
        r9 = r14.getFontLevel();
    L17:
        if (h6b.a.a(r9) == false) goto L19;
        Typeface r15 = h18.e.b(r3, 1);
    L21:
        if (((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L23;
        int r16 = ((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines();
    L24:
        TextLayoutBuilder r17 = new TextLayoutBuilder();
        r17.h(((OverSizeTextProperty) ((q6c.e) this).e).getText());
        r17.j(MathKt.roundToInt(r7));
        r17.i(r12);
        r17.f(r1);
        r17.g(true);
        r17.e(r16);
        r17.m(r15);
        Layout r18 = r17.a();
        if (r18 != null) goto L28;
        Intrinsics.checkNotNullParameter(r11, "size");
        return r11;
    L28:
        Style r19 = this.f;
        float r0 = 0.0f;
        if (r19 == null) goto L31;
        float r110 = r19.getWidth();
    L32:
        int r111 = UIHelper.dp2px(r110);
        if (r111 <= 0) goto L36;
    L39:
        int r20 = UIHelper.px2dp(r111);
        if (UIHelper.dp2px(r20) == r111) goto L43;
        r6 = 2;
    L43:
        float r21 = r20 + r6;
        if (r111 == 0) goto L54;
        if ((r18 instanceof StaticLayout) == true) goto L49;
    L51:
        int r112 = r18.getHeight() - 0;
    L52:
        r0 = UIHelper.px2dp(r112);
        goto L54
    L49:
        if (((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L51;
        StaticLayout r22 = (StaticLayout) r18;
        r112 = r22.getLineTop(Math.min(((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines(), r22.getLineCount()));
    L54:
        return new s6c.b.a(r21, r0);
    L36:
        if (r18.getWidth() <= 0) goto L38;
        r111 = r18.getWidth();
        goto L39
    L38:
        r111 = 0;
        goto L39
    L31:
        r110 = 0.0f;
        goto L32
    L23:
        r16 = Integer.MAX_VALUE;
        goto L24
    L19:
        r15 = h18.e.b(r3, 0);
    L12:
        r12 = UIHelper.getColor(2131106622);
    L55:
        Intrinsics.checkNotNullParameter(r11, "size");
        return r11;
    }

    public void update(TextView r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        r7.setText(((OverSizeTextProperty) ((q6c.e) this).e).getText());
        r7.setIncludeFontPadding(false);
        r7.setGravity(16);
        if (((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L5;
        r7.setMaxLines(((OverSizeTextProperty) ((q6c.e) this).e).getNumberOfLines());
        r7.setEllipsize(TextUtils.TruncateAt.END);
    L6:
        Context r1 = r7.getContext();
        Style r2 = this.f;
        if (r2 == null) goto L11;
        ThemeColor r3 = r2.getTextColorV2();
        if (r3 == null) goto L11;
        int r4 = com.ss.android.lark.export.entity.preview.a.a(r3, r1, null);
    L12:
        r7.setTextColor(r4);
        r7.setTextSize(2, ((OverSizeTextProperty) ((q6c.e) this).e).getFontSize());
        TextPaint r5 = r7.getPaint();
        int r6 = b.a[((OverSizeTextProperty) ((q6c.e) this).e).getFontWeight().ordinal()];
        boolean r8 = true;
        if (r6 == 1) goto L18;
        if (r6 != 2) goto L17;
    L19:
        r5.setFakeBoldText(r8);
        if (this.g != null) goto L22;
        r7.setOnClickListener(null);
        r7.setClickable(false);
    L23:
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L26;
        Style r9 = (Style) r0;
    L27:
        if (r9 == null) goto L30;
        Style.applyBackground$default(r9, r7, null, 2, null);
        return;
    L30:
        return;
    L26:
        r9 = null;
        goto L27
    L22:
        r7.setOnClickListener(new c(this));
        goto L23
    L17:
        throw new NoWhenBranchMatchedException();
    L18:
        r8 = false;
    L11:
        r4 = UIHelper.getColor(2131106622);
        goto L12
    L5:
        r7.setMaxLines(Integer.MAX_VALUE);
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((TextView) r1);
    }

    public j(OverSizeTextProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "prop");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = null;
    }
}
