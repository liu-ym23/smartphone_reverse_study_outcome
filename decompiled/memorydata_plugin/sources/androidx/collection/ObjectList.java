package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J:\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0019\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010#J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000$J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010%\u001a\u00020\u0004J:\u0010%\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0015\u0010&\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J>\u0010)\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u00042!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u000b\u0010.\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010.\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010/JA\u00101\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100Jb\u00102\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H306H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u00109\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H30:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;Jb\u0010<\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H306H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u0010=\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H30:H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;J:\u0010>\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010A\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?06H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010B\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?0\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010C\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?06H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0018\u0010D\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010(J\b\u0010E\u001a\u00020\u0004H\u0016J\u0013\u0010F\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ:\u0010H\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010J\u001a\u00020\u0017J\u0006\u0010K\u001a\u00020\u0017JR\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020O2\b\b\u0002\u0010Q\u001a\u00020O2\b\b\u0002\u0010R\u001a\u00020\u00042\b\b\u0002\u0010S\u001a\u00020O2\u0016\b\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020O\u0018\u00010\u0019H\u0007J\u000b\u0010U\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010U\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0013\u0010V\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ\u0010\u0010W\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010/JA\u0010W\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0006\u0010X\u001a\u00020\u0017J:\u0010Y\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010Z\u001a\u00020MH\u0016R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000b\u0010\bR\u0012\u0010\r\u001a\u00020\u000e8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u0082\u0001\u0001[\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\\"}, d2 = {"Landroidx/collection/ObjectList;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", Params.CONTENT, "", "getContent$annotations", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "element", "asList", "", "contains", "(Ljava/lang/Object;)Z", "containsAll", "elements", "([Ljava/lang/Object;)Z", "", CommonConsts.COUNT_TYPE, "elementAt", "index", "(I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "equals", "other", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "lastOrNull", "none", "reversedAny", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    private ObjectList(int r1) {
        if (r1 != 0) goto L5;
        Object[] r2 = ObjectListKt.access$getEmptyArray$p();
    L6:
        this.content = r2;
        return;
    L5:
        r2 = new Object[r1];
        goto L6
    }

    public /* synthetic */ ObjectList(int r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectList r8, CharSequence r9, CharSequence r10, CharSequence r11, int r12, CharSequence r13, Function1 r14, int r15, Object r16) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Function1<? super E, ? extends CharSequence> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L26;
        if ((r15 & 1) == 0) goto L8;
        r0 = (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin");
    L8:
        if ((r15 & 2) == 0) goto L11;
        r2 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L11:
        if ((r15 & 4) == 0) goto L14;
        r3 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        if ((r15 & 8) == 0) goto L16;
        int r6 = -1;
    L18:
        if ((r15 & 16) == 0) goto L21;
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast("...", CharSequence.class, "com.obric.memorydata.plugin");
    L21:
        if ((r15 & 32) == 0) goto L24;
        r5 = null;
    L24:
        return r8.joinToString(r0, r2, r3, r6, r4, r5);
    L16:
        r6 = r12;
        goto L18
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean any(Function1<? super E, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.content;
        int r6 = this._size;
        int r3 = 0;
    L3:
        if (r3 >= r6) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r0[r3]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public abstract List<E> asList();

    public final boolean contains(E r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Object[] r0 = r5.content;
        int r6 = r5._size;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        if (contains(r0[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "elements");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (contains(r5.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(List<? extends E> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (contains(r6.get(r2)) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final boolean containsAll(E[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (contains(r5[r2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super E, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.content;
        int r6 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r6) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r0[r2]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public final E elementAt(int r5) {
        boolean r1 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return (E) this.content[r5];
    L11:
        throw new IndexOutOfBoundsException("Index " + r5 + " must be in 0.." + (this._size - 1));
    L5:
        if (r5 >= this._size) goto L7;
        r1 = true;
        goto L7
    }

    public final E elementAtOrElse(int r3, Function1<? super Integer, ? extends E> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultValue");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return (E) r5.invoke(Integer.valueOf(r3));
    L11:
        return (E) this.content[r3];
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, ObjectList.class) == true) goto L5;
    L16:
        return false;
    L5:
        if (((ObjectList) ZeusTransformUtils.preCheckCast(r6, ObjectList.class, "com.obric.memorydata.plugin"))._size != this._size) goto L16;
        Object[] r3 = this.content;
        Object[] r7 = ((ObjectList) ZeusTransformUtils.preCheckCast(r6, ObjectList.class, "com.obric.memorydata.plugin")).content;
        IntRange r5 = RangesKt.until(0, this._size);
        int r0 = r5.getFirst();
        int r8 = r5.getLast();
        if (r0 <= r8) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r3[r0], r7[r0]) == false) goto L11;
        if (r0 == r8) goto L19;
        r0 = r0 + 1;
        goto L10
    L19:
        return true;
    L11:
        return false;
    }

    public final E first() {
        if (isEmpty() == true) goto L7;
        return (E) this.content[0];
    L7:
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final E first(Function1<? super E, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.content;
        int r6 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        E r3 = (E) r0[r2];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return get(0);
    }

    public final E firstOrNull(Function1<? super E, Boolean> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Object[] r0 = this.content;
        int r6 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        E r3 = (E) r0[r2];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public final <R> R fold(R r4, Function2<? super R, ? super E, ? extends R> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "operation");
        Object[] r0 = this.content;
        int r3 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        R r7 = r4;
        r4 = (R) r6.invoke(r7, r0[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    public final <R> R foldIndexed(R r5, Function3<? super Integer, ? super R, ? super E, ? extends R> r6) {
        Function3 r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "operation");
        Object[] r0 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        Object r2 = r0[r1];
        r5 = (R) r7.invoke(Integer.valueOf(r1), r5, r2);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public final <R> R foldRight(R r3, Function2<? super E, ? super R, ? extends R> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "operation");
        Object[] r0 = this.content;
        int r2 = this._size;
    L3:
        r2 = r2 - 1;
        if ((-1) >= r2) goto L6;
        r3 = (R) r5.invoke(r0[r2], r3);
        goto L3
    L6:
        return r3;
    }

    public final <R> R foldRightIndexed(R r4, Function3<? super Integer, ? super E, ? super R, ? extends R> r5) {
        Function3 r6 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "operation");
        Object[] r0 = this.content;
        int r3 = this._size;
    L3:
        r3 = r3 - 1;
        if ((-1) >= r3) goto L6;
        r4 = (R) r6.invoke(Integer.valueOf(r3), r0[r3], r4);
        goto L3
    L6:
        return r4;
    }

    public final void forEach(Function1<? super E, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "block");
        Object[] r0 = this.content;
        int r3 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r5.invoke(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void forEachIndexed(Function2<? super Integer, ? super E, Unit> r5) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "block");
        Object[] r0 = this.content;
        int r4 = this._size;
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r6.invoke(Integer.valueOf(r1), r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void forEachReversed(Function1<? super E, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        Object[] r0 = this.content;
        int r2 = this._size;
    L3:
        r2 = r2 - 1;
        if ((-1) >= r2) goto L6;
        r4.invoke(r0[r2]);
        goto L3
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super E, Unit> r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "block");
        Object[] r0 = this.content;
        int r3 = this._size;
    L3:
        r3 = r3 - 1;
        if ((-1) >= r3) goto L6;
        r5.invoke(Integer.valueOf(r3), r0[r3]);
        goto L3
    }

    public final E get(int r5) {
        boolean r1 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r1 == false) goto L11;
        return (E) this.content[r5];
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
        Object[] r0 = this.content;
        int r5 = this._size;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r5) goto L9;
        Object r4 = r0[r2];
        if (r4 == null) goto L7;
        int r6 = r4.hashCode();
    L8:
        r3 = r3 + (r6 * 31);
        r2 = r2 + 1;
        goto L3
    L7:
        r6 = 0;
        goto L8
    L9:
        return r3;
    }

    public final int indexOf(E r4) {
        int r0 = 0;
        if (r4 != null) goto L10;
        Object[] r5 = this.content;
        int r3 = this._size;
    L5:
        if (r0 >= r3) goto L16;
        if (r5[r0] == null) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return r0;
    L16:
        return -1;
    L10:
        Object[] r1 = this.content;
        int r6 = this._size;
    L11:
        if (r0 >= r6) goto L22;
        if (r4.equals(r1[r0]) == true) goto L14;
        r0 = r0 + 1;
        goto L11
    L14:
        return r0;
    L22:
        return -1;
    }

    public final int indexOfFirst(Function1<? super E, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        Object[] r0 = this.content;
        int r5 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r0[r2]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -1;
    }

    public final int indexOfLast(Function1<? super E, Boolean> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Object[] r0 = this.content;
        int r4 = this._size;
    L3:
        r4 = r4 - 1;
        if ((-1) >= r4) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(r0[r4]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L3;
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
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final String joinToString(CharSequence r10) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "separator");
        return joinToString$default(this, r1, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        return joinToString$default(this, r3, r4, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14, int r15) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        return joinToString$default(this, r3, r4, r5, r15, null, null, 48, null);
    }

    public final String joinToString(CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r12, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "separator");
        Intrinsics.checkNotNullParameter(r4, "prefix");
        Intrinsics.checkNotNullParameter(r5, "postfix");
        Intrinsics.checkNotNullParameter(r7, "truncated");
        return joinToString$default(this, r3, r4, r5, r15, r7, null, 32, null);
    }

    public final String joinToString(CharSequence r6, CharSequence r7, CharSequence r8, int r9, CharSequence r10, Function1<? super E, ? extends CharSequence> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        StringBuilder r0 = new StringBuilder();
        r0.append(r13);
        Object[] r17 = this.content;
        int r5 = this._size;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L13;
        Object r3 = r17[r2];
        if (r2 == r9) goto L6;
        if (r2 == 0) goto L9;
        r0.append(r12);
    L9:
        if (r16 != null) goto L11;
        r0.append(r3);
    L12:
        r2 = r2 + 1;
        goto L3
    L11:
        r0.append((CharSequence) ZeusTransformUtils.preCheckCast(r16.invoke(r3), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L12
    L6:
        r0.append(r15);
    L14:
        String r18 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder().apply(builderAction).toString()");
        return r18;
    L13:
        r0.append(r14);
        goto L14
    }

    public final E last() {
        if (isEmpty() == true) goto L7;
        return (E) this.content[this._size - 1];
    L7:
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final E last(Function1<? super E, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        Object[] r0 = this.content;
        int r5 = this._size;
    L3:
        r5 = r5 - 1;
        if ((-1) >= r5) goto L10;
        E r2 = (E) r0[r5];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L3;
        return r2;
    L10:
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final int lastIndexOf(E r4) {
        if (r4 != null) goto L10;
        Object[] r5 = this.content;
        int r3 = this._size - 1;
    L5:
        if ((-1) >= r3) goto L16;
        if (r5[r3] == null) goto L8;
        r3 = r3 - 1;
        goto L5
    L8:
        return r3;
    L16:
        return -1;
    L10:
        Object[] r1 = this.content;
        int r6 = this._size - 1;
    L11:
        if ((-1) >= r6) goto L16;
        if (r4.equals(r1[r6]) == true) goto L14;
        r6 = r6 - 1;
        goto L11
    L14:
        return r6;
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.content[this._size - 1];
    }

    public final E lastOrNull(Function1<? super E, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        Object[] r0 = this.content;
        int r5 = this._size;
    L3:
        r5 = r5 - 1;
        if ((-1) >= r5) goto L9;
        E r2 = (E) r0[r5];
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L3;
        return r2;
    L9:
        return null;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(Function1<? super E, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "predicate");
        Object[] r0 = this.content;
        int r5 = this._size - 1;
    L4:
        if ((-1) >= r5) goto L9;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(r0[r5]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        r5 = r5 - 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"), 25, null);
    }
}
