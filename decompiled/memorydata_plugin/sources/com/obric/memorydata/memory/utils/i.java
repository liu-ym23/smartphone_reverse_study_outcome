package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/utils/PinShortcutConfirmedDispatch;", "", "action", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;", "supersedeProvenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "<init>", "(Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;)V", "getAction", "()Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;", "getSupersedeProvenance", "()Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PinShortcutTerminalAction f11545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PinShortcutSupersedeProvenance f11546b;

    public i(PinShortcutTerminalAction r2, PinShortcutSupersedeProvenance r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.f11545a = r2;
        this.f11546b = r3;
    }

    public /* synthetic */ i(PinShortcutTerminalAction r1, PinShortcutSupersedeProvenance r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final PinShortcutTerminalAction a() {
        return this.f11545a;
    }

    public final PinShortcutSupersedeProvenance b() {
        return this.f11546b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (this.f11545a == r6.f11545a) goto L12;
        return false;
    L12:
        if (this.f11546b == r6.f11546b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f11545a.hashCode() * 31;
        PinShortcutSupersedeProvenance r1 = this.f11546b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PinShortcutConfirmedDispatch(action=" + this.f11545a + ", supersedeProvenance=" + this.f11546b + ')';
    }
}
