package d38;

import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends c38.b {
    public final KClass<? extends Annotation> a;

    public b() {
        this.a = Reflection.getOrCreateKotlinClass(SdkCall.class);
    }

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.a;
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        return new com.larksuite.rucket.impl.sdkimpl.proxymethod.b(r2);
    }
}
