package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Member;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    private final ReflectProperties.LazyVal<Getter<T, V>> _getter;
    private final Lazy<Member> delegateSource;

    public static final class Getter<T, V> extends KPropertyImpl.Getter<V> implements KProperty1.Getter<T, V> {
        private final KProperty1Impl<T, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty1Impl<T, ? extends V> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KProperty1Impl<T, V> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T r10) {
            return getProperty().get(r10);
        }
    }

    public KProperty1Impl(KDeclarationContainerImpl r10, String r11, String r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12, r13);
        ReflectProperties.LazyVal<Getter<T, V>> r14 = ReflectProperties.lazy(new KProperty1Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r14, "lazy { Getter(this) }");
        this._getter = r14;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$delegateSource$1(this));
    }

    public KProperty1Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Getter<T, V>> r12 = ReflectProperties.lazy(new KProperty1Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Getter(this) }");
        this._getter = r12;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty1Impl$delegateSource$1(this));
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T r10) {
        return getGetter().call(new Object[]{r10});
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(T r10) {
        return getDelegateImpl(this.delegateSource.getValue(), r10, null);
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty1.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<T, V> getGetter() {
        Getter<T, V> r10 = this._getter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_getter()");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KPropertyImpl.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T r10) {
        return get(r10);
    }
}
