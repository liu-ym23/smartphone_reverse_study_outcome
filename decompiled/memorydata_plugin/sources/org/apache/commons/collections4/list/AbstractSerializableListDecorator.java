package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSerializableListDecorator<E> extends AbstractListDecorator<E> {
    private static final long serialVersionUID = 2684959196747496299L;

    public AbstractSerializableListDecorator(List<E> r3) {
        super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
