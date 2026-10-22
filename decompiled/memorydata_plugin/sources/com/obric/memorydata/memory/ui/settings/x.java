package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JX\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsState;", "", "hasConfirmed", "", "isSmartMemoryEnabled", "pendingSmartMemoryEnabled", "appSettings", "", "Lcom/obric/memorydata/memory/ui/settings/AppSettingItem;", "noNeedAccessibilityPackages", "", "", "version", "", "<init>", "(ZZLjava/lang/Boolean;Ljava/util/List;Ljava/util/Set;I)V", "getHasConfirmed", "()Z", "getPendingSmartMemoryEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppSettings", "()Ljava/util/List;", "getNoNeedAccessibilityPackages", "()Ljava/util/Set;", "getVersion", "()I", "displaySmartMemoryEnabled", "getDisplaySmartMemoryEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Boolean;Ljava/util/List;Ljava/util/Set;I)Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsState;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11520b;
    private final Boolean c;
    private final List<c> d;
    private final Set<String> e;
    private final int f;

    public x() {
        this(false, false, null, null, null, 0, 63, null);
    }

    public x(boolean r3, boolean r4, Boolean r5, List<c> r6, Set<String> r7, int r8) {
        List<c> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "appSettings");
        Intrinsics.checkNotNullParameter(r10, "noNeedAccessibilityPackages");
        this.f11519a = r3;
        this.f11520b = r4;
        this.c = r5;
        this.d = r9;
        this.e = r10;
        this.f = r8;
    }

    public /* synthetic */ x(boolean r8, boolean r9, Boolean r10, List r11, Set r12, int r13, int r14, DefaultConstructorMarker r15) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if ((r14 & 1) == 0) goto L5;
        boolean r2 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Boolean r5 = null;
    L15:
        if ((r14 & 8) == 0) goto L18;
        r0 = CollectionsKt.emptyList();
    L18:
        if ((r14 & 16) == 0) goto L21;
        r1 = SetsKt.emptySet();
    L21:
        if ((r14 & 32) != 0) goto L24;
        r3 = r13;
    L24:
        this(r2, r4, r5, r0, r1, r3);
        return;
    L13:
        r5 = r10;
        goto L15
    L9:
        r4 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ x a(x r7, boolean r8, boolean r9, Boolean r10, List r11, Set r12, int r13, int r14, Object r15) {
        List<c> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Set<String> r17 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.f11519a;
    L5:
        boolean r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.f11520b;
    L8:
        boolean r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        Boolean r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r16 = r7.d;
    L14:
        List<c> r4 = r16;
        if ((r14 & 16) == 0) goto L17;
        r17 = r7.e;
    L17:
        Set<String> r5 = r17;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.f;
    L21:
        return r7.a(r1, r2, r3, r4, r5, r13);
    }

    public final x a(boolean r9, boolean r10, Boolean r11, List<c> r12, Set<String> r13, int r14) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "appSettings");
        Intrinsics.checkNotNullParameter(r6, "noNeedAccessibilityPackages");
        return new x(r9, r10, r11, r5, r6, r14);
    }

    public final boolean a() {
        return this.f11519a;
    }

    public final Boolean b() {
        return this.c;
    }

    public final List<c> c() {
        return this.d;
    }

    public final Set<String> d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == true) goto L8;
        return false;
    L8:
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin");
        if (this.f11519a == r6.f11519a) goto L12;
        return false;
    L12:
        if (this.f11520b == r6.f11520b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean f() {
        Boolean r0 = this.c;
        if (r0 == null) goto L6;
        return r0.booleanValue();
    L6:
        return this.f11520b;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.f11519a) * 31) + Boolean.hashCode(this.f11520b)) * 31;
        Boolean r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SmartMemorySettingsState(hasConfirmed=" + this.f11519a + ", isSmartMemoryEnabled=" + this.f11520b + ", pendingSmartMemoryEnabled=" + this.c + ", appSettings=" + this.d + ", noNeedAccessibilityPackages=" + this.e + ", version=" + this.f + ')';
    }
}
