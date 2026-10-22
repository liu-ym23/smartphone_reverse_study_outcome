package com.bytedance.ies.bullet.lynx.resource;

import com.google.common.reflect.w;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ go.a f5730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f5731c;

    public /* synthetic */ f(go.a r5, byte[] r10, int r11) {
        this.f5729a = r11;
        this.f5730b = r5;
        this.f5731c = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5729a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        go.a r5 = this.f5730b;
        if (r5 == null) goto L7;
        jo.a r10 = new jo.a();
        r10.f18400a = this.f5731c;
        r5.f(w.a(r10));
        return Unit.INSTANCE;
    L7:
        return null;
    L9:
        go.a r11 = this.f5730b;
        if (r11 == null) goto L12;
        r11.f(w.a(this.f5731c));
        return Unit.INSTANCE;
    L12:
        return null;
    }
}
