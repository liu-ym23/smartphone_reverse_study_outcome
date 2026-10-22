package com.google.common.reflect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9366c;

    public /* synthetic */ n(int r5) {
        this.f9366c = r5;
    }

    @Override // com.google.common.reflect.q
    public final Iterable c(Object r5) {
        switch(this.f9366c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return Arrays.asList(((Class) r5).getInterfaces());
    L7:
        return ((TypeToken) r5).getGenericInterfaces();
    }

    @Override // com.google.common.reflect.q
    public final Class d(Object r5) {
        switch(this.f9366c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (Class) r5;
    L7:
        return ((TypeToken) r5).getRawType();
    }

    @Override // com.google.common.reflect.q
    public final Object e(Object r5) {
        switch(this.f9366c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((Class) r5).getSuperclass();
    L7:
        return ((TypeToken) r5).getGenericSuperclass();
    }
}
