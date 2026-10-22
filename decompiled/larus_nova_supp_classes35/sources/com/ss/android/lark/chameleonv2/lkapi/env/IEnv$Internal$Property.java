package com.ss.android.lark.chameleonv2.lkapi.env;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "isLarkAPITestEnabled", BuildConfig.FLAVOR, "reportAPIStatInterval", BuildConfig.FLAVOR, "<init>", "(ZI)V", "()Z", "getReportAPIStatInterval", "()I", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IEnv$Internal$Property implements NonProguard {
    private final boolean isLarkAPITestEnabled;
    private final int reportAPIStatInterval;

    public static /* synthetic */ IEnv$Internal$Property copy$default(IEnv$Internal$Property r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isLarkAPITestEnabled;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.reportAPIStatInterval;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isLarkAPITestEnabled;
    }

    public final int component2() {
        return this.reportAPIStatInterval;
    }

    public final IEnv$Internal$Property copy(boolean r2, int r3) {
        return new IEnv$Internal$Property(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IEnv$Internal$Property) == true) goto L8;
        return false;
    L8:
        IEnv$Internal$Property r6 = (IEnv$Internal$Property) r5;
        if (this.isLarkAPITestEnabled == r6.isLarkAPITestEnabled) goto L12;
        return false;
    L12:
        if (this.reportAPIStatInterval == r6.reportAPIStatInterval) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isLarkAPITestEnabled == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.reportAPIStatInterval;
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "Property(isLarkAPITestEnabled=" + this.isLarkAPITestEnabled + ", reportAPIStatInterval=" + this.reportAPIStatInterval + ')';
    }

    public final int getReportAPIStatInterval() {
        return this.reportAPIStatInterval;
    }

    @JSONField(name = "isLarkAPITestEnabled")
    public final boolean isLarkAPITestEnabled() {
        return this.isLarkAPITestEnabled;
    }

    public IEnv$Internal$Property(boolean r1, int r2) {
        this.isLarkAPITestEnabled = r1;
        this.reportAPIStatInterval = r2;
    }
}
