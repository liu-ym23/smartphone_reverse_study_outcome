package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import android.os.Environment;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements UniPathProvider {
    public j() {
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
        String r4 = com.ss.android.lark.diskmanage.storage.d.e(r3);
    L13:
        FileUtils.t(r4);
        return r4;
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        StringBuilder r5 = new StringBuilder();
        File r0 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (r0 != null) goto L9;
        String r2 = "";
    L12:
        r5.append(r2);
        r5.append("/Lark/");
        r4 = r5.toString();
        FileUtils.t(r4);
        goto L13
    L9:
        if (r0.exists() == true) goto L11;
        r0.mkdir();
    L11:
        r2 = r0.getAbsolutePath();
        goto L12
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r3) {
        Intrinsics.checkNotNullParameter(r3, "space");
        VFSPath r4 = r3.b(com.ss.android.lark.storage.f.j, null);
        FileUtils.t(r4.getRealPath());
        return r4;
    }
}
