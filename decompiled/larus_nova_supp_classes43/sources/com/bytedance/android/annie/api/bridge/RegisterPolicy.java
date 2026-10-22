package com.bytedance.android.annie.api.bridge;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/api/bridge/RegisterPolicy;", "", "DEFAULT", "CACHEABLE", "SPECIFIED", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum RegisterPolicy extends Enum<RegisterPolicy> {
    public static final RegisterPolicy CACHEABLE = null;
    public static final RegisterPolicy DEFAULT = null;
    public static final RegisterPolicy SPECIFIED = null;
    public static final /* synthetic */ RegisterPolicy[] a = null;

    public static RegisterPolicy valueOf(String r1) {
        return (RegisterPolicy) a.a(RegisterPolicy.class, r1);
    }

    public static RegisterPolicy[] values() {
        return (RegisterPolicy[]) a.clone();
    }

    static {
        RegisterPolicy r0 = new RegisterPolicy("DEFAULT", 0);
        DEFAULT = r0;
        RegisterPolicy r1 = new RegisterPolicy("CACHEABLE", 1);
        CACHEABLE = r1;
        RegisterPolicy r10 = new RegisterPolicy("SPECIFIED", 2);
        SPECIFIED = r10;
        a = new RegisterPolicy[]{r0, r1, r10};
    }

    public RegisterPolicy(String r1, int r10) {
        super(r1, r10);
    }
}
