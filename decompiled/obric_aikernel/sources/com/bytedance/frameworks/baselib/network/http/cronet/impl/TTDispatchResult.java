package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class TTDispatchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1618a;

    public static final enum DispatchState extends Enum<DispatchState> {
        private static final /* synthetic */ DispatchState[] $VALUES = null;
        public static final DispatchState CRONET_NOT_INIT = null;
        public static final DispatchState INVALID_FINAL_URL = null;
        public static final DispatchState INVALID_ORIGIN_URL = null;
        public static final DispatchState NOT_REACHED = null;
        public static final DispatchState OKHTTP_DISPATCH_FAILED = null;
        public static final DispatchState SUCCESS = null;
        public static final DispatchState TIMEOUT = null;
        public static final DispatchState WRONG_FORMAT = null;

        static {
            DispatchState r10 = new DispatchState("SUCCESS", 0);
            SUCCESS = r10;
            DispatchState r11 = new DispatchState("INVALID_ORIGIN_URL", 1);
            INVALID_ORIGIN_URL = r11;
            DispatchState r12 = new DispatchState("CRONET_NOT_INIT", 2);
            CRONET_NOT_INIT = r12;
            DispatchState r13 = new DispatchState("TIMEOUT", 3);
            TIMEOUT = r13;
            DispatchState r14 = new DispatchState("INVALID_FINAL_URL", 4);
            INVALID_FINAL_URL = r14;
            DispatchState r15 = new DispatchState("WRONG_FORMAT", 5);
            WRONG_FORMAT = r15;
            DispatchState r16 = new DispatchState("OKHTTP_DISPATCH_FAILED", 6);
            OKHTTP_DISPATCH_FAILED = r16;
            DispatchState r17 = new DispatchState("NOT_REACHED", 7);
            NOT_REACHED = r17;
            $VALUES = new DispatchState[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private DispatchState(String r10, int r11) {
            super(r10, r11);
        }

        public static DispatchState valueOf(String r10) {
            return (DispatchState) Enum.valueOf(DispatchState.class, r10);
        }

        public static DispatchState[] values() {
            return (DispatchState[]) $VALUES.clone();
        }
    }

    static {
    }

    public TTDispatchResult(String r10, DispatchState r11) {
        this.f1618a = r10;
    }

    public TTDispatchResult(String r10, String r11, String r12, String r13, DispatchState r14, String r15) {
        this.f1618a = r11;
        TextUtils.isEmpty(r12);
        TextUtils.isEmpty(r13);
        TextUtils.isEmpty(r15);
    }

    public String a() {
        return this.f1618a;
    }
}
