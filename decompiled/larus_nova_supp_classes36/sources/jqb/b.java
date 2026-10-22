package jqb;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements UniPathProvider {

    public static final class a {
    }

    static {
    }

    public b() {
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
    public final String a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new PolarisFileWrapper(r3.getExternalCacheDir(), "/lark/location/map").getAbsolutePath();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r5) {
        Intrinsics.checkNotNullParameter(r5, "space");
        return r5.b(f.e, new d(new String[]{"CORE", "location/map"}));
    L5:
        VFSFiles.b.getClass();
        return VFSFiles.b(false).z(a(com.larksuite.framework.utils.b.a));
    }
}
