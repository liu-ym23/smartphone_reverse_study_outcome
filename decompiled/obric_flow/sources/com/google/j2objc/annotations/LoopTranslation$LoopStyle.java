package com.google.j2objc.annotations;

/* JADX INFO: loaded from: classes2.dex */
public final enum LoopTranslation$LoopStyle extends Enum<LoopTranslation$LoopStyle> {
    public static final LoopTranslation$LoopStyle FAST_ENUMERATION = null;
    public static final LoopTranslation$LoopStyle JAVA_ITERATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoopTranslation$LoopStyle[] f9462a = null;

    static {
        LoopTranslation$LoopStyle r5 = new LoopTranslation$LoopStyle("JAVA_ITERATOR", 0);
        JAVA_ITERATOR = r5;
        LoopTranslation$LoopStyle r10 = new LoopTranslation$LoopStyle("FAST_ENUMERATION", 1);
        FAST_ENUMERATION = r10;
        f9462a = new LoopTranslation$LoopStyle[]{r5, r10};
    }

    public static LoopTranslation$LoopStyle valueOf(String r5) {
        return (LoopTranslation$LoopStyle) Enum.valueOf(LoopTranslation$LoopStyle.class, r5);
    }

    public static LoopTranslation$LoopStyle[] values() {
        return (LoopTranslation$LoopStyle[]) f9462a.clone();
    }
}
