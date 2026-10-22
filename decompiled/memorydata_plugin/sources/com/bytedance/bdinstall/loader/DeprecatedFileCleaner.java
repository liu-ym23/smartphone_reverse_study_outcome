package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Environment;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.bytedance.common.utility.io.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class DeprecatedFileCleaner implements Runnable {
    private final InstallOptions mOptions;

    public DeprecatedFileCleaner(InstallOptions r1) {
        this.mOptions = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList r2 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.mOptions.isAnonymous() == false) goto L34;
    L21:
        Iterator r7 = r2.iterator();
    L23:
        if (r7.hasNext() == false) goto L29;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        a.a(r0);     // Catch: Throwable -> L27
        DrLog.v("dt " + r0);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L34:
        r2.add(Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L30:
        r2.add(Environment.getExternalStorageDirectory().getPath() + "/" + StringEncryptUtils.getBytedanceString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L4:
        if (this.mOptions.isAnonymous() == false) goto L6;
        String r3 = "device_id";
    L7:
        r2.add(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalCacheDir().getParent() + "/" + r3);     // Catch: Throwable -> L9
        goto L12
    L6:
        r3 = StringEncryptUtils.getBytedanceString();     // Catch: Throwable -> L9
        goto L7
    }
}
