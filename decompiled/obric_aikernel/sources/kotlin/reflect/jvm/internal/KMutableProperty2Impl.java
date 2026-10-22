package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class KMutableProperty2Impl<D, E, V> extends KProperty2Impl<D, E, V> implements KMutableProperty2<D, E, V> {
    private final ReflectProperties.LazyVal<Setter<D, E, V>> _setter;

    public static final class Setter<D, E, V> extends KPropertyImpl.Setter<V> implements KMutableProperty2.Setter<D, E, V> {
        private final KMutableProperty2Impl<D, E, V> property;

        public Setter(KMutableProperty2Impl<D, E, V> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty2Impl<D, E, V> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object r10, Object r11, Object r12) {
            invoke2(r10, r11, r12);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(D r10, E r11, V r12) {
            getProperty().set(r10, r11, r12);
        }
    }

    public KMutableProperty2Impl(KDeclarationContainerImpl r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12);
        ReflectProperties.LazyVal<Setter<D, E, V>> r13 = ReflectProperties.lazy(new KMutableProperty2Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r13, "lazy { Setter(this) }");
        this._setter = r13;
    }

    public KMutableProperty2Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Setter<D, E, V>> r12 = ReflectProperties.lazy(new KMutableProperty2Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Setter(this) }");
        this._setter = r12;
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty2, kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty2.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty2, kotlin.reflect.KMutableProperty
    public Setter<D, E, V> getSetter() {
        Setter<D, E, V> r10 = this._setter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_setter()");
        return r10;
    }

    @Override // kotlin.reflect.KMutableProperty2
    public void set(D r10, E r11, V r12) {
        getSetter().call(new Object[]{r10, r11, r12});
    }
}
