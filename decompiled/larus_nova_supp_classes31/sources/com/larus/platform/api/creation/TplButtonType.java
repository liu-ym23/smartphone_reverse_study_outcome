package com.larus.platform.api.creation;

import com.tencent.open.log.TraceLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/api/creation/TplButtonType;", "", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public @interface TplButtonType {
    public static final String CHANGE_CHARACTER = "change_character";
    public static final String CHANGE_PICTURE = "change_picture";
    public static final String CHANGE_STYLE = "change_style";
    public static final String CHANGE_TEXT = "change_text";
    public static final String CREATE_AVATAR = "create_avatar";
    public static final a Companion = null;
    public static final String GEN_AVATAR = "gen_avatar";
    public static final String GEN_CREATE_AVATAR = "gen_create_avatar";
    public static final String USE_IMAGE = "use_image";
    public static final String USE_PROMPT = "use_prompt";

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
