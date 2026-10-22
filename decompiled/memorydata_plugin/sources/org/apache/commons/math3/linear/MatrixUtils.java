package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class MatrixUtils {
    public static final RealMatrixFormat DEFAULT_FORMAT = null;
    public static final RealMatrixFormat OCTAVE_FORMAT = null;

    static {
        DEFAULT_FORMAT = RealMatrixFormat.getInstance();
        OCTAVE_FORMAT = new RealMatrixFormat("[", "]", "", "", "; ", ", ");
    }

    public static void checkAdditionCompatible(AnyMatrix r3, AnyMatrix r4) {
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r3, AnyMatrix.class, "com.obric.memorydata.plugin");
        AnyMatrix r6 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r4, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r5.getRowDimension() != r6.getRowDimension()) goto L8;
        if (r5.getColumnDimension() != r6.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r5.getRowDimension(), r5.getColumnDimension(), r6.getRowDimension(), r6.getColumnDimension());
    }

    public static void checkColumnIndex(AnyMatrix r3, int r4) {
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r3, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r4 < 0) goto L8;
        if (r4 >= r5.getColumnDimension()) goto L8;
        return;
    L8:
        throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r5.getColumnDimension() - 1));
    }

    public static void checkMatrixIndex(AnyMatrix r2, int r3, int r4) {
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r2, AnyMatrix.class, "com.obric.memorydata.plugin");
        checkRowIndex(r5, r3);
        checkColumnIndex(r5, r4);
    }

    public static void checkMultiplicationCompatible(AnyMatrix r2, AnyMatrix r3) {
        AnyMatrix r4 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r2, AnyMatrix.class, "com.obric.memorydata.plugin");
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r3, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r4.getColumnDimension() != r5.getRowDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r4.getColumnDimension(), r5.getRowDimension());
    }

    public static void checkRowIndex(AnyMatrix r3, int r4) {
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r3, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r4 < 0) goto L8;
        if (r4 >= r5.getRowDimension()) goto L8;
        return;
    L8:
        throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r5.getRowDimension() - 1));
    }

    public static void checkSubMatrixIndex(AnyMatrix r2, int r3, int r4, int r5, int r6) {
        AnyMatrix r7 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r2, AnyMatrix.class, "com.obric.memorydata.plugin");
        checkRowIndex(r7, r3);
        checkRowIndex(r7, r4);
        if (r4 < r3) goto L10;
        checkColumnIndex(r7, r5);
        checkColumnIndex(r7, r6);
        if (r6 < r5) goto L8;
        return;
    L8:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(r6), Integer.valueOf(r5), false);
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r4), Integer.valueOf(r3), false);
    }

    public static void checkSubMatrixIndex(AnyMatrix r4, int[] r5, int[] r6) {
        AnyMatrix r7 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r4, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L23;
        if (r6 == null) goto L21;
        if (r5.length == 0) goto L19;
        if (r6.length == 0) goto L17;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L12;
        checkRowIndex(r7, r5[r2]);
        r2 = r2 + 1;
        goto L10
    L12:
        int r8 = r6.length;
    L13:
        if (r1 >= r8) goto L15;
        checkColumnIndex(r7, r6[r1]);
        r1 = r1 + 1;
        goto L13
    L15:
        return;
    L17:
        throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY);
    L19:
        throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY);
    L21:
        throw new NullArgumentException();
    L23:
        throw new NullArgumentException();
    }

    public static void checkSubtractionCompatible(AnyMatrix r3, AnyMatrix r4) {
        AnyMatrix r5 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r3, AnyMatrix.class, "com.obric.memorydata.plugin");
        AnyMatrix r6 = (AnyMatrix) ZeusTransformUtils.wrapperContextForParams(r4, AnyMatrix.class, "com.obric.memorydata.plugin");
        if (r5.getRowDimension() != r6.getRowDimension()) goto L8;
        if (r5.getColumnDimension() != r6.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r5.getRowDimension(), r5.getColumnDimension(), r6.getRowDimension(), r6.getColumnDimension());
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldIdentityMatrix(Field<T> r6, int r7) {
        Field r8 = (Field) ZeusTransformUtils.wrapperContextForParams(r6, Field.class, "com.obric.memorydata.plugin");
        FieldElement r0 = (FieldElement) ZeusTransformUtils.preCheckCast(r8.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement r2 = (FieldElement) ZeusTransformUtils.preCheckCast(r8.getOne(), FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement[][] r1 = (FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r8, r7, r7), FieldElement[][].class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L3:
        if (r4 >= r7) goto L6;
        FieldElement[] r5 = r1[r4];
        Arrays.fill(r5, r0);
        r5[r4] = r2;
        r4 = r4 + 1;
        goto L3
    L6:
        return new Array2DRowFieldMatrix(r8, r1, false);
    }

    public static RealMatrix createRealIdentityMatrix(int r4) {
        RealMatrix r0 = createRealMatrix(r4, r4);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0.setEntry(r1, r1, 1.0d);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static RealMatrix createRealMatrix(int r2, int r3) {
        if ((r2 * r3) > 4096) goto L6;
        return new Array2DRowRealMatrix(r2, r3);
    L6:
        return new BlockRealMatrix(r2, r3);
    }

    public static RealMatrix createRealMatrix(double[][] r2) {
        if (r2 == null) goto L11;
        if (r2[0] == null) goto L11;
        if ((r2.length * r2[0].length) > 4096) goto L9;
        return new Array2DRowRealMatrix(r2);
    L9:
        return new BlockRealMatrix(r2);
    L11:
        throw new NullArgumentException();
    }

    public static RealVector createRealVector(double[] r2) {
        if (r2 == null) goto L6;
        return new ArrayRealVector(r2, true);
    L6:
        throw new NullArgumentException();
    }

    public static void deserializeRealMatrix(Object r10, String r11, ObjectInputStream r12) {
        int r0 = r12.readInt();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r1 = r12.readInt();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        double[] r6 = r2[r5];     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        int r7 = 0;
    L5:
        if (r7 >= r1) goto L7;
        r6[r7] = r12.readDouble();     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r7 = r7 + 1;     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        goto L5
    L7:
        r5 = r5 + 1;     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        goto L3
    L8:
        Array2DRowRealMatrix r13 = new Array2DRowRealMatrix(r2, false);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        java.lang.reflect.Field r14 = r10.getClass().getDeclaredField(r11);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r14.setAccessible(true);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        r14.set(r10, r13);     // Catch: IllegalAccessException -> L10 NoSuchFieldException -> L13
        return;
    L10:
        e = move-exception;
        IOException r15 = new IOException();
        r15.initCause(e);
        throw r15;
    L13:
        e = move-exception;
        IOException r16 = new IOException();
        r16.initCause(e);
        throw r16;
    }

    public static void deserializeRealVector(Object r6, String r7, ObjectInputStream r8) {
        int r0 = r8.readInt();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        double[] r1 = new double[r0];     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r8.readDouble();     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r3 = r3 + 1;     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        goto L3
    L5:
        ArrayRealVector r9 = new ArrayRealVector(r1, false);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        java.lang.reflect.Field r10 = r6.getClass().getDeclaredField(r7);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        r10.set(r6, r9);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L10
        return;
    L7:
        e = move-exception;
        IOException r11 = new IOException();
        r11.initCause(e);
        throw r11;
    L10:
        e = move-exception;
        IOException r12 = new IOException();
        r12.initCause(e);
        throw r12;
    }

    public static RealMatrix inverse(RealMatrix r2) {
        return inverse((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r2, RealMatrix.class, "com.obric.memorydata.plugin"), 0.0d);
    }

    public static RealMatrix inverse(RealMatrix r2, double r3) {
        RealMatrix r4 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r2, RealMatrix.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        if (r4.isSquare() == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, DiagonalMatrix.class) == false) goto L9;
        return ((DiagonalMatrix) ZeusTransformUtils.preCheckCast(r4, DiagonalMatrix.class, "com.obric.memorydata.plugin")).inverse(r3);
    L9:
        return new QRDecomposition(r4, r3).getSolver().getInverse();
    L11:
        throw new NonSquareMatrixException(r4.getRowDimension(), r4.getColumnDimension());
    }

    public static void serializeRealMatrix(RealMatrix r7, ObjectOutputStream r8) {
        RealMatrix r9 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r7, RealMatrix.class, "com.obric.memorydata.plugin");
        int r0 = r9.getRowDimension();
        int r1 = r9.getColumnDimension();
        r8.writeInt(r0);
        r8.writeInt(r1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L7;
        r8.writeDouble(r9.getEntry(r3, r4));
        r4 = r4 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    }

    public static void serializeRealVector(RealVector r4, ObjectOutputStream r5) {
        int r0 = r4.getDimension();
        r5.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.writeDouble(r4.getEntry(r1));
        r1 = r1 + 1;
        goto L3
    }
}
