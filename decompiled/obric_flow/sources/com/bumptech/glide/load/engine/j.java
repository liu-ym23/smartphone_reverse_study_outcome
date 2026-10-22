package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1519c;

    public j() {
        this.f1517a = false;
        this.f1518b = false;
        this.f1519c = false;
    }

    public void a(StringBuilder r10, int r11) {
        if (r10.length() != 0) goto L5;
        return;
    L5:
        boolean r5 = true;
        if (Character.isHighSurrogate(r10.charAt(r10.length() - 1)) == false) goto L9;
        this.f1519c = true;
        return;
    L9:
        int r12 = r10.length();
        if (this.f1519c == false) goto L12;
        int r13 = 2;
    L13:
        int r14 = r12 - r13;
        int r15 = r10.codePointAt(r14);
        if (r11 != 1) goto L35;
        Character.UnicodeBlock r16 = Character.UnicodeBlock.of(r15);
        if (r16 != Character.UnicodeBlock.BASIC_LATIN) goto L18;
    L31:
        if (r5 == false) goto L33;
    L34:
        r10.delete(r14, r10.length());
        r10.append(8203);
        r10.appendCodePoint(r15);
        this.f1518b = r5;
    L62:
        this.f1519c = false;
        return;
    L33:
        if (this.f1518b == false) goto L62;
    L18:
        if (r16 == Character.UnicodeBlock.LATIN_1_SUPPLEMENT) goto L31;
        if (r16 == Character.UnicodeBlock.LATIN_EXTENDED_A) goto L31;
        if (r16 == Character.UnicodeBlock.LATIN_EXTENDED_B) goto L31;
        if (r16 == Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L31;
        if (r16 == Character.UnicodeBlock.CURRENCY_SYMBOLS) goto L31;
        if (r16 == Character.UnicodeBlock.MATHEMATICAL_OPERATORS) goto L31;
        r5 = false;
        goto L31
    L35:
        if (r11 != 2) goto L62;
        Character.UnicodeBlock r17 = Character.UnicodeBlock.of(r15);
        if (r17 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L59;
        if (r17 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L59;
        if (r17 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) goto L59;
        if (r17 == Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT) goto L59;
        if (r17 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L59;
        if (r17 == Character.UnicodeBlock.KATAKANA) goto L59;
        if (r17 == Character.UnicodeBlock.HIRAGANA) goto L59;
        if (r17 == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) goto L59;
        if (r17 == Character.UnicodeBlock.HANGUL_JAMO) goto L59;
        if (r17 == Character.UnicodeBlock.HANGUL_SYLLABLES) goto L59;
        this.f1517a = false;
    L59:
        if (this.f1517a == false) goto L61;
        r10.delete(r14, r10.length());
        r10.append(8288);
        r10.appendCodePoint(r15);
        goto L62
    L61:
        this.f1517a = true;
        goto L62
    L12:
        r13 = 1;
        goto L13
    }

    public boolean b() {
        if (this.f1519c == true) goto L7;
        if (this.f1518b == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f1517a == false) goto L9;
        return true;
    }
}
