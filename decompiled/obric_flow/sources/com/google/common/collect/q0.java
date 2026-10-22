package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends s9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9125b;

    public /* synthetic */ q0(Iterator r5, int r10) {
        this.f9125b = r10;
        super(r5);
    }

    @Override // com.google.common.collect.s9
    public final Object a(Object r5) {
        switch(this.f9125b) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return MutableClassToInstanceMap.access$100((Map.Entry) r5);
    L7:
        return ((y7) r5).getElement();
    L9:
        return new u7((Map.Entry) r5);
    L11:
        return ((Map.Entry) r5).getValue();
    L13:
        return ((k9) r5).getValue();
    }
}
