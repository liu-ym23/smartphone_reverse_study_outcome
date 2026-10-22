package com.squareup.javapoet;

import java.util.LinkedHashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f14974b;

    public /* synthetic */ j(k r5, int r10) {
        this.f14973a = r10;
        this.f14974b = r5;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r5) {
        int r10 = this.f14973a;
        a0 r11 = (a0) r5;
        k r12 = this.f14974b;
        r12.getClass();
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        String r13 = r11.f14951w;
        LinkedHashMap r14 = (LinkedHashMap) r12.f14985n.f905a;
        r14.put(r13, Integer.valueOf(((Integer) r14.getOrDefault(r13, 0)).intValue() + 1));
        return;
    L6:
        String r15 = r11.f14951w;
        LinkedHashMap r16 = (LinkedHashMap) r12.f14985n.f905a;
        int r17 = ((Integer) r16.getOrDefault(r15, 0)).intValue();
        if (r17 == 0) goto L11;
        r16.put(r15, Integer.valueOf(r17 - 1));
        return;
    L11:
        throw new IllegalStateException(r15 + " is not in the multiset");
    }
}
