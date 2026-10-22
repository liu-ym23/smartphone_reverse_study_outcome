package com.ss.android.lark.keyboard.statistics;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TextInputPluginHitPoint extends com.ss.android.lark.keyboard.statistics.a {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/keyboard/statistics/TextInputPluginHitPoint$Scene;", "", "Companion", "keyboard-biz-common_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final String AT = "mention";
        public static final String AUDIO = "audio";
        public static final a Companion = null;
        public static final String MORE = "more";
        public static final String PICTURE = "picture";
        public static final String RICH_TEXT = "rich_text";
        public static final String SEND = "send";
        public static final String STICKER = "sticker";

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

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String a() {
        return "im_chat_input_toolbar";
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String b() {
        return this.a;
    }

    public TextInputPluginHitPoint(@Scene String r2) {
        Intrinsics.checkNotNullParameter(r2, "paramValue");
        this.a = r2;
    }
}
