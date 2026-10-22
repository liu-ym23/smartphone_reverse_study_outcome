package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J%\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "methods", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "methodInfos", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$MethodInfo;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getMethods", "()Ljava/util/ArrayList;", "getMethodInfos", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$InternalBaseProperty implements NonProguard {
    private final HashMap<String, IManifest$MethodInfo> methodInfos;
    private final ArrayList<String> methods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IManifest$InternalBaseProperty copy$default(IManifest$InternalBaseProperty r0, ArrayList r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.methods;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.methodInfos;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<String> component1() {
        return this.methods;
    }

    public final HashMap<String, IManifest$MethodInfo> component2() {
        return this.methodInfos;
    }

    public final IManifest$InternalBaseProperty copy(ArrayList<String> r2, HashMap<String, IManifest$MethodInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "methods");
        Intrinsics.checkNotNullParameter(r3, "methodInfos");
        return new IManifest$InternalBaseProperty(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IManifest$InternalBaseProperty) == true) goto L8;
        return false;
    L8:
        IManifest$InternalBaseProperty r6 = (IManifest$InternalBaseProperty) r5;
        if (Intrinsics.areEqual(this.methods, r6.methods) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.methodInfos, r6.methodInfos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.methods.hashCode() * 31) + this.methodInfos.hashCode();
    }

    public String toString() {
        return "InternalBaseProperty(methods=" + this.methods + ", methodInfos=" + this.methodInfos + ')';
    }

    public final HashMap<String, IManifest$MethodInfo> getMethodInfos() {
        return this.methodInfos;
    }

    public final ArrayList<String> getMethods() {
        return this.methods;
    }

    public IManifest$InternalBaseProperty(ArrayList<String> r2, HashMap<String, IManifest$MethodInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "methods");
        Intrinsics.checkNotNullParameter(r3, "methodInfos");
        this.methods = r2;
        this.methodInfos = r3;
    }
}
