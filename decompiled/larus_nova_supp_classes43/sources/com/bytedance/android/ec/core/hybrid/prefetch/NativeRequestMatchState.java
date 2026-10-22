package com.bytedance.android.ec.core.hybrid.prefetch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativeRequestMatchState;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "REQUEST_MATCH_SUCCESS", "REQUEST_MATCH_APIKEY_FAILED", "REQUEST_MATCH_APIURL_FAILED", "REQUEST_MATCH_METHOD_FAILED", "REQUEST_MATCH_HEADER_FAILED", "REQUEST_MATCH_PARAMS_FAILED", "REQUEST_MATCH_DATA_FAILED", "REQUEST_MATCH_EXPIRED", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NativeRequestMatchState extends Enum<NativeRequestMatchState> {
    private static final /* synthetic */ NativeRequestMatchState[] $VALUES = null;
    public static final NativeRequestMatchState REQUEST_MATCH_APIKEY_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_APIURL_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_DATA_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_EXPIRED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_HEADER_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_METHOD_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_PARAMS_FAILED = null;
    public static final NativeRequestMatchState REQUEST_MATCH_SUCCESS = null;
    private final int value;

    public static NativeRequestMatchState valueOf(String r1) {
        return (NativeRequestMatchState) r27.a.a(NativeRequestMatchState.class, r1);
    }

    public static NativeRequestMatchState[] values() {
        return (NativeRequestMatchState[]) $VALUES.clone();
    }

    static {
        NativeRequestMatchState r10 = new NativeRequestMatchState("REQUEST_MATCH_SUCCESS", 0, 1);
        REQUEST_MATCH_SUCCESS = r10;
        NativeRequestMatchState r11 = new NativeRequestMatchState("REQUEST_MATCH_APIKEY_FAILED", 1, 2);
        REQUEST_MATCH_APIKEY_FAILED = r11;
        NativeRequestMatchState r12 = new NativeRequestMatchState("REQUEST_MATCH_APIURL_FAILED", 2, 3);
        REQUEST_MATCH_APIURL_FAILED = r12;
        NativeRequestMatchState r13 = new NativeRequestMatchState("REQUEST_MATCH_METHOD_FAILED", 3, 4);
        REQUEST_MATCH_METHOD_FAILED = r13;
        NativeRequestMatchState r14 = new NativeRequestMatchState("REQUEST_MATCH_HEADER_FAILED", 4, 5);
        REQUEST_MATCH_HEADER_FAILED = r14;
        NativeRequestMatchState r15 = new NativeRequestMatchState("REQUEST_MATCH_PARAMS_FAILED", 5, 6);
        REQUEST_MATCH_PARAMS_FAILED = r15;
        NativeRequestMatchState r16 = new NativeRequestMatchState("REQUEST_MATCH_DATA_FAILED", 6, 7);
        REQUEST_MATCH_DATA_FAILED = r16;
        NativeRequestMatchState r17 = new NativeRequestMatchState("REQUEST_MATCH_EXPIRED", 7, 8);
        REQUEST_MATCH_EXPIRED = r17;
        $VALUES = new NativeRequestMatchState[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public final int getValue() {
        return this.value;
    }

    private NativeRequestMatchState(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
