package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

/* JADX INFO: loaded from: classes6.dex */
public class ReferenceIdentityMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    public ReferenceIdentityMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8) {
        super(r7, r8, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8, int r9, float r10) {
        super(r7, r8, r9, r10, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength r1, AbstractReferenceMap.ReferenceStrength r2, int r3, float r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8, boolean r9) {
        super(r7, r8, 16, 0.75f, r9);
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public int hash(Object r1) {
        return System.identityHashCode(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap
    public int hashEntry(Object r1, Object r2) {
        return System.identityHashCode(r1) ^ System.identityHashCode(r2);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap, org.apache.commons.collections4.map.AbstractHashedMap
    public boolean isEqualKey(Object r2, Object r3) {
        if (isKeyType(AbstractReferenceMap.ReferenceStrength.HARD) == true) goto L6;
        r3 = ((Reference) ZeusTransformUtils.preCheckCast(r3, Reference.class, "com.obric.memorydata.plugin")).get();
    L6:
        if (r2 != r3) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public boolean isEqualValue(Object r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }
}
