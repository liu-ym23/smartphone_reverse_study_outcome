package com.obric.assistant.onelogin;

import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class w implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ w(boolean r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        Function0 r1 = this.b;
        if (r0 == false) goto L5;
        AppHost.a.a().finishAllActivities();
    L5:
        r1.invoke();
        return Unit.INSTANCE;
    }
}
