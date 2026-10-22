package com.bytedance.android.live.openplatform.api.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "", "ConnectionPanel", "ExplainCard", "ExplainCardButton", "ToolbarDirectMicroApp", "ShelfPageMicroApp", "ShelfPageCard", "ShelfPageCardActionButton", "ShelfPageLinkCast", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MountedMiniAppSource extends Enum<MountedMiniAppSource> {
    public static final MountedMiniAppSource ConnectionPanel = null;
    public static final MountedMiniAppSource ExplainCard = null;
    public static final MountedMiniAppSource ExplainCardButton = null;
    public static final MountedMiniAppSource ShelfPageCard = null;
    public static final MountedMiniAppSource ShelfPageCardActionButton = null;
    public static final MountedMiniAppSource ShelfPageLinkCast = null;
    public static final MountedMiniAppSource ShelfPageMicroApp = null;
    public static final MountedMiniAppSource ToolbarDirectMicroApp = null;
    public static final /* synthetic */ MountedMiniAppSource[] a = null;

    static {
        MountedMiniAppSource r1 = new MountedMiniAppSource("ConnectionPanel", 0);
        ConnectionPanel = r1;
        MountedMiniAppSource r2 = new MountedMiniAppSource("ExplainCard", 1);
        ExplainCard = r2;
        MountedMiniAppSource r3 = new MountedMiniAppSource("ExplainCardButton", 2);
        ExplainCardButton = r3;
        MountedMiniAppSource r4 = new MountedMiniAppSource("ToolbarDirectMicroApp", 3);
        ToolbarDirectMicroApp = r4;
        MountedMiniAppSource r5 = new MountedMiniAppSource("ShelfPageMicroApp", 4);
        ShelfPageMicroApp = r5;
        MountedMiniAppSource r6 = new MountedMiniAppSource("ShelfPageCard", 5);
        ShelfPageCard = r6;
        MountedMiniAppSource r7 = new MountedMiniAppSource("ShelfPageCardActionButton", 6);
        ShelfPageCardActionButton = r7;
        MountedMiniAppSource r8 = new MountedMiniAppSource("ShelfPageLinkCast", 7);
        ShelfPageLinkCast = r8;
        a = new MountedMiniAppSource[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static MountedMiniAppSource valueOf(String r1) {
        return (MountedMiniAppSource) a.a(MountedMiniAppSource.class, r1);
    }

    public static MountedMiniAppSource[] values() {
        return (MountedMiniAppSource[]) a.clone();
    }

    public MountedMiniAppSource(String r1, int r2) {
        super(r1, r2);
    }
}
