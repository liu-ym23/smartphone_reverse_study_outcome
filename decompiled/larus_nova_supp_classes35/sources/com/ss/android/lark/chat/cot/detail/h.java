package com.ss.android.lark.chat.cot.detail;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ CotDetailBlueprintAdapter c;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getActionMasked() != 1) goto L7;
        c.b(this.a, this.b, this.c, r4);
        return false;
    L7:
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        c.b(this.a, this.b, this.c, r4);
        return false;
    }

    public h(c r1, RecyclerView r2, CotDetailBlueprintAdapter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
