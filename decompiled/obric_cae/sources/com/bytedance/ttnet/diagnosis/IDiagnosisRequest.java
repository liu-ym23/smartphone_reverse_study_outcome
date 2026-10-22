package com.bytedance.ttnet.diagnosis;

/* JADX INFO: loaded from: classes.dex */
public interface IDiagnosisRequest {
    void cancel();

    void doExtraCommand(String r8, String r10);

    void setUserExtraInfo(String r8);

    void start(IDiagnosisCallback r8);
}
