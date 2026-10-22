package com.bytedance.android.live.base.model.media;

import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IPlayable {
    public static final String ACTION_COMMENT_SHOW = "action_comment_show";
    public static final String ACTION_PAUSE_PLAY = "action_pause_play";
    public static final String ACTION_RESUME_PLAY = "action_resume_play";
    public static final String DETAIL_PAUSE_OR_PLAY_SIGNAL = "DETAIL_PAUSE_OR_PLAY_SIGNAL";
    public static final String DETAIL_PLAYER_CENTER_INSIDE = "DETAIL_PLAYER_CENTER_INSIDE";
    public static final String DETAIL_TAB_TO_PAUSE = "DETAIL_TAB_TO_PAUSE";
    public static final String EVENT_EACH_PLAY_END = "event_each_play_end";
    public static final String EVENT_FIRST_PLAY_END = "event_first_play_end";
    public static final String EVENT_PLAY_FAILED = "event_play_failed";
    public static final String EVENT_PLAY_SUCCESS = "event_play_success";
    public static final String EVENT_VIDEO_FPS = "event_video_fps";
    public static final int HOTSOON_ADX_VIDEO_ERROR_COVER_SIZE = 3;
    public static final int HOTSOON_ADX_VIDEO_ERROR_PLAY_FAIL = 1;
    public static final int HOTSOON_ADX_VIDEO_ERROR_VIDEO_DURATION = 4;
    public static final int HOTSOON_ADX_VIDEO_ERROR_VIDEO_MUSIC = 5;
    public static final int HOTSOON_ADX_VIDEO_ERROR_VIDEO_SIZE = 2;
    public static final String KEY_PLAY_MONITOR_STATUS = "play_monitor_status";

    public @interface HotsoonAdxVideoErrorType {
    }

    long getId();

    String getPlayKey();

    k getVideoCoverImage();

    VideoModel getVideoModel();

    boolean isBitRate();

    boolean isDeleted();
}
