package com.obric.oui.forms;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lambda f13334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnTouchListener f13335b;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r10) {
        ?? r11 = this.f13334a;
        if (r11 == 0) goto L6;
        r11.invoke(r10);
    L6:
        View.OnTouchListener r12 = this.f13335b;
        if (r12 != null) goto L10;
        return false;
    L10:
        return r12.onTouch(r5, r10);
    }
}
