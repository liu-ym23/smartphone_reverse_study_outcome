package com.ss.ttvideoengine.strategrycenter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface ISelectBitrateCallback {
    public static final String KEY_STREAM_AUDIO = "audio";
    public static final String KEY_STREAM_DUBBED_AUDIO = "dubbed_audio";
    public static final String KEY_STREAM_VIDEO = "video";
    public static final int SELECT_BITRATE_TYPE_PLAY = 1;
    public static final int SELECT_BITRATE_TYPE_PRELOAD = 2;

    Map<String, Integer> selectBitrate(int r1);
}
