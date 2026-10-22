package com.ss.android.lark.core.storage;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.h;
import com.suite.lark.platform.component.storage.file.dirs.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = FeatureGatingModule.getFeatureGatingService().isEnable("im.messager.unistore.file.core_hz");
    }

    @JvmStatic
    public static final VFSPath a() {
        int r0 = h.c;
        h r1 = h.a.a(com.larksuite.framework.utils.b.a);
        r1.c(c());
        com.suite.lark.platform.component.storage.file.dirs.e r2 = new com.suite.lark.platform.component.storage.file.dirs.e();
        Intrinsics.checkNotNullParameter(r2, "pathProvider");
        return r1.a(r2).a();
    }

    @JvmStatic
    public static final VFSPath b() {
        int r0 = h.c;
        h r1 = h.a.a(com.larksuite.framework.utils.b.a);
        r1.c(c());
        l r2 = new l();
        Intrinsics.checkNotNullParameter(r2, "pathProvider");
        return r1.a(r2).a();
    }

    @JvmStatic
    public static final com.ss.android.lark.vfs.h c() {
        VFSFiles r0 = VFSFiles.b;
        boolean r1 = a;
        r0.getClass();
        return VFSFiles.b(r1);
    }
}
