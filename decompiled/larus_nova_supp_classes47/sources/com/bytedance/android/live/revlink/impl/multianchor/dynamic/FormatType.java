package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/FormatType;", "", "OLD", "NEW", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FormatType extends Enum<FormatType> {
    public static final FormatType NEW = null;
    public static final FormatType OLD = null;
    public static final /* synthetic */ FormatType[] a = null;

    static {
        FormatType r1 = new FormatType("OLD", 0);
        OLD = r1;
        FormatType r2 = new FormatType("NEW", 1);
        NEW = r2;
        a = new FormatType[]{r1, r2};
    }

    public static FormatType valueOf(String r1) {
        return (FormatType) r27.a.a(FormatType.class, r1);
    }

    public static FormatType[] values() {
        return (FormatType[]) a.clone();
    }

    public FormatType(String r1, int r2) {
        super(r1, r2);
    }
}
