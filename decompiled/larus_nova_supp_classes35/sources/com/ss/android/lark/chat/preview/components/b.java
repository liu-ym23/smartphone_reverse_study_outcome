package com.ss.android.lark.chat.preview.components;

import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends q6c.e<DocImageProperty, com.ss.android.lark.chat.preview.components.view.b, r6c.a> {

    public static final class a {
    }

    static {
    }

    public final String i() {
        return "com.ss.android.lark.chat.preview.components.view.DocBearThumbImage";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 != null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    L5:
        return new com.ss.android.lark.chat.preview.components.view.b(r1.getContext());
    }

    public void update(com.ss.android.lark.chat.preview.components.view.b r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        if (r14.getLayoutParams().width > 0) goto L5;
    L7:
        Size r12 = null;
    L8:
        g6b.a.InterfaceC0223a r4 = g6b.a.a;
        if (r4 == null) goto L15;
        LKUIRoundedImageView2 r5 = r14.getThumbImage();
        String r6 = ((DocImageProperty) ((q6c.e) this).e).getThumbnailUrl();
        ((DocImageProperty) ((q6c.e) this).e).getToken();
        int r7 = ((DocImageProperty) ((q6c.e) this).e).getDocType().getNumber();
        Integer r0 = ((DocImageProperty) ((q6c.e) this).e).getSecretType();
        if (r0 == null) goto L13;
        int r8 = r0.intValue();
    L14:
        r4.h(r5, r6, r7, r8, ((DocImageProperty) ((q6c.e) this).e).getSecretUrl(), ((DocImageProperty) ((q6c.e) this).e).getSecretKey(), ((DocImageProperty) ((q6c.e) this).e).getSecretNonce(), r12);
        goto L15
    L13:
        r8 = 0;
    L15:
        TCStyle r1 = ((q6c.b) this).c;
        if ((r1 instanceof Style) == false) goto L18;
        Style r2 = (Style) r1;
    L19:
        if (r2 == null) goto L38;
        Border r3 = r2.getBorder();
        if (r3 == null) goto L25;
        ThemeColor r9 = r3.getThemeColor();
        if (r9 == null) goto L25;
        r14.getThumbImage().setBorderColor(com.ss.android.lark.export.entity.preview.a.a(r9, r14.getContext(), null));
    L25:
        LKUIRoundedImageView2 r10 = r14.getThumbImage();
        Border r11 = r2.getBorder();
        float r13 = 0.0f;
        if (r11 == null) goto L30;
        Float r15 = r11.getWidth();
        if (r15 == null) goto L30;
        float r16 = r15.floatValue();
    L31:
        r10.setBorderWidth(UIHelper.dp2px(r16));
        Border r17 = r2.getBorder();
        if (r17 == null) goto L36;
        Float r18 = r17.getCornerRadius();
        if (r18 == null) goto L36;
        r13 = r18.floatValue();
    L36:
        float r19 = UIHelper.dp2px(r13);
        r14.getThumbImage().setRadius(r19);
        r14.getThumbImageMask().setRadius(r19);
        return;
    L30:
        r16 = 0.0f;
        goto L31
    L38:
        return;
    L18:
        r2 = null;
        goto L19
    L5:
        if (r14.getLayoutParams().height <= 0) goto L7;
        r12 = new Size(r14.getLayoutParams().width, r14.getLayoutParams().height);
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((com.ss.android.lark.chat.preview.components.view.b) r1);
    }

    public b(DocImageProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
    }
}
