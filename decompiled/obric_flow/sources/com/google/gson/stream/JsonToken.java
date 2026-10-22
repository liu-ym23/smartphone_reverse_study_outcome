package com.google.gson.stream;

/* JADX INFO: loaded from: classes2.dex */
public final enum JsonToken extends Enum<JsonToken> {
    private static final /* synthetic */ JsonToken[] $VALUES = null;
    public static final JsonToken BEGIN_ARRAY = null;
    public static final JsonToken BEGIN_OBJECT = null;
    public static final JsonToken BOOLEAN = null;
    public static final JsonToken END_ARRAY = null;
    public static final JsonToken END_DOCUMENT = null;
    public static final JsonToken END_OBJECT = null;
    public static final JsonToken NAME = null;
    public static final JsonToken NULL = null;
    public static final JsonToken NUMBER = null;
    public static final JsonToken STRING = null;

    private static /* synthetic */ JsonToken[] $values() {
        return new JsonToken[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, END_DOCUMENT};
    }

    static {
        BEGIN_ARRAY = new JsonToken("BEGIN_ARRAY", 0);
        END_ARRAY = new JsonToken("END_ARRAY", 1);
        BEGIN_OBJECT = new JsonToken("BEGIN_OBJECT", 2);
        END_OBJECT = new JsonToken("END_OBJECT", 3);
        NAME = new JsonToken("NAME", 4);
        STRING = new JsonToken("STRING", 5);
        NUMBER = new JsonToken("NUMBER", 6);
        BOOLEAN = new JsonToken("BOOLEAN", 7);
        NULL = new JsonToken("NULL", 8);
        END_DOCUMENT = new JsonToken("END_DOCUMENT", 9);
        $VALUES = $values();
    }

    private JsonToken(String r5, int r10) {
        super(r5, r10);
    }

    public static JsonToken valueOf(String r5) {
        return (JsonToken) Enum.valueOf(JsonToken.class, r5);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }
}
