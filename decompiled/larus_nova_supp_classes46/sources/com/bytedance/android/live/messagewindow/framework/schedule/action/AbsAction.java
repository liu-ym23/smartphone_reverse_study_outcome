package com.bytedance.android.live.messagewindow.framework.schedule.action;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import j71.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class AbsAction<State> implements Runnable {
    public final PropertyOwner<State> a;
    public final PropertyOwner b;
    public final a c;

    public AbsAction(a r2, State r3) {
        Intrinsics.checkNotNullParameter(r2, "cmd");
        Intrinsics.checkNotNullParameter(r3, "initState");
        this.c = r2;
        PropertyOwner<State> r4 = new PropertyOwner(r3, AbsAction$_curState$1.INSTANCE);
        this.a = r4;
        this.b = r4;
    }
}
