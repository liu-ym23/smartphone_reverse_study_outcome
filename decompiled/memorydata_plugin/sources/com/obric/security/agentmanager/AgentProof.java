package com.obric.security.agentmanager;

/* JADX INFO: loaded from: classes3.dex */
public class AgentProof {
    private byte[] agentData;
    private byte[] agentHash;
    private String agentUuid;
    private byte[] certChain;
    private byte[] deviceStatus;
    private byte[] signature;

    public AgentProof(String r1, byte[] r2, byte[] r3, byte[] r4, byte[] r5, byte[] r6) {
        this.agentUuid = r1;
        this.agentData = r2;
        this.agentHash = r3;
        this.deviceStatus = r4;
        this.certChain = r5;
        this.signature = r6;
    }

    public byte[] getAgentData() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getAgentHash() {
        throw new RuntimeException("Stub!!");
    }

    public String getAgentUuid() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getCertChain() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getDeviceStatus() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] getSignature() {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentData(byte[] r1) {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentHash(byte[] r1) {
        throw new RuntimeException("Stub!!");
    }

    public void setAgentUuid(String r1) {
        throw new RuntimeException("Stub!!");
    }

    public void setCertChain(byte[] r1) {
        throw new RuntimeException("Stub!!");
    }

    public void setDeviceStatus(byte[] r1) {
        throw new RuntimeException("Stub!!");
    }

    public void setSignature(byte[] r1) {
        throw new RuntimeException("Stub!!");
    }
}
