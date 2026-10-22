package com.ss.android.lark.flow.feed.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import com.ss.android.lark.feed.shared.page.swipe.SwipeActionTextHelper;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseFeedSwipeActionView {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public ImageView c;
    public TextView d;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.action.a$a, reason: collision with other inner class name */
    public static final class C0041a {
    }

    static {
        e = UIHelper.dp2px(80.0f);
        f = UIHelper.dp2px(8.0f);
        g = UIHelper.dp2px(4.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        measure(View.MeasureSpec.makeMeasureSpec(e, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public CharSequence getActionName() {
        TextView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r0 = null;
    L6:
        return r0.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        LayoutInflater.from(getContext()).inflate(2131561603, this, true);
        setOrientation(1);
        int r0 = g;
        int r1 = f;
        setPadding(r0, r1, r0, r1);
        setGravity(17);
        this.c = (ImageView) findViewById(2131376297);
        TextView r2 = (TextView) findViewById(2131390975);
        this.d = r2;
        TextView r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r2 = null;
    L5:
        r2.setMaxLines(2);
        TextView r4 = this.d;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
    L9:
        float r5 = SwipeActionTextHelper.c;
        r3.setTextSize(1, SwipeActionTextHelper.c);
        return;
    L8:
        r3 = r4;
        goto L9
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        new SwipeActionTextHelper();
    }

    public void setOnlyShowText(boolean r2) {
        ImageView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 8;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        super/*android.widget.LinearLayout*/.onMeasure(r2, r3);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(e, 1073741824), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Drawable r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "icon");
        Intrinsics.checkNotNullParameter(r6, "text");
        super.a(r5, r6, r7);
        TextView r0 = this.d;
        ImageView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r0 = null;
    L5:
        zz7.a.c(r0, 12);
        TextView r1 = this.d;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r1 = null;
    L8:
        r1.setText(r6);
        ImageView r8 = this.c;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L12:
        r2.setBackground(r5);
        setBackgroundColor(r7);
        return;
    L11:
        r2 = r8;
        goto L12
    }
}
