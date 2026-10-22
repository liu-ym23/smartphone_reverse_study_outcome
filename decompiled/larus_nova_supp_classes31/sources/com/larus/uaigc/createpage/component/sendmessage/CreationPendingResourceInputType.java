package com.larus.uaigc.createpage.component.sendmessage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/uaigc/createpage/component/sendmessage/CreationPendingResourceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_PATH", "CONTENT_URI", "FILE_URI", "TOS_KEY", "REMOTE_URL", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationPendingResourceInputType extends Enum<CreationPendingResourceInputType> {
    public static final CreationPendingResourceInputType CONTENT_URI = null;
    public static final CreationPendingResourceInputType FILE_URI = null;
    public static final CreationPendingResourceInputType INVALID = null;
    public static final CreationPendingResourceInputType LOCAL_PATH = null;
    public static final CreationPendingResourceInputType REMOTE_URL = null;
    public static final CreationPendingResourceInputType TOS_KEY = null;
    public static final /* synthetic */ CreationPendingResourceInputType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationPendingResourceInputType> getEntries() {
        return b;
    }

    static {
        CreationPendingResourceInputType r0 = new CreationPendingResourceInputType("LOCAL_PATH", 0);
        LOCAL_PATH = r0;
        CreationPendingResourceInputType r1 = new CreationPendingResourceInputType("CONTENT_URI", 1);
        CONTENT_URI = r1;
        CreationPendingResourceInputType r3 = new CreationPendingResourceInputType("FILE_URI", 2);
        FILE_URI = r3;
        CreationPendingResourceInputType r5 = new CreationPendingResourceInputType("TOS_KEY", 3);
        TOS_KEY = r5;
        CreationPendingResourceInputType r7 = new CreationPendingResourceInputType("REMOTE_URL", 4);
        REMOTE_URL = r7;
        CreationPendingResourceInputType r9 = new CreationPendingResourceInputType("INVALID", 5);
        INVALID = r9;
        CreationPendingResourceInputType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static CreationPendingResourceInputType[] values() {
        return (CreationPendingResourceInputType[]) a.clone();
    }

    public static CreationPendingResourceInputType valueOf(String r1) {
        return (CreationPendingResourceInputType) r27.a.a(CreationPendingResourceInputType.class, r1);
    }

    public CreationPendingResourceInputType(String r1, int r2) {
        super(r1, r2);
    }
}
