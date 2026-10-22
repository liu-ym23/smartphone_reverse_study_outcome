package com.ss.android.lark.featuregating;

import com.larksuite.framework.utils.FileUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Deprecated(message = "replace with FlashFG")
public final class FileFgCenter {
    public static final String[] c = null;
    public static final FileFgCenter d = null;
    public final ConcurrentHashMap<String, c> a;
    public final Lazy b;

    public static final class a {
    }

    public interface b {
    }

    public static final class c {
        public final String a;
        public Boolean b;
        public final b c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Boolean r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "KeyBean(markFile=" + this.a + ", isEnable=" + this.b + ", keyChecker=" + this.c + ')';
        }

        public c(String r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "markFile");
            Intrinsics.checkNotNullParameter(r3, "keyChecker");
            this.a = r2;
            this.b = null;
            this.c = r3;
        }
    }

    public static final class d implements b {
        public d() {
        }
    }

    static {
        c = new String[]{"privacy_detection_dynamic", "render_svg_image"};
        d = new FileFgCenter();
    }

    public FileFgCenter() {
        this.a = new ConcurrentHashMap();
        this.b = LazyKt.lazy(new FileFgCenter$mFileDir$2(this));
        d r0 = new d();
        String[] r1 = c;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        String r4 = r1[r3];
        Intrinsics.checkNotNullParameter(r4, "featureName");
        Intrinsics.checkNotNullParameter(r0, "keyChecker");
        this.a.put(r4, new c(((String) this.b.getValue()) + File.separator + r4, r0));
        r3 = r3 + 1;
        goto L3
    }

    public final synchronized boolean a(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "keyName");     // Catch: Throwable -> L12
        c r0 = this.a.get(r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
        boolean r4 = FileUtils.r(((String) this.b.getValue()) + File.separator + r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r4;
    L7:
        if (r0.b != null) goto L9;
        r0.b = Boolean.valueOf(FileUtils.r(r0.a));     // Catch: Throwable -> L12
    L9:
        r4 = Intrinsics.areEqual(r0.b, Boolean.TRUE);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
