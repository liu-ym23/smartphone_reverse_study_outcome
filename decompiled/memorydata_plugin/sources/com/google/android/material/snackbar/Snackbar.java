package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] d = null;
    private static final int[] e = null;

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        public SnackbarLayout(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int r6, int r7) {
            super.onMeasure(r6, r7);
            int r8 = getChildCount();
            int r9 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int r0 = 0;
        L3:
            if (r0 >= r8) goto L8;
            View r1 = getChildAt(r0);
            if (r1.getLayoutParams().width != (-1)) goto L7;
            r1.measure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), View.MeasureSpec.makeMeasureSpec(r1.getMeasuredHeight(), 1073741824));
        L7:
            r0 = r0 + 1;
            goto L3
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable r1) {
            super.setBackground(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable r1) {
            super.setBackgroundDrawable(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList r1) {
            super.setBackgroundTintList(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode r1) {
            super.setBackgroundTintMode(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams r1) {
            super.setLayoutParams(r1);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* synthetic */ void setOnClickListener(View.OnClickListener r3) {
            super.setOnClickListener((View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        d = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarButtonStyle, "attr", "snackbarButtonStyle")};
        e = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarButtonStyle, "attr", "snackbarButtonStyle"), ZeusTransformUtils.mapRes(R.attr.snackbarTextViewStyle, "attr", "snackbarTextViewStyle")};
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void b() {
        super.b();
    }
}
