package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/BizContentType;", "", "", "value", "I", "getValue", "()I", "UNKNOW", "NUMBER", "TEXT", "IMAGE", "HOT_INFO", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BizContentType extends Enum<BizContentType> {
    public static final BizContentType HOT_INFO = null;
    public static final BizContentType IMAGE = null;
    public static final BizContentType NUMBER = null;
    public static final BizContentType TEXT = null;
    public static final BizContentType UNKNOW = null;
    public static final /* synthetic */ BizContentType[] a = null;
    private final int value;

    static {
        BizContentType r1 = new BizContentType("UNKNOW", 0, 0);
        UNKNOW = r1;
        BizContentType r2 = new BizContentType("NUMBER", 1, 1);
        NUMBER = r2;
        BizContentType r3 = new BizContentType("TEXT", 2, 2);
        TEXT = r3;
        BizContentType r4 = new BizContentType("IMAGE", 3, 3);
        IMAGE = r4;
        BizContentType r5 = new BizContentType("HOT_INFO", 4, 4);
        HOT_INFO = r5;
        a = new BizContentType[]{r1, r2, r3, r4, r5};
    }

    public static BizContentType valueOf(String r1) {
        return (BizContentType) a.a(BizContentType.class, r1);
    }

    public static BizContentType[] values() {
        return (BizContentType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public BizContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
