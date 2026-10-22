package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTNetDiagnosisRequest {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTNetDiagnosisRequest build();

        public abstract Builder setNetDetectType(int r8);

        public abstract Builder setRequestType(int r8);

        public abstract Builder setTargets(List<String> r8);

        public abstract Builder setTimeout(int r8);
    }

    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r8, String r10);
    }

    public TTNetDiagnosisRequest() {
    }

    public abstract void cancel();

    public abstract void doExtraCommand(String r8, String r10);

    public abstract void start();
}
