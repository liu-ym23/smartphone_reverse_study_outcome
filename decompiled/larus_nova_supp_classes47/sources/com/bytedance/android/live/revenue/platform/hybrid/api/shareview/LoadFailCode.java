package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/hybrid/api/shareview/LoadFailCode;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "Companion", "a", "Unknown", "CompLoadFailed", "SharerCreateFailed", "SharerNotSupported", "SharerReleased", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadFailCode extends Enum<LoadFailCode> {
    public static final LoadFailCode CompLoadFailed = null;
    public static final a Companion = null;
    public static final LoadFailCode SharerCreateFailed = null;
    public static final LoadFailCode SharerNotSupported = null;
    public static final LoadFailCode SharerReleased = null;
    public static final LoadFailCode Unknown = null;
    public static final /* synthetic */ LoadFailCode[] a = null;
    public static final Map<Integer, LoadFailCode> b = null;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    static {
        int r3 = 0;
        LoadFailCode r1 = new LoadFailCode("Unknown", 0, 0);
        Unknown = r1;
        LoadFailCode r2 = new LoadFailCode("CompLoadFailed", 1, 1);
        CompLoadFailed = r2;
        LoadFailCode r4 = new LoadFailCode("SharerCreateFailed", 2, 2);
        SharerCreateFailed = r4;
        LoadFailCode r5 = new LoadFailCode("SharerNotSupported", 3, 3);
        SharerNotSupported = r5;
        LoadFailCode r6 = new LoadFailCode("SharerReleased", 4, 4);
        SharerReleased = r6;
        a = new LoadFailCode[]{r1, r2, r4, r5, r6};
        Companion = new a();
        LoadFailCode[] r0 = values();
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
        int r8 = r0.length;
    L3:
        if (r3 >= r8) goto L5;
        LoadFailCode r9 = r0[r3];
        r7.put(Integer.valueOf(r9.code), r9);
        r3 = r3 + 1;
        goto L3
    L5:
        b = r7;
    }

    public static LoadFailCode valueOf(String r1) {
        return (LoadFailCode) r27.a.a(LoadFailCode.class, r1);
    }

    public static LoadFailCode[] values() {
        return (LoadFailCode[]) a.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return b;
    }

    public final int getCode() {
        return this.code;
    }

    public LoadFailCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
