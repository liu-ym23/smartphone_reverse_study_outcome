package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/devtools/ksp/symbol/Origin;", "", "KOTLIN", "KOTLIN_LIB", "JAVA", "JAVA_LIB", "SYNTHETIC", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Origin extends Enum<Origin> {
    public static final Origin JAVA = null;
    public static final Origin JAVA_LIB = null;
    public static final Origin KOTLIN = null;
    public static final Origin KOTLIN_LIB = null;
    public static final Origin SYNTHETIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Origin[] f9455a = null;

    static {
        Origin r5 = new Origin("KOTLIN", 0);
        KOTLIN = r5;
        Origin r10 = new Origin("KOTLIN_LIB", 1);
        KOTLIN_LIB = r10;
        Origin r11 = new Origin("JAVA", 2);
        JAVA = r11;
        Origin r12 = new Origin("JAVA_LIB", 3);
        JAVA_LIB = r12;
        Origin r13 = new Origin("SYNTHETIC", 4);
        SYNTHETIC = r13;
        f9455a = new Origin[]{r5, r10, r11, r12, r13};
    }

    public static Origin valueOf(String r5) {
        return (Origin) Enum.valueOf(Origin.class, r5);
    }

    public static Origin[] values() {
        return (Origin[]) f9455a.clone();
    }
}
