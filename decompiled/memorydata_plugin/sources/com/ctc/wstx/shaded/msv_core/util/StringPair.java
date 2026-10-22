package com.ctc.wstx.shaded.msv_core.util;

import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class StringPair implements Serializable {
    public final String localName;
    public final String namespaceURI;

    public StringPair(SimpleNameClass r2) {
        this(r2.namespaceURI, r2.localName);
    }

    public StringPair(String r1, String r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.namespaceURI = r1;
        this.localName = r2;
        return;
    L8:
        throw new InternalError("local name is null");
    L10:
        throw new InternalError("namespace URI is null");
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, StringPair.class) == true) goto L6;
        return false;
    L6:
        if (this.namespaceURI.equals(((StringPair) ZeusTransformUtils.preCheckCast(r6, StringPair.class, "com.obric.memorydata.plugin")).namespaceURI) == true) goto L8;
        return false;
    L8:
        if (this.localName.equals(((StringPair) ZeusTransformUtils.preCheckCast(r6, StringPair.class, "com.obric.memorydata.plugin")).localName) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.namespaceURI.hashCode();
        return this.localName.hashCode() ^ r0;
    }

    public String toString() {
        return "{" + this.namespaceURI + "}" + this.localName;
    }
}
