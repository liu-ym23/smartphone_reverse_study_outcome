package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements UniPathProvider {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final synchronized String a(Context r4, String r5) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L7
            String r6 = new k().d(LarkFileStorage.b()).getRealPath();     // Catch: Throwable -> L7
            Log.i("RustAvatarDir", "return dir of " + r5 + ": " + r6);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r6;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        a = new a();
    }

    public k() {
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
        Intrinsics.checkNotNullParameter(r3, "context");
        StringBuilder r0 = new StringBuilder();
        r0.append(com.ss.android.lark.diskmanage.storage.d.j(r3));
        String r4 = File.separator;
        r0.append(r4);
        r0.append("rust_avatar");
        r0.append(r4);
        return r0.toString();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r4) {
        Intrinsics.checkNotNullParameter(r4, "space");
        return r4.b(com.ss.android.lark.storage.f.e, new com.ss.android.lark.storage.d(new String[]{"rust_avatar"}));
    }
}
