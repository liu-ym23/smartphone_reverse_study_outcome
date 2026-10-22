package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.suite.lark.platform.component.storage.clean.f;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CleanRequest<Res extends f> {
    public static final b Companion = null;
    public static final String TAG = "CleanRequest";
    private final List<Res> cleanResources;
    private final int retryCount;
    private final String uniqueName;
    private final List<Res> whiteListResources;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/CleanRequest$Status;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "PENDING", "SUCCEED", "FAILED", "CANCELED", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Status extends Enum<Status> {
        public static final Status CANCELED = null;
        public static final Status FAILED = null;
        public static final Status IDLE = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status SUCCEED = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("IDLE", 0);
            IDLE = r0;
            Status r1 = new Status("RUNNING", 1);
            RUNNING = r1;
            Status r3 = new Status("PENDING", 2);
            PENDING = r3;
            Status r5 = new Status("SUCCEED", 3);
            SUCCEED = r5;
            Status r7 = new Status("FAILED", 4);
            FAILED = r7;
            Status r9 = new Status("CANCELED", 5);
            CANCELED = r9;
            Status[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class a<Res extends f, Req extends CleanRequest<Res>, BD extends a<Res, Req, BD>> {
        public final Context getContext() {
            return null;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Comparator {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((String) r1).length() - ((String) r2).length();
        }
    }

    static {
        Companion = new b();
    }

    public final void cancel() {
        h r0 = o.a;
        String r1 = this.uniqueName;
        Intrinsics.checkNotNullParameter(r1, "requestName");
        HashMap<String, Object> r2 = CleanStore.a;
        Intrinsics.checkNotNullParameter(r1, "requestName");
        CleanStore.a.remove(r1);
        CleanStore.b.remove(r1);
        Lazy r3 = CleanStore.c;
        ((KVRepo) r3.getValue()).remove("result_" + r1);
        ((KVRepo) r3.getValue()).remove("request_" + r1);
        Log.i("StorageCleaner", "all request data cleaned: " + r1);
    }

    public final long getTotalProgressWeight() {
        Iterator<T> r0 = this.cleanResources.iterator();
        long r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((f) r0.next()).progressWeight();
        goto L4
    L6:
        return r1;
    }

    public int hashCode() {
        return (((this.uniqueName.hashCode() * 31) + this.retryCount) * 31) + this.cleanResources.hashCode();
    }

    public List<f> getResources() {
        return this.cleanResources;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public List<f> getWhitelistResources() {
        return this.whiteListResources;
    }

    private final long calculateTotalSizeForPath(String r11) {
        PolarisFileWrapper r2 = new PolarisFileWrapper(r11);
    L22:
        e = move-exception;
        Log.e(TAG, "无法访问文件：" + r11, e);
        return 0;
    L4:
        if (r2.exists() == true) goto L7;
        return 0;
    L7:
        if (r2.isFile() == true) goto L9;
        Iterator r3 = FilesKt.walk$default(r2, null, 1, null).iterator();     // Catch: Exception -> L22
        long r5 = 0;
    L12:
        if (r3.hasNext() == false) goto L21;
        File r7 = (File) r3.next();     // Catch: Exception -> L22
    L18:
        e = move-exception;
        Log.e(TAG, "无法访问文件：" + r7.getAbsolutePath(), e);     // Catch: Exception -> L22
        goto L12
    L15:
        if (r7.isFile() == false) goto L12;
    L17:
        r5 = r5 + r7.length();
        goto L12
    L21:
        return r5;
    L9:
        return r2.length();
    }

    private final long calculateTotalSizeForPaths(List<String> r5) {
        List<String> r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.add(Long.valueOf(calculateTotalSizeForPath((String) r7.next())));
        goto L4
    L6:
        Iterator r8 = r0.iterator();
        long r1 = 0;
    L8:
        if (r8.hasNext() == false) goto L10;
        r1 = r1 + ((Number) r8.next()).longValue();
        goto L8
    L10:
        return r1;
    }

    private final List<String> removeRedundantPaths(List<String> r9) {
        List r10 = CollectionsKt.sortedWith(r9, c.a);
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L26;
        String r1 = (String) r11.next();
        boolean r3 = false;
        if (r0.isEmpty() == true) goto L22;
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        String r4 = (String) r2.next();
        if (Intrinsics.areEqual(r1, r4) == false) goto L14;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L10;
        r3 = true;
        goto L22
    L14:
        if (new PolarisFileWrapper(r4).isDirectory() == true) goto L16;
    L18:
        r5 = false;
        goto L20
    L16:
        if (StringsKt.startsWith$default(r1, r4, false, 2, null) == false) goto L18;
    L22:
        if (r3 == true) goto L4;
        if (new PolarisFileWrapper(r1).exists() == false) goto L4;
        r0.add(r1);
        goto L4
    L26:
        return r0;
    }

    public final long calculateCleanSize(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        List<String> r0 = collectResourceFilePaths(r12, getResources());
        List<String> r13 = collectResourceFilePaths(r12, getWhitelistResources());
        List<String> r1 = removeRedundantPaths(r0);
        List<String> r14 = removeRedundantPaths(r13);
        ArrayList r2 = new ArrayList();
        Iterator<T> r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L27;
        Object r3 = r15.next();
        String r4 = (String) r3;
        List<String> r5 = r1;
        boolean r6 = false;
        if ((r5 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L24;
        String r8 = p.a((String) r7.next());
        String r9 = p.a(r4);
        if (Intrinsics.areEqual(r9, r8) == false) goto L16;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L12;
        r6 = true;
        goto L24
    L16:
        if (new PolarisFileWrapper(r8).isDirectory() == true) goto L18;
    L20:
        r10 = false;
        goto L22
    L18:
        if (StringsKt.startsWith$default(r9, r8, false, 2, null) == false) goto L20;
    L24:
        if (r6 == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        if (r5.isEmpty() == false) goto L10;
    L27:
        return calculateTotalSizeForPaths(r1) - calculateTotalSizeForPaths(r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CleanRequest) == true) goto L8;
        return false;
    L8:
        CleanRequest r6 = (CleanRequest) r5;
        if (Intrinsics.areEqual(this.uniqueName, r6.uniqueName) == true) goto L12;
        return false;
    L12:
        if (this.retryCount == r6.retryCount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cleanResources, r6.cleanResources) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final com.suite.lark.platform.component.storage.clean.b newClean(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        h r1 = o.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(this, "request");
        if (o.c == true) goto L15;
        o.c = true;
        int r2 = e.b;
        Intrinsics.checkNotNullParameter(r4, "context");
        k r0 = (k) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(r4.getApplicationContext()), DwarfSPIEntryPoint.class)).dwarfSPI().get(k.class);
        if (r0 == null) goto L9;
        Set<j> r3 = r0.a();
        if (r3 == null) goto L9;
    L10:
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L15;
        j r6 = (j) r5.next();
        r6.a(r4, o.a);
        r6.b(r4, o.b);
    L9:
        r3 = SetsKt.emptySet();
    L15:
        return new com.suite.lark.platform.component.storage.clean.c(r4, this, o.a);
    }

    private final List<String> collectResourceFilePaths(Context r4, List<? extends f> r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        f r1 = (f) r6.next();
        if ((r1 instanceof voc.a) == false) goto L6;
        r0.addAll(((voc.a) r1).getFilePaths(r4));
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CleanRequest(String r2, int r3, List<? extends Res> r4, List<? extends Res> r5) {
        Intrinsics.checkNotNullParameter(r2, "uniqueName");
        Intrinsics.checkNotNullParameter(r4, "cleanResources");
        this.uniqueName = r2;
        this.retryCount = r3;
        this.cleanResources = r4;
        this.whiteListResources = r5;
    }

    public /* synthetic */ CleanRequest(String r1, int r2, List r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        this(r1, r2, r3, r4);
    }
}
