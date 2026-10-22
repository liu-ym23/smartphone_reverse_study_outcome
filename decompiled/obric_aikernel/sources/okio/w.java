package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends AbstractList<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f12269h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteString[] f12270c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f12271g;

    @SourceDebugExtension({"SMAP\nOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Options.kt\nokio/Options$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,236:1\n11065#2:237\n11400#2,3:238\n13374#2,3:243\n37#3,2:241\n1#4:246\n74#5:247\n74#5:248\n*S KotlinDebug\n*F\n+ 1 Options.kt\nokio/Options$Companion\n*L\n43#1:237\n43#1:238,3\n44#1:243,3\n43#1:241,2\n151#1:247\n208#1:248\n*E\n"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final void a(long r20, d r22, int r23, List<? extends ByteString> r24, int r25, int r26, List<Integer> r27) {
            int r11 = r23;
            if (r25 >= r26) goto L5;
            boolean r10 = true;
        L7:
            if (r10 == false) goto L75;
            int r12 = r25;
        L9:
            if (r12 >= r26) goto L18;
            if (r24.get(r12).size() < r11) goto L13;
            boolean r13 = true;
        L14:
            if (r13 == false) goto L17;
            r12 = r12 + 1;
            goto L9
        L17:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L13:
            r13 = false;
            goto L14
        L18:
            ByteString r14 = r24.get(r25);
            ByteString r15 = r24.get(r26 - 1);
            int r16 = -1;
            if (r11 != r14.size()) goto L21;
            int r17 = r27.get(r25).intValue();
            int r18 = r25 + 1;
            ByteString r19 = r24.get(r18);
            int r21 = r18;
            int r28 = r17;
            r14 = r19;
        L23:
            if (r14.getByte(r11) == r15.getByte(r11)) goto L54;
            int r29 = r21 + 1;
            int r30 = 1;
        L25:
            if (r29 >= r26) goto L30;
            if (r24.get(r29 - 1).getByte(r11) == r24.get(r29).getByte(r11)) goto L29;
            r30 = r30 + 1;
        L29:
            r29 = r29 + 1;
            goto L25
        L30:
            long r110 = ((r20 + c(r22)) + ((long) 2)) + ((long) (r30 * 2));
            r22.f0(r30);
            r22.f0(r28);
            int r31 = r21;
        L31:
            if (r31 >= r26) goto L38;
            byte r32 = r24.get(r31).getByte(r11);
            if (r31 != r21) goto L35;
        L36:
            r22.f0(r32 & 255);
        L37:
            r31 = r31 + 1;
            goto L31
        L35:
            if (r32 == r24.get(r31 - 1).getByte(r11)) goto L37;
        L38:
            d r33 = new d();
        L39:
            if (r21 >= r26) goto L53;
            byte r34 = r24.get(r21).getByte(r11);
            int r35 = r21 + 1;
            int r36 = r35;
        L41:
            if (r36 >= r26) goto L46;
            if (r34 != r24.get(r36).getByte(r11)) goto L44;
            r36 = r36 + 1;
            goto L41
        L44:
            int r37 = r36;
        L47:
            if (r35 == r37) goto L49;
        L51:
            r22.f0(((int) (r110 + c(r33))) * r16);
            a(r110, r33, r11 + 1, r24, r21, r37, r27);
        L52:
            r33 = r33;
            r21 = r37;
            r16 = -1;
            goto L39
        L49:
            if ((r11 + 1) != r24.get(r21).size()) goto L51;
            r22.f0(r27.get(r21).intValue());
            goto L52
        L46:
            r37 = r26;
            goto L47
        L53:
            r22.y(r33);
            return;
        L54:
            int r38 = Math.min(r14.size(), r15.size());
            int r39 = r11;
            int r111 = 0;
        L55:
            if (r39 >= r38) goto L59;
            if (r14.getByte(r39) != r15.getByte(r39)) goto L59;
            r111 = r111 + 1;
            r39 = r39 + 1;
        L59:
            long r40 = (((r20 + c(r22)) + ((long) 2)) + ((long) r111)) + 1;
            r22.f0(-r111);
            r22.f0(r28);
            int r41 = r11 + r111;
        L60:
            if (r11 >= r41) goto L63;
            r22.f0(r14.getByte(r11) & 255);
            r11 = r11 + 1;
            goto L60
        L63:
            if ((r21 + 1) == r26) goto L65;
            d r112 = new d();
            r22.f0(((int) (c(r112) + r40)) * (-1));
            a(r40, r112, r41, r24, r21, r26, r27);
            r22.y(r112);
            return;
        L65:
            if (r41 != r24.get(r21).size()) goto L67;
            boolean r42 = true;
        L68:
            if (r42 == false) goto L71;
            r22.f0(r27.get(r21).intValue());
            return;
        L71:
            throw new IllegalStateException("Check failed.".toString());
        L67:
            r42 = false;
            goto L68
        L21:
            r21 = r25;
            r28 = -1;
            goto L23
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r10 = false;
            goto L7
        }

        static /* synthetic */ void b(a r11, long r12, d r14, int r15, List r16, int r17, int r18, List r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            long r10 = 0;
        L7:
            if ((r20 & 4) == 0) goto L9;
            int r13 = 0;
        L11:
            if ((r20 & 16) == 0) goto L13;
            int r22 = 0;
        L15:
            if ((r20 & 32) == 0) goto L17;
            int r23 = r16.size();
        L18:
            r11.a(r10, r14, r13, r16, r22, r23, r19);
            return;
        L17:
            r23 = r18;
            goto L18
        L13:
            r22 = r17;
            goto L15
        L9:
            r13 = r15;
            goto L11
        L5:
            r10 = r12;
            goto L7
        }

        private final long c(d r10) {
            return r10.M() / ((long) 4);
        }

        @JvmStatic
        public final w d(ByteString... r17) {
            Intrinsics.checkNotNullParameter(r17, "byteStrings");
            int r10 = 0;
            if (r17.length != 0) goto L5;
            boolean r11 = true;
        L6:
            DefaultConstructorMarker r12 = null;
            if (r11 == true) goto L9;
            List r13 = ArraysKt.toMutableList(r17);
            CollectionsKt.sort(r13);
            ArrayList r14 = new ArrayList(r17.length);
            int r15 = r17.length;
            int r16 = 0;
        L11:
            if (r16 >= r15) goto L13;
            ByteString r18 = r17[r16];
            r14.add(-1);
            r16 = r16 + 1;
            goto L11
        L13:
            Integer[] r19 = (Integer[]) r14.toArray(new Integer[0]);
            List r110 = CollectionsKt.mutableListOf(Arrays.copyOf(r19, r19.length));
            int r111 = r17.length;
            int r112 = 0;
            int r113 = 0;
        L14:
            if (r112 >= r111) goto L17;
            r110.set(CollectionsKt.binarySearch$default(r13, r17[r112], 0, 0, 6, null), Integer.valueOf(r113));
            r112 = r112 + 1;
            r113 = r113 + 1;
            goto L14
        L17:
            if (((ByteString) r13.get(0)).size() <= 0) goto L19;
            boolean r20 = true;
        L20:
            if (r20 == false) goto L48;
            int r21 = 0;
        L23:
            if (r21 >= r13.size()) goto L41;
            ByteString r22 = (ByteString) r13.get(r21);
            int r23 = r21 + 1;
            int r24 = r23;
        L26:
            if (r24 >= r13.size()) goto L40;
            ByteString r25 = (ByteString) r13.get(r24);
            if (r25.startsWith(r22) == false) goto L40;
            if (r25.size() == r22.size()) goto L32;
            boolean r114 = true;
        L33:
            if (r114 == false) goto L39;
            if (((Number) r110.get(r24)).intValue() > ((Number) r110.get(r21)).intValue()) goto L36;
            r24 = r24 + 1;
            goto L26
        L36:
            r13.remove(r24);
            r110.remove(r24);
            goto L26
        L39:
            throw new IllegalArgumentException(("duplicate option: " + r25).toString());
        L32:
            r114 = false;
        L40:
            r21 = r23;
            goto L23
        L41:
            d r26 = new d();
            b(this, 0, r26, 0, r13, 0, 0, r110, 53, null);
            int[] r27 = new int[(int) c(r26)];
        L43:
            if (r26.n() == true) goto L45;
            r27[r10] = r26.readInt();
            r10 = r10 + 1;
            goto L43
        L45:
            Object[] r28 = Arrays.copyOf(r17, r17.length);
            Intrinsics.checkNotNullExpressionValue(r28, "copyOf(this, size)");
            return new w((ByteString[]) r28, r27, r12);
        L48:
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        L19:
            r20 = false;
            goto L20
        L9:
            return new w(new ByteString[0], new int[]{0, -1}, r12);
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        f12269h = new a(null);
    }

    private w(ByteString[] r10, int[] r11) {
        this.f12270c = r10;
        this.f12271g = r11;
    }

    public /* synthetic */ w(ByteString[] r10, int[] r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public /* bridge */ boolean a(ByteString r10) {
        return super.contains(r10);
    }

    public ByteString b(int r10) {
        return this.f12270c[r10];
    }

    public final ByteString[] c() {
        return this.f12270c;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof ByteString) == true) goto L7;
        return false;
    L7:
        return a((ByteString) r10);
    }

    public final int[] d() {
        return this.f12271g;
    }

    public /* bridge */ int e(ByteString r10) {
        return super.indexOf(r10);
    }

    public /* bridge */ int f(ByteString r10) {
        return super.lastIndexOf(r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return b(r10);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f12270c.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof ByteString) == true) goto L7;
        return -1;
    L7:
        return e((ByteString) r10);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof ByteString) == true) goto L7;
        return -1;
    L7:
        return f((ByteString) r10);
    }
}
