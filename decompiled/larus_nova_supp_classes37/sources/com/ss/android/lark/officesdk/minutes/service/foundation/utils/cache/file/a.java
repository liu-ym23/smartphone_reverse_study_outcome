package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final h a = null;

    static {
        VFSFiles.b.getClass();
        a = VFSFiles.b(true);
    }

    public static VFSFile c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "filePath");
        return a.i(r1);
    }

    public static VFSFile a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "childPath");
        h r0 = a;
        f r1 = f.g;
        return r0.D(LarkFileStorage.f(r4).b(r1, new d(new String[]{"minutes"})).toFile(), r5);
    }

    public static VFSFile b(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "childPath");
        return a.D(r1, r2);
    }
}
