package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TIMEOUT", "INTERRUPTED", "REPLACED", "PAGE_DESTROYED", "ERROR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModeEndReason extends Enum<ModeEndReason> {
    public static final ModeEndReason ERROR = null;
    public static final ModeEndReason INTERRUPTED = null;
    public static final ModeEndReason NORMAL = null;
    public static final ModeEndReason PAGE_DESTROYED = null;
    public static final ModeEndReason REPLACED = null;
    public static final ModeEndReason TIMEOUT = null;
    public static final /* synthetic */ ModeEndReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ModeEndReason> getEntries() {
        return b;
    }

    static {
        ModeEndReason r0 = new ModeEndReason("NORMAL", 0);
        NORMAL = r0;
        ModeEndReason r1 = new ModeEndReason("TIMEOUT", 1);
        TIMEOUT = r1;
        ModeEndReason r3 = new ModeEndReason("INTERRUPTED", 2);
        INTERRUPTED = r3;
        ModeEndReason r5 = new ModeEndReason("REPLACED", 3);
        REPLACED = r5;
        ModeEndReason r7 = new ModeEndReason("PAGE_DESTROYED", 4);
        PAGE_DESTROYED = r7;
        ModeEndReason r9 = new ModeEndReason("ERROR", 5);
        ERROR = r9;
        ModeEndReason[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ModeEndReason[] values() {
        return (ModeEndReason[]) a.clone();
    }

    public static ModeEndReason valueOf(String r1) {
        return (ModeEndReason) a.a(ModeEndReason.class, r1);
    }

    public ModeEndReason(String r1, int r2) {
        super(r1, r2);
    }
}
