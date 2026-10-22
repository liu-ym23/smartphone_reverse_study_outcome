package com.ss.android.lark.chameleonv2.lkapi.env;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$CustomSchema;", "Lcom/bytedance/ee/util/io/NonProguard;", "host", BuildConfig.FLAVOR, "isDefault", BuildConfig.FLAVOR, "schema", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getHost", "()Ljava/lang/String;", "()Z", "getSchema", "component1", "component2", "component3", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IEnv$CustomSchema implements NonProguard {
    private final String host;
    private final boolean isDefault;
    private final String schema;

    public static /* synthetic */ IEnv$CustomSchema copy$default(IEnv$CustomSchema r0, String r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.host;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isDefault;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.schema;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.host;
    }

    public final boolean component2() {
        return this.isDefault;
    }

    public final String component3() {
        return this.schema;
    }

    public final IEnv$CustomSchema copy(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r4, "schema");
        return new IEnv$CustomSchema(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IEnv$CustomSchema) == true) goto L8;
        return false;
    L8:
        IEnv$CustomSchema r6 = (IEnv$CustomSchema) r5;
        if (Intrinsics.areEqual(this.host, r6.host) == true) goto L12;
        return false;
    L12:
        if (this.isDefault == r6.isDefault) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.host.hashCode() * 31;
        if (this.isDefault == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.schema.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "CustomSchema(host=" + this.host + ", isDefault=" + this.isDefault + ", schema=" + this.schema + ')';
    }

    public final String getHost() {
        return this.host;
    }

    public final String getSchema() {
        return this.schema;
    }

    @JSONField(name = "isDefault")
    public final boolean isDefault() {
        return this.isDefault;
    }

    public IEnv$CustomSchema(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r4, "schema");
        this.host = r2;
        this.isDefault = r3;
        this.schema = r4;
    }
}
