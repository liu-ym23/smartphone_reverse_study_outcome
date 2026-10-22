package com.bytedance.byted_bach_sdk.input;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class BachGeneralInput implements BachAlgorithmInput {
    private HashMap<String, Object> m_mapInput;

    public BachGeneralInput() {
        this.m_mapInput = new HashMap();
    }

    public BachGeneralInput(HashMap<String, Object> r1) {
        this.m_mapInput = r1;
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

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public /* bridge */ /* synthetic */ Object getInput() {
        return getInput();
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public HashMap getInput() {
        return this.m_mapInput;
    }

    @Override // com.bytedance.byted_bach_sdk.input.BachAlgorithmInput
    public int getInputType() {
        return 5;
    }
}
