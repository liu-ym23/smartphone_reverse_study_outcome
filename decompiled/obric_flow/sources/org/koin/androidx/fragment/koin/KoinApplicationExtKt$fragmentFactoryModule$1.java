package org.koin.androidx.fragment.koin;

import androidx.fragment.app.FragmentFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.definition.Kind;
import org.koin.core.instance.e;
import uu.a;
import wu.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Luu/a;", "", "invoke", "(Luu/a;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nKoinApplicationExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KoinApplicationExt.kt\norg/koin/androidx/fragment/koin/KoinApplicationExtKt$fragmentFactoryModule$1\n+ 2 Module.kt\norg/koin/core/module/Module\n+ 3 Module.kt\norg/koin/core/module/ModuleKt\n+ 4 BeanDefinition.kt\norg/koin/core/definition/BeanDefinitionKt\n*L\n1#1,34:1\n103#2,6:35\n109#2,5:62\n200#3,6:41\n206#3:61\n105#4,14:47\n*S KotlinDebug\n*F\n+ 1 KoinApplicationExt.kt\norg/koin/androidx/fragment/koin/KoinApplicationExtKt$fragmentFactoryModule$1\n*L\n25#1:35,6\n25#1:62,5\n25#1:41,6\n25#1:61\n25#1:47,14\n*E\n"})
final class KoinApplicationExtKt$fragmentFactoryModule$1 extends Lambda implements Function1<a, Unit> {
    public static final KoinApplicationExtKt$fragmentFactoryModule$1 INSTANCE = null;

    static {
        INSTANCE = new KoinApplicationExtKt$fragmentFactoryModule$1();
    }

    public KoinApplicationExtKt$fragmentFactoryModule$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$module");
        AnonymousClass1 r5 = AnonymousClass1.INSTANCE;
        b r11 = org.koin.core.registry.a.e;
        Kind r12 = Kind.Singleton;
        List r13 = CollectionsKt.emptyList();
        org.koin.core.definition.a r14 = new org.koin.core.definition.a(r11, Reflection.getOrCreateKotlinClass(FragmentFactory.class), null, r5, r12, r13);
        Intrinsics.checkNotNullParameter(r14, "beanDefinition");
        e r15 = new e(r14);
        r10.a(r15);
        if (r10.f22467a == false) goto L5;
        r10.b(r15);
    L5:
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r15, "factory");
    }
}
