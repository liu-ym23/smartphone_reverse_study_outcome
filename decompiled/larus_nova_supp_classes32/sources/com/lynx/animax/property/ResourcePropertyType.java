package com.lynx.animax.property;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ResourcePropertyType extends Enum<ResourcePropertyType> {
    public static final ResourcePropertyType FONT_ASCENT = null;
    public static final ResourcePropertyType FONT_FAMILY = null;
    public static final ResourcePropertyType FONT_PATH = null;
    public static final ResourcePropertyType FONT_STYLE = null;
    public static final ResourcePropertyType IMAGE_DIR_NAME = null;
    public static final ResourcePropertyType IMAGE_FILE_NAME = null;
    public static final ResourcePropertyType IMAGE_HEIGHT = null;
    public static final ResourcePropertyType IMAGE_WIDTH = null;
    public static final ResourcePropertyType VIDEO_DIR_NAME = null;
    public static final ResourcePropertyType VIDEO_FILE_NAME = null;
    public static final ResourcePropertyType VIDEO_HEIGHT = null;
    public static final ResourcePropertyType VIDEO_WIDTH = null;
    public static final /* synthetic */ ResourcePropertyType[] a = null;
    private final int mValue;

    static {
        ResourcePropertyType r0 = new ResourcePropertyType("IMAGE_DIR_NAME", 0, 1);
        IMAGE_DIR_NAME = r0;
        ResourcePropertyType r1 = new ResourcePropertyType("IMAGE_FILE_NAME", 1, 2);
        IMAGE_FILE_NAME = r1;
        ResourcePropertyType r4 = new ResourcePropertyType("IMAGE_WIDTH", 2, 3);
        IMAGE_WIDTH = r4;
        ResourcePropertyType r6 = new ResourcePropertyType("IMAGE_HEIGHT", 3, 4);
        IMAGE_HEIGHT = r6;
        ResourcePropertyType r8 = new ResourcePropertyType("FONT_FAMILY", 4, 101);
        FONT_FAMILY = r8;
        ResourcePropertyType r10 = new ResourcePropertyType("FONT_STYLE", 5, 102);
        FONT_STYLE = r10;
        ResourcePropertyType r11 = new ResourcePropertyType("FONT_ASCENT", 6, 103);
        FONT_ASCENT = r11;
        ResourcePropertyType r12 = new ResourcePropertyType("FONT_PATH", 7, 104);
        FONT_PATH = r12;
        ResourcePropertyType r14 = new ResourcePropertyType("VIDEO_DIR_NAME", 8, 201);
        VIDEO_DIR_NAME = r14;
        ResourcePropertyType r13 = new ResourcePropertyType("VIDEO_FILE_NAME", 9, SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FINISHED);
        VIDEO_FILE_NAME = r13;
        ResourcePropertyType r9 = new ResourcePropertyType("VIDEO_WIDTH", 10, SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FAILED);
        VIDEO_WIDTH = r9;
        ResourcePropertyType r7 = new ResourcePropertyType("VIDEO_HEIGHT", 11, SpeechEvent.SERVER_DOWNLINK_EVENT_SESSION_STARTED);
        VIDEO_HEIGHT = r7;
        a = new ResourcePropertyType[]{r0, r1, r4, r6, r8, r10, r11, r12, r14, r13, r9, r7};
    }

    public static ResourcePropertyType[] values() {
        return (ResourcePropertyType[]) a.clone();
    }

    public int getValue() {
        return this.mValue;
    }

    public static ResourcePropertyType valueOf(String r1) {
        return (ResourcePropertyType) r27.a.a(ResourcePropertyType.class, r1);
    }

    public ResourcePropertyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }
}
