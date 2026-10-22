package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    public ExecutionError() {
    }

    public ExecutionError(Error r1) {
        super(r1);
    }

    public ExecutionError(String r1) {
        super(r1);
    }

    public ExecutionError(String r1, Error r2) {
        super(r1, r2);
    }
}
