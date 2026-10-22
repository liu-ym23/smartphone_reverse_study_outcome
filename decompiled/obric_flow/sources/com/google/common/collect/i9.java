package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i9 extends s9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Synchronized$SynchronizedCollection f9027c;

    public /* synthetic */ i9(Synchronized$SynchronizedCollection r5, Iterator r10, int r11) {
        this.f9026b = r11;
        this.f9027c = r5;
        super(r10);
    }

    @Override // com.google.common.collect.s9
    public final Object a(Object r5) {
        switch(this.f9026b) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return p7.d((Collection) r5, ((Synchronized$SynchronizedAsMapValues) this.f9027c).mutex);
    L7:
        return new b(this, (Map.Entry) r5, 1);
    }
}
