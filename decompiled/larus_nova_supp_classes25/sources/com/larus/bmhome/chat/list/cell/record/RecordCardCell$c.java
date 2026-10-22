package com.larus.bmhome.chat.list.cell.record;

import com.larus.bmhome.chat.layout.item.RecordStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public /* synthetic */ class RecordCardCell$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[RecordStatus.values().length];
        r0[RecordStatus.UNAUTHORIZED_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
    L49:
        r0[RecordStatus.EarlyEndError.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
    L59:
        r0[RecordStatus.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
    L37:
        r0[RecordStatus.Connecting.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
    L39:
        r0[RecordStatus.RECORD_ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
    L45:
        r0[RecordStatus.RECORD_FINISHED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
    L55:
        r0[RecordStatus.RecordInterruptedFinish.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
    L41:
        r0[RecordStatus.OFFLINE_ASR_ING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
    L51:
        r0[RecordStatus.SUMMARY_GENERATING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
    L53:
        r0[RecordStatus.SUMMARY_READY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
    L35:
        r0[RecordStatus.OfflineASRError.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
    L47:
        r0[RecordStatus.SecurityRiskControlError.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
    L57:
        r0[RecordStatus.SUMMARY_GENERATE_ERROR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
    L33:
        r0[RecordStatus.AVAILABLE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
    L17:
        a = r0;
    }
}
