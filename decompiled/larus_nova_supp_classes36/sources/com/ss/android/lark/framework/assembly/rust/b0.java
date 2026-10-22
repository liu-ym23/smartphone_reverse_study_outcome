package com.ss.android.lark.framework.assembly.rust;

import android.text.TextUtils;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.component.protocol.Biz;
import java.nio.charset.StandardCharsets;
import kotlin.io.FilesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 {

    public static class a {
        public static final b0 a = null;

        static {
            a = new b0();
        }
    }

    public static String b() {
        com.ss.android.lark.storage.kv.repo.a r0 = LarkKVStorage.j(Biz.Infra, true);
        if (com.ss.android.lark.featuregating.b.b(LarkContext.getApplication()).a("improve.safe.score.rust") == false) goto L7;
        String r1 = r0.getString(TrafficMetrics.FROM_RUST, "");
        if (TextUtils.isEmpty(r1) == false) goto L15;
        String r2 = l0.a().toString();
        r0.putString(TrafficMetrics.FROM_RUST, r2);
        int r3 = o6c.d.a;
        Log.i("SdkKeyStore", "generated new key, delete:" + FilesKt.deleteRecursively(VFSFiles.b.i(o6c.d.a(LarkContext.getApplication()))));
        return r2;
    L15:
        return r1;
    L7:
        String r4 = eac.a.a().getString(TrafficMetrics.FROM_RUST);
        if (TextUtils.isEmpty(r4) == false) goto L13;
        r4 = r0.getString(TrafficMetrics.FROM_RUST, "");
        if (TextUtils.isEmpty(r4) == false) goto L12;
        r4 = l0.a().toString();
        eac.a.a().putString(TrafficMetrics.FROM_RUST, r4);
        r0.putString(TrafficMetrics.FROM_RUST, r4);
        int r5 = o6c.d.a;
        Log.i("SdkKeyStore", "generated new key, delete:" + FilesKt.deleteRecursively(VFSFiles.b.i(o6c.d.a(LarkContext.getApplication()))));
        goto L13
    L12:
        eac.a.a().putString(TrafficMetrics.FROM_RUST, r4);
    L13:
        r0.putString(TrafficMetrics.FROM_RUST, r4);
        return r4;
    }

    public final synchronized byte[] a() {
        monitor-enter(this);
        String r1 = b().substring(0, 32);     // Catch: Throwable -> L7
        Log.d("SdkKeyStore", "rust encrypt key = " + r1);     // Catch: Throwable -> L7
        byte[] r0 = r1.getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public b0() {
    }
}
