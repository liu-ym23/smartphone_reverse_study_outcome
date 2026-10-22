package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layer/base/LayerBackgroundStatus;", "", "Normal", "Audio", "Leave", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LayerBackgroundStatus extends Enum<LayerBackgroundStatus> {
    public static final LayerBackgroundStatus Audio = null;
    public static final LayerBackgroundStatus Leave = null;
    public static final LayerBackgroundStatus Normal = null;
    public static final /* synthetic */ LayerBackgroundStatus[] a = null;

    static {
        LayerBackgroundStatus r1 = new LayerBackgroundStatus("Normal", 0);
        Normal = r1;
        LayerBackgroundStatus r2 = new LayerBackgroundStatus("Audio", 1);
        Audio = r2;
        LayerBackgroundStatus r3 = new LayerBackgroundStatus("Leave", 2);
        Leave = r3;
        a = new LayerBackgroundStatus[]{r1, r2, r3};
    }

    public static LayerBackgroundStatus valueOf(String r1) {
        return (LayerBackgroundStatus) a.a(LayerBackgroundStatus.class, r1);
    }

    public static LayerBackgroundStatus[] values() {
        return (LayerBackgroundStatus[]) a.clone();
    }

    public LayerBackgroundStatus(String r1, int r2) {
        super(r1, r2);
    }
}
