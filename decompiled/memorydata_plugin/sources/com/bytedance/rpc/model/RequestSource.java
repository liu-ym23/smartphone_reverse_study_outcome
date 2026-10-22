package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RequestSource extends Enum<RequestSource> {
    private static final /* synthetic */ RequestSource[] $VALUES = null;

    @SerializedName("2")
    public static final RequestSource APPFC_INTENT = null;

    @SerializedName("3")
    public static final RequestSource COMPLEX_TASK = null;

    @SerializedName("0")
    public static final RequestSource DEFAULT = null;

    @SerializedName("5")
    public static final RequestSource MCP_HUB = null;

    @SerializedName("255")
    public static final RequestSource OTHERS = null;

    @SerializedName("4")
    public static final RequestSource QA_SEARCH = null;

    @SerializedName("1")
    public static final RequestSource SIMPLE_INTENT = null;
    private final int value;

    static {
        RequestSource r0 = new RequestSource("DEFAULT", 0, 0);
        DEFAULT = r0;
        RequestSource r1 = new RequestSource("SIMPLE_INTENT", 1, 1);
        SIMPLE_INTENT = r1;
        RequestSource r3 = new RequestSource("APPFC_INTENT", 2, 2);
        APPFC_INTENT = r3;
        RequestSource r5 = new RequestSource("COMPLEX_TASK", 3, 3);
        COMPLEX_TASK = r5;
        RequestSource r7 = new RequestSource("QA_SEARCH", 4, 4);
        QA_SEARCH = r7;
        RequestSource r9 = new RequestSource("MCP_HUB", 5, 5);
        MCP_HUB = r9;
        RequestSource r11 = new RequestSource("OTHERS", 6, 255);
        OTHERS = r11;
        $VALUES = new RequestSource[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private RequestSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RequestSource findByValue(int r1) {
        if (r1 == 0) goto L30;
        if (r1 == 1) goto L28;
        if (r1 == 2) goto L26;
        if (r1 == 3) goto L24;
        if (r1 == 4) goto L22;
        if (r1 == 5) goto L20;
        if (r1 == 255) goto L18;
        return null;
    L18:
        return OTHERS;
    L20:
        return MCP_HUB;
    L22:
        return QA_SEARCH;
    L24:
        return COMPLEX_TASK;
    L26:
        return APPFC_INTENT;
    L28:
        return SIMPLE_INTENT;
    L30:
        return DEFAULT;
    }

    public static RequestSource valueOf(String r2) {
        return (RequestSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(RequestSource.class, r2), RequestSource.class, "com.obric.memorydata.plugin");
    }

    public static RequestSource[] values() {
        return (RequestSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RequestSource[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
