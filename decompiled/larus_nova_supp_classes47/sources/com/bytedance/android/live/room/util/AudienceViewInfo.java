package com.bytedance.android.live.room.util;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/util/AudienceViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE", "TTLIVE_VIEW_AUDIENCE_LIST_ITEM", "TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudienceViewInfo extends Enum<AudienceViewInfo> implements zo2.a {
    public static final AudienceViewInfo TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW = null;
    public static final AudienceViewInfo TTLIVE_VIEW_AUDIENCE_LIST_ITEM = null;
    public static final AudienceViewInfo TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE = null;
    public static final /* synthetic */ AudienceViewInfo[] a = null;

    static {
        AudienceViewInfo r1 = new AudienceViewInfo("TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE", 0);
        TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE = r1;
        AudienceViewInfo r2 = new AudienceViewInfo("TTLIVE_VIEW_AUDIENCE_LIST_ITEM", 1);
        TTLIVE_VIEW_AUDIENCE_LIST_ITEM = r2;
        AudienceViewInfo r3 = new AudienceViewInfo("TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", 2);
        TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW = r3;
        a = new AudienceViewInfo[]{r1, r2, r3};
    }

    public static AudienceViewInfo valueOf(String r1) {
        return (AudienceViewInfo) r27.a.a(AudienceViewInfo.class, r1);
    }

    public static AudienceViewInfo[] values() {
        return (AudienceViewInfo[]) a.clone();
    }

    public int getType() {
        return 0;
    }

    public int getCount() {
        int r0 = d.b[ordinal()];
        if (r0 != 1) goto L5;
        return 3;
    L5:
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        throw new NoWhenBranchMatchedException();
    L10:
        return 1;
    }

    public int getResId() {
        int r0 = d.a[ordinal()];
        if (r0 != 1) goto L5;
        return 2131567609;
    L5:
        if (r0 != 2) goto L7;
        return 2131567608;
    L7:
        if (r0 != 3) goto L10;
        return 2131566644;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public String getTag() {
        return name();
    }

    public AudienceViewInfo(String r1, int r2) {
        super(r1, r2);
    }
}
