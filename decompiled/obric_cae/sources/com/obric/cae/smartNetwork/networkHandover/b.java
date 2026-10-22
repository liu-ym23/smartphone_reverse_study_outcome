package com.obric.cae.smartNetwork.networkHandover;

import android.net.Uri;
import java.util.HashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5783b;

    public /* synthetic */ b(Object r8, int r10) {
        this.f5782a = r10;
        this.f5783b = r8;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r8) {
        int r10 = this.f5782a;
        Object r11 = this.f5783b;
        switch(r10) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        NetworkHandoverManager.a((NetworkHandoverManager) r11, (Uri) r8);
        return;
    L7:
        ((HashMap) r11).remove((String) r8);
    }
}
