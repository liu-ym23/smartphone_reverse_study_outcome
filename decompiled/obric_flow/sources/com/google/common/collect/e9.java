package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e9 implements com.google.common.base.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8960b;

    public /* synthetic */ e9(Object r5, int r10) {
        this.f8959a = r10;
        this.f8960b = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f8959a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        Map.Entry r10 = (Map.Entry) r5;
        f7 r11 = (f7) this.f8960b;
        r11.getClass();
        r10.getClass();
        return new b7(r10, r11);
    L5:
        return ((g0) ((f9) ((l) this.f8960b).d).e).get(r5);
    L9:
        return ((StandardTable) ((f9) ((d9) this.f8960b).d).e).row(r5);
    L11:
        return ((StandardTable) ((f9) ((d9) this.f8960b).d).e).column(r5);
    }
}
