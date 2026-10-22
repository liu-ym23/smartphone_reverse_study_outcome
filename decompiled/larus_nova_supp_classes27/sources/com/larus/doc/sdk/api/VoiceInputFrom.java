package com.larus.doc.sdk.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/sdk/api/VoiceInputFrom;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface VoiceInputFrom {
    public static final String ACTION_BAR = "action_bar";
    public static final String ASR_FAIL = "asr_fail";
    public static final a Companion = null;
    public static final String FRAGMENT_DETACH = "fragment_detach";
    public static final String INTERCEPT_KEYBOARD = "intercept_keyboard";
    public static final String INTERCEPT_VIEW = "intercept_view";
    public static final String NEW_DOC = "new_doc";
    public static final String SERVER_INTERRUPT = "server_interrupt";
    public static final String TOOL_BAR_CLICK = "tool_bar_click";
    public static final String TOOL_BAR_LONG_PRESS = "tool_bar_long_press";
    public static final String UNKNOWN = "unknown";

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
