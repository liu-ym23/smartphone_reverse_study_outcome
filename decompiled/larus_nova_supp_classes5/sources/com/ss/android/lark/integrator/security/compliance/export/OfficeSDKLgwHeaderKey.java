package com.ss.android.lark.integrator.security.compliance.export;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/export/OfficeSDKLgwHeaderKey;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "UNKNOWN", "LOCALE", "APP_VERSION", "SEC_TOKEN", "TERMINAL_TYPE", "USER_ID", "DEVICE_ID", "INSTALL_ID", "APP_ID", "OS_VERSION", "DEVICE_TYPE", "OS_TYPE", "APP_CHANNEL", "DEVICE_BRAND", "APP_VERSION_EXT", "androidFixedValue", "getAndroidFixedValue", "Companion", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSDKLgwHeaderKey extends Enum<OfficeSDKLgwHeaderKey> {
    public static final OfficeSDKLgwHeaderKey APP_CHANNEL = null;
    public static final OfficeSDKLgwHeaderKey APP_ID = null;
    public static final OfficeSDKLgwHeaderKey APP_VERSION = null;
    public static final OfficeSDKLgwHeaderKey APP_VERSION_EXT = null;
    public static final a Companion = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_BRAND = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_ID = null;
    public static final OfficeSDKLgwHeaderKey DEVICE_TYPE = null;
    public static final OfficeSDKLgwHeaderKey INSTALL_ID = null;
    public static final OfficeSDKLgwHeaderKey LOCALE = null;
    public static final OfficeSDKLgwHeaderKey OS_TYPE = null;
    public static final OfficeSDKLgwHeaderKey OS_VERSION = null;
    public static final OfficeSDKLgwHeaderKey SEC_TOKEN = null;
    public static final OfficeSDKLgwHeaderKey TERMINAL_TYPE = null;
    public static final OfficeSDKLgwHeaderKey UNKNOWN = null;
    public static final OfficeSDKLgwHeaderKey USER_ID = null;
    public static final Map<OfficeSDKLgwHeaderKey, String> a = null;
    public static final /* synthetic */ OfficeSDKLgwHeaderKey[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final String rawValue;

    public static EnumEntries<OfficeSDKLgwHeaderKey> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.ss.android.lark.integrator.security.compliance.export.OfficeSDKLgwHeaderKey$a] */
    static {
        OfficeSDKLgwHeaderKey r0 = new OfficeSDKLgwHeaderKey("UNKNOWN", 0, "");
        UNKNOWN = r0;
        OfficeSDKLgwHeaderKey r1 = new OfficeSDKLgwHeaderKey("LOCALE", 1, "x-lgw-locale");
        LOCALE = r1;
        OfficeSDKLgwHeaderKey r3 = new OfficeSDKLgwHeaderKey("APP_VERSION", 2, "x-lgw-app-version");
        APP_VERSION = r3;
        OfficeSDKLgwHeaderKey r5 = new OfficeSDKLgwHeaderKey("SEC_TOKEN", 3, "x-lgw-sec-token");
        SEC_TOKEN = r5;
        OfficeSDKLgwHeaderKey r7 = new OfficeSDKLgwHeaderKey("TERMINAL_TYPE", 4, "x-lgw-terminal-type");
        TERMINAL_TYPE = r7;
        OfficeSDKLgwHeaderKey r9 = new OfficeSDKLgwHeaderKey("USER_ID", 5, "x-lgw-user-id");
        USER_ID = r9;
        OfficeSDKLgwHeaderKey r11 = new OfficeSDKLgwHeaderKey("DEVICE_ID", 6, "x-lgw-device-id");
        DEVICE_ID = r11;
        OfficeSDKLgwHeaderKey r13 = new OfficeSDKLgwHeaderKey("INSTALL_ID", 7, "x-lgw-install-id");
        INSTALL_ID = r13;
        OfficeSDKLgwHeaderKey r12 = new OfficeSDKLgwHeaderKey("APP_ID", 8, "x-lgw-app-id");
        APP_ID = r12;
        OfficeSDKLgwHeaderKey r10 = new OfficeSDKLgwHeaderKey("OS_VERSION", 9, "x-lgw-os-version");
        OS_VERSION = r10;
        OfficeSDKLgwHeaderKey r8 = new OfficeSDKLgwHeaderKey("DEVICE_TYPE", 10, "x-lgw-device-type");
        DEVICE_TYPE = r8;
        OfficeSDKLgwHeaderKey r6 = new OfficeSDKLgwHeaderKey("OS_TYPE", 11, "x-lgw-os-type");
        OS_TYPE = r6;
        OfficeSDKLgwHeaderKey r4 = new OfficeSDKLgwHeaderKey("APP_CHANNEL", 12, "x-lgw-app-channel");
        APP_CHANNEL = r4;
        OfficeSDKLgwHeaderKey r2 = new OfficeSDKLgwHeaderKey("DEVICE_BRAND", 13, "x-lgw-device-brand");
        DEVICE_BRAND = r2;
        OfficeSDKLgwHeaderKey r14 = new OfficeSDKLgwHeaderKey("APP_VERSION_EXT", 14, "x-lgw-app-version-ext");
        APP_VERSION_EXT = r14;
        OfficeSDKLgwHeaderKey[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14};
        b = r15;
        c = EnumEntriesKt.enumEntries(r15);
        Companion = new a();
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r6, "4"), TuplesKt.to(r7, "3")});
    }

    public static OfficeSDKLgwHeaderKey[] values() {
        return (OfficeSDKLgwHeaderKey[]) b.clone();
    }

    public final String getAndroidFixedValue() {
        return a.get(this);
    }

    public static final /* synthetic */ Map access$getAndroidFixedHeaders$cp() {
        return a;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static OfficeSDKLgwHeaderKey valueOf(String r1) {
        return (OfficeSDKLgwHeaderKey) r27.a.a(OfficeSDKLgwHeaderKey.class, r1);
    }

    public OfficeSDKLgwHeaderKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.rawValue = r3;
    }
}
