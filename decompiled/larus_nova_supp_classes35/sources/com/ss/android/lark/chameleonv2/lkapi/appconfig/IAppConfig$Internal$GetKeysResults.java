package com.ss.android.lark.chameleonv2.lkapi.appconfig;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J9\u0010\u000f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/appconfig/IAppConfig$Internal$GetKeysResults;", "Lcom/bytedance/ee/util/io/NonProguard;", "settings", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "userId", "<init>", "(Ljava/util/HashMap;Ljava/lang/String;)V", "getSettings", "()Ljava/util/HashMap;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IAppConfig$Internal$GetKeysResults implements NonProguard {
    private final HashMap<String, String> settings;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IAppConfig$Internal$GetKeysResults copy$default(IAppConfig$Internal$GetKeysResults r0, HashMap r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.settings;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.userId;
    L9:
        return r0.copy(r1, r2);
    }

    public final HashMap<String, String> component1() {
        return this.settings;
    }

    public final String component2() {
        return this.userId;
    }

    public final IAppConfig$Internal$GetKeysResults copy(HashMap<String, String> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "settings");
        Intrinsics.checkNotNullParameter(r3, "userId");
        return new IAppConfig$Internal$GetKeysResults(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IAppConfig$Internal$GetKeysResults) == true) goto L8;
        return false;
    L8:
        IAppConfig$Internal$GetKeysResults r6 = (IAppConfig$Internal$GetKeysResults) r5;
        if (Intrinsics.areEqual(this.settings, r6.settings) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.settings.hashCode() * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "GetKeysResults(settings=" + this.settings + ", userId=" + this.userId + ')';
    }

    public final HashMap<String, String> getSettings() {
        return this.settings;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IAppConfig$Internal$GetKeysResults(HashMap<String, String> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "settings");
        Intrinsics.checkNotNullParameter(r3, "userId");
        this.settings = r2;
        this.userId = r3;
    }
}
