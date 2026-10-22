package com.bytedance.crash.dumper;

import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class GfxInfo {
    private static final String FILE_NAME = "gfxinfo.txt";

    public GfxInfo() {
    }

    public static void dump(File r9) {
        FileOutputStream r0 = null;
        Class r1 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r2 = r1.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        Method r3 = r1.getDeclaredMethod("dumpGfxInfo", new Class[]{FileDescriptor.class, String[].class});     // Catch: Throwable -> L9
        r3.setAccessible(true);     // Catch: Throwable -> L9
        FileOutputStream r4 = new FileOutputStream(new File(r9, FILE_NAME));     // Catch: Throwable -> L9
        r3.invoke(r2, new Object[]{r4.getFD(), new String[0]});     // Catch: Throwable -> L6
        FileSystemUtils.close(r4);
        return;
    L6:
        r0 = r4;
    L7:
        FileSystemUtils.close(r0);
    }
}
