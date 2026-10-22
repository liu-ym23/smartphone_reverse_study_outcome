package com.bytedance.android.livesdk.clearscreen;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/clearscreen/ZoomType;", "", "", "type", "I", "getType", "()I", "NORMAL", "LOCK", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ZoomType extends Enum<ZoomType> {
    public static final ZoomType LOCK = null;
    public static final ZoomType NORMAL = null;
    public static final /* synthetic */ ZoomType[] a = null;
    private final int type;

    static {
        ZoomType r1 = new ZoomType("NORMAL", 0, 0);
        NORMAL = r1;
        ZoomType r2 = new ZoomType("LOCK", 1, 1);
        LOCK = r2;
        a = new ZoomType[]{r1, r2};
    }

    public static ZoomType valueOf(String r1) {
        return (ZoomType) r27.a.a(ZoomType.class, r1);
    }

    public static ZoomType[] values() {
        return (ZoomType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ZoomType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
