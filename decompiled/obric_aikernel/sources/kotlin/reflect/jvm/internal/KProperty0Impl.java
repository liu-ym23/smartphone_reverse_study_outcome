package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class KProperty0Impl<V> extends KPropertyImpl<V> implements KProperty0<V> {
    private final ReflectProperties.LazyVal<Getter<V>> _getter;
    private final Lazy<Object> delegateValue;

    public static final class Getter<R> extends KPropertyImpl.Getter<R> implements KProperty0.Getter<R> {
        private final KProperty0Impl<R> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty0Impl<? extends R> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KProperty0Impl<R> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return getProperty().get();
        }
    }

    public KProperty0Impl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12, r13);
        ReflectProperties.LazyVal<Getter<V>> r14 = ReflectProperties.lazy(new KProperty0Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r14, "lazy { Getter(this) }");
        this._getter = r14;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$delegateValue$1(this));
    }

    public KProperty0Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Getter<V>> r12 = ReflectProperties.lazy(new KProperty0Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Getter(this) }");
        this._getter = r12;
        this.delegateValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty0Impl$delegateValue$1(this));
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.delegateValue.getValue();
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty0.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<V> getGetter() {
        Getter<V> r10 = this._getter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_getter()");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KPropertyImpl.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }
}
