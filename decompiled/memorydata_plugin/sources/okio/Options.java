package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B\u001f\b\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0096\u0002R\u001e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lokio/Options;", "Ljava/util/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$jvm", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$jvm", "()[I", "get", "index", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = null;
    private final ByteString[] byteStrings;
    private final int[] trie;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final void buildTrieRecursive(long r25, Buffer r27, int r28, List<? extends ByteString> r29, int r30, int r31, List<Integer> r32) {
            int r2 = r28;
            List<? extends ByteString> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
            List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
            if (r30 >= r31) goto L5;
            boolean r8 = true;
        L7:
            if (r8 == false) goto L76;
            int r9 = r30;
        L9:
            if (r9 >= r31) goto L18;
            if (((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r9), ByteString.class, "com.obric.memorydata.plugin")).size() < r2) goto L13;
            boolean r13 = true;
        L14:
            if (r13 == false) goto L17;
            r9 = r9 + 1;
            goto L9
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L13:
            r13 = false;
            goto L14
        L18:
            ByteString r11 = (ByteString) ZeusTransformUtils.preCheckCast(r7.get(r30), ByteString.class, "com.obric.memorydata.plugin");
            ByteString r12 = (ByteString) ZeusTransformUtils.preCheckCast(r7.get(r31 - 1), ByteString.class, "com.obric.memorydata.plugin");
            if (r2 != r11.size()) goto L21;
            int r14 = ((Number) ZeusTransformUtils.preCheckCast(r10.get(r30), Number.class, "com.obric.memorydata.plugin")).intValue();
            int r3 = r30 + 1;
            ByteString r15 = (ByteString) ZeusTransformUtils.preCheckCast(r7.get(r3), ByteString.class, "com.obric.memorydata.plugin");
            int r16 = r3;
            int r4 = r14;
            r11 = r15;
        L23:
            if (r11.getByte(r2) == r12.getByte(r2)) goto L54;
            int r17 = r16 + 1;
            int r6 = 1;
        L25:
            if (r17 >= r31) goto L30;
            if (((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r17 - 1), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2) == ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r17), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2)) goto L29;
            r6 = r6 + 1;
        L29:
            r17 = r17 + 1;
            goto L25
        L30:
            Class r22 = Companion.class;
            long r5 = ((long) (r6 * 2)) + ((r25 + ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).getIntCount(r27)) + ((long) 2));
            r27.writeInt(r6);
            r27.writeInt(r4);
            int r18 = r16;
        L31:
            if (r18 >= r31) goto L38;
            byte r19 = ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r18), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2);
            if (r18 != r16) goto L35;
        L36:
            r27.writeInt(r19 & 255);
        L37:
            r18 = r18 + 1;
            goto L31
        L35:
            if (r19 == ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r18 - 1), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2)) goto L37;
        L38:
            Buffer r20 = new Buffer();
            int r21 = r16;
        L39:
            if (r21 >= r31) goto L53;
            byte r23 = ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r21), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2);
            int r110 = r21 + 1;
            int r111 = r110;
        L41:
            if (r111 >= r31) goto L46;
            if (r23 != ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r111), ByteString.class, "com.obric.memorydata.plugin")).getByte(r2)) goto L44;
            r111 = r111 + 1;
            goto L41
        L44:
            int r24 = r111;
        L47:
            if (r110 == r24) goto L49;
        L51:
            Class r112 = r22;
            r27.writeInt(((int) (((Companion) ZeusTransformUtils.preCheckCast(this, r112, "com.obric.memorydata.plugin")).getIntCount(r20) + r5)) * (-1));
            Class r26 = r112;
            ((Companion) ZeusTransformUtils.preCheckCast(this, r112, "com.obric.memorydata.plugin")).buildTrieRecursive(r5, r20, r2 + 1, r7, r21, r24, r10);
        L52:
            r22 = r26;
            r21 = r24;
            r5 = r5;
            goto L39
        L49:
            if ((r2 + 1) != ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r21), ByteString.class, "com.obric.memorydata.plugin")).size()) goto L51;
            r27.writeInt(((Number) ZeusTransformUtils.preCheckCast(r10.get(r21), Number.class, "com.obric.memorydata.plugin")).intValue());
            r26 = r22;
            goto L52
        L46:
            r24 = r31;
            goto L47
        L53:
            Object r0 = ZeusTransformUtils.preCheckCast(r20, Source.class, "com.obric.memorydata.plugin");
        L73:
            r27.writeAll((Source) r0);
            return;
        L54:
            int r113 = Math.min(r11.size(), r12.size());
            int r114 = r2;
            int r33 = 0;
        L55:
            if (r114 >= r113) goto L59;
            int r34 = r113;
            if (r11.getByte(r114) != r12.getByte(r114)) goto L59;
            r33 = r33 + 1;
            r114 = r114 + 1;
            r113 = r34;
        L59:
            long r35 = 1 + (((r25 + ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).getIntCount(r27)) + ((long) 2)) + ((long) r33));
            r27.writeInt(-r33);
            r27.writeInt(r4);
            int r36 = r33 + r2;
        L60:
            if (r2 >= r36) goto L63;
            r27.writeInt(r11.getByte(r2) & 255);
            r2 = r2 + 1;
            goto L60
        L63:
            if ((r16 + 1) == r31) goto L65;
            Buffer r115 = new Buffer();
            r27.writeInt(((int) (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).getIntCount(r115) + r35)) * (-1));
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).buildTrieRecursive(r35, r115, r36, r7, r16, r31, r10);
            r0 = ZeusTransformUtils.preCheckCast(r115, Source.class, "com.obric.memorydata.plugin");
            goto L73
        L65:
            if (r36 != ((ByteString) ZeusTransformUtils.preCheckCast(r7.get(r16), ByteString.class, "com.obric.memorydata.plugin")).size()) goto L67;
            boolean r37 = true;
        L68:
            if (r37 == false) goto L71;
            r27.writeInt(((Number) ZeusTransformUtils.preCheckCast(r10.get(r16), Number.class, "com.obric.memorydata.plugin")).intValue());
            return;
        L71:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L67:
            r37 = false;
            goto L68
        L21:
            r16 = r30;
            r4 = -1;
            goto L23
        L76:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r8 = false;
            goto L7
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion r11, long r12, Buffer r14, int r15, List r16, int r17, int r18, List r19, int r20, Object r21) {
            List<? extends ByteString> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
            List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            if ((r20 & 1) == 0) goto L5;
            long r3 = 0;
        L7:
            if ((r20 & 4) == 0) goto L9;
            int r6 = 0;
        L11:
            if ((r20 & 16) == 0) goto L13;
            int r8 = 0;
        L15:
            if ((r20 & 32) == 0) goto L17;
            int r9 = r7.size();
        L18:
            r11.buildTrieRecursive(r3, r14, r6, r7, r8, r9, r10);
            return;
        L17:
            r9 = r18;
            goto L18
        L13:
            r8 = r17;
            goto L15
        L9:
            r6 = r15;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        private final long getIntCount(Buffer r3) {
            return r3.size() / ((long) 4);
        }

        @JvmStatic
        public final Options of(ByteString... r21) {
            Intrinsics.checkParameterIsNotNull(r21, "byteStrings");
            if (r21.length != 0) goto L5;
            boolean r3 = true;
        L6:
            DefaultConstructorMarker r6 = null;
            if (r3 == true) goto L9;
            List r4 = ArraysKt.toMutableList(r21);
            CollectionsKt.sort(r4);
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r21.length), Collection.class, "com.obric.memorydata.plugin");
            int r8 = r21.length;
            int r9 = 0;
        L11:
            if (r9 >= r8) goto L13;
            ByteString r10 = r21[r9];
            r7.add(-1);
            r9 = r9 + 1;
            goto L11
        L13:
            Object[] r11 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Integer[0]);
            if (r11 == null) goto L53;
            Integer[] r12 = (Integer[]) ZeusTransformUtils.preCheckCast(r11, Integer[].class, "com.obric.memorydata.plugin");
            List r14 = CollectionsKt.mutableListOf((Integer[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r12, r12.length), Integer[].class, "com.obric.memorydata.plugin"));
            int r13 = r21.length;
            int r15 = 0;
            int r16 = 0;
        L16:
            if (r15 >= r13) goto L19;
            r14.set(CollectionsKt.binarySearch$default(r4, (Comparable) ZeusTransformUtils.preCheckCast(r21[r15], Comparable.class, "com.obric.memorydata.plugin"), 0, 0, 6, null), Integer.valueOf(r16));
            r15 = r15 + 1;
            r16 = r16 + 1;
            goto L16
        L19:
            if (((ByteString) ZeusTransformUtils.preCheckCast(r4.get(0), ByteString.class, "com.obric.memorydata.plugin")).size() <= 0) goto L21;
            boolean r17 = true;
        L22:
            if (r17 == false) goto L51;
            int r18 = 0;
        L25:
            if (r18 >= r4.size()) goto L44;
            ByteString r19 = (ByteString) ZeusTransformUtils.preCheckCast(r4.get(r18), ByteString.class, "com.obric.memorydata.plugin");
            int r20 = r18 + 1;
            int r110 = r20;
        L28:
            if (r110 >= r4.size()) goto L43;
            ByteString r111 = (ByteString) ZeusTransformUtils.preCheckCast(r4.get(r110), ByteString.class, "com.obric.memorydata.plugin");
            if (r111.startsWith(r19) == false) goto L43;
            if (r111.size() == r19.size()) goto L35;
            boolean r112 = true;
        L36:
            if (r112 == false) goto L42;
            if (((Number) ZeusTransformUtils.preCheckCast(r14.get(r110), Number.class, "com.obric.memorydata.plugin")).intValue() > ((Number) ZeusTransformUtils.preCheckCast(r14.get(r18), Number.class, "com.obric.memorydata.plugin")).intValue()) goto L39;
            r110 = r110 + 1;
            goto L28
        L39:
            r4.remove(r110);
            r14.remove(r110);
            goto L28
        L42:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("duplicate option: " + r111).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L35:
            r112 = false;
        L43:
            r18 = r20;
            goto L25
        L44:
            Buffer r5 = new Buffer();
            buildTrieRecursive$default((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin"), 0, r5, 0, r4, 0, 0, r14, 53, null);
            int[] r0 = new int[(int) ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).getIntCount(r5)];
            int r113 = 0;
        L46:
            if (r5.exhausted() == true) goto L49;
            r0[r113] = r5.readInt();
            r113 = r113 + 1;
            goto L46
        L49:
            return new Options((ByteString[]) ZeusTransformUtils.preCheckCast(r21.clone(), ByteString[].class, "com.obric.memorydata.plugin"), r0, r6);
        L51:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("the empty byte string is not a supported option".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L21:
            r17 = false;
            goto L22
        L53:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        L9:
            return new Options(new ByteString[0], new int[]{0, -1}, r6);
        L5:
            r3 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    private Options(ByteString[] r1, int[] r2) {
        this.byteStrings = r1;
        this.trie = r2;
    }

    public /* synthetic */ Options(ByteString[] r1, int[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @JvmStatic
    public static final Options of(ByteString... r1) {
        return Companion.of(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object r3) {
        if (r3 == null) goto L4;
        boolean r0 = ZeusTransformUtils.instanceOf(r3, ByteString.class);
    L5:
        if (r0 == true) goto L7;
        return false;
    L7:
        return contains((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L4:
        r0 = true;
        goto L5
    }

    public /* bridge */ boolean contains(ByteString r1) {
        return super.contains(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int r1) {
        return this.byteStrings[r1];
    }

    public final ByteString[] getByteStrings$jvm() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$jvm() {
        return this.trie;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object r3) {
        if (r3 == null) goto L4;
        boolean r0 = ZeusTransformUtils.instanceOf(r3, ByteString.class);
    L5:
        if (r0 == true) goto L7;
        return -1;
    L7:
        return indexOf((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L4:
        r0 = true;
        goto L5
    }

    public /* bridge */ int indexOf(ByteString r1) {
        return super.indexOf(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object r3) {
        if (r3 == null) goto L4;
        boolean r0 = ZeusTransformUtils.instanceOf(r3, ByteString.class);
    L5:
        if (r0 == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L4:
        r0 = true;
        goto L5
    }

    public /* bridge */ int lastIndexOf(ByteString r1) {
        return super.lastIndexOf(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ByteString remove(int r1) {
        return removeAt(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object r3) {
        if (r3 == null) goto L4;
        boolean r0 = ZeusTransformUtils.instanceOf(r3, ByteString.class);
    L5:
        if (r0 == true) goto L7;
        return false;
    L7:
        return remove((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L4:
        r0 = true;
        goto L5
    }

    public /* bridge */ boolean remove(ByteString r1) {
        return super.remove(r1);
    }

    public ByteString removeAt(int r2) {
        return (ByteString) ZeusTransformUtils.preCheckCast(super.remove(r2), ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return getSize();
    }
}
