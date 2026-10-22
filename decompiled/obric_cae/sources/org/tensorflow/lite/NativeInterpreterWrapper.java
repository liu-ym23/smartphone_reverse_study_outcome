package org.tensorflow.lite;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.tensorflow.lite.annotations.UsedByReflection;
import org.tensorflow.lite.flex.FlexDelegate;
import org.tensorflow.lite.nnapi.NnApiDelegateImpl;

/* JADX INFO: loaded from: classes2.dex */
class NativeInterpreterWrapper implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9807b;

    @UsedByReflection
    private long inferenceDurationNanoseconds;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ByteBuffer f9809n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HashMap f9810o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TensorImpl[] f9811p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TensorImpl[] f9812q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9813r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f9814s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f9815t;

    static {
        g r8 = g.f9845a;
    }

    public NativeInterpreterWrapper(MappedByteBuffer r20, f.a r21) {
        this.inferenceDurationNanoseconds = -1;
        this.f9813r = false;
        ArrayList r8 = new ArrayList();
        this.f9814s = r8;
        ArrayList r10 = new ArrayList();
        this.f9815t = r10;
        TensorFlowLite.a();
        if (r20 == null) goto L63;
        this.f9809n = r20;
        long r13 = createErrorReporter(512);
        long r11 = createModelWithBuffer(this.f9809n, r13);
        this.f9806a = r13;
        this.f9808m = r11;
        ArrayList r12 = new ArrayList();
        int r14 = r21.f9836b;
        Boolean r15 = r21.f9837c;
        if (r15 != null) goto L7;
    L10:
        boolean r16 = true;
    L11:
        long r17 = createInterpreter(r11, r13, r14, r16, r12);
        this.f9807b = r17;
        boolean r18 = hasUnresolvedFlexOp(r17);
        ArrayList r19 = r21.f9838d;
        if (r18 == false) goto L25;
        List r22 = Collections.unmodifiableList(r19);
        int r23 = FlexDelegate.f9843b;     // Catch: Throwable -> L64
        Iterator r24 = r22.iterator();     // Catch: Throwable -> L64
    L16:
        if (r24.hasNext() == false) goto L20;
        if (FlexDelegate.class.isInstance((b) r24.next()) == false) goto L16;
    L20:
        b r25 = (b) FlexDelegate.class.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L64
    L23:
        if (r25 == null) goto L25;
        r10.add(r25);
        r8.add(r25);
    L22:
        r25 = null;
    L25:
        Iterator r26 = Collections.unmodifiableList(r19).iterator();
    L27:
        if (r26.hasNext() == false) goto L36;
        b r27 = (b) r26.next();
        if (r21.f9835a == e.a.f9840a) goto L35;
        if ((r27 instanceof org.tensorflow.lite.nnapi.a) == true) goto L35;
        throw new IllegalArgumentException("Instantiated delegates (other than NnApiDelegate) are not allowed when using TF Lite from Google Play Services. Please use InterpreterApi.Options.addDelegateFactory() with an appropriate DelegateFactory instead.");
    L35:
        r8.add(r27);
        goto L27
    L36:
        Iterator r28 = Collections.unmodifiableList(r21.f9839e).iterator();
    L38:
        if (r28.hasNext() == false) goto L40;
        b r29 = ((c) r28.next()).a();
        r10.add(r29);
        r8.add(r29);
        goto L38
    L40:
        new InterpreterFactoryImpl();
        Iterator r30 = r8.iterator();
    L42:
        if (r30.hasNext() == false) goto L46;
        b r31 = (b) r30.next();
        if ((r31 instanceof org.tensorflow.lite.nnapi.a) == false) goto L42;
        org.tensorflow.lite.nnapi.a r32 = (org.tensorflow.lite.nnapi.a) r31;
        r32.f9849b = new NnApiDelegateImpl(r32.f9848a);
        r32.f9850m = true;
        goto L42
    L46:
        r12.ensureCapacity(r8.size());
        Iterator r33 = r8.iterator();
    L48:
        if (r33.hasNext() == false) goto L51;
        r12.add(Long.valueOf(((b) r33.next()).getNativeHandle()));
        goto L48
    L51:
        if (r12.isEmpty() == true) goto L60;
        delete(0, 0, this.f9807b);
        int r110 = r21.f9836b;
        Boolean r34 = r21.f9837c;
        if (r34 != null) goto L55;
    L58:
        boolean r111 = true;
    L59:
        this.f9807b = createInterpreter(r11, r13, r110, r111, r12);
        goto L60
    L55:
        if (r34.booleanValue() == true) goto L58;
        r111 = false;
    L60:
        this.f9811p = new TensorImpl[getInputCount(this.f9807b)];
        this.f9812q = new TensorImpl[getOutputCount(this.f9807b)];
        allocateTensors(this.f9807b, r13);
        this.f9813r = true;
        return;
    L7:
        if (r15.booleanValue() == true) goto L10;
        r16 = false;
        goto L11
    L63:
        throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }

    private static native long allocateTensors(long r8, long r10);

    private static native void allowBufferHandleOutput(long r8, boolean r10);

    private static native void allowFp16PrecisionForFp32(long r8, boolean r10);

    private static native long createCancellationFlag(long r8);

    private static native long createErrorReporter(int r8);

    private static native long createInterpreter(long r8, long r10, int r11, boolean r12, List<Long> r13);

    private static native long createModel(String r8, long r10);

    private static native long createModelWithBuffer(ByteBuffer r8, long r10);

    private static native void delete(long r8, long r10, long r11);

    private static native long deleteCancellationFlag(long r8);

    private static native int getExecutionPlanLength(long r8);

    private static native int getInputCount(long r8);

    private static native String[] getInputNames(long r8);

    private static native int getInputTensorIndex(long r8, int r10);

    private static native int getOutputCount(long r8);

    private static native String[] getOutputNames(long r8);

    private static native int getOutputTensorIndex(long r8, int r10);

    private static native String[] getSignatureKeys(long r8);

    private static native boolean hasUnresolvedFlexOp(long r8);

    private static native boolean resizeInput(long r8, long r10, int r11, int[] r12, boolean r13);

    private static native void run(long r8, long r10);

    private static native void setCancelled(long r8, long r10, boolean r11);

    public final TensorImpl a(int r8) {
        if (r8 < 0) goto L10;
        TensorImpl[] r10 = this.f9811p;
        if (r8 >= r10.length) goto L10;
        TensorImpl r11 = r10[r8];
        if (r11 != null) goto L11;
        long r12 = this.f9807b;
        TensorImpl r13 = TensorImpl.h(getInputTensorIndex(r12, r8), r12);
        r10[r8] = r13;
        return r13;
    L11:
        return r11;
    L10:
        throw new IllegalArgumentException(defpackage.a.d("Invalid input Tensor index: ", r8));
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        int r8 = 0;
    L3:
        TensorImpl[] r10 = this.f9811p;
        if (r8 >= r10.length) goto L9;
        TensorImpl r11 = r10[r8];
        if (r11 == null) goto L8;
        r11.c();
        this.f9811p[r8] = null;
    L8:
        r8 = r8 + 1;
        goto L3
    L9:
        int r12 = 0;
    L10:
        TensorImpl[] r13 = this.f9812q;
        if (r12 >= r13.length) goto L16;
        TensorImpl r14 = r13[r12];
        if (r14 == null) goto L15;
        r14.c();
        this.f9812q[r12] = null;
    L15:
        r12 = r12 + 1;
        goto L10
    L16:
        delete(this.f9806a, this.f9808m, this.f9807b);
        deleteCancellationFlag(0);
        this.f9806a = 0;
        this.f9808m = 0;
        this.f9807b = 0;
        this.f9809n = null;
        this.f9813r = false;
        this.f9814s.clear();
        ArrayList r15 = this.f9815t;
        Iterator r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        ((b) r16.next()).close();
        goto L18
    L20:
        r15.clear();
    }

    public final TensorImpl i(int r8) {
        if (r8 < 0) goto L10;
        TensorImpl[] r10 = this.f9812q;
        if (r8 >= r10.length) goto L10;
        TensorImpl r11 = r10[r8];
        if (r11 != null) goto L11;
        long r12 = this.f9807b;
        TensorImpl r13 = TensorImpl.h(getOutputTensorIndex(r12, r8), r12);
        r10[r8] = r13;
        return r13;
    L11:
        return r11;
    L10:
        throw new IllegalArgumentException(defpackage.a.d("Invalid output Tensor index: ", r8));
    }

    public final String[] k() {
        return getSignatureKeys(this.f9807b);
    }

    public final NativeSignatureRunnerWrapper n(String r10) {
        if (this.f9810o != null) goto L6;
        this.f9810o = new HashMap();
    L6:
        if (this.f9810o.containsKey(r10) == true) goto L9;
        this.f9810o.put(r10, new NativeSignatureRunnerWrapper(this.f9807b, r10, this.f9806a));
    L9:
        return (NativeSignatureRunnerWrapper) this.f9810o.get(r10);
    }

    public final void r(Object[] r10, AbstractMap r11) {
        this.inferenceDurationNanoseconds = -1;
        if (r10.length == 0) goto L54;
        int r8 = 0;
        int r12 = 0;
    L6:
        if (r12 >= r10.length) goto L25;
        TensorImpl r13 = a(r12);
        Object r14 = r10[r12];
        if (r14 != null) goto L11;
    L9:
        int[] r15 = null;
    L17:
        if (r15 == null) goto L23;
        if (resizeInput(this.f9807b, this.f9806a, r12, r15, false) == false) goto L23;
        this.f9813r = false;
        TensorImpl r16 = this.f9811p[r12];
        if (r16 == null) goto L23;
        r16.k();
    L23:
        r12 = r12 + 1;
        goto L6
    L11:
        if ((r14 instanceof Buffer) == true) goto L9;
        r13.m(r14);
        int[] r17 = r13.e(r14);
        if (Arrays.equals(r13.f9825c, r17) == true) goto L9;
        r15 = r17;
        goto L17
    L25:
        if (this.f9813r == false) goto L27;
        boolean r18 = false;
    L33:
        int r19 = 0;
    L35:
        if (r19 >= r10.length) goto L37;
        a(r19).l(r10[r19]);
        r19 = r19 + 1;
        goto L35
    L37:
        long r20 = System.nanoTime();
        run(this.f9807b, this.f9806a);
        long r21 = System.nanoTime() - r20;
        if (r18 == false) goto L45;
        TensorImpl[] r110 = this.f9812q;
        int r22 = r110.length;
    L40:
        if (r8 >= r22) goto L45;
        TensorImpl r23 = r110[r8];
        if (r23 == null) goto L44;
        r23.k();
    L44:
        r8 = r8 + 1;
    L45:
        Iterator r111 = r11.entrySet().iterator();
    L47:
        if (r111.hasNext() == false) goto L51;
        Map.Entry r112 = (Map.Entry) r111.next();
        if (r112.getValue() == null) goto L47;
        i(((Integer) r112.getKey()).intValue()).f(r112.getValue());
        goto L47
    L51:
        this.inferenceDurationNanoseconds = r21;
        return;
    L27:
        r18 = true;
        this.f9813r = true;
        allocateTensors(this.f9807b, this.f9806a);
        TensorImpl[] r24 = this.f9812q;
        int r25 = r24.length;
        int r26 = 0;
    L28:
        if (r26 >= r25) goto L33;
        TensorImpl r27 = r24[r26];
        if (r27 == null) goto L32;
        r27.k();
    L32:
        r26 = r26 + 1;
        goto L28
    L54:
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }

    public final void v(String r8, HashMap r10, HashMap r11) {
        this.inferenceDurationNanoseconds = -1;
        if (r10.isEmpty() == true) goto L56;
        NativeSignatureRunnerWrapper r12 = n(r8);
        if (r12.d() != 0) goto L16;
        Object[] r13 = new Object[r10.size()];
        Iterator r14 = r10.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13[r12.b((String) r15.getKey())] = r15.getValue();
        goto L8
    L10:
        TreeMap r16 = new TreeMap();
        Iterator r17 = r11.entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.put(Integer.valueOf(r12.c((String) r18.getKey())), r18.getValue());
        goto L12
    L14:
        r(r13, r16);
        return;
    L16:
        Iterator r19 = r10.entrySet().iterator();
    L18:
        if (r19.hasNext() == false) goto L43;
        Map.Entry r20 = (Map.Entry) r19.next();
        String r21 = (String) r20.getKey();
        if (r21 == null) goto L42;
        NativeSignatureRunnerWrapper r22 = n(r8);
        if (r22.d() != 0) goto L24;
        TensorImpl r23 = a(r22.b(r21));
    L25:
        Object r24 = r20.getValue();
        int[] r25 = null;
        if (r24 != null) goto L29;
    L35:
        if (r25 == null) goto L18;
        r12.f(r25, (String) r20.getKey());     // Catch: IllegalArgumentException -> L38
    L38:
        e = move-exception;
        throw ((IllegalArgumentException) new IllegalArgumentException(String.format("Tensor passed for input '%s' of signature '%s' has different shape than expected", new Object[]{r20.getKey(), r8})).initCause(e));
    L29:
        if ((r24 instanceof Buffer) == true) goto L35;
        r23.m(r24);
        int[] r26 = r23.e(r24);
        if (Arrays.equals(r23.f9825c, r26) == true) goto L35;
        r25 = r26;
        goto L35
    L24:
        r23 = TensorImpl.i(r22.f9816a, r21);
        goto L25
    L42:
        throw new IllegalArgumentException("Invalid input tensor name provided (null)");
    L43:
        r12.a();
        Iterator r27 = r10.entrySet().iterator();
    L44:
        boolean r28 = r27.hasNext();
        long r29 = r12.f9816a;
        if (r28 == false) goto L47;
        Map.Entry r30 = (Map.Entry) r27.next();
        TensorImpl.i(r29, (String) r30.getKey()).l(r30.getValue());
        goto L44
    L47:
        long r31 = System.nanoTime();
        r12.e();
        long r32 = System.nanoTime() - r31;
        Iterator r33 = r11.entrySet().iterator();
    L49:
        if (r33.hasNext() == false) goto L53;
        Map.Entry r34 = (Map.Entry) r33.next();
        if (r34.getValue() == null) goto L49;
        TensorImpl.j(r29, (String) r34.getKey()).f(r34.getValue());
        goto L49
    L53:
        this.inferenceDurationNanoseconds = r32;
        return;
    L56:
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }
}
