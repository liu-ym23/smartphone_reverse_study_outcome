package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditUiState;", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "", "memoryInfo", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;)V", "getKind", "()Ljava/lang/String;", "getMemoryInfo", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "section", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "getSection", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "sceneText", "getSceneText", "singleText", "getSingleText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f10758b;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public f(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r3, "memoryInfo");
        this.f10757a = r2;
        this.f10758b = r3;
    }

    public /* synthetic */ f(String r12, e r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r12 = "";
    L6:
        if ((r14 & 2) == 0) goto L8;
        r13 = new e(null, null, null, null, null, null, null, null, 255, null);
    L8:
        this(r12, r13);
    }

    public static /* synthetic */ f a(f r0, String r1, e r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f10757a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f10758b;
    L9:
        return r0.a(r1, r2);
    }

    public final f a(String r1, e r2) {
        Intrinsics.checkNotNullParameter(r1, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r2, "memoryInfo");
        return new f(r1, r2);
    }

    public final String a() {
        return this.f10757a;
    }

    public final e b() {
        return this.f10758b;
    }

    public final e.b c() {
        return this.f10758b.c();
    }

    public final String d() {
        boolean r0 = Intrinsics.areEqual(this.f10757a, MemoryInfoSectionEditActivity.KIND_UPDATE_RULE);
        e r2 = this.f10758b;
        if (r0 == false) goto L6;
        return r2.e();
    L6:
        return r2.b();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10757a, r6.f10757a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10758b, r6.f10758b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10757a.hashCode() * 31) + this.f10758b.hashCode();
    }

    public String toString() {
        return "MemoryInfoSectionEditUiState(kind=" + this.f10757a + ", memoryInfo=" + this.f10758b + ')';
    }
}
