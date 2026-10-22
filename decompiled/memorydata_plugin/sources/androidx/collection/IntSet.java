package androidx.collection;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J:\u0010\u0011\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u0012J:\u0010\u0018\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004H\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0007J:\u0010\u001a\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0080\b¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0004H\u0086\bJ:\u0010\u001f\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010 \u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020!0\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010#\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!0\u0014H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010%\u001a\u00020\u0004H\u0016J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010'\u001a\u00020\u0012J:\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020+H\u0007JT\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020+2\u0014\b\u0004\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0\u0014H\u0087\bø\u0001\u0000J\u0006\u00101\u001a\u00020\u0012J\b\u00102\u001a\u00020)H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u0011\u0010\u000f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u0082\u0001\u00013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Landroidx/collection/IntSet;", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "element", "any", "contains", CommonConsts.COUNT_TYPE, "equals", "other", "findElementIndex", "findElementIndex$collection", "first", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntSet;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class IntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public long[] metadata;

    private IntSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.getEmptyIntArray();
    }

    public /* synthetic */ IntSet(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntSet r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, int r14, Object r15) {
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r17 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r18 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L22;
        if ((r14 & 1) == 0) goto L7;
        r16 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        CharSequence r3 = r16;
        if ((r14 & 2) == 0) goto L10;
        r17 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L10:
        CharSequence r4 = r17;
        if ((r14 & 4) == 0) goto L13;
        r18 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L13:
        CharSequence r5 = r18;
        if ((r14 & 8) == 0) goto L16;
        r12 = -1;
    L16:
        int r6 = r12;
        if ((r14 & 16) == 0) goto L20;
        r19 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
    L20:
        return r8.joinToString(r3, r4, r5, r6, r19);
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public static /* synthetic */ String joinToString$default(IntSet r20, CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function1 r26, int r27, Object r28) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L51;
        if ((r27 & 1) == 0) goto L8;
        r1 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        if ((r27 & 2) == 0) goto L11;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L11:
        if ((r27 & 4) == 0) goto L14;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        if ((r27 & 8) == 0) goto L16;
        int r7 = -1;
    L18:
        if ((r27 & 16) == 0) goto L20;
        r5 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
    L20:
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "truncated");
        Intrinsics.checkNotNullParameter(r6, "transform");
        StringBuilder r8 = new StringBuilder();
        r8.append(r3);
        int[] r9 = r20.elements;
        long[] r0 = r20.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L47;
        int r11 = 0;
        int r12 = 0;
    L23:
        long r13 = r0[r11];
        int r29 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L43;
        int r14 = 8;
        int r15 = 8 - ((~(r29 - r10)) >>> 31);
        int r16 = 0;
    L26:
        if (r16 >= r15) goto L40;
        if ((r13 & 255) >= 128) goto L30;
        boolean r17 = true;
    L31:
        if (r17 == false) goto L38;
        int r18 = r9[(r29 << 3) + r16];
        if (r12 == r7) goto L34;
        if (r12 == 0) goto L37;
        r8.append(r1);
    L37:
        r8.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(Integer.valueOf(r18)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L39:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L26
    L34:
        r8.append(r5);
    L48:
        String r19 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r19, "StringBuilder().apply(builderAction).toString()");
        return r19;
    L38:
        r2 = r14;
        goto L39
    L30:
        r17 = false;
        goto L31
    L40:
        long[] r110 = r0;
        if (r15 != r14) goto L47;
    L45:
        if (r29 == r10) goto L47;
        r11 = r29 + 1;
        r0 = r110;
        goto L23
    L43:
        r110 = r0;
    L47:
        r8.append(r4);
        goto L48
    L16:
        r7 = r24;
        goto L18
    L51:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(Function1<? super Integer, Boolean> r18) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        int[] r3 = this.elements;
        long[] r0 = this.metadata;
        int r4 = r0.length - 2;
        if (r4 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(Integer.valueOf(r3[(r7 << 3) + r12])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        return false;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 != 8) goto L21;
    L19:
        if (r7 == r4) goto L21;
        r7 = r7 + 1;
    L21:
        return true;
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean any(Function1<? super Integer, Boolean> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        int[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L21;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(Integer.valueOf(r0[(r4 << 3) + r9])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return true;
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 != 8) goto L21;
    L19:
        if (r4 == r2) goto L21;
        r4 = r4 + 1;
    L21:
        return false;
    }

    public final boolean contains(int r19) {
        int r1 = Integer.hashCode(r19) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 & 127;
        int r4 = this._capacity;
        int r5 = (r2 >>> 7) & r4;
        int r6 = 0;
    L3:
        long[] r7 = this.metadata;
        int r8 = r5 >> 3;
        int r9 = (r5 & 7) << 3;
        long r10 = ((r7[r8 + 1] << (64 - r9)) & ((-r9) >> 63)) | (r7[r8] >>> r9);
        long r11 = (((long) r3) * ScatterMapKt.BitmaskLsb) ^ r10;
        long r12 = ((~r11) & (r11 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r12 == 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L14;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.elements[r14] == r19) goto L16;
        r12 = r12 & (r12 - 1);
    L16:
        if (r14 >= 0) goto L18;
        return false;
    L18:
        return true;
    L14:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L15:
        r14 = -1;
        goto L16
    L7:
        r13 = false;
        goto L8
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super Integer, Boolean> r18) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        int[] r3 = this.elements;
        long[] r0 = this.metadata;
        int r4 = r0.length - 2;
        int r5 = 0;
        if (r4 < 0) goto L23;
        int r6 = 0;
        int r7 = 0;
    L5:
        long r8 = r0[r6];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r6 - r4)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(Integer.valueOf(r3[(r6 << 3) + r12])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        r7 = r7 + 1;
    L17:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = false;
        goto L13
    L18:
        if (r10 == 8) goto L19;
        return r7;
    L19:
        if (r6 == r4) goto L21;
        r6 = r6 + 1;
        goto L5
    L21:
        r5 = r7;
    L23:
        return r5;
    }

    public boolean equals(Object r19) {
        if (r19 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r19, IntSet.class) == true) goto L9;
        return false;
    L9:
        if (((IntSet) ZeusTransformUtils.preCheckCast(r19, IntSet.class, "com.obric.memorydata.plugin"))._size == this._size) goto L11;
        return false;
    L11:
        int[] r6 = this.elements;
        long[] r0 = this.metadata;
        int r7 = r0.length - 2;
        if (r7 < 0) goto L30;
        int r8 = 0;
    L14:
        long r9 = r0[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r11 = 8 - ((~(r8 - r7)) >>> 31);
        int r13 = 0;
    L17:
        if (r13 >= r11) goto L27;
        if ((255 & r9) >= 128) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L26;
        if (((IntSet) ZeusTransformUtils.preCheckCast(r19, IntSet.class, "com.obric.memorydata.plugin")).contains(r6[(r8 << 3) + r13]) == true) goto L26;
        return false;
    L26:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L17
    L21:
        r14 = false;
        goto L22
    L27:
        if (r11 != 8) goto L30;
    L28:
        if (r8 == r7) goto L30;
        r8 = r8 + 1;
    L30:
        return true;
    }

    public final int findElementIndex$collection(int r19) {
        int r1 = Integer.hashCode(r19) * ScatterMapKt.MurmurHashC1;
        int r2 = r1 ^ (r1 << 16);
        int r3 = r2 & 127;
        int r4 = this._capacity;
        int r5 = (r2 >>> 7) & r4;
        int r6 = 0;
    L3:
        long[] r7 = this.metadata;
        int r8 = r5 >> 3;
        int r9 = (r5 & 7) << 3;
        long r10 = ((r7[r8 + 1] << (64 - r9)) & ((-r9) >> 63)) | (r7[r8] >>> r9);
        long r11 = (((long) r3) * ScatterMapKt.BitmaskLsb) ^ r10;
        long r12 = ((~r11) & (r11 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L5:
        if (r12 == 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == false) goto L14;
        int r14 = ((Long.numberOfTrailingZeros(r12) >> 3) + r5) & r4;
        if (this.elements[r14] == r19) goto L11;
        r12 = r12 & (r12 - 1);
        goto L5
    L11:
        return r14;
    L14:
        if (((r10 & ((~r10) << 6)) & (-9187201950435737472L)) != 0) goto L15;
        r6 = r6 + 8;
        r5 = (r5 + r6) & r4;
        goto L3
    L15:
        return -1;
    L7:
        r13 = false;
        goto L8
    }

    public final int first() {
        int[] r0 = this.elements;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L21;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L17;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L15;
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L15:
        return r0[(r3 << 3) + r8];
    L12:
        r9 = false;
        goto L13
    L17:
        if (r6 != 8) goto L21;
    L18:
        if (r3 == r1) goto L21;
        r3 = r3 + 1;
    L21:
        throw new NoSuchElementException("The IntSet is empty");
    }

    public final int first(Function1<? super Integer, Boolean> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "predicate");
        int[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L22;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L18;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L17;
        int r11 = r0[(r4 << 3) + r9];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16.invoke(Integer.valueOf(r11)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return r11;
    L17:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L18:
        if (r7 != 8) goto L22;
    L19:
        if (r4 == r2) goto L22;
        r4 = r4 + 1;
    L22:
        throw new NoSuchElementException("Could not find a match");
    }

    public final void forEach(Function1<? super Integer, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        int[] r0 = this.elements;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        r15.invoke(Integer.valueOf(r0[(r3 << 3) + r8]));
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndex(Function1<? super Integer, Unit> r13) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "block");
        long[] r12 = this.metadata;
        int r0 = r12.length - 2;
        if (r0 < 0) goto L20;
        int r2 = 0;
    L5:
        long r3 = r12[r2];
        if (((((~r3) << 7) & r3) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r5 = 8 - ((~(r2 - r0)) >>> 31);
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L16;
        if ((255 & r3) >= 128) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        r14.invoke(Integer.valueOf((r2 << 3) + r7));
    L15:
        r3 = r3 >> 8;
        r7 = r7 + 1;
        goto L8
    L12:
        r8 = false;
        goto L13
    L16:
        if (r5 == 8) goto L18;
        return;
    L18:
        if (r2 == r0) goto L26;
        r2 = r2 + 1;
        goto L5
    L26:
        return;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] r0 = this.elements;
        long[] r14 = this.metadata;
        int r1 = r14.length - 2;
        int r2 = 0;
        if (r1 < 0) goto L21;
        int r3 = 0;
        int r4 = 0;
    L5:
        long r5 = r14[r3];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r7 = 8 - ((~(r3 - r1)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L16;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        r4 = r4 + Integer.hashCode(r0[(r3 << 3) + r9]);
    L15:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L16:
        if (r7 == 8) goto L17;
        return r4;
    L17:
        if (r3 == r1) goto L19;
        r3 = r3 + 1;
        goto L5
    L19:
        r2 = r4;
    L21:
        return r2;
    }

    public final boolean isEmpty() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence r9) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        return joinToString$default(this, r1, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        return joinToString$default(this, r3, r4, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12, CharSequence r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, 0, null, 24, null);
    }

    public final String joinToString(CharSequence r11, CharSequence r12, CharSequence r13, int r14) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, r14, null, 16, null);
    }

    public final String joinToString(CharSequence r20, CharSequence r21, CharSequence r22, int r23, CharSequence r24) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r24, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r2, "truncated");
        StringBuilder r5 = new StringBuilder();
        r5.append(r3);
        int[] r6 = this.elements;
        long[] r0 = this.metadata;
        int r7 = r0.length - 2;
        if (r7 < 0) goto L28;
        int r8 = 0;
        int r9 = 0;
    L5:
        long r10 = r0[r8];
        if (((((~r10) << 7) & r10) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L26;
        int r12 = 8 - ((~(r8 - r7)) >>> 31);
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L23;
        if ((255 & r10) >= 128) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L21;
        int r16 = r6[(r8 << 3) + r14];
        if (r9 == r23) goto L16;
        if (r9 == 0) goto L19;
        r5.append(r1);
    L19:
        r5.append(r16);
        r9 = r9 + 1;
        goto L21
    L16:
        r5.append(r2);
    L29:
        String r11 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "StringBuilder().apply(builderAction).toString()");
        return r11;
    L21:
        r10 = r10 >> 8;
        r14 = r14 + 1;
        goto L8
    L12:
        r15 = false;
        goto L13
    L23:
        if (r12 != 8) goto L28;
    L26:
        if (r8 == r7) goto L28;
        r8 = r8 + 1;
    L28:
        r5.append(r4);
        goto L29
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function1<? super Integer, ? extends CharSequence> r26) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "truncated");
        Intrinsics.checkNotNullParameter(r6, "transform");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == r24) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        goto L21
    L16:
        r7.append(r5);
    L29:
        String r2 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    L21:
        r12 = r12 >> 8;
        r13 = r13 + 1;
        r15 = 8;
        r1 = r1;
        r0 = r0;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r18 = r0;
        CharSequence r19 = r1;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r1 = r19;
        r0 = r18;
        goto L5
    L25:
        r18 = r0;
        r19 = r1;
    L28:
        r7.append(r4);
        goto L29
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, Function1<? super Integer, ? extends CharSequence> r25) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "transform");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L21;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == r24) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r5.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        goto L21
    L16:
        r7.append(r6);
    L29:
        String r2 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "StringBuilder().apply(builderAction).toString()");
        return r2;
    L21:
        r12 = r12 >> 8;
        r13 = r13 + 1;
        r15 = 8;
        r1 = r1;
        r0 = r0;
        goto L8
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r18 = r0;
        CharSequence r19 = r1;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r1 = r19;
        r0 = r18;
        goto L5
    L25:
        r18 = r0;
        r19 = r1;
    L28:
        r7.append(r4);
        goto L29
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, Function1<? super Integer, ? extends CharSequence> r24) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "transform");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r5.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        int r2 = 8;
    L21:
        r12 = r12 >> r2;
        r13 = r13 + 1;
        r15 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L29:
        String r18 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L20:
        r2 = r15;
        goto L21
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r19 = r0;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r0 = r19;
        goto L5
    L25:
        r19 = r0;
    L28:
        r7.append(r4);
        goto L29
    }

    public final String joinToString(CharSequence r21, CharSequence r22, Function1<? super Integer, ? extends CharSequence> r23) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r23, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "transform");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r4.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        int r2 = 8;
    L21:
        r12 = r12 >> r2;
        r13 = r13 + 1;
        r15 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L29:
        String r18 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L20:
        r2 = r15;
        goto L21
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r19 = r0;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r0 = r19;
        goto L5
    L25:
        r19 = r0;
    L28:
        r7.append(r5);
        goto L29
    }

    public final String joinToString(CharSequence r21, Function1<? super Integer, ? extends CharSequence> r22) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "transform");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r4);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r3.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        int r2 = 8;
    L21:
        r12 = r12 >> r2;
        r13 = r13 + 1;
        r15 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L29:
        String r18 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L20:
        r2 = r15;
        goto L21
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r19 = r0;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r0 = r19;
        goto L5
    L25:
        r19 = r0;
    L28:
        r7.append(r5);
        goto L29
    }

    public final String joinToString(Function1<? super Integer, ? extends CharSequence> r21) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "transform");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r4);
        int[] r8 = this.elements;
        long[] r0 = this.metadata;
        int r9 = r0.length - 2;
        if (r9 < 0) goto L28;
        int r10 = 0;
        int r11 = 0;
    L5:
        long r12 = r0[r10];
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r15 = 8;
        int r14 = 8 - ((~(r10 - r9)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r14) goto L22;
        if ((r12 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = r8[(r10 << 3) + r13];
        if (r11 == (-1)) goto L16;
        if (r11 == 0) goto L19;
        r7.append(r3);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r1.invoke(Integer.valueOf(r17)), CharSequence.class, "com.obric.memorydata.plugin"));
        r11 = r11 + 1;
        int r2 = 8;
    L21:
        r12 = r12 >> r2;
        r13 = r13 + 1;
        r15 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L29:
        String r18 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L20:
        r2 = r15;
        goto L21
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r19 = r0;
        if (r14 != r15) goto L28;
    L26:
        if (r10 == r9) goto L28;
        r10 = r10 + 1;
        r0 = r19;
        goto L5
    L25:
        r19 = r0;
    L28:
        r7.append(r5);
        goto L29
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, 25, null);
    }
}
