package com.obric.oui.forms;

import android.view.View;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lambda f13332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnFocusChangeListener f13333b;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r5, boolean r10) {
        ?? r11 = this.f13332a;
        if (r11 == 0) goto L6;
        r11.invoke(Boolean.valueOf(r10));
    L6:
        View.OnFocusChangeListener r12 = this.f13333b;
        if (r12 == null) goto L11;
        r12.onFocusChange(r5, r10);
        return;
    }
}
