package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes3.dex */
public final enum ErrorMode extends Enum<ErrorMode> {
    public static final ErrorMode BOUNDARY = null;
    public static final ErrorMode END = null;
    public static final ErrorMode IMMEDIATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorMode[] f18165a = null;

    static {
        ErrorMode r5 = new ErrorMode("IMMEDIATE", 0);
        IMMEDIATE = r5;
        ErrorMode r10 = new ErrorMode("BOUNDARY", 1);
        BOUNDARY = r10;
        ErrorMode r11 = new ErrorMode("END", 2);
        END = r11;
        f18165a = new ErrorMode[]{r5, r10, r11};
    }

    public static ErrorMode valueOf(String r5) {
        return (ErrorMode) Enum.valueOf(ErrorMode.class, r5);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) f18165a.clone();
    }
}
