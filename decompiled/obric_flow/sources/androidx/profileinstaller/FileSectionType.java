package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
final enum FileSectionType extends Enum<FileSectionType> {
    private static final /* synthetic */ FileSectionType[] $VALUES = null;
    public static final FileSectionType AGGREGATION_COUNT = null;
    public static final FileSectionType CLASSES = null;
    public static final FileSectionType DEX_FILES = null;
    public static final FileSectionType EXTRA_DESCRIPTORS = null;
    public static final FileSectionType METHODS = null;
    private final long mValue;

    private static /* synthetic */ FileSectionType[] $values() {
        return new FileSectionType[]{DEX_FILES, EXTRA_DESCRIPTORS, CLASSES, METHODS, AGGREGATION_COUNT};
    }

    static {
        DEX_FILES = new FileSectionType("DEX_FILES", 0, 0);
        EXTRA_DESCRIPTORS = new FileSectionType("EXTRA_DESCRIPTORS", 1, 1);
        CLASSES = new FileSectionType("CLASSES", 2, 2);
        METHODS = new FileSectionType("METHODS", 3, 3);
        AGGREGATION_COUNT = new FileSectionType("AGGREGATION_COUNT", 4, 4);
        $VALUES = $values();
    }

    private FileSectionType(String r5, int r10, long r11) {
        super(r5, r10);
        this.mValue = r11;
    }

    public static FileSectionType fromValue(long r5) {
        FileSectionType[] r10 = values();
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L11;
        if (r10[r11].getValue() == r5) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return r10[r11];
    L11:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.j(r5, "Unsupported FileSection Type "));
    }

    public static FileSectionType valueOf(String r5) {
        return (FileSectionType) Enum.valueOf(FileSectionType.class, r5);
    }

    public static FileSectionType[] values() {
        return (FileSectionType[]) $VALUES.clone();
    }

    public long getValue() {
        return this.mValue;
    }
}
