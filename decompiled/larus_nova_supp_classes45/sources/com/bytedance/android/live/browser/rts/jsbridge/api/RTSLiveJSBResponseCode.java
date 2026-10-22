package com.bytedance.android.live.browser.rts.jsbridge.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/rts/jsbridge/api/RTSLiveJSBResponseCode;", "", "", "value", "I", "getValue", "()I", "FAILED", "SUCCESS", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RTSLiveJSBResponseCode extends Enum<RTSLiveJSBResponseCode> {
    public static final RTSLiveJSBResponseCode FAILED = null;
    public static final RTSLiveJSBResponseCode SUCCESS = null;
    public static final /* synthetic */ RTSLiveJSBResponseCode[] a = null;
    private final int value;

    static {
        RTSLiveJSBResponseCode r1 = new RTSLiveJSBResponseCode("FAILED", 0, 0);
        FAILED = r1;
        RTSLiveJSBResponseCode r2 = new RTSLiveJSBResponseCode("SUCCESS", 1, 1);
        SUCCESS = r2;
        a = new RTSLiveJSBResponseCode[]{r1, r2};
    }

    public static RTSLiveJSBResponseCode valueOf(String r1) {
        return (RTSLiveJSBResponseCode) a.a(RTSLiveJSBResponseCode.class, r1);
    }

    public static RTSLiveJSBResponseCode[] values() {
        return (RTSLiveJSBResponseCode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RTSLiveJSBResponseCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
