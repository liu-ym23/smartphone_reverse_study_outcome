package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class KDeclarationContainerImpl$Data {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazySoftVal moduleData$delegate;
    final /* synthetic */ KDeclarationContainerImpl this$0;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KDeclarationContainerImpl$Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
    }

    public static /* synthetic */ RuntimeModuleData accessor$KDeclarationContainerImpl$Data$lambda0(KDeclarationContainerImpl r0) {
        return moduleData_delegate$lambda$0(r0);
    }

    public final RuntimeModuleData getModuleData() {
        return (RuntimeModuleData) this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public KDeclarationContainerImpl$Data(final KDeclarationContainerImpl r2) {
        this.this$0 = r2;
        this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$$Lambda$0(r2));
    }

    private static final RuntimeModuleData moduleData_delegate$lambda$0(KDeclarationContainerImpl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return ModuleByClassLoaderKt.getOrCreateModule(r1.getJClass());
    }
}
