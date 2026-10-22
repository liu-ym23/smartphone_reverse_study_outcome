package com.ss.android.lark.framework.assembly.diskmanage;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitRemoteCleanTask extends AsyncLaunchTask {
    public final int c() {
        return 20;
    }

    public InitRemoteCleanTask() {
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.ss.android.lark.framework.assembly.diskmanage.DiskManageProvider$performRemoteClean$1, java.lang.Object] */
    public final void a(Context r15) {
        AtomicBoolean r0 = c.a;
        c.b.a.getClass();
        if (c.a.get() == true) goto L5;
        c.a();
    L5:
        cbb.d r1 = c.b();
        if (o0.a(LarkContext.getApplication()) == false) goto L8;
        final String r2 = "key_disk_main_remote_clean_date";
    L9:
        Log.i("DiskManageProvider", "try perform remote clean");
        final long r3 = System.currentTimeMillis();
        long r5 = r1.a.a * ((long) AudioViewModel.ASR_SESSION_IDLE);
        long r10 = eac.a.a().getLong(r2, 0);
        if (r10 != 0) goto L13;
        eac.a.a().putLong(r2, r3);
        Log.i("DiskManageProvider", "first launch, clean skipped");
    L16:
        if (eac.a.a().getBoolean("has_deleted_old_cache_file", false) == true) goto L23;
        eac.a.a().putBoolean("has_deleted_old_cache_file", true);
        ArrayList r4 = new ArrayList();
        r4.add(new PolarisFileWrapper(l.b(r15) + "/log/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/crashLog/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/nativeCrash/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/zip/"));
        r4.add(new PolarisFileWrapper(l.a(r15) + "/rich_text/"));
        r4.add(new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.k(r15) + "/docs/"));
        r4.add(new PolarisFileWrapper(l.a(r15) + "/video_thumb_cache/"));
        r4.add(new PolarisFileWrapper(l.c(r15) + "/so_decompressed/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/picture/rust/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/MediaCover/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/download/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/audio/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/update/"));
        r4.add(new PolarisFileWrapper(l.c(r15) + "/zip/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/share_temp/"));
        r4.add(new PolarisFileWrapper(l.b(r15) + "/span"));
        Iterator r16 = r4.iterator();
    L19:
        if (r16.hasNext() == false) goto L29;
        File r6 = (File) r16.next();
        if (r6.exists() == false) goto L19;
        fbb.a.a(r6);
        goto L19
    L29:
        return;
    L23:
        return;
    L13:
        if ((Math.abs(r3 - r10) - r5) <= 0) goto L16;
        Log.i("DiskManageProvider", "startRemoteClean, key: " + r2 + ", lastTime: " + r10);
        int r7 = ebb.b.c;
        ebb.b r8 = ebb.b.b.a;
        ?? r9 = new DiskManageProvider$performRemoteClean$1(r2, r3);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "remoteConfig");
        Intrinsics.checkNotNullParameter(r9, "callback");
        r8.b.execute(new ebb.c(r8, r1, r9));
        goto L16
    L8:
        r2 = "";
        goto L9
    }
}
