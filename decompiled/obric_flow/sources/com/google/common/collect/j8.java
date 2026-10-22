package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j8 implements com.google.common.base.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j8 f9041b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j8 f9042c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9043a;

    static {
        f9041b = new j8(0);
        f9042c = new j8(1);
    }

    public /* synthetic */ j8(int r5) {
        this.f9043a = r5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        switch(this.f9043a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return Collections.unmodifiableMap((Map) r5);
    L7:
        return p7.a((Collection) r5);
    L9:
        return ((Range) r5).upperBound;
    L11:
        return ((Range) r5).lowerBound;
    }
}
