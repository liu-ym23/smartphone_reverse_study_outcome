package com.byted.cast.sdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCMediaKind {
    public static final RTCMediaKind AUDIO = null;
    public static final RTCMediaKind INVALID = null;
    public static final RTCMediaKind SCREEN = null;
    public static final RTCMediaKind VIDEO = null;
    private static String[] kinds;
    private int kind;

    static {
        AUDIO = new RTCMediaKind(0);
        VIDEO = new RTCMediaKind(1);
        SCREEN = new RTCMediaKind(2);
        INVALID = new RTCMediaKind(3);
        kinds = new String[]{"audio", "video", "screen", "invalid"};
    }

    public String toString() {
        return kinds[this.kind];
    }

    public int value() {
        return this.kind;
    }

    private RTCMediaKind(int r1) {
        this.kind = r1;
    }

    public static RTCMediaKind valueOf(String r1) {
        if (r1.equals("audio") == false) goto L7;
        return AUDIO;
    L7:
        if (r1.equals("video") == false) goto L11;
        return VIDEO;
    L11:
        if (r1.equals("screen") == false) goto L15;
        return SCREEN;
    L15:
        return INVALID;
    }

    public static RTCMediaKind valueOf(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return INVALID;
    L10:
        return SCREEN;
    L12:
        return VIDEO;
    L14:
        return AUDIO;
    }
}
