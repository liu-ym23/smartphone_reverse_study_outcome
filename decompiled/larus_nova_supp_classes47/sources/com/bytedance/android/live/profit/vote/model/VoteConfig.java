package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.LiveVoteConfig;
import com.bytedance.android.live.profit.vote.l;
import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteConfig {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/VoteConfig$Plan;", "", "A", "B", "C", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Plan extends Enum<Plan> {
        public static final Plan A = null;
        public static final Plan B = null;
        public static final Plan C = null;
        public static final /* synthetic */ Plan[] a = null;

        static {
            Plan r1 = new Plan("A", 0);
            A = r1;
            Plan r2 = new Plan("B", 1);
            B = r2;
            Plan r3 = new Plan("C", 2);
            C = r3;
            a = new Plan[]{r1, r2, r3};
        }

        public static Plan valueOf(String r1) {
            return (Plan) r27.a.a(Plan.class, r1);
        }

        public static Plan[] values() {
            return (Plan[]) a.clone();
        }

        public Plan(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static String a() {
        LiveVoteConfig r0 = l.a();
        if (r0 == null) goto L13;
        String r1 = r0.g7();
        if (r1 == null) goto L13;
        if (r1.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L13;
        return r1;
    L9:
        r2 = false;
    L13:
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L16;
        return "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fgift_pk%2Fdetails%2Findex.html&type=popup&gravity=center&web_bg_color=%2300000000&title=&hide_more=0&hide_nav_bar=1&hide_status_bar=0&radius=4&open_animate=1&height=386&width=280";
    L16:
        return "";
    }

    public static String b() {
        LiveVoteConfig r0 = l.a();
        if (r0 == null) goto L13;
        String r1 = r0.Y2();
        if (r1 == null) goto L13;
        if (r1.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L13;
        return r1;
    L9:
        r2 = false;
    L13:
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L16;
        return "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fgift_pk%2Fdetails_v2%2Findex.html&type=popup&width_percent=100&rate_height=450&gravity=bottom&web_bg_color=%2300000000&title=&hide_more=0&hide_nav_bar=1&hide_status_bar=0&radius=8&open_animate=1";
    L16:
        return "";
    }

    public static Plan c() {
        LiveVoteConfig r0 = l.a();
        if (r0 == null) goto L5;
        Integer r1 = r0.V3();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 == null) goto L22;
        if (r1.intValue() != 3) goto L22;
        return Plan.C;
    L22:
        return Plan.A;
    L14:
        if (r1.intValue() != 2) goto L16;
        return Plan.B;
    L9:
        if (r1.intValue() != 1) goto L11;
        return Plan.A;
    L5:
        r1 = null;
        goto L6
    }

    static {
    }

    public static boolean d(boolean r1) {
        if (r1 == true) goto L11;
        LiveVoteConfig r2 = l.a();
        if (r2 == null) goto L9;
        Integer r3 = r2.V3();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        if (r4 > 0) goto L11;
        return false;
    L9:
        r4 = 0;
    L11:
        return true;
    }
}
