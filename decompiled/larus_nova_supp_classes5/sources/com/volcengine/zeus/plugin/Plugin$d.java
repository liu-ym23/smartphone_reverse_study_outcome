package com.volcengine.zeus.plugin;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.File;
import java.io.FileFilter;
import mqc.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Plugin$d implements FileFilter {
    public final /* synthetic */ String a;
    public final /* synthetic */ Plugin b;

    @Override // java.io.FileFilter
    public final boolean accept(File r4) {
        if (r4 != null) goto L5;
    L13:
        return false;
    L5:
        if (r4.getName().startsWith("preversion-") == true) goto L13;
        if (this.a.equals(r4.getName()) == true) goto L13;
        if ("data".equals(r4.getName()) == true) goto L13;
        mqc.i.e(new PolarisFileWrapper(r4.getAbsolutePath()));
        ZeusLogger.w("Zeus/init_zeus", "Plugin deleteOtherExpired " + r4.getAbsolutePath());
        if (r4.getName().matches("^version-(\\d+)$") == false) goto L13;
        t.c().j(this.b.mPkgName, CastIntegerProtector.parseInt(r4.getName().split("-")[1]), false);
        goto L13
    }

    public Plugin$d(Plugin r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
