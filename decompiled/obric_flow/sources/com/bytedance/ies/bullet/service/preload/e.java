package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.net.Uri;
import android.os.MessageQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f6116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f6118c;
    public final /* synthetic */ long d;
    public final /* synthetic */ sc.a e;

    public e(f r5, Context r10, Uri r11, long r12, sc.a r13) {
        this.f6116a = r5;
        this.f6117b = r10;
        this.f6118c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        long r5 = this.d;
        sc.a r10 = this.e;
        this.f6116a.h(this.f6117b, this.f6118c, r5, r10);
        return false;
    }
}
