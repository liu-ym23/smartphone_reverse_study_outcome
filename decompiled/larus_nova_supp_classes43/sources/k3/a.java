package k3;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final <T extends BaseModel> T a(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (T) c.a(r1);
    }

    public static final <T extends BaseModel> T b(KClass<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = c.a;
        return (T) c.a(JvmClassMappingKt.getJavaClass(r1));
    }
}
