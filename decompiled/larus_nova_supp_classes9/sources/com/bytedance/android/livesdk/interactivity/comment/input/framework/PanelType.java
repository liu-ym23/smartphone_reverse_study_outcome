package com.bytedance.android.livesdk.interactivity.comment.input.framework;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/framework/PanelType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "NONE", "KEYBOARD", "RIGHTS", "EMOJI", "SCREEN_CHAT", "RECOMMEND_EMOJI", "VIDEO_COMMENT", "AUDIO_COMMENT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType AUDIO_COMMENT = null;
    public static final PanelType EMOJI = null;
    public static final PanelType KEYBOARD = null;
    public static final PanelType NONE = null;
    public static final PanelType RECOMMEND_EMOJI = null;
    public static final PanelType RIGHTS = null;
    public static final PanelType SCREEN_CHAT = null;
    public static final PanelType VIDEO_COMMENT = null;
    public static final /* synthetic */ PanelType[] a = null;
    private final String typeName;

    public static PanelType valueOf(String r1) {
        return (PanelType) a.a(PanelType.class, r1);
    }

    public static PanelType[] values() {
        return (PanelType[]) a.clone();
    }

    static {
        PanelType r1 = new PanelType("NONE", 0, "none");
        NONE = r1;
        PanelType r2 = new PanelType("KEYBOARD", 1, "keyboard");
        KEYBOARD = r2;
        PanelType r3 = new PanelType("RIGHTS", 2, "rights");
        RIGHTS = r3;
        PanelType r4 = new PanelType("EMOJI", 3, "emoji");
        EMOJI = r4;
        PanelType r5 = new PanelType("SCREEN_CHAT", 4, "screen_chat");
        SCREEN_CHAT = r5;
        PanelType r6 = new PanelType("RECOMMEND_EMOJI", 5, "recommend emoji");
        RECOMMEND_EMOJI = r6;
        PanelType r7 = new PanelType("VIDEO_COMMENT", 6, "video_comment");
        VIDEO_COMMENT = r7;
        PanelType r8 = new PanelType("AUDIO_COMMENT", 7, "audio_comment");
        AUDIO_COMMENT = r8;
        a = new PanelType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public PanelType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
