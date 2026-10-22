package com.ss.android.lark.chat.preview.components;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView;
import com.ss.android.lark.chat.preview.entity.component.property.AvatarProperty;
import com.ss.android.lark.export.entity.preview.AvatarChatterInfo;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.tangram.base.style.Value;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends q6c.e<AvatarProperty, LKUIRoundedImageView2, r6c.a> {
    public final Style f;
    public final com.ss.android.lark.chat.preview.actions.b g;
    public final URLPreviewParams h;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.components.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0107a implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ LKUIRoundedImageView2 b;

        public ViewOnClickListenerC0107a(a r1, LKUIRoundedImageView2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.ss.android.lark.chat.preview.actions.b r4 = this.a.g;
            if (r4 == null) goto L5;
            int r0 = com.ss.android.lark.chat.preview.actions.b.h;
            r4.a(1);
        L5:
            AvatarChatterInfo r5 = ((AvatarProperty) ((q6c.e) this.a).e).getChatterInfo();
            if (r5 == null) goto L8;
            r5.getAvatarKey();
        L8:
            g6b.a.InterfaceC0223a r6 = g6b.a.a;
            if (r6 == null) goto L17;
            com.ss.android.lark.officesdk.integrator.im.b r7 = r6.getCoreDependency();
            if (r7 == null) goto L18;
            Context r1 = this.b.getContext();
            AvatarChatterInfo r2 = ((AvatarProperty) ((q6c.e) this.a).e).getChatterInfo();
            if (r2 == null) goto L15;
            r2.getChatterId();
        L15:
            String r8 = this.a.h.f;
            r7.b(r1);
            return;
        L18:
            return;
        }
    }

    public final String i() {
        return "com.larksuite.component.ui.imageview.LKUIRoundedImageView2";
    }

    public final View a(RectF r10) {
        Intrinsics.checkNotNullParameter(r10, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L24;
        LKUIRoundedImageView2 r11 = new LKUIRoundedImageView2(r1.getContext(), null, 0, 6, null);
        Style r0 = this.f;
        if (r0 == null) goto L23;
        Border r3 = r0.getBorder();
        if (r3 == null) goto L11;
        ThemeColor r4 = r3.getThemeColor();
        if (r4 == null) goto L11;
        r11.setBorderColor(com.ss.android.lark.export.entity.preview.a.a(r4, r1.getContext(), null));
    L11:
        Border r2 = r0.getBorder();
        float r5 = 0.0f;
        if (r2 == null) goto L16;
        Float r6 = r2.getWidth();
        if (r6 == null) goto L16;
        float r7 = r6.floatValue();
    L17:
        r11.setBorderWidth(UIHelper.dp2px(r7));
        Border r8 = r0.getBorder();
        if (r8 == null) goto L22;
        Float r9 = r8.getCornerRadius();
        if (r9 == null) goto L22;
        r5 = r9.floatValue();
    L22:
        r11.setRadius(r5);
        r11.setOval(true);
    L16:
        r7 = 0.0f;
    L23:
        return r11;
    L24:
        Intrinsics.checkNotNullParameter(r10, "size");
        return null;
    }

    public void update(LKUIRoundedImageView2 r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.update(r6);
        float r1 = 0.0f;
        if (r6.getLayoutParams().width <= 0) goto L5;
        int r0 = r6.getLayoutParams().width;
    L15:
        if (r6.getLayoutParams().height <= 0) goto L17;
        int r2 = r6.getLayoutParams().height;
    L25:
        AvatarChatterInfo r3 = ((AvatarProperty) ((q6c.e) this).e).getChatterInfo();
        String r4 = null;
        if (r3 == null) goto L28;
        String r5 = r3.getAvatarKey();
    L29:
        AvatarChatterInfo r7 = ((AvatarProperty) ((q6c.e) this).e).getChatterInfo();
        if (r7 == null) goto L32;
        r4 = r7.getChatterId();
    L32:
        AvatarImage r8 = AvatarImage.Builder.obtain(r5, r4, r0, r2).build();
        com.ss.android.lark.image.entity.a r9 = CrescentAvatarListView.a(r6.getContext(), r0, r2);
        IRequestCreator r10 = ImageLoader.with(r6.getContext()).load(r8);
        g6b.a.InterfaceC0223a r11 = g6b.a.a;
        if (r11 == null) goto L35;
        r11.c();
    L35:
        r10.isAsync(false).placeholder(r9).override(r0, r2).into(r6);
        r6.setOnClickListener(new ViewOnClickListenerC0107a(this, r6));
        return;
    L28:
        r5 = null;
        goto L29
    L17:
        Style r12 = this.f;
        if (r12 == null) goto L24;
        Value r13 = r12.getScaleHeight();
        if (r13 == null) goto L24;
        Float r14 = r13.getValue();
        if (r14 == null) goto L24;
        r1 = r14.floatValue();
    L24:
        r2 = UIHelper.dp2px(r1);
        goto L25
    L5:
        Style r15 = this.f;
        if (r15 == null) goto L12;
        Value r16 = r15.getScaleWidth();
        if (r16 == null) goto L12;
        Float r17 = r16.getValue();
        if (r17 == null) goto L12;
        float r18 = r17.floatValue();
    L13:
        r0 = UIHelper.dp2px(r18);
    L12:
        r18 = 0.0f;
        goto L13
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUIRoundedImageView2) r1);
    }

    public a(AvatarProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = null;
        this.h = r4.d;
    }
}
