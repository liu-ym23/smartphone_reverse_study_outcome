package com.bytedance.android.live.service.preinflate;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019j\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00060"}, d2 = {"Lcom/bytedance/android/live/service/preinflate/ProfilePreInflateViewInfo;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "used", "Z", "getUsed", "()Z", "setUsed", "(Z)V", "", "getResId", "()I", "resId", "getTag", "tag", "getCount", "count", "Ljava/lang/Class;", "Landroid/view/View;", "getContainerViewClass", "()Ljava/lang/Class;", "containerViewClass", "TTLIVE_PROFILE_LAYOUT_PORT", "TTLIVE_PROFILE_LAYOUT_LAND", "TTLIVE_PROFILE_LAYOUT_HD", "TTLIVE_PROFILE_VISITOR_COUNT", "TTLIVE_PROFILE_GROUP_LIVE_MEMBER", "TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", "TTLIVE_PROFILE_FANS_VIP", "TTLIVE_PROFILE_DRESS_PREVIEW", "TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", "TTLIVE_PROFILE_TEXT_INFO", "TTLIVE_PROFILE_ANNOUNCE", "TTLIVE_PROFILE_FOLLOE_BUTTON", "TTLIVE_PROFILE_FANS_GROUP_BUTTON", "TTLIVE_PROFILE_BUTTON", "TTLIVE_PROFILE_OWNER_CENTER_BUTTON", "TTLIVE_PROFILE_ECOM_SET_BUTTON", "TTLIVE_PROFILE_HONOUR_CARD_NEW", "TTLIVE_PROFILE_TAG", "TTLIVE_PROFILE_POI_TAG", "TTLIVE_PROFILE_LIVE_HONOR_TAG", "TTLIVE_PROFILE_LOCAL_LIFE", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProfilePreInflateViewInfo extends Enum<ProfilePreInflateViewInfo> {
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_ANNOUNCE = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_DRESS_PREVIEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_ECOM_SET_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FANS_GROUP_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FANS_VIP = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_FOLLOE_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_GIFT_EXHIBITION_NEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_GROUP_LIVE_MEMBER = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_HONOUR_CARD_NEW = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_HD = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_LAND = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LAYOUT_PORT = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LIVE_HONOR_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_LOCAL_LIFE = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_OWNER_CENTER_BUTTON = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_POI_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_TAG = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_TEXT_INFO = null;
    public static final ProfilePreInflateViewInfo TTLIVE_PROFILE_VISITOR_COUNT = null;
    public static final /* synthetic */ ProfilePreInflateViewInfo[] a = null;
    private final String key;
    private boolean used;

    public ProfilePreInflateViewInfo() {
        throw null;
    }

    public static ProfilePreInflateViewInfo valueOf(String r1) {
        return (ProfilePreInflateViewInfo) r27.a.a(ProfilePreInflateViewInfo.class, r1);
    }

    public static ProfilePreInflateViewInfo[] values() {
        return (ProfilePreInflateViewInfo[]) a.clone();
    }

    static {
        ProfilePreInflateViewInfo r8 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_PORT", 0, "TTLIVE_PROFILE_LAYOUT_PORT", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_PORT = r8;
        ProfilePreInflateViewInfo r1 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_LAND", 1, "TTLIVE_PROFILE_LAYOUT_LAND", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_LAND = r1;
        ProfilePreInflateViewInfo r2 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LAYOUT_HD", 2, "TTLIVE_PROFILE_LAYOUT_HD", false, 2, null);
        TTLIVE_PROFILE_LAYOUT_HD = r2;
        ProfilePreInflateViewInfo r3 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_VISITOR_COUNT", 3, "TTLIVE_PROFILE_VISITOR_COUNT", false, 2, null);
        TTLIVE_PROFILE_VISITOR_COUNT = r3;
        ProfilePreInflateViewInfo r4 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_GROUP_LIVE_MEMBER", 4, "TTLIVE_PROFILE_GROUP_LIVE_MEMBER", false, 2, null);
        TTLIVE_PROFILE_GROUP_LIVE_MEMBER = r4;
        ProfilePreInflateViewInfo r5 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", 5, "TTLIVE_PROFILE_GIFT_EXHIBITION_NEW", false, 2, null);
        TTLIVE_PROFILE_GIFT_EXHIBITION_NEW = r5;
        ProfilePreInflateViewInfo r6 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FANS_VIP", 6, "TTLIVE_PROFILE_FANS_VIP", false, 2, null);
        TTLIVE_PROFILE_FANS_VIP = r6;
        ProfilePreInflateViewInfo r7 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_DRESS_PREVIEW", 7, "TTLIVE_PROFILE_DRESS_PREVIEW", false, 2, null);
        TTLIVE_PROFILE_DRESS_PREVIEW = r7;
        ProfilePreInflateViewInfo r9 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", 8, "TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT", false, 2, null);
        TTLIVE_PROFILE_DRESS_PREVIEW_DEFAULT = r9;
        ProfilePreInflateViewInfo r10 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_TEXT_INFO", 9, "TTLIVE_PROFILE_TEXT_INFO", false, 2, null);
        TTLIVE_PROFILE_TEXT_INFO = r10;
        ProfilePreInflateViewInfo r12 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_ANNOUNCE", 10, "TTLIVE_PROFILE_ANNOUNCE", false, 2, null);
        TTLIVE_PROFILE_ANNOUNCE = r12;
        ProfilePreInflateViewInfo r13 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FOLLOE_BUTTON", 11, "TTLIVE_PROFILE_FOLLOE_BUTTON", false, 2, null);
        TTLIVE_PROFILE_FOLLOE_BUTTON = r13;
        ProfilePreInflateViewInfo r14 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_FANS_GROUP_BUTTON", 12, "TTLIVE_PROFILE_FANS_GROUP_BUTTON", false, 2, null);
        TTLIVE_PROFILE_FANS_GROUP_BUTTON = r14;
        ProfilePreInflateViewInfo r15 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_BUTTON", 13, "TTLIVE_PROFILE_BUTTON", false, 2, null);
        TTLIVE_PROFILE_BUTTON = r15;
        ProfilePreInflateViewInfo r16 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_OWNER_CENTER_BUTTON", 14, "TTLIVE_PROFILE_OWNER_CENTER_BUTTON", false, 2, null);
        TTLIVE_PROFILE_OWNER_CENTER_BUTTON = r16;
        ProfilePreInflateViewInfo r17 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_ECOM_SET_BUTTON", 15, "TTLIVE_PROFILE_ECOM_SET_BUTTON", false, 2, null);
        TTLIVE_PROFILE_ECOM_SET_BUTTON = r17;
        ProfilePreInflateViewInfo r18 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_HONOUR_CARD_NEW", 16, "TTLIVE_PROFILE_HONOUR_CARD_NEW", false, 2, null);
        TTLIVE_PROFILE_HONOUR_CARD_NEW = r18;
        ProfilePreInflateViewInfo r19 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_TAG", 17, "TTLIVE_PROFILE_TAG", false, 2, null);
        TTLIVE_PROFILE_TAG = r19;
        ProfilePreInflateViewInfo r20 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_POI_TAG", 18, "TTLIVE_PROFILE_POI_TAG", false, 2, null);
        TTLIVE_PROFILE_POI_TAG = r20;
        ProfilePreInflateViewInfo r22 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LIVE_HONOR_TAG", 19, "TTLIVE_PROFILE_LIVE_HONOR_TAG", false, 2, null);
        TTLIVE_PROFILE_LIVE_HONOR_TAG = r22;
        ProfilePreInflateViewInfo r23 = new ProfilePreInflateViewInfo("TTLIVE_PROFILE_LOCAL_LIFE", 20, "TTLIVE_PROFILE_LOCAL_LIFE", false, 2, null);
        TTLIVE_PROFILE_LOCAL_LIFE = r23;
        a = new ProfilePreInflateViewInfo[]{r8, r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23};
    }

    public final Class<? extends View> getContainerViewClass() {
        int r0 = c.c[ordinal()];
        if (r0 != 1) goto L5;
        return null;
    L5:
        if (r0 != 2) goto L7;
        return null;
    L7:
        if (r0 == 3) goto L12;
        return FrameLayout.class;
    L12:
        return null;
    }

    public final int getCount() {
        int r0 = c.b[ordinal()];
        if (r0 != 1) goto L5;
        return 3;
    L5:
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L8;
    L9:
        return 1;
    L8:
        if (r0 != 4) goto L9;
        return 3;
    L10:
        return 2;
    }

    public final int getResId() {
        switch(c.a[ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            case 20: goto L7;
            case 21: goto L6;
            default: goto L5;
        };
    L6:
        return 2131567207;
    L7:
        return 2131567183;
    L8:
        return 2131567186;
    L9:
        return 2131567191;
    L10:
        return 2131567190;
    L11:
        return 2131567196;
    L12:
        return 2131567209;
    L13:
        return 2131567198;
    L14:
        return 2131567201;
    L15:
        return 2131567202;
    L16:
        return 2131567197;
    L17:
        return 2131567212;
    L18:
        return 2131567199;
    L19:
        return 2131567200;
    L20:
        return 2131567177;
    L21:
        return 2131567180;
    L22:
        return 2131567181;
    L23:
        return 2131567213;
    L28:
        return 2131565671;
    L29:
        return 2131565673;
    L5:
        throw new NoWhenBranchMatchedException();
    L25:
        if (PadConfigUtils.c() == false) goto L27;
        return 2131565670;
    L27:
        return 0;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getTag() {
        return this.key;
    }

    public final boolean getUsed() {
        return this.used;
    }

    public final void setUsed(boolean r1) {
        this.used = r1;
    }

    public ProfilePreInflateViewInfo(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = false;
    L5:
        super(r1, r2);
        this.key = r3;
        this.used = r4;
    }
}
