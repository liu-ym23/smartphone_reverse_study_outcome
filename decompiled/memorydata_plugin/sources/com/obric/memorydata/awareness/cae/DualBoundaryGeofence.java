package com.obric.memorydata.awareness.cae;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence;", "", "<init>", "()V", "INNER_RADIUS_OFFSET_METERS", "", "OUTER_RADIUS_OFFSET_METERS", "INNER_PREFIX", "", "OUTER_PREFIX", "innerFenceId", "logicalFenceId", "outerFenceId", "parse", "Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$PhysicalFence;", "fenceId", "isInternalFenceId", "", "isReservedFenceId", "Boundary", "PhysicalFence", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DualBoundaryGeofence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DualBoundaryGeofence f8549a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$Boundary;", "", "protocolValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProtocolValue", "()Ljava/lang/String;", "INNER", "OUTER", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Boundary extends Enum<Boundary> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Boundary[] $VALUES = null;
        public static final Boundary INNER = null;
        public static final Boundary OUTER = null;
        private final String protocolValue;

        private static final /* synthetic */ Boundary[] $values() {
            return new Boundary[]{INNER, OUTER};
        }

        static {
            INNER = new Boundary("INNER", 0, "inner");
            OUTER = new Boundary("OUTER", 1, "outer");
            Boundary[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Boundary(String r1, int r2, String r3) {
            super(r1, r2);
            this.protocolValue = r3;
        }

        public static EnumEntries<Boundary> getEntries() {
            return $ENTRIES;
        }

        public static Boundary valueOf(String r2) {
            return (Boundary) ZeusTransformUtils.preCheckCast(Enum.valueOf(Boundary.class, r2), Boundary.class, "com.obric.memorydata.plugin");
        }

        public static Boundary[] values() {
            return (Boundary[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Boundary[].class, "com.obric.memorydata.plugin");
        }

        public final String getProtocolValue() {
            return this.protocolValue;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$PhysicalFence;", "", "logicalFenceId", "", "boundary", "Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$Boundary;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$Boundary;)V", "getLogicalFenceId", "()Ljava/lang/String;", "getBoundary", "()Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$Boundary;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Boundary f8551b;

        public a(String r2, Boundary r3) {
            Intrinsics.checkNotNullParameter(r2, "logicalFenceId");
            Intrinsics.checkNotNullParameter(r3, "boundary");
            this.f8550a = r2;
            this.f8551b = r3;
        }

        public final String a() {
            return this.f8550a;
        }

        public final Boundary b() {
            return this.f8551b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8550a, r6.f8550a) == true) goto L12;
            return false;
        L12:
            if (this.f8551b == r6.f8551b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8550a.hashCode() * 31) + this.f8551b.hashCode();
        }

        public String toString() {
            return "PhysicalFence(logicalFenceId=" + this.f8550a + ", boundary=" + this.f8551b + ')';
        }
    }

    static {
        f8549a = new DualBoundaryGeofence();
    }

    private DualBoundaryGeofence() {
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicalFenceId");
        return "__memory_inner_boundary__" + r2;
    }

    public final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicalFenceId");
        return "__memory_outer_boundary__" + r2;
    }

    public final a c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "fenceId");
        if (StringsKt.startsWith$default(r6, "__memory_inner_boundary__", false, 2, null) == false) goto L6;
        a r0 = new a(StringsKt.removePrefix(r6, (CharSequence) ZeusTransformUtils.preCheckCast("__memory_inner_boundary__", CharSequence.class, "com.obric.memorydata.plugin")), Boundary.INNER);
    L9:
        if (r0 != null) goto L11;
        return null;
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        return null;
    L13:
        return r0;
    L6:
        if (StringsKt.startsWith$default(r6, "__memory_outer_boundary__", false, 2, null) == false) goto L8;
        r0 = new a(StringsKt.removePrefix(r6, (CharSequence) ZeusTransformUtils.preCheckCast("__memory_outer_boundary__", CharSequence.class, "com.obric.memorydata.plugin")), Boundary.OUTER);
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fenceId");
        return e(r2);
    }

    public final boolean e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fenceId");
        if (StringsKt.startsWith$default(r4, "__memory_inner_boundary__", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "__memory_outer_boundary__", false, 2, null) == true) goto L6;
        return false;
    }
}
