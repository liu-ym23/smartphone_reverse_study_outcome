package com.bytedance.android.live.room.api.share.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/share/model/LiveShareType;", "", "SHARE_IM", "SHARE_THIRD", "SHARE_DIALOG", "SHARE_LIVE", "SHARE_VIDEO2FANSGROUP", "SHARE_TEXT2FANSGROUP", "SHARE_ACTIVITY", "SHARE_DIRECT", "REPORT_DIALOG", "SHARE_JSB", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveShareType extends Enum<LiveShareType> {
    public static final LiveShareType REPORT_DIALOG = null;
    public static final LiveShareType SHARE_ACTIVITY = null;
    public static final LiveShareType SHARE_DIALOG = null;
    public static final LiveShareType SHARE_DIRECT = null;
    public static final LiveShareType SHARE_IM = null;
    public static final LiveShareType SHARE_JSB = null;
    public static final LiveShareType SHARE_LIVE = null;
    public static final LiveShareType SHARE_TEXT2FANSGROUP = null;
    public static final LiveShareType SHARE_THIRD = null;
    public static final LiveShareType SHARE_VIDEO2FANSGROUP = null;
    public static final /* synthetic */ LiveShareType[] a = null;

    static {
        LiveShareType r1 = new LiveShareType("SHARE_IM", 0);
        SHARE_IM = r1;
        LiveShareType r2 = new LiveShareType("SHARE_THIRD", 1);
        SHARE_THIRD = r2;
        LiveShareType r3 = new LiveShareType("SHARE_DIALOG", 2);
        SHARE_DIALOG = r3;
        LiveShareType r4 = new LiveShareType("SHARE_LIVE", 3);
        SHARE_LIVE = r4;
        LiveShareType r5 = new LiveShareType("SHARE_VIDEO2FANSGROUP", 4);
        SHARE_VIDEO2FANSGROUP = r5;
        LiveShareType r6 = new LiveShareType("SHARE_TEXT2FANSGROUP", 5);
        SHARE_TEXT2FANSGROUP = r6;
        LiveShareType r7 = new LiveShareType("SHARE_ACTIVITY", 6);
        SHARE_ACTIVITY = r7;
        LiveShareType r8 = new LiveShareType("SHARE_DIRECT", 7);
        SHARE_DIRECT = r8;
        LiveShareType r9 = new LiveShareType("REPORT_DIALOG", 8);
        REPORT_DIALOG = r9;
        LiveShareType r10 = new LiveShareType("SHARE_JSB", 9);
        SHARE_JSB = r10;
        a = new LiveShareType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static LiveShareType valueOf(String r1) {
        return (LiveShareType) a.a(LiveShareType.class, r1);
    }

    public static LiveShareType[] values() {
        return (LiveShareType[]) a.clone();
    }

    public LiveShareType(String r1, int r2) {
        super(r1, r2);
    }
}
