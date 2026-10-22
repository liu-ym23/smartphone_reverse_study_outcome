package com.obric.memorydata.memory.ui.detail;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/SourceActivityTarget;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "className", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getClassName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10846b;

    public ad(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "className");
        this.f10845a = r2;
        this.f10846b = r3;
    }

    public final String a() {
        return this.f10845a;
    }

    public final String b() {
        return this.f10846b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ad.class) == true) goto L8;
        return false;
    L8:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10845a, r6.f10845a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10846b, r6.f10846b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10845a.hashCode() * 31) + this.f10846b.hashCode();
    }

    public String toString() {
        return "SourceActivityTarget(packageName=" + this.f10845a + ", className=" + this.f10846b + ')';
    }
}
