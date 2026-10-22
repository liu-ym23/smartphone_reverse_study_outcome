package org.apache.commons.collections4.set;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSerializableSetDecorator<E> extends AbstractSetDecorator<E> {
    private static final long serialVersionUID = 1229469966212206107L;

    public AbstractSerializableSetDecorator(Set<E> r3) {
        super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        setCollection((Collection) ZeusTransformUtils.preCheckCast(r3.readObject(), Collection.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(decorated());
    }
}
