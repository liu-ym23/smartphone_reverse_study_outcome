package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowListScrollBehavior;", "", "listScrollEnabled", "", "appBarCollapseEnabled", "listStickyOverlapEnabled", "<init>", "(ZZZ)V", "getListScrollEnabled", "()Z", "getAppBarCollapseEnabled", "getListStickyOverlapEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6629b;
    private final boolean c;

    public p(boolean r1, boolean r2, boolean r3) {
        this.f6628a = r1;
        this.f6629b = r2;
        this.c = r3;
    }

    public final boolean a() {
        return this.f6628a;
    }

    public final boolean b() {
        return this.f6629b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
        if (this.f6628a == r6.f6628a) goto L12;
        return false;
    L12:
        if (this.f6629b == r6.f6629b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f6628a) * 31) + Boolean.hashCode(this.f6629b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "NowListScrollBehavior(listScrollEnabled=" + this.f6628a + ", appBarCollapseEnabled=" + this.f6629b + ", listStickyOverlapEnabled=" + this.c + ')';
    }
}
