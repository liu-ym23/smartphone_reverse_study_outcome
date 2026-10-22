package com.lynx.devtool.recorder;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.lynx.tasm.LynxView;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderView extends RelativeLayout {
    public static final String LYNX_VIEW_HEIGHT = "LynxViewHeight";
    public static final String LYNX_VIEW_WIDTH = "LynxViewWidth";
    private LynxRecorderActionManager mActionManager;
    private LynxView mLynxView;
    private int[] mPoint;

    public void destroy() {
        LynxRecorderActionManager r0 = this.mActionManager;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public void reload() {
        this.mActionManager.load();
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L6;
        r0.onEnterForeground();
        return;
    }

    public LynxRecorderView(Context r1) {
        super(r1);
    }

    public static /* synthetic */ LynxView access$002(LynxRecorderView r0, LynxView r1) {
        r0.mLynxView = r1;
        return r1;
    }

    public void updateScreenMetrics(int r2, int r3) {
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L6;
        r0.updateScreenMetrics(r2, r3);
        return;
    }

    private void attachToView(ViewGroup r3, int r4, int r5) {
        LynxView r0 = this.mLynxView;
        if (r0 == null) goto L6;
        r3.addView(r0, new LinearLayout.LayoutParams(r4, r5));
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) getLayoutParams();
        r6.width = -2;
        r6.height = -2;
        int[] r7 = this.mPoint;
        r6.leftMargin = r7[0];
        r6.topMargin = r7[1];
        setLayoutParams(r6);
        return;
    }

    public void loadPageWithPoint(String r3, int[] r4, Intent r5) {
        this.mPoint = Arrays.copyOf(r4, r4.length);
        LynxRecorderActionManager r6 = new LynxRecorderActionManager(r5, getContext(), this, null);
        this.mActionManager = r6;
        r6.registerCallback(new AnonymousClass1(this));
        Iterator<LynxRecorderActionCallback> r7 = LynxRecorderPageManager.getInstance().getCallbacks().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        LynxRecorderActionCallback r8 = r7.next();
        this.mActionManager.registerCallback(r8);
        goto L4
    L6:
        this.mActionManager.startWithUrl(r3);
    }

    public static /* synthetic */ void access$100(LynxRecorderView r0, ViewGroup r1, int r2, int r3) {
        r0.attachToView(r1, r2, r3);
    }
}
