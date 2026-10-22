package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.officesdk.integrator.im.InitChatPreviewTask;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u extends q6c.e<TextViewProperty, TextView, r6c.a> {
    public static final float h = 0.0f;
    public final Style f;
    public final com.ss.android.lark.chat.preview.actions.b g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.g;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    public final String i() {
        return "android.widget.TextView";
    }

    public final boolean j() {
        return true;
    }

    static {
        h = UIHelper.dp2px(3.0f);
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new TextView(r1.getContext());
    }

    public final s6c.b.a d(s6c.b.a r12) {
        Intrinsics.checkNotNullParameter(r12, "size");
        int r1 = UIHelper.dp2px(r12.a);
        r6c.a r2 = ((q6c.a) this).a;
        if (r2 == null) goto L59;
        Context r3 = r2.getContext();
        if (r3 == null) goto L59;
        int r4 = h6b.a.a;
        Style r5 = this.f;
        if (r5 == null) goto L10;
        FontLevel r6 = r5.getFontLevel();
    L11:
        int r7 = (int) h6b.a.c(r3, r6);
        int r8 = k(r3);
        Style r9 = this.f;
        if (r9 == null) goto L14;
        FontLevel r10 = r9.getFontLevel();
    L15:
        int r11 = 1;
        if (h6b.a.a(r10) == false) goto L18;
        Typeface r13 = h18.e.b(r3, 1);
    L20:
        if (((TextViewProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L22;
        int r14 = ((TextViewProperty) ((q6c.e) this).e).getNumberOfLines();
    L23:
        TextLayoutBuilder r15 = new TextLayoutBuilder();
        r15.h(((TextViewProperty) ((q6c.e) this).e).getText());
        r15.j(r7);
        r15.i(r8);
        r15.f(r1);
        r15.g(true);
        r15.e(r14);
        r15.l(zz7.b.d().getMultiplier());
        r15.k(h);
        r15.m(r13);
        r15.d(TextUtils.TruncateAt.END);
        if (Build.VERSION.SDK_INT < 23) goto L28;
        TextLayoutBuilder.a r16 = r15.c;
        if (r16.q == 1) goto L28;
        r16.q = 1;
        r15.d = null;
    L28:
        Layout r17 = r15.a();
        if (r17 != null) goto L32;
        Intrinsics.checkNotNullParameter(r12, "size");
        return r12;
    L32:
        Style r18 = this.f;
        float r0 = 0.0f;
        if (r18 == null) goto L35;
        float r19 = r18.getWidth();
    L36:
        int r110 = UIHelper.dp2px(r19);
        if (r110 <= 0) goto L40;
    L43:
        int r20 = UIHelper.px2dp(r110);
        if (UIHelper.dp2px(r20) == r110) goto L47;
        r11 = 2;
    L47:
        float r21 = r20 + r11;
        if (r110 == 0) goto L58;
        if ((r17 instanceof StaticLayout) == true) goto L53;
    L55:
        int r111 = r17.getHeight() - 0;
    L56:
        r0 = UIHelper.px2dp(r111);
        goto L58
    L53:
        if (((TextViewProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L55;
        StaticLayout r22 = (StaticLayout) r17;
        r111 = r22.getLineTop(Math.min(((TextViewProperty) ((q6c.e) this).e).getNumberOfLines(), r22.getLineCount()));
    L58:
        return new s6c.b.a(r21, r0);
    L40:
        if (r17.getWidth() <= 0) goto L42;
        r110 = r17.getWidth();
        goto L43
    L42:
        r110 = 0;
        goto L43
    L35:
        r19 = 0.0f;
        goto L36
    L22:
        r14 = Integer.MAX_VALUE;
        goto L23
    L18:
        r13 = h18.e.b(r3, 0);
        goto L20
    L14:
        r10 = null;
        goto L15
    L10:
        r6 = null;
    L59:
        Intrinsics.checkNotNullParameter(r12, "size");
        return r12;
    }

    public final int k(Context r3) {
        Style r0 = this.f;
        if (r0 == null) goto L13;
        ThemeColor r1 = r0.getTextColorV2();
        if (r1 == null) goto L13;
        g6b.a.InterfaceC0223a r2 = g6b.a.a;
        if (r2 == null) goto L9;
        r2.e();
        InitChatPreviewTask.b r4 = InitChatPreviewTask.b.a;
    L11:
        return com.ss.android.lark.export.entity.preview.a.a(r1, r3, r4);
    L9:
        r4 = null;
    L13:
        return UIHelper.getColor(2131106622);
    }

    public void update(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.update(r5);
        r5.setText(((TextViewProperty) ((q6c.e) this).e).getText());
        r5.setIncludeFontPadding(false);
        r5.setGravity(16);
        if (((TextViewProperty) ((q6c.e) this).e).getNumberOfLines() <= 0) goto L5;
        r5.setMaxLines(((TextViewProperty) ((q6c.e) this).e).getNumberOfLines());
        r5.setEllipsize(TextUtils.TruncateAt.END);
    L6:
        r5.setTextColor(k(r5.getContext()));
        int r1 = h6b.a.a;
        Context r2 = r5.getContext();
        Style r3 = this.f;
        if (r3 == null) goto L9;
        FontLevel r4 = r3.getFontLevel();
    L10:
        r5.setTextSize(0, h6b.a.c(r2, r4));
        TextPaint r6 = r5.getPaint();
        Style r7 = this.f;
        if (r7 == null) goto L13;
        FontLevel r8 = r7.getFontLevel();
    L14:
        r6.setFakeBoldText(h6b.a.a(r8));
        r5.setLineSpacing(h, zz7.b.d().getMultiplier());
        if (this.g != null) goto L17;
        r5.setOnClickListener(null);
        r5.setClickable(false);
    L18:
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L21;
        Style r9 = (Style) r0;
    L22:
        if (r9 == null) goto L25;
        Style.applyBackground$default(r9, r5, null, 2, null);
        return;
    L25:
        return;
    L21:
        r9 = null;
        goto L22
    L17:
        r5.setOnClickListener(new b(this));
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r5.setMaxLines(Integer.MAX_VALUE);
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((TextView) r1);
    }

    public u(TextViewProperty r2, Style r3, vcb.d r4, com.ss.android.lark.chat.preview.actions.b r5) {
        Intrinsics.checkNotNullParameter(r2, "prop");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = r5;
    }
}
