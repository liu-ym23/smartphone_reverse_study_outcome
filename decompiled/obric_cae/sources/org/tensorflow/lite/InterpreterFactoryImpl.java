package org.tensorflow.lite;

import org.tensorflow.lite.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes2.dex */
@UsedByReflection
class InterpreterFactoryImpl {
    public InterpreterFactoryImpl() {
    }

    private static native String nativeRuntimeVersion();

    private static native String nativeSchemaVersion();
}
