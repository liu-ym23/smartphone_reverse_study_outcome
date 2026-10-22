package com.bytedance.android.live.network.impl.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/network/impl/utils/PATH;", "", "", "path", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "desc", "getDesc", "WEBCAST_FEED_PATH", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PATH extends Enum<PATH> {
    public static final PATH WEBCAST_FEED_PATH = null;
    public static final /* synthetic */ PATH[] a = null;
    private final String desc;
    private final String path;

    static {
        PATH r1 = new PATH();
        WEBCAST_FEED_PATH = r1;
        a = new PATH[]{r1};
    }

    public static PATH valueOf(String r1) {
        return (PATH) r27.a.a(PATH.class, r1);
    }

    public static PATH[] values() {
        return (PATH[]) a.clone();
    }

    public PATH() {
        super("WEBCAST_FEED_PATH", 0);
        this.path = "webcast_feed";
        this.desc = "直播内流接口";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getPath() {
        return this.path;
    }
}
