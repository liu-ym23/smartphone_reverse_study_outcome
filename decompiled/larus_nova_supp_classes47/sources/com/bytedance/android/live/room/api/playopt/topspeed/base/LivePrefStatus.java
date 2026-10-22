package com.bytedance.android.live.room.api.playopt.topspeed.base;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/api/playopt/topspeed/base/LivePrefStatus;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "PREF_NORMAL", "PREF_MEDIUM", "PREF_SERIOUS", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePrefStatus extends Enum<LivePrefStatus> {
    public static final LivePrefStatus PREF_MEDIUM = null;
    public static final LivePrefStatus PREF_NORMAL = null;
    public static final LivePrefStatus PREF_SERIOUS = null;
    public static final /* synthetic */ LivePrefStatus[] a = null;
    private final int code;

    static {
        LivePrefStatus r1 = new LivePrefStatus("PREF_NORMAL", 0, 0);
        PREF_NORMAL = r1;
        LivePrefStatus r2 = new LivePrefStatus("PREF_MEDIUM", 1, -1);
        PREF_MEDIUM = r2;
        LivePrefStatus r3 = new LivePrefStatus("PREF_SERIOUS", 2, -2);
        PREF_SERIOUS = r3;
        a = new LivePrefStatus[]{r1, r2, r3};
    }

    public static LivePrefStatus valueOf(String r1) {
        return (LivePrefStatus) a.a(LivePrefStatus.class, r1);
    }

    public static LivePrefStatus[] values() {
        return (LivePrefStatus[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public LivePrefStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
