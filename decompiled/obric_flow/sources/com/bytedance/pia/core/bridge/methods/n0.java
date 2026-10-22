package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n0 implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7006c;

    public /* synthetic */ n0(int r5, Object r10, Object r11) {
        this.f7004a = r5;
        this.f7005b = r10;
        this.f7006c = r11;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        switch(this.f7004a) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L10;
            default: goto L4;
        };
    L4:
        Throwable r11 = (Throwable) r10;
        String r5 = ((rh.i) this.f7006c).f21763h + "load script async error:";
        Intrinsics.checkNotNullParameter(r5, "message");
        com.bytedance.pia.core.utils.j.w(4, r5, r11);
        if (r11 == null) goto L7;
        String r12 = r11.toString();
    L8:
        ((sh.a) this.f7005b).accept(r12);
        return;
    L7:
        r12 = "";
        goto L8
    L10:
        JsonObject r13 = (JsonObject) r10;
        if (((AtomicBoolean) ((ym.p) this.f7005b).f23312b).get() == true) goto L25;
        if (r13 == null) goto L26;
        ((l0) this.f7006c).accept(r13);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        l9.l r14 = (l9.l) this.f7005b;
        r14.getClass();
        com.bytedance.pia.core.utils.m.b(new androidx.room.f(r14, 7, (String) r10, (l0) this.f7006c));
        return;
    L19:
        l9.l r15 = (l9.l) this.f7005b;
        r15.getClass();
        int r16 = 6;
        com.bytedance.pia.core.utils.m.b(new androidx.room.f(r15, r16, (Boolean) this.f7006c, (JsonObject) r10));
        return;
    L21:
        gh.c r17 = (gh.c) this.f7005b;
        r17.getClass();
        PiaMethod$Error r18 = (PiaMethod$Error) r10;
        r17.a(r18.f6951a, null, r18.getMessage(), r18.getCause());
        gh.c.b((fh.a) this.f7006c, r18);
        return;
    L23:
        ((n0) this.f7005b).accept(new PiaMethod$Error(-10007, (String) r10));
        ((rh.i) this.f7006c).b(null);
    }

    public /* synthetic */ n0(gh.c r5, String r10, JsonObject r11, long r12, fh.a r13) {
        this.f7004a = 1;
        this.f7005b = r5;
        this.f7006c = r13;
    }

    public /* synthetic */ n0(rh.i r5, sh.a r10) {
        this.f7004a = 5;
        this.f7006c = r5;
        this.f7005b = r10;
    }
}
