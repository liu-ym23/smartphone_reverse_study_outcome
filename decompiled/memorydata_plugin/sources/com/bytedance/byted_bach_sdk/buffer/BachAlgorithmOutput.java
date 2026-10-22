package com.bytedance.byted_bach_sdk.buffer;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachAlgorithmOutput {
    public HashMap<String, BachObject>[] m_dataMap;

    BachAlgorithmOutput() {
    }

    BachAlgorithmOutput(HashMap<String, BachObject>[] r1) {
        this.m_dataMap = r1;
    }

    public HashMap<String, BachObject> getResult() {
        HashMap<String, BachObject>[] r1 = this.m_dataMap;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.length > 0) goto L7;
        return null;
    L7:
        return r1[0];
    }

    public HashMap<String, BachObject> getResult(int r2) {
        HashMap<String, BachObject>[] r1 = this.m_dataMap;
        if (r1 == null) goto L9;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (r2 < r1.length) goto L8;
        return null;
    L8:
        return r1[r2];
    L9:
        return null;
    }
}
