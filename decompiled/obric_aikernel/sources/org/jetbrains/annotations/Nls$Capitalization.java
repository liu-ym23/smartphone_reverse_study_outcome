package org.jetbrains.annotations;

/* JADX INFO: loaded from: classes3.dex */
public final enum Nls$Capitalization extends Enum<Nls$Capitalization> {
    private static final /* synthetic */ Nls$Capitalization[] $VALUES = null;
    public static final Nls$Capitalization NotSpecified = null;
    public static final Nls$Capitalization Sentence = null;
    public static final Nls$Capitalization Title = null;

    static {
        Nls$Capitalization r10 = new Nls$Capitalization("NotSpecified", 0);
        NotSpecified = r10;
        Nls$Capitalization r11 = new Nls$Capitalization("Title", 1);
        Title = r11;
        Nls$Capitalization r12 = new Nls$Capitalization("Sentence", 2);
        Sentence = r12;
        $VALUES = new Nls$Capitalization[]{r10, r11, r12};
    }

    private Nls$Capitalization(String r10, int r11) {
        super(r10, r11);
    }

    public static Nls$Capitalization valueOf(String r10) {
        return (Nls$Capitalization) Enum.valueOf(Nls$Capitalization.class, r10);
    }

    public static Nls$Capitalization[] values() {
        return (Nls$Capitalization[]) $VALUES.clone();
    }
}
