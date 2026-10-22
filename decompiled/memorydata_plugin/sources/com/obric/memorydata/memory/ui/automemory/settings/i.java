package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsUiState;", "", "draft", "Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "isSaving", "", "<init>", "(Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;Z)V", "getDraft", "()Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f10761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10762b;

    /* JADX WARN: Multi-variable type inference failed */
    public i() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public i(b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "draft");
        this.f10761a = r2;
        this.f10762b = r3;
    }

    public /* synthetic */ i(b r24, boolean r25, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 1) == 0) goto L5;
        b r0 = new b(null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, null, false, 524287, null);
    L7:
        if ((r26 & 2) == 0) goto L9;
        boolean r1 = false;
    L10:
        this(r0, r1);
        return;
    L9:
        r1 = r25;
        goto L10
    L5:
        r0 = r24;
        goto L7
    }

    public static /* synthetic */ i a(i r0, b r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f10761a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.f10762b;
    L9:
        return r0.a(r1, r2);
    }

    public final b a() {
        return this.f10761a;
    }

    public final i a(b r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "draft");
        return new i(r1, r2);
    }

    public final boolean b() {
        return this.f10762b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10761a, r6.f10761a) == true) goto L12;
        return false;
    L12:
        if (this.f10762b == r6.f10762b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f10761a.hashCode() * 31) + Boolean.hashCode(this.f10762b);
    }

    public String toString() {
        return "MemoryTaskSettingsUiState(draft=" + this.f10761a + ", isSaving=" + this.f10762b + ')';
    }
}
