package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/remote/PcRemoteFileError;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_REQUEST", "INVALID_RESPONSE", "MISMATCHED_COMMAND", "UNEXPECTED_COMMAND", "FILE_NOT_FOUND", "INVALID_URL", "SERVER_ERROR", "NETWORK_ERROR", "REQUEST_TIMEOUT", "DOWNLOAD_FAILED", "ACCOUNT_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcRemoteFileError extends Enum<PcRemoteFileError> {
    public static final PcRemoteFileError ACCOUNT_CHANGED = null;
    public static final PcRemoteFileError DOWNLOAD_FAILED = null;
    public static final PcRemoteFileError FILE_NOT_FOUND = null;
    public static final PcRemoteFileError INVALID_REQUEST = null;
    public static final PcRemoteFileError INVALID_RESPONSE = null;
    public static final PcRemoteFileError INVALID_URL = null;
    public static final PcRemoteFileError MISMATCHED_COMMAND = null;
    public static final PcRemoteFileError NETWORK_ERROR = null;
    public static final PcRemoteFileError REQUEST_TIMEOUT = null;
    public static final PcRemoteFileError SERVER_ERROR = null;
    public static final PcRemoteFileError UNEXPECTED_COMMAND = null;
    public static final /* synthetic */ PcRemoteFileError[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PcRemoteFileError> getEntries() {
        return b;
    }

    static {
        PcRemoteFileError r0 = new PcRemoteFileError("INVALID_REQUEST", 0);
        INVALID_REQUEST = r0;
        PcRemoteFileError r1 = new PcRemoteFileError("INVALID_RESPONSE", 1);
        INVALID_RESPONSE = r1;
        PcRemoteFileError r3 = new PcRemoteFileError("MISMATCHED_COMMAND", 2);
        MISMATCHED_COMMAND = r3;
        PcRemoteFileError r5 = new PcRemoteFileError("UNEXPECTED_COMMAND", 3);
        UNEXPECTED_COMMAND = r5;
        PcRemoteFileError r7 = new PcRemoteFileError("FILE_NOT_FOUND", 4);
        FILE_NOT_FOUND = r7;
        PcRemoteFileError r9 = new PcRemoteFileError("INVALID_URL", 5);
        INVALID_URL = r9;
        PcRemoteFileError r11 = new PcRemoteFileError("SERVER_ERROR", 6);
        SERVER_ERROR = r11;
        PcRemoteFileError r13 = new PcRemoteFileError("NETWORK_ERROR", 7);
        NETWORK_ERROR = r13;
        PcRemoteFileError r15 = new PcRemoteFileError("REQUEST_TIMEOUT", 8);
        REQUEST_TIMEOUT = r15;
        PcRemoteFileError r14 = new PcRemoteFileError("DOWNLOAD_FAILED", 9);
        DOWNLOAD_FAILED = r14;
        PcRemoteFileError r12 = new PcRemoteFileError("ACCOUNT_CHANGED", 10);
        ACCOUNT_CHANGED = r12;
        PcRemoteFileError[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static PcRemoteFileError[] values() {
        return (PcRemoteFileError[]) a.clone();
    }

    public static PcRemoteFileError valueOf(String r1) {
        return (PcRemoteFileError) r27.a.a(PcRemoteFileError.class, r1);
    }

    public PcRemoteFileError(String r1, int r2) {
        super(r1, r2);
    }
}
