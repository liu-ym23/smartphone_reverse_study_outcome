package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceIconSpec;", "", "drawableRes", "", "cacheKey", "", "decorateIcon", "", "<init>", "(ILjava/lang/String;Z)V", "getDrawableRes", "()I", "getCacheKey", "()Ljava/lang/String;", "getDecorateIcon", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11177b;
    private final boolean c;

    public af(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        this.f11176a = r2;
        this.f11177b = r3;
        this.c = r4;
    }

    public final int a() {
        return this.f11176a;
    }

    public final String b() {
        return this.f11177b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, af.class) == true) goto L8;
        return false;
    L8:
        af r6 = (af) ZeusTransformUtils.preCheckCast(r5, af.class, "com.obric.memorydata.plugin");
        if (this.f11176a == r6.f11176a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11177b, r6.f11177b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f11176a) * 31) + this.f11177b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "MemorySourceIconSpec(drawableRes=" + this.f11176a + ", cacheKey=" + this.f11177b + ", decorateIcon=" + this.c + ')';
    }
}
