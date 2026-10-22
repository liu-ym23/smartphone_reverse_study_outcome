package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/google/devtools/ksp/symbol/Visibility;", "", "PUBLIC", "PRIVATE", "PROTECTED", "INTERNAL", "LOCAL", "JAVA_PACKAGE", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility INTERNAL = null;
    public static final Visibility JAVA_PACKAGE = null;
    public static final Visibility LOCAL = null;
    public static final Visibility PRIVATE = null;
    public static final Visibility PROTECTED = null;
    public static final Visibility PUBLIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Visibility[] f9457a = null;

    static {
        Visibility r5 = new Visibility("PUBLIC", 0);
        PUBLIC = r5;
        Visibility r10 = new Visibility("PRIVATE", 1);
        PRIVATE = r10;
        Visibility r11 = new Visibility("PROTECTED", 2);
        PROTECTED = r11;
        Visibility r12 = new Visibility("INTERNAL", 3);
        INTERNAL = r12;
        Visibility r13 = new Visibility("LOCAL", 4);
        LOCAL = r13;
        Visibility r14 = new Visibility("JAVA_PACKAGE", 5);
        JAVA_PACKAGE = r14;
        f9457a = new Visibility[]{r5, r10, r11, r12, r13, r14};
    }

    public static Visibility valueOf(String r5) {
        return (Visibility) Enum.valueOf(Visibility.class, r5);
    }

    public static Visibility[] values() {
        return (Visibility[]) f9457a.clone();
    }
}
