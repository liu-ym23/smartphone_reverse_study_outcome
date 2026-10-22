package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Member;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class KProperty2Impl<D, E, V> extends KPropertyImpl<V> implements KProperty2<D, E, V> {
    private final ReflectProperties.LazyVal<Getter<D, E, V>> _getter;
    private final Lazy<Member> delegateSource;

    public static final class Getter<D, E, V> extends KPropertyImpl.Getter<V> implements KProperty2.Getter<D, E, V> {
        private final KProperty2Impl<D, E, V> property;

        /* JADX WARN: Multi-variable type inference failed */
        public Getter(KProperty2Impl<D, E, ? extends V> r10) {
            Intrinsics.checkNotNullParameter(r10, "property");
            this.property = r10;
        }

        @Override // kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KProperty getProperty() {
            return getProperty();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KProperty2Impl<D, E, V> getProperty() {
            return this.property;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public /* bridge */ /* synthetic */ KPropertyImpl getProperty() {
            return getProperty();
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D r10, E r11) {
            return getProperty().get(r10, r11);
        }
    }

    public KProperty2Impl(KDeclarationContainerImpl r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "signature");
        super(r10, r11, r12, CallableReference.NO_RECEIVER);
        ReflectProperties.LazyVal<Getter<D, E, V>> r13 = ReflectProperties.lazy(new KProperty2Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r13, "lazy { Getter(this) }");
        this._getter = r13;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty2Impl$delegateSource$1(this));
    }

    public KProperty2Impl(KDeclarationContainerImpl r10, PropertyDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        super(r10, r11);
        ReflectProperties.LazyVal<Getter<D, E, V>> r12 = ReflectProperties.lazy(new KProperty2Impl$_getter$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "lazy { Getter(this) }");
        this._getter = r12;
        this.delegateSource = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new KProperty2Impl$delegateSource$1(this));
    }

    @Override // kotlin.reflect.KProperty2
    public V get(D r10, E r11) {
        return getGetter().call(new Object[]{r10, r11});
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(D r10, E r11) {
        return getDelegateImpl(this.delegateSource.getValue(), r10, r11);
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty2.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public Getter<D, E, V> getGetter() {
        Getter<D, E, V> r10 = this._getter.invoke();
        Intrinsics.checkNotNullExpressionValue(r10, "_getter()");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KPropertyImpl.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D r10, E r11) {
        return get(r10, r11);
    }
}
