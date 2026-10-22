package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public KCallable computeReflected() {
        return Reflection.property2(this);
    }

    @Override // kotlin.reflect.KProperty2
    /* JADX INFO: renamed from: getGetter */
    public KProperty2.Getter mo738getGetter() {
        return ((KProperty2) getReflected()).mo738getGetter();
    }

    public PropertyReference2() {
    }

    public /* bridge */ /* synthetic */ KProperty$Getter getGetter() {
        return mo738getGetter();
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(Object r2, Object r3) {
        return ((KProperty2) getReflected()).getDelegate(r2, r3);
    }

    public Object invoke(Object r1, Object r2) {
        return get(r1, r2);
    }

    public PropertyReference2(Class r7, String r8, String r9, int r10) {
        super(CallableReference.NO_RECEIVER, r7, r8, r9, r10);
    }
}
