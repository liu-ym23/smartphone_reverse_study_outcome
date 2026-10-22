package leb;

import android.content.Context;
import com.ss.android.lark.core.storage.CoreStorage;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements UniPathProvider {
    public a() {
    }

    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    public final String a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return com.ss.android.lark.diskmanage.storage.d.a(r2);
    }

    public final VFSPath d(FileStorage r5) {
        Intrinsics.checkNotNullParameter(r5, "space");
        return r5.b(com.ss.android.lark.storage.f.g, new com.ss.android.lark.storage.d(CoreStorage.a, "/avatar/"));
    L5:
        VFSFiles.b.getClass();
        return VFSFiles.b(false).z(a(com.larksuite.framework.utils.b.a));
    }
}
