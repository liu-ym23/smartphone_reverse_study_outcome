package com.larus.community.impl.applet;

import android.app.Activity;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ AICreationAppletNavigator b;
    public final /* synthetic */ Activity c;

    public /* synthetic */ k(Activity r1, AICreationAppletNavigator r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        Activity r0 = this.a;
        final AICreationAppletNavigator r1 = this.b;
        final Activity r2 = this.c;
        r0.moveTaskToBack(true);
        AICreationAppletNavigator.b.postDelayed(new d(r1, r2), 100);
        return Boolean.TRUE;
    }
}
