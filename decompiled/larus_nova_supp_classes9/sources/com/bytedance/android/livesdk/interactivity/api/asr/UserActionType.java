package com.bytedance.android.livesdk.interactivity.api.asr;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/UserActionType;", BuildConfig.FLAVOR, "Unknown", "Welcome", "Thanks", "Congrats", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserActionType extends Enum<UserActionType> {
    public static final UserActionType Congrats = null;
    public static final UserActionType Thanks = null;
    public static final UserActionType Unknown = null;
    public static final UserActionType Welcome = null;
    public static final /* synthetic */ UserActionType[] a = null;

    static {
        UserActionType r1 = new UserActionType("Unknown", 0);
        Unknown = r1;
        UserActionType r2 = new UserActionType("Welcome", 1);
        Welcome = r2;
        UserActionType r3 = new UserActionType("Thanks", 2);
        Thanks = r3;
        UserActionType r4 = new UserActionType("Congrats", 3);
        Congrats = r4;
        a = new UserActionType[]{r1, r2, r3, r4};
    }

    public static UserActionType valueOf(String r1) {
        return (UserActionType) a.a(UserActionType.class, r1);
    }

    public static UserActionType[] values() {
        return (UserActionType[]) a.clone();
    }

    public UserActionType(String r1, int r2) {
        super(r1, r2);
    }
}
