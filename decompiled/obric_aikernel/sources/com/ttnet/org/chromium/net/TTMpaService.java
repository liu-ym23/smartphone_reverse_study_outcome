package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTMpaService {

    public interface ICallback {
        void onFinish(boolean r10, String r11);
    }

    public TTMpaService() {
    }

    public abstract void command(String r10, String r11);

    public abstract void init(ICallback r10);

    public abstract void setAccAddress(List<String> r10, ICallback r11);

    public abstract void start();

    public abstract void stop();
}
