package com.larus.dora.impl.guide.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/guide/common/DoraGuideMeta;", "", "guideType", "", "guideId", "<init>", "(Ljava/lang/String;III)V", "getGuideType", "()I", "getGuideId", "DoraBtPermissionGuide", "DoraBindGuide", "DoraKeepAliveGuide", "DoraConnectDeviceGuide", "DoraDNULostUserGuide", "DoraNotificationGuide", "DoraBatteryGuide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraGuideMeta extends Enum<DoraGuideMeta> {
    public static final a Companion = null;
    public static final DoraGuideMeta DoraBatteryGuide = null;
    public static final DoraGuideMeta DoraBindGuide = null;
    public static final DoraGuideMeta DoraBtPermissionGuide = null;
    public static final DoraGuideMeta DoraConnectDeviceGuide = null;
    public static final DoraGuideMeta DoraDNULostUserGuide = null;
    public static final DoraGuideMeta DoraKeepAliveGuide = null;
    public static final DoraGuideMeta DoraNotificationGuide = null;
    public static final /* synthetic */ DoraGuideMeta[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int guideId;
    private final int guideType;

    public static EnumEntries<DoraGuideMeta> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.guide.common.DoraGuideMeta$a] */
    static {
        DoraGuideMeta r0 = new DoraGuideMeta("DoraBtPermissionGuide", 0, GuideType.PERMISSION.getType(), 0);
        DoraBtPermissionGuide = r0;
        GuideType r2 = GuideType.BOTTOM_SHEET;
        DoraGuideMeta r1 = new DoraGuideMeta("DoraBindGuide", 1, r2.getType(), 1);
        DoraBindGuide = r1;
        GuideType r5 = GuideType.BALLOON;
        DoraGuideMeta r4 = new DoraGuideMeta("DoraKeepAliveGuide", 2, r5.getType(), 2);
        DoraKeepAliveGuide = r4;
        DoraGuideMeta r7 = new DoraGuideMeta("DoraConnectDeviceGuide", 3, r5.getType(), 3);
        DoraConnectDeviceGuide = r7;
        DoraGuideMeta r8 = new DoraGuideMeta("DoraDNULostUserGuide", 4, r5.getType(), 4);
        DoraDNULostUserGuide = r8;
        DoraGuideMeta r10 = new DoraGuideMeta("DoraNotificationGuide", 5, r2.getType(), 5);
        DoraNotificationGuide = r10;
        DoraGuideMeta r3 = new DoraGuideMeta("DoraBatteryGuide", 6, r5.getType(), 6);
        DoraBatteryGuide = r3;
        DoraGuideMeta[] r6 = {r0, r1, r4, r7, r8, r10, r3};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
    }

    public static DoraGuideMeta[] values() {
        return (DoraGuideMeta[]) a.clone();
    }

    public final int getGuideId() {
        return this.guideId;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public static DoraGuideMeta valueOf(String r1) {
        return (DoraGuideMeta) r27.a.a(DoraGuideMeta.class, r1);
    }

    public DoraGuideMeta(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.guideType = r3;
        this.guideId = r4;
    }
}
