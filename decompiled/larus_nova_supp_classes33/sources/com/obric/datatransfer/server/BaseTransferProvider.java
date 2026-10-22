package com.obric.datatransfer.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.datatransfer.logger.TransferLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005JQ\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u0019\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/obric/datatransfer/server/BaseTransferProvider;", "Landroid/content/ContentProvider;", "", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "Landroid/net/Uri;", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "a", "datatransfer_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseTransferProvider extends ContentProvider {
    public static final /* synthetic */ int e = 0;
    public final Lazy a;
    public final Lazy b;
    public List<? extends File> c;
    public final TransferLogger d;

    public static final class a {
    }

    static {
    }

    public abstract List<File> a();

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        TransferLogger.c(this.d, "onCreate");
        List<File> r0 = a();
        this.c = r0;
        TransferLogger r1 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sourceFiles");
        r0 = null;
    L5:
        TransferLogger.c(r1, "gatherFiles, size=" + r0.size());
        return true;
    }

    public BaseTransferProvider() {
        this.a = LazyKt.lazy(new BaseTransferProvider$verifier$2(this));
        this.b = LazyKt.lazy(new BaseTransferProvider$transferPathStrategy$2(this));
        com.obric.datatransfer.logger.a r0 = TransferLogger.b;
        this.d = TransferLogger.a.a("BaseTransferProvider");
    }

    public final Map<String, File> b() {
        Context r0 = getContext();
        if (r0 != null) goto L7;
        return MapsKt.emptyMap();
    L7:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("files", r0.getFilesDir()), TuplesKt.to("obb", r0.getObbDir()), TuplesKt.to("external_files", r0.getExternalFilesDir(null)), TuplesKt.to("no_backup", r0.getNoBackupFilesDir()), TuplesKt.to("data", ContextCompat.getDataDir(r0)), TuplesKt.to("shared_prefs", new PolarisFileWrapper(ContextCompat.getDataDir(r0), "shared_prefs")), TuplesKt.to("databases", r0.getDatabasePath("dummy").getParentFile())});
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "mode");
        Context r2 = getContext();
        if (r2 == null) goto L48;
        if (((f) this.a.getValue()).a(r2) == false) goto L46;
        File r5 = null;
        if (StringsKt.contains$default(r12, "w", false, 2, null) == true) goto L44;
        String r3 = r11.getPath();
        if (r3 == null) goto L11;
        String r4 = StringsKt.removePrefix(r3, "/");
    L12:
        TransferLogger.a(this.d, "openFile: " + r11);
        if (Intrinsics.areEqual(r4, "file/list") == false) goto L17;
        ParcelFileDescriptor[] r13 = ParcelFileDescriptor.createPipe();
        final ParcelFileDescriptor r14 = r13[1];
        ParcelFileDescriptor r15 = r13[0];
        ThreadMethodProxy.start(new PthreadThreadV2(new b(r14, this), "BaseTransferProvider"));
        return r15;
    L17:
        if (Intrinsics.areEqual(r4, "file") == false) goto L41;
        String r16 = UriProtector.getQueryParameter(r11, "base");
        String r17 = UriProtector.getQueryParameter(r11, "path");
        if (r16 == null) goto L40;
        if (r17 == null) goto L40;
        File r1 = b().get(r16);
        if (r1 == null) goto L32;
        File r6 = new PolarisFileWrapper(r1, r17);
    L30:
        e = move-exception;
        this.d.b("Error resolving file path", e);
        goto L32
    L26:
        if (StringsKt.startsWith$default(r6.getCanonicalPath(), r1.getCanonicalPath(), false, 2, null) == true) goto L29;
        this.d.d("Path traversal attempt detected: " + r16 + "/" + r17, null);     // Catch: IOException -> L30
        goto L32
    L29:
        r5 = r6;
    L32:
        if (r5 == null) goto L38;
        if (r5.exists() == false) goto L38;
        return ParcelFileDescriptor.open(r5, 268435456);
    L38:
        throw new FileNotFoundException("File not found: " + r16 + "/" + r17);
    L40:
        throw new FileNotFoundException("Missing base or path parameter");
    L41:
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "mode");
        throw new FileNotFoundException("Invalid path: " + r4);
    L11:
        r4 = null;
        goto L12
    L44:
        throw new SecurityException("Write mode is not supported");
    L46:
        throw new SecurityException("Permission Denied");
    L48:
        throw new IllegalStateException("Context is null");
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r6, String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "method");
        if (r8 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        TransferLogger.c(this.d, "call method=" + r6 + ", arg=" + r7 + ", hasExtra=" + r1);
        Context r2 = getContext();
        if (r2 == null) goto L32;
        if (((f) this.a.getValue()).a(r2) == false) goto L30;
        if (Intrinsics.areEqual(r6, "method_transfer_finished") == false) goto L17;
        new Handler(Looper.getMainLooper()).post(new com.obric.datatransfer.server.a(this));
        return null;
    L17:
        if (Intrinsics.areEqual(r6, "method_clear_app_data") == false) goto L27;
        TransferLogger r9 = xja.a.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        TransferLogger r10 = xja.a.a;
        TransferLogger.c(r10, "Deleting current user data");
        xja.a.a(new PolarisFileWrapper(r2.getApplicationInfo().dataDir));     // Catch: Exception -> L24
        TransferLogger.c(r10, "Current user data deleted");     // Catch: Exception -> L24
        File r11 = r2.getExternalFilesDir(null);     // Catch: Exception -> L24
        if (r11 == null) goto L22;
        xja.a.a(r11);     // Catch: Exception -> L24
    L22:
        TransferLogger.c(r10, "Current user external data deleted");     // Catch: Exception -> L24
    L26:
        return null;
    L24:
        e = move-exception;
        xja.a.a.b("Error deleting current user data", e);
        goto L26
    L27:
        Intrinsics.checkNotNullParameter(r6, "method");
        return super.call(r6, r7, r8);
    L30:
        throw new SecurityException("Permission Denied");
    L32:
        throw new IllegalStateException("Context is null");
    L5:
        if (r8.isEmpty() == true) goto L7;
        r1 = true;
        goto L8
    }
}
