package j40;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e3 extends SettingKey<String[]> {
    public static final e3 a = null;

    static {
        a = new e3();
    }

    public e3() {
        super("live_strategy_handle_room_async_array", "handle room 异步列表", new String[]{"float_video_resolution", "video_resolution", "preview_video_resolution", "resolution_memory_enable", "small_window_resolution", "float_video_resolution_inner", "use_new_resolution"}, new String[]{"float_video_resolution", "video_resolution", "preview_video_resolution", "resolution_memory_enable", "small_window_resolution", "float_video_resolution_inner", "use_new_resolution"});
    }
}
