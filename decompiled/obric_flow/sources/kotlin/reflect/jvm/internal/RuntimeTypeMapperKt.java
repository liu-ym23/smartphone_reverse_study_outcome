package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String access$getSignature(Method r5) {
        return getSignature(r5);
    }

    private static final String getSignature(Method r10) {
        return r10.getName() + ArraysKt.l(r10.getParameterTypes(), "", "(", ")", RuntimeTypeMapperKt$signature$1.INSTANCE, 24) + ReflectClassUtilKt.getDesc(r10.getReturnType());
    }
}
