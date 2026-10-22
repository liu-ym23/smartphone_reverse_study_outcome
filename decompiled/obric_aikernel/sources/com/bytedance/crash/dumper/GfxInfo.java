package com.bytedance.crash.dumper;

import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class GfxInfo {
    private static final String FILE_NAME = "gfxinfo.txt";

    public GfxInfo() {
    }

    public static void dump(File r10) {
        FileOutputStream r11 = null;
        Class<?> r12 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L9
        Object r13 = r12.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        Method r14 = r12.getDeclaredMethod("dumpGfxInfo", new Class[]{FileDescriptor.class, String[].class});     // Catch: Throwable -> L9
        r14.setAccessible(true);     // Catch: Throwable -> L9
        FileOutputStream r15 = new FileOutputStream(new File(r10, FILE_NAME));     // Catch: Throwable -> L9
        r14.invoke(r13, new Object[]{r15.getFD(), new String[0]});     // Catch: Throwable -> L6
        FileSystemUtils.close(r15);
        return;
    L6:
        r11 = r15;
    L7:
        FileSystemUtils.close(r11);
    }
}
