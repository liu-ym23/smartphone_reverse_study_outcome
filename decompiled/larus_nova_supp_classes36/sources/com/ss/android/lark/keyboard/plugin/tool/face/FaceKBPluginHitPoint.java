package com.ss.android.lark.keyboard.plugin.tool.face;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FaceKBPluginHitPoint extends com.ss.android.lark.keyboard.statistics.a {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceKBPluginHitPoint$Scene;", "", "Companion", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final a Companion = null;
        public static final String EMOJI = "emoji";
        public static final String STICKER_PACK = "stickerpack";

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
        return "im_chat_input_toolbar_sticker";
    }

    public FaceKBPluginHitPoint() {
        Intrinsics.checkNotNullParameter("emoji", "paramValue");
        this.a = "emoji";
    }

    @Override // com.ss.android.lark.keyboard.statistics.a
    public final String b() {
        return this.a;
    }
}
