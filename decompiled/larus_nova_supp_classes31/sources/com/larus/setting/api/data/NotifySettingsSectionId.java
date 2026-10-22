package com.larus.setting.api.data;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/setting/api/data/NotifySettingsSectionId;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_CLOSED", "APP_OPEN", "NOTIFY_TYPE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum NotifySettingsSectionId extends Enum<NotifySettingsSectionId> {
    public static final NotifySettingsSectionId APP_CLOSED = null;
    public static final NotifySettingsSectionId APP_OPEN = null;
    public static final NotifySettingsSectionId NOTIFY_TYPE = null;
    public static final /* synthetic */ NotifySettingsSectionId[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<NotifySettingsSectionId> getEntries() {
        return b;
    }

    static {
        NotifySettingsSectionId r0 = new NotifySettingsSectionId("APP_CLOSED", 0, "app_closed");
        APP_CLOSED = r0;
        NotifySettingsSectionId r1 = new NotifySettingsSectionId("APP_OPEN", 1, "app_open");
        APP_OPEN = r1;
        NotifySettingsSectionId r2 = new NotifySettingsSectionId("NOTIFY_TYPE", 2, "notify_type");
        NOTIFY_TYPE = r2;
        NotifySettingsSectionId[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static NotifySettingsSectionId[] values() {
        return (NotifySettingsSectionId[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NotifySettingsSectionId valueOf(String r1) {
        return (NotifySettingsSectionId) a.a(NotifySettingsSectionId.class, r1);
    }

    public NotifySettingsSectionId(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
