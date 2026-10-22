package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UploadDataSink {
    public UploadDataSink() {
    }

    public abstract void onReadError(Exception r10);

    public abstract void onReadSucceeded(boolean r10);

    public abstract void onRewindError(Exception r10);

    public abstract void onRewindSucceeded();
}
