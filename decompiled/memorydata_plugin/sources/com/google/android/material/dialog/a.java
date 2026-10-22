package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f3896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3897b;
    private final int c;
    private final int d;

    public a(Dialog r2, Rect r3) {
        this.f3896a = r2;
        this.f3897b = r3.left;
        this.c = r3.top;
        this.d = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r6, MotionEvent r7) {
        View r0 = r6.findViewById(R.id.content);
        int r1 = this.f3897b + r0.getLeft();
        int r2 = r0.getWidth() + r1;
        int r3 = this.c + r0.getTop();
        if (new RectF(r1, r3, r2, r0.getHeight() + r3).contains(r7.getX(), r7.getY()) == false) goto L5;
        return false;
    L5:
        MotionEvent r4 = MotionEvent.obtain(r7);
        if (r7.getAction() != 1) goto L9;
        r4.setAction(4);
    L9:
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        r4.setAction(0);
        int r8 = this.d;
        r4.setLocation((-r8) - 1, (-r8) - 1);
    L11:
        r6.performClick();
        return this.f3896a.onTouchEvent(r4);
    }
}
