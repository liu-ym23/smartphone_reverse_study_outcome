package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.view.View;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.chat.preview.entity.component.property.EmptyProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.UrlPreviewAction;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.officesdk.integrator.im.InitChatPreviewTask;
import com.ss.android.lark.tangram.base.style.TCStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends q6c.e<EmptyProperty, LKUIRoundableLayout, r6c.a> {
    public final com.ss.android.lark.chat.preview.actions.b f;
    public final String g;
    public final URLPreviewParams h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            com.ss.android.lark.chat.preview.actions.b r12 = this.a.f;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r12.a(1);
            UrlPreviewAction r13 = this.a.f.a;
            g6b.a.InterfaceC0223a r1 = g6b.a.a;
            if (r1 == null) goto L19;
            com.ss.android.lark.officesdk.integrator.im.a r2 = r1.a();
            if (r2 == null) goto L20;
            String r3 = null;
            if (r13 == null) goto L9;
            String r4 = r13.getUrl();
        L10:
            c r14 = this.a;
            URLPreviewParams r5 = r14.h;
            String r6 = r5.a;
            String r7 = r14.g;
            String r15 = r14.f.b;
            Long r8 = r5.h;
            if (r8 == null) goto L13;
            String r9 = r8.toString();
        L14:
            Long r10 = this.a.h.i;
            if (r10 == null) goto L17;
            r3 = r10.toString();
        L17:
            r2.c(r4, r6, "container", r7, r15, r9, r3, this.a.h.e);
            return;
        L13:
            r9 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L20:
            return;
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
        r6.setTag(2131392636, ((q6c.a) this).b);
        return r6;
    L6:
        Intrinsics.checkNotNullParameter(r5, "size");
        return null;
    }

    public void update(LKUIRoundableLayout r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.update(r8);
        if ((((q6c.b) this).c instanceof Style) == false) goto L32;
        if (r8.getId() != 2131382951) goto L19;
        r6c.a r0 = ((q6c.a) this).a;
        if ((r0 instanceof vcb.d) == false) goto L9;
        vcb.d r1 = (vcb.d) r0;
    L10:
        if (r1 == null) goto L16;
        URLPreviewParams r2 = r1.d;
        if (r2 == null) goto L16;
        if (r2.l != true) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        r8.setBackground(null);
        r8.setBackgroundColor(UDColorUtils.getColor(r8.getContext(), 2131100557));
    L24:
        TCStyle r4 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Border r5 = ((Style) r4).getBorder();
        if (r5 == null) goto L32;
        Float r6 = r5.getCornerRadius();
        if (r6 == null) goto L29;
        float r7 = r6.floatValue();
    L30:
        r8.setRadius(r7);
        goto L32
    L29:
        r7 = 6.0f;
    L16:
        r3 = false;
        goto L17
    L9:
        r1 = null;
    L19:
        TCStyle r9 = ((q6c.b) this).c;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Style");
        Style r10 = (Style) r9;
        g6b.a.InterfaceC0223a r11 = g6b.a.a;
        if (r11 == null) goto L22;
        r11.e();
        InitChatPreviewTask.b r12 = InitChatPreviewTask.b.a;
    L23:
        r10.applyBackground(r8, r12);
        goto L24
    L22:
        r12 = null;
    L32:
        if (this.f != null) goto L37;
        if (r8.getId() == 2131382951) goto L37;
        r8.setOnClickListener(null);
        r8.setClickable(false);
        return;
    L37:
        if (this.f == null) goto L41;
        r8.setClickable(true);
        r8.setOnClickListener(new a(this));
        return;
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUIRoundableLayout) r1);
    }

    public c(EmptyProperty r2, Style r3, vcb.d r4, com.ss.android.lark.chat.preview.actions.b r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r5;
        this.g = r6;
        this.h = r4.d;
    }
}
