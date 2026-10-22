package com.bytedance.pia.core.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/pia/core/utils/ManifestUtils$State", "", "Lcom/bytedance/pia/core/utils/ManifestUtils$State;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
final enum ManifestUtils$State extends Enum<ManifestUtils$State> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ManifestUtils$State f7128a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ManifestUtils$State f7129b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ManifestUtils$State f7130c = null;
    public static final ManifestUtils$State d = null;
    public static final /* synthetic */ ManifestUtils$State[] e = null;

    static {
        ManifestUtils$State r5 = new ManifestUtils$State("Start", 0);
        f7128a = r5;
        ManifestUtils$State r10 = new ManifestUtils$State("ManifestStartLeft", 1);
        f7129b = r10;
        ManifestUtils$State r11 = new ManifestUtils$State("ManifestStartRight", 2);
        f7130c = r11;
        ManifestUtils$State r12 = new ManifestUtils$State("End", 3);
        d = r12;
        e = new ManifestUtils$State[]{r5, r10, r11, r12};
    }

    public ManifestUtils$State(String r5, int r10) {
        super(r5, r10);
    }

    public static ManifestUtils$State valueOf(String r5) {
        return (ManifestUtils$State) Enum.valueOf(ManifestUtils$State.class, r5);
    }

    public static ManifestUtils$State[] values() {
        return (ManifestUtils$State[]) e.clone();
    }
}
