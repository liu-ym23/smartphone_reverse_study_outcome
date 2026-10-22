package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportOutputProtocol;", "", "zipFile", "Ljava/io/File;", "workingFile", "finalFile", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", "getZipFile", "()Ljava/io/File;", "getWorkingFile", "getFinalFile", "workingFilePaths", "", "", "getWorkingFilePaths", "()Ljava/util/List;", "publish", "", "cleanupWorkingFiles", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f9784b;
    private final File c;
    private final File d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportOutputProtocol$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/datatransport/manager/ExportOutputProtocol;", "shareDir", "Ljava/io/File;", "taskId", "", "encrypted", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final m a(File r4, String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "shareDir");
            Intrinsics.checkNotNullParameter(r5, "taskId");
            String r3 = "MemoryData_Export_" + r5;
            File r7 = new File(r4, r3 + ".zip.partial");
            if (r6 == false) goto L6;
            return new m(r7, new File(r4, r3 + ".zip.enc.partial"), new File(r4, r3 + ".zip.enc"));
        L6:
            return new m(r7, r7, new File(r4, r3 + ".zip"));
        }
    }

    static {
        f9783a = new a(null);
    }

    public m(File r2, File r3, File r4) {
        Intrinsics.checkNotNullParameter(r2, "zipFile");
        Intrinsics.checkNotNullParameter(r3, "workingFile");
        Intrinsics.checkNotNullParameter(r4, "finalFile");
        this.f9784b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final File a() {
        return this.f9784b;
    }

    public final File b() {
        return this.c;
    }

    public final File c() {
        return this.d;
    }

    public final List<String> d() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new File[]{this.f9784b, this.c}), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(((File) ZeusTransformUtils.preCheckCast(r5.next(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath());
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public final void e() {
        if (this.c.isFile() == false) goto L12;
        if (this.c.length() <= 0) goto L12;
        if (this.c.renameTo(this.d) == false) goto L10;
        return;
    L10:
        throw new IOException("Unable to publish export file: " + this.d.getAbsolutePath());
    L12:
        throw new IOException("Export working file is missing or empty: " + this.c.getAbsolutePath());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9784b, r6.f9784b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void f() {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        File r2 = new File((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));
        if (r2.exists() == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L4;
        r2.delete();
        goto L4
    }

    public int hashCode() {
        return (((this.f9784b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ExportOutputProtocol(zipFile=" + this.f9784b + ", workingFile=" + this.c + ", finalFile=" + this.d + ')';
    }
}
