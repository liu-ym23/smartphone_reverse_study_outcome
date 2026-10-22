package com.larksuite.framework.utils.file.direct;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DirectFileAccess {
    public static final c a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$InvalidPathTypeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tag", "", "params", "Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;", "<init>", "(Ljava/lang/String;Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;)V", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class InvalidPathTypeException extends Exception {
        public InvalidPathTypeException(String r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "params");
            super(r2 + ": invalid path type: " + r3.c);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$NullContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tag", "", "params", "Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;", "<init>", "(Ljava/lang/String;Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;)V", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class NullContextException extends Exception {
        public NullContextException(String r2, a r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "params");
            super(r2 + ": context is null, scope: " + r3.a + ", location: " + r3.b);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$PathType;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT", "CACHE", "CODE_CACHE", "FILES", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PathType extends Enum<PathType> {
        public static final PathType CACHE = null;
        public static final PathType CODE_CACHE = null;
        public static final PathType FILES = null;
        public static final PathType ROOT = null;
        public static final /* synthetic */ PathType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PathType> getEntries() {
            return b;
        }

        static {
            PathType r0 = new PathType("ROOT", 0);
            ROOT = r0;
            PathType r1 = new PathType("CACHE", 1);
            CACHE = r1;
            PathType r3 = new PathType("CODE_CACHE", 2);
            CODE_CACHE = r3;
            PathType r5 = new PathType("FILES", 3);
            FILES = r5;
            PathType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static PathType[] values() {
            return (PathType[]) a.clone();
        }

        public static PathType valueOf(String r1) {
            return (PathType) r27.a.a(PathType.class, r1);
        }

        public PathType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$ScopedStorage;", "", "<init>", "(Ljava/lang/String;I)V", "APP", "SHARED", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ScopedStorage extends Enum<ScopedStorage> {
        public static final ScopedStorage APP = null;

        @Deprecated(message = "use MediaStore or SAF instead")
        public static final ScopedStorage SHARED = null;
        public static final /* synthetic */ ScopedStorage[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScopedStorage> getEntries() {
            return b;
        }

        static {
            ScopedStorage r0 = new ScopedStorage("APP", 0);
            APP = r0;
            ScopedStorage r1 = new ScopedStorage("SHARED", 1);
            SHARED = r1;
            ScopedStorage[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ScopedStorage[] values() {
            return (ScopedStorage[]) a.clone();
        }

        public static ScopedStorage valueOf(String r1) {
            return (ScopedStorage) r27.a.a(ScopedStorage.class, r1);
        }

        public ScopedStorage(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageLocation;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL", "EXTERNAL", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StorageLocation extends Enum<StorageLocation> {
        public static final StorageLocation EXTERNAL = null;
        public static final StorageLocation INTERNAL = null;
        public static final /* synthetic */ StorageLocation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StorageLocation> getEntries() {
            return b;
        }

        static {
            StorageLocation r0 = new StorageLocation("INTERNAL", 0);
            INTERNAL = r0;
            StorageLocation r1 = new StorageLocation("EXTERNAL", 1);
            EXTERNAL = r1;
            StorageLocation[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static StorageLocation[] values() {
            return (StorageLocation[]) a.clone();
        }

        public static StorageLocation valueOf(String r1) {
            return (StorageLocation) r27.a.a(StorageLocation.class, r1);
        }

        public StorageLocation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ int i = 0;
        public final ScopedStorage a;
        public final StorageLocation b;
        public final PathType c;
        public final String d;
        public final Context e;
        public final Set<String> f;
        public final z28.b g;
        public final z28.a h;

        /* JADX INFO: renamed from: com.larksuite.framework.utils.file.direct.DirectFileAccess$a$a, reason: collision with other inner class name */
        public static final class C0054a {
            public final ScopedStorage a;
            public StorageLocation b;
            public PathType c;
            public Context d;
            public final Set<String> e;
            public final c f;

            public C0054a() {
                this.a = ScopedStorage.APP;
                this.b = StorageLocation.INTERNAL;
                this.c = PathType.FILES;
                this.e = SetsKt.setOf("mounted");
                this.f = DirectFileAccess.a;
            }
        }

        public static final class b {
        }

        static {
        }

        public a() {
            this(null, null, null, null, 255);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            ScopedStorage r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            StorageLocation r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            PathType r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Context r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (((r12 + r14) * 31) + this.f.hashCode()) * 31;
            z28.b r16 = this.g;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r19 = (r15 + r17) * 31;
            z28.a r20 = this.h;
            if (r20 == null) goto L31;
            r1 = r20.hashCode();
        L31:
            return r19 + r1;
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StorageParams(scope=" + this.a + ", location=" + this.b + ", pathType=" + this.c + ", type=" + this.d + ", context=" + this.e + ", storageState=" + this.f + ", log=" + this.g + ", contextGet=" + this.h + ')';
        }

        public final Context getContext() {
            return this.e;
        }

        public final String getType() {
            return this.d;
        }

        public static a a(a r9, ScopedStorage r10, Context r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r10 = r9.a;
        L5:
            ScopedStorage r1 = r10;
            if ((r12 & 2) == 0) goto L8;
            StorageLocation r2 = r9.b;
        L10:
            if ((r12 & 4) == 0) goto L12;
            PathType r3 = r9.c;
        L14:
            if ((r12 & 8) == 0) goto L16;
            String r4 = r9.d;
        L18:
            if ((r12 & 16) == 0) goto L20;
            r11 = r9.e;
        L20:
            Context r5 = r11;
            if ((r12 & 32) == 0) goto L23;
            Set<String> r6 = r9.f;
        L25:
            if ((r12 & 64) == 0) goto L27;
            z28.b r7 = r9.g;
        L29:
            if ((r12 & 128) == 0) goto L31;
            z28.a r8 = r9.h;
        L32:
            Intrinsics.checkNotNullParameter(r6, "storageState");
            return new a(r1, r2, r3, r4, r5, r6, r7, r8);
        L31:
            r8 = null;
            goto L32
        L27:
            r7 = null;
            goto L29
        L23:
            r6 = null;
            goto L25
        L16:
            r4 = null;
            goto L18
        L12:
            r3 = null;
            goto L14
        L8:
            r2 = null;
            goto L10
        }

        public /* synthetic */ a(ScopedStorage r10, StorageLocation r11, String r12, Context r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            r10 = ScopedStorage.APP;
        L5:
            ScopedStorage r1 = r10;
            if ((r14 & 2) == 0) goto L8;
            r11 = StorageLocation.INTERNAL;
        L8:
            StorageLocation r2 = r11;
            if ((r14 & 4) == 0) goto L11;
            PathType r3 = PathType.FILES;
        L13:
            if ((r14 & 8) == 0) goto L15;
            String r4 = null;
        L17:
            if ((r14 & 16) == 0) goto L19;
            Context r5 = null;
        L21:
            if ((r14 & 32) == 0) goto L23;
            Set r6 = SetsKt.setOf("mounted");
        L25:
            if ((r14 & 64) == 0) goto L27;
            c r7 = DirectFileAccess.a;
        L29:
            if ((r14 & 128) == 0) goto L31;
            c r15 = DirectFileAccess.a;
        L31:
            this(r1, r2, r3, r4, r5, r6, r7, null);
            return;
        L27:
            r7 = null;
            goto L29
        L23:
            r6 = null;
            goto L25
        L19:
            r5 = r13;
            goto L21
        L15:
            r4 = r12;
            goto L17
        L11:
            r3 = null;
            goto L13
        }

        public a(ScopedStorage r2, StorageLocation r3, PathType r4, String r5, Context r6, Set<String> r7, z28.b r8, z28.a r9) {
            Intrinsics.checkNotNullParameter(r7, "storageState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ScopedStorage.values().length];
            r0[ScopedStorage.APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ScopedStorage.SHARED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[StorageLocation.values().length];
            r1[StorageLocation.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[StorageLocation.EXTERNAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    public static final class c implements z28.b {
        public c() {
        }

        @Override // z28.b
        public final void exception(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            c r0 = DirectFileAccess.a;
            if (DevEnvUtil.isDebugMode(null) == true) goto L5;
            return;
        L5:
            throw r2;
        }

        @Override // z28.b
        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            Log.e(r2, r3);
        }
    }

    static {
        a = new c();
    }

    @JvmStatic
    public static final File a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        ScopedStorage r1 = r3.a;
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L21;
        Intrinsics.checkNotNullParameter(r3, "params");
        if (d(r3) == false) goto L22;
        int r0 = a38.a.a;
        String r4 = r3.getType();
        if (r4 == null) goto L24;
        Intrinsics.checkNotNullParameter(r4, "type");
        File r5 = Environment.getExternalStoragePublicDirectory(r4);
        if (r5 == null) goto L24;
        return r5;
    L24:
        return Environment.getExternalStorageDirectory();
    L22:
        return b(r3);
    L21:
        return a(a.a(r3, ScopedStorage.APP, null, 254));
    L20:
        return c(r3);
    L5:
        r2 = b.a[r1.ordinal()];
        goto L7
    }

    public static File b(a r3) {
        int r0 = com.larksuite.framework.utils.file.direct.b.a;
        Intrinsics.checkNotNullParameter(r3, "params");
        PathType r1 = r3.c;
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 != 1) goto L9;
        Intrinsics.checkNotNullParameter(r3, "params");
        Context r4 = r3.getContext();
        if (r4 != null) goto L29;
    L32:
        return null;
    L29:
        if (Build.VERSION.SDK_INT < 24) goto L38;
        return r4.getDataDir();
    L38:
        return new PolarisFileWrapper(r4.getApplicationInfo().dataDir);
    L9:
        if (r2 != 2) goto L11;
        Intrinsics.checkNotNullParameter(r3, "params");
        Context r5 = r3.getContext();
        if (r5 == null) goto L32;
        return r5.getCacheDir();
    L11:
        if (r2 != 3) goto L13;
        Intrinsics.checkNotNullParameter(r3, "params");
        Context r6 = r3.getContext();
        if (r6 == null) goto L32;
        return r6.getCodeCacheDir();
    L13:
        if (r2 == 4) goto L17;
        z28.b r7 = r3.g;
        if (r7 == null) goto L32;
        r7.e("AppInternalPathUtils", "invalid path type: " + r3.c);
        r7.exception(new InvalidPathTypeException("AppInternalPathUtils", r3));
        goto L32
    L17:
        Intrinsics.checkNotNullParameter(r3, "params");
        Context r8 = r3.getContext();
        if (r8 == null) goto L32;
        return r8.getFilesDir();
    L5:
        r2 = com.larksuite.framework.utils.file.direct.b.a.a[r1.ordinal()];
        goto L7
    }

    @JvmStatic
    public static final File c(a r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        File r2 = null;
        if (r6.getContext() != null) goto L19;
        z28.a r0 = r6.h;
        if (r0 == null) goto L7;
        Context r1 = r0.getContext();
    L8:
        z28.b r3 = r6.g;
        if (r3 == null) goto L11;
        r3.e("DirectFileAccess", "context is null");
    L11:
        if (r1 == null) goto L17;
        z28.b r4 = r6.g;
        if (r4 == null) goto L16;
        r4.exception(new NullContextException("DirectFileAccess", r6));
    L16:
        return c(a.a(r6, null, r1, 239));
    L17:
        return null;
    L7:
        r1 = null;
        goto L8
    L19:
        if (r6.b == StorageLocation.EXTERNAL) goto L21;
    L24:
        StorageLocation r5 = r6.b;
        int r7 = -1;
        if (r5 != null) goto L27;
        int r8 = -1;
    L29:
        if (r8 == 1) goto L72;
        if (r8 != 2) goto L75;
        int r9 = com.larksuite.framework.utils.file.direct.a.a;
        Intrinsics.checkNotNullParameter(r6, "params");
        PathType r10 = r6.c;
        if (r10 == null) goto L37;
        r7 = com.larksuite.framework.utils.file.direct.a.C0055a.a[r10.ordinal()];
    L37:
        if (r7 == 1) goto L65;
        if (r7 != 2) goto L40;
        Intrinsics.checkNotNullParameter(r6, "params");
        Context r11 = r6.getContext();     // Catch: Exception -> L64
        if (r11 == null) goto L68;
        r2 = r11.getExternalFilesDir(r6.getType());     // Catch: Exception -> L64
    L68:
        if (r2 != null) goto L77;
        return b(r6);
    L77:
        return r2;
    L40:
        if (r7 == 3) goto L44;
        z28.b r12 = r6.g;
        if (r12 == null) goto L68;
        r12.e("AppExternalPathUtils", "invalid path type " + r6.c);
        r12.exception(new InvalidPathTypeException("AppExternalPathUtils", r6));
        goto L68
    L44:
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r6, "params");
        Context r13 = r6.getContext();
        if (r13 == null) goto L47;
        File r14 = r13.getExternalCacheDir();
    L48:
        if (r14 == null) goto L50;
        File r15 = r14.getParentFile();
    L51:
        if (r15 == null) goto L53;
    L52:
        r2 = r15;
        goto L68
    L53:
        Context r16 = r6.getContext();
        if (r16 == null) goto L56;
        String r17 = r16.getPackageName();
    L57:
        if (r17 == null) goto L68;
        r2 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + "/Android/data/" + r6.getContext().getPackageName());
        goto L68
    L56:
        r17 = null;
        goto L57
    L50:
        r15 = null;
        goto L51
    L47:
        r14 = null;
        goto L48
    L65:
        Intrinsics.checkNotNullParameter(r6, "params");
        Context r19 = r6.getContext();
        if (r19 == null) goto L68;
        r15 = r19.getExternalCacheDir();
        goto L52
    L75:
        return b(r6);
    L72:
        return b(r6);
    L27:
        r8 = b.b[r5.ordinal()];
        goto L29
    L21:
        if (d(r6) == true) goto L24;
        return b(r6);
    }

    public static boolean d(a r2) {
        return r2.f.contains(Environment.getExternalStorageState());
    L4:
        Set<String> r0 = r2.f;     // Catch: Throwable -> L9
        Context r3 = r2.getContext();     // Catch: Throwable -> L9
        File r1 = null;
        if (r3 == null) goto L7;
        r1 = r3.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L7:
        return r0.contains(Environment.getExternalStorageState(r1));
    L9:
        return true;
    }
}
