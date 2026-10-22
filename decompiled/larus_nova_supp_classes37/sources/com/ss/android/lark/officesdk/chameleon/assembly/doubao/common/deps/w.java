package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import java.io.InputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class w implements ntb.v {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StorageVolume.values().length];
            r0[StorageVolume.INTERNAL_FILES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[StorageVolume.INTERNAL_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[StorageVolume.INTERNAL_ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[StorageVolume.EXTERNAL_FILES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[StorageVolume.EXTERNAL_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[StorageVolume.PUBLIC_ROOT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[StorageVolume.PUBLIC_PICTURES.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    public w() {
    }

    @Override // ntb.v
    public final boolean e() {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("web_chromium_debugger_type", "key");
        return LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).getBoolean("web_chromium_debugger_type", true);
    }

    @Override // ntb.v
    public final String getString() {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String r0 = LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).getString("cachedChromium", "");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // ntb.v
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).putString("cachedChromium", r4);
    }

    @Override // ntb.v
    public final VFSFile i(String r3) {
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        return VFSFiles.b.i(r3);
    L5:
        e = move-exception;
        Log.e("StorageDependency", "newFile", e);
        return null;
    }

    @Override // ntb.v
    public final InputStream k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        return VFSFiles.b.k(r2);
    }

    @Override // ntb.v
    public final File l0(StorageVolume r12, String... r13) {
        Intrinsics.checkNotNullParameter(r12, "volume");
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter(r13, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
    L16:
        e = move-exception;
        Log.e("StorageDependency", "getFile", e);
        return null;
    L4:
        switch(b.a[r12.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L15;
        };     // Catch: Exception -> L16
    L6:
        com.ss.android.lark.storage.f r14 = com.ss.android.lark.storage.f.j;     // Catch: Exception -> L16
    L13:
        String r15 = ArraysKt.joinToString$default(r13, "/", null, null, 0, null, null, 62, null);     // Catch: Exception -> L16
        VFSPath r16 = LarkFileStorage.b().b(r14, new com.ss.android.lark.storage.d(new com.ss.android.lark.storage.a("open_platform"), r15));     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r16, "<this>");     // Catch: Exception -> L16
        VFSFiles.b.getClass();     // Catch: Exception -> L16
        return VFSFiles.a(r16).r(r16, false);
    L7:
        r14 = com.ss.android.lark.storage.f.i;     // Catch: Exception -> L16
        goto L13
    L8:
        r14 = com.ss.android.lark.storage.f.h;     // Catch: Exception -> L16
        goto L13
    L9:
        r14 = com.ss.android.lark.storage.f.g;     // Catch: Exception -> L16
        goto L13
    L10:
        r14 = com.ss.android.lark.storage.f.f;     // Catch: Exception -> L16
        goto L13
    L11:
        r14 = com.ss.android.lark.storage.f.e;     // Catch: Exception -> L16
        goto L13
    L12:
        r14 = com.ss.android.lark.storage.f.d;     // Catch: Exception -> L16
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L16
    }

    @Override // ntb.v
    public final PolarisFileWrapper A(Context r1, Uri r2, boolean r3) {
        return m0.b(r1, r2, r3);
    }
}
