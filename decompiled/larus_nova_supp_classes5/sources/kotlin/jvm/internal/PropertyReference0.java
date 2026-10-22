package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public KCallable computeReflected() {
        return Reflection.property0(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty0.Getter mo358getGetter() {
        return ((KProperty0) getReflected()).mo358getGetter();
    }

    public Object invoke() {
        return get();
    }

    public PropertyReference0() {
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo358getGetter();
    }

    public PropertyReference0(Object r1) {
        super(r1);
    }

    public PropertyReference0(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
