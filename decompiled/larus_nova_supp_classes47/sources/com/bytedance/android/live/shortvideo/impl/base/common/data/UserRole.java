package com.bytedance.android.live.shortvideo.impl.base.common.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/shortvideo/impl/base/common/data/UserRole;", "", "Anchor", "Audience", "Guest", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserRole extends Enum<UserRole> {
    public static final UserRole Anchor = null;
    public static final UserRole Audience = null;
    public static final UserRole Guest = null;
    public static final /* synthetic */ UserRole[] a = null;

    static {
        UserRole r1 = new UserRole("Anchor", 0);
        Anchor = r1;
        UserRole r2 = new UserRole("Audience", 1);
        Audience = r2;
        UserRole r3 = new UserRole("Guest", 2);
        Guest = r3;
        a = new UserRole[]{r1, r2, r3};
    }

    public static UserRole valueOf(String r1) {
        return (UserRole) a.a(UserRole.class, r1);
    }

    public static UserRole[] values() {
        return (UserRole[]) a.clone();
    }

    public UserRole(String r1, int r2) {
        super(r1, r2);
    }
}
