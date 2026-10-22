package kotlin.reflect.jvm.internal;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001bB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u000fJ\r\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u001a\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "V", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", DBDefinition.NAME, "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "delegateValue", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class KProperty0Impl<V> extends KPropertyImpl<V> implements KProperty0<V> {
    private final Lazy<Getter<V>> _getter;
    private final Lazy<Object> delegateValue;

    public static /* synthetic */ Getter accessor$KProperty0Impl$lambda0(KProperty0Impl r0) {
        return _getter$lambda$0(r0);
    }

    public static /* synthetic */ Object accessor$KProperty0Impl$lambda1(KProperty0Impl r0) {
        return delegateValue$lambda$1(r0);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.delegateValue.getValue();
    }

    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public Getter<V> m368getGetter() {
        return (Getter) this._getter.getValue();
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return (V) m368getGetter().call(new Object[0]);
    }

    public V invoke() {
        return get();
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return m368getGetter();
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KProperty0.Getter mo358getGetter() {
        return m368getGetter();
    }

    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ KPropertyImpl.Getter m369getGetter() {
        return m368getGetter();
    }

    private static final Getter _getter$lambda$0(KProperty0Impl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return new Getter(r1);
    }

    private static final Object delegateValue$lambda$1(KProperty0Impl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r2.getDelegateImpl(r2.computeDelegateSource(), null, null);
    }

    public KProperty0Impl(KDeclarationContainerImpl r2, PropertyDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        super(r2, r3);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.PUBLICATION;
        this._getter = LazyKt.lazy(r4, new KProperty0Impl$$Lambda$0(this));
        this.delegateValue = LazyKt.lazy(r4, new KProperty0Impl$$Lambda$1(this));
    }

    public KProperty0Impl(KDeclarationContainerImpl r2, String r3, String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r4, "signature");
        super(r2, r3, r4, r5);
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.PUBLICATION;
        this._getter = LazyKt.lazy(r6, new KProperty0Impl$$Lambda$0(this));
        this.delegateValue = LazyKt.lazy(r6, new KProperty0Impl$$Lambda$1(this));
    }
}
