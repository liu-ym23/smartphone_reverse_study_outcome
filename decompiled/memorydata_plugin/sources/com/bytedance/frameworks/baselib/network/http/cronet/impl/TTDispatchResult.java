package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TTDispatchResult {
    static final /* synthetic */ boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2407b;
    public final String c;
    public final String d;
    public final DispatchState e;
    public final Exception f;
    public final String g;

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
            DispatchState r0 = new DispatchState("SUCCESS", 0);
            SUCCESS = r0;
            DispatchState r1 = new DispatchState("INVALID_ORIGIN_URL", 1);
            INVALID_ORIGIN_URL = r1;
            DispatchState r3 = new DispatchState("CRONET_NOT_INIT", 2);
            CRONET_NOT_INIT = r3;
            DispatchState r5 = new DispatchState("TIMEOUT", 3);
            TIMEOUT = r5;
            DispatchState r7 = new DispatchState("INVALID_FINAL_URL", 4);
            INVALID_FINAL_URL = r7;
            DispatchState r9 = new DispatchState("WRONG_FORMAT", 5);
            WRONG_FORMAT = r9;
            DispatchState r11 = new DispatchState("OKHTTP_DISPATCH_FAILED", 6);
            OKHTTP_DISPATCH_FAILED = r11;
            DispatchState r13 = new DispatchState("NOT_REACHED", 7);
            NOT_REACHED = r13;
            $VALUES = new DispatchState[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private DispatchState(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchState valueOf(String r2) {
            return (DispatchState) ZeusTransformUtils.preCheckCast(Enum.valueOf(DispatchState.class, r2), DispatchState.class, "com.obric.memorydata.plugin");
        }

        public static DispatchState[] values() {
            return (DispatchState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DispatchState[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public TTDispatchResult(String r2, DispatchState r3, Exception r4) {
        if (h == false) goto L5;
    L9:
        this.f2406a = r2;
        this.f2407b = r2;
        this.c = "0";
        this.d = "0";
        this.e = r3;
        this.f = r4;
        this.g = "";
        return;
    L5:
        if (r3 != DispatchState.SUCCESS) goto L9;
        throw new AssertionError();
    }

    public TTDispatchResult(String r1, String r2, String r3, String r4, DispatchState r5, String r6) {
        this.f2406a = r1;
        this.f2407b = r2;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.c = r3;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        this.d = r4;
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        this.g = r6;
    L14:
        this.e = r5;
        this.f = null;
        return;
    L13:
        this.g = "";
        goto L14
    L9:
        this.d = "0";
        goto L11
    L5:
        this.c = "0";
        goto L7
    }

    public String a() {
        return this.f2407b;
    }
}
