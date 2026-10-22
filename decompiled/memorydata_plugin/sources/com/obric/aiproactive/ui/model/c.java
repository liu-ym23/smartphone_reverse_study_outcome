package com.obric.aiproactive.ui.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/aiproactive/ui/model/AllDayPagingState;", "", "loading", "", "hasNext", "nextOffset", "", "<init>", "(ZZI)V", "getLoading", "()Z", "getHasNext", "getNextOffset", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6720b;
    private final int c;

    public c() {
        this(false, false, 0, 7, null);
    }

    public c(boolean r1, boolean r2, int r3) {
        this.f6719a = r1;
        this.f6720b = r2;
        this.c = r3;
    }

    public /* synthetic */ c(boolean r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ c a(c r0, boolean r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.f6719a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.f6720b;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.c;
    L12:
        return r0.a(r1, r2, r3);
    }

    public final c a(boolean r1, boolean r2, int r3) {
        return new c(r1, r2, r3);
    }

    public final boolean a() {
        return this.f6719a;
    }

    public final boolean b() {
        return this.f6720b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f6719a == r6.f6719a) goto L12;
        return false;
    L12:
        if (this.f6720b == r6.f6720b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f6719a) * 31) + Boolean.hashCode(this.f6720b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "AllDayPagingState(loading=" + this.f6719a + ", hasNext=" + this.f6720b + ", nextOffset=" + this.c + ')';
    }
}
