package com.obric.capabilitykit;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/ActionType;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final enum m extends Enum<m> {
    public static final a b = null;
    public static final m c = null;
    public static final m d = null;
    public static final /* synthetic */ m[] e = null;
    private final String a;

    static {
        m r0 = new m("INDEX", 0, "index");
        c = r0;
        m r1 = new m("DELETE", 1, "delete");
        d = r1;
        e = new m[]{r0, r1};
        b = new a();
    }

    public m(String r1, int r2, String r3) {
        super(r1, r2);
        this.a = r3;
    }

    public static m valueOf(String r1) {
        return (m) a.a(m.class, r1);
    }

    public static m[] values() {
        return (m[]) e.clone();
    }

    public final String b() {
        return this.a;
    }
}
