package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements UniPathProvider {

    /* JADX INFO: renamed from: com.suite.lark.platform.component.storage.file.dirs.a$a, reason: collision with other inner class name */
    public static final class C0240a {
    }

    static {
    }

    public a() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        if (UniPathProvider.SpaceType.USER != UniPathProvider.SpaceType.LARK) goto L6;
        return LarkFileStorage.b();
    L6:
        return LarkFileStorage.c();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = com.ss.android.lark.diskmanage.storage.d.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        String r4 = com.ss.android.lark.diskmanage.storage.d.i(r3) + "/audio/";
        FileUtils.t(r4);
        return r4;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r4) {
        Intrinsics.checkNotNullParameter(r4, "space");
        return r4.b(com.ss.android.lark.storage.f.e, new com.ss.android.lark.storage.d(new String[]{TextInputPluginHitPoint.Scene.AUDIO}));
    }
}
