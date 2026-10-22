package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class QnameValueType implements Serializable {
    private static final long serialVersionUID = 1;
    public final String localPart;
    public final String namespaceURI;

    public QnameValueType(String r1, String r2) {
        this.namespaceURI = r1;
        this.localPart = r2;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, QnameValueType.class) == false) goto L16;
        QnameValueType r5 = (QnameValueType) ZeusTransformUtils.preCheckCast(r4, QnameValueType.class, "com.obric.memorydata.plugin");
        if (this.namespaceURI.equals(r5.namespaceURI) == true) goto L10;
        return false;
    L10:
        if (this.localPart.equals(r5.localPart) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return this.namespaceURI.hashCode() + this.localPart.hashCode();
    }

    public String toString() {
        return "{" + this.namespaceURI + "}:" + this.localPart;
    }
}
