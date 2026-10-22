package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PanelPopupFailed;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "UserBan", "CommentClose", "NotLogin", "SpecialStyle", "LandscapeBlock", "NotPaid", "UserCenterIntercept", "VS", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelPopupFailed extends Enum<PanelPopupFailed> {
    public static final PanelPopupFailed CommentClose = null;
    public static final PanelPopupFailed LandscapeBlock = null;
    public static final PanelPopupFailed NotLogin = null;
    public static final PanelPopupFailed NotPaid = null;
    public static final PanelPopupFailed SpecialStyle = null;
    public static final PanelPopupFailed UserBan = null;
    public static final PanelPopupFailed UserCenterIntercept = null;
    public static final PanelPopupFailed VS = null;
    public static final /* synthetic */ PanelPopupFailed[] a = null;
    private final String reason;

    public static PanelPopupFailed valueOf(String r1) {
        return (PanelPopupFailed) a.a(PanelPopupFailed.class, r1);
    }

    public static PanelPopupFailed[] values() {
        return (PanelPopupFailed[]) a.clone();
    }

    static {
        PanelPopupFailed r1 = new PanelPopupFailed("UserBan", 0, "user_ban");
        UserBan = r1;
        PanelPopupFailed r2 = new PanelPopupFailed("CommentClose", 1, "comment_close");
        CommentClose = r2;
        PanelPopupFailed r3 = new PanelPopupFailed("NotLogin", 2, "not_login");
        NotLogin = r3;
        PanelPopupFailed r4 = new PanelPopupFailed("SpecialStyle", 3, "special_style");
        SpecialStyle = r4;
        PanelPopupFailed r5 = new PanelPopupFailed("LandscapeBlock", 4, "landscape_block");
        LandscapeBlock = r5;
        PanelPopupFailed r6 = new PanelPopupFailed("NotPaid", 5, "not_paid");
        NotPaid = r6;
        PanelPopupFailed r7 = new PanelPopupFailed("UserCenterIntercept", 6, "user_center_intercept");
        UserCenterIntercept = r7;
        PanelPopupFailed r8 = new PanelPopupFailed("VS", 7, "vs");
        VS = r8;
        a = new PanelPopupFailed[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final String getReason() {
        return this.reason;
    }

    public PanelPopupFailed(String r1, int r2, String r3) {
        super(r1, r2);
        this.reason = r3;
    }
}
