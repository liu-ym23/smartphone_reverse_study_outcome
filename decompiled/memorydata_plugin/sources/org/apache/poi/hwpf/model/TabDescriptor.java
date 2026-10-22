package org.apache.poi.hwpf.model;

import org.apache.poi.hwpf.model.types.TBDAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public class TabDescriptor extends TBDAbstractType {
    public TabDescriptor() {
    }

    public TabDescriptor(TabDescriptor r1) {
        super(r1);
    }

    public TabDescriptor(byte[] r1, int r2) {
        fillFields(r1, r2);
    }

    public TabDescriptor copy() {
        return new TabDescriptor(this);
    }
}
