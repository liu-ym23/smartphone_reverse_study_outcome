package androidx.room.jarjarred.org.antlr.v4.runtime;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class VocabularyImpl implements Vocabulary {
    private static final String[] EMPTY_NAMES = null;
    public static final VocabularyImpl EMPTY_VOCABULARY = null;
    private final String[] displayNames;
    private final String[] literalNames;
    private final int maxTokenType;
    private final String[] symbolicNames;

    static {
        String[] r5 = new String[0];
        EMPTY_NAMES = r5;
        EMPTY_VOCABULARY = new VocabularyImpl(r5, r5, r5);
    }

    public VocabularyImpl(String[] r5, String[] r10) {
        this(r5, r10, null);
    }

    public static Vocabulary fromTokenNames(String[] r10) {
        if (r10 == null) goto L25;
        if (r10.length == 0) goto L25;
        String[] r5 = (String[]) Arrays.copyOf(r10, r10.length);
        String[] r11 = (String[]) Arrays.copyOf(r10, r10.length);
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L23;
        String r13 = r10[r12];
        if (r13 == null) goto L21;
        if (r13.isEmpty() == true) goto L20;
        char r14 = r13.charAt(0);
        if (r14 != '\'') goto L18;
        r11[r12] = null;
        goto L21
    L18:
        if (Character.isUpperCase(r14) == false) goto L20;
        r5[r12] = null;
    L20:
        r5[r12] = null;
        r11[r12] = null;
    L21:
        r12 = r12 + 1;
        goto L8
    L23:
        return new VocabularyImpl(r5, r11, r10);
    L25:
        return EMPTY_VOCABULARY;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary
    public String getDisplayName(int r5) {
        if (r5 < 0) goto L8;
        String[] r10 = this.displayNames;
        if (r5 >= r10.length) goto L8;
        String r11 = r10[r5];
        if (r11 == null) goto L8;
        return r11;
    L8:
        String r12 = getLiteralName(r5);
        if (r12 == null) goto L11;
        return r12;
    L11:
        String r13 = getSymbolicName(r5);
        if (r13 == null) goto L15;
        return r13;
    L15:
        return Integer.toString(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary
    public String getLiteralName(int r5) {
        if (r5 < 0) goto L7;
        String[] r10 = this.literalNames;
        if (r5 < r10.length) goto L6;
        return null;
    L6:
        return r10[r5];
    L7:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary
    public int getMaxTokenType() {
        return this.maxTokenType;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary
    public String getSymbolicName(int r5) {
        if (r5 < 0) goto L8;
        String[] r10 = this.symbolicNames;
        if (r5 >= r10.length) goto L8;
        return r10[r5];
    L8:
        if (r5 != (-1)) goto L11;
        return "EOF";
    L11:
        return null;
    }

    public VocabularyImpl(String[] r5, String[] r10, String[] r11) {
        if (r5 != null) goto L6;
        r5 = EMPTY_NAMES;
    L6:
        this.literalNames = r5;
        if (r10 != null) goto L10;
        r10 = EMPTY_NAMES;
    L10:
        this.symbolicNames = r10;
        if (r11 != null) goto L14;
        r11 = EMPTY_NAMES;
    L14:
        this.displayNames = r11;
        this.maxTokenType = Math.max(r11.length, Math.max(r5.length, r10.length)) - 1;
    }
}
