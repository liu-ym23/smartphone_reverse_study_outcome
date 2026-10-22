package com.ss.android.account.share.data.write.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.account.share.data.write.SecShareDataWriteManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JM\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/ss/android/account/share/data/write/provider/SecShareDataProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "Landroid/content/ContentValues;", "values", "insert", "", "getType", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", DownloadConstants.QUERY_KEY, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "a", "sec_share_data_release"}, k = 1, mv = {1, 4, 0})
public final class SecShareDataProvider extends ContentProvider {
    public static final UriMatcher b = null;
    public com.ss.android.account.share.data.write.a a;

    public static final class a {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    static {
        b = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r0 = getContext();
        if (r0 == null) goto L9;
        com.ss.android.account.share.data.write.a r2 = com.ss.android.account.share.data.write.a.b;
        this.a = com.ss.android.account.share.data.write.a.C0007a.a(r0);
        String r1 = r0.getPackageName();
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        UriMatcher r3 = b;
        r3.addURI(r1 + ".SecShareProviderAuthority", "sec_share/*", 2);
        r3.addURI(r1 + ".SecShareProviderAuthority", "sec_share_file/*", 3);
        return true;
    L9:
        return false;
    }

    public SecShareDataProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        int r0 = b.match(r10);
        if (r0 != 2) goto L5;
        Context r11 = getContext();
        if (r11 == null) goto L31;
        String r12 = r11.getPackageName();
        if (TextUtils.isEmpty(r12) == false) goto L30;
        return null;
    L30:
        return r12 + ".SecShareProviderAuthority";
    L31:
        return null;
    L5:
        if (r0 == 3) goto L7;
        return null;
    L7:
        String r3 = r10.getLastPathSegment();
        if (r3 == null) goto L10;
        int r1 = StringsKt.lastIndexOf$default(r3, '.', 0, false, 6, null);
    L11:
        if (r1 < 0) goto L22;
        String r13 = r10.getLastPathSegment();
        if (r13 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        int r2 = r1 + 1;
        if (r13 == null) goto L21;
        String r14 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r13.substring(r2));
        if (r14 == null) goto L32;
        return r14;
    L32:
        return "application/octet-stream";
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L22:
        return "application/octet-stream";
    L10:
        r1 = -1;
        goto L11
    }

    @Override // android.content.ContentProvider
    public synchronized Uri insert(Uri r1, ContentValues r2) {
        monitor-enter(this);
        monitor-exit(this);
        return r1;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r4, String r5) {
        SecShareDataWriteManager r6 = SecShareDataWriteManager.f;
        String r0 = getCallingPackage();
        r6.getClass();
        if (SecShareDataWriteManager.a(r0) == true) goto L6;
        return null;
    L6:
        if (b.match(r4) == 3) goto L9;
        return null;
    L9:
        if (getContext() == null) goto L38;
        String r7 = r4.getLastPathSegment();
        if (r7 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L38;
        int r9 = dra.a.a;
        Context r10 = getContext();
        if (r10 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        String r11 = r4.getLastPathSegment();
        if (r11 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r10.getFilesDir(), "sec_share_data_file");     // Catch: Throwable -> L29
        if (r1.exists() == true) goto L27;
        r1.mkdirs();     // Catch: Throwable -> L29
    L27:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r1, r11);     // Catch: Throwable -> L29
    L31:
        if (r12 == null) goto L38;
        if (r12.exists() == false) goto L38;
        if (r12.isFile() == false) goto L38;
        return ParcelFileDescriptor.open(r12, 268435456);
    L29:
        th = move-exception;
        th.printStackTrace();
        r12 = null;
        goto L31
    L13:
        if (r7.length() == 0) goto L16;
        r8 = false;
    L38:
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        monitor-enter(this);
        SecShareDataWriteManager r8 = SecShareDataWriteManager.f;     // Catch: Throwable -> L32
        String r9 = getCallingPackage();     // Catch: Throwable -> L32
        r8.getClass();     // Catch: Throwable -> L32
        boolean r10 = SecShareDataWriteManager.a(r9);     // Catch: Throwable -> L32
        MatrixCursor r11 = null;
        if (r10 == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Logger.e("SecShareDataProvider", "query getCallingPackage = " + getCallingPackage());     // Catch: Throwable -> L32
        if (b.match(r3) == 2) goto L14;
        monitor-exit(this);
        return null;
    L14:
        List<String> r12 = r3.getPathSegments();     // Catch: Throwable -> L32
        int r13 = r12.size();     // Catch: Throwable -> L32
        if (r13 <= 0) goto L30;
        String r14 = (String) ListProtector.get(r12, r13 - 1);     // Catch: Throwable -> L32
        com.ss.android.account.share.data.write.a r15 = this.a;     // Catch: Exception -> L26 Throwable -> L32
        if (r15 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Exception -> L26 Throwable -> L32
    L20:
        String r16 = r15.a.getSharedPreferences("account_sec_share_data", 0).getString(r14, "");     // Catch: Exception -> L26 Throwable -> L32
        MatrixCursor r0 = new MatrixCursor(new String[]{r14});     // Catch: Exception -> L26 Throwable -> L32
        MatrixCursor.RowBuilder r17 = r0.newRow();     // Catch: Exception -> L24 Throwable -> L32
        Logger.w("SecShareDataProvider", "MultiProcessShareProvider  get queryKey = " + r14 + " value = " + r16);     // Catch: Exception -> L24 Throwable -> L32
        r17.add(r14, r16);     // Catch: Exception -> L24 Throwable -> L32
        monitor-exit(this);
        return r0;
    L24:
        e = e;
        r11 = r0;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L32
        monitor-exit(this);
        return r11;
    L26:
        e = e;
        goto L27
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }
}
