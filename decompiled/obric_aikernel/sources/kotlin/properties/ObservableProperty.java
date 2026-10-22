package kotlin.properties;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {
    private V value;

    public ObservableProperty(V r10) {
        this.value = r10;
    }

    protected void afterChange(KProperty<?> r10, V r11, V r12) {
        Intrinsics.checkNotNullParameter(r10, "property");
    }

    protected boolean beforeChange(KProperty<?> r10, V r11, V r12) {
        Intrinsics.checkNotNullParameter(r10, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object r10, KProperty<?> r11, V r12) {
        Intrinsics.checkNotNullParameter(r11, "property");
        V r13 = this.value;
        if (beforeChange(r11, r13, r12) == true) goto L5;
        return;
    L5:
        this.value = r12;
        afterChange(r11, r13, r12);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}
