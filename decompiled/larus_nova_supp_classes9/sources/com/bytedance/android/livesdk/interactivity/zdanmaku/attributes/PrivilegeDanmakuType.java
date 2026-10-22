package com.bytedance.android.livesdk.interactivity.zdanmaku.attributes;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import nf6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/attributes/PrivilegeDanmakuType;", BuildConfig.FLAVOR, "Lnf6/a;", "MultiLine", "SingleLine", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PrivilegeDanmakuType extends Enum<PrivilegeDanmakuType> implements a {
    public static final PrivilegeDanmakuType MultiLine = null;
    public static final PrivilegeDanmakuType SingleLine = null;
    public static final /* synthetic */ PrivilegeDanmakuType[] a = null;

    static {
        PrivilegeDanmakuType r1 = new PrivilegeDanmakuType("MultiLine", 0);
        MultiLine = r1;
        PrivilegeDanmakuType r2 = new PrivilegeDanmakuType("SingleLine", 1);
        SingleLine = r2;
        a = new PrivilegeDanmakuType[]{r1, r2};
    }

    public static PrivilegeDanmakuType valueOf(String r1) {
        return (PrivilegeDanmakuType) r27.a.a(PrivilegeDanmakuType.class, r1);
    }

    public static PrivilegeDanmakuType[] values() {
        return (PrivilegeDanmakuType[]) a.clone();
    }

    public PrivilegeDanmakuType(String r1, int r2) {
        super(r1, r2);
    }
}
