package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"useClassValue", "", "createCache", "Lkotlin/reflect/jvm/internal/CacheByClass;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "compute", "Lkotlin/Function1;", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCacheByClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/CacheByClassKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
public final class CacheByClassKt {
    private static final boolean useClassValue = false;

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(Class.forName("java.lang.ClassValue"));     // Catch: Throwable -> L4
    L7:
        if (Result.m131isSuccessimpl(r10) == false) goto L9;
        Class r11 = (Class) r10;
        r10 = Boolean.TRUE;
    L9:
        Object r12 = Result.m124constructorimpl(r10);
        Boolean r13 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r12) == false) goto L12;
        r12 = r13;
    L12:
        ((Boolean) r12).getClass();
        return;
    L4:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final <V> CacheByClass<V> createCache(Function1<? super Class<?>, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "compute");
        return new ConcurrentHashMapCache(r5);
    }
}
