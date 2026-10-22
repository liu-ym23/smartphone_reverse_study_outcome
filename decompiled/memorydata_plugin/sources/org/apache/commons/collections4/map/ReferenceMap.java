package org.apache.commons.collections4.map;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ReferenceMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8) {
        super(r7, r8, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8, int r9, float r10) {
        super(r7, r8, r9, r10, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength r1, AbstractReferenceMap.ReferenceStrength r2, int r3, float r4, boolean r5) {
        super(r1, r2, r3, r4, r5);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength r7, AbstractReferenceMap.ReferenceStrength r8, boolean r9) {
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
}
