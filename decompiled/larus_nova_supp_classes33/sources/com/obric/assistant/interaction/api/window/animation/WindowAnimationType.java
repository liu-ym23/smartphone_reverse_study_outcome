package com.obric.assistant.interaction.api.window.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "", "serializedValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSerializedValue", "()Ljava/lang/String;", "Slide", "AiKeyOverlayFade", "Fade", "None", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WindowAnimationType extends Enum<WindowAnimationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WindowAnimationType[] $VALUES = null;
    public static final WindowAnimationType AiKeyOverlayFade = null;
    public static final WindowAnimationType Fade = null;
    public static final WindowAnimationType None = null;
    public static final WindowAnimationType Slide = null;
    private final String serializedValue;

    private static final /* synthetic */ WindowAnimationType[] $values() {
        return new WindowAnimationType[]{Slide, AiKeyOverlayFade, Fade, None};
    }

    public static EnumEntries<WindowAnimationType> getEntries() {
        return $ENTRIES;
    }

    static {
        Slide = new WindowAnimationType("Slide", 0, "slide");
        AiKeyOverlayFade = new WindowAnimationType("AiKeyOverlayFade", 1, "ai_key_overlay_fade");
        Fade = new WindowAnimationType("Fade", 2, "fade");
        None = new WindowAnimationType("None", 3, "none");
        WindowAnimationType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static WindowAnimationType[] values() {
        return (WindowAnimationType[]) $VALUES.clone();
    }

    public final String getSerializedValue() {
        return this.serializedValue;
    }

    public static WindowAnimationType valueOf(String r1) {
        return (WindowAnimationType) a.a(WindowAnimationType.class, r1);
    }

    private WindowAnimationType(String r1, int r2, String r3) {
        super(r1, r2);
        this.serializedValue = r3;
    }
}
