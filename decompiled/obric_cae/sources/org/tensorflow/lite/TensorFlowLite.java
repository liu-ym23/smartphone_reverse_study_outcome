package org.tensorflow.lite;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class TensorFlowLite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f9819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UnsatisfiedLinkError f9820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f9821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean[] f9822d = null;

    static {
        f9819a = Logger.getLogger(TensorFlowLite.class.getName());
        String[][] r8 = {new String[]{"tensorflowlite_jni", "tensorflowlite_jni_stable"}, new String[]{"tensorflowlite_jni_gms_client"}};
        int r10 = 0;
        f9821c = false;
        UnsatisfiedLinkError r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= 2) goto L17;
        String[] r13 = r8[r12];
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L16;
        String r16 = r13[r15];
        System.loadLibrary(r16);     // Catch: UnsatisfiedLinkError -> L10
        f9819a.info("Loaded native library: " + r16);     // Catch: UnsatisfiedLinkError -> L10
    L10:
        e = move-exception;
        f9819a.info("Didn't load native library: " + r16);
        if (r11 != null) goto L14;
        r11 = e;
    L15:
        r15 = r15 + 1;
        goto L6
    L14:
        r11.addSuppressed(e);
    L16:
        r12 = r12 + 1;
        goto L4
    L17:
        f9820b = r11;
        f9822d = new AtomicBoolean[e.a.values().length];
    L19:
        if (r10 >= e.a.values().length) goto L21;
        f9822d[r10] = new AtomicBoolean();
        r10 = r10 + 1;
        goto L19
    }

    public TensorFlowLite() {
    }

    public static void a() {
        if (f9821c == false) goto L14;
        return;
    L14:
        nativeDoNothing();     // Catch: UnsatisfiedLinkError -> L7
        f9821c = true;     // Catch: UnsatisfiedLinkError -> L7
        return;
    L7:
        e = move-exception;
        UnsatisfiedLinkError r8 = f9820b;
        if (r8 != null) goto L12;
        r8 = e;
    L12:
        UnsatisfiedLinkError r10 = new UnsatisfiedLinkError("Failed to load native TensorFlow Lite methods. Check that the correct native libraries are present, and, if using a custom native library, have been properly loaded via System.loadLibrary():\n  " + r8);
        r10.initCause(e);
        throw r10;
    }

    private static native void nativeDoNothing();
}
