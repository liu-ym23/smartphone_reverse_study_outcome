package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TTNetDiagnosisRequest {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTNetDiagnosisRequest build();

        public abstract Builder setMultiNetAction(int r1);

        public abstract Builder setNetDetectType(int r1);

        public abstract Builder setRequestType(int r1);

        public abstract Builder setTargets(List<String> r1);

        public abstract Builder setTimeout(int r1);
    }

    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r1, String r2);
    }

    public TTNetDiagnosisRequest() {
    }

    public abstract void cancel();

    public abstract void doExtraCommand(String r1, String r2);

    public abstract void start();
}
