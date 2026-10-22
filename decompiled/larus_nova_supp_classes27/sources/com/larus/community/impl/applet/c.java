package com.larus.community.impl.applet;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Activity d;
    public final /* synthetic */ int e;

    public /* synthetic */ c(Ref.ObjectRef r1, Runnable r2, long r3, Activity r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.ObjectRef r0 = this.a;
        Runnable r1 = this.b;
        long r2 = this.c;
        Activity r4 = this.d;
        int r5 = this.e;
        if (r0.element == null) goto L24;
        AppHost.Companion r6 = AppHost.a;
        Activity r7 = r6.a().getCurrentActivity();
        if (r7 == null) goto L14;
        if (r7 == r4) goto L11;
        AICreationAppletNavigator.a.getClass();
        if (AICreationAppletNavigator.i(r7, r5) == false) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L14;
    L16:
        if (r7 == null) goto L18;
        FLogger.a.i("AICreationAppletNavigator", "run AI creation applet task action with resumed native activity=".concat(r7.getClass().getSimpleName()));
        AICreationAppletNavigator.t(r1, r2, r0, r7);
        return;
    L18:
        f09.a.a r9 = (f09.a.a) r0.element;
        if (r9 == null) goto L21;
        r6.a().f(r9);
        r0.element = null;
    L21:
        FLogger.a.i("AICreationAppletNavigator", "run AI creation applet task action after route handled below host activity");
        AICreationAppletNavigator.b.postDelayed(r1, r2);
        return;
    L11:
        r8 = false;
    L14:
        r7 = null;
        goto L16
    }
}
