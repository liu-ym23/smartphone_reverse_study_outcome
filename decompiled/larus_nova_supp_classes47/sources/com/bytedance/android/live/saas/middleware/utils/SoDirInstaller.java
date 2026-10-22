package com.bytedance.android.live.saas.middleware.utils;

import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class SoDirInstaller {
    private static final String TAG = "Tinker.LoadLibrary";

    public static final class V14 {
        private V14() {
        }

        public static /* synthetic */ void access$200(ClassLoader r0, File r1) throws Throwable {
            install(r0, r1);
        }

        private static void install(ClassLoader r8, File r9) throws Throwable {
            Object r10 = SoReflectUtil.findField(r8, "pathList").get(r8);
            Field r0 = SoReflectUtil.findField(r10, "nativeLibraryDirectories");
            File[] r1 = (File[]) r0.get(r10);
            ArrayList r2 = new ArrayList(r1.length + 1);
            r2.add(r9);
            int r3 = r1.length;
            int r5 = 0;
        L3:
            if (r5 >= r3) goto L8;
            File r6 = r1[r5];
            if (r9.equals(r6) == true) goto L7;
            r2.add(r6);
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            r0.set(r10, r2.toArray(new File[0]));
        }
    }

    public static final class V23 {
        private V23() {
        }

        public static /* synthetic */ void access$100(ClassLoader r0, File r1) throws Throwable {
            install(r0, r1);
        }

        private static void install(ClassLoader r6, File r7) throws Throwable {
            Object r8 = SoReflectUtil.findField(r6, "pathList").get(r6);
            List r0 = (List) SoReflectUtil.findField(r8, "nativeLibraryDirectories").get(r8);
            if (r0 != null) goto L5;
            r0 = new ArrayList(2);
        L5:
            Iterator r2 = r0.iterator();
        L7:
            if (r2.hasNext() == false) goto L11;
            if (r7.equals((File) r2.next()) == false) goto L7;
            r2.remove();
        L11:
            ListProtector.add(r0, 0, r7);
            List r9 = (List) SoReflectUtil.findField(r8, "systemNativeLibraryDirectories").get(r8);
            if (r9 != null) goto L14;
            r9 = new ArrayList(2);
        L14:
            ArrayList r3 = new ArrayList((r0.size() + r9.size()) + 1);
            r3.addAll(r0);
            r3.addAll(r9);
            SoReflectUtil.findField(r8, "nativeLibraryPathElements").set(r8, (Object[]) SoReflectUtil.findMethod(r8, "makePathElements", new Class[]{List.class, File.class, List.class}).invoke(r8, new Object[]{r3, null, new ArrayList()}));
        }
    }

    public static final class V25 {
        private V25() {
        }

        public static /* synthetic */ void access$000(ClassLoader r0, File r1) throws Throwable {
            install(r0, r1);
        }

        private static void install(ClassLoader r5, File r6) throws Throwable {
            Object r7 = SoReflectUtil.findField(r5, "pathList").get(r5);
            List r0 = (List) SoReflectUtil.findField(r7, "nativeLibraryDirectories").get(r7);
            if (r0 != null) goto L5;
            r0 = new ArrayList(2);
        L5:
            Iterator r2 = r0.iterator();
        L7:
            if (r2.hasNext() == false) goto L11;
            if (r6.equals((File) r2.next()) == false) goto L7;
            r2.remove();
        L11:
            ListProtector.add(r0, 0, r6);
            List r8 = (List) SoReflectUtil.findField(r7, "systemNativeLibraryDirectories").get(r7);
            if (r8 != null) goto L14;
            r8 = new ArrayList(2);
        L14:
            ArrayList r1 = new ArrayList((r0.size() + r8.size()) + 1);
            r1.addAll(r0);
            r1.addAll(r8);
            SoReflectUtil.findField(r7, "nativeLibraryPathElements").set(r7, (Object[]) SoReflectUtil.findMethod(r7, "makePathElements", new Class[]{List.class}).invoke(r7, new Object[]{r1}));
        }
    }

    public static final class V4 {
        private V4() {
        }

        public static /* synthetic */ void access$300(ClassLoader r0, File r1) throws Throwable {
            install(r0, r1);
        }

        private static void install(ClassLoader r8, File r9) throws Throwable {
            String r10 = r9.getPath();
            Field r0 = SoReflectUtil.findField(r8, "libPath");
            String[] r1 = ((String) r0.get(r8)).split(":");
            StringBuilder r2 = new StringBuilder(r10);
            int r3 = r1.length;
            int r5 = 0;
        L3:
            if (r5 >= r3) goto L11;
            String r6 = r1[r5];
            if (r6 == null) goto L10;
            if (r10.equals(r6) == true) goto L10;
            r2.append(':');
            r2.append(r6);
        L10:
            r5 = r5 + 1;
            goto L3
        L11:
            r0.set(r8, r2.toString());
            Field r4 = SoReflectUtil.findField(r8, "libraryPathElements");
            List r7 = (List) r4.get(r8);
            Iterator r12 = r7.iterator();
        L13:
            if (r12.hasNext() == false) goto L17;
            if (r10.equals((String) r12.next()) == false) goto L13;
            r12.remove();
        L17:
            ListProtector.add(r7, 0, r10);
            r4.set(r8, r7);
        }
    }

    public SoDirInstaller() {
    }

    public static void installNativeLibraryPath(ClassLoader r3, File r4) throws Throwable {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == false) goto L30;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 == 25) goto L9;
    L10:
        if (r0 <= 25) goto L16;
    L23:
        V25.access$000(r3, r4);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.getMessage();
        V23.access$100(r3, r4);
        return;
    L16:
        if (r0 >= 23) goto L25;
        V14.access$200(r3, r4);
        return;
    L25:
        V23.access$100(r3, r4);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        th.getMessage();
        V14.access$200(r3, r4);
        return;
    L9:
        if (Build.VERSION.PREVIEW_SDK_INT != 0) goto L23;
    }
}
