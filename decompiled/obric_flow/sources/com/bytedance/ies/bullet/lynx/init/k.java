package com.bytedance.ies.bullet.lynx.init;

import com.lynx.animax.util.LynxAnimaX;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f5685a = null;

    static {
        f5685a = new k();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        LynxAnimaX.inst().init();
        return Unit.INSTANCE;
    }
}
