package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class TensorImpl implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f9825c;

    public TensorImpl(long r8) {
        this.f9823a = r8;
        int r10 = dtype(r8);
        switch(r10) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L5;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        a r11 = a.f9833r;
    L14:
        this.f9824b = r11;
        this.f9825c = shape(r8);
        shapeSignature(r8);
        quantizationScale(r8);
        quantizationZeroPoint(r8);
        return;
    L7:
        r11 = a.f9832q;
        goto L14
    L8:
        r11 = a.f9831p;
        goto L14
    L9:
        r11 = a.f9830o;
        goto L14
    L10:
        r11 = a.f9829n;
        goto L14
    L11:
        r11 = a.f9828m;
        goto L14
    L12:
        r11 = a.f9827b;
        goto L14
    L13:
        r11 = a.f9826a;
        goto L14
    L5:
        throw new IllegalArgumentException(android.aimedia.a.c("DataType error: DataType ", r10, " is not recognized in Java."));
    }

    private static native ByteBuffer buffer(long r8);

    private static native long create(long r8, int r10, int r11);

    private static native long createSignatureInputTensor(long r8, String r10);

    private static native long createSignatureOutputTensor(long r8, String r10);

    public static int d(Object r8) {
        if (r8 != null) goto L5;
    L13:
        return 0;
    L5:
        if (r8.getClass().isArray() == false) goto L13;
        if (Array.getLength(r8) == 0) goto L12;
        return d(Array.get(r8, 0)) + 1;
    L12:
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    private static native void delete(long r8);

    private static native int dtype(long r8);

    public static void g(Object r8, int r10, int[] r11) {
        if (r10 != r11.length) goto L5;
        return;
    L5:
        int r12 = Array.getLength(r8);
        int r13 = r11[r10];
        if (r13 != 0) goto L8;
        r11[r10] = r12;
    L9:
        int r14 = r10 + 1;
        if (r14 != r11.length) goto L12;
        return;
    L12:
        int r15 = 0;
    L13:
        if (r15 >= r12) goto L15;
        g(Array.get(r8, r15), r14, r11);
        r15 = r15 + 1;
        goto L13
    L15:
        return;
    L8:
        if (r13 == r12) goto L9;
        throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(r11[r10]), Integer.valueOf(r12), Integer.valueOf(r10)}));
    }

    public static TensorImpl h(int r8, long r10) {
        return new TensorImpl(create(r10, r8, 0));
    }

    private static native boolean hasDelegateBufferHandle(long r8);

    public static TensorImpl i(long r8, String r10) {
        long r11 = createSignatureInputTensor(r8, r10);
        if (r11 == (-1)) goto L7;
        return new TensorImpl(r11);
    L7:
        throw new IllegalArgumentException(defpackage.b.d("Input error: input ", r10, " not found."));
    }

    private static native int index(long r8);

    public static TensorImpl j(long r8, String r10) {
        long r11 = createSignatureOutputTensor(r8, r10);
        if (r11 == (-1)) goto L7;
        return new TensorImpl(r11);
    L7:
        throw new IllegalArgumentException(defpackage.b.d("Input error: output ", r10, " not found."));
    }

    private static native String name(long r8);

    private static native int numBytes(long r8);

    private static native float quantizationScale(long r8);

    private static native int quantizationZeroPoint(long r8);

    private static native void readMultiDimensionalArray(long r8, Object r10);

    private static native int[] shape(long r8);

    private static native int[] shapeSignature(long r8);

    private static native void writeDirectBuffer(long r8, Buffer r10);

    private static native void writeMultiDimensionalArray(long r8, Object r10);

    private static native void writeScalar(long r8, Object r10);

    @Override // org.tensorflow.lite.h
    public final int[] a() {
        return this.f9825c;
    }

    public final ByteBuffer b() {
        return buffer(this.f9823a).order(ByteOrder.nativeOrder());
    }

    public final void c() {
        delete(this.f9823a);
        this.f9823a = 0;
    }

    public final int[] e(Object r8) {
        int r10 = d(r8);
        if (this.f9824b != a.f9830o) goto L12;
        Class<?> r11 = r8.getClass();
        if (r11.isArray() == false) goto L12;
    L7:
        if (r11.isArray() == false) goto L10;
        r11 = r11.getComponentType();
        goto L7
    L10:
        if (Byte.TYPE.equals(r11) == false) goto L12;
        r10 = r10 - 1;
    L12:
        int[] r12 = new int[r10];
        g(r8, 0, r12);
        return r12;
    }

    public final void f(Object r8) {
        if (r8 == null) goto L4;
        m(r8);
        boolean r10 = r8 instanceof Buffer;
        if (r10 == false) goto L18;
        Buffer r11 = (Buffer) r8;
        int r12 = numBytes(this.f9823a);
        if ((r8 instanceof ByteBuffer) == false) goto L13;
        int r13 = r11.capacity();
    L14:
        if (r12 > r13) goto L17;
    L20:
        if (r10 == false) goto L38;
        Buffer r14 = (Buffer) r8;
        if ((r14 instanceof ByteBuffer) == false) goto L25;
        ((ByteBuffer) r14).put(b());
        return;
    L25:
        if ((r14 instanceof FloatBuffer) == false) goto L28;
        ((FloatBuffer) r14).put(b().asFloatBuffer());
        return;
    L28:
        if ((r14 instanceof LongBuffer) == false) goto L31;
        ((LongBuffer) r14).put(b().asLongBuffer());
        return;
    L31:
        if ((r14 instanceof IntBuffer) == false) goto L34;
        ((IntBuffer) r14).put(b().asIntBuffer());
        return;
    L34:
        if ((r14 instanceof ShortBuffer) == false) goto L37;
        ((ShortBuffer) r14).put(b().asShortBuffer());
        return;
    L37:
        throw new IllegalArgumentException("Unexpected output buffer type: " + r14);
    L38:
        readMultiDimensionalArray(this.f9823a, r8);
        return;
    L17:
        throw new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[]{name(this.f9823a), Integer.valueOf(r12), Integer.valueOf(r13)}));
    L13:
        r13 = r11.capacity() * this.f9824b.a();
        goto L14
    L18:
        int[] r15 = e(r8);
        if (Arrays.equals(r15, this.f9825c) == true) goto L20;
        throw new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", new Object[]{name(this.f9823a), Arrays.toString(this.f9825c), Arrays.toString(r15)}));
    L4:
        if (hasDelegateBufferHandle(this.f9823a) == false) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
    }

    public final void k() {
        this.f9825c = shape(this.f9823a);
    }

    public final void l(Object r8) {
        if (r8 == null) goto L4;
        m(r8);
        boolean r10 = r8 instanceof Buffer;
        a r11 = this.f9824b;
        if (r10 == false) goto L18;
        Buffer r12 = (Buffer) r8;
        int r13 = numBytes(this.f9823a);
        if ((r8 instanceof ByteBuffer) == false) goto L13;
        int r14 = r12.capacity();
    L14:
        if (r13 != r14) goto L17;
    L20:
        if (r10 == false) goto L64;
        Buffer r15 = (Buffer) r8;
        if ((r15 instanceof ByteBuffer) == false) goto L30;
        ByteBuffer r16 = (ByteBuffer) r15;
        if (r16.isDirect() == true) goto L26;
    L28:
        b().put(r16);
        return;
    L26:
        if (r16.order() != ByteOrder.nativeOrder()) goto L28;
    L59:
        writeDirectBuffer(this.f9823a, r15);
        return;
    L30:
        if ((r15 instanceof LongBuffer) == false) goto L38;
        LongBuffer r17 = (LongBuffer) r15;
        if (r17.isDirect() == true) goto L34;
    L36:
        b().asLongBuffer().put(r17);
        return;
    L34:
        if (r17.order() != ByteOrder.nativeOrder()) goto L36;
    L38:
        if ((r15 instanceof FloatBuffer) == false) goto L46;
        FloatBuffer r18 = (FloatBuffer) r15;
        if (r18.isDirect() == true) goto L42;
    L44:
        b().asFloatBuffer().put(r18);
        return;
    L42:
        if (r18.order() != ByteOrder.nativeOrder()) goto L44;
    L46:
        if ((r15 instanceof IntBuffer) == false) goto L54;
        IntBuffer r19 = (IntBuffer) r15;
        if (r19.isDirect() == true) goto L50;
    L52:
        b().asIntBuffer().put(r19);
        return;
    L50:
        if (r19.order() != ByteOrder.nativeOrder()) goto L52;
    L54:
        if ((r15 instanceof ShortBuffer) == false) goto L62;
        ShortBuffer r20 = (ShortBuffer) r15;
        if (r20.isDirect() == true) goto L58;
    L60:
        b().asShortBuffer().put(r20);
        return;
    L58:
        if (r20.order() != ByteOrder.nativeOrder()) goto L60;
    L62:
        throw new IllegalArgumentException("Unexpected input buffer type: " + r15);
    L64:
        if (r11 != a.f9830o) goto L69;
        if (this.f9825c.length != 0) goto L69;
    L71:
        writeScalar(this.f9823a, r8);
        return;
    L69:
        if (r8.getClass().isArray() == false) goto L71;
        writeMultiDimensionalArray(this.f9823a, r8);
        return;
    L17:
        throw new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[]{name(this.f9823a), Integer.valueOf(r13), Integer.valueOf(r14)}));
    L13:
        r14 = r12.capacity() * r11.a();
        goto L14
    L18:
        int[] r21 = e(r8);
        if (Arrays.equals(r21, this.f9825c) == true) goto L20;
        throw new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", new Object[]{name(this.f9823a), Arrays.toString(this.f9825c), Arrays.toString(r21)}));
    L4:
        if (hasDelegateBufferHandle(this.f9823a) == false) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
    }

    public final void m(Object r8) {
        if ((r8 instanceof ByteBuffer) == false) goto L5;
        return;
    L5:
        Class<?> r10 = r8.getClass();
        boolean r11 = r10.isArray();
        a r12 = this.f9824b;
        if (r11 == false) goto L35;
    L8:
        if (r10.isArray() == false) goto L11;
        r10 = r10.getComponentType();
        goto L8
    L11:
        if (Float.TYPE.equals(r10) == false) goto L14;
    L65:
        a r13 = a.f9826a;
    L66:
        if (r13 != r12) goto L68;
        return;
    L68:
        if (t2.b.a0(r13).equals(t2.b.a0(r12)) == false) goto L71;
        return;
    L71:
        throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[]{r12, r8.getClass().getName(), r13}));
    L14:
        if (Integer.TYPE.equals(r10) == false) goto L17;
    L15:
        r13 = a.f9827b;
        goto L66
    L17:
        if (Short.TYPE.equals(r10) == false) goto L20;
    L18:
        r13 = a.f9832q;
        goto L66
    L20:
        if (Byte.TYPE.equals(r10) == false) goto L26;
        r13 = a.f9830o;
        if (r12 == r13) goto L66;
    L24:
        r13 = a.f9828m;
        goto L66
    L26:
        if (Long.TYPE.equals(r10) == false) goto L29;
    L27:
        r13 = a.f9829n;
        goto L66
    L29:
        if (Boolean.TYPE.equals(r10) == false) goto L32;
    L30:
        r13 = a.f9831p;
        goto L66
    L32:
        if (String.class.equals(r10) == false) goto L64;
    L33:
        r13 = a.f9830o;
    L64:
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of ".concat(r8.getClass().getName()));
    L35:
        if (Float.class.equals(r10) == true) goto L65;
        if ((r8 instanceof FloatBuffer) == true) goto L65;
        if (Integer.class.equals(r10) == true) goto L15;
        if ((r8 instanceof IntBuffer) == true) goto L15;
        if (Short.class.equals(r10) == true) goto L18;
        if ((r8 instanceof ShortBuffer) == true) goto L18;
        if (Byte.class.equals(r10) == true) goto L24;
        if (Long.class.equals(r10) == true) goto L27;
        if ((r8 instanceof LongBuffer) == true) goto L27;
        if (Boolean.class.equals(r10) == true) goto L30;
        if (String.class.equals(r10) == false) goto L64;
        goto L33
    }
}
