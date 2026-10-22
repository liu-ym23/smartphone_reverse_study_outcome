package com.ss.android.lark.forwardv2.dto;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardResult implements Serializable {
    private final int mResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FORWARDRESULT {
        public static final int FORWARD_CANCEL = 3;
        public static final int FORWARD_FAILED = 2;
        public static final int FORWARD_SUCCESS = 1;
        public static final int FORWARD_UNKOWN = 0;
    }

    public int getResult() {
        return this.mResult;
    }

    public ForwardResult(int r1) {
        this.mResult = r1;
    }
}
