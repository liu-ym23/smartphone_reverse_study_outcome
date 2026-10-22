package com.obric.assistant.interaction.base.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/base/feedback/VibratorSmtFeedbackEffect;", "", "<init>", "(Ljava/lang/String;I)V", "EFFECT_WAKE_UP", "EFFECT_LONG_PRESS", "EFFECT_TICK", "EFFECT_WARNING", "EFFECT_CONFIRM", "EFFECT_RIGID", "EFFECT_SOFT", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VibratorSmtFeedbackEffect extends Enum<VibratorSmtFeedbackEffect> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ VibratorSmtFeedbackEffect[] $VALUES = null;
    public static final VibratorSmtFeedbackEffect EFFECT_CONFIRM = null;
    public static final VibratorSmtFeedbackEffect EFFECT_LONG_PRESS = null;
    public static final VibratorSmtFeedbackEffect EFFECT_RIGID = null;
    public static final VibratorSmtFeedbackEffect EFFECT_SOFT = null;
    public static final VibratorSmtFeedbackEffect EFFECT_TICK = null;
    public static final VibratorSmtFeedbackEffect EFFECT_WAKE_UP = null;
    public static final VibratorSmtFeedbackEffect EFFECT_WARNING = null;

    private static final /* synthetic */ VibratorSmtFeedbackEffect[] $values() {
        return new VibratorSmtFeedbackEffect[]{EFFECT_WAKE_UP, EFFECT_LONG_PRESS, EFFECT_TICK, EFFECT_WARNING, EFFECT_CONFIRM, EFFECT_RIGID, EFFECT_SOFT};
    }

    public static EnumEntries<VibratorSmtFeedbackEffect> getEntries() {
        return $ENTRIES;
    }

    static {
        EFFECT_WAKE_UP = new VibratorSmtFeedbackEffect("EFFECT_WAKE_UP", 0);
        EFFECT_LONG_PRESS = new VibratorSmtFeedbackEffect("EFFECT_LONG_PRESS", 1);
        EFFECT_TICK = new VibratorSmtFeedbackEffect("EFFECT_TICK", 2);
        EFFECT_WARNING = new VibratorSmtFeedbackEffect("EFFECT_WARNING", 3);
        EFFECT_CONFIRM = new VibratorSmtFeedbackEffect("EFFECT_CONFIRM", 4);
        EFFECT_RIGID = new VibratorSmtFeedbackEffect("EFFECT_RIGID", 5);
        EFFECT_SOFT = new VibratorSmtFeedbackEffect("EFFECT_SOFT", 6);
        VibratorSmtFeedbackEffect[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static VibratorSmtFeedbackEffect[] values() {
        return (VibratorSmtFeedbackEffect[]) $VALUES.clone();
    }

    public static VibratorSmtFeedbackEffect valueOf(String r1) {
        return (VibratorSmtFeedbackEffect) a.a(VibratorSmtFeedbackEffect.class, r1);
    }

    private VibratorSmtFeedbackEffect(String r1, int r2) {
        super(r1, r2);
    }
}
