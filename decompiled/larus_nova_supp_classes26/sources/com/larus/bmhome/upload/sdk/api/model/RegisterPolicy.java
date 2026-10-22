package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/RegisterPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceEnable", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RegisterPolicy extends Enum<RegisterPolicy> {
    public static final RegisterPolicy Auto = null;
    public static final RegisterPolicy Disabled = null;
    public static final RegisterPolicy ForceEnable = null;
    public static final /* synthetic */ RegisterPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RegisterPolicy> getEntries() {
        return b;
    }

    static {
        RegisterPolicy r0 = new RegisterPolicy("Auto", 0);
        Auto = r0;
        RegisterPolicy r1 = new RegisterPolicy("ForceEnable", 1);
        ForceEnable = r1;
        RegisterPolicy r3 = new RegisterPolicy("Disabled", 2);
        Disabled = r3;
        RegisterPolicy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static RegisterPolicy[] values() {
        return (RegisterPolicy[]) a.clone();
    }

    public static RegisterPolicy valueOf(String r1) {
        return (RegisterPolicy) a.a(RegisterPolicy.class, r1);
    }

    public RegisterPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
