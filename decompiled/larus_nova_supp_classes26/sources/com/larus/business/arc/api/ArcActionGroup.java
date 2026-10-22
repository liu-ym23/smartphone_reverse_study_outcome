package com.larus.business.arc.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/business/arc/api/ArcActionGroup;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "BASE", "SETTINGS", "KEVA", "ACCOUNT", "TELEMETRY", "NETWORK", "CHAT", "AUDIO", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArcActionGroup extends Enum<ArcActionGroup> {
    public static final ArcActionGroup ACCOUNT = null;
    public static final ArcActionGroup AUDIO = null;
    public static final ArcActionGroup BASE = null;
    public static final ArcActionGroup CHAT = null;
    public static final ArcActionGroup KEVA = null;
    public static final ArcActionGroup NETWORK = null;
    public static final ArcActionGroup SETTINGS = null;
    public static final ArcActionGroup TELEMETRY = null;
    public static final /* synthetic */ ArcActionGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String id;

    public static EnumEntries<ArcActionGroup> getEntries() {
        return b;
    }

    static {
        ArcActionGroup r0 = new ArcActionGroup("BASE", 0, "base");
        BASE = r0;
        ArcActionGroup r1 = new ArcActionGroup("SETTINGS", 1, "settings");
        SETTINGS = r1;
        ArcActionGroup r2 = new ArcActionGroup("KEVA", 2, "keva");
        KEVA = r2;
        ArcActionGroup r4 = new ArcActionGroup("ACCOUNT", 3, "account");
        ACCOUNT = r4;
        ArcActionGroup r6 = new ArcActionGroup("TELEMETRY", 4, "telemetry");
        TELEMETRY = r6;
        ArcActionGroup r8 = new ArcActionGroup("NETWORK", 5, "network");
        NETWORK = r8;
        ArcActionGroup r10 = new ArcActionGroup("CHAT", 6, "chat");
        CHAT = r10;
        ArcActionGroup r12 = new ArcActionGroup("AUDIO", 7, "audio");
        AUDIO = r12;
        ArcActionGroup[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ArcActionGroup[] values() {
        return (ArcActionGroup[]) a.clone();
    }

    public final String getId() {
        return this.id;
    }

    public static ArcActionGroup valueOf(String r1) {
        return (ArcActionGroup) r27.a.a(ArcActionGroup.class, r1);
    }

    public ArcActionGroup(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
