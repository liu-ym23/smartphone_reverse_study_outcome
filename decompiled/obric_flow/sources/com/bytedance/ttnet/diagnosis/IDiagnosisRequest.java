package com.bytedance.ttnet.diagnosis;

/* JADX INFO: loaded from: classes2.dex */
public interface IDiagnosisRequest {
    void cancel();

    void doExtraCommand(String r5, String r10);

    void setUserExtraInfo(String r5);

    void start(IDiagnosisCallback r5);
}
