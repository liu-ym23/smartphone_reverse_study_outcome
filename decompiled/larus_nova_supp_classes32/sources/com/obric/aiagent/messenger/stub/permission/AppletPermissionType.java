package com.obric.aiagent.messenger.stub.permission;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/messenger/stub/permission/AppletPermissionType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Location", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPermissionType extends Enum<AppletPermissionType> {
    public static final AppletPermissionType Location = null;
    public static final /* synthetic */ AppletPermissionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public AppletPermissionType() {
        super("Location", 0);
        this.value = "Location";
    }

    public static EnumEntries<AppletPermissionType> getEntries() {
        return b;
    }

    static {
        AppletPermissionType r0 = new AppletPermissionType();
        Location = r0;
        AppletPermissionType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public static AppletPermissionType[] values() {
        return (AppletPermissionType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AppletPermissionType valueOf(String r1) {
        return (AppletPermissionType) r27.a.a(AppletPermissionType.class, r1);
    }
}
