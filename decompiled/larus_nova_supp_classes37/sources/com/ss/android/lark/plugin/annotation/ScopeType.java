package com.ss.android.lark.plugin.annotation;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ScopeType extends Enum<ScopeType> {
    public static final ScopeType GLOBAL = null;
    public static final ScopeType USER = null;
    public static final /* synthetic */ ScopeType[] a = null;

    static {
        ScopeType r0 = new ScopeType("USER", 0);
        USER = r0;
        ScopeType r1 = new ScopeType("GLOBAL", 1);
        GLOBAL = r1;
        a = new ScopeType[]{r0, r1};
    }

    public static ScopeType[] values() {
        return (ScopeType[]) a.clone();
    }

    public static ScopeType valueOf(String r1) {
        return (ScopeType) a.a(ScopeType.class, r1);
    }

    public ScopeType(String r1, int r2) {
        super(r1, r2);
    }
}
