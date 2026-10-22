package com.larus.community.impl.applet;

import android.app.Activity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ b(Ref.BooleanRef r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ref.BooleanRef r0 = this.a;
        Activity r1 = this.b;
        if (r0.element == true) goto L13;
        r0.element = true;
        if (r1.isFinishing() == false) goto L8;
        return;
    L8:
        if (r1.isDestroyed() == true) goto L12;
        FLogger.a.i("AICreationAppletNavigator", "move AI creation applet task to back");
        r1.moveTaskToBack(true);
        return;
    L12:
        return;
    }
}
