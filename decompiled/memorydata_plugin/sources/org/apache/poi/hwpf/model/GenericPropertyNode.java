package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class GenericPropertyNode extends PropertyNode<GenericPropertyNode> {
    public GenericPropertyNode(int r1, int r2, byte[] r3) {
        super(r1, r2, r3);
    }

    public byte[] getBytes() {
        return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this._buf, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("GenericPropertyNode [").append(getStart()).append("; ").append(getEnd()).append(") ");
        if (getBytes() == null) goto L5;
        String r2 = getBytes().length + " byte(s)";
    L7:
        return r0.append(r2).toString();
    L5:
        r2 = "null";
        goto L7
    }
}
