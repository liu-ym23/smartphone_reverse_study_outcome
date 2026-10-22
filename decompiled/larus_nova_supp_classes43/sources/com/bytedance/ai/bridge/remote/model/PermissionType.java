package com.bytedance.ai.bridge.remote.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PermissionType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ONE_TICKET_SCOPE", "RUNNING_TIME_SCOPE", "LONG_TERM_TICKET_SCOPE", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionType extends Enum<PermissionType> {
    public static final a Companion = null;
    public static final PermissionType LONG_TERM_TICKET_SCOPE = null;
    public static final PermissionType ONE_TICKET_SCOPE = null;
    public static final PermissionType RUNNING_TIME_SCOPE = null;
    public static final PermissionType UNKNOWN = null;
    public static final /* synthetic */ PermissionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PermissionType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.bridge.remote.model.PermissionType$a] */
    static {
        PermissionType r0 = new PermissionType("UNKNOWN", 0);
        UNKNOWN = r0;
        PermissionType r1 = new PermissionType("ONE_TICKET_SCOPE", 1);
        ONE_TICKET_SCOPE = r1;
        PermissionType r10 = new PermissionType("RUNNING_TIME_SCOPE", 2);
        RUNNING_TIME_SCOPE = r10;
        PermissionType r11 = new PermissionType("LONG_TERM_TICKET_SCOPE", 3);
        LONG_TERM_TICKET_SCOPE = r11;
        PermissionType[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static PermissionType[] values() {
        return (PermissionType[]) a.clone();
    }

    public static PermissionType valueOf(String r1) {
        return (PermissionType) r27.a.a(PermissionType.class, r1);
    }

    public PermissionType(String r1, int r10) {
        super(r1, r10);
    }
}
