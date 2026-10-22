package com.ss.android.lark.chat.cot;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotBlockStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PENDING", "RUNNING", "DONE", "ERROR", "VIOLATED", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotBlockStatus extends Enum<CotBlockStatus> {
    public static final CotBlockStatus DONE = null;
    public static final CotBlockStatus ERROR = null;
    public static final CotBlockStatus PENDING = null;
    public static final CotBlockStatus RUNNING = null;
    public static final CotBlockStatus VIOLATED = null;
    public static final /* synthetic */ CotBlockStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CotBlockStatus> getEntries() {
        return b;
    }

    static {
        CotBlockStatus r0 = new CotBlockStatus("PENDING", 0);
        PENDING = r0;
        CotBlockStatus r1 = new CotBlockStatus("RUNNING", 1);
        RUNNING = r1;
        CotBlockStatus r3 = new CotBlockStatus("DONE", 2);
        DONE = r3;
        CotBlockStatus r5 = new CotBlockStatus("ERROR", 3);
        ERROR = r5;
        CotBlockStatus r7 = new CotBlockStatus("VIOLATED", 4);
        VIOLATED = r7;
        CotBlockStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CotBlockStatus[] values() {
        return (CotBlockStatus[]) a.clone();
    }

    public static CotBlockStatus valueOf(String r1) {
        return (CotBlockStatus) r27.a.a(CotBlockStatus.class, r1);
    }

    public CotBlockStatus(String r1, int r2) {
        super(r1, r2);
    }
}
