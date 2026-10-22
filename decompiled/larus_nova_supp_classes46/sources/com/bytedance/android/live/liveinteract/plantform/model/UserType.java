package com.bytedance.android.live.liveinteract.plantform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/UserType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "ANCHOR", "AUDIENCE", "GUEST", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserType extends Enum<UserType> {
    public static final UserType ANCHOR = null;
    public static final UserType AUDIENCE = null;
    public static final UserType GUEST = null;
    public static final UserType UNKNOWN = null;
    public static final /* synthetic */ UserType[] a = null;
    private final int value;

    static {
        UserType r1 = new UserType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        UserType r2 = new UserType("ANCHOR", 1, 1);
        ANCHOR = r2;
        UserType r3 = new UserType("AUDIENCE", 2, 2);
        AUDIENCE = r3;
        UserType r4 = new UserType("GUEST", 3, 3);
        GUEST = r4;
        a = new UserType[]{r1, r2, r3, r4};
    }

    public static UserType valueOf(String r1) {
        return (UserType) r27.a.a(UserType.class, r1);
    }

    public static UserType[] values() {
        return (UserType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
