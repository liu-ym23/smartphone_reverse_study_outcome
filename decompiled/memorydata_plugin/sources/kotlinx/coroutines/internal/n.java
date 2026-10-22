package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a!\u0010\r\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0012\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0014\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0015"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", ExifInterface.LONGITUDE_EAST, "clz", "Ljava/lang/Class;", "safeCtor", "block", "tryCopyException", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f17587a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f17588b = null;

    static {
        f17587a = a(Throwable.class, -1);
    L9:
        k r1 = (k) ZeusTransformUtils.preCheckCast(au.f17573a, k.class, "com.obric.memorydata.plugin");
    L10:
        f17588b = r1;
        return;
    L4:
        if (p.a() == false) goto L7;
        Object r2 = au.f17573a;     // Catch: Throwable -> L9
        Class<k> r3 = k.class;
    L6:
        r1 = (k) ZeusTransformUtils.preCheckCast(r2, r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L10
    L7:
        r2 = c.f17576a;     // Catch: Throwable -> L9
        r3 = k.class;
        goto L6
    }

    private static final int a(Class<?> r3, int r4) {
        JvmClassMappingKt.getKotlinClass(r3);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(Integer.valueOf(a(r3, 0, 1, null)));     // Catch: Throwable -> L5
    L7:
        Integer r6 = Integer.valueOf(r4);
        if (Result.m1427isFailureimpl(r5) == false) goto L11;
        r5 = r6;
    L11:
        return ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    static /* synthetic */ int a(Class r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return b(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E a(E r3) {
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.af.class) == true) goto L14;
        Object r4 = f17588b.a(r3.getClass()).invoke(r3);
    L12:
        return (E) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin");
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        r4 = Result.m1421constructorimpl(((kotlinx.coroutines.af) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.af.class, "com.obric.memorydata.plugin")).createCopy());     // Catch: Throwable -> L6
    L9:
        if (Result.m1427isFailureimpl(r4) == false) goto L12;
        r4 = null;
    L6:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final /* synthetic */ Function1 a(Class r0) {
        return b(r0);
    }

    private static final Function1<Throwable, Throwable> a(Function1<? super Throwable, ? extends Throwable> r2) {
        final Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        return (Function1) ZeusTransformUtils.preCheckCast(new ExceptionsConstructorKt$safeCtor$1(r3), Function1.class, "com.obric.memorydata.plugin");
    }

    private static final int b(Class<?> r5, int r6) {
    L2:
        Field[] r0 = r5.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if ((!Modifier.isStatic(r0[r2].getModifiers())) == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r6 = r6 + r3;
        r5 = r5.getSuperclass();
        if (r5 != null) goto L2;
        return r6;
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> b(Class<E> r13) {
        Function1<Throwable, Throwable> r0 = (Function1) ZeusTransformUtils.preCheckCast(ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        if (f17587a == a(r13, 0)) goto L5;
        return r0;
    L5:
        Constructor<?>[] r14 = r13.getConstructors();
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.length), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r14.length;
        int r5 = 0;
    L6:
        Object r6 = null;
        if (r5 >= r4) goto L27;
        final Constructor<?> r7 = r14[r5];
        Class<?>[] r8 = r7.getParameterTypes();
        int r9 = r8.length;
        if (r9 != 0) goto L11;
        r6 = a((Function1) ZeusTransformUtils.preCheckCast(new ExceptionsConstructorKt$createConstructor$1$4(r7), Function1.class, "com.obric.memorydata.plugin"));
        int r10 = 0;
    L26:
        r1.add(TuplesKt.to(r6, r10));
        r5 = r5 + 1;
        goto L6
    L11:
        if (r9 == 1) goto L19;
        if (r9 == 2) goto L15;
    L13:
        r10 = -1;
        goto L26
    L15:
        if (Intrinsics.areEqual(r8[0], String.class) == false) goto L13;
        if (Intrinsics.areEqual(r8[1], Throwable.class) == false) goto L13;
        r6 = a((Function1) ZeusTransformUtils.preCheckCast(new ExceptionsConstructorKt$createConstructor$1$1(r7), Function1.class, "com.obric.memorydata.plugin"));
        r10 = 3;
        goto L26
    L19:
        Class<?> r11 = r8[0];
        if (Intrinsics.areEqual(r11, String.class) == false) goto L23;
        r6 = a((Function1) ZeusTransformUtils.preCheckCast(new ExceptionsConstructorKt$createConstructor$1$2(r7), Function1.class, "com.obric.memorydata.plugin"));
        r10 = 2;
        goto L26
    L23:
        if (Intrinsics.areEqual(r11, Throwable.class) == false) goto L13;
        r6 = a((Function1) ZeusTransformUtils.preCheckCast(new ExceptionsConstructorKt$createConstructor$1$3(r7), Function1.class, "com.obric.memorydata.plugin"));
        r10 = 1;
        goto L26
    L27:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r15.hasNext() == false) goto L39;
        r6 = r15.next();
        if (r15.hasNext() == false) goto L39;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue();
    L34:
        Object r3 = r15.next();
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r2 >= r12) goto L38;
        r6 = r3;
        r2 = r12;
    L38:
        if (r15.hasNext() == true) goto L34;
    L39:
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r6, Pair.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L54;
        Function1<Throwable, Throwable> r17 = (Function1) ZeusTransformUtils.preCheckCast(r16.getFirst(), Function1.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L45;
        return r0;
    L45:
        return r17;
    L54:
        return r0;
    }
}
