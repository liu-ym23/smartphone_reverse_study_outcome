package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/VideoChorusSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "LINK_ICON", "PK_ICON", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoChorusSource extends Enum<VideoChorusSource> {
    public static final VideoChorusSource LINK_ICON = null;
    public static final VideoChorusSource PK_ICON = null;
    public static final VideoChorusSource UNKNOWN = null;
    public static final /* synthetic */ VideoChorusSource[] a = null;
    private final String value;

    static {
        VideoChorusSource r1 = new VideoChorusSource("UNKNOWN", 0, CardLockInfo.sUNKNOWN);
        UNKNOWN = r1;
        VideoChorusSource r2 = new VideoChorusSource("LINK_ICON", 1, "link_icon");
        LINK_ICON = r2;
        VideoChorusSource r3 = new VideoChorusSource("PK_ICON", 2, "pk_icon");
        PK_ICON = r3;
        a = new VideoChorusSource[]{r1, r2, r3};
    }

    public static VideoChorusSource valueOf(String r1) {
        return (VideoChorusSource) a.a(VideoChorusSource.class, r1);
    }

    public static VideoChorusSource[] values() {
        return (VideoChorusSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public VideoChorusSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
