package com.ss.android.lark.download.service;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum FileDownloadState extends Enum<FileDownloadState> {
    public static final FileDownloadState DOWNLOADING = null;
    public static final FileDownloadState DOWNLOAD_CANCEL = null;
    public static final FileDownloadState DOWNLOAD_FAIL = null;
    public static final FileDownloadState DOWNLOAD_SUCCESS = null;
    public static final FileDownloadState DOWNLOAD_WAIT = null;
    public static final FileDownloadState UNKNOWN = null;
    public static final /* synthetic */ FileDownloadState[] a = null;
    private int value;

    static {
        FileDownloadState r0 = new FileDownloadState("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        FileDownloadState r1 = new FileDownloadState("DOWNLOAD_WAIT", 1, 7);
        DOWNLOAD_WAIT = r1;
        FileDownloadState r3 = new FileDownloadState("DOWNLOADING", 2, 8);
        DOWNLOADING = r3;
        FileDownloadState r4 = new FileDownloadState("DOWNLOAD_FAIL", 3, 9);
        DOWNLOAD_FAIL = r4;
        FileDownloadState r6 = new FileDownloadState("DOWNLOAD_CANCEL", 4, 10);
        DOWNLOAD_CANCEL = r6;
        FileDownloadState r8 = new FileDownloadState("DOWNLOAD_SUCCESS", 5, 11);
        DOWNLOAD_SUCCESS = r8;
        a = new FileDownloadState[]{r0, r1, r3, r4, r6, r8};
    }

    public static FileDownloadState[] values() {
        return (FileDownloadState[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileDownloadState forNumber(int r0) {
        switch(r0) {
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
        return DOWNLOAD_SUCCESS;
    L8:
        return DOWNLOAD_CANCEL;
    L10:
        return DOWNLOAD_FAIL;
    L12:
        return DOWNLOADING;
    L14:
        return DOWNLOAD_WAIT;
    }

    public static FileDownloadState valueOf(String r1) {
        return (FileDownloadState) a.a(FileDownloadState.class, r1);
    }

    public static FileDownloadState valueOf(int r0) {
        return forNumber(r0);
    }

    public FileDownloadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
