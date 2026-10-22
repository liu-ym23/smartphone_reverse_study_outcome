package com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_inject_api/model/share/VsLiveShareType;", "", "SHARE_IM", "SHARE_THIRD", "SHARE_DIALOG", "SHARE_VIDEO2FANSGROUP", "SHARE_TEXT2FANSGROUP", "SHARE_ACTIVITY", "REPORT_DIALOG", "vs-inject-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VsLiveShareType extends Enum<VsLiveShareType> {
    public static final VsLiveShareType REPORT_DIALOG = null;
    public static final VsLiveShareType SHARE_ACTIVITY = null;
    public static final VsLiveShareType SHARE_DIALOG = null;
    public static final VsLiveShareType SHARE_IM = null;
    public static final VsLiveShareType SHARE_TEXT2FANSGROUP = null;
    public static final VsLiveShareType SHARE_THIRD = null;
    public static final VsLiveShareType SHARE_VIDEO2FANSGROUP = null;
    public static final /* synthetic */ VsLiveShareType[] a = null;

    static {
        VsLiveShareType r1 = new VsLiveShareType("SHARE_IM", 0);
        SHARE_IM = r1;
        VsLiveShareType r2 = new VsLiveShareType("SHARE_THIRD", 1);
        SHARE_THIRD = r2;
        VsLiveShareType r3 = new VsLiveShareType("SHARE_DIALOG", 2);
        SHARE_DIALOG = r3;
        VsLiveShareType r4 = new VsLiveShareType("SHARE_VIDEO2FANSGROUP", 3);
        SHARE_VIDEO2FANSGROUP = r4;
        VsLiveShareType r5 = new VsLiveShareType("SHARE_TEXT2FANSGROUP", 4);
        SHARE_TEXT2FANSGROUP = r5;
        VsLiveShareType r6 = new VsLiveShareType("SHARE_ACTIVITY", 5);
        SHARE_ACTIVITY = r6;
        VsLiveShareType r7 = new VsLiveShareType("REPORT_DIALOG", 6);
        REPORT_DIALOG = r7;
        a = new VsLiveShareType[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static VsLiveShareType valueOf(String r1) {
        return (VsLiveShareType) a.a(VsLiveShareType.class, r1);
    }

    public static VsLiveShareType[] values() {
        return (VsLiveShareType[]) a.clone();
    }

    public VsLiveShareType(String r1, int r2) {
        super(r1, r2);
    }
}
