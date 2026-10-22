package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n13896#2,14:3043\n13919#2,14:3057\n13942#2,14:3071\n13965#2,14:3085\n13988#2,14:3099\n14011#2,14:3113\n14034#2,14:3127\n14057#2,14:3141\n14080#2,14:3155\n16482#2,14:3169\n16505#2,14:3183\n16528#2,14:3197\n16551#2,14:3211\n16574#2,14:3225\n16597#2,14:3239\n16620#2,14:3253\n16643#2,14:3267\n16666#2,14:3281\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n*L\n2434#1:3043,14\n2441#1:3057,14\n2448#1:3071,14\n2455#1:3085,14\n2462#1:3099,14\n2469#1:3113,14\n2476#1:3127,14\n2483#1:3141,14\n2490#1:3155,14\n2632#1:3169,14\n2639#1:3183,14\n2646#1:3197,14\n2653#1:3211,14\n2660#1:3225,14\n2667#1:3239,14\n2674#1:3253,14\n2681#1:3267,14\n2688#1:3281,14\n*E\n"})
class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractList<Byte> implements RandomAccess {
        final /* synthetic */ byte[] $this_asList;

        AnonymousClass1(byte[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(byte r10) {
            return ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Byte) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).byteValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Byte get(int r10) {
            return Byte.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(byte r10) {
            return ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Byte) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).byteValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(byte r10) {
            return ArraysKt.lastIndexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Byte) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).byteValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractList<Short> implements RandomAccess {
        final /* synthetic */ short[] $this_asList;

        AnonymousClass2(short[] r10) {
            this.$this_asList = r10;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Short) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).shortValue());
        }

        public boolean contains(short r10) {
            return ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Short get(int r10) {
            return Short.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Short) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).shortValue());
        }

        public int indexOf(short r10) {
            return ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Short) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).shortValue());
        }

        public int lastIndexOf(short r10) {
            return ArraysKt.lastIndexOf(this.$this_asList, r10);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ int[] $this_asList;

        AnonymousClass3(int[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(int r10) {
            return ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Integer) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).intValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Integer get(int r10) {
            return Integer.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(int r10) {
            return ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).intValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(int r10) {
            return ArraysKt.lastIndexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).intValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractList<Long> implements RandomAccess {
        final /* synthetic */ long[] $this_asList;

        AnonymousClass4(long[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(long r10) {
            return ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Long) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).longValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Long get(int r10) {
            return Long.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(long r10) {
            return ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).longValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(long r10) {
            return ArraysKt.lastIndexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).longValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$5, reason: invalid class name */
    @SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12524#2,2:3043\n1687#2,6:3045\n1795#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3043,2\n201#1:3045,6\n202#1:3051,6\n*E\n"})
    public static final class AnonymousClass5 extends AbstractList<Float> implements RandomAccess {
        final /* synthetic */ float[] $this_asList;

        AnonymousClass5(float[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(float r10) {
            float[] r11 = this.$this_asList;
            int r12 = r11.length;
            int r13 = 0;
        L4:
            if (r13 >= r12) goto L15;
            if (Float.floatToIntBits(r11[r13]) != Float.floatToIntBits(r10)) goto L8;
            boolean r14 = true;
        L9:
            if (r14 == true) goto L12;
            r13 = r13 + 1;
            goto L4
        L12:
            return true;
        L8:
            r14 = false;
            goto L9
        L15:
            return false;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Float) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).floatValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Float get(int r10) {
            return Float.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(float r10) {
            float[] r11 = this.$this_asList;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L11;
            if (Float.floatToIntBits(r11[r13]) != Float.floatToIntBits(r10)) goto L7;
            boolean r14 = true;
        L8:
            if (r14 == true) goto L15;
            r13 = r13 + 1;
            goto L3
        L15:
            return r13;
        L7:
            r14 = false;
            goto L8
        L11:
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Float) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).floatValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(float r10) {
            float[] r11 = this.$this_asList;
            int r12 = r11.length - 1;
            if (r12 < 0) goto L13;
        L4:
            int r13 = r12 - 1;
            if (Float.floatToIntBits(r11[r12]) != Float.floatToIntBits(r10)) goto L7;
            boolean r14 = true;
        L8:
            if (r14 == true) goto L16;
            if (r13 < 0) goto L17;
            r12 = r13;
            goto L4
        L17:
            return -1;
        L16:
            return r12;
        L7:
            r14 = false;
            goto L8
        L13:
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Float) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).floatValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$6, reason: invalid class name */
    @SourceDebugExtension({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3042:1\n12534#2,2:3043\n1699#2,6:3045\n1807#2,6:3051\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n*L\n213#1:3043,2\n215#1:3045,6\n216#1:3051,6\n*E\n"})
    public static final class AnonymousClass6 extends AbstractList<Double> implements RandomAccess {
        final /* synthetic */ double[] $this_asList;

        AnonymousClass6(double[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(double r10) {
            double[] r11 = this.$this_asList;
            int r12 = r11.length;
            int r13 = 0;
        L4:
            if (r13 >= r12) goto L15;
            if (Double.doubleToLongBits(r11[r13]) != Double.doubleToLongBits(r10)) goto L8;
            boolean r14 = true;
        L9:
            if (r14 == true) goto L12;
            r13 = r13 + 1;
            goto L4
        L12:
            return true;
        L8:
            r14 = false;
            goto L9
        L15:
            return false;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Double) == true) goto L7;
            return false;
        L7:
            return contains(((Number) r10).doubleValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Double get(int r10) {
            return Double.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(double r10) {
            double[] r11 = this.$this_asList;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L11;
            if (Double.doubleToLongBits(r11[r13]) != Double.doubleToLongBits(r10)) goto L7;
            boolean r14 = true;
        L8:
            if (r14 == true) goto L15;
            r13 = r13 + 1;
            goto L3
        L15:
            return r13;
        L7:
            r14 = false;
            goto L8
        L11:
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Number) r10).doubleValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(double r10) {
            double[] r11 = this.$this_asList;
            int r12 = r11.length - 1;
            if (r12 < 0) goto L13;
        L4:
            int r13 = r12 - 1;
            if (Double.doubleToLongBits(r11[r12]) != Double.doubleToLongBits(r10)) goto L7;
            boolean r14 = true;
        L8:
            if (r14 == true) goto L16;
            if (r13 < 0) goto L17;
            r12 = r13;
            goto L4
        L17:
            return -1;
        L16:
            return r12;
        L7:
            r14 = false;
            goto L8
        L13:
            return -1;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Number) r10).doubleValue());
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractList<Boolean> implements RandomAccess {
        final /* synthetic */ boolean[] $this_asList;

        AnonymousClass7(boolean[] r10) {
            this.$this_asList = r10;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Boolean) == true) goto L7;
            return false;
        L7:
            return contains(((Boolean) r10).booleanValue());
        }

        public boolean contains(boolean r10) {
            return ArraysKt___ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Boolean get(int r10) {
            return Boolean.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Boolean) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Boolean) r10).booleanValue());
        }

        public int indexOf(boolean r10) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Boolean) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Boolean) r10).booleanValue());
        }

        public int lastIndexOf(boolean r10) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, r10);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.ArraysKt___ArraysJvmKt$asList$8, reason: invalid class name */
    public static final class AnonymousClass8 extends AbstractList<Character> implements RandomAccess {
        final /* synthetic */ char[] $this_asList;

        AnonymousClass8(char[] r10) {
            this.$this_asList = r10;
        }

        public boolean contains(char r10) {
            return ArraysKt.contains(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof Character) == true) goto L7;
            return false;
        L7:
            return contains(((Character) r10).charValue());
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Character get(int r10) {
            return Character.valueOf(this.$this_asList[r10]);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.$this_asList.length;
        }

        public int indexOf(char r10) {
            return ArraysKt___ArraysKt.indexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return indexOf(((Character) r10).charValue());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            if (this.$this_asList.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int lastIndexOf(char r10) {
            return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, r10);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof Character) == true) goto L7;
            return -1;
        L7:
            return lastIndexOf(((Character) r10).charValue());
        }
    }

    public ArraysKt___ArraysJvmKt() {
    }

    public static final List<Byte> asList(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final List<Character> asList(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass8(r10);
    }

    public static List<Double> asList(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass6(r10);
    }

    public static final List<Float> asList(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass5(r10);
    }

    public static List<Integer> asList(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass3(r10);
    }

    public static List<Long> asList(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass4(r10);
    }

    public static <T> List<T> asList(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<T> r11 = ArraysUtilJVM.asList(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "asList(this)");
        return r11;
    }

    public static final List<Short> asList(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass2(r10);
    }

    public static final List<Boolean> asList(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass7(r10);
    }

    public static final int binarySearch(byte[] r10, byte r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final int binarySearch(char[] r10, char r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final int binarySearch(double[] r10, double r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final int binarySearch(float[] r10, float r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final int binarySearch(int[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final int binarySearch(long[] r10, long r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final <T> int binarySearch(T[] r10, T r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static final <T> int binarySearch(T[] r10, T r11, Comparator<? super T> r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        return Arrays.binarySearch(r10, r13, r14, r11, r12);
    }

    public static final int binarySearch(short[] r10, short r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Arrays.binarySearch(r10, r12, r13, r11);
    }

    public static /* synthetic */ int binarySearch$default(byte[] r10, byte r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(char[] r10, char r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(double[] r10, double r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(float[] r10, float r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(int[] r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(long[] r10, long r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(Object[] r10, Object r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    public static /* synthetic */ int binarySearch$default(Object[] r10, Object r11, Comparator r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r13 = 0;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ int binarySearch$default(short[] r10, short r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = r10.length;
    L9:
        return binarySearch(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsInline")
    @LowPriorityInOverloadResolution
    private static final <T> boolean contentDeepEqualsInline(T[] r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return ArraysKt__ArraysKt.contentDeepEquals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsNullable")
    private static final <T> boolean contentDeepEqualsNullable(T[] r10, T[] r11) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        return ArraysKt__ArraysKt.contentDeepEquals(r10, r11);
    L7:
        return Arrays.deepEquals(r10, r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeInline")
    @LowPriorityInOverloadResolution
    private static final <T> int contentDeepHashCodeInline(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeNullable")
    private static final <T> int contentDeepHashCodeNullable(T[] r10) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L7;
        return ArraysKt__ArraysJVMKt.contentDeepHashCode(r10);
    L7:
        return Arrays.deepHashCode(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepToStringInline")
    @LowPriorityInOverloadResolution
    private static final <T> String contentDeepToStringInline(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt__ArraysKt.contentDeepToString(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "contentDeepToStringNullable")
    private static final <T> String contentDeepToStringNullable(T[] r10) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == true) goto L5;
        String r11 = Arrays.deepToString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "deepToString(this)");
        return r11;
    L5:
        return ArraysKt__ArraysKt.contentDeepToString(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(byte[] r10, byte[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(char[] r10, char[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(double[] r10, double[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(float[] r10, float[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(int[] r10, int[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(long[] r10, long[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T> boolean contentEquals(T[] r10, T[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(short[] r10, short[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean contentEquals(boolean[] r10, boolean[] r11) {
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(byte[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(char[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(double[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(float[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(int[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(long[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T> int contentHashCode(T[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(short[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int contentHashCode(boolean[] r10) {
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(byte[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(char[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(double[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(float[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(int[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(long[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T> String contentToString(T[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(short[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String contentToString(boolean[] r10) {
        String r11 = Arrays.toString(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "toString(this)");
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static byte[] copyInto(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final char[] copyInto(char[] r10, char[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final double[] copyInto(double[] r10, double[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final float[] copyInto(float[] r10, float[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static int[] copyInto(int[] r10, int[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static long[] copyInto(long[] r10, long[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static <T> T[] copyInto(T[] r10, T[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static short[] copyInto(short[] r10, short[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final boolean[] copyInto(boolean[] r10, boolean[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] r10, byte[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return ArraysKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ char[] copyInto$default(char[] r10, char[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ double[] copyInto$default(double[] r10, double[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ float[] copyInto$default(float[] r10, float[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ int[] copyInto$default(int[] r10, int[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return ArraysKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ long[] copyInto$default(long[] r10, long[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return ArraysKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] r10, Object[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return ArraysKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ short[] copyInto$default(short[] r10, short[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return ArraysKt.copyInto(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] r10, boolean[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return copyInto(r10, r11, r12, r13, r14);
    }

    @InlineOnly
    private static final byte[] copyOf(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final byte[] copyOf(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final char[] copyOf(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        char[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final char[] copyOf(char[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        char[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final double[] copyOf(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        double[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final double[] copyOf(double[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        double[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final float[] copyOf(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final float[] copyOf(float[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final int[] copyOf(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final int[] copyOf(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final long[] copyOf(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final long[] copyOf(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final <T> T[] copyOf(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T[] r11 = (T[]) Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final <T> T[] copyOf(T[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        T[] r12 = (T[]) Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final short[] copyOf(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final short[] copyOf(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        short[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @InlineOnly
    private static final boolean[] copyOf(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @InlineOnly
    private static final boolean[] copyOf(boolean[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static byte[] copyOfRange(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        byte[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final char[] copyOfRange(char[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        char[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final double[] copyOfRange(double[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        double[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final float[] copyOfRange(float[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        float[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static int[] copyOfRange(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        int[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static long[] copyOfRange(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        long[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static <T> T[] copyOfRange(T[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        T[] r13 = (T[]) Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static short[] copyOfRange(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        short[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final boolean[] copyOfRange(boolean[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(r12, r10.length);
        boolean[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "copyOfRange(this, fromIndex, toIndex)");
        return r13;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final byte[] copyOfRangeInline(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return ArraysKt.copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        byte[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final char[] copyOfRangeInline(char[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        char[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final double[] copyOfRangeInline(double[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        double[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final float[] copyOfRangeInline(float[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        float[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final int[] copyOfRangeInline(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return ArraysKt.copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        int[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final long[] copyOfRangeInline(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return ArraysKt.copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        long[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final <T> T[] copyOfRangeInline(T[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return (T[]) ArraysKt.copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        T[] r13 = (T[]) Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final short[] copyOfRangeInline(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return ArraysKt.copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        short[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    private static final boolean[] copyOfRangeInline(boolean[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L6;
        return copyOfRange(r10, r11, r12);
    L6:
        if (r12 > r10.length) goto L10;
        boolean[] r13 = Arrays.copyOfRange(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
        return r13;
    L10:
        throw new IndexOutOfBoundsException("toIndex: " + r12 + ", size: " + r10.length);
    }

    @InlineOnly
    private static final byte elementAt(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final char elementAt(char[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final double elementAt(double[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final float elementAt(float[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final int elementAt(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final long elementAt(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final <T> T elementAt(T[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final short elementAt(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    @InlineOnly
    private static final boolean elementAt(boolean[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10[r11];
    }

    public static void fill(byte[] r10, byte r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static final void fill(char[] r10, char r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static final void fill(double[] r10, double r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static final void fill(float[] r10, float r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static void fill(int[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static void fill(long[] r10, long r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static <T> void fill(T[] r10, T r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static void fill(short[] r10, short r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static final void fill(boolean[] r10, boolean r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static /* synthetic */ void fill$default(byte[] r10, byte r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        ArraysKt.fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(char[] r10, char r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(double[] r10, double r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(float[] r10, float r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(int[] r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        ArraysKt.fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(long[] r10, long r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        ArraysKt.fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(Object[] r10, Object r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        ArraysKt.fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(short[] r10, short r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        ArraysKt.fill(r10, r11, r12, r13);
    }

    public static /* synthetic */ void fill$default(boolean[] r10, boolean r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        fill(r10, r11, r12, r13);
    }

    public static final <R> List<R> filterIsInstance(Object[] r10, Class<R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "klass");
        return (List) filterIsInstanceTo(r10, new ArrayList(), r11);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] r10, C r11, Class<R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "klass");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Object r15 = r10[r14];
        if (r12.isInstance(r15) == false) goto L7;
        r11.add(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte max(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character max(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable max(Comparable[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double max(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double max(Double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float max(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float max(Float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer max(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long max(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short max(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.maxOrNull(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean maxBy(boolean[] r10, Function1<? super Boolean, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        boolean r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Boolean.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        boolean r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Boolean.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Boolean.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte maxBy(byte[] r10, Function1<? super Byte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        byte r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Byte.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        byte r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Byte.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Byte.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character maxBy(char[] r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        char r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        char r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double maxBy(double[] r10, Function1<? super Double, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        double r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Double.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        double r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Double.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r15 = r18;
        r13 = r17;
    L23:
        return Double.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float maxBy(float[] r10, Function1<? super Float, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        float r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Float.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        float r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Float.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Float.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer maxBy(int[] r10, Function1<? super Integer, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        int r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Integer.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        int r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Integer.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Integer.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long maxBy(long[] r10, Function1<? super Long, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        long r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Long.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        long r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Long.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r15 = r18;
        r13 = r17;
    L23:
        return Long.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T maxBy(T[] r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        T r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(r13);
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        T r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(r17);
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short maxBy(short[] r10, Function1<? super Short, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        short r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Short.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        short r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Short.valueOf(r17));
        if (r15.compareTo(r18) >= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Short.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Boolean maxWith(boolean[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte maxWith(byte[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character maxWith(char[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double maxWith(double[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float maxWith(float[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer maxWith(int[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long maxWith(long[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object maxWith(Object[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short maxWith(short[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.maxWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte min(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character min(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable min(Comparable[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double min(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double min(Double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float min(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @SinceKotlin(version = "1.1")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float min(Float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer min(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long min(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short min(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ArraysKt___ArraysKt.minOrNull(r10);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean minBy(boolean[] r10, Function1<? super Boolean, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        boolean r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Boolean.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        boolean r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Boolean.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Boolean.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte minBy(byte[] r10, Function1<? super Byte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        byte r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Byte.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        byte r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Byte.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Byte.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character minBy(char[] r10, Function1<? super Character, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        char r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Character.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        char r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Character.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Character.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double minBy(double[] r10, Function1<? super Double, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        double r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Double.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        double r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Double.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r15 = r18;
        r13 = r17;
    L23:
        return Double.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float minBy(float[] r10, Function1<? super Float, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        float r13 = r10[0];
        int r14 = ArraysKt___ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Float.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        float r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Float.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Float.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer minBy(int[] r10, Function1<? super Integer, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        int r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Integer.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        int r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Integer.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Integer.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long minBy(long[] r10, Function1<? super Long, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        long r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Long.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        long r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Long.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r15 = r18;
        r13 = r17;
    L23:
        return Long.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T minBy(T[] r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        T r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(r13);
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        T r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(r17);
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short minBy(short[] r10, Function1<? super Short, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (r10.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return null;
    L8:
        short r13 = r10[0];
        int r14 = ArraysKt.getLastIndex(r10);
        if (r14 == 0) goto L23;
        R r15 = r11.invoke(Short.valueOf(r13));
        ?? r16 = new IntRange(1, r14).iterator2();
    L13:
        if (r16.hasNext() == false) goto L23;
        short r17 = r10[r16.nextInt()];
        R r18 = r11.invoke(Short.valueOf(r17));
        if (r15.compareTo(r18) <= 0) goto L13;
        r13 = r17;
        r15 = r18;
    L23:
        return Short.valueOf(r13);
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Boolean minWith(boolean[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte minWith(byte[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character minWith(char[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double minWith(double[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float minWith(float[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer minWith(int[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long minWith(long[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object minWith(Object[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short minWith(short[] r10, Comparator r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return ArraysKt___ArraysKt.minWithOrNull(r10, r11);
    }

    public static byte[] plus(byte[] r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        byte[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final byte[] plus(byte[] r10, Collection<Byte> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        byte[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Byte> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().byteValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static byte[] plus(byte[] r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        byte[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final char[] plus(char[] r10, char r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        char[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final char[] plus(char[] r10, Collection<Character> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        char[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Character> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().charValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final char[] plus(char[] r10, char[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        char[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final double[] plus(double[] r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        double[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final double[] plus(double[] r10, Collection<Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        double[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Double> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().doubleValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final double[] plus(double[] r10, double[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        double[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final float[] plus(float[] r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        float[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final float[] plus(float[] r10, Collection<Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        float[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Float> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().floatValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final float[] plus(float[] r10, float[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        float[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static int[] plus(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        int[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final int[] plus(int[] r10, Collection<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Integer> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().intValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static int[] plus(int[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        int[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static long[] plus(long[] r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        long[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final long[] plus(long[] r10, Collection<Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        long[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Long> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().longValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static long[] plus(long[] r10, long[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        long[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final <T> T[] plus(T[] r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        T[] r13 = (T[]) Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final <T> T[] plus(T[] r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        T[] r13 = (T[]) Arrays.copyOf(r10, r11.size() + r12);
        Iterator<? extends T> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final <T> T[] plus(T[] r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        T[] r14 = (T[]) Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final short[] plus(short[] r10, Collection<Short> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        short[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Short> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().shortValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static short[] plus(short[] r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        short[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static short[] plus(short[] r10, short[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        short[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    public static final boolean[] plus(boolean[] r10, Collection<Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        boolean[] r13 = Arrays.copyOf(r10, r11.size() + r12);
        Iterator<Boolean> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13[r12] = r14.next().booleanValue();
        r12 = r12 + 1;
        goto L4
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final boolean[] plus(boolean[] r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = r10.length;
        boolean[] r13 = Arrays.copyOf(r10, r12 + 1);
        r13[r12] = r11;
        Intrinsics.checkNotNullExpressionValue(r13, "result");
        return r13;
    }

    public static final boolean[] plus(boolean[] r10, boolean[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = r10.length;
        int r13 = r11.length;
        boolean[] r14 = Arrays.copyOf(r10, r12 + r13);
        System.arraycopy(r11, 0, r14, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "result");
        return r14;
    }

    @InlineOnly
    private static final <T> T[] plusElement(T[] r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (T[]) plus(r10, r11);
    }

    public static final void sort(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(char[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(double[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(float[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> void sort(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        sort(r10);
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> void sort(T[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final <T> void sort(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final <T> void sort(T[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static final void sort(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void sort(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Arrays.sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(byte[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(char[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(double[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(float[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(int[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(long[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(Comparable[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(Object[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static /* synthetic */ void sort$default(short[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length;
    L8:
        sort(r10, r11, r12);
    }

    public static final <T> void sortWith(T[] r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10, r11);
        return;
    }

    public static final <T> void sortWith(T[] r10, Comparator<? super T> r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Arrays.sort(r10, r12, r13, r11);
    }

    public static /* synthetic */ void sortWith$default(Object[] r10, Comparator r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        sortWith(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(byte[] r10, Function1<? super Byte, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Byte.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(char[] r10, Function1<? super Character, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Character.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(double[] r10, Function1<? super Double, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Double.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(float[] r10, Function1<? super Float, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Float.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(int[] r10, Function1<? super Integer, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Integer.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(long[] r10, Function1<? super Long, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Long.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigDecimal sumOfBigDecimal(T[] r10, Function1<? super T, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(r10[r14]));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(short[] r10, Function1<? super Short, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Short.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal sumOfBigDecimal(boolean[] r10, Function1<? super Boolean, ? extends BigDecimal> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigDecimal r12 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Boolean.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(byte[] r10, Function1<? super Byte, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Byte.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(char[] r10, Function1<? super Character, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Character.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(double[] r10, Function1<? super Double, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Double.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(float[] r10, Function1<? super Float, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Float.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(int[] r10, Function1<? super Integer, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Integer.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(long[] r10, Function1<? super Long, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Long.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final <T> BigInteger sumOfBigInteger(T[] r10, Function1<? super T, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(r10[r14]));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(short[] r10, Function1<? super Short, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Short.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger sumOfBigInteger(boolean[] r10, Function1<? super Boolean, ? extends BigInteger> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        BigInteger r12 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(this.toLong())");
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = r12.add(r11.invoke(Boolean.valueOf(r10[r14])));
        Intrinsics.checkNotNullExpressionValue(r12, "this.add(other)");
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    public static final SortedSet<Byte> toSortedSet(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Character> toSortedSet(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Double> toSortedSet(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Float> toSortedSet(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Integer> toSortedSet(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Long> toSortedSet(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final <T> SortedSet<T> toSortedSet(T[] r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet(r11));
    }

    public static final SortedSet<Short> toSortedSet(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final SortedSet<Boolean> toSortedSet(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(r10, new TreeSet());
    }

    public static final Boolean[] toTypedArray(boolean[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Boolean[] r11 = new Boolean[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Boolean.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Byte[] toTypedArray(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Byte[] r11 = new Byte[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Byte.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Character[] toTypedArray(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Character[] r11 = new Character[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Character.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Double[] toTypedArray(double[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Double[] r11 = new Double[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Double.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Float[] toTypedArray(float[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Float[] r11 = new Float[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Float.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Integer[] toTypedArray(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Integer[] r11 = new Integer[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Integer.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Long[] toTypedArray(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Long[] r11 = new Long[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Long.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final Short[] toTypedArray(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Short[] r11 = new Short[r10.length];
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13] = Short.valueOf(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
