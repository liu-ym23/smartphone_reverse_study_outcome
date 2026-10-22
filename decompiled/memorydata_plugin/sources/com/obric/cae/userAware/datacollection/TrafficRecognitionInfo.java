package com.obric.cae.userAware.datacollection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class TrafficRecognitionInfo {
    public static final String SOURCE_AIRPORT_RECOGNITION = "airport_recognition";
    public static final String SOURCE_AOI_BOARD = "aoi_board";
    public static final int STATE_ENTER = 1;
    public static final int STATE_INSIDE = 3;
    public static final int TYPE_AIRPORT = 1;
    public static final int TYPE_TRAIN_STATION = 2;
    private final long mEventTime;
    private final String mPlaceId;
    private final String mPlaceName;
    private final String mRecognitionSource;
    private final int mTrafficState;
    private final int mTrafficType;

    public TrafficRecognitionInfo(long r1, int r3, int r4, String r5, String r6, String r7) {
        this.mEventTime = r1;
        this.mTrafficType = r3;
        this.mTrafficState = r4;
        this.mPlaceId = (String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5), String.class, "com.obric.memorydata.plugin");
        this.mPlaceName = (String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), String.class, "com.obric.memorydata.plugin");
        this.mRecognitionSource = (String) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), String.class, "com.obric.memorydata.plugin");
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String getPlaceId() {
        return this.mPlaceId;
    }

    public String getPlaceName() {
        return this.mPlaceName;
    }

    public String getRecognitionSource() {
        return this.mRecognitionSource;
    }

    public int getTrafficState() {
        return this.mTrafficState;
    }

    public int getTrafficType() {
        return this.mTrafficType;
    }
}
