package com.bytedance.android.live.profit.util;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/util/ProfitNitaViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_VIEW_USER_INFO_MVI_FOLLOW", "TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProfitNitaViewInfo extends Enum<ProfitNitaViewInfo> implements zo2.a {
    public static final ProfitNitaViewInfo TTLIVE_VIEW_USER_INFO_MVI_FOLLOW = null;
    public static final ProfitNitaViewInfo TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE = null;
    public static final /* synthetic */ ProfitNitaViewInfo[] a = null;

    static {
        ProfitNitaViewInfo r1 = new ProfitNitaViewInfo("TTLIVE_VIEW_USER_INFO_MVI_FOLLOW", 0);
        TTLIVE_VIEW_USER_INFO_MVI_FOLLOW = r1;
        ProfitNitaViewInfo r2 = new ProfitNitaViewInfo("TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE", 1);
        TTLIVE_VIEW_USER_INFO_MVI_FOLLOW_VSSYTLE = r2;
        a = new ProfitNitaViewInfo[]{r1, r2};
    }

    public static ProfitNitaViewInfo valueOf(String r1) {
        return (ProfitNitaViewInfo) r27.a.a(ProfitNitaViewInfo.class, r1);
    }

    public static ProfitNitaViewInfo[] values() {
        return (ProfitNitaViewInfo[]) a.clone();
    }

    public int getType() {
        return 0;
    }

    public int getCount() {
        int r0 = f.b[ordinal()];
        if (r0 != 1) goto L5;
    L9:
        return 1;
    L5:
        if (r0 == 2) goto L9;
        throw new NoWhenBranchMatchedException();
    }

    public int getResId() {
        int r0 = f.a[ordinal()];
        if (r0 != 1) goto L5;
        return 2131567556;
    L5:
        if (r0 != 2) goto L8;
        return 2131567557;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public String getTag() {
        return name();
    }

    public ProfitNitaViewInfo(String r1, int r2) {
        super(r1, r2);
    }
}
