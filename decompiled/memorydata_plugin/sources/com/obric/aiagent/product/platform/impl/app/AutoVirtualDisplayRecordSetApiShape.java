package com.obric.aiagent.product.platform.impl.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetApiShape;", "", "namespace", "", "managerClassName", "listenerClassName", "invokerClassName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getManagerClassName", "getListenerClassName", "getInvokerClassName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoVirtualDisplayRecordSetApiShape {
    private final String invokerClassName;
    private final String listenerClassName;
    private final String managerClassName;
    private final String namespace;

    public AutoVirtualDisplayRecordSetApiShape(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "namespace");
        Intrinsics.checkNotNullParameter(r3, "managerClassName");
        Intrinsics.checkNotNullParameter(r4, "listenerClassName");
        Intrinsics.checkNotNullParameter(r5, "invokerClassName");
        this.namespace = r2;
        this.managerClassName = r3;
        this.listenerClassName = r4;
        this.invokerClassName = r5;
    }

    public static /* synthetic */ AutoVirtualDisplayRecordSetApiShape copy$default(AutoVirtualDisplayRecordSetApiShape r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.namespace;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.managerClassName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.listenerClassName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.invokerClassName;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.namespace;
    }

    public final String component2() {
        return this.managerClassName;
    }

    public final String component3() {
        return this.listenerClassName;
    }

    public final String component4() {
        return this.invokerClassName;
    }

    public final AutoVirtualDisplayRecordSetApiShape copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "namespace");
        Intrinsics.checkNotNullParameter(r2, "managerClassName");
        Intrinsics.checkNotNullParameter(r3, "listenerClassName");
        Intrinsics.checkNotNullParameter(r4, "invokerClassName");
        return new AutoVirtualDisplayRecordSetApiShape(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AutoVirtualDisplayRecordSetApiShape.class) == true) goto L8;
        return false;
    L8:
        AutoVirtualDisplayRecordSetApiShape r6 = (AutoVirtualDisplayRecordSetApiShape) ZeusTransformUtils.preCheckCast(r5, AutoVirtualDisplayRecordSetApiShape.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.namespace, r6.namespace) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.managerClassName, r6.managerClassName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.listenerClassName, r6.listenerClassName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.invokerClassName, r6.invokerClassName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getInvokerClassName() {
        return this.invokerClassName;
    }

    public final String getListenerClassName() {
        return this.listenerClassName;
    }

    public final String getManagerClassName() {
        return this.managerClassName;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return (((((this.namespace.hashCode() * 31) + this.managerClassName.hashCode()) * 31) + this.listenerClassName.hashCode()) * 31) + this.invokerClassName.hashCode();
    }

    public String toString() {
        return "AutoVirtualDisplayRecordSetApiShape(namespace=" + this.namespace + ", managerClassName=" + this.managerClassName + ", listenerClassName=" + this.listenerClassName + ", invokerClassName=" + this.invokerClassName + ')';
    }
}
