package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/CPositionInviteType;", "", "", "value", "I", "getValue", "()I", "Enlarge", "Reduce", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CPositionInviteType extends Enum<CPositionInviteType> {
    public static final CPositionInviteType Enlarge = null;
    public static final CPositionInviteType Reduce = null;
    public static final /* synthetic */ CPositionInviteType[] a = null;
    private final int value;

    static {
        CPositionInviteType r2 = new CPositionInviteType("Enlarge", 0, 1);
        Enlarge = r2;
        CPositionInviteType r3 = new CPositionInviteType("Reduce", 1, 2);
        Reduce = r3;
        a = new CPositionInviteType[]{r2, r3};
    }

    public static CPositionInviteType valueOf(String r1) {
        return (CPositionInviteType) r27.a.a(CPositionInviteType.class, r1);
    }

    public static CPositionInviteType[] values() {
        return (CPositionInviteType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CPositionInviteType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
