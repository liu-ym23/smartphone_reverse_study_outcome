package v98;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    public static final a a = null;
    public static final long b = 0;
    public static final long c = 0;
    public static final ConcurrentHashMap<String, l> d = null;
    public static volatile boolean e;

    public static final class a {
        public static void b() {
            Collection<l> r0 = r.d.values();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L3:
            boolean r3 = true;
            if (r2.hasNext() == false) goto L12;
            Object r4 = r2.next();
            l r5 = (l) r4;
            long r6 = TimeUnit.DAYS.toMillis(7);
            r5.getClass();
            if ((System.currentTimeMillis() - r5.d) > r6) goto L9;
            r3 = false;
        L9:
            if (r3 == false) goto L3;
            r1.add(r4);
            goto L3
        L12:
            if ((!r1.isEmpty()) == false) goto L18;
            FLogger.a.i("StoragePolicyManager", "Found " + r1.size() + " expired files, cleaning up...");
            Iterator r7 = r1.iterator();
        L15:
            if (r7.hasNext() == false) goto L17;
            d((l) r7.next());
            goto L15
        L17:
            FLogger.a.i("StoragePolicyManager", "Cleanup completed. Removed " + r1.size() + " expired files");
        L18:
            long r8 = e();
            long r9 = r.b;
            if (r8 <= r9) goto L42;
            FLogger r10 = FLogger.a;
            StringBuilder r11 = new StringBuilder("Storage limit exceeded: ");
            long r12 = 1024;
            r11.append((r8 / r12) / r12);
            r11.append("MB / ");
            r11.append((r9 / r12) / r12);
            r11.append("MB");
            r10.w("StoragePolicyManager", r11.toString());
            List r13 = CollectionsKt.sortedWith(r.d.values(), new q());
            ArrayList r14 = new ArrayList();
            Iterator r15 = r13.iterator();
            long r16 = 0;
        L23:
            if (r15.hasNext() == false) goto L26;
            l r17 = (l) r15.next();
            r14.add(r17);
            r16 = r16 + r17.c;
            if (r16 < r.c) goto L23;
        L26:
            FLogger.a.i("StoragePolicyManager", "Will delete " + r14.size() + " oldest files to free " + ((r16 / r12) / r12) + "MB");
            Iterator r18 = r14.iterator();
        L28:
            if (r18.hasNext() == false) goto L30;
            d((l) r18.next());
            goto L28
        L30:
            long r19 = e();
            FLogger.a.i("StoragePolicyManager", "Cleanup completed. New storage size: " + ((r19 / r12) / r12) + "MB");
            return;
        }

        public static void c() {
            PolarisFileWrapper r1 = new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "zip_exports");     // Catch: Exception -> L20
            if (r1.exists() == true) goto L6;
            return;
        L6:
            File[] r2 = r1.listFiles();     // Catch: Exception -> L20
            int r3 = 0;
            long r4 = 0;
            if (r2 == null) goto L17;
            int r6 = r2.length;     // Catch: Exception -> L20
            long r7 = 0;
            int r5 = 0;
        L9:
            if (r3 >= r6) goto L16;
            File r8 = r2[r3];     // Catch: Exception -> L20
            if (r8.isFile() == false) goto L15;
            long r9 = r8.length();     // Catch: Exception -> L20
            if (r8.delete() == false) goto L15;
            r5 = r5 + 1;     // Catch: Exception -> L20
            r7 = r7 + r9;     // Catch: Exception -> L20
            FLogger r11 = FLogger.a;     // Catch: Exception -> L20
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L20
            r12.append("Cleaned up ZIP file: ");     // Catch: Exception -> L20
            r12.append(r8.getName());     // Catch: Exception -> L20
            r12.append(" (");     // Catch: Exception -> L20
            long r13 = 1024;
            r12.append((r9 / r13) / r13);     // Catch: Exception -> L20
            r12.append("MB)");     // Catch: Exception -> L20
            r11.i("StoragePolicyManager", r12.toString());     // Catch: Exception -> L20
        L15:
            r3 = r3 + 1;     // Catch: Exception -> L20
            goto L9
        L16:
            r3 = r5;
            r4 = r7;
        L17:
            if (r3 <= 0) goto L29;
            FLogger r10 = FLogger.a;     // Catch: Exception -> L20
            StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L20
            r14.append("Cleaned up ");     // Catch: Exception -> L20
            r14.append(r3);     // Catch: Exception -> L20
            r14.append(" ZIP files, freed ");     // Catch: Exception -> L20
            long r15 = 1024;
            r14.append((r4 / r15) / r15);     // Catch: Exception -> L20
            r14.append("MB");     // Catch: Exception -> L20
            r10.i("StoragePolicyManager", r14.toString());     // Catch: Exception -> L20
            return;
        L29:
            return;
        L20:
            e = move-exception;
            FLogger.a.e("StoragePolicyManager", "Error cleaning up ZIP files: " + e.getMessage(), e);
        }

        public static long e() {
            Iterator<T> r0 = r.d.values().iterator();
            long r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L6;
            r1 = r1 + ((l) r0.next()).c;
            goto L4
        L6:
            return r1;
        }

        public static void g() {
            PolarisFileWrapper r1 = new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "dump_files_storage_info.json");     // Catch: Exception -> L12
            if (r1.exists() == true) goto L7;
            FLogger.a.i("StoragePolicyManager", "No existing storage info file found");     // Catch: Exception -> L12
            return;
        L7:
            JSONArray r2 = new JSONArray(FilesKt.readText$default(r1, null, 1, null));     // Catch: Exception -> L12
            int r3 = r2.length();     // Catch: Exception -> L12
            int r4 = 0;
            int r5 = 0;
        L8:
            if (r4 >= r3) goto L10;
            JSONObject r6 = JSONArrayProtectorUtils.getJSONObject(r2, r4);     // Catch: Exception -> L12
            l r13 = new l(r6.optString("filePath"), r6.optString("fileName"), r6.optLong("sizeBytes"), r6.optLong("creationTime"));     // Catch: Exception -> L12
            r.d.put(r13.a, r13);     // Catch: Exception -> L12
            r5 = r5 + 1;     // Catch: Exception -> L12
            r4 = r4 + 1;     // Catch: Exception -> L12
            goto L8
        L10:
            FLogger.a.i("StoragePolicyManager", "Loaded " + r5 + " file info entries from disk");     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            FLogger.a.e("StoragePolicyManager", "Failed to load file info from disk: " + e.getMessage(), e);
        }

        public static void h() {
            JSONArray r1 = new JSONArray();     // Catch: Exception -> L9
            Iterator<l> r2 = r.d.values().iterator();     // Catch: Exception -> L9
        L5:
            if (r2.hasNext() == false) goto L7;
            l r3 = r2.next();     // Catch: Exception -> L9
            JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
            r4.put("filePath", r3.a);     // Catch: Exception -> L9
            r4.put("fileName", r3.b);     // Catch: Exception -> L9
            r4.put("sizeBytes", r3.c);     // Catch: Exception -> L9
            r4.put("creationTime", r3.d);     // Catch: Exception -> L9
            r1.put(r4);     // Catch: Exception -> L9
            goto L5
        L7:
            FilesKt.writeText$default(new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "dump_files_storage_info.json"), r1.toString(), null, 2, null);     // Catch: Exception -> L9
            FLogger.a.d("StoragePolicyManager", "Saved " + r.d.size() + " file info entries to disk");     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            FLogger.a.e("StoragePolicyManager", "Failed to save file info to disk: " + e.getMessage(), e);
        }

        public static void i() {
            ArrayList r0 = new ArrayList();
            Iterator<Map.Entry<String, l>> r1 = r.d.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            Map.Entry<String, l> r2 = r1.next();
            String r4 = r2.getKey();
            l r3 = r2.getValue();
            if (new PolarisFileWrapper(r4).exists() == true) goto L4;
            r0.add(r4);
            FLogger.a.w("StoragePolicyManager", "File no longer exists: " + r3.b);
            goto L4
        L8:
            Iterator r5 = r0.iterator();
        L10:
            if (r5.hasNext() == false) goto L13;
            r.d.remove((String) r5.next());
            goto L10
        L13:
            if ((!r0.isEmpty()) == false) goto L22;
            FLogger.a.i("StoragePolicyManager", "Removed " + r0.size() + " non-existent file records");
            h();
            return;
        }

        public final void f() {
            if (r.e == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (r.e == false) goto L10;
            monitor-exit(this);
            return;
        L10:
            FLogger r1 = FLogger.a;     // Catch: Throwable -> L13
            r1.i("StoragePolicyManager", "Initializing StoragePolicyManager...");     // Catch: Throwable -> L13
            a r2 = r.a;     // Catch: Throwable -> L13
            g();     // Catch: Throwable -> L13
            i();     // Catch: Throwable -> L13
            c();     // Catch: Throwable -> L13
            r.e = true;     // Catch: Throwable -> L13
            long r3 = e();     // Catch: Throwable -> L13
            int r4 = r.d.size();     // Catch: Throwable -> L13
            long r7 = r.b;     // Catch: Throwable -> L13
            long r5 = (((long) 100) * r3) / r7;     // Catch: Throwable -> L13
            long r6 = 1024;
            long r8 = (r7 / r6) / r6;     // Catch: Throwable -> L13
            r1.i("StoragePolicyManager", "StoragePolicyManager initialized. Files: " + r4 + ", Size: " + ((r3 / r6) / r6) + "MB");     // Catch: Throwable -> L13
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
        }

        public a() {
        }

        public static void d(l r6) {
            PolarisFileWrapper r4 = new PolarisFileWrapper(r6.a);     // Catch: Exception -> L12
            if (r4.exists() == true) goto L6;
            r.d.remove(r6.a);     // Catch: Exception -> L12
            FLogger.a.d("StoragePolicyManager", "File no longer exists, removed from management: " + r6.a);     // Catch: Exception -> L12
        L10:
            h();     // Catch: Exception -> L12
            return;
        L6:
            if (r4.delete() == false) goto L8;
            r.d.remove(r6.a);     // Catch: Exception -> L12
            FLogger.a.d("StoragePolicyManager", "Deleted file: " + r6.b);     // Catch: Exception -> L12
            goto L10
        L8:
            FLogger.a.w("StoragePolicyManager", "Failed to delete file: " + r6.a);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            FLogger.a.e("StoragePolicyManager", "Error deleting file " + r6.a + ": " + e.getMessage(), e);
        }

        public final void a(String r9, String r10, long r11) {
            Intrinsics.checkNotNullParameter(r9, "filePath");
            Intrinsics.checkNotNullParameter(r10, "fileName");
            f();
            r.d.put(r9, new l(r9, r10, r11, System.currentTimeMillis()));
            FLogger.a.d("StoragePolicyManager", "Added file to storage management: " + r10 + " (" + r11 + " bytes)");
            h();
            b();
        }
    }

    static {
        a = new a();
        AppHost.Companion r0 = AppHost.a;
        long r2 = 20971520;
        if (r0.isTestChannel() == false) goto L5;
        long r4 = 3221225472L;
    L6:
        b = r4;
        if (r0.isTestChannel() == false) goto L9;
        r2 = 209715200;
    L9:
        c = r2;
        d = new ConcurrentHashMap();
        return;
    L5:
        r4 = 20971520;
        goto L6
    }
}
