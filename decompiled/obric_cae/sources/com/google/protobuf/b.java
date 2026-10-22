package com.google.protobuf;

import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object r8) {
        return ((Descriptors.FieldDescriptor) r8).getNumber();
    }
}
