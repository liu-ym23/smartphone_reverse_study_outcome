package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Property;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalManifest;", "Lcom/bytedance/ee/util/io/NonProguard;", "app", "Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;", "env", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "internal", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", "system", "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;)V", "getApp", "()Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;", "getEnv", "()Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "getInternal", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", "getSystem", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$GlobalManifest implements NonProguard {
    private final IApp$Property app;
    private final IEnv$Property env;
    private final IManifest$GlobalInternalProperty internal;
    private final ISystem$Property system;

    public static /* synthetic */ IManifest$GlobalManifest copy$default(IManifest$GlobalManifest r0, IApp$Property r1, IEnv$Property r2, IManifest$GlobalInternalProperty r3, ISystem$Property r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.app;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.env;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.internal;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.system;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final IApp$Property component1() {
        return this.app;
    }

    public final IEnv$Property component2() {
        return this.env;
    }

    public final IManifest$GlobalInternalProperty component3() {
        return this.internal;
    }

    public final ISystem$Property component4() {
        return this.system;
    }

    public final IManifest$GlobalManifest copy(IApp$Property r2, IEnv$Property r3, IManifest$GlobalInternalProperty r4, ISystem$Property r5) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "env");
        Intrinsics.checkNotNullParameter(r4, "internal");
        Intrinsics.checkNotNullParameter(r5, "system");
        return new IManifest$GlobalManifest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IManifest$GlobalManifest) == true) goto L8;
        return false;
    L8:
        IManifest$GlobalManifest r6 = (IManifest$GlobalManifest) r5;
        if (Intrinsics.areEqual(this.app, r6.app) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.env, r6.env) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.internal, r6.internal) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.system, r6.system) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.app.hashCode() * 31) + this.env.hashCode()) * 31) + this.internal.hashCode()) * 31) + this.system.hashCode();
    }

    public String toString() {
        return "GlobalManifest(app=" + this.app + ", env=" + this.env + ", internal=" + this.internal + ", system=" + this.system + ')';
    }

    public final IApp$Property getApp() {
        return this.app;
    }

    public final IEnv$Property getEnv() {
        return this.env;
    }

    public final IManifest$GlobalInternalProperty getInternal() {
        return this.internal;
    }

    public final ISystem$Property getSystem() {
        return this.system;
    }

    public IManifest$GlobalManifest(IApp$Property r2, IEnv$Property r3, IManifest$GlobalInternalProperty r4, ISystem$Property r5) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "env");
        Intrinsics.checkNotNullParameter(r4, "internal");
        Intrinsics.checkNotNullParameter(r5, "system");
        this.app = r2;
        this.env = r3;
        this.internal = r4;
        this.system = r5;
    }
}
