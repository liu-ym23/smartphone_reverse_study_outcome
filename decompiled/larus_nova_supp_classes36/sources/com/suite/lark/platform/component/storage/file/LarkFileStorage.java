package com.suite.lark.platform.component.storage.file;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.e;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.storage.file.RootDirResolver;
import com.ss.android.lark.storage.file.USFFileSystemProvider;
import com.ss.android.lark.storage.file.d;
import com.ss.android.lark.vfs.Schemes;
import com.ss.android.lark.vfs.c;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LarkFileStorage {
    public static volatile Application a;
    public static volatile a b;
    public static final HashMap<String, FileStorage> c = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/storage/file/LarkFileStorage$LarkSpaceRootDirResolver;", "Lcom/ss/android/lark/storage/file/FileStorage$DefaultRootDirResolver;", "context", "Landroid/content/Context;", "useNew", "", "<init>", "(Landroid/content/Context;Z)V", "getContext", "()Landroid/content/Context;", "userSpaceDirFormatter", "Lcom/suite/lark/platform/component/storage/file/LarkFileStorage$UserSpaceDirFormatter;", "getRootDir", "", "volume", "Lcom/ss/android/lark/storage/file/IVolume;", "spaceName", "getVolumeRootDir", "volumeParentRoot", "getSpaceDirName", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LarkSpaceRootDirResolver extends FileStorage.DefaultRootDirResolver {
        private final Context context;
        private final boolean useNew;
        private final b userSpaceDirFormatter;

        public final Context getContext() {
            return this.context;
        }

        public LarkSpaceRootDirResolver(Context r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            this.useNew = r3;
            this.userSpaceDirFormatter = new b();
        }

        public String getSpaceDirName(Context r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "spaceName");
            if (Intrinsics.areEqual(r6, "Lark") == true) goto L30;
            b r7 = this.userSpaceDirFormatter;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r6, "userSpace");
            ConcurrentHashMap<String, String> r8 = r7.a;
            String r0 = r8.get(r6);
            if (r0 != null) goto L22;
            StringBuilder r1 = new StringBuilder();
            MessageDigest r2 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
            r2.update(r6.getBytes(Charsets.UTF_8));     // Catch: Exception -> L12
            String r3 = new BigInteger(1, r2.digest()).toString(16);     // Catch: Exception -> L12
            if (24 > r3.length()) goto L14;
            r3 = r3.substring(8, 24);     // Catch: Exception -> L12
        L14:
            r1.append(r3);
            r1.append('_');
            if (r6.length() <= 4) goto L17;
            String r4 = r6.substring(r6.length() - 4);
        L18:
            r1.append(r4);
            r0 = r1.toString();
            String r9 = r8.putIfAbsent(r6, r0);
            if (r9 == null) goto L22;
            r0 = r9;
            goto L22
        L17:
            r4 = r6;
        L12:
            e = move-exception;
            Log.e("LarkFileStorage", "space name md5 failed:", e);
            r3 = r6;
        L22:
            String r10 = r0;
            if (this.useNew == false) goto L25;
            String r11 = "user" + File.separator + r10;
        L27:
            return r11;
        L25:
            r11 = "uz_" + r10;
            goto L27
        L30:
            return r6;
        }

        public String getVolumeRootDir(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "volumeParentRoot");
            Intrinsics.checkNotNullParameter(r3, "spaceName");
            return super.getVolumeRootDir(r2, getSpaceDirName(this.context, r3));
        }

        public String getRootDir(Context r2, com.ss.android.lark.storage.file.b r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "volume");
            Intrinsics.checkNotNullParameter(r4, "spaceName");
            HashMap r0 = f.c;
            return getVolumeRootDir(((f) r3).a(r2, null), r4);
        }
    }

    public static final class LarkUniUriFactory implements d {
        public final Schemes a;
        public final RootDirResolver b;

        public final c b() {
            return new USFFileSystemProvider(this.a.getValue(), this.b);
        }

        public LarkUniUriFactory(Schemes r2, LarkSpaceRootDirResolver r3) {
            Intrinsics.checkNotNullParameter(r2, "supportScheme");
            Intrinsics.checkNotNullParameter(r3, "rootDirResolver");
            this.a = r2;
            this.b = r3;
        }

        public final Uri a(Context r2, final com.ss.android.lark.storage.file.b r3, final String r4, RootDirResolver r5, final com.ss.android.lark.storage.d r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "volume");
            Intrinsics.checkNotNullParameter(r4, "spaceName");
            Intrinsics.checkNotNullParameter(r5, "rootDirResolver");
            String r7 = com.ss.android.lark.storage.file.c.e;
            Function1<com.ss.android.lark.storage.file.c.b, Unit> r8 = new LarkFileStorage$LarkUniUriFactory$customVFSUri$1(this, r4, r3, r6);
            Intrinsics.checkNotNullParameter(r8, "block");
            com.ss.android.lark.storage.file.c.b r9 = new com.ss.android.lark.storage.file.c.b();
            r8.invoke(r9);
            if (((e.a) r9).a != null) goto L6;
            ((e.a) r9).a = com.ss.android.lark.storage.file.c.e;
        L6:
            return UriProtector.parse(new com.ss.android.lark.storage.file.c(r9).a());
        }
    }

    public interface a {
        String a();
    }

    public static final class b {
        public final ConcurrentHashMap<String, String> a;

        public b() {
            this.a = new ConcurrentHashMap();
        }
    }

    @JvmStatic
    public static final FileStorage b() {
        return a("Lark", false);
    }

    static {
        c = new HashMap();
    }

    @Deprecated(message = "use userSpace2(userId)  instead if possible")
    @JvmStatic
    public static final FileStorage c() {
        a r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L8:
        return d(r1);
    L6:
        r1 = "";
        goto L8
    }

    @Deprecated(message = "use userSpace2(userId)  instead if possible")
    @JvmStatic
    public static final FileStorage e() {
        a r0 = b;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L8:
        return f(r1);
    L6:
        r1 = "";
        goto L8
    }

    @Deprecated(message = "use userSpace2 instead if possible")
    @JvmStatic
    public static final FileStorage d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        return a(r1, false);
    }

    @JvmStatic
    public static final FileStorage f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        return a(r1, true);
    }

    public static FileStorage a(String r5, boolean r6) {
        FileStorage r0 = c.get(r5 + '_' + r6);
        if (r0 != null) goto L18;
        Application r1 = a;
        Application r2 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r1 = null;
    L7:
        LarkSpaceRootDirResolver r3 = new LarkSpaceRootDirResolver(r1, r6);
        if (r6 == false) goto L10;
        Schemes r7 = Schemes.USF2;
    L11:
        LarkUniUriFactory r4 = new LarkUniUriFactory(r7, r3);
        Application r8 = a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L15:
        FileStorage.a r9 = new FileStorage.a(r2);
        Intrinsics.checkNotNullParameter(r5, "spaceName");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r9.b = r5;
        Intrinsics.checkNotNullParameter(r4, "uriFactory");
        r9.d = r4;
        Intrinsics.checkNotNullParameter(r3, "rootDirResolver");
        r9.c = r3;
        return new FileStorage(r9);
    L14:
        r2 = r8;
        goto L15
    L10:
        r7 = Schemes.USF;
        goto L11
    L18:
        return r0;
    }
}
