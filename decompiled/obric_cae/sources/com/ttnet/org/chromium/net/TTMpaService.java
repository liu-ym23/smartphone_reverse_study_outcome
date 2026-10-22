package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTMpaService {

    public interface ICallback {
        void onFinish(boolean r8, String r10);
    }

    public TTMpaService() {
    }

    public abstract void command(String r8, String r10);

    public abstract void init(ICallback r8);

    public abstract void setAccAddress(List<String> r8, ICallback r10);

    public abstract void start();

    public abstract void stop();
}
