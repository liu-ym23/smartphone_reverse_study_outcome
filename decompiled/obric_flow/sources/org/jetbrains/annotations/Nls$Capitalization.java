package org.jetbrains.annotations;

/* JADX INFO: loaded from: classes3.dex */
public final enum Nls$Capitalization extends Enum<Nls$Capitalization> {
    public static final Nls$Capitalization NotSpecified = null;
    public static final Nls$Capitalization Sentence = null;
    public static final Nls$Capitalization Title = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Nls$Capitalization[] f20989a = null;

    static {
        Nls$Capitalization r5 = new Nls$Capitalization("NotSpecified", 0);
        NotSpecified = r5;
        Nls$Capitalization r10 = new Nls$Capitalization("Title", 1);
        Title = r10;
        Nls$Capitalization r11 = new Nls$Capitalization("Sentence", 2);
        Sentence = r11;
        f20989a = new Nls$Capitalization[]{r5, r10, r11};
    }

    public static Nls$Capitalization valueOf(String r5) {
        return (Nls$Capitalization) Enum.valueOf(Nls$Capitalization.class, r5);
    }

    public static Nls$Capitalization[] values() {
        return (Nls$Capitalization[]) f20989a.clone();
    }
}
