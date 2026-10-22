package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.google.gson.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Comparable f7019c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public r(Uri r5, String r10, JsonObject r11, List r12, gh.b r13, n0 r14) {
        this.f7017a = 0;
        this.f7019c = r5;
        this.f7018b = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f7017a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        com.lynx.tasm.p.e(this.f7018b, (String) this.f7019c, (String) this.d, (String) this.e, (String) this.f, (String) this.g);
        return;
    L15:
    L9:
        e = move-exception;
        ((n0) this.g).accept(new PiaMethod$Error("[Cache] PIA Cache Save Failed, reason: (" + e.getMessage() + ')'));
        return;
    L7:
        if (jh.c.e.get() == true) goto L11;
        jh.c.d();     // Catch: Exception -> L9
    L11:
        ((gh.b) this.f).accept(new q(jh.c.i((Uri) this.f7019c, this.f7018b, (JsonObject) this.d, (List) this.e)));     // Catch: Exception -> L9
    }

    public r(String r5, String r10, String r11, String r12, String r13, String r14) {
        this.f7017a = 1;
        this.f7018b = r5;
        this.f7019c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
    }
}
