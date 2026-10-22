package com.larus.audio.call.dora;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/dora/DoraEMessageType;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public @interface DoraEMessageType {
    public static final a Companion = null;
    public static final String IMAGE = "image_only";
    public static final String VOICE = "voice_only";
    public static final String VOICE_AND_IMAGE = "voice_and_image";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @DoraEMessageType
        public static String a(Integer r2) {
            if (r2 == null) goto L15;
            r2.intValue();
            if (r2.intValue() != 1) goto L8;
            return DoraEMessageType.VOICE;
        L8:
            if (r2.intValue() != 6) goto L12;
            return DoraEMessageType.IMAGE;
        L12:
            if (r2.intValue() != 20) goto L17;
            return DoraEMessageType.VOICE_AND_IMAGE;
        L17:
            return null;
        L15:
            return null;
        }
    }

    static {
        Companion = a.a;
    }
}
