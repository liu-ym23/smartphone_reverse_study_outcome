package com.bytedance.bdinstall.loader;

import android.os.Environment;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import java.util.ArrayList;
import java.util.Iterator;
import s1.a;

/* JADX INFO: loaded from: classes.dex */
final class DeprecatedFileCleaner implements Runnable {
    private final InstallOptions mOptions;

    public DeprecatedFileCleaner(InstallOptions r10) {
        this.mOptions = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList r10 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.mOptions.isAnonymous() == false) goto L30;
    L21:
        Iterator r11 = r10.iterator();
    L23:
        if (r11.hasNext() == false) goto L29;
        String r12 = (String) r11.next();
        a.b(r12);     // Catch: Throwable -> L27
        DrLog.v("dt " + r12);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L30:
        r10.add(Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L36:
        r10.add(Environment.getExternalStorageDirectory().getPath() + "/" + StringEncryptUtils.getBytedanceString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L4:
        if (this.mOptions.isAnonymous() == false) goto L6;
        String r13 = "device_id";
    L7:
        r10.add(this.mOptions.getContext().getExternalCacheDir().getParent() + "/" + r13);     // Catch: Throwable -> L9
        goto L12
    L6:
        r13 = StringEncryptUtils.getBytedanceString();     // Catch: Throwable -> L9
        goto L7
    }
}
