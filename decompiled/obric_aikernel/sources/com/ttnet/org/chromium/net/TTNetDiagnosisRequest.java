package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTNetDiagnosisRequest {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTNetDiagnosisRequest build();

        public abstract Builder setMultiNetAction(int r10);

        public abstract Builder setNetDetectType(int r10);

        public abstract Builder setRequestType(int r10);

        public abstract Builder setTargets(List<String> r10);

        public abstract Builder setTimeout(int r10);
    }

    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r10, String r11);
    }

    public TTNetDiagnosisRequest() {
    }

    public abstract void cancel();

    public abstract void doExtraCommand(String r10, String r11);

    public abstract void start();
}
