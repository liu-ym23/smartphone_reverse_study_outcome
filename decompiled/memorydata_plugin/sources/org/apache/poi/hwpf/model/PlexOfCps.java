package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PlexOfCps {
    private final int _cbStruct;
    private int _iMac;
    private final List<GenericPropertyNode> _props;

    public PlexOfCps(int r2) {
        this._props = new ArrayList();
        this._cbStruct = r2;
    }

    public PlexOfCps(byte[] r3, int r4, int r5, int r6) {
        int r7 = (r5 - 4) / (r6 + 4);
        this._iMac = r7;
        IOUtils.safelyAllocateCheck(r7, 100000);
        this._cbStruct = r6;
        this._props = new ArrayList(this._iMac);
        int r8 = 0;
    L4:
        if (r8 >= this._iMac) goto L6;
        this._props.add(getProperty(r8, r3, r4));
        r8 = r8 + 1;
        goto L4
    }

    private int getIntOffset(int r1) {
        return r1 * 4;
    }

    private GenericPropertyNode getProperty(int r3, byte[] r4, int r5) {
        return new GenericPropertyNode(LittleEndian.getInt(r4, getIntOffset(r3) + r5), LittleEndian.getInt(r4, getIntOffset(r3 + 1) + r5), IOUtils.safelyClone(r4, r5 + getStructOffset(r3), this._cbStruct, 10485760));
    }

    private int getStructOffset(int r2) {
        return ((this._iMac + 1) * 4) + (this._cbStruct * r2);
    }

    public void addProperty(GenericPropertyNode r2) {
        this._props.add(r2);
        this._iMac++;
    }

    void adjust(int r4, int r5) {
        Iterator<GenericPropertyNode> r3 = this._props.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        GenericPropertyNode r0 = (GenericPropertyNode) ZeusTransformUtils.preCheckCast(r3.next(), GenericPropertyNode.class, "com.obric.memorydata.plugin");
        if (r0.getStart() <= r4) goto L9;
        r0.setStart(Math.max(r0.getStart() + r5, r4));
    L9:
        if (r0.getEnd() < r4) goto L4;
        r0.setEnd(Math.max(r0.getEnd() + r5, r4));
        goto L4
    }

    public GenericPropertyNode getProperty(int r2) {
        return (GenericPropertyNode) ZeusTransformUtils.preCheckCast(this._props.get(r2), GenericPropertyNode.class, "com.obric.memorydata.plugin");
    }

    public int length() {
        return this._iMac;
    }

    void remove(int r2) {
        this._props.remove(r2);
        this._iMac--;
    }

    public String toString() {
        return "PLCF (cbStruct: " + this._cbStruct + "; iMac: " + this._iMac + ")";
    }
}
