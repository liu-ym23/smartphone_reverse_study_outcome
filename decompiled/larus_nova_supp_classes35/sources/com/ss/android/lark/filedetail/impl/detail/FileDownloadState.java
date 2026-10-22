package com.ss.android.lark.filedetail.impl.detail;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum FileDownloadState extends Enum<FileDownloadState> {
    public static final FileDownloadState BURNED = null;
    public static final FileDownloadState DECRYPT_FAILED = null;
    public static final FileDownloadState DECRYPT_START = null;
    public static final FileDownloadState DLP_BLOCKED = null;
    public static final FileDownloadState DONE = null;
    public static final FileDownloadState DOWNLOADING = null;
    public static final FileDownloadState DOWNLOAD_FAILED = null;
    public static final FileDownloadState DOWNLOAD_NETWORK = null;
    public static final FileDownloadState NORMAL = null;
    public static final FileDownloadState PAUSE = null;
    public static final FileDownloadState RECALL = null;
    public static final FileDownloadState STOP = null;
    public static final FileDownloadState UNKNOWN = null;
    public static final /* synthetic */ FileDownloadState[] a = null;
    private final int value;

    static {
        FileDownloadState r0 = new FileDownloadState("NORMAL", 0, 0);
        NORMAL = r0;
        FileDownloadState r1 = new FileDownloadState("PAUSE", 1, 1);
        PAUSE = r1;
        FileDownloadState r3 = new FileDownloadState("DOWNLOADING", 2, 2);
        DOWNLOADING = r3;
        FileDownloadState r5 = new FileDownloadState("DONE", 3, 3);
        DONE = r5;
        FileDownloadState r7 = new FileDownloadState("STOP", 4, 4);
        STOP = r7;
        FileDownloadState r9 = new FileDownloadState("RECALL", 5, 5);
        RECALL = r9;
        FileDownloadState r11 = new FileDownloadState("BURNED", 6, 6);
        BURNED = r11;
        FileDownloadState r13 = new FileDownloadState("DOWNLOAD_FAILED", 7, 7);
        DOWNLOAD_FAILED = r13;
        FileDownloadState r15 = new FileDownloadState("DECRYPT_START", 8, 8);
        DECRYPT_START = r15;
        FileDownloadState r14 = new FileDownloadState("DECRYPT_FAILED", 9, 9);
        DECRYPT_FAILED = r14;
        FileDownloadState r12 = new FileDownloadState("DLP_BLOCKED", 10, 10);
        DLP_BLOCKED = r12;
        FileDownloadState r10 = new FileDownloadState("DOWNLOAD_NETWORK", 11, 11);
        DOWNLOAD_NETWORK = r10;
        FileDownloadState r8 = new FileDownloadState("UNKNOWN", 12, -1);
        UNKNOWN = r8;
        a = new FileDownloadState[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }

    public static FileDownloadState[] values() {
        return (FileDownloadState[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileDownloadState forNumber(int r0) {
        switch(r0) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L4;
        };
    L4:
        return UNKNOWN;
    L6:
        return DOWNLOAD_NETWORK;
    L8:
        return DLP_BLOCKED;
    L10:
        return DECRYPT_FAILED;
    L12:
        return DECRYPT_START;
    L14:
        return DOWNLOAD_FAILED;
    L16:
        return BURNED;
    L18:
        return RECALL;
    L20:
        return STOP;
    L22:
        return DONE;
    L24:
        return DOWNLOADING;
    L26:
        return PAUSE;
    L28:
        return NORMAL;
    }

    public static FileDownloadState valueOf(String r1) {
        return (FileDownloadState) r27.a.a(FileDownloadState.class, r1);
    }

    public static FileDownloadState valueOf(int r0) {
        return forNumber(r0);
    }

    public FileDownloadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
