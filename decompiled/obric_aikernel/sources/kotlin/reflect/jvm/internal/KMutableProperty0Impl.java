package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements KMutableProperty0<V> {
    private final ReflectProperties.LazyVal<Setter<V>> _setter;

    public static final class Setter<R> extends KPropertyImpl.Setter<R> implements KMutableProperty0.Setter<R> {
        private final KMutableProperty0Impl<R> property;

        public Setter(KMutableProperty0Impl<R> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty0Impl<R> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object r10) {
            invoke2(r10);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(R r10) {
            getProperty().set(r10);
        }
    }

    public KMutableProperty0Impl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12, r13);
        ReflectProperties.LazyVal<Setter<V>> r14 = ReflectProperties.lazy(new KMutableProperty0Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r14, "lazy { Setter(this) }");
        this._setter = r14;
    }

    public KMutableProperty0Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Setter<V>> r12 = ReflectProperties.lazy(new KMutableProperty0Impl$_setter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Setter(this) }");
        this._setter = r12;
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty0.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KMutableProperty
    public Setter<V> getSetter() {
        Setter<V> r10 = this._setter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_setter()");
        return r10;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(V r10) {
        getSetter().call(new Object[]{r10});
    }
}
