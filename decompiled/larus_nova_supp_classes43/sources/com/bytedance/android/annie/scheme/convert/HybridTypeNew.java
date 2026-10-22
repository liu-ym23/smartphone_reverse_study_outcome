package com.bytedance.android.annie.scheme.convert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/scheme/convert/HybridTypeNew;", "", "H5", "Lynx", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum HybridTypeNew extends Enum<HybridTypeNew> {
    public static final HybridTypeNew H5 = null;
    public static final HybridTypeNew Lynx = null;
    public static final /* synthetic */ HybridTypeNew[] a = null;

    public static HybridTypeNew valueOf(String r1) {
        return (HybridTypeNew) a.a(HybridTypeNew.class, r1);
    }

    public static HybridTypeNew[] values() {
        return (HybridTypeNew[]) a.clone();
    }

    static {
        HybridTypeNew r0 = new HybridTypeNew("H5", 0);
        H5 = r0;
        HybridTypeNew r1 = new HybridTypeNew("Lynx", 1);
        Lynx = r1;
        a = new HybridTypeNew[]{r0, r1};
    }

    public HybridTypeNew(String r1, int r10) {
        super(r1, r10);
    }
}
