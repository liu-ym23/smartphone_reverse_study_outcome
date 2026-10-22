package com.ss.android.lark.movable.selection;

import android.view.MotionEvent;
import com.ss.android.lark.movable.MovableView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements g {
    public n() {
    }

    @Override // com.ss.android.lark.movable.selection.g
    public final void a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.ss.android.lark.movable.selection.g
    public final void b(MovableSelectionManager r2, MovableView r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r3, "movableView");
    }
}
