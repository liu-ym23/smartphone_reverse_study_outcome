package com.obric.oui.window.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/window/bean/PageGridConfig;", "", "gridMode", "", "pageColumns", "Lcom/obric/oui/window/bean/PageColumns;", "pageGutter", "Lcom/obric/oui/window/bean/PageGutter;", "pageMargin", "Lcom/obric/oui/window/bean/PageMargin;", "(Ljava/lang/String;Lcom/obric/oui/window/bean/PageColumns;Lcom/obric/oui/window/bean/PageGutter;Lcom/obric/oui/window/bean/PageMargin;)V", "getGridMode", "()Ljava/lang/String;", "getPageColumns", "()Lcom/obric/oui/window/bean/PageColumns;", "getPageGutter", "()Lcom/obric/oui/window/bean/PageGutter;", "getPageMargin", "()Lcom/obric/oui/window/bean/PageMargin;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f14892b;
    private final d c;
    private final e d;

    public c(String r2, b r3, d r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "gridMode");
        Intrinsics.checkNotNullParameter(r3, "pageColumns");
        Intrinsics.checkNotNullParameter(r4, "pageGutter");
        Intrinsics.checkNotNullParameter(r5, "pageMargin");
        this.f14891a = r2;
        this.f14892b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final String a() {
        return this.f14891a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14891a, r6.f14891a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14892b, r6.f14892b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f14891a.hashCode() * 31) + this.f14892b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "PageGridConfig(gridMode=" + this.f14891a + ", pageColumns=" + this.f14892b + ", pageGutter=" + this.c + ", pageMargin=" + this.d + ')';
    }
}
