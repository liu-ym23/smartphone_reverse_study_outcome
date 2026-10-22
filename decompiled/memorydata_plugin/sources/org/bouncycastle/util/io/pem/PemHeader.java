package org.bouncycastle.util.io.pem;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class PemHeader {
    private String name;
    private String value;

    private int getHashCode(String r1) {
        if (r1 != null) goto L6;
        return 1;
    L6:
        return r1.hashCode();
    }

    private boolean isEqual(String r1, String r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 == null) goto L10;
        if (r2 != null) goto L9;
        return false;
    L9:
        return r1.equals(r2);
    L10:
        return false;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PemHeader.class) == true) goto L5;
        return false;
    L5:
        PemHeader r5 = (PemHeader) ZeusTransformUtils.preCheckCast(r4, PemHeader.class, "com.obric.memorydata.plugin");
        if (r5 != this) goto L8;
    L11:
        return true;
    L8:
        if (isEqual(this.name, r5.name) == true) goto L10;
        return false;
    L10:
        if (isEqual(this.value, r5.value) == true) goto L11;
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return getHashCode(this.name) + (getHashCode(this.value) * 31);
    }
}
