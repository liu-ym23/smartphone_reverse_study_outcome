package com.obric.memorydata.memory.ui.migration;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\r\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", "", "includeTaskData", "", "includeMemoryData", "<init>", "(ZZ)V", "getIncludeTaskData", "()Z", "getIncludeMemoryData", "isValid", "toExportScopeIntOrNull", "", "()Ljava/lang/Integer;", "putIntoIntent", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0610a f11363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f11364b;
    private final boolean c;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.migration.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/migration/ExportSelection$Companion;", "", "<init>", "()V", "EXTRA_INCLUDE_TASK_DATA", "", "EXTRA_INCLUDE_MEMORY_DATA", "fromIntent", "Lcom/obric/memorydata/memory/ui/migration/ExportSelection;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0610a {
        private C0610a() {
        }

        public /* synthetic */ C0610a(DefaultConstructorMarker r1) {
            this();
        }

        public final a a(Intent r4) {
            if (r4 != null) goto L5;
            boolean r1 = false;
            return new a(r1, r1, 3, null);
        L5:
            boolean r2 = true;
            if (r4.hasExtra("extra_export_include_task_data") == false) goto L8;
            boolean r3 = r4.getBooleanExtra("extra_export_include_task_data", true);
        L10:
            if (r4.hasExtra("extra_export_include_memory_data") == false) goto L13;
            r2 = r4.getBooleanExtra("extra_export_include_memory_data", true);
        L13:
            return new a(r3, r2);
        L8:
            r3 = true;
            goto L10
        }
    }

    static {
        f11363a = new C0610a(null);
    }

    public a() {
        boolean r0 = false;
        this(r0, r0, 3, null);
    }

    public a(boolean r1, boolean r2) {
        this.f11364b = r1;
        this.c = r2;
    }

    public /* synthetic */ a(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ a a(a r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.f11364b;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.c;
    L9:
        return r0.a(r1, r2);
    }

    public final a a(boolean r1, boolean r2) {
        return new a(r1, r2);
    }

    public final void a(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        r3.putExtra("extra_export_include_task_data", this.f11364b);
        r3.putExtra("extra_export_include_memory_data", this.c);
    }

    public final boolean a() {
        return this.f11364b;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        if (this.f11364b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c == true) goto L8;
        return false;
    }

    public final Integer d() {
        if (c() == true) goto L5;
        return null;
    L5:
        boolean r0 = this.c;
        if (r0 == true) goto L8;
    L11:
        if (r0 == false) goto L13;
    L15:
        if (r0 == true) goto L17;
        return null;
    L17:
        if (this.f11364b == false) goto L21;
        int r3 = 3;
    L19:
        return Integer.valueOf(r3);
    L21:
        return null;
    L13:
        if (this.f11364b == false) goto L15;
        r3 = 2;
        goto L19
    L8:
        if (this.f11364b == true) goto L11;
        r3 = 1;
        goto L19
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f11364b == r6.f11364b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f11364b) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "ExportSelection(includeTaskData=" + this.f11364b + ", includeMemoryData=" + this.c + ')';
    }
}
