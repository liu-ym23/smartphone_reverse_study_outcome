package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LazyWrappedType extends WrappedType {
    private final Function0<KotlinType> computation;
    private final NotNullLazyValue<KotlinType> lazyValue;
    private final StorageManager storageManager;

    public static /* synthetic */ KotlinType accessor$LazyWrappedType$lambda0(KotlinTypeRefiner r0, LazyWrappedType r1) {
        return refine$lambda$0(r0, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public KotlinType getDelegate() {
        return (KotlinType) this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public LazyWrappedType refine(KotlinTypeRefiner r4) {
        Intrinsics.checkNotNullParameter(r4, "kotlinTypeRefiner");
        return new LazyWrappedType(this.storageManager, new LazyWrappedType$.Lambda.0(r4, this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
        return refine(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(StorageManager r2, Function0<? extends KotlinType> r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "computation");
        this.storageManager = r2;
        this.computation = r3;
        this.lazyValue = r2.createLazyValue(r3);
    }

    private static final KotlinType refine$lambda$0(KotlinTypeRefiner r1, LazyWrappedType r2) {
        Intrinsics.checkNotNullParameter(r1, "$kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r1.refineType((KotlinTypeMarker) r2.computation.invoke());
    }
}
