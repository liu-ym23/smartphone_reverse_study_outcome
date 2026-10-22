package com.bytedance.crash.util;

/* JADX INFO: loaded from: classes2.dex */
final enum JSONWriter$Scope extends Enum<JSONWriter$Scope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONWriter$Scope f4164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONWriter$Scope f4165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final JSONWriter$Scope f4166c = null;
    public static final JSONWriter$Scope d = null;
    public static final JSONWriter$Scope e = null;
    public static final JSONWriter$Scope f = null;
    public static final /* synthetic */ JSONWriter$Scope[] g = null;

    static {
        JSONWriter$Scope r5 = new JSONWriter$Scope("EMPTY_ARRAY", 0);
        f4164a = r5;
        JSONWriter$Scope r10 = new JSONWriter$Scope("NONEMPTY_ARRAY", 1);
        f4165b = r10;
        JSONWriter$Scope r11 = new JSONWriter$Scope("EMPTY_OBJECT", 2);
        f4166c = r11;
        JSONWriter$Scope r12 = new JSONWriter$Scope("DANGLING_KEY", 3);
        d = r12;
        JSONWriter$Scope r13 = new JSONWriter$Scope("NONEMPTY_OBJECT", 4);
        e = r13;
        JSONWriter$Scope r14 = new JSONWriter$Scope("NULL", 5);
        f = r14;
        g = new JSONWriter$Scope[]{r5, r10, r11, r12, r13, r14};
    }

    public JSONWriter$Scope(String r5, int r10) {
        super(r5, r10);
    }

    public static JSONWriter$Scope valueOf(String r5) {
        return (JSONWriter$Scope) Enum.valueOf(JSONWriter$Scope.class, r5);
    }

    public static JSONWriter$Scope[] values() {
        return (JSONWriter$Scope[]) g.clone();
    }
}
