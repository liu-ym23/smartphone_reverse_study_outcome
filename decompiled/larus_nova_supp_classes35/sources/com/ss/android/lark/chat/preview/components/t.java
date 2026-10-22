package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.preview.entity.component.property.TagListProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.Gradient;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t extends q6c.e<TagListProperty, com.ss.android.lark.chat.preview.components.view.f, r6c.a> {
    public final com.ss.android.lark.chat.preview.actions.b f;
    public int g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.f;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    static {
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.view.TagListView";
    }

    public final boolean j() {
        return true;
    }

    public final float l() {
        r6c.a r0 = ((q6c.a) this).a;
        if (r0 == null) goto L17;
        Context r1 = r0.getContext();
        if (r1 == null) goto L19;
        int r2 = h6b.a.a;
        TCStyle r3 = ((q6c.b) this).c;
        if ((r3 instanceof Style) == false) goto L10;
        Style r4 = (Style) r3;
    L11:
        if (r4 == null) goto L14;
        FontLevel r5 = r4.getFontLevel();
        if (r5 == null) goto L14;
    L16:
        return h6b.a.c(r1, r5);
    L14:
        r5 = new FontLevel(null, 0, 3, null);
        goto L16
    L10:
        r4 = null;
        goto L11
    L19:
        return 0.0f;
    L17:
        return 0.0f;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new com.ss.android.lark.chat.preview.components.view.f(r1.getContext());
    }

    public final s6c.b.a d(s6c.b.a r7) {
        Intrinsics.checkNotNullParameter(r7, "size");
        List<String> r0 = ((TagListProperty) ((q6c.e) this).e).getTagString();
        if (r0 == null) goto L11;
        TextPaint r1 = new TextPaint();
        r1.setTextSize(l());
        StringBuilder r2 = new StringBuilder();
        Iterator<String> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.append(r3.next());
        goto L6
    L8:
        String r4 = r2.toString();
        Rect r5 = new Rect();
        r1.getTextBounds(r4, 0, r4.length(), r5);
        int r6 = (UIHelper.px2dp(r5.width()) + (r0.size() * 4)) + ((r0.size() * 2) * 4);
        this.g = (UIHelper.px2dp(r5.height()) + 4) + 2;
        return new s6c.b.a(Math.min(r6, r7.a), this.g);
    L11:
        return new s6c.b.a(0.0f, 0.0f);
    }

    public final int k(Context r4) {
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L5;
        Style r1 = (Style) r0;
    L6:
        if (r1 == null) goto L16;
        Gradient r2 = r1.getBackgroundColor();
        if (r2 == null) goto L16;
        Gradient.Content r3 = r2.getContent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
        ArrayList<ThemeColor> r5 = ((Gradient.Linear) r3).getThemeColors();
        if (r5 == null) goto L16;
        if ((!r5.isEmpty()) == false) goto L16;
        return com.ss.android.lark.export.entity.preview.a.a((ThemeColor) ListProtector.get(r5, 0), r4, null);
    L16:
        return r4.getResources().getColor(2131109109);
    L5:
        r1 = null;
        goto L6
    }

    public void update(com.ss.android.lark.chat.preview.components.view.f r19) {
        Intrinsics.checkNotNullParameter(r19, "view");
        r19.getContext();
        ncc.g r2 = new ncc.g();
        if ((((q6c.b) this).c instanceof Style) == false) goto L7;
        r19.getTextView().setTextSize(0, l());
        TCStyle r3 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        ThemeColor r4 = ((Style) r3).getTextColorV2();
        if (r4 == null) goto L7;
        r19.getTextView().setTextColor(com.ss.android.lark.export.entity.preview.a.a(r4, r19.getContext(), null));
    L7:
        List<String> r5 = ((TagListProperty) ((q6c.e) this).e).getTagString();
        if (r5 == null) goto L44;
        if (r5.size() != 1) goto L22;
        r19.getTextView().setText((CharSequence) ListProtector.get(r5, 0));
        r19.getTextView().setSingleLine();
        r19.getTextView().setIncludeFontPadding(false);
        r19.getTextView().setGravity(17);
        int r6 = UIHelper.dp2px(4.0f);
        float r7 = 2.0f;
        UIHelper.dp2px(2.0f);
        r19.getTextView().setPadding(r6, 0, r6, 0);
        TextView r8 = r19.getTextView();
        r8.setBackground(null);
        GradientDrawable r9 = new GradientDrawable();
        r9.setColor(k(r8.getContext()));
        TCStyle r10 = ((q6c.b) this).c;
        if ((r10 instanceof Style) == false) goto L14;
        Style r11 = (Style) r10;
    L15:
        if (r11 == null) goto L21;
        Border r12 = r11.getBorder();
        if (r12 == null) goto L21;
        Float r13 = r12.getCornerRadius();
        if (r13 == null) goto L21;
        r7 = r13.floatValue();
    L21:
        r9.setCornerRadius(UIHelper.dp2px(r7));
        r8.setBackground(r9);
        goto L44
    L14:
        r11 = null;
        goto L15
    L22:
        r19.getTextView().setIncludeFontPadding(false);
        r19.getTextView().setPadding(0, 0, 0, 0);
        TCStyle r14 = ((q6c.b) this).c;
        if ((r14 instanceof Style) == false) goto L25;
        Style r15 = (Style) r14;
    L26:
        if (r15 == null) goto L30;
        ThemeColor r16 = r15.getTextColorV2();
        if (r16 == null) goto L30;
        int r17 = com.ss.android.lark.export.entity.preview.a.a(r16, r19.getContext(), null);
    L31:
        int r18 = k(r19.getContext());
        IntIterator r110 = CollectionsKt.getIndices(r5).iterator();
    L33:
        if (r110.hasNext() == false) goto L42;
        int r20 = r110.nextInt();
        String r21 = (String) ListProtector.get(r5, r20);
        if (r21 == null) goto L33;
        if (r20 != 0) goto L39;
        int r111 = 0;
    L40:
        r2.b("$", new com.ss.android.lark.chat.preview.components.view.h(new com.ss.android.lark.chat.preview.components.view.g(r19.getContext(), r21, r18, r17, r111, l(), this.g - 2)), 34);
        goto L33
    L39:
        r111 = 4;
        goto L40
    L42:
        r19.getTextView().setText(r2);
    L30:
        r17 = r19.getContext().getResources().getColor(2131108724);
        goto L31
    L25:
        r15 = null;
    L44:
        if (this.f != null) goto L46;
        r19.setOnClickListener(null);
        r19.setClickable(false);
        return;
    L46:
        r19.setOnClickListener(new b(this));
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((com.ss.android.lark.chat.preview.components.view.f) r1);
    }

    public t(TagListProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "prop");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = null;
    }
}
