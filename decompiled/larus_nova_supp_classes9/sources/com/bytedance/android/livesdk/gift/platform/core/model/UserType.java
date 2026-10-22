package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/UserType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "Audience", "Anchor", "Guest", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UserType extends Enum<UserType> {
    public static final UserType Anchor = null;
    public static final UserType Audience = null;
    public static final UserType Guest = null;
    public static final /* synthetic */ UserType[] a = null;
    private final int value;

    static {
        UserType r1 = new UserType("Audience", 0, 1);
        Audience = r1;
        UserType r2 = new UserType("Anchor", 1, 2);
        Anchor = r2;
        UserType r3 = new UserType("Guest", 2, 4);
        Guest = r3;
        a = new UserType[]{r1, r2, r3};
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
