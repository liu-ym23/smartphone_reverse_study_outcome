package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.FileDescriptor;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements GenericSoundPool {
    public final SparseArray<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b> a;
    public HandlerC0038a b;
    public final Handler c;
    public final PThreadPoolExecutor d;
    public final b e;
    public final Queue<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a> f;
    public final Queue<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b> g;
    public final Context h;
    public GenericSoundPool.b i;
    public int j;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.soundpool.a$a, reason: collision with other inner class name */
    public final class HandlerC0038a extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            boolean r1 = true;
            if (r5.what != 1) goto L12;
            GenericSoundPool.b r0 = this.a.i;
            if (r0 == null) goto L13;
            int r2 = r5.arg1;
            if (r5.arg2 == 1) goto L10;
            r1 = false;
        L10:
            String r6 = (String) r5.obj;
            ((com.lynx.clay.embedding.engine.plugins.audio.a.C0036a) r0).a(r2, r1);
            return;
        L13:
            return;
        }

        public HandlerC0038a(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ a a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r4v6, types: [android.os.Handler, com.lynx.clay.embedding.engine.plugins.audio.soundpool.a$a] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            if (this.a.f.isEmpty() == true) goto L5;
        L7:
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0.getPriority() == 5) goto L10;
            ThreadMethodProxy.setPriority(r0, 5);
        L10:
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r1 = (com.lynx.clay.embedding.engine.plugins.audio.soundpool.b) ((LinkedBlockingQueue) this.a.g).poll();
            ?? r2 = 0;
            r2 = 0;
            if (r1 != null) goto L54;
            boolean r3 = false;
        L18:
            if (r3 == true) goto L43;
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a r4 = (com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a) ((LinkedBlockingQueue) this.a.f).poll();
            if (r4 == null) goto L43;
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r5 = this.a.a.get(r4.a);
            String r11 = null;
            if (r5 == null) goto L37;
            Context r6 = this.a.h;     // Catch: Exception -> L34
            if (r4.b == 0) goto L27;
            AssetFileDescriptor r7 = r6.getResources().openRawResourceFd(r4.b);     // Catch: Exception -> L34
            long r8 = r7.getStartOffset();     // Catch: Exception -> L34
            long r9 = r7.getLength();     // Catch: Exception -> L34
            FileDescriptor r10 = r7.getFileDescriptor();     // Catch: Exception -> L34
        L30:
            long r12 = r9;
            long r13 = r8;
            FileDescriptor r14 = r10;
        L32:
            r2 = r5.a(r14, r13, r12);     // Catch: Exception -> L34
            goto L37
        L27:
            r8 = 0;
            if (TextUtils.isEmpty(r4.c) == true) goto L31;
            PolarisFileWrapper r15 = new PolarisFileWrapper(r4.c);     // Catch: Exception -> L34
            ParcelFileDescriptor r16 = ParcelFileDescriptor.open(r15, 268435456);     // Catch: Exception -> L34
            long r17 = r15.length();     // Catch: Exception -> L34
            r10 = r16.getFileDescriptor();     // Catch: Exception -> L34
            r9 = r17;
            goto L30
        L31:
            r12 = 0;
            r13 = 0;
            r14 = null;
        L34:
            e = move-exception;
            e.printStackTrace();
            r11 = e.getMessage();
        L37:
            if (this.a.b == null) goto L43;
            if (r5 == null) goto L43;
            if (r5.r == true) goto L43;
            ?? r18 = this.a.b;
            r18.sendMessage(r18.obtainMessage(1, r4.a, r2, r11));
        L43:
            if (r0.isInterrupted() == false) goto L45;
            return;
        L45:
            if (this.a.g.isEmpty() == true) goto L47;
        L50:
            a r19 = this.a;
            r19.c.post(r19.e);
            return;
        L47:
            if (this.a.f.isEmpty() == false) goto L50;
            ThreadMethodProxy.setPriority(r0, 1);
            return;
        L54:
            r1.close();     // Catch: Exception -> L15
        L17:
            r3 = true;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        L5:
            if (this.a.g.isEmpty() == false) goto L7;
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

        public b(a r1) {
            this.a = r1;
        }
    }

    public static class c implements ThreadFactory {
        public static final AtomicInteger d = null;
        public final ThreadGroup a;
        public final AtomicInteger b;
        public final String c;

        static {
            d = new AtomicInteger(1);
        }

        public c() {
            this.b = new AtomicInteger(1);
            SecurityManager r0 = System.getSecurityManager();
            if (r0 == null) goto L5;
            ThreadGroup r1 = r0.getThreadGroup();
        L6:
            this.a = r1;
            this.c = "pool-" + d.getAndIncrement() + "-thread-sound-";
            return;
        L5:
            r1 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r8) {
            PthreadThreadV2 r6 = new PthreadThreadV2(this.a, r8, this.c + this.b.getAndIncrement(), 0);
            if (r6.isDaemon() == false) goto L6;
            r6.setDaemon(false);
        L6:
            if (r6.getPriority() == 10) goto L8;
            ThreadMethodProxy.setPriority(r6, 10);
        L8:
            return r6;
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void a() {
        int r0 = this.a.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L11;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r1 = this.a.valueAt(r0);
        PThreadPoolExecutor r2 = this.d;
        r1.getClass();
        c5a.c.c("SoundSample", "resume");
        AudioTrack r3 = r1.d;
        if (r3 == null) goto L3;
        if (r3.getPlayState() != 2) goto L3;
        r2.execute(r1.b);
        goto L3
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void f() {
        int r0 = this.a.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        this.a.valueAt(r0).c();
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void release() {
        this.c.removeCallbacksAndMessages(null);
        ThreadMethodProxy.quit(this.c.getLooper());
        ((LinkedBlockingQueue) this.g).clear();
        int r0 = this.a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r3 = this.a.valueAt(r2);     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        r3.h();     // Catch: Exception -> L8
        r3.close();     // Catch: Exception -> L8
    L10:
        r2 = r2 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        this.a.clear();
        ((LinkedBlockingQueue) this.g).clear();
        this.d.shutdown();
        this.j = 0;
    }

    public a(Context r10) {
        this.h = r10;
        this.a = new SparseArray(1);
        PthreadHandlerThreadV2 r11 = new PthreadHandlerThreadV2("SoundLoadWorker", 10);
        ThreadMethodProxy.start(r11);
        this.c = new Handler(r11.getLooper());
        this.d = new PThreadPoolExecutor(4, 8, 2, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c());
        this.e = new b(this);
        this.f = new LinkedBlockingQueue();
        this.g = new LinkedBlockingQueue();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void b(com.lynx.clay.embedding.engine.plugins.audio.a.C0036a r3) {
        this.b = new HandlerC0038a(this, Looper.getMainLooper());
        this.i = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int load(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L8:
        return -1;
    L5:
        if (this.a.size() == 1) goto L8;
        int r0 = this.j + 1;
        this.j = r0;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r1 = new com.lynx.clay.embedding.engine.plugins.audio.soundpool.b();
        this.a.append(r0, r1);
        this.f.add(new com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a(r0, r4));
        this.c.post(this.e);
        return r0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void pause(int r2) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r3 = this.a.get(r2);
        if (r3 == null) goto L6;
        r3.c();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void resume(int r4) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r5 = this.a.get(r4);
        if (r5 == null) goto L11;
        PThreadPoolExecutor r0 = this.d;
        c5a.c.c("SoundSample", "resume");
        AudioTrack r1 = r5.d;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getPlayState() != 2) goto L13;
        r0.execute(r5.b);
        return;
    L13:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void stop(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r3 = this.a.get(r2);
        if (r3 == null) goto L8;
        r3.h();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void c(int r2, int r3) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r4 = this.a.get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.d != null) goto L8;
        return;
    L8:
        if (r3 < (-1)) goto L17;
        if (r3 != (-1)) goto L12;
        int r5 = Integer.MAX_VALUE;
    L13:
        r4.l = r5;
        return;
    L12:
        r5 = r3 + 1;
        goto L13
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void e(int r2, float r3, float r4) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r5 = this.a.get(r2);
        if (r5 == null) goto L6;
        r5.f(r3, r4);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int d(int r6, float r7, float r8, int r9) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r0 = this.a.get(r6);
        if (r0 != null) goto L5;
        return -1;
    L5:
        PThreadPoolExecutor r2 = this.d;
        c5a.c.c("SoundSample", "play");
        AudioTrack r3 = r0.d;
        if (r3 != null) goto L8;
    L25:
        return r6;
    L8:
        if (r3.getPlayState() == 3) goto L25;
        r0.f(r7, r8);
        AudioTrack r10 = r0.d;
        if (r10 == null) goto L16;
        if (r0.q == 1.0f) goto L16;
        r0.q = 1.0f;
        r10.setPlaybackRate((int) (1.0f * r10.getSampleRate()));
    L16:
        if (r0.d == null) goto L24;
        if (r9 < (-1)) goto L24;
        if (r9 != (-1)) goto L22;
        int r11 = Integer.MAX_VALUE;
    L23:
        r0.l = r11;
        goto L24
    L22:
        r11 = r9 + 1;
    L24:
        r2.execute(r0.b);
        goto L25
    }
}
