package com.obric.livecard.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/livecard/api/utils/IslandVersionCode;", "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface IslandVersionCode {
    public static final int AI_SUGGESTION_FEATURE = 8;
    public static final int AUDIO_AMPLITUDE_FEATURE = 10;
    public static final int CARD_PACKAGE_FEATURE = 9;
    public static final int COLLAPSE_NOTIFICATION_FEATURE = 4;
    public static final Companion Companion = null;
    public static final int DIALOGUE_FEATURE = 3;
    public static final int ISLAND_AUTO_DISMISS_FEATURE = 7;
    public static final int LANGUAGE_FEATURE = 6;
    public static final int SCENE_FEATURE = 5;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/utils/IslandVersionCode$Companion;", "", "()V", "AI_SUGGESTION_FEATURE", "", "AUDIO_AMPLITUDE_FEATURE", "CARD_PACKAGE_FEATURE", "COLLAPSE_NOTIFICATION_FEATURE", "DIALOGUE_FEATURE", "ISLAND_AUTO_DISMISS_FEATURE", "LANGUAGE_FEATURE", "SCENE_FEATURE", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int AI_SUGGESTION_FEATURE = 8;
        public static final int AUDIO_AMPLITUDE_FEATURE = 10;
        public static final int CARD_PACKAGE_FEATURE = 9;
        public static final int COLLAPSE_NOTIFICATION_FEATURE = 4;
        public static final int DIALOGUE_FEATURE = 3;
        public static final int ISLAND_AUTO_DISMISS_FEATURE = 7;
        public static final int LANGUAGE_FEATURE = 6;
        public static final int SCENE_FEATURE = 5;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
