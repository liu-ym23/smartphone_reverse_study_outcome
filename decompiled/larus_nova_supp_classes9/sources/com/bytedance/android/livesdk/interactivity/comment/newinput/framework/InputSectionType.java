package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputSectionType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "NONE", "EMPTY", "SHADOW", "WORD_ASSOCIATE", "MENTION", "CHARGE", "CONTENT", "CONTROL_LANDSCAPE", "CONTROL_PORTRAIT", "KEYBOARD", "EMOJI", "QUICK_COMMENT", "DANMAKU", "AUDIO", "AUDIO2TEXT", "AUDIO_COMPOSE", "SEND_PORTRAIT", "VIDEO", "INTERACTIVITY_SHARE", "OGC_FIXED_INPUT", "FREQUENT_CHAT", "SECRET_CHAT", "MARK_HIGHLIGHT", "MORE", "INTEREST", "TRUTH", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputSectionType extends Enum<InputSectionType> {
    public static final InputSectionType AUDIO = null;
    public static final InputSectionType AUDIO2TEXT = null;
    public static final InputSectionType AUDIO_COMPOSE = null;
    public static final InputSectionType CHARGE = null;
    public static final InputSectionType CONTENT = null;
    public static final InputSectionType CONTROL_LANDSCAPE = null;
    public static final InputSectionType CONTROL_PORTRAIT = null;
    public static final InputSectionType DANMAKU = null;
    public static final InputSectionType EMOJI = null;
    public static final InputSectionType EMPTY = null;
    public static final InputSectionType FREQUENT_CHAT = null;
    public static final InputSectionType INTERACTIVITY_SHARE = null;
    public static final InputSectionType INTEREST = null;
    public static final InputSectionType KEYBOARD = null;
    public static final InputSectionType MARK_HIGHLIGHT = null;
    public static final InputSectionType MENTION = null;
    public static final InputSectionType MORE = null;
    public static final InputSectionType NONE = null;
    public static final InputSectionType OGC_FIXED_INPUT = null;
    public static final InputSectionType QUICK_COMMENT = null;
    public static final InputSectionType SECRET_CHAT = null;
    public static final InputSectionType SEND_PORTRAIT = null;
    public static final InputSectionType SHADOW = null;
    public static final InputSectionType TRUTH = null;
    public static final InputSectionType VIDEO = null;
    public static final InputSectionType WORD_ASSOCIATE = null;
    public static final /* synthetic */ InputSectionType[] a = null;
    private final String typeName;

    public static InputSectionType valueOf(String r1) {
        return (InputSectionType) r27.a.a(InputSectionType.class, r1);
    }

    public static InputSectionType[] values() {
        return (InputSectionType[]) a.clone();
    }

    static {
        InputSectionType r1 = new InputSectionType("NONE", 0, "none");
        NONE = r1;
        InputSectionType r2 = new InputSectionType("EMPTY", 1, "empty");
        EMPTY = r2;
        InputSectionType r3 = new InputSectionType("SHADOW", 2, "shadow");
        SHADOW = r3;
        InputSectionType r4 = new InputSectionType("WORD_ASSOCIATE", 3, "word_associate");
        WORD_ASSOCIATE = r4;
        InputSectionType r5 = new InputSectionType("MENTION", 4, "mention");
        MENTION = r5;
        InputSectionType r6 = new InputSectionType("CHARGE", 5, "charge");
        CHARGE = r6;
        InputSectionType r7 = new InputSectionType("CONTENT", 6, "content");
        CONTENT = r7;
        InputSectionType r8 = new InputSectionType("CONTROL_LANDSCAPE", 7, "control_landscape");
        CONTROL_LANDSCAPE = r8;
        InputSectionType r9 = new InputSectionType("CONTROL_PORTRAIT", 8, "control_portrait");
        CONTROL_PORTRAIT = r9;
        InputSectionType r10 = new InputSectionType("KEYBOARD", 9, "keyboard");
        KEYBOARD = r10;
        InputSectionType r11 = new InputSectionType("EMOJI", 10, "emoji");
        EMOJI = r11;
        InputSectionType r13 = new InputSectionType("QUICK_COMMENT", 11, "quick_comment");
        QUICK_COMMENT = r13;
        InputSectionType r14 = new InputSectionType("DANMAKU", 12, "screen_chat");
        DANMAKU = r14;
        InputSectionType r15 = new InputSectionType("AUDIO", 13, "audio");
        AUDIO = r15;
        InputSectionType r16 = new InputSectionType("AUDIO2TEXT", 14, "audio_to_text");
        AUDIO2TEXT = r16;
        InputSectionType r17 = new InputSectionType("AUDIO_COMPOSE", 15, "audio_compose");
        AUDIO_COMPOSE = r17;
        InputSectionType r18 = new InputSectionType("SEND_PORTRAIT", 16, "send_portrait");
        SEND_PORTRAIT = r18;
        InputSectionType r19 = new InputSectionType("VIDEO", 17, "video");
        VIDEO = r19;
        InputSectionType r20 = new InputSectionType("INTERACTIVITY_SHARE", 18, "interactivity_share");
        INTERACTIVITY_SHARE = r20;
        InputSectionType r21 = new InputSectionType("OGC_FIXED_INPUT", 19, "ogc_fixed_comment");
        OGC_FIXED_INPUT = r21;
        InputSectionType r23 = new InputSectionType("FREQUENT_CHAT", 20, "frequent_comment");
        FREQUENT_CHAT = r23;
        InputSectionType r24 = new InputSectionType("SECRET_CHAT", 21, "secret_chat");
        SECRET_CHAT = r24;
        InputSectionType r25 = new InputSectionType("MARK_HIGHLIGHT", 22, "mark_highlight");
        MARK_HIGHLIGHT = r25;
        InputSectionType r26 = new InputSectionType("MORE", 23, "more");
        MORE = r26;
        InputSectionType r27 = new InputSectionType("INTEREST", 24, "interest");
        INTEREST = r27;
        InputSectionType r28 = new InputSectionType("TRUTH", 25, "truth");
        TRUTH = r28;
        a = new InputSectionType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public InputSectionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
