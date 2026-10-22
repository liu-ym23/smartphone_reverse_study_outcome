package org.apache.commons.collections4.multiset;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class HashMultiSet<E> extends AbstractMapMultiSet<E> implements Serializable {
    private static final long serialVersionUID = 20150610;

    public HashMultiSet() {
        super(new HashMap());
    }

    public HashMultiSet(Collection<? extends E> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this();
        addAll(r4);
    }

    private void readObject(ObjectInputStream r2) {
        r2.defaultReadObject();
        setMap(new HashMap());
        super.doReadObject(r2);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        super.doWriteObject(r1);
    }
}
