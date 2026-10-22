package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0018J&\u0010\u001c\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0\u001aH\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0.H\u0081\bø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020)0.H\u0086\bø\u0001\u0000J\u0016\u00102\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00103J\u001b\u00104\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u001b¢\u0006\u0002\u00106J'\u00107\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00028\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b08H\u0086\bø\u0001\u0000¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u0018J\u0006\u0010<\u001a\u00020\u0018J:\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@H\u0007Jx\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020@2\b\b\u0002\u0010C\u001a\u00020\u00052\b\b\u0002\u0010D\u001a\u00020@28\b\u0004\u0010E\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020@0\u001aH\u0087\bø\u0001\u0000J\u0006\u0010F\u001a\u00020\u0018J\b\u0010G\u001a\u00020>H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000f\u0012\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"Landroidx/collection/ObjectLongMap;", "K", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", EventBody.KEY_VALUE, CommonConsts.COUNT_TYPE, "equals", "other", "findKeyIndex", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(Ljava/lang/Object;)J", "getOrDefault", "defaultValue", "(Ljava/lang/Object;J)J", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)J", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableObjectLongMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObjectLongMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public long[] values;

    private ObjectLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = LongSetKt.getEmptyLongArray();
    }

    public /* synthetic */ ObjectLongMap(DefaultConstructorMarker r1) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectLongMap r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, int r14, Object r15) {
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

    public static /* synthetic */ String joinToString$default(ObjectLongMap r20, CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function2 r26, int r27, Object r28) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r26, Function2.class, "com.obric.memorydata.plugin");
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
        Object[] r9 = r20.keys;
        long[] r10 = r20.values;
        long[] r0 = r20.metadata;
        int r11 = r0.length - 2;
        if (r11 < 0) goto L47;
        int r12 = 0;
        int r13 = 0;
    L23:
        long r14 = r0[r12];
        int r29 = r12;
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L43;
        int r15 = 8 - ((~(r29 - r11)) >>> 31);
        int r16 = 0;
    L26:
        if (r16 >= r15) goto L40;
        if ((r14 & 255) >= 128) goto L30;
        boolean r17 = true;
    L31:
        if (r17 == false) goto L39;
        int r18 = (r29 << 3) + r16;
        Object r2 = r9[r18];
        long r19 = r10[r18];
        if (r13 == r7) goto L34;
        if (r13 == 0) goto L37;
        r8.append(r1);
    L37:
        r8.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(r2, Long.valueOf(r19)), CharSequence.class, "com.obric.memorydata.plugin"));
        r13 = r13 + 1;
        goto L39
    L34:
        r8.append(r5);
    L48:
        String r30 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r30, "StringBuilder().apply(builderAction).toString()");
        return r30;
    L39:
        r14 = r14 >> 8;
        r16 = r16 + 1;
        r1 = r1;
        r0 = r0;
        goto L26
    L30:
        r17 = false;
        goto L31
    L40:
        long[] r110 = r0;
        CharSequence r111 = r1;
        if (r15 != 8) goto L47;
    L45:
        if (r29 == r11) goto L47;
        r12 = r29 + 1;
        r1 = r111;
        r0 = r110;
        goto L23
    L43:
        r110 = r0;
        r111 = r1;
    L47:
        r8.append(r4);
        goto L48
    L16:
        r7 = r24;
        goto L18
    L51:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(Function2<? super K, ? super Long, Boolean> r19) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        long[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        if (r5 < 0) goto L21;
        int r8 = 0;
    L5:
        long r9 = r0[r8];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r8 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r8 << 3) + r13;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r15], Long.valueOf(r4[r15])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        return false;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 != 8) goto L21;
    L19:
        if (r8 == r5) goto L21;
        r8 = r8 + 1;
    L21:
        return true;
    }

    public final boolean any() {
        if (this._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean any(Function2<? super K, ? super Long, Boolean> r19) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        long[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        if (r5 < 0) goto L21;
        int r7 = 0;
    L5:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r10 = 8 - ((~(r7 - r5)) >>> 31);
        int r12 = 0;
    L8:
        if (r12 >= r10) goto L18;
        if ((255 & r8) >= 128) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L17;
        int r14 = (r7 << 3) + r12;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r14], Long.valueOf(r4[r14])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        return true;
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
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
    L21:
        return false;
    }

    public final boolean contains(K r1) {
        if (findKeyIndex(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsKey(K r1) {
        if (findKeyIndex(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(long r14) {
        long[] r0 = this.values;
        long[] r13 = this.metadata;
        int r1 = r13.length - 2;
        if (r1 < 0) goto L21;
        int r3 = 0;
    L5:
        long r4 = r13[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L18;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L17;
        if (r14 != r0[(r3 << 3) + r8]) goto L17;
        return true;
    L17:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L18:
        if (r6 != 8) goto L21;
    L19:
        if (r3 == r1) goto L21;
        r3 = r3 + 1;
    L21:
        return false;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super K, ? super Long, Boolean> r19) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r19, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Object[] r3 = this.keys;
        long[] r4 = this.values;
        long[] r0 = this.metadata;
        int r5 = r0.length - 2;
        int r6 = 0;
        if (r5 < 0) goto L23;
        int r7 = 0;
        int r8 = 0;
    L5:
        long r9 = r0[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L18;
        if ((255 & r9) >= 128) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L17;
        int r15 = (r7 << 3) + r13;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.invoke(r3[r15], Long.valueOf(r4[r15])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L17;
        r8 = r8 + 1;
    L17:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        goto L8
    L12:
        r14 = false;
        goto L13
    L18:
        if (r11 == 8) goto L19;
        return r8;
    L19:
        if (r7 == r5) goto L21;
        r7 = r7 + 1;
        goto L5
    L21:
        r6 = r8;
    L23:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r18) {
        if (r18 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r18, ObjectLongMap.class) == true) goto L9;
        return false;
    L9:
        if (((ObjectLongMap) ZeusTransformUtils.preCheckCast(r18, ObjectLongMap.class, "com.obric.memorydata.plugin")).getSize() == getSize()) goto L11;
        return false;
    L11:
        ObjectLongMap r1 = (ObjectLongMap) ZeusTransformUtils.preCheckCast(r18, ObjectLongMap.class, "com.obric.memorydata.plugin");
        Object[] r2 = this.keys;
        long[] r4 = this.values;
        long[] r0 = this.metadata;
        int r6 = r0.length - 2;
        if (r6 < 0) goto L30;
        int r7 = 0;
    L14:
        long r8 = r0[r7];
        if (((((~r8) << 7) & r8) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        int r10 = 8 - ((~(r7 - r6)) >>> 31);
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L27;
        if ((255 & r8) >= 128) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L26;
        int r14 = (r7 << 3) + r12;
        if (r4[r14] == r1.get(r2[r14])) goto L26;
        return false;
    L26:
        r8 = r8 >> 8;
        r12 = r12 + 1;
        goto L17
    L21:
        r13 = false;
        goto L22
    L27:
        if (r10 != 8) goto L30;
    L28:
        if (r7 == r6) goto L30;
        r7 = r7 + 1;
    L30:
        return true;
    }

    public final int findKeyIndex(K r18) {
        if (r18 == null) goto L5;
        int r3 = r18.hashCode();
    L6:
        int r4 = r3 * ScatterMapKt.MurmurHashC1;
        int r5 = r4 ^ (r4 << 16);
        int r6 = r5 & 127;
        int r7 = this._capacity;
        int r8 = (r5 >>> 7) & r7;
        int r9 = 0;
    L7:
        long[] r10 = this.metadata;
        int r11 = r8 >> 3;
        int r12 = (r8 & 7) << 3;
        long r13 = ((r10[r11 + 1] << (64 - r12)) & ((-r12) >> 63)) | (r10[r11] >>> r12);
        long r14 = (((long) r6) * ScatterMapKt.BitmaskLsb) ^ r13;
        long r15 = ((~r14) & (r14 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r15 == 0) goto L11;
        boolean r16 = true;
    L12:
        if (r16 == false) goto L18;
        int r17 = ((Long.numberOfTrailingZeros(r15) >> 3) + r8) & r7;
        if (Intrinsics.areEqual(this.keys[r17], r18) == true) goto L15;
        r15 = r15 & (r15 - 1);
        goto L9
    L15:
        return r17;
    L18:
        if (((r13 & ((~r13) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r9 = r9 + 8;
        r8 = (r8 + r9) & r7;
        goto L7
    L19:
        return -1;
    L11:
        r16 = false;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public final void forEach(Function2<? super K, ? super Long, Unit> r15) {
        Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r15, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "block");
        Object[] r0 = this.keys;
        long[] r1 = this.values;
        long[] r14 = this.metadata;
        int r2 = r14.length - 2;
        if (r2 < 0) goto L19;
        int r4 = 0;
    L5:
        long r5 = r14[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r7 = 8 - ((~(r4 - r2)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L16;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        int r11 = (r4 << 3) + r9;
        r16.invoke(r0[r11], Long.valueOf(r1[r11]));
    L15:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L16:
        if (r7 == 8) goto L17;
        return;
    L17:
        if (r4 == r2) goto L26;
        r4 = r4 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r13) {
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

    public final void forEachKey(Function1<? super K, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        Object[] r0 = this.keys;
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
        r15.invoke(r0[(r3 << 3) + r8]);
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

    public final void forEachValue(Function1<? super Long, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        long[] r0 = this.values;
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
        r15.invoke(Long.valueOf(r0[(r3 << 3) + r8]));
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

    public final long get(K r3) {
        int r0 = findKeyIndex(r3);
        if (r0 < 0) goto L7;
        return this.values[r0];
    L7:
        throw new NoSuchElementException("There is no key " + r3 + " in the map");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(K r1, long r2) {
        int r3 = findKeyIndex(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return this.values[r3];
    }

    public final long getOrElse(K r3, Function0<Long> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        int r6 = findKeyIndex(r3);
        if (r6 < 0) goto L7;
        return this.values[r6];
    L7:
        return ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] r0 = this.keys;
        long[] r1 = this.values;
        long[] r15 = this.metadata;
        int r2 = r15.length - 2;
        int r3 = 0;
        if (r2 < 0) goto L25;
        int r4 = 0;
        int r5 = 0;
    L5:
        long r6 = r15[r4];
        if (((((~r6) << 7) & r6) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r8 = 8 - ((~(r4 - r2)) >>> 31);
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L20;
        if ((255 & r6) >= 128) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L19;
        int r12 = (r4 << 3) + r10;
        Object r13 = r0[r12];
        long r14 = r1[r12];
        if (r13 == null) goto L17;
        int r16 = r13.hashCode();
    L18:
        r5 = r5 + (r16 ^ Long.hashCode(r14));
        goto L19
    L17:
        r16 = 0;
    L19:
        r6 = r6 >> 8;
        r10 = r10 + 1;
        goto L8
    L12:
        r11 = false;
        goto L13
    L20:
        if (r8 == 8) goto L21;
        return r5;
    L21:
        if (r4 == r2) goto L23;
        r4 = r4 + 1;
        goto L5
    L23:
        r3 = r5;
    L25:
        return r3;
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

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r2, "truncated");
        StringBuilder r5 = new StringBuilder();
        r5.append(r3);
        Object[] r6 = this.keys;
        long[] r7 = this.values;
        long[] r0 = this.metadata;
        int r8 = r0.length - 2;
        if (r8 < 0) goto L28;
        int r9 = 0;
        int r10 = 0;
    L5:
        long r11 = r0[r9];
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r13 = 8 - ((~(r9 - r8)) >>> 31);
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L22;
        if ((r11 & 255) >= 128) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == false) goto L20;
        int r17 = (r9 << 3) + r15;
        Object r12 = r6[r17];
        long r18 = r7[r17];
        if (r10 == r24) goto L16;
        if (r10 == 0) goto L19;
        r5.append(r1);
    L19:
        r5.append(r12);
        r5.append('=');
        r5.append(r18);
        r10 = r10 + 1;
        int r19 = 8;
    L21:
        r11 = r11 >> r19;
        r15 = r15 + 1;
        r14 = r19;
        r0 = r0;
        goto L8
    L16:
        r5.append(r2);
    L29:
        String r20 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r19 = r14;
        goto L21
    L12:
        r16 = false;
        goto L13
    L22:
        long[] r110 = r0;
        if (r13 != r14) goto L28;
    L26:
        if (r9 == r8) goto L28;
        r9 = r9 + 1;
        r0 = r110;
        goto L5
    L25:
        r110 = r0;
    L28:
        r5.append(r4);
        goto L29
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, CharSequence r25, Function2<? super K, ? super Long, ? extends CharSequence> r26) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r26, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "truncated");
        Intrinsics.checkNotNullParameter(r6, "transform");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r27 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r27 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r27 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == r24) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r6.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r5);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r27 == r10) goto L29;
        r11 = r27 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r4);
        goto L30
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, int r24, Function2<? super K, ? super Long, ? extends CharSequence> r25) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r25, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "transform");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r26 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r26 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r26 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == r24) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r5.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r26 == r10) goto L29;
        r11 = r26 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r4);
        goto L30
    }

    public final String joinToString(CharSequence r21, CharSequence r22, CharSequence r23, Function2<? super K, ? super Long, ? extends CharSequence> r24) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r24, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "postfix");
        Intrinsics.checkNotNullParameter(r5, "transform");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r25 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r25 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r25 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == (-1)) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r5.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r25 == r10) goto L29;
        r11 = r25 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r4);
        goto L30
    }

    public final String joinToString(CharSequence r21, CharSequence r22, Function2<? super K, ? super Long, ? extends CharSequence> r23) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r23, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "transform");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r3);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r24 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r24 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r24 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == (-1)) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r4.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r24 == r10) goto L29;
        r11 = r24 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r5);
        goto L30
    }

    public final String joinToString(CharSequence r21, Function2<? super K, ? super Long, ? extends CharSequence> r22) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
        Function2 r3 = (Function2) ZeusTransformUtils.wrapperContextForParams(r22, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        Intrinsics.checkNotNullParameter(r3, "transform");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r4);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r23 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r23 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r23 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == (-1)) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r1);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r3.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r23 == r10) goto L29;
        r11 = r23 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r5);
        goto L30
    }

    public final String joinToString(Function2<? super K, ? super Long, ? extends CharSequence> r21) {
        Function2 r1 = (Function2) ZeusTransformUtils.wrapperContextForParams(r21, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "transform");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
        r7.append(r4);
        Object[] r8 = this.keys;
        long[] r9 = this.values;
        long[] r0 = this.metadata;
        int r10 = r0.length - 2;
        if (r10 < 0) goto L29;
        int r11 = 0;
        int r12 = 0;
    L5:
        long r13 = r0[r11];
        int r22 = r11;
        if (((((~r13) << 7) & r13) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r14 = 8;
        int r15 = 8 - ((~(r22 - r10)) >>> 31);
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L22;
        if ((r13 & 255) >= 128) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L20;
        int r18 = (r22 << 3) + r16;
        Object r19 = r8[r18];
        long r110 = r9[r18];
        if (r12 == (-1)) goto L16;
        if (r12 == 0) goto L19;
        r7.append(r3);
    L19:
        r7.append((CharSequence) ZeusTransformUtils.preCheckCast(r1.invoke(r19, Long.valueOf(r110)), CharSequence.class, "com.obric.memorydata.plugin"));
        r12 = r12 + 1;
        int r2 = 8;
    L21:
        r13 = r13 >> r2;
        r16 = r16 + 1;
        r14 = r2;
        r0 = r0;
        goto L8
    L16:
        r7.append(r6);
    L30:
        String r20 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "StringBuilder().apply(builderAction).toString()");
        return r20;
    L20:
        r2 = r14;
        goto L21
    L12:
        r17 = false;
        goto L13
    L22:
        long[] r111 = r0;
        if (r15 != r14) goto L29;
    L27:
        if (r22 == r10) goto L29;
        r11 = r22 + 1;
        r0 = r111;
        goto L5
    L25:
        r111 = r0;
    L29:
        r7.append(r5);
        goto L30
    }

    public final boolean none() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r1 = new StringBuilder().append('{');
        Object[] r2 = this.keys;
        long[] r3 = this.values;
        long[] r4 = this.metadata;
        int r5 = r4.length - 2;
        if (r5 < 0) goto L32;
        int r7 = 0;
        int r8 = 0;
    L9:
        long r9 = r4[r7];
        if (((((~r9) << 7) & r9) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L29;
        int r11 = 8 - ((~(r7 - r5)) >>> 31);
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L26;
        if ((255 & r9) >= 128) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L24;
        int r15 = (r7 << 3) + r13;
        Object r16 = r2[r15];
        int r17 = r7;
        long r6 = r3[r15];
        if (r16 != this) goto L21;
        r16 = "(this)";
    L21:
        r1.append(r16);
        r1.append("=");
        r1.append(r6);
        r8 = r8 + 1;
        if (r8 >= this._size) goto L25;
        r1.append(',').append(' ');
    L25:
        r9 = r9 >> 8;
        r13 = r13 + 1;
        r7 = r17;
        goto L12
    L24:
        r17 = r7;
        goto L25
    L16:
        r14 = false;
        goto L17
    L26:
        int r18 = r7;
        if (r11 != 8) goto L32;
        int r10 = r18;
    L30:
        if (r10 == r5) goto L32;
        r7 = r10 + 1;
        goto L9
    L29:
        r10 = r7;
    L32:
        String r0 = r1.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(r0, "s.append('}').toString()");
        return r0;
    }
}
