package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/model/CollectionType;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public @interface CollectionType {
    public static final a Companion = null;
    public static final int LIKE_MESSAGES = 4;
    public static final int MULTI_MESSAGE = 2;
    public static final int QA_MESSAGES = 5;
    public static final int SINGLE_MESSAGE = 1;
    public static final int SINGLE_MUSIC = 3;
    public static final int SINGLE_QISHUI_ALBUM = 101;
    public static final int SINGLE_QISHUI_MUSIC = 100;
    public static final int SINGLE_QISHUI_PLAY_LIST = 102;
    public static final int UNKNOWN = 0;

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
