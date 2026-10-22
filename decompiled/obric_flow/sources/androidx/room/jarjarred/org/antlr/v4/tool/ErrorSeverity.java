package androidx.room.jarjarred.org.antlr.v4.tool;

/* JADX INFO: loaded from: classes.dex */
public final enum ErrorSeverity extends Enum<ErrorSeverity> {
    private static final /* synthetic */ ErrorSeverity[] $VALUES = null;
    public static final ErrorSeverity ERROR = null;
    public static final ErrorSeverity ERROR_ONE_OFF = null;
    public static final ErrorSeverity FATAL = null;
    public static final ErrorSeverity INFO = null;
    public static final ErrorSeverity WARNING = null;
    public static final ErrorSeverity WARNING_ONE_OFF = null;
    private final String text;

    static {
        ErrorSeverity r5 = new ErrorSeverity("INFO", 0, "info");
        INFO = r5;
        ErrorSeverity r10 = new ErrorSeverity("WARNING", 1, "warning");
        WARNING = r10;
        ErrorSeverity r11 = new ErrorSeverity("WARNING_ONE_OFF", 2, "warning");
        WARNING_ONE_OFF = r11;
        ErrorSeverity r12 = new ErrorSeverity("ERROR", 3, "error");
        ERROR = r12;
        ErrorSeverity r13 = new ErrorSeverity("ERROR_ONE_OFF", 4, "error");
        ERROR_ONE_OFF = r13;
        ErrorSeverity r14 = new ErrorSeverity("FATAL", 5, "fatal");
        FATAL = r14;
        $VALUES = new ErrorSeverity[]{r5, r10, r11, r12, r13, r14};
    }

    private ErrorSeverity(String r5, int r10, String r11) {
        super(r5, r10);
        this.text = r11;
    }

    public static ErrorSeverity valueOf(String r5) {
        return (ErrorSeverity) Enum.valueOf(ErrorSeverity.class, r5);
    }

    public static ErrorSeverity[] values() {
        return (ErrorSeverity[]) $VALUES.clone();
    }

    public String getText() {
        return this.text;
    }
}
