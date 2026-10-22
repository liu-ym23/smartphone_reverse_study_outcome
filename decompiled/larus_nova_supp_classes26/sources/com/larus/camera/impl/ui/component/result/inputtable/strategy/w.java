package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larus.camera.impl.ui.component.result.inputtable.ResultInputControlBinder;
import com.larus.camera.impl.widget.CameraInputContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w implements View.OnTouchListener {
    public boolean a;
    public Job b;
    public final /* synthetic */ vx8.b c;
    public final /* synthetic */ x d;

    public w(ResultInputControlBinder.b r1, x r2) {
        this.c = r1;
        this.d = r2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "event");
        int r0 = r11.getAction();
        if (r0 == 0) goto L25;
        if (r0 != 1) goto L6;
    L8:
        Job r1 = this.b;
        if (r1 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L17;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L17:
        if (this.a == false) goto L24;
        x r2 = this.d;
        r2.i();
        ViewGroup r3 = r2.c;
        if (r3 == null) goto L23;
        CameraInputContainer r5 = (CameraInputContainer) r3.findViewById(2131375355);
        if (r5 == null) goto L23;
        int r6 = r5.getPaddingBottom();
        r5.setPaddingRelative(r5.getPaddingStart(), r5.getPaddingTop(), r5.getPaddingEnd(), r6 - c7.b(28));
    L23:
        this.a = false;
    L26:
        op8.i r7 = this.c.b();
        if (r7 == null) goto L29;
        r7.a(r10, r11);
    L29:
        return true;
    L24:
        r10.performClick();
        goto L26
    L11:
        if (r1.isActive() != true) goto L13;
        r4 = true;
        goto L14
    L6:
        if (r0 == 3) goto L8;
    L25:
        this.b = BuildersKt.launch$default(this.d.h(), null, null, new IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1(this, this.d, null), 3, null);
        goto L26
    }
}
