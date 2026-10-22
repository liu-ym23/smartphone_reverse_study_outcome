package com.obric.capabilitykit.common;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ConditionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum s extends Enum<s> {
    public static final s b = null;
    public static final s c = null;
    public static final /* synthetic */ s[] d = null;
    private final String a;

    static {
        s r0 = new s("TIME", 0, "time");
        b = r0;
        s r1 = new s("LOCATION", 1, "location");
        c = r1;
        d = new s[]{r0, r1};
    }

    public s(String r1, int r2, String r3) {
        super(r1, r2);
        this.a = r3;
    }

    public static s valueOf(String r1) {
        return (s) a.a(s.class, r1);
    }

    public static s[] values() {
        return (s[]) d.clone();
    }

    public final String b() {
        return this.a;
    }
}
