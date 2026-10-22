package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: loaded from: classes7.dex */
public class XmlValueRef {
    Object _initVal;
    XmlAnySimpleType _obj;
    SchemaType.Ref _typeref;

    XmlValueRef(SchemaType.Ref r1, Object r2) {
        if (r1 == null) goto L7;
        this._typeref = r1;
        this._initVal = r2;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    public XmlValueRef(XmlAnySimpleType r3) {
        XmlAnySimpleType r4 = (XmlAnySimpleType) ZeusTransformUtils.wrapperContextForParams(r3, XmlAnySimpleType.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this._obj = r4;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    synchronized XmlAnySimpleType get() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this._obj != null) goto L14;
        SchemaType r0 = this._typeref.get();     // Catch: Throwable -> L17
        if (r0.getSimpleVariety() == 3) goto L9;
        XmlAnySimpleType r1 = r0.newValue(this._initVal);     // Catch: Throwable -> L17
    L8:
        this._obj = r1;     // Catch: Throwable -> L17
        goto L14
    L9:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        Iterator r3 = ((List) ZeusTransformUtils.preCheckCast(this._initVal, List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
    L11:
        if (r3.hasNext() == false) goto L13;
        r2.add(((XmlValueRef) ZeusTransformUtils.preCheckCast(r3.next(), XmlValueRef.class, "com.obric.memorydata.plugin")).get());     // Catch: Throwable -> L17
        goto L11
    L13:
        r1 = r0.newValue(r2);     // Catch: Throwable -> L17
    L14:
        XmlAnySimpleType r4 = this._obj;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r4;
    }
}
