package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class InstanceofPredicate implements Serializable, Predicate<Object> {
    private static final long serialVersionUID = -6682656911025165584L;
    private final Class<?> iType;

    public InstanceofPredicate(Class<?> r1) {
        this.iType = r1;
    }

    public static Predicate<Object> instanceOfPredicate(Class<?> r1) {
        Objects.requireNonNull(r1, "The type to check instanceof must not be null");
        return new InstanceofPredicate(r1);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(Object r1) {
        return ZeusTransformUtils.instanceOf(this.iType, r1);
    }

    public Class<?> getType() {
        return this.iType;
    }
}
