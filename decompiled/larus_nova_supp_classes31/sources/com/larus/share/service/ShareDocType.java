package com.larus.share.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/share/service/ShareDocType;", "", "<init>", "(Ljava/lang/String;I)V", "SLIDES", "SHEET", "DRIVE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ShareDocType extends Enum<ShareDocType> {
    public static final ShareDocType DRIVE = null;
    public static final ShareDocType SHEET = null;
    public static final ShareDocType SLIDES = null;
    public static final /* synthetic */ ShareDocType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ShareDocType> getEntries() {
        return b;
    }

    static {
        ShareDocType r0 = new ShareDocType("SLIDES", 0);
        SLIDES = r0;
        ShareDocType r1 = new ShareDocType("SHEET", 1);
        SHEET = r1;
        ShareDocType r3 = new ShareDocType("DRIVE", 2);
        DRIVE = r3;
        ShareDocType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ShareDocType[] values() {
        return (ShareDocType[]) a.clone();
    }

    public static ShareDocType valueOf(String r1) {
        return (ShareDocType) r27.a.a(ShareDocType.class, r1);
    }

    public ShareDocType(String r1, int r2) {
        super(r1, r2);
    }
}
