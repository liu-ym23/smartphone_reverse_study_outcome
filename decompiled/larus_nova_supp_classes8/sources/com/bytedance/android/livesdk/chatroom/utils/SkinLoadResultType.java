package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/SkinLoadResultType;", "", "START", "SUCCESS", "ERROR", "END", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkinLoadResultType extends Enum<SkinLoadResultType> {
    public static final SkinLoadResultType END = null;
    public static final SkinLoadResultType ERROR = null;
    public static final SkinLoadResultType START = null;
    public static final SkinLoadResultType SUCCESS = null;
    public static final /* synthetic */ SkinLoadResultType[] a = null;

    static {
        SkinLoadResultType r1 = new SkinLoadResultType("START", 0);
        START = r1;
        SkinLoadResultType r2 = new SkinLoadResultType("SUCCESS", 1);
        SUCCESS = r2;
        SkinLoadResultType r3 = new SkinLoadResultType("ERROR", 2);
        ERROR = r3;
        SkinLoadResultType r4 = new SkinLoadResultType("END", 3);
        END = r4;
        a = new SkinLoadResultType[]{r1, r2, r3, r4};
    }

    public static SkinLoadResultType valueOf(String r1) {
        return (SkinLoadResultType) r27.a.a(SkinLoadResultType.class, r1);
    }

    public static SkinLoadResultType[] values() {
        return (SkinLoadResultType[]) a.clone();
    }

    public SkinLoadResultType(String r1, int r2) {
        super(r1, r2);
    }
}
