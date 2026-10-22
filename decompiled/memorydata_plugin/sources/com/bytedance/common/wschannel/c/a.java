package com.bytedance.common.wschannel.c;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2009a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f2010b;
    private static File c;

    static {
    }

    public a() {
    }

    public static synchronized File a(Context r5) {
        monitor-enter(a.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        File r1 = f2010b;     // Catch: Throwable -> L20
        if (r1 == null) goto L23;
        monitor-exit(a.class);
        return r1;
    L23:
        File r2 = new File(b(r6), c.b(r6).replace(".", "_").replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "-") + "_frontier.bin");     // Catch: Exception -> L15 Throwable -> L20
        if (r2.exists() == true) goto L11;
        r2.createNewFile();     // Catch: Exception -> L15 Throwable -> L20
    L11:
        f2010b = r2;     // Catch: Exception -> L15 Throwable -> L20
        if (Logger.debug() == false) goto L17;
        Logger.d(f2009a, "prepare PersistentFile success. fileName=" + f2010b);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        File r7 = f2010b;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return r7;
    L15:
        e = move-exception;
        Logger.e(f2009a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private static File b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        File r0 = c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = new File(r3.getFilesDir(), "wschannel");
        c = r1;
        if (r1.exists() == true) goto L9;
        c.mkdirs();
    L9:
        return c;
    }
}
