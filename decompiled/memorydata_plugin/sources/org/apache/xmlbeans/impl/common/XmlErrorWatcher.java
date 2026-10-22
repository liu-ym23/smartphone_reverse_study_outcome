package org.apache.xmlbeans.impl.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.xmlbeans.XmlError;

/* JADX INFO: loaded from: classes7.dex */
public class XmlErrorWatcher extends AbstractCollection<XmlError> {
    private XmlError _firstError;
    private final Collection<XmlError> _underlying;

    public XmlErrorWatcher(Collection<XmlError> r3) {
        this._underlying = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public /* synthetic */ boolean add(Object r3) {
        return add((XmlError) ZeusTransformUtils.preCheckCast(r3, XmlError.class, "com.obric.memorydata.plugin"));
    }

    public boolean add(XmlError r2) {
        if (this._firstError != null) goto L8;
        if (r2 == null) goto L8;
        if (r2.getSeverity() != 0) goto L8;
        this._firstError = r2;
    L8:
        Collection<XmlError> r1 = this._underlying;
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.add(r2);
    }

    public boolean hasError() {
        if (this._firstError == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<XmlError> iterator() {
        Collection<XmlError> r0 = this._underlying;
        if (r0 != null) goto L7;
        return Collections.emptyIterator();
    L7:
        return r0.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        Collection<XmlError> r0 = this._underlying;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }
}
