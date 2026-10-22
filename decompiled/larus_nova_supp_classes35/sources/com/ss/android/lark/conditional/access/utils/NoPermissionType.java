package com.ss.android.lark.conditional.access.utils;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEVICE_OWNER", "DEVICE_STATE", "MFA", "NETWORK", "DEVICE_AUTHENTICATION", "DEVICE_OWNER_V2", "DEVICE_CREDIBILITY", "DEVICE_OS", "DEVICE_TERMINAL", "CUSTOM_DISPLAY", "OAUTH_REAUTHORIZATION", "UNKNOWN", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NoPermissionType extends Enum<NoPermissionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NoPermissionType[] $VALUES = null;
    public static final NoPermissionType CUSTOM_DISPLAY = null;
    public static final NoPermissionType DEVICE_AUTHENTICATION = null;
    public static final NoPermissionType DEVICE_CREDIBILITY = null;
    public static final NoPermissionType DEVICE_OS = null;
    public static final NoPermissionType DEVICE_OWNER = null;
    public static final NoPermissionType DEVICE_OWNER_V2 = null;
    public static final NoPermissionType DEVICE_STATE = null;
    public static final NoPermissionType DEVICE_TERMINAL = null;
    public static final NoPermissionType MFA = null;
    public static final NoPermissionType NETWORK = null;
    public static final NoPermissionType OAUTH_REAUTHORIZATION = null;
    public static final NoPermissionType UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ NoPermissionType[] $values() {
        return new NoPermissionType[]{DEVICE_OWNER, DEVICE_STATE, MFA, NETWORK, DEVICE_AUTHENTICATION, DEVICE_OWNER_V2, DEVICE_CREDIBILITY, DEVICE_OS, DEVICE_TERMINAL, CUSTOM_DISPLAY, OAUTH_REAUTHORIZATION, UNKNOWN};
    }

    public static EnumEntries<NoPermissionType> getEntries() {
        return $ENTRIES;
    }

    static {
        DEVICE_OWNER = new NoPermissionType("DEVICE_OWNER", 0, 1);
        DEVICE_STATE = new NoPermissionType("DEVICE_STATE", 1, 2);
        MFA = new NoPermissionType("MFA", 2, 3);
        NETWORK = new NoPermissionType("NETWORK", 3, 4);
        DEVICE_AUTHENTICATION = new NoPermissionType("DEVICE_AUTHENTICATION", 4, 5);
        DEVICE_OWNER_V2 = new NoPermissionType("DEVICE_OWNER_V2", 5, 6);
        DEVICE_CREDIBILITY = new NoPermissionType("DEVICE_CREDIBILITY", 6, 7);
        DEVICE_OS = new NoPermissionType("DEVICE_OS", 7, 8);
        DEVICE_TERMINAL = new NoPermissionType("DEVICE_TERMINAL", 8, 9);
        CUSTOM_DISPLAY = new NoPermissionType("CUSTOM_DISPLAY", 9, 10);
        OAUTH_REAUTHORIZATION = new NoPermissionType("OAUTH_REAUTHORIZATION", 10, 11);
        UNKNOWN = new NoPermissionType("UNKNOWN", 11, -1);
        NoPermissionType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static NoPermissionType[] values() {
        return (NoPermissionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static NoPermissionType valueOf(String r1) {
        return (NoPermissionType) r27.a.a(NoPermissionType.class, r1);
    }

    private NoPermissionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
