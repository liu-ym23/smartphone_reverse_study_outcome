package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.preview.entity.component.property.IGProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.Gradient;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends q6c.e<IGProperty, LKUIRoundableLayout, r6c.a> {
    public final com.ss.android.lark.chat.preview.actions.b f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.ss.android.lark.chat.preview.actions.b r3 = this.a.f;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r3.a(1);
        }
    }

    public final void e(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final String i() {
        return "com.larksuite.component.ui.layout.LKUIRoundableLayout";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r5) {
        Intrinsics.checkNotNullParameter(r5, "size");
        if (((q6c.a) this).a == null) goto L6;
        r6c.a r0 = ((q6c.a) this).a;
        Intrinsics.checkNotNull(r0);
        LKUIRoundableLayout r6 = new LKUIRoundableLayout(r0.getContext(), null, 6, 0);
        r6.setTag(((q6c.a) this).b);
        return r6;
    L6:
        Intrinsics.checkNotNullParameter(r5, "size");
        return null;
    }

    public void update(LKUIRoundableLayout r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.update(r6);
        TCStyle r0 = ((q6c.b) this).c;
        if ((r0 instanceof Style) == false) goto L35;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Border r1 = ((Style) r0).getBorder();
        if (r1 == null) goto L11;
        Float r2 = r1.getCornerRadius();
        if (r2 == null) goto L9;
        float r3 = r2.floatValue();
    L10:
        r6.setRadius(r3);
        goto L11
    L9:
        r3 = 0.0f;
    L11:
        TCStyle r4 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Gradient r5 = ((Style) r4).getBackgroundColor();
        if (r5 == null) goto L14;
        Gradient.Content r7 = r5.getContent();
    L16:
        if (((IGProperty) ((q6c.e) this).e).getMaskColor() == null) goto L35;
        if ((r7 instanceof Gradient.Linear) == false) goto L35;
        Gradient.Linear r8 = (Gradient.Linear) r7;
        ArrayList<ThemeColor> r9 = r8.getThemeColors();
        if (r9 == null) goto L22;
        int r10 = r9.size();
    L23:
        if (r10 <= 0) goto L35;
        ArrayList<ThemeColor> r11 = r8.getThemeColors();
        if (r11 == null) goto L27;
        ThemeColor r12 = (ThemeColor) ListProtector.get(r11, 0);
    L28:
        if (r12 == null) goto L35;
        hz7.a r13 = new hz7.a();
        ArrayList<ThemeColor> r14 = r8.getThemeColors();
        if (r14 == null) goto L32;
        ThemeColor r15 = (ThemeColor) ListProtector.get(r14, 0);
    L33:
        Intrinsics.checkNotNull(r15);
        r13.setColor(com.ss.android.lark.export.entity.preview.a.a(r15, r6.getContext(), null));
        ThemeColor r16 = ((IGProperty) ((q6c.e) this).e).getMaskColor();
        Intrinsics.checkNotNull(r16);
        r13.b(com.ss.android.lark.export.entity.preview.a.a(r16, r6.getContext(), null));
        r6.setBackground(r13);
        goto L35
    L32:
        r15 = null;
        goto L33
    L27:
        r12 = null;
        goto L28
    L22:
        r10 = 0;
        goto L23
    L14:
        r7 = null;
    L35:
        if (this.f != null) goto L37;
        r6.setOnClickListener(null);
        r6.setClickable(false);
        return;
    L37:
        r6.setOnClickListener(new a(this));
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUIRoundableLayout) r1);
    }

    public d(IGProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = null;
    }
}
