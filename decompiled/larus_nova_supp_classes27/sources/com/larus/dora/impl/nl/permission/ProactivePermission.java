package com.larus.dora.impl.nl.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/nl/permission/ProactivePermission;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFICATION_LISTENER", "POST_NOTIFICATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactivePermission extends Enum<ProactivePermission> {
    public static final ProactivePermission NOTIFICATION_LISTENER = null;
    public static final ProactivePermission POST_NOTIFICATION = null;
    public static final /* synthetic */ ProactivePermission[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ProactivePermission> getEntries() {
        return b;
    }

    static {
        ProactivePermission r0 = new ProactivePermission("NOTIFICATION_LISTENER", 0);
        NOTIFICATION_LISTENER = r0;
        ProactivePermission r1 = new ProactivePermission("POST_NOTIFICATION", 1);
        POST_NOTIFICATION = r1;
        ProactivePermission[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ProactivePermission[] values() {
        return (ProactivePermission[]) a.clone();
    }

    public static ProactivePermission valueOf(String r1) {
        return (ProactivePermission) a.a(ProactivePermission.class, r1);
    }

    public ProactivePermission(String r1, int r2) {
        super(r1, r2);
    }
}
