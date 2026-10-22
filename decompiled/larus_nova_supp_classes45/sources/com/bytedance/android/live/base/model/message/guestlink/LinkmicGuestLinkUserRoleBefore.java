package com.bytedance.android.live.base.model.message.guestlink;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/LinkmicGuestLinkUserRoleBefore;", "", "", "value", "I", "getValue", "()I", "LinkmicGuestLinkUserRoleBefore_Audience", "LinkmicGuestLinkUserRoleBefore_Anchor", "LinkmicGuestLinkUserRoleBefore_Guest", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicGuestLinkUserRoleBefore extends Enum<LinkmicGuestLinkUserRoleBefore> {
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Anchor = null;
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Audience = null;
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Guest = null;
    public static final /* synthetic */ LinkmicGuestLinkUserRoleBefore[] a = null;
    private final int value;

    static {
        LinkmicGuestLinkUserRoleBefore r1 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Audience", 0, 0);
        LinkmicGuestLinkUserRoleBefore_Audience = r1;
        LinkmicGuestLinkUserRoleBefore r2 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Anchor", 1, 1);
        LinkmicGuestLinkUserRoleBefore_Anchor = r2;
        LinkmicGuestLinkUserRoleBefore r3 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Guest", 2, 2);
        LinkmicGuestLinkUserRoleBefore_Guest = r3;
        a = new LinkmicGuestLinkUserRoleBefore[]{r1, r2, r3};
    }

    public static LinkmicGuestLinkUserRoleBefore valueOf(String r1) {
        return (LinkmicGuestLinkUserRoleBefore) r27.a.a(LinkmicGuestLinkUserRoleBefore.class, r1);
    }

    public static LinkmicGuestLinkUserRoleBefore[] values() {
        return (LinkmicGuestLinkUserRoleBefore[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicGuestLinkUserRoleBefore(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
