package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements UniPathProvider {
    public g() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.LARK;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = com.ss.android.lark.diskmanage.storage.d.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        if (StoragePermissionUtils.e(r3) == true) goto L5;
        String r4 = com.ss.android.lark.diskmanage.storage.d.b(r3);
    L6:
        FileUtils.t(r4);
        return r4;
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        r4 = com.ss.android.lark.diskmanage.storage.d.l(r3) + "download" + File.separator;
        FileUtils.t(r4);
        goto L6
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r4) {
        Intrinsics.checkNotNullParameter(r4, "space");
        return r4.b(com.ss.android.lark.storage.f.i, new com.ss.android.lark.storage.d(new String[]{"download"}));
    }
}
