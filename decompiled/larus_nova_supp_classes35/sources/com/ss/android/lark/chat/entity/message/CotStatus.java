package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/CotStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NONE", "RUNNING", "DONE", "ERROR", "TIMEOUT", "INTERRUPTED", "PAUSED", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotStatus extends Enum<CotStatus> {
    public static final a Companion = null;
    public static final CotStatus DONE = null;
    public static final CotStatus ERROR = null;
    public static final CotStatus INTERRUPTED = null;
    public static final CotStatus NONE = null;
    public static final CotStatus PAUSED = null;
    public static final CotStatus RUNNING = null;
    public static final CotStatus TIMEOUT = null;
    public static final /* synthetic */ CotStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CotStatus> getEntries() {
        return b;
    }

    static {
        CotStatus r0 = new CotStatus("NONE", 0);
        NONE = r0;
        CotStatus r1 = new CotStatus("RUNNING", 1);
        RUNNING = r1;
        CotStatus r3 = new CotStatus("DONE", 2);
        DONE = r3;
        CotStatus r5 = new CotStatus("ERROR", 3);
        ERROR = r5;
        CotStatus r7 = new CotStatus("TIMEOUT", 4);
        TIMEOUT = r7;
        CotStatus r9 = new CotStatus("INTERRUPTED", 5);
        INTERRUPTED = r9;
        CotStatus r11 = new CotStatus("PAUSED", 6);
        PAUSED = r11;
        CotStatus[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static CotStatus[] values() {
        return (CotStatus[]) a.clone();
    }

    @JvmStatic
    public static final CotStatus fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return NONE;
    L17:
        return TIMEOUT;
    L18:
        return ERROR;
    L19:
        return DONE;
    L15:
        return RUNNING;
    }

    public static CotStatus valueOf(String r1) {
        return (CotStatus) r27.a.a(CotStatus.class, r1);
    }

    public CotStatus(String r1, int r2) {
        super(r1, r2);
    }
}
