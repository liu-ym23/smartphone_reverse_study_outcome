package com.larus.avlink.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/model/FlowDoraScene;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public @interface FlowDoraScene {
    public static final a Companion = null;
    public static final int SCENE_ENV_OBSERVER = 2;
    public static final int SCENE_FEED_BACK = 5;
    public static final int SCENE_HEADPHONE = 8;
    public static final int SCENE_LIVE_AI = 1;
    public static final int SCENE_OTA = 4;
    public static final int SCENE_RECORDING = 7;
    public static final int SCENE_SESSION = 0;
    public static final int SCENE_SI = 6;
    public static final int SCENE_VIDEO_RECORD = 3;

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
