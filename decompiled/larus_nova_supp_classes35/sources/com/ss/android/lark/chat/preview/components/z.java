package com.ss.android.lark.chat.preview.components;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.ss.android.lark.chat.preview.entity.component.property.UDLoadingProperty;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z extends q6c.e<UDLoadingProperty, ImageView, r6c.a> {
    public final Style f;
    public final y g;

    public final String i() {
        return "android.widget.ImageView";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r3) {
        Intrinsics.checkNotNullParameter(r3, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L6;
        ImageView r4 = new ImageView(r1.getContext());
        r4.setScaleType(ImageView.ScaleType.CENTER);
        return r4;
    L6:
        Intrinsics.checkNotNullParameter(r3, "size");
        return null;
    }

    public void update(ImageView r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Style r0 = this.f;
        CircularProgressDrawable r1 = null;
        if (r0 == null) goto L5;
        ThemeColor r2 = r0.getTextColorV2();
    L6:
        if (r2 == null) goto L8;
        ThemeColor r3 = this.f.getTextColorV2();
        Intrinsics.checkNotNull(r3);
        int r4 = com.ss.android.lark.export.entity.preview.a.a(r3, r7.getContext(), null);
    L9:
        Style r5 = this.f;
        if (r5 == null) goto L12;
        float r6 = r5.getWidth();
    L13:
        float r8 = 0.1f * r6;
        float r9 = 2;
        float r10 = ((r6 * 0.8f) - (r9 * r8)) / r9;
        Drawable r11 = r7.getDrawable();
        if ((r11 instanceof CircularProgressDrawable) == false) goto L16;
        r1 = (CircularProgressDrawable) r11;
    L16:
        if (r1 != null) goto L18;
        r1 = new CircularProgressDrawable(r7.getContext());
    L18:
        r1.setStyle(1);
        r1.setStrokeWidth(UIHelper.dp2px(r8));
        r1.setColorSchemeColors(new int[]{r4});
        r1.setCenterRadius(UIHelper.dp2px(r10));
        r1.setStrokeCap(Paint.Cap.ROUND);
        r7.setImageDrawable(r1);
        r7.removeOnAttachStateChangeListener(this.g);
        r7.addOnAttachStateChangeListener(this.g);
        if (r7.isAttachedToWindow() == true) goto L21;
        return;
    L21:
        if (r1.isRunning() == true) goto L25;
        r1.start();
        return;
    L25:
        return;
    L12:
        r6 = 0.0f;
        goto L13
    L8:
        r4 = UIHelper.getColor(2131105548);
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((ImageView) r1);
    }

    public z(UDLoadingProperty r2, Style r3, vcb.d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
        this.f = r3;
        this.g = new y();
    }
}
