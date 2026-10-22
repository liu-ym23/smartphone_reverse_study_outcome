package zkb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.image.uploader.utils.c;
import com.suite.lark.platform.component.storage.file.dirs.f;
import com.suite.lark.platform.component.storage.file.dirs.h;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final a a = null;
    public static final HashMap<String, Integer> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new HashMap();
    }

    public final synchronized String b(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "filePath");     // Catch: Throwable -> L9
        HashMap<String, Integer> r0 = b;     // Catch: Throwable -> L9
        Integer r1 = r0.get(r7);     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
        r1 = 0;     // Catch: Throwable -> L9
    L6:
        r0.put(r7, Integer.valueOf(r1.intValue() + 1));     // Catch: Throwable -> L9
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L9
        String r8 = String.format("%s_%s", Arrays.copyOf(new Object[]{r7, r1}, 2));     // Catch: Throwable -> L9
        monitor-exit(this);
        return r8;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(String r7, String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "tempPath");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r8, "path");     // Catch: Throwable -> L7
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L7
        boolean r9 = new PolarisFileWrapper(r7).renameTo(new PolarisFileWrapper(r8));     // Catch: Throwable -> L7
        int r10 = c.a;     // Catch: Throwable -> L7
        c.a("CacheManager", "rename time cost: " + (System.currentTimeMillis() - r1));     // Catch: Throwable -> L7
        monitor-exit(this);
        return r9;
    L7:
        th = move-exception;
        throw th;
    }

    public static String a(Context r4, String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "filePath");
        int r0 = h.c;
        String r8 = h.a.a(r4).b(new f()).getRealPath();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r5);
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r10 = String.format("%s_%s_%s", Arrays.copyOf(new Object[]{r1.getPath(), Long.valueOf(r1.length()), Long.valueOf(r1.lastModified())}, 3));
        String r2 = s.b(r10);
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = String.valueOf(Objects.hashCode(r10));
    L6:
        return r8 + File.separator + r2 + '_' + r6 + '_' + r7;
    }
}
