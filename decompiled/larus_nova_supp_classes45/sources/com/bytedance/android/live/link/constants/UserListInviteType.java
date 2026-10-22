package com.bytedance.android.live.link.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class UserListInviteType {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/link/constants/UserListInviteType$InviteType;", "", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface InviteType {
    }

    static {
    }

    public static String a(int r1, Map r2) {
        if (r2 == null) goto L8;
        if (r2.get(Integer.valueOf(r1)) == null) goto L8;
        Object r3 = r2.get(Integer.valueOf(r1));
        Intrinsics.checkNotNull(r3);
        return (String) r3;
    L8:
        if (r1 != 20) goto L10;
        return "relink_team";
    L10:
        if (r1 != 21) goto L12;
        return "relink_player";
    L12:
        if (r1 == 110) goto L37;
        switch(r1) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L36;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            default: goto L14;
        };
    L14:
        switch(r1) {
            case 101: goto L35;
            case 102: goto L34;
            case 103: goto L33;
            case 104: goto L32;
            case 105: goto L31;
            case 106: goto L30;
            case 107: goto L29;
            default: goto L36;
        };
    L29:
        return "near";
    L30:
        return "recommend_similar";
    L31:
        return "follow_and_pk";
    L32:
        return "mixed_recommend";
    L33:
        return "mixed_mutual_recommend";
    L34:
        return "random_recommend";
    L35:
        return "random_follow";
    L16:
        return "strategy_invite";
    L17:
        return "flex_activity";
    L18:
        return "best_invite_recomm";
    L19:
        return "popularity_rank";
    L20:
        return "campaign";
    L21:
        return "history";
    L22:
        return "regional_rank";
    L23:
        return "hourly_rank";
    L24:
        return "search";
    L25:
        return "recent";
    L26:
        return "recommend";
    L27:
        return "mutual_follow";
    L28:
        return "random";
    L36:
        return "other_follow";
    L37:
        return "custom_preference";
    }
}
