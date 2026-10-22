package com.bytedance.awemeopen.share.serviceapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/share/serviceapi/AoShareResult;", "", "Success", "Fail", "Cancel", "ao_share_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum AoShareResult extends Enum<AoShareResult> {
    public static final AoShareResult Cancel = null;
    public static final AoShareResult Fail = null;
    public static final AoShareResult Success = null;
    public static final /* synthetic */ AoShareResult[] a = null;

    public static AoShareResult valueOf(String r1) {
        return (AoShareResult) a.a(AoShareResult.class, r1);
    }

    public static AoShareResult[] values() {
        return (AoShareResult[]) a.clone();
    }

    static {
        AoShareResult r0 = new AoShareResult("Success", 0);
        Success = r0;
        AoShareResult r1 = new AoShareResult("Fail", 1);
        Fail = r1;
        AoShareResult r3 = new AoShareResult("Cancel", 2);
        Cancel = r3;
        a = new AoShareResult[]{r0, r1, r3};
    }

    public AoShareResult(String r1, int r2) {
        super(r1, r2);
    }
}
