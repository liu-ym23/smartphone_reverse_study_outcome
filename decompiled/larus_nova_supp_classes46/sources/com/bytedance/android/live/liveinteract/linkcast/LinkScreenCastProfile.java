package com.bytedance.android.live.liveinteract.linkcast;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkcast/LinkScreenCastProfile;", "", "SCREEN_CAST_PROFILE_UNKNOWN", "SCREEN_CAST_PROFILE_15FPS", "SCREEN_CAST_PROFILE_30FPS", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkScreenCastProfile extends Enum<LinkScreenCastProfile> {
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_15FPS = null;
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_30FPS = null;
    public static final LinkScreenCastProfile SCREEN_CAST_PROFILE_UNKNOWN = null;
    public static final /* synthetic */ LinkScreenCastProfile[] a = null;

    static {
        LinkScreenCastProfile r1 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_UNKNOWN", 0);
        SCREEN_CAST_PROFILE_UNKNOWN = r1;
        LinkScreenCastProfile r2 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_15FPS", 1);
        SCREEN_CAST_PROFILE_15FPS = r2;
        LinkScreenCastProfile r3 = new LinkScreenCastProfile("SCREEN_CAST_PROFILE_30FPS", 2);
        SCREEN_CAST_PROFILE_30FPS = r3;
        a = new LinkScreenCastProfile[]{r1, r2, r3};
    }

    public static LinkScreenCastProfile valueOf(String r1) {
        return (LinkScreenCastProfile) r27.a.a(LinkScreenCastProfile.class, r1);
    }

    public static LinkScreenCastProfile[] values() {
        return (LinkScreenCastProfile[]) a.clone();
    }

    public LinkScreenCastProfile(String r1, int r2) {
        super(r1, r2);
    }
}
