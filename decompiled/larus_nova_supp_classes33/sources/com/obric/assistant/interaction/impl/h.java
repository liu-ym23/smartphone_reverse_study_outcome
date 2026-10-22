package com.obric.assistant.interaction.impl;

import android.app.Activity;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ h(List r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricCameraServiceDiffImpl.b(this.a, this.b);
    }
}
