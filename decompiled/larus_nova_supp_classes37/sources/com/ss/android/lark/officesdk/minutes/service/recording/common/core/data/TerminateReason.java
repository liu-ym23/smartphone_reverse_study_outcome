package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/TerminateReason;", "", "<init>", "(Ljava/lang/String;I)V", "MEETING_ID_EMPTY", "MINUTES_TOKEN_EMPTY", "RTC_INIT_FAILED", "DIR_CREATE_FAILED", "ALREADY_RECORDING", "MEETING_CREATED_FAILED", "UPLOAD_COMPLETED", "NON_RECORDING_TYPE", "REACH_MAX_DURATION", "UPLOAD_COMPLETED_SERVER", "OBJECT_DELETED", "NOT_LOGGED_IN", "UNAUTHORIZED", "TENANT_KEY_DELETED", "SAVE_ARTIFACT_DISABLED", "HARDWARE_DISCONNECTED", "PRIORITY_REPLACED", "HARDWARE_STOPPED", "OTHERS", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum TerminateReason extends Enum<TerminateReason> {
    public static final TerminateReason ALREADY_RECORDING = null;
    public static final TerminateReason DIR_CREATE_FAILED = null;
    public static final TerminateReason HARDWARE_DISCONNECTED = null;
    public static final TerminateReason HARDWARE_STOPPED = null;
    public static final TerminateReason MEETING_CREATED_FAILED = null;
    public static final TerminateReason MEETING_ID_EMPTY = null;
    public static final TerminateReason MINUTES_TOKEN_EMPTY = null;
    public static final TerminateReason NON_RECORDING_TYPE = null;
    public static final TerminateReason NOT_LOGGED_IN = null;
    public static final TerminateReason OBJECT_DELETED = null;
    public static final TerminateReason OTHERS = null;
    public static final TerminateReason PRIORITY_REPLACED = null;
    public static final TerminateReason REACH_MAX_DURATION = null;
    public static final TerminateReason RTC_INIT_FAILED = null;
    public static final TerminateReason SAVE_ARTIFACT_DISABLED = null;
    public static final TerminateReason TENANT_KEY_DELETED = null;
    public static final TerminateReason UNAUTHORIZED = null;
    public static final TerminateReason UPLOAD_COMPLETED = null;
    public static final TerminateReason UPLOAD_COMPLETED_SERVER = null;
    public static final /* synthetic */ TerminateReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TerminateReason> getEntries() {
        return b;
    }

    static {
        TerminateReason r0 = new TerminateReason("MEETING_ID_EMPTY", 0);
        MEETING_ID_EMPTY = r0;
        TerminateReason r1 = new TerminateReason("MINUTES_TOKEN_EMPTY", 1);
        MINUTES_TOKEN_EMPTY = r1;
        TerminateReason r3 = new TerminateReason("RTC_INIT_FAILED", 2);
        RTC_INIT_FAILED = r3;
        TerminateReason r5 = new TerminateReason("DIR_CREATE_FAILED", 3);
        DIR_CREATE_FAILED = r5;
        TerminateReason r7 = new TerminateReason("ALREADY_RECORDING", 4);
        ALREADY_RECORDING = r7;
        TerminateReason r9 = new TerminateReason("MEETING_CREATED_FAILED", 5);
        MEETING_CREATED_FAILED = r9;
        TerminateReason r11 = new TerminateReason("UPLOAD_COMPLETED", 6);
        UPLOAD_COMPLETED = r11;
        TerminateReason r13 = new TerminateReason("NON_RECORDING_TYPE", 7);
        NON_RECORDING_TYPE = r13;
        TerminateReason r15 = new TerminateReason("REACH_MAX_DURATION", 8);
        REACH_MAX_DURATION = r15;
        TerminateReason r14 = new TerminateReason("UPLOAD_COMPLETED_SERVER", 9);
        UPLOAD_COMPLETED_SERVER = r14;
        TerminateReason r12 = new TerminateReason("OBJECT_DELETED", 10);
        OBJECT_DELETED = r12;
        TerminateReason r10 = new TerminateReason("NOT_LOGGED_IN", 11);
        NOT_LOGGED_IN = r10;
        TerminateReason r8 = new TerminateReason("UNAUTHORIZED", 12);
        UNAUTHORIZED = r8;
        TerminateReason r6 = new TerminateReason("TENANT_KEY_DELETED", 13);
        TENANT_KEY_DELETED = r6;
        TerminateReason r4 = new TerminateReason("SAVE_ARTIFACT_DISABLED", 14);
        SAVE_ARTIFACT_DISABLED = r4;
        TerminateReason r2 = new TerminateReason("HARDWARE_DISCONNECTED", 15);
        HARDWARE_DISCONNECTED = r2;
        TerminateReason r16 = new TerminateReason("PRIORITY_REPLACED", 16);
        PRIORITY_REPLACED = r16;
        TerminateReason r17 = new TerminateReason("HARDWARE_STOPPED", 17);
        HARDWARE_STOPPED = r17;
        TerminateReason r18 = new TerminateReason("OTHERS", 18);
        OTHERS = r18;
        TerminateReason[] r19 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        a = r19;
        b = EnumEntriesKt.enumEntries(r19);
    }

    public static TerminateReason[] values() {
        return (TerminateReason[]) a.clone();
    }

    public static TerminateReason valueOf(String r1) {
        return (TerminateReason) a.a(TerminateReason.class, r1);
    }

    public TerminateReason(String r1, int r2) {
        super(r1, r2);
    }
}
