package com.miui.bugreport.logprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import j6.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DumpLogProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final File f4296c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile HashMap<String, File> f4297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<a> f4298h = null;

    static {
        f4296c = new File("/");
        f4297g = new HashMap();
        f4298h = new CopyOnWriteArrayList();
    }

    public DumpLogProvider() {
    }

    private static void a(String r10, File r11) {
        if (TextUtils.isEmpty(r10) == false) goto L11;
        Log.w("DumpLogProvider", "addRoot: name is empty, skip");
        return;
    L11:
        r11 = r11.getCanonicalFile();     // Catch: IOException -> L8
        f4297g.put(r10, r11);     // Catch: IOException -> L8
        Log.d("DumpLogProvider", "addRoot: added [" + r10 + "] -> " + r11.getPath());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("DumpLogProvider", "addRoot: canonical failed for " + r11, e);
    }

    private static File b(File r10, String... r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        String r14 = r11[r13];
        if (r14 == null) goto L7;
        r10 = new File(r10, r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r10;
    }

    private static HashMap<String, File> c() {
        HashMap<String, File> r10 = new HashMap(f4297g);
        StringBuilder r11 = new StringBuilder();
        r11.append("getAllLogDirs: static paths count=");
        r11.append(f4297g.size());
        r11.append(", dynamic providers count=");
        List<a> r12 = f4298h;
        r11.append(r12.size());
        Log.d("DumpLogProvider", r11.toString());
        Iterator<a> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L25;
        a r14 = r13.next();
        Map<String, File> r15 = r14.a();     // Catch: Exception -> L23
        if (r15 == null) goto L9;
        Log.d("DumpLogProvider", "getAllLogDirs: provider " + r14.getClass().getName() + " returned " + r15.size() + " paths");     // Catch: Exception -> L23
        Iterator<Map.Entry<String, File>> r16 = r15.entrySet().iterator();     // Catch: Exception -> L23
    L12:
        if (r16.hasNext() == false) goto L4;
        Map.Entry<String, File> r17 = r16.next();     // Catch: Exception -> L23
        String r18 = r17.getKey();     // Catch: Exception -> L23
        File r19 = r17.getValue();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r18) == true) goto L21;
        if (r19 == null) goto L21;
        File r20 = r19.getCanonicalFile();     // Catch: IOException -> L19 Exception -> L23
        r10.put(r18, r20);     // Catch: IOException -> L19 Exception -> L23
        Log.d("DumpLogProvider", "getAllLogDirs: dynamic path added: name=" + r18 + ", path=" + r20.getPath());     // Catch: IOException -> L19 Exception -> L23
    L19:
        e = move-exception;
        r10.put(r18, r19);     // Catch: Exception -> L23
        Log.w("DumpLogProvider", "getAllLogDirs: canonical failed for " + r19 + ", using original path", e);     // Catch: Exception -> L23
    L21:
        Log.w("DumpLogProvider", "getAllLogDirs: skipping invalid dynamic entry: name=" + r18 + ", path=" + r19);     // Catch: Exception -> L23
        goto L12
    L9:
        Log.w("DumpLogProvider", "getAllLogDirs: provider " + r14.getClass().getName() + " returned null, skip");     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e("DumpLogProvider", "getAllLogDirs: exception from provider " + r14.getClass().getName(), e);
        goto L4
    L25:
        Log.i("DumpLogProvider", "getAllLogDirs: total merged paths count=" + r10.size());
        Iterator<Map.Entry<String, File>> r21 = r10.entrySet().iterator();
    L27:
        if (r21.hasNext() == false) goto L29;
        Map.Entry<String, File> r22 = r21.next();
        Log.d("DumpLogProvider", "getAllLogDirs:   [" + r22.getKey() + "] -> " + r22.getValue().getPath() + " (exists=" + r22.getValue().exists() + ")");
        goto L27
    L29:
        return r10;
    }

    private static boolean d(Context r10) {
        boolean r11 = true;
        if ((r10.getPackageManager().getPackageInfo("com.miui.bugreport", 0).applicationInfo.flags & 1) != 0) goto L7;
        r11 = false;
    L7:
        Log.d("DumpLogProvider", "isMiui: com.miui.bugreport found, isSystem=" + r11);     // Catch: PackageManager.NameNotFoundException -> L9
        return r11;
    L9:
        Log.d("DumpLogProvider", "isMiui: com.miui.bugreport not found, returning false");
        return false;
    }

    private static HashMap<String, File> e(Context r11, String r12) {
        Log.d("DumpLogProvider", "parseLogDir: metaDataName=" + r12);
        HashMap<String, File> r10 = new HashMap();
        XmlResourceParser r13 = r11.getPackageManager().getApplicationInfo(r11.getPackageName(), 128).loadXmlMetaData(r11.getPackageManager(), r12);     // Catch: Exception -> L44
        if (r13 != null) goto L7;
        Log.w("DumpLogProvider", "parseLogDir: no xml meta-data found for " + r12);     // Catch: Exception -> L44
        return r10;
    L7:
        int r14 = r13.next();     // Catch: Exception -> L44
        if (r14 == 1) goto L46;
        if (r14 != 2) goto L7;
        String r15 = r13.getName();     // Catch: Exception -> L44
        File r16 = null;
        String r17 = r13.getAttributeValue(null, ActivityLifecycle.NAME);     // Catch: Exception -> L44
        String r18 = r13.getAttributeValue(null, "path");     // Catch: Exception -> L44
        Log.d("DumpLogProvider", "parseLogDir: tag=" + r15 + ", name=" + r17 + ", path=" + r18);     // Catch: Exception -> L44
        if ("root-path".equals(r15) == false) goto L15;
        r16 = f4296c;     // Catch: Exception -> L44
    L40:
        if (r16 != null) goto L41;
        Log.w("DumpLogProvider", "parseLogDir: unknown or unresolved tag=" + r15);     // Catch: Exception -> L44
        goto L7
    L41:
        File r19 = b(r16, new String[]{r18});     // Catch: Exception -> L44
        Log.d("DumpLogProvider", "parseLogDir: resolved target=" + r19.getPath());     // Catch: Exception -> L44
        a(r17, r19);     // Catch: Exception -> L44
        goto L7
    L15:
        if ("files-path".equals(r15) == false) goto L18;
        r16 = r11.getFilesDir();     // Catch: Exception -> L44
        goto L40
    L18:
        if ("cache-path".equals(r15) == false) goto L21;
        r16 = r11.getCacheDir();     // Catch: Exception -> L44
        goto L40
    L21:
        if ("external-path".equals(r15) == false) goto L24;
        r16 = Environment.getExternalStorageDirectory();     // Catch: Exception -> L44
        goto L40
    L24:
        if ("external-files-path".equals(r15) == false) goto L29;
        File[] r20 = r11.getExternalFilesDirs(null);     // Catch: Exception -> L44
        if (r20.length <= 0) goto L40;
        r16 = r20[0];     // Catch: Exception -> L44
        goto L40
    L29:
        if ("external-cache-path".equals(r15) == false) goto L34;
        File[] r21 = r11.getExternalCacheDirs();     // Catch: Exception -> L44
        if (r21.length <= 0) goto L40;
        r16 = r21[0];     // Catch: Exception -> L44
        goto L40
    L34:
        if (Build.VERSION.SDK_INT < 21) goto L40;
        if ("external-media-path".equals(r15) == false) goto L40;
        File[] r22 = r11.getExternalMediaDirs();     // Catch: Exception -> L44
        if (r22.length <= 0) goto L40;
        r16 = r22[0];     // Catch: Exception -> L44
    L46:
        Log.d("DumpLogProvider", "parseLogDir: done, parsed " + r10.size() + " entries from " + r12);
        return r10;
    L44:
        e = move-exception;
        Log.e("DumpLogProvider", "parseLogDir: exception", e);
        goto L46
    }

    public static void f(@NonNull a r10) {
        List<a> r11 = f4298h;
        if (r11.contains(r10) == true) goto L5;
        r11.add(r10);
        Log.i("DumpLogProvider", "registerDynamicLogPathProvider: registered " + r10.getClass().getName() + ", total dynamic providers: " + r11.size());
        return;
    L5:
        Log.w("DumpLogProvider", "registerDynamicLogPathProvider: provider already registered, skip: " + r10.getClass().getName());
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r10, @Nullable String r11, @Nullable String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r10, @Nullable ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i("DumpLogProvider", "onCreate: start, package=" + getContext().getPackageName());
        f4297g.putAll(e(getContext(), "com.miui.bugreport.DEFAULT_LOG_DIR"));
        Log.d("DumpLogProvider", "onCreate: after parsing DEFAULT_LOG_DIR, paths count=" + f4297g.size());
        f4297g.putAll(e(getContext(), "com.miui.bugreport.LOG_DIR"));
        Log.d("DumpLogProvider", "onCreate: after parsing LOG_DIR, paths count=" + f4297g.size());
        Iterator<Map.Entry<String, File>> r10 = f4297g.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, File> r11 = r10.next();
        Log.i("DumpLogProvider", "onCreate: static path [" + r11.getKey() + "] -> " + r11.getValue().getPath());
        goto L4
    L6:
        Log.i("DumpLogProvider", "onCreate: done, dynamic providers count=" + f4298h.size());
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri r10, @NonNull String r11) {
        Log.i("DumpLogProvider", "openFile: uri=" + r10 + ", mode=" + r11);
        if (d(getContext()) == true) goto L6;
        Log.w("DumpLogProvider", "openFile: not MIUI, returning null");
        return null;
    L6:
        String r12 = Uri.parse(Uri.decode(r10.toString())).getPath();
        Log.d("DumpLogProvider", "openFile: decoded filePath=" + r12);
        if (TextUtils.isEmpty(r12) == false) goto L22;
        Log.e("DumpLogProvider", "openFile: filePath is empty, throwing FileNotFoundException");
        throw new FileNotFoundException();
    L22:
        File r13 = new File(r12);     // Catch: IOException -> L17
        String r14 = r13.getCanonicalPath();     // Catch: IOException -> L17
        Log.d("DumpLogProvider", "openFile: canonical filePath=" + r14);     // Catch: IOException -> L17
        Iterator<Map.Entry<String, File>> r15 = c().entrySet().iterator();     // Catch: IOException -> L17
    L10:
        if (r15.hasNext() == false) goto L15;
        Map.Entry<String, File> r16 = r15.next();     // Catch: IOException -> L17
        String r17 = r16.getValue().getPath();     // Catch: IOException -> L17
        if (r14.startsWith(r17) == false) goto L10;
        Log.i("DumpLogProvider", "openFile: matched root [" + r16.getKey() + "] " + r17 + ", opening file: " + r14);     // Catch: IOException -> L17
        return ParcelFileDescriptor.open(r13, 268435456);
    L15:
        Log.w("DumpLogProvider", "openFile: filePath " + r14 + " does not match any registered root, returning null");     // Catch: IOException -> L17
    L19:
        return null;
    L17:
        e = move-exception;
        Log.e("DumpLogProvider", "openFile: IOException", e);
        goto L19
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14) {
        Log.i("DumpLogProvider", "query: uri=" + r10);
        boolean r15 = d(getContext());
        StringBuilder r16 = new StringBuilder();
        r16.append("query: isMiui=");
        r16.append(r15);
        r16.append(", SDK_INT=");
        int r17 = Build.VERSION.SDK_INT;
        r16.append(r17);
        Log.d("DumpLogProvider", r16.toString());
        if (r15 == true) goto L5;
    L37:
        Log.w("DumpLogProvider", "query: returning null, isMiui=" + r15 + ", SDK_INT=" + r17);
        return null;
    L5:
        if (r17 < 23) goto L37;
        HashMap<String, File> r18 = c();
        LinkedList r19 = new LinkedList();
        ArrayList<String> r20 = new ArrayList();
        Iterator<Map.Entry<String, File>> r21 = r18.entrySet().iterator();
    L9:
        if (r21.hasNext() == false) goto L31;
        Map.Entry<String, File> r22 = r21.next();
        File r23 = r22.getValue();
        Log.d("DumpLogProvider", "query: scanning dir [" + r22.getKey() + "] -> " + r23.getPath() + " (exists=" + r23.exists() + ", isDir=" + r23.isDirectory() + ")");
        if (r23.exists() == true) goto L12;
        Log.w("DumpLogProvider", "query: dir does not exist, skip: " + r23.getPath());
        goto L9
    L12:
        r19.offer(r23);
    L14:
        if (r19.size() == 0) goto L9;
        File r24 = (File) r19.poll();
        if (r24.isFile() == true) goto L17;
        File[] r25 = r24.listFiles();
        if (r25 == null) goto L20;
        int r26 = r25.length;
        int r27 = 0;
    L22:
        if (r27 >= r26) goto L14;
        File r28 = r25[r27];
        if (r28.isFile() == false) goto L27;
        r20.add(r28.getPath());
    L29:
        r27 = r27 + 1;
        goto L22
    L27:
        if (r28.isDirectory() == false) goto L29;
        r19.offer(r28);
        goto L29
    L20:
        Log.w("DumpLogProvider", "query: listFiles returned null for " + r24.getPath() + " (permission issue?)");
        goto L14
    L17:
        r20.add(r24.getPath());
        goto L14
    L31:
        Log.i("DumpLogProvider", "query: total log files found=" + r20.size());
        Iterator<String> r29 = r20.iterator();
    L33:
        if (r29.hasNext() == false) goto L35;
        Log.d("DumpLogProvider", "query:   file=" + r29.next());
        goto L33
    L35:
        MatrixCursor r30 = new MatrixCursor(new String[0]);
        Bundle r31 = new Bundle();
        r31.putStringArrayList("logDir", r20);
        r30.setExtras(r31);
        return r30;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r10, @Nullable ContentValues r11, @Nullable String r12, @Nullable String[] r13) {
        return 0;
    }
}
