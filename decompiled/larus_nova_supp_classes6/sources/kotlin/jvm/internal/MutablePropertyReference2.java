package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements KMutableProperty2 {
    public KCallable computeReflected() {
        return Reflection.mutableProperty2(this);
    }

    @Override // kotlin.reflect.KProperty2
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty2.Getter mo738getGetter() {
        return ((KMutableProperty2) getReflected()).mo738getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty2
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KMutableProperty2.Setter mo739getSetter() {
        return ((KMutableProperty2) getReflected()).mo739getSetter();
    }

    public MutablePropertyReference2() {
    }

    public /* bridge */ /* synthetic */ KProperty$Getter getGetter() {
        return mo738getGetter();
    }

    public /* bridge */ /* synthetic */ KMutableProperty$Setter getSetter() {
        return mo739getSetter();
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(Object r2, Object r3) {
        return ((KMutableProperty2) getReflected()).getDelegate(r2, r3);
    }

    public Object invoke(Object r1, Object r2) {
        return get(r1, r2);
    }

    public MutablePropertyReference2(Class r7, String r8, String r9, int r10) {
        super(CallableReference.NO_RECEIVER, r7, r8, r9, r10);
    }
}
