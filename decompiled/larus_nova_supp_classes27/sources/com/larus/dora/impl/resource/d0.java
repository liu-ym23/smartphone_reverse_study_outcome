package com.larus.dora.impl.resource;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.network.a$a;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 {
    public static final Set<DoraEnableScope> f = null;
    public final PolarisFileWrapper a;
    public final PolarisFileWrapper b;
    public final File c;
    public final c d;
    public final Object e;

    public static final class a {
        public final Set<String> a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "ArchiveExtraction(files=" + this.a + ", extractedBytes=" + this.b + ')';
        }

        public a(Set<String> r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "files");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final Gson a;
        public final Keva b;

        public final Set<String> c() {
            Set<String> r2 = null;
            String r3 = this.b.getString("active_package_ids", null);
            if (r3 == null) goto L13;
            List r0 = StringsKt.split$default(r3, new String[]{","}, false, 0, 6, null);
            if (r0 == null) goto L13;
            ArrayList r1 = new ArrayList();
            Iterator r4 = r0.iterator();
        L8:
            if (r4.hasNext() == false) goto L12;
            Object r5 = r4.next();
            if ((!StringsKt.isBlank((String) r5)) == false) goto L8;
            r1.add(r5);
            goto L8
        L12:
            r2 = CollectionsKt.toSet(r1);
        L13:
            if (r2 == null) goto L15;
            return r2;
        L15:
            return SetsKt.emptySet();
        }

        public c() {
            this.a = new Gson();
            this.b = Keva.getRepo("dora_resource_artifact_identities", 0);
        }

        public final Map<String, o> b() {
            Set<String> r0 = c();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            String r3 = (String) r2.next();
            o r4 = a(r3);
            if (r4 == null) goto L8;
            Pair r5 = TuplesKt.to(r3, r4);
        L9:
            if (r5 == null) goto L4;
            r1.add(r5);
            goto L4
        L8:
            r5 = null;
            goto L9
        L12:
            return MapsKt.toMap(r1);
        }

        public final o a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "packageId");
            Long r0 = Long.valueOf(this.b.getLong("active_version_" + r9, -1));
            if (r0.longValue() == (-1)) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L31;
            long r4 = r0.longValue();
            String r1 = this.b.getString("active_sha256_" + r9, null);
            if (r1 == null) goto L31;
            if ((!StringsKt.isBlank(r1)) == true) goto L17;
            r1 = null;
        L17:
            if (r1 == null) goto L31;
            String r3 = this.b.getString("active_files_" + r9, null);
            if (r3 == null) goto L31;
            String[] r5 = (String[]) GsonProtectorUtils.fromJson(this.a, r3, String[].class);
            if (r5 == null) goto L31;
            Set r6 = ArraysKt.toSet(r5);
            if (r6 == null) goto L31;
            if ((true ^ r6.isEmpty()) == true) goto L28;
            r6 = null;
        L28:
            if (r6 == null) goto L31;
            return new o(new m(r9, r4, r1), r6);
        L31:
            return null;
        L5:
            r2 = false;
            goto L7
        }

        public final void d(Set<String> r13) {
            Intrinsics.checkNotNullParameter(r13, "directories");
            if (r13.isEmpty() == false) goto L5;
            return;
        L5:
            Map<String, o> r0 = b();
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator<Map.Entry<String, o>> r2 = r0.entrySet().iterator();
        L6:
            boolean r3 = true;
            if (r2.hasNext() == false) goto L37;
            Map.Entry<String, o> r4 = r2.next();
            Set<String> r5 = r4.getValue().b;
            if ((r5 instanceof Collection) == true) goto L11;
        L13:
            Iterator<T> r6 = r5.iterator();
        L15:
            if (r6.hasNext() == false) goto L34;
            String r7 = (String) r6.next();
            if (r13.isEmpty() == true) goto L31;
            Iterator<T> r8 = r13.iterator();
        L21:
            if (r8.hasNext() == false) goto L31;
            String r9 = (String) r8.next();
            if (Intrinsics.areEqual(r7, r9) == false) goto L25;
        L28:
            boolean r10 = true;
        L29:
            if (r10 == false) goto L21;
            boolean r11 = true;
        L32:
            if (r11 == false) goto L15;
        L35:
            if (r3 == false) goto L6;
            r1.put(r4.getKey(), r4.getValue());
            goto L6
        L25:
            if (StringsKt.startsWith$default(r7, r9 + '/', false, 2, null) == true) goto L28;
            r10 = false;
        L31:
            r11 = false;
        L34:
            r3 = false;
            goto L35
        L11:
            if (r5.isEmpty() == false) goto L13;
        L37:
            Set r12 = r1.keySet();
            Set r14 = r12;
            Iterator r15 = r14.iterator();
        L39:
            if (r15.hasNext() == false) goto L42;
            String r16 = (String) r15.next();
            this.b.erase("active_version_" + r16);
            this.b.erase("active_sha256_" + r16);
            this.b.erase("active_files_" + r16);
            goto L39
        L42:
            if ((!r12.isEmpty()) == false) goto L61;
            this.b.storeString("active_package_ids", CollectionsKt.joinToString$default(CollectionsKt.sorted(SetsKt.minus(c(), r14)), ",", null, null, 0, null, null, 62, null));
            g49.d.d("DoraResourceInstall", "removed artifact identities after resource cleanup: directories=" + r13 + ", packages=" + r12);
            return;
        }

        public final void e(o r11) {
            Intrinsics.checkNotNullParameter(r11, "state");
            String r0 = r11.a.a;
            this.b.storeLong("active_version_" + r0, r11.a.b);
            this.b.storeString("active_sha256_" + r0, r11.a.c);
            this.b.storeString("active_files_" + r0, GsonProtectorUtils.toJson(this.a, CollectionsKt.sorted(r11.b)));
            this.b.storeString("active_package_ids", CollectionsKt.joinToString$default(CollectionsKt.sorted(SetsKt.plus(c(), r0)), ",", null, null, 0, null, null, 62, null));
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public static final a a = null;

            static {
                a = new a();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof a) == true) goto L9;
                return false;
            L9:
                a r4 = (a) r3;
                return true;
            }

            public final int hashCode() {
                return -1062040470;
            }

            public final String toString() {
                return "DownloadFailed";
            }

            public a() {
            }
        }

        public static final class b extends d {
            public static final b a = null;

            static {
                a = new b();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof b) == true) goto L9;
                return false;
            L9:
                b r4 = (b) r3;
                return true;
            }

            public final int hashCode() {
                return 1193669150;
            }

            public final String toString() {
                return "Success";
            }

            public b() {
            }
        }

        public static final class c extends d {
            public static final c a = null;

            static {
                a = new c();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof c) == true) goto L9;
                return false;
            L9:
                c r4 = (c) r3;
                return true;
            }

            public final int hashCode() {
                return -2136379173;
            }

            public final String toString() {
                return "VerifyFailed";
            }

            public c() {
            }
        }

        public d() {
        }
    }

    public static final class e {
        public final n a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "PendingArtifactInstallation(manifest=" + this.a + ')';
        }

        public e(n r2) {
            Intrinsics.checkNotNullParameter(r2, "manifest");
            this.a = r2;
        }
    }

    public static final class f {
        public final List<e> a;
        public final List<o> b;
        public final Set<String> c;
        public final Set<DoraEnableScope> d;
        public final Set<String> e;
        public final Map<DoraEnableScope, Set<String>> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "ResourceArtifactTransaction(installations=" + this.a + ", retainedStates=" + this.b + ", packageIdsToReplace=" + this.c + ", expectedDeviceScopes=" + this.d + ", allowedArchiveRoots=" + this.e + ", artifactIdsByScope=" + this.f + ')';
        }

        public final List<e> a() {
            return this.a;
        }

        public final List<o> b() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(List<e> r2, List<o> r3, Set<String> r4, Set<? extends DoraEnableScope> r5, Set<String> r6, Map<DoraEnableScope, ? extends Set<String>> r7) {
            Intrinsics.checkNotNullParameter(r2, "installations");
            Intrinsics.checkNotNullParameter(r3, "retainedStates");
            Intrinsics.checkNotNullParameter(r4, "packageIdsToReplace");
            Intrinsics.checkNotNullParameter(r5, "expectedDeviceScopes");
            Intrinsics.checkNotNullParameter(r6, "allowedArchiveRoots");
            Intrinsics.checkNotNullParameter(r7, "artifactIdsByScope");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static abstract class g {

        public static final class a extends g {
            public static final a a = null;

            static {
                a = new a();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof a) == true) goto L9;
                return false;
            L9:
                a r4 = (a) r3;
                return true;
            }

            public final int hashCode() {
                return -2107816190;
            }

            public final String toString() {
                return "DownloadFailed";
            }

            public a() {
            }
        }

        public static final class b extends g {
            public static final b a = null;

            static {
                a = new b();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof b) == true) goto L9;
                return false;
            L9:
                b r4 = (b) r3;
                return true;
            }

            public final int hashCode() {
                return 2018691579;
            }

            public final String toString() {
                return "InstallFailed";
            }

            public b() {
            }
        }

        public static final class c extends g {
            public final File a;
            public final List<o> b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Success(stagedCloudDirectory=" + this.a + ", installedStates=" + this.b + ')';
            }

            public final List<o> a() {
                return this.b;
            }

            public final File b() {
                return this.a;
            }

            public c(PolarisFileWrapper r2, List r3) {
                Intrinsics.checkNotNullParameter(r2, "stagedCloudDirectory");
                Intrinsics.checkNotNullParameter(r3, "installedStates");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class d extends g {
            public static final d a = null;

            static {
                a = new d();
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if ((r3 instanceof d) == true) goto L9;
                return false;
            L9:
                d r4 = (d) r3;
                return true;
            }

            public final int hashCode() {
                return -1838026381;
            }

            public final String toString() {
                return "VerifyFailed";
            }

            public d() {
            }
        }

        public g() {
        }
    }

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraResourceArtifactUpdateAction.values().length];
            r0[DoraResourceArtifactUpdateAction.INSTALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[DoraResourceArtifactUpdateAction.UNCHANGED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[DoraResourceArtifactUpdateAction.KEEP_ACTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DoraResourceArtifactUpdateAction.INVALID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class i<T> implements Comparator {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((n) r1).a, ((n) r2).a);
        }
    }

    static {
        f = SetsKt.setOf(new DoraEnableScope[]{DoraEnableScope.G1, DoraEnableScope.G2});
    }

    public d0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = new PolarisFileWrapper(r4.getFilesDir(), ".dora_resource_tmp");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4.getFilesDir(), "dora_resources/cloud");
        this.b = r0;
        File r5 = r0.getParentFile();
        if (r5 == null) goto L7;
        this.c = r5;
        this.d = new c();
        this.e = new Object();
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static boolean i(File r9) {
        boolean r1 = true;
        if (r9.exists() == true) goto L5;
        File r0 = r9.getParentFile();
        if (r0 != null) goto L17;
        g49.d.e("DoraResourceInstall", "directory creation failed without parent: path=" + r9.getAbsolutePath());
        return false;
    L17:
        if (i(r0) == true) goto L21;
        g49.d.e("DoraResourceInstall", "directory parent creation failed: path=" + r9.getAbsolutePath() + ", parent=" + r0.getAbsolutePath() + ", parentExists=" + r0.exists() + ", parentIsDirectory=" + r0.isDirectory() + ", parentCanWrite=" + r0.canWrite());
        return false;
    L21:
        if (r9.mkdir() == false) goto L23;
    L26:
        if (r1 == true) goto L28;
        g49.d.e("DoraResourceInstall", "directory creation failed: path=" + r9.getAbsolutePath() + ", parent=" + r0.getAbsolutePath() + ", parentExists=" + r0.exists() + ", parentIsDirectory=" + r0.isDirectory() + ", parentCanWrite=" + r0.canWrite());
    L28:
        return r1;
    L23:
        if (r9.exists() == true) goto L26;
        r1 = false;
        goto L26
    L5:
        if (r9.isDirectory() == true) goto L11;
        StringBuilder r2 = new StringBuilder("directory creation rejected existing non-directory path: path=");
        r2.append(r9.getAbsolutePath());
        r2.append(", parent=");
        File r10 = r9.getParentFile();
        if (r10 == null) goto L9;
        String r11 = r10.getAbsolutePath();
    L10:
        r2.append(r11);
        g49.d.e("DoraResourceInstall", r2.toString());
        goto L11
    L9:
        r11 = null;
    L11:
        return true;
    }

    public final boolean a(Set<? extends DoraEnableScope> r10) {
        Intrinsics.checkNotNullParameter(r10, "scopes");
        Set r11 = CollectionsKt.intersect(r10, f);
        boolean r1 = true;
        if (r11.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r0 = this.e;
        monitor-enter(r0);
        PolarisFileWrapper r2 = d("cleanup");     // Catch: Throwable -> L59
        if (r2 != null) goto L62;
    L52:
        r1 = false;
    L55:
        monitor-exit(r0);
        return r1;
    L62:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2, "cloud");     // Catch: Throwable -> L40
        if (c(r4) == true) goto L17;
        g49.d.e("DoraResourceInstall", "resource cleanup staging copy failed");     // Catch: Throwable -> L40
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L59
    L51:
        this.a.delete();     // Catch: Throwable -> L59
        goto L52
    L17:
        LinkedHashSet r6 = new LinkedHashSet();     // Catch: Throwable -> L40
        Iterator r5 = r11.iterator();     // Catch: Throwable -> L40
    L19:
        if (r5.hasNext() == false) goto L22;
        r6.add(f0.a((DoraEnableScope) r5.next()));     // Catch: Throwable -> L40
        goto L19
    L22:
        if (Intrinsics.areEqual(r11, f) == false) goto L25;
        r6.add("shared/g");     // Catch: Throwable -> L40
    L25:
        if (r6.isEmpty() == true) goto L42;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L40
    L29:
        if (r7.hasNext() == false) goto L42;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r4, (String) r7.next());     // Catch: Throwable -> L40
        if (h(r4, r8) == true) goto L33;
    L37:
        boolean r9 = false;
    L38:
        if (r9 == true) goto L29;
        boolean r12 = false;
    L43:
        if (r12 == true) goto L48;
        g49.d.e("DoraResourceInstall", "resource cleanup staging deletion failed");     // Catch: Throwable -> L40
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L59
        goto L51
    L48:
        if (b(r4, r2) == true) goto L53;
        g49.d.e("DoraResourceInstall", "resource cleanup cloud commit failed");     // Catch: Throwable -> L40
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L59
        goto L51
    L53:
        this.d.d(r6);     // Catch: Throwable -> L40
        g49.d.d("DoraResourceInstall", "resource cleanup committed: scopes=" + r11 + ", shared=" + r6.contains("shared/g"));     // Catch: Throwable -> L40
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L59
        this.a.delete();     // Catch: Throwable -> L59
        goto L55
    L33:
        if (r8.exists() == true) goto L35;
    L36:
        r9 = true;
        goto L38
    L35:
        if (FilesKt.deleteRecursively(r8) == false) goto L37;
    L42:
        r12 = true;
    L40:
        th = move-exception;
        FilesKt.deleteRecursively(r2);     // Catch: Throwable -> L59
        this.a.delete();     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    }

    public final boolean c(PolarisFileWrapper r110) {
        StringBuilder r0 = new StringBuilder("cloud staging directory state: activeCloud=");
        r0.append(this.b.getAbsolutePath());
        r0.append(", activeExists=");
        r0.append(this.b.exists());
        r0.append(", activeIsDirectory=");
        r0.append(this.b.isDirectory());
        r0.append(", activeCanRead=");
        r0.append(this.b.canRead());
        r0.append(", activeCanWrite=");
        r0.append(this.b.canWrite());
        r0.append(", target=");
        r0.append(r110.getAbsolutePath());
        r0.append(", targetParent=");
        File r6 = r110.getParentFile();
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.getAbsolutePath();
    L6:
        r0.append(r8);
        r0.append(", targetParentExists=");
        File r9 = r110.getParentFile();
        if (r9 == null) goto L9;
        Boolean r10 = Boolean.valueOf(r9.exists());
    L10:
        r0.append(r10);
        r0.append(", targetParentIsDirectory=");
        File r11 = r110.getParentFile();
        if (r11 == null) goto L13;
        Boolean r12 = Boolean.valueOf(r11.isDirectory());
    L14:
        r0.append(r12);
        g49.d.d("DoraResourceInstall", r0.toString());
        if (this.b.exists() == true) goto L21;
        boolean r1 = i(r110);
        StringBuilder r3 = new StringBuilder("staged cloud directory creation result: path=");
        r3.append(r110.getAbsolutePath());
        r3.append(", parent=");
        File r4 = r110.getParentFile();
        if (r4 == null) goto L19;
        r7 = r4.getAbsolutePath();
    L19:
        r3.append(r7);
        r3.append(", ready=");
        r3.append(r1);
        r3.append(", exists=");
        r3.append(r110.exists());
        r3.append(", isDirectory=");
        r3.append(r110.isDirectory());
        r3.append(", canWrite=");
        r3.append(r110.canWrite());
        g49.d.d("DoraResourceInstall", r3.toString());
        return r1;
    L21:
        boolean r2 = i(r110);
        if (this.b.isDirectory() == false) goto L71;
        if (r2 == false) goto L71;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L61
        File r13 = this.b.getCanonicalFile();     // Catch: Throwable -> L61
        String r14 = r13.getPath() + File.separator;     // Catch: Throwable -> L61
        Iterator r15 = FilesKt.walkTopDown(this.b).onEnter(new a0(this)).iterator();     // Catch: Throwable -> L61
    L27:
        if (r15.hasNext() == false) goto L59;
        File r16 = (File) r15.next();     // Catch: Throwable -> L61
        File r17 = r16.getCanonicalFile();     // Catch: Throwable -> L61
        if (Intrinsics.areEqual(r17, r13) == false) goto L31;
    L34:
        String r18 = StringsKt.replace$default(FilesKt.relativeTo(r16, this.b).getPath(), File.separatorChar, '/', false, 4, null);     // Catch: Throwable -> L61
        if (r18.length() != 0) goto L37;
        boolean r111 = true;
    L38:
        if (r111 == true) goto L27;
        PolarisFileWrapper r112 = new PolarisFileWrapper(r110, r18);     // Catch: Throwable -> L61
        if (h(r110, r112) == false) goto L42;
        if (r16.isDirectory() == true) goto L47;
        if (r16.isFile() == false) goto L57;
        if (i(r112.getParentFile()) == false) goto L54;
        FilesKt.copyTo$default(r16, r112, true, 0, 4, null);     // Catch: Throwable -> L61
        goto L27
    L54:
        g49.d.e("DoraResourceInstall", "cloud staging target parent creation failed: source=" + r16.getAbsolutePath() + ", targetParent=" + r112.getParentFile().getAbsolutePath());     // Catch: Throwable -> L61
        return false;
    L57:
        g49.d.e("DoraResourceInstall", "cloud staging source type rejected: source=" + r16.getAbsolutePath());     // Catch: Throwable -> L61
        return false;
    L47:
        if (i(r112) == true) goto L27;
        g49.d.e("DoraResourceInstall", "cloud staging target directory creation failed: source=" + r16.getAbsolutePath() + ", target=" + r112.getAbsolutePath());     // Catch: Throwable -> L61
        return false;
    L42:
        g49.d.e("DoraResourceInstall", "cloud staging target escaped root: source=" + r16.getAbsolutePath() + ", target=" + r112.getAbsolutePath());     // Catch: Throwable -> L61
        return false;
    L37:
        r111 = false;
        goto L38
    L31:
        if (StringsKt.startsWith$default(r17.getPath(), r14, false, 2, null) == true) goto L34;
        g49.d.e("DoraResourceInstall", "cloud staging source escaped root: source=" + r16.getAbsolutePath() + ", sourceCanonical=" + r17.getAbsolutePath() + ", cloudCanonical=" + r13.getAbsolutePath());     // Catch: Throwable -> L61
        return false;
    L59:
        Object r20 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L61
    L63:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L66;
        g49.d.e("DoraResourceInstall", "cloud staging copy exception: activeCloud=" + this.b.getAbsolutePath() + ", target=" + r110.getAbsolutePath() + ", type=" + r21.getClass().getSimpleName() + ", message=" + r21.getMessage());
    L66:
        Boolean r22 = Boolean.FALSE;
        if (Result.isFailure-impl(r20) == false) goto L70;
        r20 = r22;
    L70:
        return ((Boolean) r20).booleanValue();
    L61:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L71:
        g49.d.e("DoraResourceInstall", "cloud staging directory rejected: activeCloud=" + this.b.getAbsolutePath() + ", activeIsDirectory=" + this.b.isDirectory() + ", target=" + r110.getAbsolutePath() + ", targetReady=" + r2 + ", targetExists=" + r110.exists() + ", targetIsDirectory=" + r110.isDirectory());
        return false;
    L13:
        r12 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public final PolarisFileWrapper d(String r14) {
        boolean r0 = i(this.a);
        StringBuilder r1 = new StringBuilder();
        r1.append(r14);
        r1.append(" temporary root directory creation result: path=");
        r1.append(this.a.getAbsolutePath());
        r1.append(", parent=");
        File r3 = this.a.getParentFile();
        if (r3 == null) goto L5;
        String r4 = r3.getAbsolutePath();
    L6:
        r1.append(r4);
        r1.append(", ready=");
        r1.append(r0);
        r1.append(", exists=");
        r1.append(this.a.exists());
        r1.append(", isDirectory=");
        r1.append(this.a.isDirectory());
        r1.append(", canRead=");
        r1.append(this.a.canRead());
        r1.append(", canWrite=");
        r1.append(this.a.canWrite());
        g49.d.d("DoraResourceInstall", r1.toString());
        if (r0 == true) goto L10;
        g49.d.e("DoraResourceInstall", r14 + " transaction temporary root creation failed: rootPath=" + this.a.getAbsolutePath() + ", rootExists=" + this.a.exists() + ", rootIsDirectory=" + this.a.isDirectory());
        return null;
    L10:
        PolarisFileWrapper r2 = new PolarisFileWrapper(this.a, r14 + '_' + System.nanoTime());
        boolean r5 = i(r2);
        StringBuilder r10 = new StringBuilder();
        r10.append(r14);
        r10.append(" transaction directory creation result: path=");
        r10.append(r2.getAbsolutePath());
        r10.append(", parent=");
        File r6 = r2.getParentFile();
        if (r6 == null) goto L13;
        String r7 = r6.getAbsolutePath();
    L14:
        r10.append(r7);
        r10.append(", ready=");
        r10.append(r5);
        r10.append(", exists=");
        r10.append(r2.exists());
        r10.append(", isDirectory=");
        r10.append(r2.isDirectory());
        r10.append(", canRead=");
        r10.append(r2.canRead());
        r10.append(", canWrite=");
        r10.append(r2.canWrite());
        g49.d.d("DoraResourceInstall", r10.toString());
        if (r5 == true) goto L18;
        g49.d.e("DoraResourceInstall", r14 + " transaction temporary directory creation failed: temporaryRootExists=" + this.a.exists() + ", targetExists=" + r2.exists() + ", targetIsDirectory=" + r2.isDirectory());
        return null;
    L18:
        return r2;
    L13:
        r7 = null;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    public final f j(Map<DoraEnableScope, com.larus.dora.impl.resource.c> r17) {
        if (r17.isEmpty() == true) goto L14;
        Iterator<Map.Entry<DoraEnableScope, com.larus.dora.impl.resource.c>> r1 = r17.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<DoraEnableScope, com.larus.dora.impl.resource.c> r4 = r1.next();
        if (r4.getValue().a == r4.getKey()) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return null;
    L18:
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r6 = r17.values().iterator();
    L20:
        if (r6.hasNext() == false) goto L31;
        Iterator<Map.Entry<String, n>> r7 = ((com.larus.dora.impl.resource.c) r6.next()).b.entrySet().iterator();
    L23:
        if (r7.hasNext() == false) goto L20;
        Map.Entry<String, n> r8 = r7.next();
        String r9 = r8.getKey();
        n r10 = r8.getValue();
        n r11 = (n) r3.putIfAbsent(r9, r10);
        if (r11 == null) goto L23;
        if (r11.b != r10.b) goto L30;
        if (Intrinsics.areEqual(r11.d, r10.d) == true) goto L23;
    L30:
        return null;
    L31:
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r14 = CollectionsKt.sortedWith(r3.values(), new i()).iterator();
    L33:
        if (r14.hasNext() == false) goto L77;
        n r15 = (n) r14.next();
        o r16 = this.d.a(r15.a);
        int r18 = q.a;
        if (r16 == null) goto L37;
        m r20 = r16.a;
    L38:
        Intrinsics.checkNotNullParameter(r15, "manifest");
        if (r20 != null) goto L41;
        p r21 = new p(DoraResourceArtifactUpdateAction.INSTALL, new m(r15.a, r15.b, r15.d));
    L50:
        int r22 = h.a[r21.a.ordinal()];
        if (r22 != 1) goto L52;
        r12.add(new e(r15));
        goto L33
    L52:
        if (r22 != 2) goto L54;
        if (r16 == null) goto L67;
        if (g(r16, this.b) == true) goto L70;
        r12.add(new e(r15));
        goto L33
    L70:
        m r23 = r21.b;
        if (r23 == null) goto L74;
        Set<String> r24 = r16.b;
        Intrinsics.checkNotNullParameter(r23, "identity");
        Intrinsics.checkNotNullParameter(r24, "files");
        r13.add(new o(r23, r24));
        goto L33
    L74:
        throw new IllegalArgumentException("Required value was null.".toString());
    L67:
        return null;
    L54:
        if (r22 != 3) goto L56;
        if (r16 == null) goto L61;
        if (g(r16, this.b) == false) goto L64;
        r13.add(r16);
        goto L33
    L64:
        return null;
    L61:
        return null;
    L56:
        if (r22 != 4) goto L59;
        return null;
    L59:
        throw new NoWhenBranchMatchedException();
    L41:
        long r110 = r15.b;
        long r111 = r20.b;
        if (r110 <= r111) goto L44;
        r21 = new p(DoraResourceArtifactUpdateAction.INSTALL, new m(r15.a, r110, r15.d));
        goto L50
    L44:
        if (r110 >= r111) goto L47;
        r21 = new p(DoraResourceArtifactUpdateAction.KEEP_ACTIVE, null);
        goto L50
    L47:
        if (Intrinsics.areEqual(r20.c, r15.d) == false) goto L49;
        r21 = new p(DoraResourceArtifactUpdateAction.UNCHANGED, r20);
        goto L50
    L49:
        r21 = new p(DoraResourceArtifactUpdateAction.INVALID, null);
        goto L50
    L37:
        r20 = null;
        goto L38
    L77:
        LinkedHashSet r112 = new LinkedHashSet();
        Iterator r25 = r12.iterator();
    L79:
        if (r25.hasNext() == false) goto L81;
        r112.add(((e) r25.next()).a.a);
        goto L79
    L81:
        Set<DoraEnableScope> r113 = r17.keySet();
        Set<DoraEnableScope> r26 = r17.keySet();
        LinkedHashSet r114 = new LinkedHashSet();
        Iterator<T> r27 = r26.iterator();
    L83:
        if (r27.hasNext() == false) goto L85;
        CollectionsKt.addAll(r114, SetsKt.setOf(new String[]{f0.a((DoraEnableScope) r27.next()), "shared/g"}));
        goto L83
    L85:
        LinkedHashMap r115 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
        Iterator<T> r28 = r17.entrySet().iterator();
    L87:
        if (r28.hasNext() == false) goto L90;
        Map.Entry r30 = (Map.Entry) r28.next();
        r115.put(r30.getKey(), ((com.larus.dora.impl.resource.c) r30.getValue()).b.keySet());
        goto L87
    L90:
        return new f(r12, r13, r112, r113, r114, r115);
    L11:
        r5 = false;
    L14:
        r2 = false;
        goto L16
    }

    public final t39.p m(Map<DoraEnableScope, com.larus.dora.impl.resource.c> r17) {
        Set<DoraEnableScope> r0 = r17.keySet();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        if (((DoraEnableScope) r1.next()) != DoraEnableScope.G_SERIES) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        Object r6 = this.e;
        monitor-enter(r6);
        f r7 = j(r17);     // Catch: Throwable -> L227
        if (r7 != null) goto L26;
        t39.p r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.INVALID_CONFIG, null, null, 6);     // Catch: Throwable -> L227
    L201:
        monitor-exit(r6);
        return r4;
    L26:
        g49.d.d("DoraResourceInstall", "install transaction prepared: scopes=" + r17.keySet() + ", installations=" + r7.a().size() + ", retained=" + r7.b().size());     // Catch: Throwable -> L227
        if (r7.a().isEmpty() == false) goto L33;
        List<o> r5 = r7.b();     // Catch: Throwable -> L227
        c r8 = this.d;     // Catch: Throwable -> L227
        Iterator<T> r9 = r5.iterator();     // Catch: Throwable -> L227
    L30:
        if (r9.hasNext() == false) goto L32;
        r8.e((o) r9.next());     // Catch: Throwable -> L227
        goto L30
    L32:
        g49.d.d("DoraResourceInstall", "install transaction skipped: scopes=" + r17.keySet());     // Catch: Throwable -> L227
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.SKIPPED, null, r17.keySet(), 2);     // Catch: Throwable -> L227
        goto L201
    L33:
        PolarisFileWrapper r10 = d("install");     // Catch: Throwable -> L227
        if (r10 != null) goto L233;
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.INSTALL_FAILED, null, null, 6);     // Catch: Throwable -> L227
        goto L201
    L233:
        g r11 = l(r7, r10);     // Catch: Throwable -> L203
        if (Intrinsics.areEqual(r11, g.a.a) == false) goto L63;
        g49.d.e("DoraResourceInstall", "install transaction failed during download");     // Catch: Throwable -> L203
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.DOWNLOAD_FAILED, null, null, 6);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L43;
    L46:
        boolean r12 = true;
    L48:
        if (this.a.exists() == true) goto L50;
    L53:
        boolean r13 = true;
    L54:
        if (r12 == false) goto L59;
        if (r13 == false) goto L59;
        String r14 = "DoraResourceInstall";
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L198:
        g49.d.d(r14, r15.toString());     // Catch: Throwable -> L227
    L59:
        String r16 = "DoraResourceInstall";
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
    L200:
        g49.d.e(r16, r18.toString());     // Catch: Throwable -> L227
        goto L201
    L50:
        if (this.a.delete() == true) goto L53;
        r13 = false;
        goto L54
    L43:
        if (FilesKt.deleteRecursively(r10) == true) goto L46;
        r12 = false;
        goto L48
    L63:
        if (Intrinsics.areEqual(r11, g.d.a) == false) goto L86;
        g49.d.e("DoraResourceInstall", "install transaction failed during verification");     // Catch: Throwable -> L203
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.VERIFY_FAILED, null, null, 6);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L68;
    L71:
        boolean r20 = true;
    L73:
        if (this.a.exists() == true) goto L75;
    L78:
        boolean r21 = true;
    L79:
        if (r20 == false) goto L83;
        if (r21 == false) goto L83;
        r14 = "DoraResourceInstall";
        r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L83:
        r16 = "DoraResourceInstall";
        r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
        goto L200
    L75:
        if (this.a.delete() == true) goto L78;
        r21 = false;
        goto L79
    L68:
        if (FilesKt.deleteRecursively(r10) == true) goto L71;
        r20 = false;
        goto L73
    L86:
        if (Intrinsics.areEqual(r11, g.b.a) == false) goto L109;
        g49.d.e("DoraResourceInstall", "install transaction failed during staging");     // Catch: Throwable -> L203
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.INSTALL_FAILED, null, null, 6);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L91;
    L94:
        boolean r22 = true;
    L96:
        if (this.a.exists() == true) goto L98;
    L101:
        boolean r23 = true;
    L102:
        if (r22 == false) goto L106;
        if (r23 == false) goto L106;
        r14 = "DoraResourceInstall";
        r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L106:
        r16 = "DoraResourceInstall";
        r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
        goto L200
    L98:
        if (this.a.delete() == true) goto L101;
        r23 = false;
        goto L102
    L91:
        if (FilesKt.deleteRecursively(r10) == true) goto L94;
        r22 = false;
        goto L96
    L109:
        if ((r11 instanceof g.c) == false) goto L206;
        if (b(((g.c) r11).b(), r10) == true) goto L231;
        g49.d.e("DoraResourceInstall", "install transaction cloud commit failed");     // Catch: Throwable -> L203
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.INSTALL_FAILED, null, null, 6);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L116;
    L119:
        boolean r24 = true;
    L121:
        if (this.a.exists() == true) goto L123;
    L126:
        boolean r25 = true;
    L127:
        if (r24 == false) goto L131;
        if (r25 == false) goto L131;
        r14 = "DoraResourceInstall";
        r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L131:
        r16 = "DoraResourceInstall";
        r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
        goto L200
    L123:
        if (this.a.delete() == true) goto L126;
        r25 = false;
        goto L127
    L116:
        if (FilesKt.deleteRecursively(r10) == true) goto L119;
        r24 = false;
        goto L121
    L231:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L143
        List<o> r27 = r7.b();     // Catch: Throwable -> L143
        c r110 = this.d;     // Catch: Throwable -> L143
        Iterator<T> r28 = r27.iterator();     // Catch: Throwable -> L143
    L135:
        if (r28.hasNext() == false) goto L137;
        r110.e((o) r28.next());     // Catch: Throwable -> L143
        goto L135
    L137:
        List<o> r30 = ((g.c) r11).a();     // Catch: Throwable -> L143
        c r111 = this.d;     // Catch: Throwable -> L143
        Iterator<T> r31 = r30.iterator();     // Catch: Throwable -> L143
    L139:
        if (r31.hasNext() == false) goto L141;
        r111.e((o) r31.next());     // Catch: Throwable -> L143
        goto L139
    L141:
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L143
    L145:
        Throwable r112 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L203
        if (r112 == null) goto L157;
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L203
        r113.append("install version state persistence failed after cloud commit: activeCloud=");     // Catch: Throwable -> L203
        r113.append(this.b.getAbsolutePath());     // Catch: Throwable -> L203
        r113.append(", retainedPackages=");     // Catch: Throwable -> L203
        List<o> r114 = r7.b();     // Catch: Throwable -> L203
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));     // Catch: Throwable -> L203
        Iterator<T> r33 = r114.iterator();     // Catch: Throwable -> L203
    L149:
        if (r33.hasNext() == false) goto L151;
        r115.add(((o) r33.next()).a().a());     // Catch: Throwable -> L203
        goto L149
    L151:
        r113.append(r115);     // Catch: Throwable -> L203
        r113.append(", installedPackages=");     // Catch: Throwable -> L203
        List<o> r34 = ((g.c) r11).a();     // Catch: Throwable -> L203
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));     // Catch: Throwable -> L203
        Iterator<T> r35 = r34.iterator();     // Catch: Throwable -> L203
    L153:
        if (r35.hasNext() == false) goto L155;
        r116.add(((o) r35.next()).a().a());     // Catch: Throwable -> L203
        goto L153
    L155:
        r113.append(r116);     // Catch: Throwable -> L203
        r113.append(", type=");     // Catch: Throwable -> L203
        r113.append(r112.getClass().getSimpleName());     // Catch: Throwable -> L203
        r113.append(", message=");     // Catch: Throwable -> L203
        r113.append(r112.getMessage());     // Catch: Throwable -> L203
        g49.d.e("DoraResourceInstall", r113.toString());     // Catch: Throwable -> L203
    L157:
        if (Result.isSuccess-impl(r32) == true) goto L179;
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.INSTALL_FAILED, null, null, 6);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L162;
    L165:
        boolean r36 = true;
    L167:
        if (this.a.exists() == true) goto L169;
    L172:
        boolean r37 = true;
    L173:
        if (r36 == false) goto L177;
        if (r37 == false) goto L177;
        r14 = "DoraResourceInstall";
        r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L177:
        r16 = "DoraResourceInstall";
        r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
        goto L200
    L169:
        if (this.a.delete() == true) goto L172;
        r37 = false;
        goto L173
    L162:
        if (FilesKt.deleteRecursively(r10) == true) goto L165;
        r36 = false;
        goto L167
    L179:
        g49.d.d("DoraResourceInstall", "install transaction committed: scopes=" + r17.keySet() + ", activeCloud=" + this.b.getAbsolutePath() + ", retained=" + r7.b().size() + ", installed=" + ((g.c) r11).a().size());     // Catch: Throwable -> L203
        r4 = k(this, IDoraService.Debug.ResourceConfigSyncStatus.SUCCESS, r17.keySet(), null, 4);     // Catch: Throwable -> L203
        if (r10.exists() == true) goto L183;
    L186:
        boolean r38 = true;
    L188:
        if (this.a.exists() == true) goto L190;
    L193:
        boolean r40 = true;
    L194:
        if (r38 == false) goto L199;
        if (r40 == false) goto L199;
        r14 = "DoraResourceInstall";
        r15 = new StringBuilder();     // Catch: Throwable -> L227
        r15.append("install transaction cleanup completed: transaction=");     // Catch: Throwable -> L227
        r15.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r15.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r15.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L199:
        r16 = "DoraResourceInstall";
        r18 = new StringBuilder();     // Catch: Throwable -> L227
        r18.append("install transaction cleanup incomplete: transaction=");     // Catch: Throwable -> L227
        r18.append(r10.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", transactionExists=");     // Catch: Throwable -> L227
        r18.append(r10.exists());     // Catch: Throwable -> L227
        r18.append(", temporaryRoot=");     // Catch: Throwable -> L227
        r18.append(this.a.getAbsolutePath());     // Catch: Throwable -> L227
        r18.append(", temporaryRootExists=");     // Catch: Throwable -> L227
        r18.append(this.a.exists());     // Catch: Throwable -> L227
        goto L200
    L190:
        if (this.a.delete() == true) goto L193;
        r40 = false;
        goto L194
    L183:
        if (FilesKt.deleteRecursively(r10) == true) goto L186;
        r38 = false;
        goto L188
    L143:
        th = move-exception;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L203
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L203
        goto L145
    L206:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L203
    L203:
        th = move-exception;
        if (r10.exists() == true) goto L210;
    L213:
        boolean r41 = true;
    L215:
        if (this.a.exists() == true) goto L217;
    L220:
        boolean r42 = true;
    L221:
        if (r41 == false) goto L225;
        if (r42 == false) goto L225;
        g49.d.d("DoraResourceInstall", "install transaction cleanup completed: transaction=" + r10.getAbsolutePath() + ", temporaryRoot=" + this.a.getAbsolutePath());     // Catch: Throwable -> L227
    L226:
        throw th;     // Catch: Throwable -> L227
    L225:
        g49.d.e("DoraResourceInstall", "install transaction cleanup incomplete: transaction=" + r10.getAbsolutePath() + ", transactionExists=" + r10.exists() + ", temporaryRoot=" + this.a.getAbsolutePath() + ", temporaryRootExists=" + this.a.exists());     // Catch: Throwable -> L227
        goto L226
    L217:
        if (this.a.delete() == true) goto L220;
        r42 = false;
        goto L221
    L210:
        if (FilesKt.deleteRecursively(r10) == true) goto L213;
        r41 = false;
    L227:
        th = move-exception;
        throw th;
    L20:
        return k(this, IDoraService.Debug.ResourceConfigSyncStatus.INVALID_CONFIG, null, null, 6);
    L13:
        r2 = false;
    L16:
        r3 = false;
        goto L18
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final t39.p n(com.larus.dora.impl.resource.g r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        if ((!r3.b.isEmpty()) == false) goto L7;
        return k(this, IDoraService.Debug.ResourceConfigSyncStatus.INVALID_CONFIG, null, null, 6);
    L7:
        return m(r3.a);
    }

    public static d e(n r27, PolarisFileWrapper r28) {
        String r2 = ", message=";
        String r3 = ", type=";
        StringBuilder r8 = new StringBuilder("download start: artifact=");
        r8.append(StringsKt.takeLast(r27.a, 12));
        String r9 = ", version=";
        r8.append(", version=");
        r8.append(r27.b);
        r8.append(", url=");
        r8.append(StringsKt.substringBefore$default(r27.f, '?', null, 2, null));
        r8.append(", hasSignedQuery=");
        r8.append(StringsKt.contains$default(r27.f, '?', false, 2, null));
        r8.append(", target=");
        r8.append(r28.getAbsolutePath());
        g49.d.d("DoraResourceInstall", r8.toString());
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L116
        Object r11 = com.larus.dora.api.network.a.a(com.larus.dora.api.network.a.a, r27.f);     // Catch: Throwable -> L116
        if ((r11 instanceof a$a.a) == false) goto L9;
        g49.d.e("DoraResourceInstall", "download http failed: artifact=" + StringsKt.takeLast(r27.a, 12) + ", code=" + ((a$a.a) r11).a + ", target=" + r28.getAbsolutePath());     // Catch: Throwable -> L116
        return d.a.a;
    L9:
        if ((r11 instanceof a$a.b) == false) goto L146;
        g49.d.e("DoraResourceInstall", "download request failed: artifact=" + StringsKt.takeLast(r27.a, 12) + ", type=" + ((a$a.b) r11).a.getClass().getSimpleName() + ", statusCode=" + ((a$a.b) r11).b + ", internalErrorCode=" + ((a$a.b) r11).c + ", message=" + ((a$a.b) r11).a.getMessage() + ", target=" + r28.getAbsolutePath());     // Catch: Throwable -> L116
        return d.a.a;
    L146:
        if ((r11 instanceof a$a.c) == false) goto L113;
        Closeable r12 = (Closeable) r11;     // Catch: Throwable -> L116
        a$a.c r6 = (a$a.c) r12;     // Catch: Throwable -> L103
        g49.d.d("DoraResourceInstall", "download stream opened: artifact=" + StringsKt.takeLast(r27.a, 12) + ", code=" + r6.a + ", contentLength=" + r6.b + ", target=" + r28.getAbsolutePath());     // Catch: Throwable -> L103
        if (r6.b <= 268435456) goto L21;
        g49.d.e("DoraResourceInstall", "download rejected by archive size limit: artifact=" + StringsKt.takeLast(r27.a, 12) + ", contentLength=" + r6.b + ", maxBytes=268435456, target=" + r28.getAbsolutePath());     // Catch: Throwable -> L103
        d.c r0 = d.c.a;     // Catch: Throwable -> L103
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L116
        return r0;
    L21:
        MessageDigest r1 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L103
        Ref.LongRef r4 = new Ref.LongRef();     // Catch: Throwable -> L103
        InputStream r7 = r6.c;     // Catch: Throwable -> L103
        if ((r7 instanceof BufferedInputStream) == false) goto L25;
        BufferedInputStream r13 = (BufferedInputStream) r7;     // Catch: Throwable -> L103
    L165:
        BufferedOutputStream r14 = new PolarisFileOutputStreamWrapper(r28);     // Catch: Throwable -> L91
        if ((r14 instanceof BufferedOutputStream) == false) goto L32;
        BufferedOutputStream r15 = r14;     // Catch: Throwable -> L91
    L144:
        byte[] r16 = new byte[16384];     // Catch: Throwable -> L81
    L35:
        int r17 = r13.read(r16);     // Catch: Throwable -> L81
        if (r17 < 0) goto L38;
        String r18 = r2;
        String r110 = r3;
        String r21 = r9;
        byte[] r20 = r16;
        long r5 = r4.element + ((long) r17);     // Catch: Throwable -> L79
        r4.element = r5;     // Catch: Throwable -> L79
        if (r5 <= 268435456) goto L136;
        g49.d.e("DoraResourceInstall", "download exceeded archive size limit: artifact=" + StringsKt.takeLast(r27.a, 12) + ", bytes=" + r4.element + ", maxBytes=268435456, target=" + r28.getAbsolutePath());     // Catch: Throwable -> L72
        d.c r22 = d.c.a;     // Catch: Throwable -> L72
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L70
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L66
        return r22;
    L66:
        th = th;
    L120:
        Result.Companion r23 = Result.Companion;
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L121:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L133;
        if (r28.exists() == true) goto L127;
    L130:
        boolean r26 = true;
    L131:
        g49.d.e("DoraResourceInstall", "download exception: artifact=" + StringsKt.takeLast(r27.a, 12) + ", target=" + r28.getAbsolutePath() + ", targetExists=" + r28.exists() + ", archiveDeleted=" + r26 + r110 + r25.getClass().getSimpleName() + r18 + r25.getMessage());
        r24 = d.a.a;
        goto L133
    L127:
        if (r28.delete() == true) goto L130;
        r26 = false;
    L133:
        return (d) r24;
    L68:
        th = move-exception;
        Throwable r30 = th;
    L158:
        throw r30;     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        CloseableKt.closeFinally(r12, r30);     // Catch: Throwable -> L114
        throw th;     // Catch: Throwable -> L114
    L70:
        th = move-exception;
        Throwable r31 = th;
    L138:
        throw r31;     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        CloseableKt.closeFinally(r13, r31);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L101:
        th = th;
    L106:
        r30 = th;
    L72:
        th = move-exception;
        Throwable r32 = th;
    L154:
        throw r32;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        CloseableKt.closeFinally(r15, r32);     // Catch: Throwable -> L89
        throw th;     // Catch: Throwable -> L89
    L89:
        th = th;
    L95:
        r31 = th;
        goto L138
    L136:
        r15.write(r20, 0, r17);     // Catch: Throwable -> L77
        r1.update(r20, 0, r17);     // Catch: Throwable -> L77
        r16 = r20;
        r2 = r18;
        r3 = r110;
        r9 = r21;
    L77:
        th = th;
    L83:
        r32 = th;
    L79:
        th = th;
        goto L83
    L38:
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L81
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L91
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L54
        String r34 = ArraysKt.joinToString$default(r1.digest(), "", null, null, 0, null, new b0(), 30, null);     // Catch: Throwable -> L54
        String r35 = r27.d.toLowerCase(Locale.US);     // Catch: Throwable -> L54
        if (Intrinsics.areEqual(r34, r35) == true) goto L50;
        g49.d.e("DoraResourceInstall", "download sha256 verification failed: artifact=" + StringsKt.takeLast(r27.a, 12) + ", expected=" + r35 + ", calculated=" + r34 + ", archive=" + r28.getAbsolutePath());     // Catch: Throwable -> L54
        d.c r36 = d.c.a;     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L48
        return r36;
    L50:
        g49.d.d("DoraResourceInstall", "download verified: artifact=" + StringsKt.takeLast(r27.a, 12) + r9 + r27.b + ", bytes=" + r4.element + ", sha256=" + r34 + ", archive=" + r28.getAbsolutePath());     // Catch: Throwable -> L54
        d.b r37 = d.b.a;     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L48
        r24 = Result.constructor-impl(r37);     // Catch: Throwable -> L48
        r18 = r2;
        r110 = r3;
    L48:
        th = th;
    L118:
        r18 = r2;
        r110 = r3;
    L54:
        th = th;
    L105:
        r18 = r2;
        r110 = r3;
    L81:
        th = th;
        r18 = r2;
        r110 = r3;
        goto L83
    L32:
        r15 = new BufferedOutputStream(r14, 8192);     // Catch: Throwable -> L91
    L91:
        th = th;
    L92:
        r18 = r2;
        r110 = r3;
    L93:
        th = th;
        goto L92
    L25:
        r13 = new BufferedInputStream(r7, 8192);     // Catch: Throwable -> L103
    L103:
        th = th;
        goto L105
    L113:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L114
    L114:
        th = th;
    L116:
        th = th;
        goto L118
    }

    public static boolean g(o r7, PolarisFileWrapper r8) {
        if ((!r7.b.isEmpty()) == false) goto L25;
        Set<String> r9 = r7.b;
        if ((r9 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L22;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r8, (String) r10.next());
        if (h(r8, r3) == true) goto L15;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == true) goto L11;
        boolean r11 = false;
    L23:
        if (r11 == false) goto L25;
        return true;
    L15:
        if (r3.isFile() == false) goto L19;
        if (r3.length() <= 0) goto L19;
        r0 = true;
    L22:
        r11 = true;
        goto L23
    L7:
        if (r9.isEmpty() == false) goto L9;
    L25:
        return false;
    }

    public static boolean h(PolarisFileWrapper r3, PolarisFileWrapper r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Boolean.valueOf(StringsKt.startsWith$default(r4.getCanonicalFile().getPath(), r3.getCanonicalFile().getPath() + File.separator, false, 2, null)));     // Catch: Throwable -> L4
    L6:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = r6;
    L10:
        return ((Boolean) r5).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static String o(String r16, Set r17) {
        boolean r7 = false;
        int r8 = 2;
        if (StringsKt.startsWith$default(r16, '/', false, 2, null) == false) goto L5;
    L58:
        return null;
    L5:
        if (StringsKt.contains$default(r16, '\\', false, 2, null) == true) goto L58;
        String r0 = StringsKt.replace$default(r16, '\\', '/', false, 4, null);
        List r2 = StringsKt.split$default(r0, new char[]{'/'}, false, 0, 6, null);
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L10;
    L12:
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L26;
        String r5 = (String) r4.next();
        if (StringsKt.isBlank(r5) == false) goto L18;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L14;
        r7 = true;
        goto L26
    L18:
        if (Intrinsics.areEqual(r5, ".") == true) goto L23;
        if (Intrinsics.areEqual(r5, "..") == true) goto L23;
        r6 = false;
    L26:
        if (r7 == false) goto L28;
        return null;
    L28:
        String r9 = (String) CollectionsKt.first(r2);
        int r10 = r9.hashCode();
        if (r10 == (-903566235)) goto L43;
        if (r10 == 3242) goto L39;
        if (r10 == 3243) goto L36;
    L44:
        return null;
    L36:
        if (r9.equals(DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2) == false) goto L44;
    L41:
        String r11 = (String) CollectionsKt.first(r2);
    L50:
        if (r17.contains(r11) == false) goto L58;
        int r12 = r2.size();
        if (Intrinsics.areEqual(r11, "shared/g") == true) goto L55;
        r8 = 1;
    L55:
        if (r12 <= r8) goto L58;
        return r0;
    L39:
        if (r9.equals(DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1) == true) goto L41;
    L43:
        if (r9.equals("shared") == false) goto L44;
        if (Intrinsics.areEqual(CollectionsKt.getOrNull(r2, 1), "g") == true) goto L48;
        return null;
    L48:
        r11 = "shared/g";
        goto L50
    L10:
        if (r3.isEmpty() == false) goto L12;
        goto L12
    }

    public final boolean b(File r20, PolarisFileWrapper r21) {
        File r10 = new PolarisFileWrapper(r21, "cloud_backup");
        boolean r11 = this.b.exists();
        g49.d.d("DoraResourceInstall", "cloud commit directory layout: stagedCloud=" + r20.getAbsolutePath() + ", resourceRoot=" + this.c.getAbsolutePath() + ", activeCloud=" + this.b.getAbsolutePath() + ", backupCloud=" + r10.getAbsolutePath() + ", activeCloudExists=" + r11);
        boolean r12 = i(this.c);     // Catch: Exception -> L54
        g49.d.d("DoraResourceInstall", "resource root directory creation result: path=" + this.c.getAbsolutePath() + ", ready=" + r12 + ", exists=" + this.c.exists() + ", isDirectory=" + this.c.isDirectory() + ", canWrite=" + this.c.canWrite());     // Catch: Exception -> L54
        if (r12 == true) goto L8;
        g49.d.e("DoraResourceInstall", "cloud commit failed: reason=resource_root_not_ready, resourceRoot=" + this.c.getAbsolutePath() + ", stagedCloud=" + r20.getAbsolutePath() + ", activeCloud=" + this.b.getAbsolutePath());     // Catch: Exception -> L54
        return false;
    L8:
        if (r11 == false) goto L18;
    L52:
        e = e;
        String r6 = ", activeCloud=";
    L57:
        if (r10.exists() == true) goto L59;
    L61:
        boolean r5 = false;
    L62:
        if (r5 == true) goto L64;
    L67:
        boolean r13 = true;
    L68:
        g49.d.e("DoraResourceInstall", "cloud commit exception: stagedCloud=" + r20.getAbsolutePath() + ", stagedExists=" + r20.exists() + r6 + this.b.getAbsolutePath() + ", activeExists=" + this.b.exists() + ", backupCloud=" + r10.getAbsolutePath() + ", backupExists=" + r10.exists() + ", rollbackRequired=" + r5 + ", rollbackSucceeded=" + r13 + ", type=" + e.getClass().getSimpleName() + ", message=" + e.getMessage());
        return false;
    L64:
        if (r10.renameTo(this.b) == true) goto L67;
        r13 = false;
        goto L68
    L59:
        if (this.b.exists() == true) goto L61;
        r5 = true;
        goto L62
    L10:
        if (this.b.renameTo(r10) == true) goto L18;
        StringBuilder r0 = new StringBuilder("active cloud backup failed: source=");     // Catch: Exception -> L52
        r0.append(this.b.getAbsolutePath());     // Catch: Exception -> L52
        r0.append(", sourceExists=");     // Catch: Exception -> L52
        r0.append(this.b.exists());     // Catch: Exception -> L52
        r0.append(", sourceIsDirectory=");     // Catch: Exception -> L52
        r0.append(this.b.isDirectory());     // Catch: Exception -> L52
        r0.append(", sourceCanRead=");     // Catch: Exception -> L52
        r0.append(this.b.canRead());     // Catch: Exception -> L52
        r0.append(", sourceCanWrite=");     // Catch: Exception -> L52
        r0.append(this.b.canWrite());     // Catch: Exception -> L52
        r0.append(", target=");     // Catch: Exception -> L52
        r0.append(r10.getAbsolutePath());     // Catch: Exception -> L52
        r0.append(", targetParent=");     // Catch: Exception -> L52
        File r7 = r10.getParentFile();     // Catch: Exception -> L52
        if (r7 == null) goto L14;
        String r8 = r7.getAbsolutePath();     // Catch: Exception -> L52
    L15:
        r0.append(r8);     // Catch: Exception -> L52
        r0.append(", targetExists=");     // Catch: Exception -> L52
        r0.append(r10.exists());     // Catch: Exception -> L52
        g49.d.e("DoraResourceInstall", r0.toString());     // Catch: Exception -> L52
        return false;
    L14:
        r8 = null;
    L18:
        if (r20.renameTo(this.b) == true) goto L38;
        if (r10.exists() == true) goto L22;
    L24:
        boolean r9 = false;
    L25:
        if (r9 == true) goto L27;
    L30:
        boolean r14 = true;
    L31:
        StringBuilder r15 = new StringBuilder("staged cloud commit failed: source=");     // Catch: Exception -> L52
        r15.append(r20.getAbsolutePath());     // Catch: Exception -> L52
        r15.append(", sourceExists=");     // Catch: Exception -> L52
        r15.append(r20.exists());     // Catch: Exception -> L52
        r15.append(", sourceIsDirectory=");     // Catch: Exception -> L52
        r15.append(r20.isDirectory());     // Catch: Exception -> L52
        r15.append(", target=");     // Catch: Exception -> L52
        r15.append(this.b.getAbsolutePath());     // Catch: Exception -> L52
        r15.append(", targetExists=");     // Catch: Exception -> L52
        r15.append(this.b.exists());     // Catch: Exception -> L52
        r15.append(", targetParent=");     // Catch: Exception -> L52
        File r1 = this.b.getParentFile();     // Catch: Exception -> L52
        if (r1 == null) goto L34;
        String r16 = r1.getAbsolutePath();     // Catch: Exception -> L52
    L35:
        r15.append(r16);     // Catch: Exception -> L52
        r15.append(", backup=");     // Catch: Exception -> L52
        r15.append(r10.getAbsolutePath());     // Catch: Exception -> L52
        r15.append(", backupExists=");     // Catch: Exception -> L52
        r15.append(r10.exists());     // Catch: Exception -> L52
        r15.append(", rollbackRequired=");     // Catch: Exception -> L52
        r15.append(r9);     // Catch: Exception -> L52
        r15.append(", rollbackSucceeded=");     // Catch: Exception -> L52
        r15.append(r14);     // Catch: Exception -> L52
        g49.d.e("DoraResourceInstall", r15.toString());     // Catch: Exception -> L52
        return false;
    L34:
        r16 = null;
        goto L35
    L27:
        if (r10.renameTo(this.b) == true) goto L30;
        r14 = false;
        goto L31
    L22:
        if (this.b.exists() == true) goto L24;
        r9 = true;
        goto L25
    L38:
        if (r10.exists() == true) goto L40;
    L43:
        boolean r2 = true;
    L44:
        if (r2 == true) goto L46;
        g49.d.e("DoraResourceInstall", "cloud commit completed with backup cleanup failure: activeCloud=" + this.b.getAbsolutePath() + ", backupCloud=" + r10.getAbsolutePath() + ", backupExists=" + r10.exists());     // Catch: Exception -> L52
    L49:
        return true;
    L46:
        StringBuilder r17 = new StringBuilder("cloud commit completed: stagedCloud=");     // Catch: Exception -> L52
        r17.append(r20.getAbsolutePath());     // Catch: Exception -> L52
        r6 = ", activeCloud=";
        r17.append(r6);     // Catch: Exception -> L50
        r17.append(this.b.getAbsolutePath());     // Catch: Exception -> L50
        r17.append(", backupCloud=");     // Catch: Exception -> L50
        r17.append(r10.getAbsolutePath());     // Catch: Exception -> L50
        r17.append(", backupDeleted=");     // Catch: Exception -> L50
        r17.append(r2);     // Catch: Exception -> L50
        g49.d.d("DoraResourceInstall", r17.toString());     // Catch: Exception -> L50
    L50:
        e = e;
        goto L57
    L40:
        if (FilesKt.deleteRecursively(r10) == true) goto L43;
        r2 = false;
    L54:
        e = e;
        r6 = ", activeCloud=";
        goto L57
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v15, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r19v19 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v20 */
    /* JADX WARN: Type inference failed for: r19v21 */
    /* JADX WARN: Type inference failed for: r19v22 */
    /* JADX WARN: Type inference failed for: r19v23 */
    /* JADX WARN: Type inference failed for: r19v24 */
    /* JADX WARN: Type inference failed for: r19v25 */
    /* JADX WARN: Type inference failed for: r19v26 */
    /* JADX WARN: Type inference failed for: r19v27 */
    /* JADX WARN: Type inference failed for: r19v28 */
    /* JADX WARN: Type inference failed for: r19v29 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v44 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v48 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v8 */
    public final g l(f r35, PolarisFileWrapper r36) {
        f r2 = r35;
        File r4 = new PolarisFileWrapper(r36, "cloud");
        StringBuilder r0 = new StringBuilder("install directory layout: temporaryRoot=");
        r0.append(this.a.getAbsolutePath());
        r0.append(", transaction=");
        r0.append(r36.getAbsolutePath());
        String r5 = ", stagedCloud=";
        r0.append(", stagedCloud=");
        r0.append(r4.getAbsolutePath());
        r0.append(", resourceRoot=");
        r0.append(this.c.getAbsolutePath());
        r0.append(", activeCloud=");
        r0.append(this.b.getAbsolutePath());
        String r6 = "DoraResourceInstall";
        g49.d.d("DoraResourceInstall", r0.toString());
        Map<String, o> r7 = this.d.b();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, o>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry<String, o> r9 = r8.next();
        if ((true ^ r2.c.contains(r9.getKey())) == false) goto L4;
        r1.put(r9.getKey(), r9.getValue());
        goto L4
    L8:
        ?? r10 = r1.values();
        StringBuilder r3 = new StringBuilder("install staging preparation: activePackages=");
        r3.append(r7.size());
        r3.append(", replacingPackages=");
        r3.append(r2.c.size());
        String r11 = ", retainedPackages=";
        r3.append(", retainedPackages=");
        r3.append(r10.size());
        r3.append(", target=");
        r3.append(r4.getAbsolutePath());
        g49.d.d("DoraResourceInstall", r3.toString());
        String r15 = ", message=";
        String r14 = ", type=";
        String r12 = ", files=";
        if (i(r4) == true) goto L11;
        g49.d.e("DoraResourceInstall", "retained artifact target directory creation failed: path=" + r4.getAbsolutePath());
        Map<String, o> r22 = r7;
        String r23 = ", files=";
        ?? r13 = r10;
    L28:
        boolean r16 = false;
        ?? r17 = r13;
    L29:
        r5 = r5;
        ?? r18 = "DoraResourceInstall";
        ?? r110 = r17;
        String r30 = r11;
        String r20 = r14;
        String r21 = r15;
        long r111 = 0;
    L89:
        if (r16 == true) goto L92;
        g49.d.e(r18, "install staging copy of retained artifact files failed: activeCloud=" + this.b.getAbsolutePath() + r5 + r4.getAbsolutePath() + r30 + r110.size());
        return g.b.a;
    L92:
        String r24 = r5;
        g49.d.d(r18, "install staged cloud directory ready: path=" + r4.getAbsolutePath() + ", exists=" + r4.exists() + ", isDirectory=" + r4.isDirectory() + ", canRead=" + r4.canRead() + ", canWrite=" + r4.canWrite());
        if (r4.isDirectory() == true) goto L202;
        g49.d.e(r18, "cloud file enumeration failed: reason=root_not_directory, path=" + r4.getAbsolutePath() + ", exists=" + r4.exists() + ", isFile=" + r4.isFile() + ", canRead=" + r4.canRead());
        Set r25 = null;
    L110:
        if (r25 != null) goto L113;
        g49.d.e(r18, "install staging could not enumerate existing cloud files: path=" + r4.getAbsolutePath() + ", exists=" + r4.exists() + ", isDirectory=" + r4.isDirectory() + ", canRead=" + r4.canRead());
        return g.b.a;
    L113:
        g49.d.d(r18, "install staging enumeration completed: path=" + r4.getAbsolutePath() + ", existingFiles=" + r25.size());
        File r26 = new PolarisFileWrapper(r36, "archives");
        boolean r27 = i(r26);
        StringBuilder r28 = new StringBuilder("install archive directory creation result: path=");
        r28.append(r26.getAbsolutePath());
        r28.append(", parent=");
        File r112 = r26.getParentFile();
        if (r112 == null) goto L116;
        String r113 = r112.getAbsolutePath();
    L117:
        r28.append(r113);
        r28.append(", created=");
        r28.append(r27);
        r28.append(", exists=");
        r28.append(r26.exists());
        r28.append(", isDirectory=");
        r28.append(r26.isDirectory());
        r28.append(", canWrite=");
        r28.append(r26.canWrite());
        g49.d.d(r18, r28.toString());
        if (r27 == true) goto L125;
        StringBuilder r31 = new StringBuilder("install staging archive directory creation failed: path=");
        r31.append(r26.getAbsolutePath());
        r31.append(", parent=");
        File r32 = r26.getParentFile();
        if (r32 == null) goto L122;
        String r114 = r32.getAbsolutePath();
    L123:
        r31.append(r114);
        r31.append(", exists=");
        r31.append(r26.exists());
        r31.append(", isDirectory=");
        r31.append(r26.isDirectory());
        r31.append(", canWrite=");
        r31.append(r26.canWrite());
        g49.d.e(r18, r31.toString());
        return g.b.a;
    L122:
        r114 = null;
        goto L123
    L125:
        LinkedHashMap r33 = new LinkedHashMap();
        ArrayList r34 = new ArrayList();
        Set<String> r37 = r35.e;
        Iterator r115 = r35.a.iterator();
        long r116 = r111;
        int r117 = 0;
    L127:
        if (r115.hasNext() == false) goto L156;
        n r38 = ((e) r115.next()).a;
        Iterator r310 = r115;
        File r118 = (File) r33.get(r38.d);
        String r311 = r24;
        if (r118 == null) goto L131;
        g49.d.d(r18, "reuse downloaded archive: artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b);
        File r119 = r118;
    L134:
        g49.d.d(r18, "archive extraction started: artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b + ", archive=" + r119.getAbsolutePath() + ", target=" + r4.getAbsolutePath() + ", allowedRoots=" + r37 + ", occupiedFiles=" + r25.size());
        a r40 = f(r119, r4, r37, r25);
        if (r40 == null) goto L136;
        StringBuilder r41 = new StringBuilder("archive extracted: artifact=");
        r41.append(StringsKt.takeLast(r38.a, 12));
        r41.append(", version=");
        r41.append(r38.b);
        r41.append(", archive=");
        r41.append(r119.getAbsolutePath());
        r41.append(", target=");
        r41.append(r4.getAbsolutePath());
        String r42 = r23;
        r41.append(r42);
        r41.append(r40.a.size());
        r41.append(", bytes=");
        r41.append(r40.b);
        g49.d.d(r18, r41.toString());
        r116 = r116 + r40.b;
        r117 = r117 + r40.a.size();
        if (r116 > 805306368) goto L144;
        if (r117 > 10000) goto L144;
        File r210 = r4;
        ArrayList r43 = r34;
        r43.add(new o(new m(r38.a, r38.b, r38.d), r40.a));
        r115 = r310;
        r34 = r43;
        r26 = r26;
        r33 = r33;
        r4 = r210;
        r23 = r42;
        r24 = r311;
    L144:
        g49.d.e(r18, "install transaction extraction limit exceeded: bytes=" + r116 + r42 + r117 + ", maxBytes=805306368, maxFiles=10000, artifact=" + StringsKt.takeLast(r38.a, 12) + ", archive=" + r119.getAbsolutePath());
        return g.d.a;
    L136:
        g49.d.e(r18, "archive extraction failed: artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b + ", archive=" + r119.getAbsolutePath() + ", target=" + r4.getAbsolutePath());
        return g.d.a;
    L131:
        r119 = new PolarisFileWrapper(r26, r38.d + ".zip");
        g49.d.d(r18, "archive download scheduled: artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b + ", expectedSha256=" + r38.d + ", target=" + r119.getAbsolutePath());
        d r44 = e(r38, r119);
        if (Intrinsics.areEqual(r44, d.b.a) == false) goto L147;
        r33.put(r38.d, r119);
        goto L134
    L147:
        if (Intrinsics.areEqual(r44, d.a.a) == false) goto L151;
        g49.d.e(r18, "archive staging failed: stage=download, artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b + ", target=" + r119.getAbsolutePath());
        return g.a.a;
    L151:
        if (Intrinsics.areEqual(r44, d.c.a) == false) goto L155;
        g49.d.e(r18, "archive staging failed: stage=download_verification, artifact=" + StringsKt.takeLast(r38.a, 12) + ", version=" + r38.b + ", target=" + r119.getAbsolutePath());
        return g.d.a;
    L155:
        throw new NoWhenBranchMatchedException();
    L156:
        String r312 = r24;
        File r211 = r4;
        ArrayList r45 = r34;
        g49.d.d(r18, "install transaction extraction completed: target=" + r211.getAbsolutePath() + ", archives=" + r33.size() + ", artifacts=" + r45.size() + r23 + r117 + ", bytes=" + r116);
        LinkedHashMap r46 = new LinkedHashMap();
        Iterator<Map.Entry<String, o>> r47 = r22.entrySet().iterator();
    L158:
        if (r47.hasNext() == false) goto L162;
        Map.Entry<String, o> r48 = r47.next();
        if ((!r35.c.contains(r48.getKey())) == false) goto L158;
        r46.put(r48.getKey(), r48.getValue());
        goto L158
    L162:
        Map r50 = MapsKt.toMutableMap(r46);
        Iterator r51 = r35.b.iterator();
    L164:
        if (r51.hasNext() == false) goto L166;
        o r52 = (o) r51.next();
        r50.put(r52.a.a, r52);
        goto L164
    L166:
        Iterator r53 = r45.iterator();
    L168:
        if (r53.hasNext() == false) goto L170;
        o r54 = (o) r53.next();
        r50.put(r54.a.a, r54);
        goto L168
    L170:
        Set<DoraEnableScope> r55 = r35.d;
        if ((r55 instanceof Collection) == true) goto L173;
    L175:
        Iterator r56 = r55.iterator();
    L177:
        if (r56.hasNext() == false) goto L187;
        DoraEnableScope r57 = (DoraEnableScope) r56.next();
        Iterator r58 = SequencesKt.flatMap(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) MapsKt.getValue(r35.f, r57)), new DoraResourcePackageSynchronizer$stageTransaction$hasAllDeviceSpecificResources$1$1(r50)), new z()).iterator();
    L180:
        if (r58.hasNext() == false) goto L184;
        if (StringsKt.startsWith$default((String) r58.next(), f0.a(r57).concat("/"), false, 2, null) == false) goto L180;
        boolean r60 = true;
    L185:
        if (r60 == true) goto L177;
        boolean r120 = false;
    L188:
        if (r120 == true) goto L192;
        g49.d.e(r18, "install transaction missing device-specific resources after extraction: expectedScopes=" + r35.d + ", artifactsByScope=" + r35.f + ", activePackages=" + r50.keySet() + r312 + r211.getAbsolutePath());
        return g.d.a;
    L192:
        return new g.c(r211, r45);
    L184:
        r60 = false;
    L187:
        r120 = true;
        goto L188
    L173:
        if (r55.isEmpty() == false) goto L175;
    L116:
        r113 = null;
        goto L117
    L202:
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L101
        Sequence r62 = SequencesKt.filter(FilesKt.walkTopDown(r4), new c0());     // Catch: Throwable -> L101
        LinkedHashSet r121 = new LinkedHashSet();     // Catch: Throwable -> L101
        Iterator r63 = r62.iterator();     // Catch: Throwable -> L101
    L97:
        if (r63.hasNext() == false) goto L99;
        r121.add(StringsKt.replace$default(FilesKt.relativeTo((File) r63.next(), r4).getPath(), File.separatorChar, '/', false, 4, null));     // Catch: Throwable -> L101
        goto L97
    L99:
        Object r64 = Result.constructor-impl(r121);     // Catch: Throwable -> L101
    L103:
        Throwable r122 = Result.exceptionOrNull-impl(r64);
        if (r122 == null) goto L107;
        g49.d.e(r18, "cloud file enumeration exception: path=" + r4.getAbsolutePath() + r20 + r122.getClass().getSimpleName() + r21 + r122.getMessage());
    L107:
        if (Result.isFailure-impl(r64) == false) goto L109;
        r64 = null;
    L109:
        r25 = (Set) r64;
    L101:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r64 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L11:
        StringBuilder r65 = new StringBuilder("retained artifact staging started: target=");
        r65.append(r4.getAbsolutePath());
        r65.append(", packages=");
        r65.append(r10.size());
        r65.append(", files=");
        int r124 = 0;
        Iterator r125 = ((Iterable) r10).iterator();
    L13:
        if (r125.hasNext() == false) goto L15;
        Iterator r126 = r125;
        r124 = r124 + ((o) r125.next()).b.size();
        r125 = r126;
        goto L13
    L15:
        r65.append(r124);
        g49.d.d("DoraResourceInstall", r65.toString());
        if (r10.isEmpty() == false) goto L204;
        r22 = r7;
        r23 = ", files=";
        r16 = true;
        r17 = r10;
        goto L29
    L204:
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L78
        LinkedHashSet r67 = new LinkedHashSet();     // Catch: Throwable -> L78
        Iterator r127 = CollectionsKt.sortedWith((Iterable) r10, new e0()).iterator();     // Catch: Throwable -> L78
        Object r68 = r2;
        ?? r70 = r10;
        ?? r128 = r126;
    L199:
        if (r127.hasNext() == false) goto L74;
        o r129 = (o) r127.next();     // Catch: Throwable -> L78
        Iterator r130 = r127;
        Iterator r131 = CollectionsKt.sorted(r129.b).iterator();     // Catch: Throwable -> L78
        r10 = r70;
    L22:
        boolean r132 = r131.hasNext();     // Catch: Throwable -> L78
        if (r132 == false) goto L73;
        Iterator r212 = r131;
        String r133 = (String) r131.next();     // Catch: Throwable -> L78
        LinkedHashSet r213 = r67;
        r22 = r7;
        r23 = r12;
        if (r67.add(r133) == false) goto L27;
        PolarisFileWrapper r71 = new PolarisFileWrapper(this.b, r133);     // Catch: Throwable -> L71
        PolarisFileWrapper r72 = new PolarisFileWrapper(r4, r133);     // Catch: Throwable -> L71
        r128 = r10;
        boolean r73 = h(this.b, r71);     // Catch: Throwable -> L68
        r30 = r11;
        boolean r74 = r71.isFile();     // Catch: Throwable -> L65
        String r313 = r14;
        String r314 = r15;
        long r134 = r71.length();     // Catch: Throwable -> L63
        r5 = r5;
        boolean r75 = h(r4, r72);     // Catch: Throwable -> L60
        if (r73 == false) goto L52;
        if (r74 == false) goto L52;
        r111 = 0;
        if (r134 <= 0) goto L195;
        if (r75 == false) goto L195;
    L50:
        th = th;
        r68 = "DoraResourceInstall";
    L80:
        Result.Companion r76 = Result.Companion;
        Object r77 = Result.constructor-impl(ResultKt.createFailure(th));
        ?? r78 = r68;
        ?? r135 = r128;
    L81:
        Throwable r80 = Result.exceptionOrNull-impl(r77);
        if (r80 == null) goto L84;
        StringBuilder r81 = new StringBuilder("retained artifact staging exception: target=");
        r81.append(r4.getAbsolutePath());
        r20 = r313;
        r81.append(r20);
        r81.append(r80.getClass().getSimpleName());
        r21 = r314;
        r81.append(r21);
        r81.append(r80.getMessage());
        g49.d.e(r78, r81.toString());
    L85:
        Boolean r82 = Boolean.FALSE;
        if (Result.isFailure-impl(r77) == false) goto L88;
        r77 = r82;
    L88:
        r16 = ((Boolean) r77).booleanValue();
        r18 = r78;
        r110 = r135;
        goto L89
    L84:
        r21 = r314;
        r20 = r313;
        goto L85
    L46:
        if (i(r72.getParentFile()) == false) goto L47;
        FilesKt.copyTo$default(r71, r72, false, 0, 4, null);     // Catch: Throwable -> L50
        r10 = r128;
        r131 = r212;
        r67 = r213;
        r7 = r22;
        r12 = r23;
        r11 = r30;
        r15 = r314;
        r14 = r313;
        r5 = r5;
        goto L22
    L47:
        g49.d.e("DoraResourceInstall", "retained artifact target parent creation failed: source=" + r71.getAbsolutePath() + ", target=" + r72.getAbsolutePath() + ", targetParent=" + r72.getParentFile().getAbsolutePath() + ", targetRoot=" + r4.getAbsolutePath());     // Catch: Throwable -> L50
        String r83 = "DoraResourceInstall";
    L57:
        r21 = r314;
        r20 = r313;
        r16 = false;
        r18 = r83;
        r110 = r128;
    L195:
        String r84 = "DoraResourceInstall";
        g49.d.e(r84, "retained artifact file rejected: package=" + r129.a.a + ", relativePath=" + r133 + ", source=" + r71.getAbsolutePath() + ", sourceCanonical=" + r71.getCanonicalPath() + ", sourceRoot=" + this.b.getAbsolutePath() + ", sourceRootCanonical=" + this.b.getCanonicalPath() + ", sourceInsideRoot=" + r73 + ", sourceIsFile=" + r74 + ", sourceLength=" + r134 + ", target=" + r72.getAbsolutePath() + ", targetCanonical=" + r72.getCanonicalPath() + ", targetRoot=" + r4.getAbsolutePath() + ", targetRootCanonical=" + r4.getCanonicalPath() + ", targetInsideRoot=" + r75);     // Catch: Throwable -> L76
        r83 = r84;
    L58:
        th = th;
        r68 = "DoraResourceInstall";
    L52:
        r111 = 0;
    L60:
        th = th;
    L61:
        r68 = "DoraResourceInstall";
        r128 = r128;
    L62:
        r111 = 0;
    L63:
        th = th;
        r5 = r5;
    L65:
        th = th;
        r5 = r5;
        String r85 = "DoraResourceInstall";
        ?? r136 = r128;
    L67:
        r313 = r14;
        r314 = r15;
        r68 = r85;
        r128 = r136;
    L68:
        th = th;
        ?? r137 = r128;
    L70:
        r30 = r11;
        r85 = r6;
        r136 = r137;
    L71:
        th = th;
        r137 = r10;
        goto L70
    L27:
        g49.d.e("DoraResourceInstall", "retained artifact path conflict: package=" + r129.a.a + ", relativePath=" + r133 + ", sourceRoot=" + this.b.getAbsolutePath() + ", targetRoot=" + r4.getAbsolutePath());     // Catch: Throwable -> L71
        r13 = r10;
        goto L28
    L73:
        r111 = 0;
        r68 = r35;
        r127 = r130;
        r70 = r10;
        r128 = r132;
        goto L199
    L74:
        r5 = r5;
        r78 = "DoraResourceInstall";
        r22 = r7;
        r135 = r70;
        r30 = r11;
        r23 = r12;
        r313 = r14;
        r314 = r15;
        r111 = 0;
        r77 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L76
    L76:
        th = th;
    L78:
        th = th;
        r5 = r5;
        r85 = "DoraResourceInstall";
        r22 = r7;
        r136 = r10;
        r30 = r11;
        r23 = r12;
        goto L67
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static a f(File r22, PolarisFileWrapper r23, Set r24, Set r25) {
        PolarisFileWrapper r1 = r23;
        Set r0 = r24;
        LinkedHashSet r5 = new LinkedHashSet();
        PolarisFileWrapper r6 = null;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L128
        ZipInputStream r8 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r22)));     // Catch: Throwable -> L128
        long r11 = 0;
        String r13 = null;
        int r9 = 0;
    L149:
        ZipEntry r14 = r8.getNextEntry();     // Catch: Throwable -> L120
        if (r14 == null) goto L7;
        r13 = r14.getName();     // Catch: Throwable -> L120
        String r15 = StringsKt.replace$default(r14.getName(), '\\', '/', false, 4, null);     // Catch: Throwable -> L120
        String r10 = StringsKt.substringAfterLast$default(r15, '/', r6, 2, r6);     // Catch: Throwable -> L120
        long r18 = r11;
    L116:
        th = th;
        r1 = null;
    L122:
        Throwable r12 = th;
        throw r12;     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        CloseableKt.closeFinally(r8, r12);     // Catch: Throwable -> L95
        throw th;     // Catch: Throwable -> L95
    L25:
        if (StringsKt.startsWith$default(r15, "__MACOSX/", false, 2, null) == false) goto L27;
    L32:
        boolean r16 = true;
    L33:
        if (r16 == true) goto L34;
        if (r14.isDirectory() == true) goto L113;
        String r17 = o(r14.getName(), r0);     // Catch: Throwable -> L111
        if (r17 == null) goto L40;
        if (r5.add(r17) == false) goto L49;
        if (r25.add(r17) == false) goto L56;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r1, r17);     // Catch: Throwable -> L111
        if (h(r1, r110) == false) goto L62;
        if (i(r110.getParentFile()) == false) goto L68;
        BufferedOutputStream r20 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L111
        if ((r20 instanceof BufferedOutputStream) == false) goto L77;
        BufferedOutputStream r21 = r20;     // Catch: Throwable -> L111
    L140:
        byte[] r111 = new byte[16384];     // Catch: Throwable -> L99
        r11 = r18;
    L80:
        int r112 = r8.read(r111);     // Catch: Throwable -> L99
        if (r112 < 0) goto L156;
        r11 = r11 + ((long) r112);
        if (r11 > 536870912) goto L90;
        r1 = null;
        r21.write(r111, 0, r112);     // Catch: Throwable -> L104
    L104:
        th = th;
    L105:
        Throwable r26 = th;
    L147:
        throw r26;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        CloseableKt.closeFinally(r21, r26);     // Catch: Throwable -> L97
        throw th;     // Catch: Throwable -> L97
    L97:
        th = th;
        goto L122
    L90:
        g49.d.e("DoraResourceInstall", "archive extraction failed: reason=archive_size_limit_exceeded, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", extractedBytes=" + r11 + ", maxBytes=536870912");     // Catch: Throwable -> L99
        CloseableKt.closeFinally(r21, null);     // Catch: Throwable -> L97
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L95
        return null;
    L156:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L86
        CloseableKt.closeFinally(r21, null);     // Catch: Throwable -> L111
        r1 = null;
    L160:
        r8.closeEntry();     // Catch: Throwable -> L97
        r0 = r24;
        r6 = r1;
        r1 = r23;
    L86:
        th = move-exception;
        r26 = th;
        r1 = null;
    L99:
        th = th;
        r1 = null;
        goto L105
    L77:
        r21 = new BufferedOutputStream(r20, 8192);     // Catch: Throwable -> L111
        goto L140
    L68:
        g49.d.e("DoraResourceInstall", "archive extraction failed: reason=parent_directory_creation_failed, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", parent=" + r110.getParentFile().getAbsolutePath() + ", target=" + r23.getAbsolutePath());     // Catch: Throwable -> L111
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L44
        return null;
    L62:
        g49.d.e("DoraResourceInstall", "archive entry rejected: reason=path_escapes_target, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", target=" + r23.getAbsolutePath() + ", output=" + r110.getAbsolutePath());     // Catch: Throwable -> L111
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L44
        return null;
    L56:
        g49.d.e("DoraResourceInstall", "archive entry rejected: reason=conflicts_with_staged_file, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", relativePath=" + r17 + ", target=" + r23.getAbsolutePath());     // Catch: Throwable -> L111
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L44
        return null;
    L49:
        g49.d.e("DoraResourceInstall", "archive entry rejected: reason=duplicate_in_archive, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", relativePath=" + r17);     // Catch: Throwable -> L111
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L44
        return null;
    L40:
        g49.d.e("DoraResourceInstall", "archive entry rejected: reason=invalid_path, archive=" + r22.getAbsolutePath() + ", entry=" + r14.getName() + ", allowedRoots=" + r0);     // Catch: Throwable -> L111
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L44
        return null;
    L44:
        th = th;
        r1 = null;
    L130:
        Result.Companion r27 = Result.Companion;
        Object r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L131:
        Throwable r28 = Result.exceptionOrNull-impl(r2);
        if (r28 == null) goto L135;
        g49.d.e("DoraResourceInstall", "archive extraction exception: archive=" + r22.getAbsolutePath() + ", entry=" + r13 + ", target=" + r23.getAbsolutePath() + ", type=" + r28.getClass().getSimpleName() + ", message=" + r28.getMessage());
    L135:
        if (Result.isFailure-impl(r2) == false) goto L137;
        Object r30 = r1;
    L139:
        return (a) r30;
    L137:
        r30 = r2;
        goto L139
    L113:
        r1 = null;
        r11 = r18;
        goto L160
    L34:
        r9 = r9 + 1;
        r8.closeEntry();     // Catch: Throwable -> L111
        r11 = r18;
        r6 = null;
    L111:
        th = th;
        r1 = null;
        goto L122
    L27:
        if (Intrinsics.areEqual(r10, ".DS_Store") == true) goto L32;
        if (StringsKt.startsWith$default(r10, "._", false, 2, null) == true) goto L32;
        r16 = false;
        goto L33
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L120
        CloseableKt.closeFinally(r8, r6);     // Catch: Throwable -> L19
        if (r9 <= 0) goto L11;
        g49.d.d("DoraResourceInstall", "archive metadata entries skipped: archive=" + r22.getAbsolutePath() + ", count=" + r9);     // Catch: Throwable -> L19
    L11:
        PolarisFileWrapper r4 = new a(r5, r11);     // Catch: Throwable -> L19
        if ((!r4.a.isEmpty()) == true) goto L15;
        r4 = r6;
    L15:
        if (r4 != null) goto L17;
        g49.d.e("DoraResourceInstall", "archive extraction failed: reason=no_files, archive=" + r22.getAbsolutePath() + ", target=" + r23.getAbsolutePath());     // Catch: Throwable -> L19
        r4 = r6;
    L17:
        r2 = Result.constructor-impl(r4);     // Catch: Throwable -> L19
        r1 = r6;
    L19:
        th = th;
        r1 = r6;
    L120:
        th = th;
        r1 = r6;
    L95:
        th = th;
    L128:
        th = th;
        r1 = null;
        r13 = null;
        goto L130
    }

    public static t39.p k(d0 r1, IDoraService.Debug.ResourceConfigSyncStatus r2, Set r3, Set r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = SetsKt.emptySet();
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = SetsKt.emptySet();
    L8:
        r1.getClass();
        return new t39.p(r2, r3, r4);
    }
}
