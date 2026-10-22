package com.lynx.tasm.resourceprovider;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxResourceResponse<T> {
    public ResponseState a;
    public T b;
    public Throwable c;

    public static final enum ResponseState extends Enum<ResponseState> {
        public static final ResponseState FAILED = null;
        public static final ResponseState SUCCESS = null;
        public static final /* synthetic */ ResponseState[] a = null;

        static {
            ResponseState r0 = new ResponseState("FAILED", 0);
            FAILED = r0;
            ResponseState r1 = new ResponseState("SUCCESS", 1);
            SUCCESS = r1;
            a = new ResponseState[]{r0, r1};
        }

        public static ResponseState[] values() {
            return (ResponseState[]) a.clone();
        }

        public static ResponseState valueOf(String r1) {
            return (ResponseState) a.a(ResponseState.class, r1);
        }

        public ResponseState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxResourceResponse() {
    }

    public static LynxResourceResponse a(Throwable r2) {
        LynxResourceResponse r0 = new LynxResourceResponse();
        r0.a = ResponseState.FAILED;
        r0.c = r2;
        return r0;
    }

    public static <T> LynxResourceResponse<T> b(T r2) {
        LynxResourceResponse<T> r0 = new LynxResourceResponse();
        r0.a = ResponseState.SUCCESS;
        r0.b = r2;
        return r0;
    }
}
