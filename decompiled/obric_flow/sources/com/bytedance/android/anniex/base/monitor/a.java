package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f3118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3119c;

    public /* synthetic */ a(b r5, String r10, int r11) {
        this.f3117a = r11;
        this.f3118b = r5;
        this.f3119c = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f3117a) {
            case 0: goto L11;
            default: goto L5;
        };
    L5:
        if (this.f3118b.f3121a.get(this.f3119c) != null) goto L9;
        return Unit.INSTANCE;
    L9:
        throw new ClassCastException();
    L11:
        if (this.f3118b.f3121a.get(this.f3119c) != null) goto L15;
        return Unit.INSTANCE;
    L15:
        throw new ClassCastException();
    }
}
