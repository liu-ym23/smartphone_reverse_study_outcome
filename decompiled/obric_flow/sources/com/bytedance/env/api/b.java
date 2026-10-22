package com.bytedance.env.api;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/env/api/b;", "", "Lcom/bytedance/env/api/EnvType;", "a", "Lcom/bytedance/env/api/EnvType;", "()Lcom/bytedance/env/api/EnvType;", "setEnv", "(Lcom/bytedance/env/api/EnvType;)V", "env", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setLane", "(Ljava/lang/String;)V", "lane", "", "c", "Z", "getEnabledBOE2", "()Z", "setEnabledBOE2", "(Z)V", "enabledBOE2", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("env")
    private EnvType f4193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("lane")
    private String f4194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("enabledBOE2")
    private boolean f4195c;
    public final transient HashMap d;

    public b() {
        this(null, null, 15);
    }

    public final EnvType a() {
        return this.f4193a;
    }

    public final String b() {
        return this.f4194b;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof b) == true) goto L5;
        Object r10 = null;
    L6:
        b r11 = (b) r10;
        if (r11 == null) goto L25;
        EnvType r12 = this.f4193a;
        if (r12 == EnvType.f4190a) goto L21;
        if (r12 == EnvType.f4191b) goto L21;
        if (r12 == r11.f4193a) goto L15;
    L19:
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4194b, r11.f4194b) == false) goto L19;
        if (this.f4195c != r11.f4195c) goto L19;
        return true;
    L21:
        if (r12 != r11.f4193a) goto L23;
        return true;
    L23:
        return false;
    L25:
        return super.equals(r5);
    L5:
        r10 = r5;
        goto L6
    }

    public final String toString() {
        return "EnvConfig(env=" + this.f4193a + ", lane=" + this.f4194b + ", enabledBOE2=" + this.f4195c + ", headers=" + this.d + ")";
    }

    public b(EnvType r5, String r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r5 = EnvType.f4190a;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = "prod";
    L8:
        HashMap r12 = new HashMap();
        this.f4193a = r5;
        this.f4194b = r10;
        this.f4195c = false;
        this.d = r12;
    }
}
