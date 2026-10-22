package org.koin.dsl;

import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "R", "Lorg/koin/core/scope/a;", "Lvu/a;", LynxResourceModule.PARAMS_KEY, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScopeSetExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScopeSetExt.kt\norg/koin/dsl/ScopeSetExtKt$scoped$1\n*L\n1#1,50:1\n*E\n"})
public final class ScopeSetExtKt$scoped$1 extends Lambda implements Function2<a, vu.a, Object> {
    public static final ScopeSetExtKt$scoped$1 INSTANCE = null;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new ScopeSetExtKt$scoped$1();
    }

    public ScopeSetExtKt$scoped$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(a r5, vu.a r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$scoped");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.reifiedOperationMarker(4, "R");
        return org.koin.core.instance.a.b(r5, Reflection.getOrCreateKotlinClass(Object.class), r10);
    }
}
