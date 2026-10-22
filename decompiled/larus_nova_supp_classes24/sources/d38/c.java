package d38;

import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends c38.b {
    public final l a;
    public final KClass<? extends Annotation> b;

    @Override // c38.b
    public final KClass<? extends Annotation> a() {
        return this.b;
    }

    public c(l r2) {
        Intrinsics.checkNotNullParameter(r2, "client");
        this.a = r2;
        this.b = Reflection.getOrCreateKotlinClass(SdkPush.class);
    }

    @Override // c38.b
    public final com.larksuite.rucket.core.proxymethod.a b(Method r3) {
        Intrinsics.checkNotNullParameter(r3, "origin");
        return new com.larksuite.rucket.impl.sdkimpl.proxymethod.c(this.a, r3);
    }
}
