package com.obric.livecard.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/livecard/api/utils/IslandSessionFlags;", "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface IslandSessionFlags {
    public static final Companion Companion = null;
    public static final long FLAG_AUTO_DISMISS_ONCLICK = 2048;
    public static final long FLAG_DIALOGUE_MODE = 8;
    public static final long FLAG_DIALOGUE_MODE_TIME_LIMIT = 512;
    public static final long FLAG_DISABLE_SWIPE_HIDE = 4096;
    public static final long FLAG_FULL_SCREEN_SHOW = 1024;
    public static final long FLAG_KEYGUARD_ABOVE_ONCLICK = 256;
    public static final long FLAG_KEYGUARD_DISMISS_ONCLICK = 2;
    public static final long FLAG_KEYGUARD_SHOW = 1;
    public static final long FLAG_PENDING_AUTO_DISMISS = 128;
    public static final long FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE = 16;
    public static final long FLAG_SLIDE_UP_DESTROY = 4;
    public static final long FLAG_TEMP_REFRESH_FRONT_SHOW = 64;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/livecard/api/utils/IslandSessionFlags$Companion;", "", "()V", "FLAG_AUTO_DISMISS_ONCLICK", "", "FLAG_DIALOGUE_MODE", "FLAG_DIALOGUE_MODE_TIME_LIMIT", "FLAG_DISABLE_SWIPE_HIDE", "FLAG_FULL_SCREEN_SHOW", "FLAG_KEYGUARD_ABOVE_ONCLICK", "FLAG_KEYGUARD_DISMISS_ONCLICK", "getFLAG_KEYGUARD_DISMISS_ONCLICK$annotations", "FLAG_KEYGUARD_SHOW", "FLAG_PENDING_AUTO_DISMISS", "FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE", "FLAG_SLIDE_UP_DESTROY", "FLAG_TEMP_REFRESH_FRONT_SHOW", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long FLAG_AUTO_DISMISS_ONCLICK = 2048;
        public static final long FLAG_DIALOGUE_MODE = 8;
        public static final long FLAG_DIALOGUE_MODE_TIME_LIMIT = 512;
        public static final long FLAG_DISABLE_SWIPE_HIDE = 4096;
        public static final long FLAG_FULL_SCREEN_SHOW = 1024;
        public static final long FLAG_KEYGUARD_ABOVE_ONCLICK = 256;
        public static final long FLAG_KEYGUARD_DISMISS_ONCLICK = 2;
        public static final long FLAG_KEYGUARD_SHOW = 1;
        public static final long FLAG_PENDING_AUTO_DISMISS = 128;
        public static final long FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE = 16;
        public static final long FLAG_SLIDE_UP_DESTROY = 4;
        public static final long FLAG_TEMP_REFRESH_FRONT_SHOW = 64;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        @Deprecated(message = "默认都需要解锁")
        public static /* synthetic */ void getFLAG_KEYGUARD_DISMISS_ONCLICK$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
