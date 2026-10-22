package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/AdvanceRecordError;", "", "<init>", "(Ljava/lang/String;I)V", "WEAK_NET", "INTERRUPT", "RECORD_FAILED", "MEDIA_LOCK_FAILED", "REQUEST_TIMEOUT", "RECORD_TOO_SHORT", "HARDWARE_PREPARE_TOO_LONG", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AdvanceRecordError extends Enum<AdvanceRecordError> {
    public static final AdvanceRecordError HARDWARE_PREPARE_TOO_LONG = null;
    public static final AdvanceRecordError INTERRUPT = null;
    public static final AdvanceRecordError MEDIA_LOCK_FAILED = null;
    public static final AdvanceRecordError RECORD_FAILED = null;
    public static final AdvanceRecordError RECORD_TOO_SHORT = null;
    public static final AdvanceRecordError REQUEST_TIMEOUT = null;
    public static final AdvanceRecordError WEAK_NET = null;
    public static final /* synthetic */ AdvanceRecordError[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AdvanceRecordError> getEntries() {
        return b;
    }

    static {
        AdvanceRecordError r0 = new AdvanceRecordError("WEAK_NET", 0);
        WEAK_NET = r0;
        AdvanceRecordError r1 = new AdvanceRecordError("INTERRUPT", 1);
        INTERRUPT = r1;
        AdvanceRecordError r3 = new AdvanceRecordError("RECORD_FAILED", 2);
        RECORD_FAILED = r3;
        AdvanceRecordError r5 = new AdvanceRecordError("MEDIA_LOCK_FAILED", 3);
        MEDIA_LOCK_FAILED = r5;
        AdvanceRecordError r7 = new AdvanceRecordError("REQUEST_TIMEOUT", 4);
        REQUEST_TIMEOUT = r7;
        AdvanceRecordError r9 = new AdvanceRecordError("RECORD_TOO_SHORT", 5);
        RECORD_TOO_SHORT = r9;
        AdvanceRecordError r11 = new AdvanceRecordError("HARDWARE_PREPARE_TOO_LONG", 6);
        HARDWARE_PREPARE_TOO_LONG = r11;
        AdvanceRecordError[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static AdvanceRecordError[] values() {
        return (AdvanceRecordError[]) a.clone();
    }

    public static AdvanceRecordError valueOf(String r1) {
        return (AdvanceRecordError) r27.a.a(AdvanceRecordError.class, r1);
    }

    public AdvanceRecordError(String r1, int r2) {
        super(r1, r2);
    }
}
