package com.bytedance.android.anniex.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/utils/AnnieXDDPFSignalScopeEnum;", "", "", "signalScope", "Ljava/lang/String;", "getSignalScope", "()Ljava/lang/String;", "CPU", "MEMORY", "ANR", "JIT", "GC", "STORAGE", "POWER", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXDDPFSignalScopeEnum extends Enum<AnnieXDDPFSignalScopeEnum> {
    public static final AnnieXDDPFSignalScopeEnum ANR = null;
    public static final AnnieXDDPFSignalScopeEnum CPU = null;
    public static final AnnieXDDPFSignalScopeEnum GC = null;
    public static final AnnieXDDPFSignalScopeEnum JIT = null;
    public static final AnnieXDDPFSignalScopeEnum MEMORY = null;
    public static final AnnieXDDPFSignalScopeEnum POWER = null;
    public static final AnnieXDDPFSignalScopeEnum STORAGE = null;
    public static final AnnieXDDPFSignalScopeEnum UNKNOWN = null;
    public static final /* synthetic */ AnnieXDDPFSignalScopeEnum[] a = null;
    private final String signalScope;

    public static AnnieXDDPFSignalScopeEnum valueOf(String r1) {
        return (AnnieXDDPFSignalScopeEnum) r27.a.a(AnnieXDDPFSignalScopeEnum.class, r1);
    }

    public static AnnieXDDPFSignalScopeEnum[] values() {
        return (AnnieXDDPFSignalScopeEnum[]) a.clone();
    }

    static {
        AnnieXDDPFSignalScopeEnum r0 = new AnnieXDDPFSignalScopeEnum("CPU", 0, "cpu");
        CPU = r0;
        AnnieXDDPFSignalScopeEnum r1 = new AnnieXDDPFSignalScopeEnum("MEMORY", 1, "memory");
        MEMORY = r1;
        AnnieXDDPFSignalScopeEnum r10 = new AnnieXDDPFSignalScopeEnum("ANR", 2, "anr");
        ANR = r10;
        AnnieXDDPFSignalScopeEnum r11 = new AnnieXDDPFSignalScopeEnum("JIT", 3, "jit");
        JIT = r11;
        AnnieXDDPFSignalScopeEnum r12 = new AnnieXDDPFSignalScopeEnum("GC", 4, "gc");
        GC = r12;
        AnnieXDDPFSignalScopeEnum r13 = new AnnieXDDPFSignalScopeEnum("STORAGE", 5, "storage");
        STORAGE = r13;
        AnnieXDDPFSignalScopeEnum r14 = new AnnieXDDPFSignalScopeEnum("POWER", 6, "power");
        POWER = r14;
        AnnieXDDPFSignalScopeEnum r15 = new AnnieXDDPFSignalScopeEnum("UNKNOWN", 7, "unknown");
        UNKNOWN = r15;
        a = new AnnieXDDPFSignalScopeEnum[]{r0, r1, r10, r11, r12, r13, r14, r15};
    }

    public final String getSignalScope() {
        return this.signalScope;
    }

    public AnnieXDDPFSignalScopeEnum(String r1, int r10, String r11) {
        super(r1, r10);
        this.signalScope = r11;
    }
}
