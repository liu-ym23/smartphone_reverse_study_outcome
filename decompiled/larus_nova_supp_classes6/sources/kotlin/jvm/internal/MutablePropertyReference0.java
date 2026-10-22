package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty$Getter;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public KCallable computeReflected() {
        return Reflection.mutableProperty0(this);
    }

    public Object getDelegate() {
        return getReflected().getDelegate();
    }

    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty0.Getter m736getGetter() {
        return getReflected().getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KMutableProperty0.Setter mo737getSetter() {
        return getReflected().mo737getSetter();
    }

    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0() {
    }

    public /* bridge */ /* synthetic */ KProperty$Getter getGetter() {
        return m736getGetter();
    }

    public /* bridge */ /* synthetic */ KMutableProperty$Setter getSetter() {
        return mo737getSetter();
    }

    public MutablePropertyReference0(Object r1) {
        super(r1);
    }

    public MutablePropertyReference0(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
