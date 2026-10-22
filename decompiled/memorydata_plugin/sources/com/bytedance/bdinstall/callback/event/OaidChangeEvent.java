package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.IOaidObserver;

/* JADX INFO: loaded from: classes.dex */
public class OaidChangeEvent {
    private final IOaidObserver.Oaid oaid;

    public OaidChangeEvent(IOaidObserver.Oaid r1) {
        this.oaid = r1;
    }

    public IOaidObserver.Oaid getOaid() {
        return this.oaid;
    }
}
