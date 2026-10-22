package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class KMutableProperty1Impl<T, V> extends KProperty1Impl<T, V> implements KMutableProperty1<T, V> {
    private final ReflectProperties.LazyVal<Setter<T, V>> _setter;

    public static final class Setter<T, V> extends KPropertyImpl.Setter<V> implements KMutableProperty1.Setter<T, V> {
        private final KMutableProperty1Impl<T, V> property;

        public Setter(KMutableProperty1Impl<T, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty1Impl<T, V> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object r10, Object r11) {
            invoke2(r10, r11);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(T r10, V r11) {
            getProperty().set(r10, r11);
        }
    }

    public KMutableProperty1Impl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12, r13);
        ReflectProperties.LazyVal<Setter<T, V>> r14 = ReflectProperties.lazy(new KMutableProperty1Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r14, "lazy { Setter(this) }");
        this._setter = r14;
    }

    public KMutableProperty1Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Setter<T, V>> r12 = ReflectProperties.lazy(new KMutableProperty1Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Setter(this) }");
        this._setter = r12;
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty1.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public Setter<T, V> getSetter() {
        Setter<T, V> r10 = this._setter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_setter()");
        return r10;
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(T r10, V r11) {
        getSetter().call(new Object[]{r10, r11});
    }
}
