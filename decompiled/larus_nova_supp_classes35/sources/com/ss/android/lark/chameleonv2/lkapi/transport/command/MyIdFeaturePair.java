package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "Lcom/bytedance/ee/util/io/NonProguard;", Keys.API_RETURN_KEY_APP_ID, BuildConfig.FLAVOR, "feature", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getAppId", "()Ljava/lang/String;", "getFeature", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyIdFeaturePair implements NonProguard {
    private final String appId;
    private final Integer feature;

    public static /* synthetic */ MyIdFeaturePair copy$default(MyIdFeaturePair r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.feature;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.appId;
    }

    public final Integer component2() {
        return this.feature;
    }

    public final MyIdFeaturePair copy(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_APP_ID);
        return new MyIdFeaturePair(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyIdFeaturePair) == true) goto L8;
        return false;
    L8:
        MyIdFeaturePair r6 = (MyIdFeaturePair) r5;
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feature, r6.feature) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.appId.hashCode() * 31;
        Integer r1 = this.feature;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MyIdFeaturePair(appId=" + this.appId + ", feature=" + this.feature + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Integer getFeature() {
        return this.feature;
    }

    public MyIdFeaturePair(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_APP_ID);
        this.appId = r2;
        this.feature = r3;
    }
}
