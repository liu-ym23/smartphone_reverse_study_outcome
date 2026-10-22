package com.bytedance.android.live.pushstream.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/pushstream/model/LiveRequestSourceRole;", "", "", "value", "I", "getValue", "()I", "User", "Business", "RoomState", "livepushstream-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRequestSourceRole extends Enum<LiveRequestSourceRole> {
    public static final LiveRequestSourceRole Business = null;
    public static final LiveRequestSourceRole RoomState = null;
    public static final LiveRequestSourceRole User = null;
    public static final /* synthetic */ LiveRequestSourceRole[] a = null;
    private final int value;

    static {
        LiveRequestSourceRole r1 = new LiveRequestSourceRole("User", 0, 0);
        User = r1;
        LiveRequestSourceRole r2 = new LiveRequestSourceRole("Business", 1, 1);
        Business = r2;
        LiveRequestSourceRole r3 = new LiveRequestSourceRole("RoomState", 2, 2);
        RoomState = r3;
        a = new LiveRequestSourceRole[]{r1, r2, r3};
    }

    public static LiveRequestSourceRole valueOf(String r1) {
        return (LiveRequestSourceRole) a.a(LiveRequestSourceRole.class, r1);
    }

    public static LiveRequestSourceRole[] values() {
        return (LiveRequestSourceRole[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveRequestSourceRole(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
