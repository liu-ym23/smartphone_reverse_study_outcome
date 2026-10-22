package com.obric.assistant.banner.bean;

import com.obric.aivoice.core.data.NameKeys;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/banner/bean/ObricBannerPriority;", NameKeys.UnloadStrategy_No_Strategy, "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface ObricBannerPriority {
    public static final int CHECK_UPDATE_PRIORITY = 100;
    public static final a Companion = null;
    public static final int OTHER_PRIORITY = 0;
    public static final int SET_DEFAULT_ASSISTANT_PRIORITY = -10;

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
