package com.bytedance.ies.bullet.lynx.resource;

import com.google.common.reflect.w;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ go.a f5766b;

    public /* synthetic */ g(go.a r5, int r10) {
        this.f5765a = r10;
        this.f5766b = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5765a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        go.a r5 = this.f5766b;
        if (r5 == null) goto L7;
        r5.f(w.b(new Error("file not found")));
        return Unit.INSTANCE;
    L7:
        return null;
    L9:
        go.a r10 = this.f5766b;
        if (r10 == null) goto L12;
        r10.f(w.b(new Error("file not found")));
        return Unit.INSTANCE;
    L12:
        return null;
    }
}
