package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/audio/enroll/model/EnrollState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ENROLLING", "ENROLLED_SUCCESS", "ENROLLED_FAILED", "ENROLLED_INTERRUPT", "NEW_ENROLLING", "NEW_ENROLLED_SUCCESS", "NEW_ENROLLED_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnrollState extends Enum<EnrollState> {
    public static final EnrollState ENROLLED_FAILED = null;
    public static final EnrollState ENROLLED_INTERRUPT = null;
    public static final EnrollState ENROLLED_SUCCESS = null;
    public static final EnrollState ENROLLING = null;
    public static final EnrollState IDLE = null;
    public static final EnrollState NEW_ENROLLED_FAILED = null;
    public static final EnrollState NEW_ENROLLED_SUCCESS = null;
    public static final EnrollState NEW_ENROLLING = null;
    public static final /* synthetic */ EnrollState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<EnrollState> getEntries() {
        return b;
    }

    static {
        EnrollState r0 = new EnrollState("IDLE", 0);
        IDLE = r0;
        EnrollState r1 = new EnrollState("ENROLLING", 1);
        ENROLLING = r1;
        EnrollState r3 = new EnrollState("ENROLLED_SUCCESS", 2);
        ENROLLED_SUCCESS = r3;
        EnrollState r5 = new EnrollState("ENROLLED_FAILED", 3);
        ENROLLED_FAILED = r5;
        EnrollState r7 = new EnrollState("ENROLLED_INTERRUPT", 4);
        ENROLLED_INTERRUPT = r7;
        EnrollState r9 = new EnrollState("NEW_ENROLLING", 5);
        NEW_ENROLLING = r9;
        EnrollState r11 = new EnrollState("NEW_ENROLLED_SUCCESS", 6);
        NEW_ENROLLED_SUCCESS = r11;
        EnrollState r13 = new EnrollState("NEW_ENROLLED_FAILED", 7);
        NEW_ENROLLED_FAILED = r13;
        EnrollState[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static EnrollState[] values() {
        return (EnrollState[]) a.clone();
    }

    public static EnrollState valueOf(String r1) {
        return (EnrollState) a.a(EnrollState.class, r1);
    }

    public EnrollState(String r1, int r2) {
        super(r1, r2);
    }
}
