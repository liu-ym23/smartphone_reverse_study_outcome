package com.obric.assistant.provider;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/provider/AppPermissionOnAutoActionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNAVAILABLE", "AVAILABLE_ALWAYS", "AVAILABLE_FOR_ONCE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppPermissionOnAutoActionStatus extends Enum<AppPermissionOnAutoActionStatus> {
    public static final AppPermissionOnAutoActionStatus AVAILABLE_ALWAYS = null;
    public static final AppPermissionOnAutoActionStatus AVAILABLE_FOR_ONCE = null;
    public static final AppPermissionOnAutoActionStatus UNAVAILABLE = null;
    public static final /* synthetic */ AppPermissionOnAutoActionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AppPermissionOnAutoActionStatus> getEntries() {
        return b;
    }

    static {
        AppPermissionOnAutoActionStatus r0 = new AppPermissionOnAutoActionStatus("UNAVAILABLE", 0, 0);
        UNAVAILABLE = r0;
        AppPermissionOnAutoActionStatus r1 = new AppPermissionOnAutoActionStatus("AVAILABLE_ALWAYS", 1, 1);
        AVAILABLE_ALWAYS = r1;
        AppPermissionOnAutoActionStatus r3 = new AppPermissionOnAutoActionStatus("AVAILABLE_FOR_ONCE", 2, 2);
        AVAILABLE_FOR_ONCE = r3;
        AppPermissionOnAutoActionStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AppPermissionOnAutoActionStatus[] values() {
        return (AppPermissionOnAutoActionStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppPermissionOnAutoActionStatus valueOf(String r1) {
        return (AppPermissionOnAutoActionStatus) r27.a.a(AppPermissionOnAutoActionStatus.class, r1);
    }

    public AppPermissionOnAutoActionStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
