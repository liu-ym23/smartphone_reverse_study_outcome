package d4;

import c4.d;
import com.bytedance.news.common.service.manager.IService;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final <T extends IService> T a(KClass<T> r10) {
        Intrinsics.checkParameterIsNotNull(r10, "receiver$0");
        return (T) d.a(JvmClassMappingKt.getJavaClass(r10));
    }
}
