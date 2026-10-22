package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/AssetDownloadPriority;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "priority", "I", "getPriority", "()I", "NORMAL", "OTHER_SEND", "JSB_PLAY", "LOCAL", "OPEN_DIY_PAGE", "ANCHOR_MOCK", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AssetDownloadPriority extends Enum<AssetDownloadPriority> {
    public static final AssetDownloadPriority ANCHOR_MOCK = null;
    public static final AssetDownloadPriority JSB_PLAY = null;
    public static final AssetDownloadPriority LOCAL = null;
    public static final AssetDownloadPriority NORMAL = null;
    public static final AssetDownloadPriority OPEN_DIY_PAGE = null;
    public static final AssetDownloadPriority OTHER_SEND = null;
    public static final /* synthetic */ AssetDownloadPriority[] a = null;
    private final int priority;

    static {
        AssetDownloadPriority r1 = new AssetDownloadPriority("NORMAL", 0, 1);
        NORMAL = r1;
        AssetDownloadPriority r2 = new AssetDownloadPriority("OTHER_SEND", 1, 2);
        OTHER_SEND = r2;
        AssetDownloadPriority r3 = new AssetDownloadPriority("JSB_PLAY", 2, 3);
        JSB_PLAY = r3;
        AssetDownloadPriority r4 = new AssetDownloadPriority("LOCAL", 3, 4);
        LOCAL = r4;
        AssetDownloadPriority r5 = new AssetDownloadPriority("OPEN_DIY_PAGE", 4, 5);
        OPEN_DIY_PAGE = r5;
        AssetDownloadPriority r6 = new AssetDownloadPriority("ANCHOR_MOCK", 5, 100);
        ANCHOR_MOCK = r6;
        a = new AssetDownloadPriority[]{r1, r2, r3, r4, r5, r6};
    }

    public static AssetDownloadPriority valueOf(String r1) {
        return (AssetDownloadPriority) r27.a.a(AssetDownloadPriority.class, r1);
    }

    public static AssetDownloadPriority[] values() {
        return (AssetDownloadPriority[]) a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public AssetDownloadPriority(String r1, int r2, int r3) {
        super(r1, r2);
        this.priority = r3;
    }
}
