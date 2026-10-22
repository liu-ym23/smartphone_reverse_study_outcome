package androidx.collection;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J:\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0086\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0003J:\u0010\u001f\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010 \u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u0003J9\u0010\"\u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u00032!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00180\u0017H\u0086\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010&\u001a\u00020\u0018J:\u0010&\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001Jb\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H(0+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u0010.\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H(0/H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100Jb\u00101\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H(0+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u00102\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H(0/H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100J:\u00103\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00106\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00107\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00108\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040+H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u00109\u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u0003H\u0086\u0002J\b\u0010:\u001a\u00020\u0003H\u0016J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J:\u0010<\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010>\u001a\u00020\u0015J\u0006\u0010?\u001a\u00020\u0015J:\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020CH\u0007JT\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020C2\u0014\b\u0004\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020C0\u0017H\u0087\bø\u0001\u0000J\u0006\u0010I\u001a\u00020\u0018J:\u0010I\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010J\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010K\u001a\u00020\u0015J:\u0010L\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010M\u001a\u00020AH\u0016R\u0018\u0010\u0005\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0001\u0001N\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, d2 = {"Landroidx/collection/LongList;", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", Params.CONTENT, "", "getContent$annotations", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "element", "contains", "containsAll", "elements", CommonConsts.COUNT_TYPE, "elementAt", "index", "elementAtOrElse", "defaultValue", "equals", "other", "first", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "none", "reversedAny", "toString", "Landroidx/collection/MutableLongList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongList {
    public int _size;
    public long[] content;

    private LongList(int r1) {
        if (r1 != 0) goto L5;
        long[] r2 = LongSetKt.getEmptyLongArray();
    L6:
        this.content = r2;
        return;
    L5:
        r2 = new long[r1];
        goto L6
    }

    public /* synthetic */ LongList(int r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(LongList r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, int r14, Object r15) {
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

    public static /* synthetic */ String joinToString$default(LongList r4, CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9, Function1 r10, int r11, Object r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r16 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L31;
        if ((r11 & 1) == 0) goto L8;
        r13 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        if ((r11 & 2) == 0) goto L11;
        r14 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L11:
        if ((r11 & 4) == 0) goto L14;
        r15 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        if ((r11 & 8) == 0) goto L17;
        r8 = -1;
    L17:
        if ((r11 & 16) == 0) goto L19;
        r16 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
    L19:
        Intrinsics.checkNotNullParameter(r13, "separator");
        Intrinsics.checkNotNullParameter(r14, "prefix");
        Intrinsics.checkNotNullParameter(r15, "postfix");
        Intrinsics.checkNotNullParameter(r16, "truncated");
        Intrinsics.checkNotNullParameter(r17, "transform");
        StringBuilder r18 = new StringBuilder();
        r18.append(r14);
        long[] r19 = r4.content;
        int r110 = 0;
        int r20 = r4._size;
    L20:
        if (r110 >= r20) goto L27;
        long r2 = r19[r110];
        if (r110 == r8) goto L23;
        if (r110 == 0) goto L26;
        r18.append(r13);
    L26:
        r18.append((CharSequence) ZeusTransformUtils.preCheckCast(r17.invoke(Long.valueOf(r2)), CharSequence.class, "com.obric.memorydata.plugin"));
        r110 = r110 + 1;
        goto L20
    L23:
        r18.append(r16);
    L28:
        String r21 = r18.toString();
        Intrinsics.checkNotNullExpressionValue(r21, "StringBuilder().apply(builderAction).toString()");
        return r21;
    L27:
        r18.append(r15);
        goto L28
    L31:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean any(Function1<? super Long, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        long[] r0 = this.content;
        int r6 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r6) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(Long.valueOf(r0[r3])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean contains(long r6) {
        long[] r0 = this.content;
        int r5 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L9;
        if (r0[r2] == r6) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final boolean containsAll(LongList r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        IntRange r0 = RangesKt.until(0, r6._size);
        int r2 = r0.getFirst();
        int r1 = r0.getLast();
        if (r2 <= r1) goto L5;
        return true;
    L5:
        if (contains(r6.get(r2)) == false) goto L6;
        if (r2 == r1) goto L13;
        r2 = r2 + 1;
        goto L5
    L13:
        return true;
    L6:
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super Long, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        long[] r0 = this.content;
        int r6 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r6) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(Long.valueOf(r0[r2])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public final long elementAt(int r5) {
        boolean r1 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return this.content[r5];
    L11:
        throw new IndexOutOfBoundsException("Index " + r5 + " must be in 0.." + (this._size - 1));
    L5:
        if (r5 >= this._size) goto L7;
        r1 = true;
        goto L7
    }

    public final long elementAtOrElse(int r4, Function1<? super Integer, Long> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "defaultValue");
        boolean r0 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return ((Number) ZeusTransformUtils.preCheckCast(r6.invoke(Integer.valueOf(r4)), Number.class, "com.obric.memorydata.plugin")).longValue();
    L11:
        return this.content[r4];
    L5:
        if (r4 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public boolean equals(Object r9) {
        if (ZeusTransformUtils.instanceOf(r9, LongList.class) == true) goto L5;
    L16:
        return false;
    L5:
        if (((LongList) ZeusTransformUtils.preCheckCast(r9, LongList.class, "com.obric.memorydata.plugin"))._size != this._size) goto L16;
        long[] r3 = this.content;
        long[] r10 = ((LongList) ZeusTransformUtils.preCheckCast(r9, LongList.class, "com.obric.memorydata.plugin")).content;
        IntRange r8 = RangesKt.until(0, this._size);
        int r0 = r8.getFirst();
        int r11 = r8.getLast();
        if (r0 <= r11) goto L10;
        return true;
    L10:
        if (r3[r0] != r10[r0]) goto L11;
        if (r0 == r11) goto L19;
        r0 = r0 + 1;
        goto L10
    L19:
        return true;
    L11:
        return false;
    }

    public final long first() {
        if (isEmpty() == true) goto L7;
        return this.content[0];
    L7:
        throw new NoSuchElementException("LongList is empty.");
    }

    public final long first(Function1<? super Long, Boolean> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "predicate");
        long[] r0 = this.content;
        int r7 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L9;
        long r3 = r0[r2];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(Long.valueOf(r3)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final <R> R fold(R r5, Function2<? super R, ? super Long, ? extends R> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "operation");
        long[] r0 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        R r8 = r5;
        r5 = (R) r7.invoke(r8, Long.valueOf(r0[r1]));
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public final <R> R foldIndexed(R r6, Function3<? super Integer, ? super R, ? super Long, ? extends R> r7) {
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "operation");
        long[] r0 = this.content;
        int r5 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        long r2 = r0[r1];
        R r9 = r6;
        r6 = (R) r8.invoke(Integer.valueOf(r1), r9, Long.valueOf(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        return r6;
    }

    public final <R> R foldRight(R r4, Function2<? super Long, ? super R, ? extends R> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "operation");
        long[] r0 = this.content;
        int r3 = this._size;
    L3:
        r3 = r3 - 1;
        if ((-1) >= r3) goto L6;
        r4 = (R) r6.invoke(Long.valueOf(r0[r3]), r4);
        goto L3
    L6:
        return r4;
    }

    public final <R> R foldRightIndexed(R r5, Function3<? super Integer, ? super Long, ? super R, ? extends R> r6) {
        Function3 r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "operation");
        long[] r0 = this.content;
        int r4 = this._size;
    L3:
        r4 = r4 - 1;
        if ((-1) >= r4) goto L6;
        r5 = (R) r7.invoke(Integer.valueOf(r4), Long.valueOf(r0[r4]), r5);
        goto L3
    L6:
        return r5;
    }

    public final void forEach(Function1<? super Long, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "block");
        long[] r0 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r6.invoke(Long.valueOf(r0[r1]));
        r1 = r1 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super Long, Unit> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "block");
        long[] r0 = this.content;
        int r5 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r7.invoke(Integer.valueOf(r1), Long.valueOf(r0[r1]));
        r1 = r1 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super Long, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "block");
        long[] r0 = this.content;
        int r3 = this._size;
    L3:
        r3 = r3 - 1;
        if ((-1) >= r3) goto L6;
        r5.invoke(Long.valueOf(r0[r3]));
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super Long, Unit> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "block");
        long[] r0 = this.content;
        int r4 = this._size;
    L3:
        r4 = r4 - 1;
        if ((-1) >= r4) goto L6;
        r6.invoke(Integer.valueOf(r4), Long.valueOf(r0[r4]));
        goto L3
    }

    public final long get(int r5) {
        boolean r1 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return this.content[r5];
    L11:
        throw new IndexOutOfBoundsException("Index " + r5 + " must be in 0.." + (this._size - 1));
    L5:
        if (r5 >= this._size) goto L7;
        r1 = true;
        goto L7
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] r0 = this.content;
        int r5 = this._size;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r2 = r2 + (Long.hashCode(r0[r1]) * 31);
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public final int indexOf(long r5) {
        long[] r0 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L8;
        if (r5 == r0[r1]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    public final int indexOfFirst(Function1<? super Long, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        long[] r0 = this.content;
        int r5 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Long.valueOf(r0[r2])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super Long, Boolean> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        long[] r0 = this.content;
        int r4 = this._size;
    L3:
        r4 = r4 - 1;
        if ((-1) >= r4) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(Long.valueOf(r0[r4])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L3;
        return r4;
    L9:
        return -1;
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

    public final String joinToString(CharSequence r5, CharSequence r6, CharSequence r7, int r8, CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "separator");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        Intrinsics.checkNotNullParameter(r12, "postfix");
        Intrinsics.checkNotNullParameter(r13, "truncated");
        StringBuilder r0 = new StringBuilder();
        r0.append(r11);
        long[] r14 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L10;
        long r2 = r14[r1];
        if (r1 == r8) goto L6;
        if (r1 == 0) goto L9;
        r0.append(r10);
    L9:
        r0.append(r2);
        r1 = r1 + 1;
        goto L3
    L6:
        r0.append(r13);
    L11:
        String r15 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    L10:
        r0.append(r12);
        goto L11
    }

    public final String joinToString(CharSequence r6, CharSequence r7, CharSequence r8, int r9, CharSequence r10, Function1<? super Long, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        Intrinsics.checkNotNullParameter(r16, "transform");
        StringBuilder r0 = new StringBuilder();
        r0.append(r13);
        long[] r17 = this.content;
        int r5 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L10;
        long r3 = r17[r2];
        if (r2 == r9) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r12);
    L9:
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r16.invoke(Long.valueOf(r3)), CharSequence.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L3
    L6:
        r0.append(r15);
    L11:
        String r18 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L10:
        r0.append(r14);
        goto L11
    }

    public final String joinToString(CharSequence r7, CharSequence r8, CharSequence r9, int r10, Function1<? super Long, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r15, "transform");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder();
        r2.append(r13);
        long[] r16 = this.content;
        int r6 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r6) goto L10;
        long r4 = r16[r3];
        if (r3 == r10) goto L6;
        if (r3 == 0) goto L9;
        r2.append(r12);
    L9:
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r15.invoke(Long.valueOf(r4)), CharSequence.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L3
    L6:
        r2.append(r0);
    L11:
        String r17 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    L10:
        r2.append(r14);
        goto L11
    }

    public final String joinToString(CharSequence r8, CharSequence r9, CharSequence r10, Function1<? super Long, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r15, "transform");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder();
        r2.append(r13);
        long[] r16 = this.content;
        int r7 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r7) goto L10;
        long r4 = r16[r3];
        if (r3 == (-1)) goto L6;
        if (r3 == 0) goto L9;
        r2.append(r12);
    L9:
        r2.append((CharSequence) ZeusTransformUtils.preCheckCast(r15.invoke(Long.valueOf(r4)), CharSequence.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L3
    L6:
        r2.append(r0);
    L11:
        String r17 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    L10:
        r2.append(r14);
        goto L11
    }

    public final String joinToString(CharSequence r9, CharSequence r10, Function1<? super Long, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "transform");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
        r3.append(r13);
        long[] r15 = this.content;
        int r8 = this._size;
        int r4 = 0;
    L3:
        if (r4 >= r8) goto L10;
        long r5 = r15[r4];
        if (r4 == (-1)) goto L6;
        if (r4 == 0) goto L9;
        r3.append(r12);
    L9:
        r3.append((CharSequence) ZeusTransformUtils.preCheckCast(r14.invoke(Long.valueOf(r5)), CharSequence.class, "com.obric.memorydata.plugin"));
        r4 = r4 + 1;
        goto L3
    L6:
        r3.append(r2);
    L11:
        String r16 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    L10:
        r3.append(r0);
        goto L11
    }

    public final String joinToString(CharSequence r10, Function1<? super Long, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "transform");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder();
        r4.append(r0);
        long[] r1 = this.content;
        int r9 = this._size;
        int r5 = 0;
    L3:
        if (r5 >= r9) goto L10;
        long r6 = r1[r5];
        if (r5 == (-1)) goto L6;
        if (r5 == 0) goto L9;
        r4.append(r12);
    L9:
        r4.append((CharSequence) ZeusTransformUtils.preCheckCast(r13.invoke(Long.valueOf(r6)), CharSequence.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L3
    L6:
        r4.append(r3);
    L11:
        String r14 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "StringBuilder().apply(builderAction).toString()");
        return r14;
    L10:
        r4.append(r2);
        goto L11
    }

    public final String joinToString(Function1<? super Long, ? extends CharSequence> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "transform");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder();
        r5.append(r2);
        long[] r6 = this.content;
        int r10 = this._size;
        int r7 = 0;
    L3:
        if (r7 >= r10) goto L10;
        long r8 = r6[r7];
        if (r7 == (-1)) goto L6;
        if (r7 == 0) goto L9;
        r5.append(r0);
    L9:
        r5.append((CharSequence) ZeusTransformUtils.preCheckCast(r12.invoke(Long.valueOf(r8)), CharSequence.class, "com.obric.memorydata.plugin"));
        r7 = r7 + 1;
        goto L3
    L6:
        r5.append(r4);
    L11:
        String r13 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        return r13;
    L10:
        r5.append(r3);
        goto L11
    }

    public final long last() {
        if (isEmpty() == true) goto L7;
        return this.content[this._size - 1];
    L7:
        throw new NoSuchElementException("LongList is empty.");
    }

    public final long last(Function1<? super Long, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        long[] r0 = this.content;
        int r6 = this._size;
    L3:
        r6 = r6 - 1;
        if ((-1) >= r6) goto L10;
        long r2 = r0[r6];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(Long.valueOf(r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L3;
        return r2;
    L10:
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final int lastIndexOf(long r4) {
        long[] r0 = this.content;
        int r3 = this._size;
    L3:
        r3 = r3 - 1;
        if ((-1) >= r3) goto L9;
        if (r0[r3] != r4) goto L3;
        return r3;
    L9:
        return -1;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(Function1<? super Long, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        long[] r0 = this.content;
        int r5 = this._size - 1;
    L4:
        if ((-1) >= r5) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Long.valueOf(r0[r5])), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        r5 = r5 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, 25, null);
    }
}
