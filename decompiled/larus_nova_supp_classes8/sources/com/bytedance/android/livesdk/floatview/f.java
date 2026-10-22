package com.bytedance.android.livesdk.floatview;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f {
    public static final a N0 = null;

    public static final class a {
        public static final ILivePlayerScene a = null;
        public static final ILivePlayerScene b = null;
        public static final ILivePlayerScene c = null;
        public static final /* synthetic */ a d = null;

        public a() {
        }

        static {
            d = new a();
            ILivePlayerScene.Companion r0 = ILivePlayerScene.Companion;
            a = r0.scene("in_app_in_room_float_window");
            b = r0.scene("out_app_float_window");
            c = r0.scene("in_app_out_room_float_window");
        }
    }

    static {
        N0 = a.d;
    }

    void e();

    void g();

    void h(Room r1, boolean r2);

    boolean isPaused();

    void onPause();

    void onResume();

    void onStart();

    void reset();

    void stop();
}
