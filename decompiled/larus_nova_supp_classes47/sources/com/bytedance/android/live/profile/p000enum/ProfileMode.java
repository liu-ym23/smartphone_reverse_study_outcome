package com.bytedance.android.live.profile.p000enum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profile/enum/ProfileMode;", "", "NEVER", "NONE", "USER_BEFORE", "USER_CURRENT", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProfileMode extends Enum<ProfileMode> {
    public static final ProfileMode NEVER = null;
    public static final ProfileMode NONE = null;
    public static final ProfileMode USER_BEFORE = null;
    public static final ProfileMode USER_CURRENT = null;
    public static final /* synthetic */ ProfileMode[] a = null;

    static {
        ProfileMode r1 = new ProfileMode("NEVER", 0);
        NEVER = r1;
        ProfileMode r2 = new ProfileMode("NONE", 1);
        NONE = r2;
        ProfileMode r3 = new ProfileMode("USER_BEFORE", 2);
        USER_BEFORE = r3;
        ProfileMode r4 = new ProfileMode("USER_CURRENT", 3);
        USER_CURRENT = r4;
        a = new ProfileMode[]{r1, r2, r3, r4};
    }

    public static ProfileMode valueOf(String r1) {
        return (ProfileMode) a.a(ProfileMode.class, r1);
    }

    public static ProfileMode[] values() {
        return (ProfileMode[]) a.clone();
    }

    public ProfileMode(String r1, int r2) {
        super(r1, r2);
    }
}
