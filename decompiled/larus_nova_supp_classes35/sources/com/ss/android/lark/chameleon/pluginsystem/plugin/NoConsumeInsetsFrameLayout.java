package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NoConsumeInsetsFrameLayout extends FrameLayout {
    private static final String TAG = "NoConsumeInsetsFrameLayout";

    private String getTagString() {
        if (getTag() != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        if (getTag().toString().length() > 0) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return getTag().toString() + " ";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, getTagString() + "onAttachedToWindow ");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, getTagString() + "onDetachedFromWindow ");
    }

    public NoConsumeInsetsFrameLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r4) {
        super.dispatchApplyWindowInsets(new WindowInsets(r4));
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        getChildAt(r0).dispatchApplyWindowInsets(new WindowInsets(r4));
        r0 = r0 + 1;
        goto L4
    L6:
        return r4;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r3) {
        super.onViewAdded(r3);
        requestApplyInsets();
        Log.i(TAG, getTagString() + "onViewAdded " + r3);
    }

    public NoConsumeInsetsFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        super.onVisibilityChanged(r2, r3);
        Log.i(TAG, getTagString() + "onVisibilityChanged " + r3);
    }

    public NoConsumeInsetsFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public NoConsumeInsetsFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        Log.i(TAG, getTagString() + "onSizeChanged  " + r3 + " " + r4 + " " + r5 + " " + r6);
    }
}
