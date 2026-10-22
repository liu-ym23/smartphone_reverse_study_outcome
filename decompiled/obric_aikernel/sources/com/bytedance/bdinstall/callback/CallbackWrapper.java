package com.bytedance.bdinstall.callback;

/* JADX INFO: loaded from: classes.dex */
public abstract class CallbackWrapper<Event, Listener> {
    private final Listener listener;

    CallbackWrapper(Listener r10) {
        this.listener = r10;
    }

    Listener getListener() {
        return this.listener;
    }
}
