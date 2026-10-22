package com.larus.bmhome.social.userchat.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/TriggerSendLoading;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface TriggerSendLoading {
    public static final String BOT_SAY_LOADING = "2";
    public static final a Companion = null;
    public static final String GENERATE_IMAGE_LOADING = "3";
    public static final String GENERATE_MUSIC_LOADING = "4";
    public static final String NO_LOADING = "0";
    public static final String SEND_HIDDEN_MSG_LOADING = "5";
    public static final String SIMPLE_LOADING = "1";

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
