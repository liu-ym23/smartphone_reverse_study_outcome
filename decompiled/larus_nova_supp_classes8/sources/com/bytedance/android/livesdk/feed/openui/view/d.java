package com.bytedance.android.livesdk.feed.openui.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ LiveListBlock a;

    public d(LiveListBlock r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "motionEvent");
        if (r5.getAction() != 0) goto L5;
    L10:
        this.a.a(2131384076).getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    L5:
        if (r5.getAction() == 2) goto L10;
        if (r5.getAction() == 1) goto L10;
        this.a.a(2131384076).getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
