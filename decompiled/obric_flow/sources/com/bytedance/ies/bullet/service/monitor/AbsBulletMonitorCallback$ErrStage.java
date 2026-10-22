package com.bytedance.ies.bullet.service.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage", "", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback$ErrStage;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AbsBulletMonitorCallback$ErrStage extends Enum<AbsBulletMonitorCallback$ErrStage> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbsBulletMonitorCallback$ErrStage f6029b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbsBulletMonitorCallback$ErrStage f6030c = null;
    public static final AbsBulletMonitorCallback$ErrStage d = null;
    public static final AbsBulletMonitorCallback$ErrStage e = null;
    public static final /* synthetic */ AbsBulletMonitorCallback$ErrStage[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6031a;

    static {
        AbsBulletMonitorCallback$ErrStage r5 = new AbsBulletMonitorCallback$ErrStage("Container", 0, "bullet");
        f6029b = r5;
        AbsBulletMonitorCallback$ErrStage r10 = new AbsBulletMonitorCallback$ErrStage("Engine", 1, "engine");
        f6030c = r10;
        AbsBulletMonitorCallback$ErrStage r11 = new AbsBulletMonitorCallback$ErrStage("Plugin", 2, "plugin");
        d = r11;
        AbsBulletMonitorCallback$ErrStage r12 = new AbsBulletMonitorCallback$ErrStage("Business", 3, "business");
        AbsBulletMonitorCallback$ErrStage r13 = new AbsBulletMonitorCallback$ErrStage("RL", 4, "resource");
        e = r13;
        f = new AbsBulletMonitorCallback$ErrStage[]{r5, r10, r11, r12, r13};
    }

    public AbsBulletMonitorCallback$ErrStage(String r5, int r10, String r11) {
        super(r5, r10);
        this.f6031a = r11;
    }

    public static AbsBulletMonitorCallback$ErrStage valueOf(String r5) {
        return (AbsBulletMonitorCallback$ErrStage) Enum.valueOf(AbsBulletMonitorCallback$ErrStage.class, r5);
    }

    public static AbsBulletMonitorCallback$ErrStage[] values() {
        return (AbsBulletMonitorCallback$ErrStage[]) f.clone();
    }
}
