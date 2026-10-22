package com.airbnb.lottie.parser.moshi;

/* JADX INFO: loaded from: classes.dex */
public final enum JsonReader$Token extends Enum<JsonReader$Token> {
    public static final JsonReader$Token BEGIN_ARRAY = null;
    public static final JsonReader$Token BEGIN_OBJECT = null;
    public static final JsonReader$Token BOOLEAN = null;
    public static final JsonReader$Token END_ARRAY = null;
    public static final JsonReader$Token END_DOCUMENT = null;
    public static final JsonReader$Token END_OBJECT = null;
    public static final JsonReader$Token NAME = null;
    public static final JsonReader$Token NULL = null;
    public static final JsonReader$Token NUMBER = null;
    public static final JsonReader$Token STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JsonReader$Token[] f1301a = null;

    static {
        JsonReader$Token r5 = new JsonReader$Token("BEGIN_ARRAY", 0);
        BEGIN_ARRAY = r5;
        JsonReader$Token r10 = new JsonReader$Token("END_ARRAY", 1);
        END_ARRAY = r10;
        JsonReader$Token r11 = new JsonReader$Token("BEGIN_OBJECT", 2);
        BEGIN_OBJECT = r11;
        JsonReader$Token r12 = new JsonReader$Token("END_OBJECT", 3);
        END_OBJECT = r12;
        JsonReader$Token r13 = new JsonReader$Token("NAME", 4);
        NAME = r13;
        JsonReader$Token r14 = new JsonReader$Token("STRING", 5);
        STRING = r14;
        JsonReader$Token r15 = new JsonReader$Token("NUMBER", 6);
        NUMBER = r15;
        JsonReader$Token r16 = new JsonReader$Token("BOOLEAN", 7);
        BOOLEAN = r16;
        JsonReader$Token r17 = new JsonReader$Token("NULL", 8);
        NULL = r17;
        JsonReader$Token r18 = new JsonReader$Token("END_DOCUMENT", 9);
        END_DOCUMENT = r18;
        f1301a = new JsonReader$Token[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public static JsonReader$Token valueOf(String r5) {
        return (JsonReader$Token) Enum.valueOf(JsonReader$Token.class, r5);
    }

    public static JsonReader$Token[] values() {
        return (JsonReader$Token[]) f1301a.clone();
    }
}
