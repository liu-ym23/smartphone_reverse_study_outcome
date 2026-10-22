package com.obric.update.api.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/update/api/v2/ObricBannerType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "AVAILABLE", "DOWNLOADING", "WIFI_DOWNLOADING", "STATE_DOWNLOADED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricBannerType extends Enum<ObricBannerType> {
    public static final ObricBannerType AVAILABLE = null;
    public static final ObricBannerType DOWNLOADING = null;
    public static final ObricBannerType STATE_DOWNLOADED = null;
    public static final ObricBannerType UNKNOWN = null;
    public static final ObricBannerType WIFI_DOWNLOADING = null;
    public static final /* synthetic */ ObricBannerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ObricBannerType> getEntries() {
        return b;
    }

    static {
        ObricBannerType r0 = new ObricBannerType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ObricBannerType r1 = new ObricBannerType("AVAILABLE", 1, 1);
        AVAILABLE = r1;
        ObricBannerType r3 = new ObricBannerType("DOWNLOADING", 2, 2);
        DOWNLOADING = r3;
        ObricBannerType r5 = new ObricBannerType("WIFI_DOWNLOADING", 3, 3);
        WIFI_DOWNLOADING = r5;
        ObricBannerType r7 = new ObricBannerType("STATE_DOWNLOADED", 4, 4);
        STATE_DOWNLOADED = r7;
        ObricBannerType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ObricBannerType[] values() {
        return (ObricBannerType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricBannerType valueOf(String r1) {
        return (ObricBannerType) a.a(ObricBannerType.class, r1);
    }

    public ObricBannerType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
