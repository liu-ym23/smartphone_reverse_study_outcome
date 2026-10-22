package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import io.reactivex.functions.Action;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Action {
    public static final c a = null;

    public static final class a implements FileFilter {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r7) {
            long r0 = System.currentTimeMillis() - r7.lastModified();
            if (StringsKt.startsWith$default(r7.getName(), "/vip_broadcast", false, 2, null) == true) goto L5;
            return false;
        L5:
            if (r0 <= TimeUnit.DAYS.toMillis(2)) goto L9;
            return true;
        L9:
            return false;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public final void run() {
        File r0 = (File) AudioRecordHelper.f.getValue();
        int r2 = 0;
        if (r0.exists() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L20;
        File[] r3 = r0.listFiles(a.a);
        if (r3 == null) goto L24;
        int r4 = r3.length;
    L15:
        if (r2 >= r4) goto L25;
        File r5 = r3[r2];
        if (r5.isFile() == false) goto L19;
        r5.delete();
    L19:
        r2 = r2 + 1;
        goto L15
    L25:
        return;
    L24:
        return;
    L20:
        return;
    L5:
        if (r0.isDirectory() == false) goto L7;
        r1 = true;
        goto L8
    }
}
