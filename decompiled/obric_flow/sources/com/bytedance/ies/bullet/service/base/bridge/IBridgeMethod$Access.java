package com.bytedance.ies.bullet.service.base.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access", "", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum IBridgeMethod$Access extends Enum<IBridgeMethod$Access> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IBridgeMethod$Access f5959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IBridgeMethod$Access f5960b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ IBridgeMethod$Access[] f5961c = null;

    static {
        IBridgeMethod$Access r5 = new IBridgeMethod$Access("PUBLIC", 0);
        IBridgeMethod$Access r10 = new IBridgeMethod$Access("PRIVATE", 1);
        f5959a = r10;
        IBridgeMethod$Access r11 = new IBridgeMethod$Access("PROTECT", 2);
        IBridgeMethod$Access r12 = new IBridgeMethod$Access("SECURE", 3);
        f5960b = r12;
        f5961c = new IBridgeMethod$Access[]{r5, r10, r11, r12};
    }

    public IBridgeMethod$Access(String r5, int r10) {
        super(r5, r10);
    }

    public static IBridgeMethod$Access valueOf(String r5) {
        return (IBridgeMethod$Access) Enum.valueOf(IBridgeMethod$Access.class, r5);
    }

    public static IBridgeMethod$Access[] values() {
        return (IBridgeMethod$Access[]) f5961c.clone();
    }
}
