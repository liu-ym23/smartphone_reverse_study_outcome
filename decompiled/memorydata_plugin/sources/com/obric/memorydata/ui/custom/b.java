package com.obric.memorydata.ui.custom;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/ui/custom/ResolvedAttr;", "", ActivityLifecycle.NAME, "", "typeName", "rawType", "", "displayValue", "resolved", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getTypeName", "getRawType", "()I", "getDisplayValue", "getResolved", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13002b;
    private final int c;
    private final String d;
    private final boolean e;

    public b(String r2, String r3, int r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "typeName");
        Intrinsics.checkNotNullParameter(r5, "displayValue");
        this.f13001a = r2;
        this.f13002b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final String a() {
        return this.f13002b;
    }

    public final String b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13001a, r6.f13001a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13002b, r6.f13002b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f13001a.hashCode() * 31) + this.f13002b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "ResolvedAttr(name=" + this.f13001a + ", typeName=" + this.f13002b + ", rawType=" + this.c + ", displayValue=" + this.d + ", resolved=" + this.e + ')';
    }
}
