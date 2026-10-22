package com.bytedance.byted_bach_sdk.listener;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachAlgorithmMessage {
    public static final int MSG_SCRIPT_JS = 101;
    public static final int MSG_SCRIPT_NATIVE = 100;
    private HashMap<String, Object> m_mapInput;
    private int m_msgType;

    public BachAlgorithmMessage(int r2) {
        this.m_msgType = 0;
        this.m_msgType = r2;
        this.m_mapInput = new HashMap();
    }

    public void addInput(String r1, double r2) {
        this.m_mapInput.put(r1, Double.valueOf(r2));
    }

    public void addInput(String r1, float r2) {
        this.m_mapInput.put(r1, Float.valueOf(r2));
    }

    public void addInput(String r1, int r2) {
        this.m_mapInput.put(r1, Integer.valueOf(r2));
    }

    public void addInput(String r1, long r2) {
        this.m_mapInput.put(r1, Long.valueOf(r2));
    }

    public void addInput(String r1, String r2) {
        this.m_mapInput.put(r1, r2);
    }

    public void addInput(String r1, boolean r2) {
        this.m_mapInput.put(r1, Boolean.valueOf(r2));
    }
}
