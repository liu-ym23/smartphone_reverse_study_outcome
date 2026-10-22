package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.app.Activity;
import androidx.core.util.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ Function1<Activity, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Activity r1, Function1<? super Activity, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        Activity r3 = this.a;
    L6:
        this.b.invoke(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
