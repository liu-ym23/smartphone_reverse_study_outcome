package com.bytedance.android.live.liveinteract.interactivesong.logger;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/logger/UserType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ANCHOR", "ADMIN", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserType extends Enum<UserType> {
    public static final UserType ADMIN = null;
    public static final UserType ANCHOR = null;
    public static final /* synthetic */ UserType[] a = null;
    private final String value;

    static {
        UserType r1 = new UserType("ANCHOR", 0, "anchor");
        ANCHOR = r1;
        UserType r2 = new UserType("ADMIN", 1, "admin");
        ADMIN = r2;
        a = new UserType[]{r1, r2};
    }

    public static UserType valueOf(String r1) {
        return (UserType) a.a(UserType.class, r1);
    }

    public static UserType[] values() {
        return (UserType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public UserType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
