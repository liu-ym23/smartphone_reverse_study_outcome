package com.bytedance.ai.bridge.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/service/PermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "REJECTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionState extends Enum<PermissionState> {
    public static final PermissionState DENIED = null;
    public static final PermissionState GRANTED = null;
    public static final PermissionState REJECTED = null;
    public static final /* synthetic */ PermissionState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PermissionState> getEntries() {
        return b;
    }

    static {
        PermissionState r0 = new PermissionState("GRANTED", 0);
        GRANTED = r0;
        PermissionState r1 = new PermissionState("DENIED", 1);
        DENIED = r1;
        PermissionState r10 = new PermissionState("REJECTED", 2);
        REJECTED = r10;
        PermissionState[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static PermissionState[] values() {
        return (PermissionState[]) a.clone();
    }

    public static PermissionState valueOf(String r1) {
        return (PermissionState) a.a(PermissionState.class, r1);
    }

    public PermissionState(String r1, int r10) {
        super(r1, r10);
    }
}
