package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
    }

    public PropertyReference2(Class r7, String r8, String r9, int r10) {
        super(NO_RECEIVER, r7, r8, r9, r10);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property2(this);
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(Object r3, Object r4) {
        return ((KProperty2) ZeusTransformUtils.preCheckCast(getReflected(), KProperty2.class, "com.obric.memorydata.plugin")).getDelegate(r3, r4);
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KProperty
    public KProperty2.Getter getGetter() {
        return ((KProperty2) ZeusTransformUtils.preCheckCast(getReflected(), KProperty2.class, "com.obric.memorydata.plugin")).getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object r1, Object r2) {
        return get(r1, r2);
    }
}
