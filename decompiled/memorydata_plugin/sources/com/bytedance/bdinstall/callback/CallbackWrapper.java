package com.bytedance.bdinstall.callback;

/* JADX INFO: loaded from: classes.dex */
public abstract class CallbackWrapper<Event, Listener> {
    private final Listener listener;

    CallbackWrapper(Listener r1) {
        this.listener = r1;
    }

    Listener getListener() {
        return this.listener;
    }
}
