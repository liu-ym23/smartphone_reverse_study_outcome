package com.larksuite.framework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.ss.android.lark.log.Log;
import f06.b;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MediaStoreUtil {
    public static final Set<String> a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larksuite/framework/utils/MediaStoreUtil$DirType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PICTURES", "DCIM", "DOWNLOADS", "DOCUMENTS", "MUSIC", "MOVIES", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DirType extends Enum<DirType> {
        public static final DirType DCIM = null;
        public static final DirType DOCUMENTS = null;
        public static final DirType DOWNLOADS = null;
        public static final DirType MOVIES = null;
        public static final DirType MUSIC = null;
        public static final DirType PICTURES = null;
        public static final /* synthetic */ DirType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<DirType> getEntries() {
            return b;
        }

        static {
            DirType r0 = new DirType("PICTURES", 0, Environment.DIRECTORY_PICTURES);
            PICTURES = r0;
            DirType r1 = new DirType("DCIM", 1, Environment.DIRECTORY_DCIM);
            DCIM = r1;
            DirType r2 = new DirType("DOWNLOADS", 2, Environment.DIRECTORY_DOWNLOADS);
            DOWNLOADS = r2;
            DirType r4 = new DirType("DOCUMENTS", 3, Environment.DIRECTORY_DOCUMENTS);
            DOCUMENTS = r4;
            DirType r6 = new DirType("MUSIC", 4, Environment.DIRECTORY_MUSIC);
            MUSIC = r6;
            DirType r8 = new DirType("MOVIES", 5, Environment.DIRECTORY_MOVIES);
            MOVIES = r8;
            DirType[] r10 = {r0, r1, r2, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static DirType[] values() {
            return (DirType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static DirType valueOf(String r1) {
            return (DirType) r27.a.a(DirType.class, r1);
        }

        public DirType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DirType.values().length];
            r0[DirType.DOCUMENTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[DirType.DOWNLOADS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[DirType.MUSIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[DirType.MOVIES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DirType.DCIM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[DirType.PICTURES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public MediaStoreUtil() {
    }

    @JvmStatic
    public static final Uri e(Context r7, String r8, String r9, DirType r10, Token r11) {
        Intrinsics.checkNotNullParameter(r9, "mimeType");
        Intrinsics.checkNotNullParameter(r10, "dirType");
        Intrinsics.checkNotNullParameter(r11, "token");
        return f(r7, r8, r9, r10, r11, 16);
    }

    static {
        a = SetsKt.setOf(new String[]{"doc", "docx", "xls", "xlsx", "pdf", "pps", "ppt", "pptx", "txt"});
    }

    public static DirType h(String r4) {
        Log.i("MediaStoreUtil", "getDirName ... filename: " + r4);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        String r5 = FileUtils.k(r4);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "extension");
        if (a.contains(r5) == true) goto L9;
        String r0 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r5);
        if (r0 != null) goto L13;
        r0 = "*/*";
    L13:
        Log.i("MediaStoreUtil", "getDirName ... mimeType from extension(" + r5 + "): " + r0);
        Intrinsics.checkNotNull(r0);
        if (StringsKt.startsWith$default(r0, "image", false, 2, null) == false) goto L17;
        return DirType.PICTURES;
    L17:
        if (StringsKt.startsWith$default(r0, GlobalAudioSceneEnum.VIDEO, false, 2, null) == false) goto L20;
        return DirType.MOVIES;
    L20:
        if (StringsKt.startsWith$default(r0, "audio", false, 2, null) == false) goto L23;
        return DirType.MUSIC;
    L23:
        return DirType.DOWNLOADS;
    L9:
        return DirType.DOCUMENTS;
    L5:
        return DirType.DOWNLOADS;
    }

    @JvmStatic
    public static final String i(DirType r3) {
        Intrinsics.checkNotNullParameter(r3, "dirType");
        Intrinsics.checkNotNullParameter(r3, "dirType");
        PolarisFileWrapper r0 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(r3.getValue()), "Lark");
        if (r0.exists() == true) goto L7;
        r0.mkdirs();     // Catch: Exception -> L8
    L7:
        return r3.getValue() + File.separator + "Lark";
    }

    public static Uri b(ContentResolver r19, Uri r110, ContentValues r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r110, r20};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240017);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240017, "android/content/ContentResolver", "insert", r19, r1, "android.net.Uri", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Uri) r4.b;
    L21:
        return r19.insert(r110, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @JvmStatic
    public static final void c(File r3, Uri r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "srcFile");
        Intrinsics.checkNotNullParameter(r4, "destUri");
        Intrinsics.checkNotNullParameter(r5, "context");
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r3);     // Catch: IOException -> L24
        OutputStream r6 = ContentResolverWrapper.openOutputStream(r5.getContentResolver(), r4);     // Catch: Throwable -> L19
        if (r6 != null) goto L31;
        Log.e("MediaStoreUtil", "open uri failed:" + r4);     // Catch: Throwable -> L19
    L16:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r2, null);     // Catch: IOException -> L24
        return;
    L31:
        FileUtils.d(r2, r6);     // Catch: Throwable -> L10
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L19
        goto L16
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: IOException -> L24
        throw th;     // Catch: IOException -> L24
    L24:
        e = move-exception;
        Log.d("MediaStoreUtil", e.getMessage());
    }

    @JvmStatic
    public static final void j(Context r1, String r2, Token r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "token");
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        uf7.a.a(r3);     // Catch: SensitiveAPIException -> L7
        Intent r0 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");     // Catch: SensitiveAPIException -> L7
        r0.setData(Uri.fromFile(new PolarisFileWrapper(r2)));     // Catch: SensitiveAPIException -> L7
        r1.sendBroadcast(r0);     // Catch: SensitiveAPIException -> L7
        MediaScannerConnection.scanFile(r1, new String[]{r2}, null, null);     // Catch: SensitiveAPIException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("MediaStoreUtil", "notifySystemScanFile failed", e);
    }

    public static void a(ContentValues r3, String r4, String r5, String r6) {
        long r0 = System.currentTimeMillis();
        r3.put("_display_name", r4);
        r3.put("mime_type", r5);
        r3.put("relative_path", r6);
        r3.put("date_added", Long.valueOf(r0));
    }

    @Deprecated(message = "use psda token", replaceWith = @ReplaceWith(expression = "createMediaStoreUri function with token parameter.", imports = {}))
    @JvmStatic
    public static final Uri d(Context r8, String r9, String r10, DirType r11) {
        Intrinsics.checkNotNullParameter(r10, "mimeType");
        Intrinsics.checkNotNullParameter(r11, "dirType");
        ContentValues r6 = new ContentValues();
        Intrinsics.checkNotNullParameter(r10, "mimeType");
        Intrinsics.checkNotNullParameter(r11, "dirType");
        return g(r8, r9, r10, r11, r6, null);
    }

    public static Uri f(Context r6, String r7, String r8, DirType r9, Token r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        r8 = FileUtils.p(r7);
    L5:
        String r2 = r8;
        if ((r11 & 8) == 0) goto L8;
        r9 = h(r7);
    L8:
        DirType r3 = r9;
        if ((r11 & 16) == 0) goto L11;
        ContentValues r12 = new ContentValues();
    L12:
        Intrinsics.checkNotNullParameter(r2, "mimeType");
        Intrinsics.checkNotNullParameter(r3, "dirType");
        Intrinsics.checkNotNullParameter(r10, "token");
        return g(r6, r7, r2, r3, r12, r10);
    L11:
        r12 = null;
        goto L12
    }

    @JvmStatic
    public static final Uri g(Context r17, String r19, String r110, DirType r20, ContentValues r21, Token r22) {
        Intrinsics.checkNotNullParameter(r110, "mimeType");
        Intrinsics.checkNotNullParameter(r20, "dirType");
        if (r17 != null) goto L6;
        Log.e("MediaStoreUtil", "context is null");
        return null;
    L6:
        if (r19 != null) goto L8;
    L96:
        Log.e("MediaStoreUtil", "filename is not valid");
        return null;
    L8:
        if (TextUtils.isEmpty(r19) == true) goto L96;
        if (r21 != null) goto L12;
        ContentValues r6 = new ContentValues();
    L13:
        String r7 = i(r20);
        switch(a.a[r20.ordinal()]) {
            case 1: goto L85;
            case 2: goto L73;
            case 3: goto L54;
            case 4: goto L36;
            case 5: goto L18;
            case 6: goto L18;
            default: goto L16;
        };
    L16:
        throw new NoWhenBranchMatchedException();
    L18:
        if (TextUtils.isEmpty(r19) == false) goto L20;
    L71:
        return null;
    L20:
        if (TextUtils.isEmpty(r7) == true) goto L71;
        if (r7.endsWith("/") == true) goto L25;
        r7 = r7.concat("/");
    L25:
        r6.put("_display_name", r19);
        r6.put("mime_type", r110);
        if (Build.VERSION.SDK_INT < 29) goto L28;
        r6.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r0 = MediaStore.Images.Media.getContentUri("external_primary");
        r6.put("relative_path", r7);
    L29:
        if (r22 != null) goto L102;
        Uri r1 = c.a(r17.getContentResolver(), r0, r6);
    L95:
        return r1;
    L102:
        r1 = sf7.a.a.insert(r17.getContentResolver(), r0, r6, r22);     // Catch: SensitiveAPIException -> L32
    L32:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createImageUri failed:" + e.getMessage());
        goto L71
    L28:
        Uri r2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r6.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + "/" + r7 + "/" + r19));
        r0 = r2;
        goto L29
    L36:
        if (TextUtils.isEmpty(r19) == true) goto L71;
        if (TextUtils.isEmpty(r7) == true) goto L71;
        if (r7.endsWith("/") == true) goto L43;
        r7 = r7.concat("/");
    L43:
        r6.put("_display_name", r19);
        r6.put("mime_type", r110);
        if (Build.VERSION.SDK_INT < 29) goto L46;
        r6.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r3 = MediaStore.Video.Media.getContentUri("external_primary");
        r6.put("relative_path", r7);
    L47:
        if (r22 != null) goto L100;
        r1 = c.a(r17.getContentResolver(), r3, r6);
        goto L95
    L100:
        r1 = sf7.a.a.insert(r17.getContentResolver(), r3, r6, r22);     // Catch: SensitiveAPIException -> L50
    L50:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createVideoUri failed:" + e.getMessage());
        goto L71
    L46:
        Uri r4 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r6.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + "/" + r7 + "/" + r19));
        r3 = r4;
        goto L47
    L54:
        if (TextUtils.isEmpty(r19) == true) goto L71;
        if (TextUtils.isEmpty(r7) == true) goto L71;
        if (r7.endsWith("/") == true) goto L61;
        r7 = r7.concat("/");
    L61:
        r6.put("_display_name", r19);
        r6.put("mime_type", r110);
        if (Build.VERSION.SDK_INT < 29) goto L64;
        r6.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        Uri r5 = MediaStore.Audio.Media.getContentUri("external_primary");
        r6.put("relative_path", r7);
    L65:
        if (r22 != null) goto L98;
        r1 = c.a(r17.getContentResolver(), r5, r6);
        goto L95
    L98:
        r1 = sf7.a.a.insert(r17.getContentResolver(), r5, r6, r22);     // Catch: SensitiveAPIException -> L68
    L68:
        e = move-exception;
        Log.e("BdMediaFileSystemWithPSDA", "createMusicUri failed:" + e.getMessage());
        goto L71
    L64:
        Uri r8 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        r6.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + "/" + r7 + "/" + r19));
        r5 = r8;
        goto L65
    L73:
        if (Build.VERSION.SDK_INT <= 29) goto L75;
        boolean r9 = true;
    L76:
        if (r9 == false) goto L83;
        a(r6, r19, r110, i(r20));
        Uri r10 = MediaStore.Downloads.getContentUri("external_primary");
        if (r22 == null) goto L80;
        r1 = sf7.a.a.insert(r17.getContentResolver(), r10, r6, r22);
    L81:
        if (r1 != null) goto L95;
        Log.e("MediaStoreUtil", "create download uri for R failed");
        goto L95
    L80:
        r1 = b(r17.getContentResolver(), r10, r6);
        goto L81
    L83:
        PolarisFileWrapper r11 = new PolarisFileWrapper(i(r20));
        r11.mkdirs();
        r1 = Uri.fromFile(new PolarisFileWrapper(r11, r19));
        goto L95
    L75:
        r9 = false;
        goto L76
    L85:
        if (Build.VERSION.SDK_INT <= 29) goto L87;
        boolean r12 = true;
    L88:
        if (r12 == false) goto L93;
        a(r6, r19, r110, i(r20));
        Uri r13 = MediaStore.Files.getContentUri("external_primary");
        if (r22 == null) goto L92;
        sf7.a r14 = sf7.a.a;
        ContentResolver r15 = r17.getContentResolver();
        Intrinsics.checkNotNull(r13);
        r1 = r14.insert(r15, r13, r6, r22);
        goto L95
    L92:
        r1 = b(r17.getContentResolver(), r13, r6);
        goto L95
    L93:
        PolarisFileWrapper r16 = new PolarisFileWrapper(i(r20));
        r16.mkdirs();
        r1 = Uri.fromFile(new PolarisFileWrapper(r16, r19));
        goto L95
    L87:
        r12 = false;
        goto L88
    L12:
        r6 = r21;
        goto L13
    }
}
