package com.google.thirdparty.publicsuffix;

/* JADX INFO: loaded from: classes2.dex */
public final enum PublicSuffixType extends Enum<PublicSuffixType> {
    public static final PublicSuffixType PRIVATE = null;
    public static final PublicSuffixType REGISTRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicSuffixType[] f9464a = null;
    private final char innerNodeCode;
    private final char leafNodeCode;

    static {
        PublicSuffixType r5 = new PublicSuffixType("PRIVATE", 0, ':', ',');
        PRIVATE = r5;
        PublicSuffixType r10 = new PublicSuffixType("REGISTRY", 1, '!', '?');
        REGISTRY = r10;
        f9464a = new PublicSuffixType[]{r5, r10};
    }

    public PublicSuffixType(String r5, int r10, char r11, char r12) {
        super(r5, r10);
        this.innerNodeCode = r11;
        this.leafNodeCode = r12;
    }

    public static PublicSuffixType fromCode(char r5) {
        PublicSuffixType[] r10 = values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        PublicSuffixType r13 = r10[r12];
        if (r13.getInnerNodeCode() == r5) goto L10;
        if (r13.getLeafNodeCode() == r5) goto L10;
        r12 = r12 + 1;
    L10:
        return r13;
    L11:
        StringBuilder r14 = new StringBuilder(38);
        r14.append("No enum corresponding to given code: ");
        r14.append(r5);
        throw new IllegalArgumentException(r14.toString());
    }

    public static PublicSuffixType valueOf(String r5) {
        return (PublicSuffixType) Enum.valueOf(PublicSuffixType.class, r5);
    }

    public static PublicSuffixType[] values() {
        return (PublicSuffixType[]) f9464a.clone();
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
