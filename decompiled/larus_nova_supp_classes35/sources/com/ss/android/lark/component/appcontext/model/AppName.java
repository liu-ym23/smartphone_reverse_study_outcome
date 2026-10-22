package com.ss.android.lark.component.appcontext.model;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/AppName;", BuildConfig.FLAVOR, "rawName", BuildConfig.FLAVOR, "lowerCaseName", "camelCaseName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRawName", "()Ljava/lang/String;", "getLowerCaseName", "getCamelCaseName", "Lark", "Mempope", "OfficeSDK", "isLark", BuildConfig.FLAVOR, "isMempope", "isOfficeSDK", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppName extends Enum<AppName> {
    public static final AppName Lark = null;
    public static final AppName Mempope = null;
    public static final AppName OfficeSDK = null;
    public static final /* synthetic */ AppName[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String camelCaseName;
    private final String lowerCaseName;
    private final String rawName;

    public static EnumEntries<AppName> getEntries() {
        return b;
    }

    static {
        AppName r6 = new AppName("Lark", 0, "Lark", "lark", "Lark");
        Lark = r6;
        AppName r0 = new AppName("Mempope", 1, "Mempope", "mempope", "MemPope");
        Mempope = r0;
        AppName r1 = new AppName("OfficeSDK", 2, "OfficeSDK", "officesdk", "OfficeSDK");
        OfficeSDK = r1;
        AppName[] r2 = {r6, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AppName[] values() {
        return (AppName[]) a.clone();
    }

    public final boolean isLark() {
        if (this != Lark) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMempope() {
        if (this != Mempope) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOfficeSDK() {
        if (this != OfficeSDK) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getCamelCaseName() {
        return this.camelCaseName;
    }

    public final String getLowerCaseName() {
        return this.lowerCaseName;
    }

    public final String getRawName() {
        return this.rawName;
    }

    public static AppName valueOf(String r1) {
        return (AppName) a.a(AppName.class, r1);
    }

    public AppName(String r1, int r2, String r3, String r4, String r5) {
        super(r1, r2);
        this.rawName = r3;
        this.lowerCaseName = r4;
        this.camelCaseName = r5;
    }
}
