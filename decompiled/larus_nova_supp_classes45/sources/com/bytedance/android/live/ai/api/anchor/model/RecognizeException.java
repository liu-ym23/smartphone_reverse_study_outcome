package com.bytedance.android.live.ai.api.anchor.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RecognizeException extends Exception {
    private int code;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecognizeExceptionCode {
        public static final int CODE_ENGINE_ERROR = 1;
        public static final int CODE_PARSE_RESULT_FAILED = 2;
        public static final int CODE_UNKNOWN = 0;
    }

    public int getCode() {
        return this.code;
    }

    public RecognizeException(int r2, String r3) {
        this(r2, r3, null);
    }

    public RecognizeException(int r1, String r2, Throwable r3) {
        super(r2, r3);
        this.code = r1;
    }
}
