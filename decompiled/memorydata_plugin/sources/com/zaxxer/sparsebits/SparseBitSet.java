package com.zaxxer.sparsebits;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class SparseBitSet implements Serializable, Cloneable {
    protected static final int INDEX_SIZE = 31;
    protected static final int LENGTH2 = 32;
    protected static final int LENGTH3 = 32;
    protected static final int LENGTH4 = 64;
    protected static final int LEVEL1 = 15;
    protected static final int LEVEL2 = 5;
    protected static final int LEVEL3 = 5;
    protected static final int LEVEL4 = 6;
    protected static final int MASK2 = 31;
    protected static final int MASK3 = 31;
    protected static final int MAX_LENGTH1 = 32768;
    protected static final int SHIFT1 = 10;
    protected static final int SHIFT2 = 5;
    protected static final int SHIFT3 = 6;
    protected static final int UNIT = 65536;
    static final long[] ZERO_BLOCK = null;
    protected static final transient b andNotStrategy = null;
    protected static final transient c andStrategy = null;
    protected static final transient e clearStrategy = null;
    static int compactionCountDefault = 2;
    protected static final transient f copyStrategy = null;
    protected static final transient h flipStrategy = null;
    protected static transient i intersectsStrategy = null;
    protected static final transient j orStrategy = null;
    private static final long serialVersionUID = -6663013367427929992L;
    protected static final transient k setStrategy = null;
    protected static final transient m xorStrategy = null;
    protected transient long[][][] bits;
    protected transient int bitsLength;
    protected transient d cache;
    protected transient int compactionCount;
    protected transient g equalsStrategy;
    protected transient long[] spare;
    protected transient l updateStrategy;

    public static final enum Statistics extends Enum<Statistics> {
        private static final /* synthetic */ Statistics[] $VALUES = null;
        public static final Statistics Cardinality = null;
        public static final Statistics Compaction_count_value = null;
        public static final Statistics Length = null;
        public static final Statistics Level2_area_length = null;
        public static final Statistics Level2_areas = null;
        public static final Statistics Level3_block_length = null;
        public static final Statistics Level3_blocks = null;
        public static final Statistics Set_array_length = null;
        public static final Statistics Set_array_max_length = null;
        public static final Statistics Size = null;
        public static final Statistics Total_words = null;

        static {
            Statistics r0 = new Statistics("Size", 0);
            Size = r0;
            Statistics r1 = new Statistics("Length", 1);
            Length = r1;
            Statistics r3 = new Statistics("Cardinality", 2);
            Cardinality = r3;
            Statistics r5 = new Statistics("Total_words", 3);
            Total_words = r5;
            Statistics r7 = new Statistics("Set_array_length", 4);
            Set_array_length = r7;
            Statistics r9 = new Statistics("Set_array_max_length", 5);
            Set_array_max_length = r9;
            Statistics r11 = new Statistics("Level2_areas", 6);
            Level2_areas = r11;
            Statistics r13 = new Statistics("Level2_area_length", 7);
            Level2_area_length = r13;
            Statistics r15 = new Statistics("Level3_blocks", 8);
            Level3_blocks = r15;
            Statistics r14 = new Statistics("Level3_block_length", 9);
            Level3_block_length = r14;
            Statistics r12 = new Statistics("Compaction_count_value", 10);
            Compaction_count_value = r12;
            $VALUES = new Statistics[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        private Statistics(String r1, int r2) {
            super(r1, r2);
        }

        public static Statistics valueOf(String r2) {
            return (Statistics) ZeusTransformUtils.preCheckCast(Enum.valueOf(Statistics.class, r2), Statistics.class, "com.obric.memorydata.plugin");
        }

        public static Statistics[] values() {
            return (Statistics[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Statistics[].class, "com.obric.memorydata.plugin");
        }
    }

    protected static abstract class a {
        public a() {
        }

        public abstract int a();

        public void a(int r1, int r2) {
        }

        public abstract boolean a(int r1, int r2, int r3, long[] r4, long[] r5);

        public abstract boolean a(int r1, int r2, long[] r3, long[] r4, long r5);

        public abstract boolean a(SparseBitSet r1);

        public final boolean a(long[] r7) {
            int r6 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L8;
            if (r7[r1] != 0) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }
    }

    protected static class b extends a {
        public b() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 11;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = r8[r6] & (~r9[r6]);
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r1 = true;
        L8:
            r10 = r10 & r1;
            r6 = r6 + 1;
            goto L3
        L7:
            r1 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r3, int r4, long[] r5, long[] r6, long r7) {
            long r2 = r5[r4] & (~(r6[r4] & r7));
            r5[r4] = r2;
            if (r2 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            return true;
        }
    }

    protected static class c extends a {
        public c() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 7;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = r8[r6] & r9[r6];
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r1 = true;
        L8:
            r10 = r10 & r1;
            r6 = r6 + 1;
            goto L3
        L7:
            r1 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r3, int r4, long[] r5, long[] r6, long r7) {
            long r2 = r5[r4];
            long r0 = r6[r4];
            long r8 = r2 & ((~r7) | r0);
            r5[r4] = r8;
            if (r8 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            return true;
        }
    }

    protected class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected transient int f16359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected transient int f16360b;
        protected transient int c;
        protected transient int d;
        protected transient int e;
        protected transient int f;
        protected transient int g;
        final /* synthetic */ SparseBitSet h;

        public d(SparseBitSet r1) {
            this.h = r1;
        }
    }

    protected static class e extends a {
        public e() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 3;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, int r3, long[] r4, long[] r5) {
            if (r2 != 0) goto L5;
            if (r3 != 32) goto L5;
            return true;
        L5:
            if (r2 == r3) goto L11;
            r4[r2] = 0;
            r2 = r2 + 1;
            goto L5
        L11:
            return true;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, long[] r3, long[] r4, long r5) {
            long r0 = r3[r2] & (~r5);
            r3[r2] = r0;
            if (r0 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            return true;
        }
    }

    protected static class f extends a {
        public f() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 5;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = r9[r6];
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r1 = true;
        L8:
            r10 = r10 & r1;
            r6 = r6 + 1;
            goto L3
        L7:
            r1 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, long[] r3, long[] r4, long r5) {
            long r0 = r4[r2] & r5;
            r3[r2] = r0;
            if (r0 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            return true;
        }
    }

    protected static class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f16361a;

        public g() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 1;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r7, int r8, int r9, long[] r10, long[] r11) {
            boolean r0 = true;
        L3:
            if (r8 == r9) goto L12;
            long r1 = r10[r8];
            boolean r3 = this.f16361a;
            boolean r5 = false;
            if (r1 != r11[r8]) goto L7;
            boolean r4 = true;
        L8:
            this.f16361a = r3 & r4;
            if (r1 != 0) goto L11;
            r5 = true;
        L11:
            r0 = r0 & r5;
            r8 = r8 + 1;
            goto L3
        L7:
            r4 = false;
            goto L8
        L12:
            return r0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, long[] r7, long[] r8, long r9) {
            long r0 = r7[r6];
            boolean r10 = this.f16361a;
            if ((r0 & r9) != (r8[r6] & r9)) goto L5;
            boolean r11 = true;
        L6:
            this.f16361a = r10 & r11;
            if (r0 != 0) goto L10;
            return true;
        L10:
            return false;
        L5:
            r11 = false;
            goto L6
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            this.f16361a = true;
            return false;
        }
    }

    protected static class h extends a {
        public h() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = ~r8[r6];
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r11 = true;
        L8:
            r10 = r10 & r11;
            r6 = r6 + 1;
            goto L3
        L7:
            r11 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, long[] r3, long[] r4, long r5) {
            long r0 = r3[r2] ^ r5;
            r3[r2] = r0;
            if (r0 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            return true;
        }
    }

    protected static class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f16362a;

        public i() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 3;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r9, int r10, int r11, long[] r12, long[] r13) {
            boolean r0 = true;
        L3:
            if (r10 == r11) goto L12;
            long r1 = r12[r10];
            boolean r3 = this.f16362a;
            boolean r5 = false;
            if ((r13[r10] & r1) == 0) goto L7;
            boolean r4 = true;
        L8:
            this.f16362a = r3 | r4;
            if (r1 != 0) goto L11;
            r5 = true;
        L11:
            r0 = r0 & r5;
            r10 = r10 + 1;
            goto L3
        L7:
            r4 = false;
            goto L8
        L12:
            return r0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r3, int r4, long[] r5, long[] r6, long r7) {
            long r0 = r5[r4];
            boolean r8 = this.f16362a;
            if (((r6[r4] & r0) & r7) == 0) goto L5;
            boolean r9 = true;
        L6:
            this.f16362a = r8 | r9;
            if (r0 != 0) goto L10;
            return true;
        L10:
            return false;
        L5:
            r9 = false;
            goto L6
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            this.f16362a = false;
            return false;
        }
    }

    protected static class j extends a {
        public j() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 9;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = r8[r6] | r9[r6];
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r1 = true;
        L8:
            r10 = r10 & r1;
            r6 = r6 + 1;
            goto L3
        L7:
            r1 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r3, int r4, long[] r5, long[] r6, long r7) {
            long r2 = r5[r4] | (r6[r4] & r7);
            r5[r4] = r2;
            if (r2 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            return true;
        }
    }

    protected static class k extends a {
        public k() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 0;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, int r3, long[] r4, long[] r5) {
        L2:
            if (r2 == r3) goto L4;
            r4[r2] = -1;
            r2 = r2 + 1;
            goto L2
        L4:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r1, int r2, long[] r3, long[] r4, long r5) {
            r3[r2] = r3[r2] | r5;
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            return true;
        }
    }

    protected class l extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected transient int f16363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected transient long f16364b;
        protected transient int c;
        protected transient long d;
        protected transient long e;
        protected transient int f;
        protected transient int g;
        final /* synthetic */ SparseBitSet h;

        public l(SparseBitSet r1) {
            this.h = r1;
        }

        private void a(int r5, long r6) {
            this.f++;
            this.e ^= ((long) (r5 + 1)) * r6;
            if (this.f16363a >= 0) goto L5;
            this.f16363a = r5;
            this.f16364b = r6;
        L5:
            this.c = r5;
            this.d = r6;
            this.g += Long.bitCount(r6);
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 3;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public void a(int r5, int r6) {
            this.h.cache.f = r5;
            this.h.cache.g = r6;
            d r7 = this.h.cache;
            r7.e = this.f;
            d r8 = this.h.cache;
            r8.c = this.g;
            d r9 = this.h.cache;
            r9.d = ((this.c + 1) * 64) - Long.numberOfLeadingZeros(this.d);
            d r10 = this.h.cache;
            r10.f16360b = (this.h.cache.d - (this.f16363a * 64)) - Long.numberOfTrailingZeros(this.f16364b);
            d r11 = this.h.cache;
            long r0 = this.e;
            r11.f16359a = (int) (r0 ^ (r0 >> 32));
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r6, int r7, int r8, long[] r9, long[] r10) {
            boolean r11 = true;
            int r0 = 0;
        L3:
            if (r0 == r8) goto L8;
            long r1 = r9[r0];
            if (r1 == 0) goto L7;
            a(r6 + r0, r1);
            r11 = false;
        L7:
            r0 = r0 + 1;
            goto L3
        L8:
            return r11;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r4, int r5, long[] r6, long[] r7, long r8) {
            long r9 = r6[r5];
            long r10 = r8 & r9;
            if (r10 == 0) goto L6;
            a(r4 + r5, r10);
        L6:
            if (r9 != 0) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r3) {
            this.e = 1234;
            this.f16363a = -1;
            this.f16364b = 0;
            this.c = 0;
            this.d = 0;
            this.f = 0;
            this.g = 0;
            return false;
        }
    }

    protected static class m extends a {
        public m() {
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public int a() {
            return 9;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r5, int r6, int r7, long[] r8, long[] r9) {
            boolean r10 = true;
        L3:
            if (r6 == r7) goto L9;
            long r0 = r8[r6] ^ r9[r6];
            r8[r6] = r0;
            if (r0 != 0) goto L7;
            boolean r1 = true;
        L8:
            r10 = r10 & r1;
            r6 = r6 + 1;
            goto L3
        L7:
            r1 = false;
            goto L8
        L9:
            return r10;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(int r3, int r4, long[] r5, long[] r6, long r7) {
            long r2 = r5[r4] ^ (r6[r4] & r7);
            r5[r4] = r2;
            if (r2 != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.zaxxer.sparsebits.SparseBitSet.a
        public boolean a(SparseBitSet r1) {
            Objects.requireNonNull(r1);
            return true;
        }
    }

    static {
        ZERO_BLOCK = new long[32];
        andStrategy = new c();
        andNotStrategy = new b();
        clearStrategy = new e();
        copyStrategy = new f();
        flipStrategy = new h();
        intersectsStrategy = new i();
        orStrategy = new j();
        setStrategy = new k();
        xorStrategy = new m();
    }

    public SparseBitSet() {
        this(1, compactionCountDefault);
    }

    public SparseBitSet(int r2) {
        this(r2, compactionCountDefault);
    }

    public SparseBitSet(int r2, int r3) {
        if (r2 < 0) goto L7;
        resize(r2 - 1);
        this.compactionCount = r3;
        constructorHelper();
        statisticsUpdate();
        return;
    L7:
        throw new NegativeArraySizeException("(requested capacity=" + r2 + ") < 0");
    }

    public static SparseBitSet and(SparseBitSet r0, SparseBitSet r1) {
        SparseBitSet r2 = r0.clone();
        r2.and(r1);
        return r2;
    }

    public static SparseBitSet andNot(SparseBitSet r0, SparseBitSet r1) {
        SparseBitSet r2 = r0.clone();
        r2.andNot(r1);
        return r2;
    }

    public static SparseBitSet or(SparseBitSet r0, SparseBitSet r1) {
        SparseBitSet r2 = r0.clone();
        r2.or(r1);
        return r2;
    }

    private void readObject(ObjectInputStream r11) {
        r11.defaultReadObject();
        this.compactionCount = r11.readInt();
        resize(r11.readInt());
        int r0 = r11.readInt();
        int r1 = 0;
    L3:
        if (r1 == r0) goto L11;
        int r2 = r11.readInt();
        int r3 = r2 & 31;
        int r4 = (r2 >> 5) & 31;
        int r5 = r2 >> 10;
        long r6 = r11.readLong();
        long[][][] r7 = this.bits;
        long[][] r8 = r7[r5];
        if (r8 != null) goto L7;
        r8 = new long[32][];
        r7[r5] = r8;
    L7:
        long[] r9 = r8[r4];
        if (r9 != null) goto L10;
        r9 = new long[32];
        r8[r4] = r9;
    L10:
        r9[r3] = r6;
        r1 = r1 + 1;
        goto L3
    L11:
        constructorHelper();
        statisticsUpdate();
        if (r0 != this.cache.e) goto L19;
        if (r11.readInt() != this.cache.f16359a) goto L17;
        return;
    L17:
        throw new IOException("deserialized hashCode mis-match");
    L19:
        throw new InternalError("count of entries not consistent");
    }

    public static void throwIndexOutOfBoundsException(int r7, int r8) {
        String r2 = "";
        if (r7 >= 0) goto L5;
        String r3 = "(i=" + r7 + ") < 0";
    L7:
        if (r7 != Integer.MAX_VALUE) goto L10;
        r3 = r3 + "(i=" + r7 + ")";
    L10:
        if (r8 >= 0) goto L16;
        StringBuilder r6 = new StringBuilder().append(r3);
        if (r3.isEmpty() == false) goto L14;
        String r4 = "";
    L15:
        r3 = r6.append(r4).append("(j=").append(r8).append(") < 0").toString();
        goto L16
    L14:
        r4 = ", ";
    L16:
        if (r7 <= r8) goto L23;
        StringBuilder r0 = new StringBuilder().append(r3);
        if (r3.isEmpty() == true) goto L21;
        r2 = ", ";
    L21:
        r3 = r0.append(r2).append("(i=").append(r7).append(") > (j=").append(r8).append(")").toString();
    L23:
        throw new IndexOutOfBoundsException(r3);
    L5:
        r3 = "";
        goto L7
    }

    private void writeObject(ObjectOutputStream r18) {
        statisticsUpdate();
        r18.defaultWriteObject();
        r18.writeInt(this.compactionCount);
        r18.writeInt(this.cache.d);
        int r2 = this.cache.e;
        r18.writeInt(r2);
        long[][][] r3 = this.bits;
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 == r4) goto L19;
        long[][] r7 = r3[r6];
        if (r7 == null) goto L18;
        int r8 = 0;
    L8:
        if (r8 == 32) goto L18;
        long[] r10 = r7[r8];
        if (r10 == null) goto L17;
        int r11 = (r6 << 10) + (r8 << 5);
        int r12 = 0;
    L12:
        if (r12 == 32) goto L17;
        long r13 = r10[r12];
        if (r13 == 0) goto L16;
        r18.writeInt(r11 + r12);
        r18.writeLong(r13);
        r2 = r2 - 1;
    L16:
        r12 = r12 + 1;
    L17:
        r8 = r8 + 1;
    L18:
        r6 = r6 + 1;
        goto L3
    L19:
        if (r2 != 0) goto L23;
        r18.writeInt(this.cache.f16359a);
        return;
    L23:
        throw new InternalError("count of entries not consistent");
    }

    public static SparseBitSet xor(SparseBitSet r0, SparseBitSet r1) {
        SparseBitSet r2 = r0.clone();
        r2.xor(r1);
        return r2;
    }

    public void and(int r2, int r3, SparseBitSet r4) {
        setScanner(r2, r3, r4, andStrategy);
    }

    public void and(int r3, boolean r4) {
        if ((r3 + 1) < 1) goto L8;
        if (r4 == true) goto L9;
        clear(r3);
        return;
    L9:
        return;
    L8:
        throw new IndexOutOfBoundsException("i=" + r3);
    }

    public void and(SparseBitSet r4) {
        nullify(Math.min(this.bits.length, r4.bits.length));
        setScanner(0, Math.min(this.bitsLength, r4.bitsLength), r4, andStrategy);
    }

    public void andNot(int r2, int r3, SparseBitSet r4) {
        setScanner(r2, r3, r4, andNotStrategy);
    }

    public void andNot(int r3, boolean r4) {
        if ((r3 + 1) < 1) goto L8;
        if (r4 == false) goto L9;
        clear(r3);
        return;
    L9:
        return;
    L8:
        throw new IndexOutOfBoundsException("i=" + r3);
    }

    public void andNot(SparseBitSet r4) {
        setScanner(0, Math.min(this.bitsLength, r4.bitsLength), r4, andNotStrategy);
    }

    public int cardinality() {
        statisticsUpdate();
        return this.cache.c;
    }

    public void clear() {
        nullify(0);
    }

    public void clear(int r7) {
        if ((r7 + 1) < 1) goto L16;
        if (r7 < this.bitsLength) goto L7;
        return;
    L7:
        int r0 = r7 >> 6;
        long[][] r1 = this.bits[r0 >> 10];
        if (r1 != null) goto L10;
        return;
    L10:
        long[] r2 = r1[(r0 >> 5) & 31];
        if (r2 != null) goto L13;
        return;
    L13:
        int r3 = r0 & 31;
        r2[r3] = r2[r3] & (~(1 << r7));
        this.cache.f16359a = 0;
        return;
    L16:
        throw new IndexOutOfBoundsException("i=" + r7);
    }

    public void clear(int r3, int r4) {
        setScanner(r3, r4, null, clearStrategy);
    }

    public SparseBitSet clone() {
        SparseBitSet r1 = (SparseBitSet) ZeusTransformUtils.preCheckCast(super.clone(), SparseBitSet.class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.bits = (long[][][]) ZeusTransformUtils.preCheckCast(null, long[][][].class, "com.obric.memorydata.plugin");     // Catch: CloneNotSupportedException -> L5
        r1.resize(1);     // Catch: CloneNotSupportedException -> L5
        r1.constructorHelper();     // Catch: CloneNotSupportedException -> L5
        r1.equalsStrategy = null;     // Catch: CloneNotSupportedException -> L5
        r1.setScanner(0, this.bitsLength, this, copyStrategy);     // Catch: CloneNotSupportedException -> L5
        return r1;
    L5:
        e = move-exception;
        throw new InternalError(e.getMessage());
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1411clone() {
        return clone();
    }

    public final void constructorHelper() {
        this.spare = new long[32];
        this.cache = new d(this);
        this.updateStrategy = new l(this);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SparseBitSet.class) == true) goto L5;
        return false;
    L5:
        SparseBitSet r5 = (SparseBitSet) ZeusTransformUtils.preCheckCast(r4, SparseBitSet.class, "com.obric.memorydata.plugin");
        if (this != r5) goto L10;
        return true;
    L10:
        if (this.equalsStrategy != null) goto L12;
        this.equalsStrategy = new g();
    L12:
        setScanner(0, Math.max(this.bitsLength, r5.bitsLength), r5, this.equalsStrategy);
        return this.equalsStrategy.f16361a;
    }

    public void flip(int r7) {
        if ((r7 + 1) < 1) goto L16;
        int r0 = r7 >> 6;
        int r1 = r0 >> 10;
        int r2 = (r0 >> 5) & 31;
        if (r7 < this.bitsLength) goto L7;
        resize(r7);
    L7:
        long[][][] r3 = this.bits;
        long[][] r4 = r3[r1];
        if (r4 != null) goto L10;
        r4 = new long[32][];
        r3[r1] = r4;
    L10:
        long[] r5 = r4[r2];
        if (r5 != null) goto L13;
        r5 = new long[32];
        r4[r2] = r5;
    L13:
        int r6 = r0 & 31;
        r5[r6] = r5[r6] ^ (1 << r7);
        this.cache.f16359a = 0;
        return;
    L16:
        throw new IndexOutOfBoundsException("i=" + r7);
    }

    public void flip(int r3, int r4) {
        setScanner(r3, r4, null, flipStrategy);
    }

    public SparseBitSet get(int r3, int r4) {
        SparseBitSet r0 = new SparseBitSet(r4, this.compactionCount);
        r0.setScanner(r3, r4, this, copyStrategy);
        return r0;
    }

    public boolean get(int r7) {
        if ((r7 + 1) < 1) goto L16;
        int r0 = r7 >> 6;
        if (r7 >= this.bitsLength) goto L13;
        long[][] r6 = this.bits[r0 >> 10];
        if (r6 == null) goto L13;
        long[] r8 = r6[(r0 >> 5) & 31];
        if (r8 == null) goto L13;
        if (((1 << r7) & r8[r0 & 31]) == 0) goto L13;
        return true;
    L13:
        return false;
    L16:
        throw new IndexOutOfBoundsException("i=" + r7);
    }

    public int hashCode() {
        statisticsUpdate();
        return this.cache.f16359a;
    }

    public boolean intersects(int r2, int r3, SparseBitSet r4) {
        setScanner(r2, r3, r4, intersectsStrategy);
        return intersectsStrategy.f16362a;
    }

    public boolean intersects(SparseBitSet r4) {
        setScanner(0, Math.max(this.bitsLength, r4.bitsLength), r4, intersectsStrategy);
        return intersectsStrategy.f16362a;
    }

    public boolean isEmpty() {
        statisticsUpdate();
        if (this.cache.c != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int length() {
        statisticsUpdate();
        return this.cache.d;
    }

    public int nextClearBit(int r14) {
        if (r14 < 0) goto L34;
        int r0 = r14 >> 6;
        int r1 = r0 & 31;
        int r2 = (r0 >> 5) & 31;
        int r3 = r0 >> 10;
        long r4 = -1;
        long r6 = (-1) << r14;
        long[][][] r15 = this.bits;
        int r8 = r15.length;
        if (r3 >= r8) goto L29;
        long[][] r16 = r15[r3];
        if (r16 == null) goto L29;
        long[] r17 = r16[r2];
        if (r17 == null) goto L29;
        r6 = r6 & (~r17[r1]);
        if (r6 != 0) goto L29;
        int r5 = r0 + 1;
        r3 = r5 >> 10;
        r1 = r5 & 31;
        int r18 = (r5 >> 5) & 31;
    L12:
        if (r3 == r8) goto L28;
        long[][] r7 = this.bits[r3];
        if (r7 == null) goto L28;
    L17:
        if (r18 == 32) goto L27;
        long[] r9 = r7[r18];
        if (r9 == null) goto L28;
    L21:
        if (r1 == 32) goto L26;
        r4 = ~r9[r1];
        if (r4 != 0) goto L28;
        r1 = r1 + 1;
        goto L21
    L26:
        r18 = r18 + 1;
        r1 = 0;
        goto L17
    L27:
        r3 = r3 + 1;
        r18 = 0;
        r1 = 0;
    L28:
        r2 = r18;
        r6 = r4;
    L29:
        int r13 = ((((r3 << 10) + (r2 << 5)) + r1) << 6) + Long.numberOfTrailingZeros(r6);
        if (r13 != Integer.MAX_VALUE) goto L41;
        return -1;
    L41:
        return r13;
    L34:
        throw new IndexOutOfBoundsException("i=" + r14);
    }

    public int nextSetBit(int r14) {
        if (r14 < 0) goto L35;
        int r0 = r14 >> 6;
        int r1 = r0 & 31;
        int r2 = (r0 >> 5) & 31;
        int r3 = r0 >> 10;
        long[][][] r4 = this.bits;
        int r5 = r4.length;
        long r6 = 0;
        if (r3 >= r5) goto L30;
        long[][] r7 = r4[r3];
        if (r7 == null) goto L12;
        long[] r8 = r7[r2];
        if (r8 == null) goto L12;
        long r9 = r8[r1] & ((-1) << r14);
        if (r9 == 0) goto L13;
    L29:
        r6 = r9;
    L13:
        int r10 = r0 + 1;
        r3 = r10 >> 10;
        r1 = r10 & 31;
        int r15 = (r10 >> 5) & 31;
    L14:
        if (r3 == r5) goto L28;
        long[][] r11 = this.bits[r3];
        if (r11 == null) goto L27;
    L18:
        if (r15 == 32) goto L27;
        long[] r12 = r11[r15];
        if (r12 == null) goto L26;
    L21:
        if (r1 == 32) goto L26;
        r9 = r12[r1];
        if (r9 != 0) goto L28;
        r1 = r1 + 1;
    L26:
        r15 = r15 + 1;
        r1 = 0;
    L27:
        r3 = r3 + 1;
        r15 = 0;
        r1 = 0;
    L28:
        r2 = r15;
    L12:
        r9 = 0;
    L30:
        if (r3 < r5) goto L33;
        return -1;
    L33:
        return ((((r3 << 10) + (r2 << 5)) + r1) << 6) + Long.numberOfTrailingZeros(r6);
    L35:
        throw new IndexOutOfBoundsException("i=" + r14);
    }

    public final void nullify(int r6) {
        int r0 = this.bits.length;
        if (r6 >= r0) goto L9;
    L4:
        if (r6 == r0) goto L6;
        this.bits[r6] = (long[][]) ZeusTransformUtils.preCheckCast(null, long[][].class, "com.obric.memorydata.plugin");
        r6 = r6 + 1;
        goto L4
    L6:
        this.cache.f16359a = 0;
        return;
    }

    public void or(int r2, int r3, SparseBitSet r4) {
        setScanner(r2, r3, r4, orStrategy);
    }

    public void or(int r3, boolean r4) {
        if ((r3 + 1) < 1) goto L8;
        if (r4 == false) goto L9;
        set(r3);
        return;
    L9:
        return;
    L8:
        throw new IndexOutOfBoundsException("i=" + r3);
    }

    public void or(SparseBitSet r4) {
        setScanner(0, r4.bitsLength, r4, orStrategy);
    }

    public int previousClearBit(int r21) {
        if (r21 >= 0) goto L8;
        if (r21 != (-1)) goto L7;
        return -1;
    L7:
        throw new IndexOutOfBoundsException("i=" + r21);
    L8:
        long[][][] r2 = this.bits;
        int r4 = r21 >> 6;
        int r5 = r4 & 31;
        int r6 = (r4 >> 5) & 31;
        int r7 = r4 >> 10;
        int r3 = r2.length - 1;
        if (r7 <= r3) goto L11;
        return r21;
    L11:
        int r8 = Math.min(r7, r3);
        int r0 = r21 % 64;
        int r9 = r8;
        int r10 = r5;
        int r11 = r6;
    L12:
        if (r9 < 0) goto L49;
        long[][] r12 = r2[r9];
        if (r12 == null) goto L15;
    L21:
        if (r11 < 0) goto L48;
        long[] r13 = r12[r11];
        if (r13 == null) goto L24;
    L30:
        if (r10 < 0) goto L47;
        long r14 = r13[r10];
        if (r14 == 0) goto L33;
        int r17 = r0;
    L40:
        if (r17 < 0) goto L46;
        if ((r14 & (1 << r17)) == 0) goto L44;
        r17 = r17 - 1;
        goto L40
    L44:
        return ((((r9 << 10) + (r11 << 5)) + r10) << 6) + r17;
    L46:
        r10 = r10 - 1;
        goto L30
    L33:
        int r1 = (((r9 << 10) + (r11 << 5)) + r10) << 6;
        if (r5 == r10) goto L38;
        r0 = 63;
    L38:
        return r1 + r0;
    L47:
        r11 = r11 - 1;
        r10 = 31;
        goto L21
    L24:
        int r15 = (((r9 << 10) + (r11 << 5)) + r10) << 6;
        if (r6 == r11) goto L29;
        r0 = 63;
    L29:
        return r15 + r0;
    L48:
        r9 = r9 - 1;
        r11 = 31;
        r10 = 31;
        goto L12
    L15:
        int r16 = (((r9 << 10) + (r11 << 5)) + r10) << 6;
        if (r8 == r9) goto L20;
        r0 = 63;
    L20:
        return r16 + r0;
    L49:
        return -1;
    }

    public int previousSetBit(int r19) {
        if (r19 >= 0) goto L8;
        if (r19 != (-1)) goto L7;
        return -1;
    L7:
        throw new IndexOutOfBoundsException("i=" + r19);
    L8:
        long[][][] r2 = this.bits;
        int r4 = r19 >> 6;
        int r5 = r4 >> 10;
        boolean r6 = true;
        int r3 = r2.length - 1;
        if (r5 <= r3) goto L11;
        r5 = r3;
        int r0 = 63;
        int r7 = 31;
        int r8 = 31;
    L13:
        if (r5 < 0) goto L34;
        long[][] r10 = r2[r5];
        if (r10 == null) goto L33;
    L16:
        if (r7 < 0) goto L33;
        long[] r11 = r10[r7];
        if (r11 == null) goto L32;
    L19:
        if (r8 < 0) goto L32;
        long r12 = r11[r8];
        if (r12 == 0) goto L31;
        if (r6 == false) goto L24;
        int r9 = r0;
    L25:
        if (r9 < 0) goto L31;
        if ((r12 & (1 << r9)) != 0) goto L29;
        r9 = r9 - 1;
        goto L25
    L29:
        return ((((r5 << 10) + (r7 << 5)) + r8) << 6) + r9;
    L24:
        r9 = 63;
    L31:
        r8 = r8 - 1;
        r6 = false;
    L32:
        r7 = r7 - 1;
        r8 = 31;
        r6 = false;
    L33:
        r5 = r5 - 1;
        r7 = 31;
        r8 = 31;
        r6 = false;
        goto L13
    L34:
        return -1;
    L11:
        r7 = (r4 >> 5) & 31;
        r8 = r4 & 31;
        r0 = r19 % 64;
        goto L13
    }

    public final void resize(int r6) {
        int r7 = (r6 >> 6) >> 10;
        int r0 = Integer.highestOneBit(r7);
        if (r0 != 0) goto L5;
        r0 = 1;
    L5:
        if (r7 < r0) goto L8;
        r0 = r0 << 1;
    L8:
        if (r0 <= 32768) goto L10;
        r0 = 32768;
    L10:
        long[][][] r1 = this.bits;
        if (r1 == null) goto L13;
        int r3 = r1.length;
    L14:
        if (r0 != r3) goto L16;
        if (r1 == null) goto L16;
        return;
    L16:
        long[][][] r4 = new long[r0][][];
        if (r3 == 0) goto L19;
        System.arraycopy(r1, 0, r4, 0, Math.min(r3, r0));
        nullify(0);
    L19:
        this.bits = r4;
        if (r0 != 32768) goto L22;
        int r8 = Integer.MAX_VALUE;
    L23:
        this.bitsLength = r8;
        return;
    L22:
        r8 = 65536 * r0;
        goto L23
    L13:
        r3 = 0;
        goto L14
    }

    public void set(int r7) {
        if ((r7 + 1) < 1) goto L16;
        int r0 = r7 >> 6;
        int r1 = r0 >> 10;
        int r2 = (r0 >> 5) & 31;
        if (r7 < this.bitsLength) goto L7;
        resize(r7);
    L7:
        long[][][] r3 = this.bits;
        long[][] r4 = r3[r1];
        if (r4 != null) goto L10;
        r4 = new long[32][];
        r3[r1] = r4;
    L10:
        long[] r5 = r4[r2];
        if (r5 != null) goto L13;
        r5 = new long[32];
        r4[r2] = r5;
    L13:
        int r6 = r0 & 31;
        r5[r6] = r5[r6] | (1 << r7);
        this.cache.f16359a = 0;
        return;
    L16:
        throw new IndexOutOfBoundsException("i=" + r7);
    }

    public void set(int r3, int r4) {
        setScanner(r3, r4, null, setStrategy);
    }

    public void set(int r1, int r2, boolean r3) {
        if (r3 == false) goto L4;
        set(r1, r2);
        return;
    L4:
        clear(r1, r2);
    }

    public void set(int r1, boolean r2) {
        if (r2 == false) goto L4;
        set(r1);
        return;
    L4:
        clear(r1);
    }

    public final void setScanner(int r50, int r51, SparseBitSet r52, a r53) {
        int r2 = r51;
        if (r53.a(r52) == false) goto L6;
        this.cache.f16359a = 0;
    L6:
        if (r2 >= r50) goto L8;
    L9:
        throwIndexOutOfBoundsException(r50, r51);
    L10:
        if (r50 != r2) goto L12;
        return;
    L12:
        int r4 = r53.a();
        if ((r4 & 1) == 0) goto L15;
        boolean r14 = true;
    L17:
        if ((r4 & 2) == 0) goto L19;
        boolean r15 = true;
    L21:
        if ((r4 & 4) == 0) goto L23;
        boolean r16 = true;
    L25:
        if ((r4 & 8) == 0) goto L27;
        boolean r17 = true;
    L28:
        int r5 = r50 >> 6;
        long r18 = (-1) << r50;
        int r9 = (r2 - 1) >> 6;
        long r20 = (-1) >>> (-r2);
        long[][][] r7 = this.bits;
        int r8 = r7.length;
        if (r52 == null) goto L31;
        long[][][] r6 = r52.bits;
    L32:
        long[][][] r25 = r6;
        if (r25 == null) goto L35;
        int r10 = r52.bits.length;
    L36:
        int r3 = r5 >> 10;
        int r11 = (r5 >> 5) & 31;
        int r26 = r5 & 31;
        int r13 = r9 >> 10;
        int r28 = (r9 >> 5) & 31;
        int r29 = r9 & 31;
        int r1 = (r13 << 5) + r28;
        if (r5 == 0) goto L39;
    L41:
        boolean r23 = false;
    L42:
        if (r11 != 0) goto L44;
        boolean r24 = true;
    L45:
        int r54 = r5;
        long[][][] r12 = r7;
        int r31 = 0;
        int r19 = r3;
        int r21 = r8;
        int r22 = r50;
        int r55 = r11;
        int r27 = 0;
    L46:
        if (r22 >= r2) goto L172;
        long[][] r210 = (long[][]) ZeusTransformUtils.preCheckCast(null, long[][].class, "com.obric.memorydata.plugin");
        if (r19 >= r21) goto L52;
        r210 = r12[r19];
        if (r210 == null) goto L52;
        long[][] r30 = r210;
        boolean r32 = true;
    L53:
        long[][] r33 = (long[][]) ZeusTransformUtils.preCheckCast(null, long[][].class, "com.obric.memorydata.plugin");
        if (r19 >= r10) goto L59;
        if (r25 == null) goto L59;
        r33 = r25[r19];
        if (r33 == null) goto L59;
        boolean r34 = true;
    L60:
        if (r32 == true) goto L63;
        if (r34 == true) goto L63;
        if (r14 == false) goto L63;
    L67:
        if (r23 == false) goto L73;
        if (r19 == r13) goto L73;
        if (r19 >= r21) goto L71;
        r12[r19] = (long[][]) ZeusTransformUtils.preCheckCast(null, long[][].class, "com.obric.memorydata.plugin");
    L71:
        int r56 = r1;
        int r35 = r19;
        int r47 = r9;
        int r39 = r13;
        boolean r41 = r14;
    L168:
        r19 = r35 + 1;
        int r36 = r19 << 10;
        int r37 = r36 << 6;
        if (r37 >= 0) goto L171;
        r37 = Integer.MAX_VALUE;
    L171:
        r22 = r37;
        r1 = r56;
        r54 = r36;
        r10 = r10;
        r13 = r39;
        r14 = r41;
        r9 = r47;
        r55 = 0;
        r2 = r51;
    L73:
        if (r19 != r13) goto L75;
        int r38 = r28 + 1;
    L76:
        long[][] r310 = r30;
        boolean r311 = r32;
        boolean r312 = r23;
        boolean r313 = r24;
        long[][][] r211 = r12;
        int r212 = r27;
        int r40 = r55;
        int r42 = r21;
    L77:
        if (r40 == r38) goto L159;
        if (r311 == false) goto L82;
        long[] r43 = r310[r40];
        if (r43 == null) goto L83;
        boolean r314 = true;
    L84:
        if (r34 == false) goto L88;
        long[] r315 = r33[r40];
        if (r315 == null) goto L89;
        boolean r44 = true;
    L90:
        boolean r57 = r34;
        int r45 = (r19 << 5) + r40;
        if (r1 == r45) goto L93;
        boolean r46 = true;
    L94:
        if (r314 == true) goto L97;
        if (r44 == true) goto L97;
        if (r14 == false) goto L97;
    L101:
        if (r312 == false) goto L106;
        if (r46 == false) goto L106;
        if (r311 == false) goto L105;
        r310[r40] = null;
    L105:
        int r316 = r38;
        int r48 = r19;
        int r49 = r9;
        int r317 = r13;
        r14 = r14;
        int r58 = r40;
        int r110 = r22;
        int r410 = r1;
        int r59 = r54;
        int r510 = r410;
    L158:
        r40 = r58 + 1;
        r34 = r57;
        r19 = r48;
        r22 = r110;
        r38 = r316;
        r13 = r317;
        r14 = r14;
        r9 = r49;
        r26 = 0;
        int r411 = r59;
        r1 = r510;
        r54 = r411;
    L106:
        int r60 = r45 << 5;
        if (r46 == false) goto L109;
        int r412 = 32;
    L110:
        if (r314 == true) goto L112;
        r43 = this.spare;
    L112:
        if (r44 == true) goto L114;
        long[] r318 = ZERO_BLOCK;
    L115:
        if (r312 == false) goto L121;
        if (r46 == false) goto L121;
        if (r17 == false) goto L120;
        if (r44 == true) goto L120;
        boolean r213 = r53.a(r43);
        int r413 = r42;
        r316 = r38;
        int r414 = r19;
        r49 = r9;
        r317 = r13;
        r14 = r14;
        int r61 = 32;
        r58 = r40;
        r110 = r22;
        int r415 = r1;
        r59 = r54;
        r510 = r415;
    L135:
        if (r213 == false) goto L140;
        if (r311 == false) goto L138;
        r310[r58] = null;
    L138:
        r42 = r413;
        r48 = r414;
    L151:
        if (r311 == true) goto L153;
    L156:
        boolean r62 = true;
    L157:
        r313 = r313 & r62;
        goto L158
    L153:
        if (r310[r58] == null) goto L156;
        r62 = false;
        goto L157
    L140:
        if (r43 == this.spare) goto L142;
        r48 = r414;
        r42 = r413;
    L150:
        r212 = r212 + 1;
        goto L151
    L142:
        if (r110 < this.bitsLength) goto L144;
        resize(r110);
        long[][][] r63 = this.bits;
        r211 = r63;
        r42 = r63.length;
    L145:
        if (r310 != null) goto L147;
        long[][] r64 = new long[r61][];
        r48 = r414;
        r211[r48] = r64;
        r310 = r64;
        r311 = true;
    L148:
        r310[r58] = r43;
        this.spare = new long[r61];
        goto L150
    L147:
        r48 = r414;
        goto L148
    L144:
        r42 = r413;
    L120:
        long[] r416 = r43;
        r413 = r42;
        int r417 = r1;
        r59 = r54;
        r510 = r417;
        r316 = r38;
        r414 = r19;
        r317 = r13;
        r110 = r22;
        r213 = r53.a(r60, 0, 32, r416, r318);
        r49 = r9;
        r14 = r14;
        r43 = r416;
        r58 = r40;
        r61 = 32;
    L121:
        long[] r418 = r43;
        r413 = r42;
        r316 = r38;
        r414 = r19;
        r317 = r13;
        r110 = r22;
        r58 = r40;
        int r419 = r1;
        r59 = r54;
        r510 = r419;
        if (r312 == false) goto L124;
        r49 = r9;
        r213 = r53.a(r60, 0, r412, r418, r318) & r53.a(r60, r412, r418, r318, r20);
        r61 = 32;
    L132:
        r43 = r418;
        if (r213 == false) goto L135;
        r213 = r53.a(r43);
        goto L135
    L124:
        int r65 = r9;
        if (r59 != r65) goto L127;
        r49 = r65;
        r213 = r53.a(r60, r26, r418, r318, r18 & r20);
        r61 = 32;
    L131:
        r312 = true;
        goto L132
    L127:
        r49 = r65;
        r213 = r53.a(r60, r26, r418, r318, r18) & r53.a(r60, r26 + 1, r412, r418, r318);
        int r66 = r412;
        if (r66 == 32) goto L130;
        r61 = 32;
        r213 = r213 & r53.a(r60, r66, r418, r318, r20);
        goto L131
    L130:
        r61 = 32;
        goto L131
    L114:
        r318 = r315;
        goto L115
    L109:
        r412 = r29;
    L97:
        if (r314 == true) goto L99;
        if (r15 == true) goto L101;
    L99:
        if (r44 == true) goto L106;
        if (r16 == false) goto L106;
    L93:
        r46 = false;
    L89:
        r44 = false;
        goto L90
    L88:
        r315 = null;
    L83:
        r314 = false;
        goto L84
    L82:
        r43 = null;
        goto L83
    L159:
        r56 = r1;
        int r420 = r42;
        r35 = r19;
        r47 = r9;
        r39 = r13;
        r41 = r14;
        if (r40 != 32) goto L165;
        if (r313 == false) goto L165;
        r21 = r420;
        if (r35 >= r21) goto L166;
        r211[r35] = (long[][]) ZeusTransformUtils.preCheckCast(null, long[][].class, "com.obric.memorydata.plugin");
    L167:
        r12 = r211;
        r27 = r212;
        r23 = r312;
        r24 = r313;
    L166:
        r31 = r31 + 1;
    L165:
        r21 = r420;
        goto L166
    L75:
        r38 = 32;
    L63:
        if (r32 == true) goto L65;
        if (r15 == true) goto L67;
    L65:
        if (r34 == true) goto L73;
        if (r16 == false) goto L73;
    L59:
        r34 = false;
    L52:
        r30 = r210;
        r32 = false;
        goto L53
    L172:
        r53.a(r31, r27);
        return;
    L44:
        r24 = false;
        goto L45
    L39:
        if (r18 != (-1)) goto L41;
        r23 = true;
        goto L42
    L35:
        r10 = 0;
        goto L36
    L31:
        r6 = (long[][][]) ZeusTransformUtils.preCheckCast(null, long[][][].class, "com.obric.memorydata.plugin");
        goto L32
    L27:
        r17 = false;
        goto L28
    L23:
        r16 = false;
        goto L25
    L19:
        r15 = false;
        goto L21
    L15:
        r14 = false;
        goto L17
    L8:
        if ((r50 + 1) >= 1) goto L10;
        goto L9
    }

    public int size() {
        statisticsUpdate();
        return this.cache.f16360b;
    }

    public String statistics() {
        return statistics(null);
    }

    public String statistics(String[] r12) {
        statisticsUpdate();
        int r0 = Statistics.values().length;
        String[] r1 = new String[r0];
        r1[Statistics.Size.ordinal()] = Integer.toString(size());
        r1[Statistics.Length.ordinal()] = Integer.toString(length());
        r1[Statistics.Cardinality.ordinal()] = Integer.toString(cardinality());
        r1[Statistics.Total_words.ordinal()] = Integer.toString(this.cache.e);
        r1[Statistics.Set_array_length.ordinal()] = Integer.toString(this.bits.length);
        r1[Statistics.Set_array_max_length.ordinal()] = Integer.toString(32768);
        r1[Statistics.Level2_areas.ordinal()] = Integer.toString(this.cache.f);
        r1[Statistics.Level2_area_length.ordinal()] = Integer.toString(32);
        r1[Statistics.Level3_blocks.ordinal()] = Integer.toString(this.cache.g);
        r1[Statistics.Level3_block_length.ordinal()] = Integer.toString(32);
        r1[Statistics.Compaction_count_value.ordinal()] = Integer.toString(this.compactionCount);
        Statistics[] r11 = Statistics.values();
        int r2 = r11.length;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r6 = Math.max(r6, r11[r5].name().length());
        r5 = r5 + 1;
        goto L3
    L5:
        StringBuilder r13 = new StringBuilder();
        Statistics[] r3 = Statistics.values();
        int r7 = r3.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L12;
        Statistics r9 = r3[r8];
        r13.append(r9.name());
        int r10 = 0;
    L9:
        if (r10 == (r6 - r9.name().length())) goto L11;
        r13.append(' ');
        r10 = r10 + 1;
        goto L9
    L11:
        r13.append(" = ");
        r13.append(r1[r9.ordinal()]);
        r13.append('\n');
        r8 = r8 + 1;
        goto L6
    L12:
        int r4 = 0;
    L14:
        if (r4 == r13.length()) goto L19;
        if (r13.charAt(r4) != '_') goto L18;
        r13.setCharAt(r4, ' ');
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        if (r12 == null) goto L22;
        System.arraycopy(r1, 0, r12, 0, Math.min(r12.length, r0));
    L22:
        return r13.toString();
    }

    public final void statisticsUpdate() {
        if (this.cache.f16359a == 0) goto L5;
        return;
    L5:
        setScanner(0, this.bitsLength, null, this.updateStrategy);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(200);
        r0.append('{');
        int r1 = nextSetBit(0);
    L3:
        if (r1 < 0) goto L17;
        r0.append(r1);
        int r2 = nextSetBit(r1 + 1);
        if (this.compactionCount <= 0) goto L14;
        if (r2 < 0) goto L17;
        int r3 = nextClearBit(r1);
        if (r3 >= 0) goto L12;
        r3 = Integer.MAX_VALUE;
    L12:
        if ((r1 + this.compactionCount) >= r3) goto L14;
        r0.append("..").append(r3 - 1);
        r1 = nextSetBit(r3);
    L15:
        if (r1 < 0) goto L3;
        r0.append(", ");
    L14:
        r1 = r2;
    L17:
        r0.append('}');
        return r0.toString();
    }

    public void toStringCompaction(int r1) {
        this.compactionCount = r1;
    }

    public void toStringCompaction(boolean r1) {
        if (r1 == false) goto L5;
        compactionCountDefault = this.compactionCount;
        return;
    }

    public void xor(int r2, int r3, SparseBitSet r4) {
        setScanner(r2, r3, r4, xorStrategy);
    }

    public void xor(int r3, boolean r4) {
        if ((r3 + 1) < 1) goto L8;
        if (r4 == false) goto L9;
        flip(r3);
        return;
    L9:
        return;
    L8:
        throw new IndexOutOfBoundsException("i=" + r3);
    }

    public void xor(SparseBitSet r4) {
        setScanner(0, r4.bitsLength, r4, xorStrategy);
    }
}
