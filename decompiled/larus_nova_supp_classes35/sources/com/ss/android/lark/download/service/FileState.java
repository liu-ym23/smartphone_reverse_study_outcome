package com.ss.android.lark.download.service;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum FileState extends Enum<FileState> {
    public static final FileState DELETED = null;
    public static final FileState FREED_UP = null;
    public static final FileState NORMAL = null;
    public static final FileState RECOVERABLE = null;
    public static final FileState UNRECOVERABLE = null;
    public static final /* synthetic */ FileState[] a = null;
    private int value;

    static {
        FileState r0 = new FileState("NORMAL", 0, 1);
        NORMAL = r0;
        FileState r1 = new FileState("DELETED", 1, 2);
        DELETED = r1;
        FileState r4 = new FileState("RECOVERABLE", 2, 3);
        RECOVERABLE = r4;
        FileState r6 = new FileState("UNRECOVERABLE", 3, 4);
        UNRECOVERABLE = r6;
        FileState r8 = new FileState("FREED_UP", 4, 5);
        FREED_UP = r8;
        a = new FileState[]{r0, r1, r4, r6, r8};
    }

    public static FileState[] values() {
        return (FileState[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FileState forNumber(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return NORMAL;
    L15:
        return FREED_UP;
    L17:
        return UNRECOVERABLE;
    L19:
        return RECOVERABLE;
    L21:
        return DELETED;
    L23:
        return NORMAL;
    }

    public static FileState valueOf(String r1) {
        return (FileState) a.a(FileState.class, r1);
    }

    public static FileState valueOf(int r0) {
        return forNumber(r0);
    }

    public FileState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
