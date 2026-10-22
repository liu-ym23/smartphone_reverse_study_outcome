package com.bytedance.iesgurd.core;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/iesgurd/core/ReqType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "REGISTER_LATE", "NORMAL", "POLLING", "BYTESYNC", "LAZY", "QUEUE", "CUSTOM_REQUEST", "UPDATE_BY_ACCESS", "UPDATE_BY_PRE_ACCESS", "PROBE", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final enum ReqType extends Enum<ReqType> {
    private static final /* synthetic */ ReqType[] $VALUES = null;
    public static final ReqType BYTESYNC = null;
    public static final ReqType CUSTOM_REQUEST = null;
    public static final ReqType LAZY = null;
    public static final ReqType NONE = null;
    public static final ReqType NORMAL = null;
    public static final ReqType POLLING = null;
    public static final ReqType PROBE = null;
    public static final ReqType QUEUE = null;
    public static final ReqType REGISTER_LATE = null;
    public static final ReqType UPDATE_BY_ACCESS = null;
    public static final ReqType UPDATE_BY_PRE_ACCESS = null;
    private final int type;

    static {
        ReqType r5 = new ReqType("NONE", 0, -1);
        NONE = r5;
        ReqType r10 = new ReqType("REGISTER_LATE", 1, 0);
        REGISTER_LATE = r10;
        ReqType r11 = new ReqType("NORMAL", 2, 1);
        NORMAL = r11;
        ReqType r12 = new ReqType("POLLING", 3, 3);
        POLLING = r12;
        ReqType r13 = new ReqType("BYTESYNC", 4, 4);
        BYTESYNC = r13;
        ReqType r14 = new ReqType("LAZY", 5, 5);
        LAZY = r14;
        ReqType r15 = new ReqType("QUEUE", 6, 6);
        QUEUE = r15;
        ReqType r16 = new ReqType("CUSTOM_REQUEST", 7, 7);
        CUSTOM_REQUEST = r16;
        ReqType r17 = new ReqType("UPDATE_BY_ACCESS", 8, 8);
        UPDATE_BY_ACCESS = r17;
        ReqType r18 = new ReqType("UPDATE_BY_PRE_ACCESS", 9, 9);
        UPDATE_BY_PRE_ACCESS = r18;
        ReqType r19 = new ReqType("PROBE", 10, 10);
        PROBE = r19;
        $VALUES = new ReqType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    private ReqType(String r5, int r10, int r11) {
        super(r5, r10);
        this.type = r11;
    }

    public static ReqType valueOf(String r5) {
        return (ReqType) Enum.valueOf(ReqType.class, r5);
    }

    public static ReqType[] values() {
        return (ReqType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
