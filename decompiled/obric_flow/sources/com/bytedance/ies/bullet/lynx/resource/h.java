package com.bytedance.ies.bullet.lynx.resource;

import com.google.common.reflect.w;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ go.a f5768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f5769c;

    public /* synthetic */ h(go.a r5, Throwable r10, int r11) {
        this.f5767a = r11;
        this.f5768b = r5;
        this.f5769c = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5767a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        go.a r5 = this.f5768b;
        if (r5 == null) goto L7;
        StringBuilder r10 = new StringBuilder("stream write error, ");
        r5.f(w.b(new Error(androidx.room.jarjarred.org.antlr.runtime.a.x(this.f5769c, r10))));
        return Unit.INSTANCE;
    L7:
        return null;
    L9:
        go.a r11 = this.f5768b;
        if (r11 == null) goto L12;
        StringBuilder r12 = new StringBuilder("stream write error, ");
        r11.f(w.b(new Error(androidx.room.jarjarred.org.antlr.runtime.a.x(this.f5769c, r12))));
        return Unit.INSTANCE;
    L12:
        return null;
    }
}
