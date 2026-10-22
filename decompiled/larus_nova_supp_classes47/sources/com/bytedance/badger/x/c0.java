package com.bytedance.badger.x;

import com.bytedance.badger.data.BadgerResult;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements o {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ z c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;

    public c0(f0 r1, long r2, z r4, Ref.ObjectRef r5, Ref.ObjectRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final void a() {
        String r4 = p.b();     // Catch: Throwable -> L6
        this.a.c(this.b, new y(0, "success", this.c, r4, "service", 32), null, null);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.bytedance.badger.e.c("DeviceFp1Task", "GetDeviceIdByAsk failed", th);
        this.d.element = "service: " + th.getClass().getName() + " " + th.getMessage();
        f0 r2 = this.a;
        long r3 = this.b;
        String r1 = (String) this.d.element;
        r2.c(r3, new y(BadgerResult.ERROR, r1, this.c, null, null, 56), (String) this.e.element, r1);
    }
}
