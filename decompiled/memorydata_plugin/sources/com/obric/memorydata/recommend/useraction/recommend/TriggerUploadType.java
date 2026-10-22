package com.obric.memorydata.recommend.useraction.recommend;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "", "<init>", "(Ljava/lang/String;I)V", "Action", "AppOpen", "AppClose", "ImeHide", "LocationChange", "CameraForegroundSample", "VideoPlaybackSample", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TriggerUploadType extends Enum<TriggerUploadType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TriggerUploadType[] $VALUES = null;
    public static final TriggerUploadType Action = null;
    public static final TriggerUploadType AppClose = null;
    public static final TriggerUploadType AppOpen = null;
    public static final TriggerUploadType CameraForegroundSample = null;
    public static final TriggerUploadType ImeHide = null;
    public static final TriggerUploadType LocationChange = null;
    public static final TriggerUploadType VideoPlaybackSample = null;

    private static final /* synthetic */ TriggerUploadType[] $values() {
        return new TriggerUploadType[]{Action, AppOpen, AppClose, ImeHide, LocationChange, CameraForegroundSample, VideoPlaybackSample};
    }

    static {
        Action = new TriggerUploadType("Action", 0);
        AppOpen = new TriggerUploadType("AppOpen", 1);
        AppClose = new TriggerUploadType("AppClose", 2);
        ImeHide = new TriggerUploadType("ImeHide", 3);
        LocationChange = new TriggerUploadType("LocationChange", 4);
        CameraForegroundSample = new TriggerUploadType("CameraForegroundSample", 5);
        VideoPlaybackSample = new TriggerUploadType("VideoPlaybackSample", 6);
        TriggerUploadType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private TriggerUploadType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<TriggerUploadType> getEntries() {
        return $ENTRIES;
    }

    public static TriggerUploadType valueOf(String r2) {
        return (TriggerUploadType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TriggerUploadType.class, r2), TriggerUploadType.class, "com.obric.memorydata.plugin");
    }

    public static TriggerUploadType[] values() {
        return (TriggerUploadType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TriggerUploadType[].class, "com.obric.memorydata.plugin");
    }
}
