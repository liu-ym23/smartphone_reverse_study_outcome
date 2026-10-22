package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.service.base.a0;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f5629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5630c;
    public final /* synthetic */ a0 d;
    public final /* synthetic */ wc.g e;
    public final /* synthetic */ com.bytedance.ies.bullet.ui.common.loader.a f;

    public /* synthetic */ e(h r5, String r10, a0 r11, wc.g r12, com.bytedance.ies.bullet.ui.common.loader.a r13, int r14) {
        this.f5628a = r14;
        this.f5629b = r5;
        this.f5630c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5628a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        wc.g r5 = this.e;
        com.bytedance.ies.bullet.ui.common.loader.a r10 = this.f;
        h.d(this.f5629b, this.f5630c, this.d, r5, r10);
        return Unit.INSTANCE;
    L6:
        wc.g r11 = this.e;
        com.bytedance.ies.bullet.ui.common.loader.a r12 = this.f;
        h.d(this.f5629b, this.f5630c, this.d, r11, r12);
        return Unit.INSTANCE;
    }
}
