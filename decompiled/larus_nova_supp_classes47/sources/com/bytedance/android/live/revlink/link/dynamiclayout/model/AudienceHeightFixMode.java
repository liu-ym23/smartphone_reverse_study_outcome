package com.bytedance.android.live.revlink.link.dynamiclayout.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/AudienceHeightFixMode;", "", "OriginContainerHeight", "RationTransformHeight", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudienceHeightFixMode extends Enum<AudienceHeightFixMode> {
    public static final AudienceHeightFixMode OriginContainerHeight = null;
    public static final AudienceHeightFixMode RationTransformHeight = null;
    public static final /* synthetic */ AudienceHeightFixMode[] a = null;

    static {
        AudienceHeightFixMode r1 = new AudienceHeightFixMode("OriginContainerHeight", 0);
        OriginContainerHeight = r1;
        AudienceHeightFixMode r2 = new AudienceHeightFixMode("RationTransformHeight", 1);
        RationTransformHeight = r2;
        a = new AudienceHeightFixMode[]{r1, r2};
    }

    public static AudienceHeightFixMode valueOf(String r1) {
        return (AudienceHeightFixMode) a.a(AudienceHeightFixMode.class, r1);
    }

    public static AudienceHeightFixMode[] values() {
        return (AudienceHeightFixMode[]) a.clone();
    }

    public AudienceHeightFixMode(String r1, int r2) {
        super(r1, r2);
    }
}
