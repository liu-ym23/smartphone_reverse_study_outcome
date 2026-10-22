package com.obric.memorydata.memory.ui.address.setting;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingUiState;", "", "isReady", "", "autoLearnEnabled", "home", "Lcom/obric/memorydata/memory/ui/address/setting/AddressItemUiState;", "company", "<init>", "(ZZLcom/obric/memorydata/memory/ui/address/setting/AddressItemUiState;Lcom/obric/memorydata/memory/ui/address/setting/AddressItemUiState;)V", "()Z", "getAutoLearnEnabled", "getHome", "()Lcom/obric/memorydata/memory/ui/address/setting/AddressItemUiState;", "getCompany", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10591b;
    private final a c;
    private final a d;

    public b() {
        this(false, false, null, null, 15, null);
    }

    public b(boolean r2, boolean r3, a r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "home");
        Intrinsics.checkNotNullParameter(r5, "company");
        this.f10590a = r2;
        this.f10591b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ b(boolean r4, boolean r5, a r6, a r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r6 = new a(null, false, 3, null);
    L12:
        if ((r8 & 8) == 0) goto L14;
        r7 = new a(null, false, 3, null);
    L14:
        this(r4, r5, r6, r7);
    }

    public final boolean a() {
        return this.f10590a;
    }

    public final boolean b() {
        return this.f10591b;
    }

    public final a c() {
        return this.c;
    }

    public final a d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f10590a == r6.f10590a) goto L12;
        return false;
    L12:
        if (this.f10591b == r6.f10591b) goto L15;
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
        return (((((Boolean.hashCode(this.f10590a) * 31) + Boolean.hashCode(this.f10591b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "AddressSettingUiState(isReady=" + this.f10590a + ", autoLearnEnabled=" + this.f10591b + ", home=" + this.c + ", company=" + this.d + ')';
    }
}
