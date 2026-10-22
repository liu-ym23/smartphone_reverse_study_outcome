package com.lynx.animax.property;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LayerPropertyType extends Enum<LayerPropertyType> {
    public static final LayerPropertyType BLUR_RADIUS = null;
    public static final LayerPropertyType COLOR = null;
    public static final LayerPropertyType COLOR_FILTER = null;
    public static final LayerPropertyType CORNER_RADIUS = null;
    public static final LayerPropertyType DROP_SHADOW_COLOR = null;
    public static final LayerPropertyType DROP_SHADOW_DIRECTION = null;
    public static final LayerPropertyType DROP_SHADOW_DISTANCE = null;
    public static final LayerPropertyType DROP_SHADOW_OPACITY = null;
    public static final LayerPropertyType DROP_SHADOW_RADIUS = null;
    public static final LayerPropertyType ELLIPSE_SIZE = null;
    public static final LayerPropertyType OPACITY = null;
    public static final LayerPropertyType POLYSTAR_INNER_RADIUS = null;
    public static final LayerPropertyType POLYSTAR_INNER_ROUNDED = null;
    public static final LayerPropertyType POLYSTAR_OUTER_RADIUS = null;
    public static final LayerPropertyType POLYSTAR_OUTER_ROUNDED = null;
    public static final LayerPropertyType POLYSTAR_POINTS = null;
    public static final LayerPropertyType POLYSTAR_ROTATION = null;
    public static final LayerPropertyType POSITION = null;
    public static final LayerPropertyType RECTANGLE_SIZE = null;
    public static final LayerPropertyType REPEATER_COPIES = null;
    public static final LayerPropertyType REPEATER_OFFSET = null;
    public static final LayerPropertyType STROKE_COLOR = null;
    public static final LayerPropertyType STROKE_WIDTH = null;
    public static final LayerPropertyType TEXT_COLOR = null;
    public static final LayerPropertyType TEXT_SIZE = null;
    public static final LayerPropertyType TEXT_TRACKING = null;
    public static final LayerPropertyType TEXT_VALUE = null;
    public static final LayerPropertyType TRANSFORM_ANCHOR = null;
    public static final LayerPropertyType TRANSFORM_END_OPACITY = null;
    public static final LayerPropertyType TRANSFORM_OPACITY = null;
    public static final LayerPropertyType TRANSFORM_POSITION = null;
    public static final LayerPropertyType TRANSFORM_ROTATION = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_X = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_Y = null;
    public static final LayerPropertyType TRANSFORM_ROTATION_Z = null;
    public static final LayerPropertyType TRANSFORM_SCALE = null;
    public static final LayerPropertyType TRANSFORM_SKEW = null;
    public static final LayerPropertyType TRANSFORM_SKEW_ANGLE = null;
    public static final LayerPropertyType TRANSFORM_START_OPACITY = null;
    public static final LayerPropertyType VISIBILITY = null;
    public static final /* synthetic */ LayerPropertyType[] a = null;
    private final int mValue;

    static {
        LayerPropertyType r0 = new LayerPropertyType("VISIBILITY", 0, 1);
        VISIBILITY = r0;
        LayerPropertyType r1 = new LayerPropertyType("TRANSFORM_OPACITY", 1, 2);
        TRANSFORM_OPACITY = r1;
        LayerPropertyType r4 = new LayerPropertyType("TRANSFORM_ANCHOR", 2, 3);
        TRANSFORM_ANCHOR = r4;
        LayerPropertyType r6 = new LayerPropertyType("TRANSFORM_POSITION", 3, 4);
        TRANSFORM_POSITION = r6;
        LayerPropertyType r8 = new LayerPropertyType("TRANSFORM_SCALE", 4, 5);
        TRANSFORM_SCALE = r8;
        LayerPropertyType r10 = new LayerPropertyType("TRANSFORM_ROTATION", 5, 6);
        TRANSFORM_ROTATION = r10;
        LayerPropertyType r12 = new LayerPropertyType("TRANSFORM_SKEW", 6, 7);
        TRANSFORM_SKEW = r12;
        LayerPropertyType r14 = new LayerPropertyType("TRANSFORM_SKEW_ANGLE", 7, 8);
        TRANSFORM_SKEW_ANGLE = r14;
        LayerPropertyType r13 = new LayerPropertyType("TRANSFORM_START_OPACITY", 8, 9);
        TRANSFORM_START_OPACITY = r13;
        LayerPropertyType r15 = new LayerPropertyType("TRANSFORM_END_OPACITY", 9, 10);
        TRANSFORM_END_OPACITY = r15;
        LayerPropertyType r11 = new LayerPropertyType("TRANSFORM_ROTATION_X", 10, 11);
        TRANSFORM_ROTATION_X = r11;
        LayerPropertyType r9 = new LayerPropertyType("TRANSFORM_ROTATION_Y", 11, 12);
        TRANSFORM_ROTATION_Y = r9;
        LayerPropertyType r7 = new LayerPropertyType("TRANSFORM_ROTATION_Z", 12, 13);
        TRANSFORM_ROTATION_Z = r7;
        LayerPropertyType r5 = new LayerPropertyType("TEXT_VALUE", 13, 101);
        TEXT_VALUE = r5;
        LayerPropertyType r3 = new LayerPropertyType("TEXT_SIZE", 14, 102);
        TEXT_SIZE = r3;
        LayerPropertyType r2 = new LayerPropertyType("TEXT_COLOR", 15, 103);
        TEXT_COLOR = r2;
        LayerPropertyType r16 = new LayerPropertyType("TEXT_TRACKING", 16, 104);
        TEXT_TRACKING = r16;
        LayerPropertyType r17 = new LayerPropertyType("COLOR", 17, 201);
        COLOR = r17;
        LayerPropertyType r18 = new LayerPropertyType("COLOR_FILTER", 18, SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FINISHED);
        COLOR_FILTER = r18;
        LayerPropertyType r19 = new LayerPropertyType("STROKE_COLOR", 19, SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FAILED);
        STROKE_COLOR = r19;
        LayerPropertyType r20 = new LayerPropertyType("STROKE_WIDTH", 20, SpeechEvent.SERVER_DOWNLINK_EVENT_SESSION_STARTED);
        STROKE_WIDTH = r20;
        LayerPropertyType r21 = new LayerPropertyType("OPACITY", 21, SpeechEvent.SERVER_DOWNLINK_EVENT_SESSION_FINISHED);
        OPACITY = r21;
        LayerPropertyType r22 = new LayerPropertyType("BLUR_RADIUS", 22, SpeechEvent.SERVER_DOWNLINK_EVENT_SESSION_FAILED);
        BLUR_RADIUS = r22;
        LayerPropertyType r23 = new LayerPropertyType("ELLIPSE_SIZE", 23, SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_INFO);
        ELLIPSE_SIZE = r23;
        LayerPropertyType r24 = new LayerPropertyType("RECTANGLE_SIZE", 24, SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_RESPONSE);
        RECTANGLE_SIZE = r24;
        LayerPropertyType r25 = new LayerPropertyType("CORNER_RADIUS", 25, SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_ENDED);
        CORNER_RADIUS = r25;
        LayerPropertyType r26 = new LayerPropertyType("POSITION", 26, SpeechEvent.SERVER_DOWNLINK_EVENT_CHAT_RESPONSE);
        POSITION = r26;
        LayerPropertyType r27 = new LayerPropertyType("REPEATER_COPIES", 27, SpeechEvent.SERVER_DOWNLINK_EVENT_CHAT_ENDED);
        REPEATER_COPIES = r27;
        LayerPropertyType r28 = new LayerPropertyType("REPEATER_OFFSET", 28, SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_SENTENCE_START);
        REPEATER_OFFSET = r28;
        LayerPropertyType r29 = new LayerPropertyType("POLYSTAR_POINTS", 29, SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_RESPONSE);
        POLYSTAR_POINTS = r29;
        LayerPropertyType r30 = new LayerPropertyType("POLYSTAR_ROTATION", 30, SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_SENTENCE_END);
        POLYSTAR_ROTATION = r30;
        LayerPropertyType r31 = new LayerPropertyType("POLYSTAR_INNER_RADIUS", 31, SpeechEvent.SERVER_DOWNLINK_EVENT_TTS_ENDED);
        POLYSTAR_INNER_RADIUS = r31;
        LayerPropertyType r32 = new LayerPropertyType("POLYSTAR_OUTER_RADIUS", 32, SpeechEvent.SERVER_DOWNLINK_EVENT_BOT_TRIGGERED);
        POLYSTAR_OUTER_RADIUS = r32;
        LayerPropertyType r33 = new LayerPropertyType("POLYSTAR_INNER_ROUNDED", 33, SpeechEvent.SERVER_DOWNLINK_EVENT_UPLINKACK);
        POLYSTAR_INNER_ROUNDED = r33;
        LayerPropertyType r34 = new LayerPropertyType("POLYSTAR_OUTER_ROUNDED", 34, 218);
        POLYSTAR_OUTER_ROUNDED = r34;
        LayerPropertyType r35 = new LayerPropertyType("DROP_SHADOW_COLOR", 35, 219);
        DROP_SHADOW_COLOR = r35;
        LayerPropertyType r36 = new LayerPropertyType("DROP_SHADOW_OPACITY", 36, 220);
        DROP_SHADOW_OPACITY = r36;
        LayerPropertyType r37 = new LayerPropertyType("DROP_SHADOW_DIRECTION", 37, 221);
        DROP_SHADOW_DIRECTION = r37;
        LayerPropertyType r38 = new LayerPropertyType("DROP_SHADOW_DISTANCE", 38, 222);
        DROP_SHADOW_DISTANCE = r38;
        LayerPropertyType r39 = new LayerPropertyType("DROP_SHADOW_RADIUS", 39, 223);
        DROP_SHADOW_RADIUS = r39;
        a = new LayerPropertyType[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r5, r3, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39};
    }

    public static LayerPropertyType[] values() {
        return (LayerPropertyType[]) a.clone();
    }

    public int getValue() {
        return this.mValue;
    }

    public static LayerPropertyType valueOf(String r1) {
        return (LayerPropertyType) r27.a.a(LayerPropertyType.class, r1);
    }

    public LayerPropertyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }
}
