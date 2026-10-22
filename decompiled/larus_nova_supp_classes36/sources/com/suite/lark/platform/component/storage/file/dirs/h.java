package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final /* synthetic */ int c = 0;
    public final Context a;
    public com.ss.android.lark.vfs.h b;

    public static final class a {
        @JvmStatic
        public static h a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return new h(r1);
        }
    }

    public static final class b {
        public final com.ss.android.lark.vfs.h a;
        public final VFSPath b;
        public final String c;
        public final o6c.c d;
        public boolean e;

        public final VFSPath a() {
            String r0 = this.d.toString();
            VFSPath r1 = this.b.subPath(r0);
            String r2 = this.c;
            if (r2 != null) goto L5;
        L7:
            VFSPath r3 = null;
        L8:
            if (r3 != null) goto L14;
            if (this.a.C() == true) goto L24;
            r1 = this.a.z(r1.getRealPath());
        L24:
            if (this.e == false) goto L26;
            com.suite.lark.component.storage.ext.b.d(r1);
        L29:
            return r1;
        L26:
            VFSPath r4 = r1.getParent();
            if (r4 == null) goto L29;
            com.suite.lark.component.storage.ext.b.d(r4);
            goto L29
        L14:
            if (this.a.C() == false) goto L17;
            com.ss.android.lark.storage.file.migration.c.a r5 = new com.ss.android.lark.storage.file.migration.c.a();
            String r6 = r3.getRealPath();
            Intrinsics.checkNotNullParameter(r6, "path");
            ((ArrayList) r5.b).add(r6);
            String r7 = r1.getRealPath();
            Intrinsics.checkNotNullParameter(r7, "dir");
            r5.c = r7;
            Intrinsics.checkNotNullParameter(r1.toUri(), "uri");
            com.ss.android.lark.storage.file.migration.d.d(r5.a());
            VFSFiles.b.getClass();
            r1 = VFSFiles.b(true).z(r1.getRealPath());
            goto L24
        L17:
            if (this.e == false) goto L20;
        L22:
            r1 = r3;
            goto L24
        L20:
            if (new PolarisFileWrapper(this.b.getRealPath()).exists() == false) goto L22;
            r1 = this.a.z(r1.getRealPath());
            goto L24
        L5:
            if (TextUtils.isEmpty(r2) == true) goto L7;
            VFSFiles.b.getClass();
            r3 = VFSFiles.b(false).z(r2).subPath(r0);
            goto L8
        }

        public final void b(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            this.d.a(r3, false);
            this.e = false;
            return;
        L12:
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "domain");
            this.d.a(r3, false);
        }

        public b(com.ss.android.lark.vfs.h r2, VFSPath r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "vfsFacade");
            Intrinsics.checkNotNullParameter(r3, "newUniPath");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            int r5 = o6c.c.c;
            String r6 = File.separator;
            Intrinsics.checkNotNullParameter(r6, "separator");
            this.d = new o6c.c(r6);
            this.e = true;
        }
    }

    static {
    }

    public h(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = com.ss.android.lark.vfs.d.a();
    }

    public final b a(UniPathProvider r4) {
        VFSPath r0 = r4.d(r4.b());
        String r5 = r4.a(this.a);
        return new b(this.b, r0, r5);
    }

    public final VFSPath b(UniPathProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "pathProvider");
        return a(r2).a();
    }

    public final void c(com.ss.android.lark.vfs.h r2) {
        Intrinsics.checkNotNullParameter(r2, "vfsFacade");
        this.b = r2;
    }
}
