package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/AutoEndConversationTime;", NameKeys.UnloadStrategy_No_Strategy, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface AutoEndConversationTime {
    public static final long AFTER_10_SECONDS = 10000;
    public static final long AFTER_20_SECONDS = 20000;
    public static final long AFTER_30_SECONDS = 30000;
    public static final long AFTER_60_SECONDS = 60000;
    public static final a Companion = null;
    public static final long FOLLOW_SYSTEM_LOCK_TIME = -1;
    public static final long IMMEDIATELY = 3500;

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
