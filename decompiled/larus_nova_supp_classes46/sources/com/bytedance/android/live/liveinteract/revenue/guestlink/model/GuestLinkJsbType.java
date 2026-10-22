package com.bytedance.android.live.liveinteract.revenue.guestlink.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/model/GuestLinkJsbType;", "", "ENTER_CHANNEL", "HANDLE_SERVER_EXCEPTION", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GuestLinkJsbType extends Enum<GuestLinkJsbType> {
    public static final GuestLinkJsbType ENTER_CHANNEL = null;
    public static final GuestLinkJsbType HANDLE_SERVER_EXCEPTION = null;
    public static final /* synthetic */ GuestLinkJsbType[] a = null;

    static {
        GuestLinkJsbType r1 = new GuestLinkJsbType("ENTER_CHANNEL", 0);
        ENTER_CHANNEL = r1;
        GuestLinkJsbType r2 = new GuestLinkJsbType("HANDLE_SERVER_EXCEPTION", 1);
        HANDLE_SERVER_EXCEPTION = r2;
        a = new GuestLinkJsbType[]{r1, r2};
    }

    public static GuestLinkJsbType valueOf(String r1) {
        return (GuestLinkJsbType) a.a(GuestLinkJsbType.class, r1);
    }

    public static GuestLinkJsbType[] values() {
        return (GuestLinkJsbType[]) a.clone();
    }

    public GuestLinkJsbType(String r1, int r2) {
        super(r1, r2);
    }
}
