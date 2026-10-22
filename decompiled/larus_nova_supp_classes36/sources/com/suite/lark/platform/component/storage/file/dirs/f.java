package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSPath;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements UniPathProvider {
    public static final ConcurrentHashMap<String, Object> a = null;

    public static final class a {
    }

    public f() {
    }

    static {
        a = new ConcurrentHashMap();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        return com.ss.android.lark.diskmanage.storage.d.h(r2);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r10) {
        Intrinsics.checkNotNullParameter(r10, "space");
        com.ss.android.lark.storage.f r0 = com.ss.android.lark.storage.f.e;
        VFSPath r1 = r10.b(r0, new com.ss.android.lark.storage.d(new String[]{"image_compressed"}));
        ConcurrentHashMap<String, Object> r3 = a;
        if (r3.contains(r1.getRealPath()) == true) goto L6;
        FileSystemManager.a r4 = FileSystemManager.a();
        r4.c(r1.getRealPath());
        r4.a(new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null));
        r4.b(false);
        r3.put(r1.getRealPath(), 0);
        return r10.b(r0, new com.ss.android.lark.storage.d(new String[]{"image_compressed"}));
    L6:
        return r1;
    }
}
