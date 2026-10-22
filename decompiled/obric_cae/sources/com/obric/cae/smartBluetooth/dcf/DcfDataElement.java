package com.obric.cae.smartBluetooth.dcf;

/* JADX INFO: loaded from: classes.dex */
public class DcfDataElement {
    private byte[] data;
    private int tag;

    public DcfDataElement(int r8, byte[] r10) {
        this.tag = r8;
        this.data = r10;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getTag() {
        return this.tag;
    }

    public void setData(byte[] r8) {
        this.data = r8;
    }

    public void setTag(int r8) {
        this.tag = r8;
    }
}
