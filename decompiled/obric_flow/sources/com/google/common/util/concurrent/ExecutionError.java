package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(String r5) {
        super(r5);
    }

    public ExecutionError(String r5, Error r10) {
        super(r5, r10);
    }

    public ExecutionError(Error r5) {
        super(r5);
    }
}
