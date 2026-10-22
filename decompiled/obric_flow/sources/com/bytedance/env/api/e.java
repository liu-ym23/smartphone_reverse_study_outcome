package com.bytedance.env.api;

import ai.j0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/env/api/e;", "", "Lcom/bytedance/env/api/AccessKeyType;", "a", "Lcom/bytedance/env/api/AccessKeyType;", "()Lcom/bytedance/env/api/AccessKeyType;", "setAccessKeyType", "(Lcom/bytedance/env/api/AccessKeyType;)V", "accessKeyType", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setEnvLane", "(Ljava/lang/String;)V", "envLane", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("accessKeyType")
    private AccessKeyType f4197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("envLane")
    private String f4198b;

    public e() {
        this(0);
    }

    public final AccessKeyType a() {
        return this.f4197a;
    }

    public final String b() {
        return this.f4198b;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e) == true) goto L5;
        Object r10 = null;
    L6:
        e r11 = (e) r10;
        if (r11 == null) goto L17;
        if (this.f4197a == r11.f4197a) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f4198b, r11.f4198b) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return super.equals(r5);
    L5:
        r10 = r5;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GeckoConfig(accessKeyType=");
        r5.append(this.f4197a);
        r5.append(", envLane=");
        return j0.q(r5, this.f4198b, ")");
    }

    public e(int r5) {
        this.f4197a = AccessKeyType.f4187a;
        this.f4198b = "";
    }
}
