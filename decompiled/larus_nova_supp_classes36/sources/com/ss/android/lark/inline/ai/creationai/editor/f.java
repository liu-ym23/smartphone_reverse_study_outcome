package com.ss.android.lark.inline.ai.creationai.editor;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ CreationAIEditorWebview a;

    public f(CreationAIEditorWebview r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        l r0 = this.a.R;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        super.onLongPress(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        l r3 = this.a.R;
        if (r3 == null) goto L7;
        r3.b();
        return false;
    L7:
        return false;
    }
}
