package com.bytedance.android.accessibilityLib_Core.base.api;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AbstractAccessibilityLibIsolation$processLifecycleEventObserver$2$a implements LifecycleEventObserver {
    public final /* synthetic */ AbstractAccessibilityLibIsolation.processLifecycleEventObserver.2 a;

    public AbstractAccessibilityLibIsolation$processLifecycleEventObserver$2$a(AbstractAccessibilityLibIsolation.processLifecycleEventObserver.2 r1) {
        this.a = r1;
    }

    public final void onStateChanged(LifecycleOwner r1, Lifecycle.Event r10) {
        if (r10 != Lifecycle.Event.ON_STOP) goto L6;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        this.a.this$0.e = true;
        return;
    L6:
        if (r10 != Lifecycle.Event.ON_START) goto L13;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        AbstractAccessibilityLibIsolation r13 = this.a.this$0;
        if (r13.e == false) goto L10;
        r13.k(AbstractAccessibilityLibIsolation$ReStartAccessibilityEngineCondition.APP_FOREGROUND_FROM_BACKGROUND);
    L10:
        this.a.this$0.e = false;
        return;
    }
}
