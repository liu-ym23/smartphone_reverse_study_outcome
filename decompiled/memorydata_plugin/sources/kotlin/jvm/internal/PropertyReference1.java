package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1() {
    }

    public PropertyReference1(Object r1) {
        super(r1);
    }

    public PropertyReference1(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object r3) {
        return ((KProperty1) ZeusTransformUtils.preCheckCast(getReflected(), KProperty1.class, "com.obric.memorydata.plugin")).getDelegate(r3);
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.Getter getGetter() {
        return ((KProperty1) ZeusTransformUtils.preCheckCast(getReflected(), KProperty1.class, "com.obric.memorydata.plugin")).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r1) {
        return get(r1);
    }
}
