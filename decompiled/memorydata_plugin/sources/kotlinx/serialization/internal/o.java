package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u001e\u0010\u0005\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u0006H\u0000\u001aB\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042,\u0010\u0005\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"useClassValue", "", "createCache", "Lkotlinx/serialization/internal/SerializerCache;", ExifInterface.GPS_DIRECTION_TRUE, "factory", "Lkotlin/Function1;", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "createParametrizedCache", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "Lkotlin/Function2;", "", "", "Lkotlin/reflect/KType;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17806a = false;

    static {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(ZeusTransformUtils.forName("java.lang.ClassValue", "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r2) == false) goto L10;
        Result.Companion r3 = Result.Companion;
        Class r4 = (Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin");
        r2 = true;
    L10:
        Object r5 = Result.m1421constructorimpl(r2);
        if (Result.m1427isFailureimpl(r5) == false) goto L13;
        r5 = false;
    L13:
        f17806a = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final <T> bk<T> a(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends kotlinx.serialization.c<T>> r2) {
        Function2 r3 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "factory");
        if (f17806a == false) goto L5;
        Object r0 = new t(r3);
    L7:
        return (bk) ZeusTransformUtils.preCheckCast(r0, bk.class, "com.obric.memorydata.plugin");
    L5:
        r0 = new x(r3);
        goto L7
    }

    public static final <T> bx<T> a(Function1<? super KClass<?>, ? extends kotlinx.serialization.c<T>> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "factory");
        if (f17806a == false) goto L5;
        Object r0 = new s(r3);
    L7:
        return (bx) ZeusTransformUtils.preCheckCast(r0, bx.class, "com.obric.memorydata.plugin");
    L5:
        r0 = new w(r3);
        goto L7
    }
}
