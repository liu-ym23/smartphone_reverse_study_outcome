package com.bytedance.pia.core.utils;

import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.bytedance.salamander.anniex.b0;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7147c;
    public final /* synthetic */ Object d;

    public d(f r5, dh.e r10, fh.a r11) {
        this.f7145a = 0;
        this.f7146b = r5;
        this.f7147c = r10;
        this.d = r11;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        switch(this.f7145a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        int r10 = ((b0) this.f7146b).f7246b;
        JsonObject r11 = ProtocolMessage.b(new l9.g(r10, 1, (JsonObject) r5, null));
        if (r11 != null) goto L7;
        return;
    L7:
        if (((AtomicBoolean) this.f7147c).compareAndSet(false, true) == false) goto L13;
        ((gh.c) this.d).e.c(r11);
        return;
    L13:
        return;
    L10:
        Throwable r12 = (Throwable) r5;
        ((f) this.f7146b).getClass();
        f.c((dh.e) this.f7147c, (fh.a) this.d);
    }

    public d(gh.c r5, b0 r10, AtomicBoolean r11) {
        this.f7145a = 1;
        this.d = r5;
        this.f7146b = r10;
        this.f7147c = r11;
    }
}
