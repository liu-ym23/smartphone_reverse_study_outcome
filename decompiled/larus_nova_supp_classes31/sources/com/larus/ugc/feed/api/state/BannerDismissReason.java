package com.larus.ugc.feed.api.state;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/state/BannerDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_ACTION", "CLICK_DISMISS", "AUTO_DISMISS", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum BannerDismissReason extends Enum<BannerDismissReason> {
    public static final BannerDismissReason AUTO_DISMISS = null;
    public static final BannerDismissReason CLICK_ACTION = null;
    public static final BannerDismissReason CLICK_DISMISS = null;
    public static final /* synthetic */ BannerDismissReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BannerDismissReason> getEntries() {
        return b;
    }

    static {
        BannerDismissReason r0 = new BannerDismissReason("CLICK_ACTION", 0);
        CLICK_ACTION = r0;
        BannerDismissReason r1 = new BannerDismissReason("CLICK_DISMISS", 1);
        CLICK_DISMISS = r1;
        BannerDismissReason r3 = new BannerDismissReason("AUTO_DISMISS", 2);
        AUTO_DISMISS = r3;
        BannerDismissReason[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BannerDismissReason[] values() {
        return (BannerDismissReason[]) a.clone();
    }

    public static BannerDismissReason valueOf(String r1) {
        return (BannerDismissReason) a.a(BannerDismissReason.class, r1);
    }

    public BannerDismissReason(String r1, int r2) {
        super(r1, r2);
    }
}
