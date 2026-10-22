package com.ss.android.lark.chat.entity.message.content;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum FileState extends Enum<FileState> {
    public static final FileState COMPRESSING = null;
    public static final FileState DONE = null;
    public static final FileState DOWNLOAD = null;
    public static final FileState DOWNLOADING = null;
    public static final FileState PAUSE = null;
    public static final FileState UPLOADING = null;
    public static final /* synthetic */ FileState[] a = null;
    private int fileStateType;
    private int value;

    static {
        FileState r0 = new FileState("DOWNLOAD", 0, 1, 2131891753);
        DOWNLOAD = r0;
        FileState r1 = new FileState("DOWNLOADING", 1, 2, 2131891754);
        DOWNLOADING = r1;
        FileState r2 = new FileState("UPLOADING", 2, 3, 2131891756);
        UPLOADING = r2;
        FileState r5 = new FileState("COMPRESSING", 3, 4, 2131891751);
        COMPRESSING = r5;
        FileState r7 = new FileState("PAUSE", 4, 5, 2131891755);
        PAUSE = r7;
        FileState r9 = new FileState("DONE", 5, 6, 2131891752);
        DONE = r9;
        a = new FileState[]{r0, r1, r2, r5, r7, r9};
    }

    public static FileState[] values() {
        return (FileState[]) a.clone();
    }

    public int getFileStateType() {
        return this.fileStateType;
    }

    public int getValue() {
        return this.value;
    }

    public static FileState valueOf(String r1) {
        return (FileState) r27.a.a(FileState.class, r1);
    }

    public FileState(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.fileStateType = r3;
        this.value = r4;
    }
}
