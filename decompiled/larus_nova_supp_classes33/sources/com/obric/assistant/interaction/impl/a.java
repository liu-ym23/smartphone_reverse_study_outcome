package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ AppLaunchServiceImpl.activityLifeCycleCallback.1 b;

    public /* synthetic */ a(Activity r1, AppLaunchServiceImpl.activityLifeCycleCallback.1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        AppLaunchServiceImpl.activityLifeCycleCallback.1.a(this.a, this.b, (Intent) r3);
    }
}
