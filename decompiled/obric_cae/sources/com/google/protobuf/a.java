package com.google.protobuf;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ToIntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5191a;

    public /* synthetic */ a(int r8) {
        this.f5191a = r8;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r8) {
        switch(this.f5191a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L10;
        };
    L6:
        return ((Integer) r8).intValue();
    L8:
        return ((Descriptors.EnumValueDescriptor) r8).getNumber();
    L10:
        return ((Integer) r8).intValue();
    }
}
