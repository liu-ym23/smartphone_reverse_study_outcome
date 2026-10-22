package z0c;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.ss.ttvideoengine.TTVideoEngine;
import com.suite.lark.platform.component.storage.file.dirs.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static String a;

    static {
        a = "";
    }

    @JvmStatic
    public static final String b() {
        VFSFiles.b.getClass();
        h r0 = VFSFiles.b(true);
        int r1 = com.suite.lark.platform.component.storage.file.dirs.h.c;
        com.suite.lark.platform.component.storage.file.dirs.h r2 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(LarkContext.getApplication());
        r2.c(r0);
        String r3 = r2.b(new m()).getRealPath();
        FileUtils.t(r3);
        return r3;
    }

    @JvmStatic
    public static final void a() {
        String r0 = b();
        Log.i("LarkPlayerCache", "lastPath:" + a + ", newPath:" + r0);
        if (a.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L9:
        a = r0;
        Log.i("LarkPlayerCache", "configDynamicDir start:" + r0);
        TTVideoEngine.cancelAllPreloadTasks();
        TTVideoEngine.setStringValue(0, r0);
        TTVideoEngine.setStringValueSync(2030, r0);
        return;
    L8:
        if (Intrinsics.areEqual(a, r0) == false) goto L9;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
