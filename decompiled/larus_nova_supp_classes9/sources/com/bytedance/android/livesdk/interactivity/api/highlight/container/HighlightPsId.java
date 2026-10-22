package com.bytedance.android.livesdk.interactivity.api.highlight.container;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/container/HighlightPsId;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "desc", "Announcement", "Pin", "PSHighlightPin", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HighlightPsId extends Enum<HighlightPsId> {
    public static final HighlightPsId Announcement = null;
    public static final HighlightPsId PSHighlightPin = null;
    public static final HighlightPsId Pin = null;
    public static final /* synthetic */ HighlightPsId[] a = null;
    private final String desc;
    private final String key;

    static {
        HighlightPsId r1 = new HighlightPsId("Announcement", 0, "AnnouncementHighlightProcessor", "预告");
        Announcement = r1;
        HighlightPsId r2 = new HighlightPsId("Pin", 1, "PinContainer", "贴纸置顶消息");
        Pin = r2;
        HighlightPsId r3 = new HighlightPsId("PSHighlightPin", 2, "PSHighlightPinContainer", "公屏强调区置顶消息");
        PSHighlightPin = r3;
        a = new HighlightPsId[]{r1, r2, r3};
    }

    public static HighlightPsId valueOf(String r1) {
        return (HighlightPsId) a.a(HighlightPsId.class, r1);
    }

    public static HighlightPsId[] values() {
        return (HighlightPsId[]) a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public HighlightPsId(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.key = r3;
        this.desc = r4;
    }
}
