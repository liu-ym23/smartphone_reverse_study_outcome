package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", BuildConfig.FLAVOR, "TOP", "MIDDLE", "BOTTOM", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelItemShowArea extends Enum<PanelItemShowArea> {
    public static final PanelItemShowArea BOTTOM = null;
    public static final PanelItemShowArea MIDDLE = null;
    public static final PanelItemShowArea TOP = null;
    public static final /* synthetic */ PanelItemShowArea[] a = null;

    static {
        PanelItemShowArea r1 = new PanelItemShowArea("TOP", 0);
        TOP = r1;
        PanelItemShowArea r2 = new PanelItemShowArea("MIDDLE", 1);
        MIDDLE = r2;
        PanelItemShowArea r3 = new PanelItemShowArea("BOTTOM", 2);
        BOTTOM = r3;
        a = new PanelItemShowArea[]{r1, r2, r3};
    }

    public static PanelItemShowArea valueOf(String r1) {
        return (PanelItemShowArea) a.a(PanelItemShowArea.class, r1);
    }

    public static PanelItemShowArea[] values() {
        return (PanelItemShowArea[]) a.clone();
    }

    public PanelItemShowArea(String r1, int r2) {
        super(r1, r2);
    }
}
