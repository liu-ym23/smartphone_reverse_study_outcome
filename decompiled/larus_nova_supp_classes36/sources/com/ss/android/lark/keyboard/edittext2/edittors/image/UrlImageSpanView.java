package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFiles;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UrlImageSpanView extends FrameLayout {
    public int a;
    public final Lazy b;
    public final Paint c;

    public static final class a {
    }

    static {
    }

    private final ImageView getImageView() {
        return (ImageView) this.b.getValue();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        Log.d("UrlImageSpanView", "requestLayout: requestLayout called");
    }

    public final int getFixSize() {
        return this.a;
    }

    public static final /* synthetic */ ImageView a(UrlImageSpanView r0) {
        return r0.getImageView();
    }

    public final void setFixSize(int r1) {
        this.a = r1;
    }

    public UrlImageSpanView(final Context r11, com.ss.android.lark.widget.span.b.b<?> r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "loadInfo");
        super(r11);
        this.a = -1;
        this.b = LazyKt.lazy(new UrlImageSpanView$imageView$2(r11, this));
        Resources r13 = getResources();
        int r6 = (int) (((double) WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).widthPixels) * 0.4d);
        Resources r14 = getResources();
        int r7 = (int) (((double) WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).heightPixels) * 0.4d);
        Context r15 = getContext();
        if ((r15 instanceof Activity) == true) goto L5;
    L7:
        boolean r1 = true;
        if ((r12 instanceof com.ss.android.lark.widget.span.b.b.a) == false) goto L10;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(VFSFiles.b.i((String) ((com.ss.android.lark.widget.span.b.b) ((com.ss.android.lark.widget.span.b.b.a) r12)).d).getPath(), r0);
        Pair r2 = new Pair(Integer.valueOf(r0.outWidth), Integer.valueOf(r0.outHeight));
    L20:
        int[] r3 = ImageUtils.g(((Number) r2.component1()).intValue(), ((Number) r2.component2()).intValue(), r6, r7, 80, 80);
        Intrinsics.checkNotNull(r3);
        int r4 = r3[0];
        int r5 = r3[1];
        IRequestCreator r16 = ImageLoader.with(r15).load(r12.d).asBitmap();
        c r17 = new c(this);
        int r8 = this.a;
        if (1 > r8) goto L24;
        if (r8 >= r5) goto L24;
    L25:
        if (r1 == false) goto L27;
        r16.override(r8, r8).centerCrop().into(r17);
    L28:
        Paint r18 = new Paint();
        r18.setColor(UIHelper.getColor(2131106521));
        r18.setStyle(Paint.Style.FILL);
        this.c = r18;
        return;
    L27:
        r16.override(r4, r5).into(r17);
    L24:
        r1 = false;
        goto L25
    L10:
        int r9 = Integer.MAX_VALUE;
        if ((r12 instanceof com.ss.android.lark.widget.span.b.b.b) == false) goto L19;
        com.ss.android.lark.widget.span.b.b.b r10 = (com.ss.android.lark.widget.span.b.b.b) r12;
        int r19 = ((com.ss.android.lark.widget.span.b.b) r10).b;
        int r20 = ((com.ss.android.lark.widget.span.b.b) r10).c;
        if (r19 != 0) goto L15;
        r19 = Integer.MAX_VALUE;
    L15:
        if (r20 == 0) goto L18;
        r9 = r20;
    L18:
        r2 = TuplesKt.to(Integer.valueOf(r19), Integer.valueOf(r9));
        goto L20
    L19:
        r2 = TuplesKt.to(Integer.MAX_VALUE, Integer.MAX_VALUE);
        goto L20
    L5:
        if (UIUtils.isActivityRunning((Activity) r15) == true) goto L7;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        Log.d("UrlImageSpanView", "measureView: measured size is " + getMeasuredWidth() + 'x' + getMeasuredHeight() + ", widthMeasureSpec is " + r3 + ", heightMeasureSpec is " + r4);
    }
}
