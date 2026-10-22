package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements UniPathProvider {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UniPathProvider.SpaceType.values().length];
            r0[UniPathProvider.SpaceType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[UniPathProvider.SpaceType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public l() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        UniPathProvider.SpaceType r0 = UniPathProvider.SpaceType.USER;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return LarkFileStorage.e();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return LarkFileStorage.b();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        return com.ss.android.lark.diskmanage.storage.d.q(r2);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r4) {
        Intrinsics.checkNotNullParameter(r4, "space");
        return com.ss.android.lark.storage.file.a.a.a(r4, new com.ss.android.lark.storage.d(new String[]{"share_temp", ""}));
    }
}
