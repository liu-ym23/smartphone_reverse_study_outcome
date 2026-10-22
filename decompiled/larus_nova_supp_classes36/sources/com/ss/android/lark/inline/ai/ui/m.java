package com.ss.android.lark.inline.ai.ui;

import android.view.ViewTreeObserver;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ InlineAIPanelController a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Log.i("InlineAIPanelController", "onPreDraw");
        int r0 = zlb.a.d;
        zlb.a.C0355a.d(this.a.a.i);
        this.a.e.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public m(InlineAIPanelController r1) {
        this.a = r1;
    }
}
