package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/FallbackPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Enabled", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FallbackPolicy extends Enum<FallbackPolicy> {
    public static final FallbackPolicy Disabled = null;
    public static final FallbackPolicy Enabled = null;
    public static final /* synthetic */ FallbackPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FallbackPolicy> getEntries() {
        return b;
    }

    static {
        FallbackPolicy r0 = new FallbackPolicy("Enabled", 0);
        Enabled = r0;
        FallbackPolicy r1 = new FallbackPolicy("Disabled", 1);
        Disabled = r1;
        FallbackPolicy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FallbackPolicy[] values() {
        return (FallbackPolicy[]) a.clone();
    }

    public static FallbackPolicy valueOf(String r1) {
        return (FallbackPolicy) a.a(FallbackPolicy.class, r1);
    }

    public FallbackPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
