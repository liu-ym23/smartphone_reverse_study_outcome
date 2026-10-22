package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/CPositionReplyType;", "", "", "value", "I", "getValue", "()I", "Accept", "Reject", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CPositionReplyType extends Enum<CPositionReplyType> {
    public static final CPositionReplyType Accept = null;
    public static final CPositionReplyType Reject = null;
    public static final /* synthetic */ CPositionReplyType[] a = null;
    private final int value;

    static {
        CPositionReplyType r2 = new CPositionReplyType("Accept", 0, 1);
        Accept = r2;
        CPositionReplyType r3 = new CPositionReplyType("Reject", 1, 2);
        Reject = r3;
        a = new CPositionReplyType[]{r2, r3};
    }

    public static CPositionReplyType valueOf(String r1) {
        return (CPositionReplyType) r27.a.a(CPositionReplyType.class, r1);
    }

    public static CPositionReplyType[] values() {
        return (CPositionReplyType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CPositionReplyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
