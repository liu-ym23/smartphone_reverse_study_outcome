package com.obric.assistant.live.gr.island.island;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Target({ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/GRIslandSessionFlags;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface GRIslandSessionFlags {
    public static final a Companion = null;
    public static final long FLAG_DIALOGUE_MODE = 8;
    public static final long FLAG_DIALOGUE_MODE_TIME_LIMIT = 512;
    public static final long FLAG_FULL_SCREEN_SHOW = 1024;
    public static final long FLAG_KEYGUARD_ABOVE_ONCLICK = 256;
    public static final long FLAG_KEYGUARD_SHOW = 1;
    public static final long FLAG_PENDING_AUTO_DISMISS = 128;
    public static final long FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE = 16;
    public static final long FLAG_SLIDE_UP_DESTROY = 4;
    public static final long FLAG_TEMP_REFRESH_FRONT_SHOW = 64;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
