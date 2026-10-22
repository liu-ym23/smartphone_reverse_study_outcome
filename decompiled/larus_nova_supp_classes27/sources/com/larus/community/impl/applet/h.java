package com.larus.community.impl.applet;

import android.app.Activity;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ Activity a;

    public /* synthetic */ h(Activity r1) {
        this.a = r1;
    }

    public final Object invoke() {
        this.a.finish();
        return Boolean.TRUE;
    }
}
