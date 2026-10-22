package com.larus.uaigc.chat.loading;

import com.tencent.open.log.TraceLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/chat/loading/ProgressLoadingScene;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ProgressLoadingScene {
    public static final int AVATAR_IMAGE = 3;
    public static final int BOT_CREATE_AVATAR = 2;
    public static final a Companion = null;
    public static final int IMAGE = 1;
    public static final int VIDEO = 4;

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
