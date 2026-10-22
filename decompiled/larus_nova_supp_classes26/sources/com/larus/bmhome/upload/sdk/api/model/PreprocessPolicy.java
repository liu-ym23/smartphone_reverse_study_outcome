package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/PreprocessPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "ForceEnable", "Disabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreprocessPolicy extends Enum<PreprocessPolicy> {
    public static final PreprocessPolicy Auto = null;
    public static final PreprocessPolicy Disabled = null;
    public static final PreprocessPolicy ForceEnable = null;
    public static final /* synthetic */ PreprocessPolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreprocessPolicy> getEntries() {
        return b;
    }

    static {
        PreprocessPolicy r0 = new PreprocessPolicy("Auto", 0);
        Auto = r0;
        PreprocessPolicy r1 = new PreprocessPolicy("ForceEnable", 1);
        ForceEnable = r1;
        PreprocessPolicy r3 = new PreprocessPolicy("Disabled", 2);
        Disabled = r3;
        PreprocessPolicy[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PreprocessPolicy[] values() {
        return (PreprocessPolicy[]) a.clone();
    }

    public static PreprocessPolicy valueOf(String r1) {
        return (PreprocessPolicy) a.a(PreprocessPolicy.class, r1);
    }

    public PreprocessPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
