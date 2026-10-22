package org.tensorflow.lite.flex;

import java.io.Closeable;
import org.tensorflow.lite.annotations.UsedByReflection;
import org.tensorflow.lite.b;

/* JADX INFO: loaded from: classes2.dex */
@UsedByReflection
public class FlexDelegate implements b, Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9843b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9844a;

    static {
        System.loadLibrary("tensorflowlite_flex_jni");
    }

    @UsedByReflection
    public FlexDelegate() {
        this.f9844a = nativeCreateDelegate();
    }

    private static native long nativeCreateDelegate();

    private static native void nativeDeleteDelegate(long r8);

    private static native long nativeInitTensorFlow();

    @Override // org.tensorflow.lite.b, java.io.Closeable, java.lang.AutoCloseable
    @UsedByReflection
    public void close() {
        long r8 = this.f9844a;
        if (r8 == 0) goto L6;
        nativeDeleteDelegate(r8);
        this.f9844a = 0;
        return;
    }

    @Override // org.tensorflow.lite.b
    @UsedByReflection
    public long getNativeHandle() {
        return this.f9844a;
    }
}
