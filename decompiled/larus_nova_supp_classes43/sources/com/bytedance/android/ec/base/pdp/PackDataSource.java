package com.bytedance.android.ec.base.pdp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/base/pdp/PackDataSource;", "", "STANDARD", "FORCE_NET", "ec-base_release"}, k = 1, mv = {1, 4, 3})
public final enum PackDataSource extends Enum<PackDataSource> {
    public static final PackDataSource FORCE_NET = null;
    public static final PackDataSource STANDARD = null;
    public static final /* synthetic */ PackDataSource[] a = null;

    static {
        PackDataSource r1 = new PackDataSource("STANDARD", 0);
        STANDARD = r1;
        PackDataSource r10 = new PackDataSource("FORCE_NET", 1);
        FORCE_NET = r10;
        a = new PackDataSource[]{r1, r10};
    }

    public static PackDataSource valueOf(String r1) {
        return (PackDataSource) a.a(PackDataSource.class, r1);
    }

    public static PackDataSource[] values() {
        return (PackDataSource[]) a.clone();
    }

    public PackDataSource(String r1, int r10) {
        super(r1, r10);
    }
}
