package com.bytedance.android.live.liveinteract.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/LinkScreenCastType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "", "typeValue", "I", "getTypeValue", "()I", "CAST_TYPE_UNKNOWN", "CAST_TYPE_GAME", "CAST_TYPE_MINI_APP", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkScreenCastType extends Enum<LinkScreenCastType> {
    public static final LinkScreenCastType CAST_TYPE_GAME = null;
    public static final LinkScreenCastType CAST_TYPE_MINI_APP = null;
    public static final LinkScreenCastType CAST_TYPE_UNKNOWN = null;
    public static final /* synthetic */ LinkScreenCastType[] a = null;
    private final String typeName;
    private final int typeValue;

    static {
        LinkScreenCastType r1 = new LinkScreenCastType("CAST_TYPE_UNKNOWN", 0, "未知类型", 0);
        CAST_TYPE_UNKNOWN = r1;
        LinkScreenCastType r2 = new LinkScreenCastType("CAST_TYPE_GAME", 1, "小游戏", 1);
        CAST_TYPE_GAME = r2;
        LinkScreenCastType r3 = new LinkScreenCastType("CAST_TYPE_MINI_APP", 2, "小程序", 2);
        CAST_TYPE_MINI_APP = r3;
        a = new LinkScreenCastType[]{r1, r2, r3};
    }

    public static LinkScreenCastType valueOf(String r1) {
        return (LinkScreenCastType) r27.a.a(LinkScreenCastType.class, r1);
    }

    public static LinkScreenCastType[] values() {
        return (LinkScreenCastType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final int getTypeValue() {
        return this.typeValue;
    }

    public LinkScreenCastType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.typeName = r3;
        this.typeValue = r4;
    }
}
