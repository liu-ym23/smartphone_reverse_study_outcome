package com.larus.audio.call.dora;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/audio/call/dora/DoraSpecialMode;", "", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public @interface DoraSpecialMode {
    public static final int AST = 3;
    public static final a Companion = null;
    public static final int DEFAULT = 0;
    public static final int DISCOVER = 1;
    public static final int FPA_MEETING = 5;
    public static final int LARK_MEETING = 6;
    public static final int LIVE = 2;

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
