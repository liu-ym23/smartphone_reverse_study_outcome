package org.codehaus.stax2.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements org.codehaus.stax2.a.b {

    @Deprecated
    protected final javax.xml.stream.a g;

    public a(javax.xml.stream.a r3) {
        this.g = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
    }

    public static boolean b(String r3, String r4) {
        if (r3 != null) goto L5;
    L12:
        if (r4 == null) goto L16;
        if (r4.length() == 0) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r3.length() == 0) goto L12;
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r3.equals(r4) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public abstract int l();

    @Override // javax.xml.stream.a.c
    public javax.xml.stream.a m() {
        return this.g;
    }

    public String toString() {
        return "[Stax Event #" + l() + "]";
    }
}
