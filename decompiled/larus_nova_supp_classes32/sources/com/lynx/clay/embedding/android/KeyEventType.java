package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum KeyEventType extends Enum<KeyEventType> {
    public static final KeyEventType COMMIT_COMPOSING_TEXT = null;
    public static final KeyEventType COMMIT_TEXT = null;
    public static final KeyEventType DOWN = null;
    public static final KeyEventType REPEAT = null;
    public static final KeyEventType UP = null;
    public static final /* synthetic */ KeyEventType[] a = null;

    static {
        KeyEventType r0 = new KeyEventType("DOWN", 0);
        DOWN = r0;
        KeyEventType r1 = new KeyEventType("UP", 1);
        UP = r1;
        KeyEventType r3 = new KeyEventType("REPEAT", 2);
        REPEAT = r3;
        KeyEventType r5 = new KeyEventType("COMMIT_TEXT", 3);
        COMMIT_TEXT = r5;
        KeyEventType r7 = new KeyEventType("COMMIT_COMPOSING_TEXT", 4);
        COMMIT_COMPOSING_TEXT = r7;
        a = new KeyEventType[]{r0, r1, r3, r5, r7};
    }

    public static KeyEventType[] values() {
        return (KeyEventType[]) a.clone();
    }

    public static KeyEventType valueOf(String r1) {
        return (KeyEventType) r27.a.a(KeyEventType.class, r1);
    }

    public KeyEventType(String r1, int r2) {
        super(r1, r2);
    }
}
