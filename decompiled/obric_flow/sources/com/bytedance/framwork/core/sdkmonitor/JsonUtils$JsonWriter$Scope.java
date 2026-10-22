package com.bytedance.framwork.core.sdkmonitor;

/* JADX INFO: loaded from: classes2.dex */
final enum JsonUtils$JsonWriter$Scope extends Enum<JsonUtils$JsonWriter$Scope> {
    public static final JsonUtils$JsonWriter$Scope DANGLING_KEY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope EMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_ARRAY = null;
    public static final JsonUtils$JsonWriter$Scope NONEMPTY_OBJECT = null;
    public static final JsonUtils$JsonWriter$Scope NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsonUtils$JsonWriter$Scope[] f4700a = null;

    static {
        JsonUtils$JsonWriter$Scope r5 = new JsonUtils$JsonWriter$Scope("EMPTY_ARRAY", 0);
        EMPTY_ARRAY = r5;
        JsonUtils$JsonWriter$Scope r10 = new JsonUtils$JsonWriter$Scope("NONEMPTY_ARRAY", 1);
        NONEMPTY_ARRAY = r10;
        JsonUtils$JsonWriter$Scope r11 = new JsonUtils$JsonWriter$Scope("EMPTY_OBJECT", 2);
        EMPTY_OBJECT = r11;
        JsonUtils$JsonWriter$Scope r12 = new JsonUtils$JsonWriter$Scope("DANGLING_KEY", 3);
        DANGLING_KEY = r12;
        JsonUtils$JsonWriter$Scope r13 = new JsonUtils$JsonWriter$Scope("NONEMPTY_OBJECT", 4);
        NONEMPTY_OBJECT = r13;
        JsonUtils$JsonWriter$Scope r14 = new JsonUtils$JsonWriter$Scope("NULL", 5);
        NULL = r14;
        f4700a = new JsonUtils$JsonWriter$Scope[]{r5, r10, r11, r12, r13, r14};
    }

    public static JsonUtils$JsonWriter$Scope valueOf(String r5) {
        return (JsonUtils$JsonWriter$Scope) Enum.valueOf(JsonUtils$JsonWriter$Scope.class, r5);
    }

    public static JsonUtils$JsonWriter$Scope[] values() {
        return (JsonUtils$JsonWriter$Scope[]) f4700a.clone();
    }
}
