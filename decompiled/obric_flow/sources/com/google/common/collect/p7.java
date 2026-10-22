package com.google.common.collect;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j8 f9120a = null;

    static {
        f9120a = new j8(3);
    }

    public static boolean A(Set r5, Object r10) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == false) goto L15;
        Set r11 = (Set) r10;
        if (r5.size() != r11.size()) goto L14;
        if (r5.containsAll(r11) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static void A0(j0 r5, ObjectOutputStream r10) {
        r10.writeInt(r5.entrySet().size());
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        y7 r12 = (y7) r11.next();
        r10.writeObject(r12.getElement());
        r10.writeInt(r12.getCount());
        goto L4
    }

    public static int B(int r5, int r10) {
        if (r10 < 0) goto L10;
        int r11 = (r5 + (r5 >> 1)) + 1;
        if (r11 >= r10) goto L6;
        r11 = Integer.highestOneBit(r10 - 1) << 1;
    L6:
        if (r11 >= 0) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return r11;
    L10:
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }

    public static void C(Collection r5, Object[] r10) {
        Iterator r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r10[r12] = r11.next();
        r12 = r12 + 1;
        goto L4
    }

    public static u1 D(Spliterator r10, Function r11, int r12, long r13) {
        boolean r5 = false;
        if ((r12 & 16384) != 0) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.b0.g("flatMap does not support SUBSIZED characteristic", r14);
        if ((r12 & 4) != 0) goto L9;
        r5 = true;
    L9:
        com.google.common.base.b0.g("flatMap does not support SORTED characteristic", r5);
        r10.getClass();
        return new u1(null, r10, r11, r12, r13);
    L5:
        r14 = false;
        goto L6
    }

    public static g5 E(int r5, int r10, Object[] r11) {
        if (r5 < 0) goto L5;
        boolean r12 = true;
    L6:
        com.google.common.base.b0.i(r12);
        com.google.common.base.b0.p(0, r5, r11.length);
        com.google.common.base.b0.o(r10, r5);
        if (r5 != 0) goto L11;
        return g5.d;
    L11:
        return new g5(r11, r5, r10);
    L5:
        r12 = false;
        goto L6
    }

    public static f7 F(Class r5, String r10) {
        return new f7(r5.getDeclaredField(r10));
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static Object G(Iterator r5) {
        if (r5.hasNext() == true) goto L7;
        return null;
    L7:
        return r5.next();
    }

    public static Object H(Collection r5) {
        Iterator r10 = r5.iterator();
        Object r11 = r10.next();
        if (r10.hasNext() == true) goto L5;
        return r11;
    L5:
        StringBuilder r12 = new StringBuilder("expected one element but was: <");
        r12.append(r11);
        int r13 = 0;
    L7:
        if (r13 >= 4) goto L12;
        if (r10.hasNext() == false) goto L12;
        r12.append(", ");
        r12.append(r10.next());
        r13 = r13 + 1;
    L12:
        if (r10.hasNext() == false) goto L14;
        r12.append(", ...");
    L14:
        r12.append(Typography.greater);
        throw new IllegalArgumentException(r12.toString());
    }

    public static boolean I(Comparator r5, Iterable r10) {
        r5.getClass();
        r10.getClass();
        if ((r10 instanceof SortedSet) == false) goto L8;
        Comparator r11 = ((SortedSet) r10).comparator();
        if (r11 != null) goto L11;
        r11 = g8.natural();
    L11:
        return r5.equals(r11);
    L8:
        if ((r10 instanceof t8) == false) goto L12;
        r11 = ((t8) r10).comparator();
        goto L11
    L12:
        return false;
    }

    public static int J(Set r5) {
        Iterator r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r12 = r10.next();
        if (r12 == null) goto L8;
        int r13 = r12.hashCode();
    L9:
        r11 = ~(~(r11 + r13));
        goto L4
    L8:
        r13 = 0;
        goto L9
    L10:
        return r11;
    }

    public static y7 K(int r5, Object r10) {
        return new Multisets$ImmutableEntry(r10, r5);
    }

    public static Map.Entry L(Object r5, Object r10) {
        return new ImmutableEntry(r5, r10);
    }

    public static ImmutableMap M(Collection r10) {
        Map.Entry[] r5 = new Map.Entry[r10.size()];
        Iterator r11 = r10.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r14 = r11.next();
        int r15 = r12 + 1;
        Integer r16 = Integer.valueOf(r12);
        int r17 = r13 + 1;
        if (r17 <= r5.length) goto L8;
        r5 = (Map.Entry[]) Arrays.copyOf(r5, B(r5.length, r17));
    L8:
        r5[r13] = ImmutableMap.entryOf(r14, r16);
        r13 = r13 + 1;
        r12 = r15;
        goto L4
    L9:
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L19;
        Map.Entry r18 = r5[0];
        Objects.requireNonNull(r18);
        return ImmutableMap.of(r18.getKey(), r18.getValue());
    L19:
        return RegularImmutableMap.fromEntryArray(r13, r5, true);
    L15:
        return ImmutableMap.of();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Spliterator$OfInt] */
    public static s1 N(int r5, int r10, IntFunction r11, Comparator r12) {
        if (r12 == null) goto L10;
        if ((r10 & 4) == 0) goto L7;
        boolean r13 = true;
    L8:
        com.google.common.base.b0.i(r13);
        goto L10
    L7:
        r13 = false;
    L10:
        return new s1(IntStream.range(0, r5).spliterator(), r11, r10, r12);
    }

    public static c8 O(z7 r5) {
        return new c8(r5, r5.entrySet().iterator());
    }

    public static Object P(Map.Entry r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getKey();
    }

    public static List Q(List r5, Object r10) {
        if ((r5 instanceof RandomAccess) == false) goto L6;
        return new Synchronized$SynchronizedRandomAccessList(r5, r10);
    L6:
        return new Synchronized$SynchronizedList(r5, r10);
    }

    public static p1 R(Spliterator r5, Function r10) {
        r5.getClass();
        return new p1(r5, r10);
    }

    public static int S(int r5, int r10, int r11) {
        return (r5 & (~r11)) | (r10 & r11);
    }

    public static ArrayList T() {
        return new ArrayList();
    }

    public static ArrayList U(Iterable r5) {
        r5.getClass();
        if ((r5 instanceof Collection) == false) goto L6;
        return new ArrayList((Collection) r5);
    L6:
        return V(r5.iterator());
    }

    public static ArrayList V(Iterator r5) {
        ArrayList r10 = new ArrayList();
        j(r10, r5);
        return r10;
    }

    public static int W(int r5) {
        if (r5 >= 32) goto L5;
        int r10 = 4;
    L7:
        return (r5 + 1) * r10;
    L5:
        r10 = 2;
        goto L7
    }

    public static HashMap X(int r5) {
        return new HashMap(n(r5));
    }

    public static HashSet Y(int r5) {
        return new HashSet(n(r5));
    }

    public static LinkedHashMap Z() {
        return new LinkedHashMap();
    }

    public static Collection a(Collection r5) {
        if ((r5 instanceof SortedSet) == false) goto L6;
        return Collections.unmodifiableSortedSet((SortedSet) r5);
    L6:
        if ((r5 instanceof Set) == false) goto L9;
        return Collections.unmodifiableSet((Set) r5);
    L9:
        if ((r5 instanceof List) == false) goto L12;
        return Collections.unmodifiableList((List) r5);
    L12:
        return Collections.unmodifiableCollection(r5);
    }

    public static LinkedHashMap a0(int r5) {
        return new LinkedHashMap(n(r5));
    }

    public static Object b(y7 r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getElement();
    }

    public static j5 b0(Iterator r5) {
        if ((r5 instanceof j5) == false) goto L7;
        return (j5) r5;
    L7:
        return new j5(r5);
    }

    public static Set c(Set r5, Object r10) {
        if ((r5 instanceof SortedSet) == false) goto L6;
        return new Synchronized$SynchronizedSortedSet((SortedSet) r5, r10);
    L6:
        return new Synchronized$SynchronizedSet(r5, r10);
    }

    public static Object c0(Iterator r5) {
        if (r5.hasNext() == false) goto L6;
        Object r10 = r5.next();
        r5.remove();
        return r10;
    L6:
        return null;
    }

    public static Collection d(Collection r5, Object r10) {
        if ((r5 instanceof SortedSet) == false) goto L6;
        return new Synchronized$SynchronizedSortedSet((SortedSet) r5, r10);
    L6:
        if ((r5 instanceof Set) == false) goto L9;
        return new Synchronized$SynchronizedSet((Set) r5, r10);
    L9:
        if ((r5 instanceof List) == false) goto L12;
        return Q((List) r5, r10);
    L12:
        return new Synchronized$SynchronizedCollection(r5, r10, null);
    }

    public static void d0(Map r5, ObjectInputStream r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.put(r10.readObject(), r10.readObject());
        r12 = r12 + 1;
        goto L3
    }

    public static Map.Entry e(Map.Entry r5, Object r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return new Synchronized$SynchronizedEntry(r5, r10);
    }

    public static void e0(q7 r10, ObjectInputStream r11, int r12) {
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L8;
        Collection r13 = r10.get(r11.readObject());
        int r14 = r11.readInt();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L7;
        r13.add(r11.readObject());
        r15 = r15 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    }

    public static e7 f(Map.Entry r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return new e7(r5);
    }

    public static void f0(j0 r5, ObjectInputStream r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5.add(r10.readObject(), r10.readInt());
        r12 = r12 + 1;
        goto L3
    }

    public static int g0(Object r10, Object r11, int r12, Object r13, int[] r14, Object[] r15, Object[] r16) {
        int r5 = o0(r10);
        int r17 = r5 & r12;
        int r18 = p0(r17, r13);
        if (r18 != 0) goto L5;
        return -1;
    L5:
        int r19 = ~r12;
        int r20 = r5 & r19;
        int r21 = -1;
    L6:
        int r22 = r18 - 1;
        int r23 = r14[r22];
        if ((r23 & r19) == r20) goto L9;
    L18:
        int r24 = r23 & r12;
        if (r24 == 0) goto L20;
        r21 = r22;
        r18 = r24;
        goto L6
    L20:
        return -1;
    L9:
        if (com.google.common.base.b0.w(r10, r15[r22]) == false) goto L18;
        if (r16 == null) goto L13;
        if (com.google.common.base.b0.w(r11, r16[r22]) == false) goto L18;
    L13:
        int r25 = r23 & r12;
        if (r21 != (-1)) goto L16;
        q0(r17, r25, r13);
    L17:
        return r22;
    L16:
        r14[r21] = S(r14[r21], r25, r12);
        goto L17
    }

    public static boolean h0(Collection r5, Iterator r10) {
        r5.getClass();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r5.contains(r10.next()) == false) goto L4;
        r10.remove();
        r11 = true;
        goto L4
    L8:
        return r11;
    }

    public static boolean i(Collection r5, Iterable r10) {
        if ((r10 instanceof Collection) == true) goto L5;
        r10.getClass();
        return j(r5, r10.iterator());
    L5:
        return r5.addAll((Collection) r10);
    }

    public static boolean i0(Set r5, Collection r10) {
        r10.getClass();
        if ((r10 instanceof z7) == false) goto L6;
        r10 = ((z7) r10).elementSet();
    L6:
        if ((r10 instanceof Set) == false) goto L12;
        if (r10.size() <= r5.size()) goto L12;
        return h0(r10, r5.iterator());
    L12:
        return j0(r5, r10.iterator());
    }

    public static boolean j(Collection r5, Iterator r10) {
        r5.getClass();
        r10.getClass();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | r5.add(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static boolean j0(Set r5, Iterator r10) {
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | r5.remove(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static boolean k(final z7 r5, Collection r10) {
        r10.getClass();
        if ((r10 instanceof z7) == false) goto L10;
        z7 r11 = (z7) r10;
        if (r11.isEmpty() == true) goto L14;
        r11.forEachEntry(new a8(r5));
        return true;
    L14:
        return false;
    L10:
        if (r10.isEmpty() == false) goto L13;
        return false;
    L13:
        return j(r5, r10.iterator());
    }

    public static boolean k0(Map r5, Object r10) {
        r5.getClass();
        return r5.containsKey(r10);
    L5:
        return false;
    }

    public static int l(List r10, com.google.common.base.q r11, Comparable r12, SortedLists$KeyPresentBehavior r13, SortedLists$KeyAbsentBehavior r14) {
        r12.getClass();
        return m(r10, r11, r12, g8.natural(), r13, r14);
    }

    public static Object l0(Map r5, Object r10) {
        r5.getClass();
        return r5.get(r10);
    L5:
        return null;
    }

    public static int m(List r5, com.google.common.base.q r10, Object r11, g8 r12, SortedLists$KeyPresentBehavior r13, SortedLists$KeyAbsentBehavior r14) {
        if ((r5 instanceof RandomAccess) == false) goto L5;
        List r15 = new Lists$TransformingRandomAccessList(r5, r10);
    L6:
        r12.getClass();
        r13.getClass();
        r14.getClass();
        if ((r15 instanceof RandomAccess) == true) goto L9;
        r15 = U(r15);
    L9:
        int r16 = r15.size() - 1;
        int r17 = 0;
    L10:
        if (r17 > r16) goto L18;
        int r18 = (r17 + r16) >>> 1;
        int r19 = r12.compare(r11, r15.get(r18));
        if (r19 < 0) goto L13;
        if (r19 <= 0) goto L26;
        r17 = r18 + 1;
        goto L10
    L26:
        return r17 + r13.resultIndex(r12, r11, r15.subList(r17, r16 + 1), r18 - r17);
    L13:
        r16 = r18 - 1;
        goto L10
    L18:
        return r14.resultIndex(r17);
    L5:
        r15 = new Lists$TransformingSequentialList(r5, r10);
        goto L6
    }

    public static int m0(Iterator r5) {
        long r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r5.next();
        r10 = r10 + 1;
        goto L4
    L7:
        return dn.a.U(r10);
    }

    public static int n(int r5) {
        if (r5 >= 3) goto L7;
        q(r5, "expectedSize");
        return r5 + 1;
    L7:
        if (r5 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) ((r5 / 0.75f) + 1.0f);
    }

    public static int n0(int r5) {
        return (int) (((long) Integer.rotateLeft((int) (((long) r5) * (-862048943)), 15)) * 461845907);
    }

    public static void o(int r5, Object[] r10) {
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L9;
        if (r10[r11] == null) goto L8;
        r11 = r11 + 1;
        goto L3
    L8:
        throw new NullPointerException(androidx.constraintlayout.motion.widget.a.i(20, "at index ", r11));
    }

    public static int o0(Object r5) {
        if (r5 != null) goto L4;
        int r10 = 0;
    L6:
        return n0(r10);
    L4:
        r10 = r5.hashCode();
        goto L6
    }

    public static void p(Object r5, Object r10) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L5;
        return;
    L5:
        String r11 = String.valueOf(r5);
        throw new NullPointerException(androidx.room.jarjarred.org.antlr.runtime.a.m(r11.length() + 26, "null value in entry: ", r11, "=null"));
    L7:
        String r12 = String.valueOf(r10);
        throw new NullPointerException(androidx.room.jarjarred.org.antlr.runtime.a.l(r12.length() + 24, "null key in entry: null=", r12));
    }

    public static int p0(int r5, Object r10) {
        if ((r10 instanceof byte[]) == false) goto L7;
        return ((byte[]) r10)[r5] & UByte.MAX_VALUE;
    L7:
        if ((r10 instanceof short[]) == false) goto L11;
        return ((short[]) r10)[r5] & UShort.MAX_VALUE;
    L11:
        return ((int[]) r10)[r5];
    }

    public static void q(int r5, String r10) {
        if (r5 < 0) goto L4;
        return;
    L4:
        StringBuilder r11 = new StringBuilder(r10.length() + 40);
        r11.append(r10);
        r11.append(" cannot be negative but was: ");
        r11.append(r5);
        throw new IllegalArgumentException(r11.toString());
    }

    public static void q0(int r5, int r10, Object r11) {
        if ((r11 instanceof byte[]) == false) goto L6;
        ((byte[]) r11)[r5] = (byte) r10;
        return;
    L6:
        if ((r11 instanceof short[]) == false) goto L8;
        ((short[]) r11)[r5] = (short) r10;
        return;
    L8:
        ((int[]) r11)[r5] = r10;
    }

    public static void r(long r5) {
        if (r5 < 0) goto L5;
        return;
    L5:
        StringBuilder r10 = new StringBuilder("distance".length() + 49);
        r10.append("distance cannot be negative but was: ");
        r10.append(r5);
        throw new IllegalArgumentException(r10.toString());
    }

    public static int r0(int r5) {
        return Math.max(4, v(1.0d, r5 + 1));
    }

    public static void s(int r5) {
        if (r5 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.i("occurrences".length() + 38, "occurrences must be positive but was: ", r5));
    }

    public static Object[] s0(Collection r5, Object[] r10) {
        int r11 = r5.size();
        if (r10.length >= r11) goto L5;
        int r12 = h8.f9015a;
        r10 = (Object[]) Array.newInstance(r10.getClass().getComponentType(), r11);
    L5:
        C(r5, r10);
        if (r10.length <= r11) goto L8;
        r10[r11] = null;
    L8:
        return r10;
    }

    public static void t(boolean r5) {
        com.google.common.base.b0.u(r5, "no calls to next() since the last call to remove()");
    }

    public static Object[] t0(Object[] r5, int r10, Object[] r11) {
        com.google.common.base.b0.p(0, r10, r5.length);
        if (r11.length >= r10) goto L6;
        int r12 = h8.f9015a;
        r11 = (Object[]) Array.newInstance(r11.getClass().getComponentType(), r10);
    L8:
        System.arraycopy(r5, 0, r11, 0, r10);
        return r11;
    L6:
        if (r11.length <= r10) goto L8;
        r11[r10] = null;
        goto L8
    }

    public static void u(Iterator r5) {
        r5.getClass();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next();
        r5.remove();
        goto L4
    }

    public static String u0(Iterable r5) {
        Iterator r10 = r5.iterator();
        StringBuilder r11 = new StringBuilder("[");
        boolean r12 = true;
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r12 == true) goto L7;
        r11.append(", ");
    L7:
        r11.append(r10.next());
        r12 = false;
        goto L4
    L8:
        r11.append(']');
        return r11.toString();
    }

    public static int v(double r5, int r10) {
        int r11 = Math.max(r10, 2);
        int r12 = Integer.highestOneBit(r11);
        if (r11 <= ((int) (r5 * ((double) r12)))) goto L9;
        int r13 = r12 << 1;
        if (r13 > 0) goto L10;
        return BasicMeasure.EXACTLY;
    L10:
        return r13;
    L9:
        return r12;
    }

    public static String v0(Map r10) {
        int r5 = r10.size();
        q(r5, "size");
        StringBuilder r11 = new StringBuilder((int) Math.min(((long) r5) * 8, 1073741824));
        r11.append('{');
        Iterator r12 = r10.entrySet().iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r12.next();
        if (r13 == true) goto L8;
        r11.append(", ");
    L8:
        r11.append(r14.getKey());
        r11.append('=');
        r11.append(r14.getValue());
        r13 = false;
        goto L4
    L9:
        r11.append('}');
        return r11.toString();
    }

    public static boolean w(Iterator r5, Object r10) {
        if (r10 != null) goto L10;
    L5:
        if (r5.hasNext() == false) goto L14;
        if (r5.next() != null) goto L5;
        return true;
    L14:
        return false;
    L10:
        if (r5.hasNext() == false) goto L22;
        if (r10.equals(r5.next()) == false) goto L10;
        return true;
    L22:
        return false;
    }

    public static ga w0(Iterator r5) {
        r5.getClass();
        if ((r5 instanceof ga) == false) goto L7;
        return (ga) r5;
    L7:
        return new d5(r5, 0);
    }

    public static boolean x(Collection r5, Collection r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r5.contains(r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static NavigableSet x0(NavigableSet r5) {
        if ((r5 instanceof ImmutableCollection) == false) goto L5;
    L9:
        return r5;
    L5:
        if ((r5 instanceof Sets$UnmodifiableNavigableSet) == true) goto L9;
        return new Sets$UnmodifiableNavigableSet(r5);
    }

    public static Object y(int r5) {
        if (r5 < 2) goto L19;
        if (r5 > 1073741824) goto L19;
        if (Integer.highestOneBit(r5) != r5) goto L19;
        if (r5 > 256) goto L13;
        return new byte[r5];
    L13:
        if (r5 > 65536) goto L17;
        return new short[r5];
    L17:
        return new int[r5];
    L19:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.i(52, "must be power of 2 between 2^1 and 2^30: ", r5));
    }

    public static void y0(Map r5, ObjectOutputStream r10) {
        r10.writeInt(r5.size());
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.writeObject(r12.getKey());
        r10.writeObject(r12.getValue());
        goto L4
    }

    public static boolean z(z7 r5, Object r10) {
        if (r10 != r5) goto L6;
        return true;
    L6:
        if ((r10 instanceof z7) == false) goto L19;
        z7 r11 = (z7) r10;
        if (r5.size() != r11.size()) goto L19;
        if (r5.entrySet().size() != r11.entrySet().size()) goto L19;
        Iterator r12 = r11.entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L18;
        y7 r13 = (y7) r12.next();
        if (r5.count(r13.getElement()) == r13.getCount()) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    public static void z0(g0 r5, ObjectOutputStream r10) {
        r10.writeInt(r5.asMap().size());
        Iterator r11 = r5.asMap().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.writeObject(r12.getKey());
        r10.writeInt(((Collection) r12.getValue()).size());
        Iterator r13 = ((Collection) r12.getValue()).iterator();
    L7:
        if (r13.hasNext() == false) goto L4;
        r10.writeObject(r13.next());
        goto L7
    }

    public abstract p7 g(Object r5);

    public void h(Iterator r5) {
    L3:
        if (r5.hasNext() == false) goto L5;
        g(r5.next());
        goto L3
    }
}
