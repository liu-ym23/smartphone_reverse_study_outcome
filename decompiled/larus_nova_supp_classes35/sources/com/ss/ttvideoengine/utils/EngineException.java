package com.ss.ttvideoengine.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EngineException extends Exception {
    private final Error mError;

    public Error getError() {
        return this.mError;
    }

    public EngineException(Error r2) {
        super(r2.toString());
        this.mError = r2;
    }

    public EngineException(Error r2, Throwable r3) {
        super(r2.toString(), r3);
        this.mError = r2;
    }
}
