package com.bytedance.ies.bullet.base.core.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/base/core/common/PadAdapterStyle;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum PadAdapterStyle extends Enum<PadAdapterStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PadAdapterStyle f5186a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PadAdapterStyle f5187b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PadAdapterStyle f5188c = null;
    public static final PadAdapterStyle d = null;
    public static final /* synthetic */ PadAdapterStyle[] e = null;

    static {
        PadAdapterStyle r5 = new PadAdapterStyle("WIDTH_PERCENT", 0, "width_percent");
        f5186a = r5;
        PadAdapterStyle r10 = new PadAdapterStyle("UNIFORM_STYLE", 1, "uniform_style");
        f5187b = r10;
        PadAdapterStyle r11 = new PadAdapterStyle("CHANNEL_STYLE", 2, "channel_style");
        f5188c = r11;
        PadAdapterStyle r12 = new PadAdapterStyle("NONE", 3, "none");
        d = r12;
        e = new PadAdapterStyle[]{r5, r10, r11, r12};
    }

    public PadAdapterStyle(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static PadAdapterStyle valueOf(String r5) {
        return (PadAdapterStyle) Enum.valueOf(PadAdapterStyle.class, r5);
    }

    public static PadAdapterStyle[] values() {
        return (PadAdapterStyle[]) e.clone();
    }
}
