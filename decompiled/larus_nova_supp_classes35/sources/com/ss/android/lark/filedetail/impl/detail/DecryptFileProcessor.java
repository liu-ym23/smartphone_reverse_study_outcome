package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.DecryptFileRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DecryptFileProcessor {
    public static final Lazy<DecryptFileProcessor> e = null;
    public final ExecutorService a;
    public final ReentrantReadWriteLock b;
    public final ConcurrentHashMap<String, String> c;
    public String d;

    public static final class a {
    }

    public interface b {
        void a(String r1);

        void b(String r1);

        void c();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ b d;
        public final /* synthetic */ DecryptFileProcessor e;

        public c(String r1, String r2, String r3, b r4, DecryptFileProcessor r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            String r0 = this.a + File.separator + System.currentTimeMillis() + "_decrypt_" + this.b;
            String r1 = this.c;
            Intrinsics.checkNotNullParameter(r1, "originPath");
            Intrinsics.checkNotNullParameter(r0, "targetPath");
            SdkSender.d r2 = SdkSender.syncSendMayError(Command.DECRYPT_FILE, new DecryptFileRequest.Builder().src_path(r1).dst_path(r0), g.a);
            if (r2.b == null) goto L8;
            Log.i("DecryptFileProcessor", "decrypt file failed origin path: " + this.c);
            b r3 = this.d;
            if (r3 == null) goto L26;
            r3.a(r2.b.getDisplayMsg());
            return;
        L26:
            return;
        L8:
            if (((Boolean) r2.a).booleanValue() == false) goto L17;
            Log.i("DecryptFileProcessor", "decrypt file success");
            if (sfb.c.b().i(r0).exists() == false) goto L14;
            this.e.c.put(this.c, r0);
            Log.i("DecryptFileProcessor", "decrypt file success origin path: " + this.c);
            b r4 = this.d;
            if (r4 == null) goto L28;
            r4.b(r0);
            return;
        L28:
            return;
        L14:
            Log.i("DecryptFileProcessor", "decrypt file failed file create failed");
            b r5 = this.d;
            if (r5 == null) goto L30;
            r5.a("create file failed");
            return;
        L30:
            return;
        L17:
            Log.i("DecryptFileProcessor", "origin file is not encrypted");
            if (sfb.c.b().i(this.c).exists() == false) goto L22;
            Log.i("DecryptFileProcessor", "non encrypted file success origin path: " + this.c);
            b r6 = this.d;
            if (r6 == null) goto L32;
            r6.b(this.c);
            return;
        L32:
            return;
        L22:
            Log.i("DecryptFileProcessor", "non encrypted file not exist");
            b r7 = this.d;
            if (r7 == null) goto L34;
            r7.a("origin file not exist");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DecryptFileProcessor$Companion$INSTANCE$2.INSTANCE);
    }

    public DecryptFileProcessor() {
        this.a = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-file-decrypt"));
        this.b = new ReentrantReadWriteLock();
        this.c = new ConcurrentHashMap();
    }

    public static String b(Context r3) {
        VFSFile r4 = sfb.c.b().i(com.larksuite.framework.utils.l.c(r3) + File.separator + "rust_decrypt");
        if (r4.exists() == false) goto L15;
        Log.d("DecryptFileProcessor", "find decrypt folder " + r4.getPath());
        return r4.getPath();
    L15:
    L11:
        e = move-exception;
        Log.e("DecryptFileProcessor", "mk decrypt dir failed! " + e.getMessage());
    L13:
        return null;
    L7:
        if (r4.mkdirs() == false) goto L9;
        Log.d("DecryptFileProcessor", "mk decrypt folder success " + r4.getPath());     // Catch: Exception -> L11
        return r4.getPath();
    L9:
        Log.e("DecryptFileProcessor", "mk decrypt dir failed!");     // Catch: Exception -> L11
        goto L13
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "currentPath");
        this.b.writeLock().lock();     // Catch: Throwable -> L6
        this.d = r2;     // Catch: Throwable -> L6
        this.b.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.b.writeLock().unlock();
        throw th;
    }

    public final void a(Context r9, String r10, String r11, b r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "originPath");
        Intrinsics.checkNotNullParameter(r11, "originName");
        this.b.writeLock().lock();     // Catch: Throwable -> L8
        r12.c();     // Catch: Throwable -> L8
        Log.i("DecryptFileProcessor", "decrypt File start origin path: " + r10);     // Catch: Throwable -> L8
        String r3 = b(r9);     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        this.a.execute(new c(r3, r11, r10, r12, this));     // Catch: Throwable -> L8
    L6:
        this.b.writeLock().unlock();
        return;
    L8:
        th = move-exception;
        this.b.writeLock().unlock();
        throw th;
    }
}
