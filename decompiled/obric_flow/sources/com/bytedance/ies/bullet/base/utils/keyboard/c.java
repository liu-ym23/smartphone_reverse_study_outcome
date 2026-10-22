package com.bytedance.ies.bullet.base.utils.keyboard;

import android.view.ViewTreeObserver;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f5244a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WeakReference r5 = this.f5244a;
        if (r5 == null) goto L5;
        Function r10 = (Function) r5.get();
    L6:
        if (r10 != null) goto L8;
        return;
    L8:
        Unit r11 = (Unit) r10.apply(Unit.INSTANCE);
        return;
    L5:
        r10 = null;
        goto L6
    }
}
