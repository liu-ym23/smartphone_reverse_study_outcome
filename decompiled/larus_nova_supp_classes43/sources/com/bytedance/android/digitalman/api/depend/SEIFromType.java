package com.bytedance.android.digitalman.api.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/digitalman/api/depend/SEIFromType;", "", "DHMan", "Server", "digitalman-base-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SEIFromType extends Enum<SEIFromType> {
    public static final SEIFromType DHMan = null;
    public static final SEIFromType Server = null;
    public static final /* synthetic */ SEIFromType[] a = null;

    static {
        SEIFromType r1 = new SEIFromType("DHMan", 0);
        DHMan = r1;
        SEIFromType r10 = new SEIFromType("Server", 1);
        Server = r10;
        a = new SEIFromType[]{r1, r10};
    }

    public static SEIFromType valueOf(String r1) {
        return (SEIFromType) a.a(SEIFromType.class, r1);
    }

    public static SEIFromType[] values() {
        return (SEIFromType[]) a.clone();
    }

    public SEIFromType(String r1, int r10) {
        super(r1, r10);
    }
}
