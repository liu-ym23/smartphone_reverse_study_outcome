package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes2.dex */
public final enum Md5CheckStatus extends Enum<Md5CheckStatus> {
    private static final /* synthetic */ Md5CheckStatus[] $VALUES = null;
    public static final Md5CheckStatus INVALID_FILE_MD5_EMPTY = null;
    public static final Md5CheckStatus INVALID_FILE_NO_EXIST = null;
    public static final Md5CheckStatus INVALID_MD5_NOT_EQUALS = null;
    public static final Md5CheckStatus VALID = null;

    static {
        Md5CheckStatus r10 = new Md5CheckStatus("VALID", 0);
        VALID = r10;
        Md5CheckStatus r11 = new Md5CheckStatus("INVALID_FILE_NO_EXIST", 1);
        INVALID_FILE_NO_EXIST = r11;
        Md5CheckStatus r12 = new Md5CheckStatus("INVALID_FILE_MD5_EMPTY", 2);
        INVALID_FILE_MD5_EMPTY = r12;
        Md5CheckStatus r13 = new Md5CheckStatus("INVALID_MD5_NOT_EQUALS", 3);
        INVALID_MD5_NOT_EQUALS = r13;
        $VALUES = new Md5CheckStatus[]{r10, r11, r12, r13};
    }

    private Md5CheckStatus(String r10, int r11) {
        super(r10, r11);
    }

    public static Md5CheckStatus valueOf(String r10) {
        return (Md5CheckStatus) Enum.valueOf(Md5CheckStatus.class, r10);
    }

    public static Md5CheckStatus[] values() {
        return (Md5CheckStatus[]) $VALUES.clone();
    }
}
